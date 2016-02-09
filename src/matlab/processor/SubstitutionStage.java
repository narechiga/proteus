/**
 * @author Anuradha Vakil
 * @author Nikos Arechiga
 * Toyota InfoTechnology Center, USA
 * 465 N Bernardo Ave, Mountain View, CA 94043
 * 
 * 
 * This class does the following:
 * 1. breaks the if-else block into individual blocks with condition (if it exists) and assignments/logic in that block
 * 2. Checks for post if-else assignment 
 * 3. if any then stores them in order
 * 4. appends to each if-ele block individually
 * 5. gets any assignment statements at the beginning (before if-else blcok)
 * 
 * 
 */


 
package matlab.processor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.beans.finder.FieldFinder;
import com.sun.corba.se.spi.servicecontext.UnknownServiceContext;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import dl.syntax.RealVariable;
import dl.syntax.Replacement;
import dl.syntax.Term;
import dl.syntax.dLFormula;
import interfaces.text.TextOutput;
import matlab.syntax.*;
import sun.org.mozilla.javascript.internal.ast.Assignment;
import sun.text.normalizer.ReplaceableString;

public class SubstitutionStage {

	//check for more than one assignment features at the end of if statement
	public static void main(String[] arg){

		// uncomment below to check if-else if-else and more than one assignment statements at the end	
		//	  MatlabProgram mp = new MatlabProgram (" k1 = 5; k2 = 7*k1; if ( x > k1*6) y = k2*x; elseif (n==0) y = k1*x;else k2 = 100; end z = x^2 + k2*y^2;p=0;");
		TextOutput.setDebug( true ); TextOutput.useColor( false );
		MatlabProgram mp = new MatlabProgram (" k1 = 5; k2 = 7*k1; if ( x > k1*6) y = k2*x; else y = k1*x; k2 = 100; end z = x^2 + k2*y^2;p=0;");
		List<RealVariable> inputs = new ArrayList<>();
		List<RealVariable> outputs = new ArrayList<>();
		inputs.add( new RealVariable("x"));
		outputs.add(new RealVariable("y")); outputs.add( new RealVariable ("z") ); outputs.add(new RealVariable("k2"));
		mp = mergePostAssignments( mp );
		mp = mergePreAssignments( mp, inputs, outputs );

		TextOutput.info(mp.toString());
	}
	//TODO: all terms in form of inputs and outputs; simplify the data structures
	public static MatlabProgram mergePostAssignments( MatlabProgram mp ) {
		List<Statement> matlabStatements = mp.getStatements();
		
		Stack<Statement> postAssignments = new Stack<>();
		while ( !(mp.peekLastStatement() instanceof IfStatement ) ) {
			postAssignments.push( mp.consumeLastStatement() );
		}
		List<Statement> postAssignmentList = new ArrayList<>();
		while ( !(postAssignments.isEmpty() )) {
			postAssignmentList.add(postAssignments.pop());
		}
		IfStatement ifStatement = ((IfStatement)mp.consumeLastStatement());
		for ( MatlabProgram ifCase : ifStatement.getPrograms() ) {
			ifCase.append(postAssignmentList);
		}
		mp.append( ifStatement );
		TextOutput.debug( "== Merged Post Assignments ==========================");
		TextOutput.debug( mp.toString() );
		TextOutput.debug("======================================================");
		return mp;
	}


	public static MatlabProgram mergePreAssignments( MatlabProgram newMatlabProgram,
														List<RealVariable> inputs,
														List<RealVariable> outputs ){
		
		while( newMatlabProgram.peekFirstStatement() instanceof AssignmentStatement ) {
			AssignmentStatement assignment = (AssignmentStatement) newMatlabProgram.peekFirstStatement();
			
			//if ( !outputs.contains( assignment.getLHS() ) ) {
			if ( true ) {
				newMatlabProgram.consumeFirstStatement();
			}
			
		//	TextOutput.debug("MatlabProgram: "+ newMatlabProgram.getStatements().toString()+" Assignment: "+assignment );
			newMatlabProgram = replaceWithAssignment( newMatlabProgram, assignment);
		}
		//TextOutput.info(newMatlabProgram.toString());
		return newMatlabProgram;

	}

	public static MatlabProgram replaceWithAssignment( MatlabProgram program, AssignmentStatement assignment ) {
		
		AssignmentStatement sReplaced;
		Replacement replacement = new Replacement((RealVariable)assignment.getLHS(), assignment.getRHS());

		MatlabProgram result = new MatlabProgram();
		for ( Statement s : program.getStatements() ) {
			
			if ( s instanceof IfStatement) {
				// First, the conditions
				List<dLFormula> conditions = ((IfStatement)s).getConditions();
				List<MatlabProgram> programs = ((IfStatement)s).getPrograms();
				List<dLFormula> newConditions = new ArrayList<>();
				List<MatlabProgram> newPrograms = new ArrayList<>();
				//	TextOutput.debug("Replacement is: (" + replace.toMathematicaString() +")");
				for ( dLFormula condition : conditions ) {
					newConditions.add( condition.replace( replacement ) );
				}

				for ( MatlabProgram thisProgram : programs ) {
					//	TextOutput.debug("This program is: " + thisProgram.toString() );
					newPrograms.add( replaceWithAssignment( thisProgram, assignment ) );
				}

				result.append( new IfStatement( newConditions, newPrograms ) );

			} else if ( s instanceof AssignmentStatement ) {
				RealVariable sLHS = (RealVariable)((AssignmentStatement)s).getLHS();
				Term sRHS = ((AssignmentStatement)s).getRHS();
				if ( sLHS.equals( assignment.getLHS() )) {
					sReplaced = new AssignmentStatement( sLHS , sRHS.replace( replacement ) );
					replacement = new Replacement( sLHS, sRHS.replace(replacement) );
				} else {
					sReplaced = new AssignmentStatement( sLHS , sRHS.replace( replacement ) );
				}
				result.append( sReplaced );
			}

		}
		//TextOutput.debug( result.toString() );

		return result;


	}
}