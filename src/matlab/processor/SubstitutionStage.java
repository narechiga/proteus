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
import sun.text.normalizer.ReplaceableString;

public class SubstitutionStage {
	
	//stack to store the Statements
	static Stack<Statement> assignmentStatementsStack = new Stack<>();
//	static Stack<Statement> initialAssignmentStatementStack = new Stack<>();
	static MatlabProgram newMatlabProgram ;
	static List<Statement> newStatements; 	//list to store the updated if-else block statements
	
	
	//check for more than one assignment features at the end of if statement
	public static void main(String[] arg){
	
	// uncomment below to check if-else if-else and more than one assignment statements at the end	
	//  MatlabProgram mp = new MatlabProgram (" k1 = 5; k2 = 7*k1; if ( x > k1*6) y = k2*x; elseif (n==0) y = k1*x;else k2 = 100; end z = x^2 + k2*y^2;p=0;");
		TextOutput.setDebug( true ); TextOutput.useColor( false );
		MatlabProgram mp = new MatlabProgram (" k1 = 5; k2 = 7*k1; if ( x > k1*6) y = k2*x; else y = k1*x;k2 = 100; end z = x^2 + k2*y^2;p=0;");
	//	System.out.println(mp.getStatements());
		List<Statement> matlabStatements = mp.getStatements();
		MatlabProgram appended = appendPostAssignment( matlabStatements );
//		System.out.println("processed Program is:"+ appended.getStatements());
		List<Statement> initialAssignments = getInitialParameters(appended.getStatements());
		System.out.println("Initial Assignment:--- "+ initialAssignments);
		findAndReplace();
		
		TextOutput.info("================================================");
		TextOutput.info(newMatlabProgram.toString());
	}
	
	
	public static Statement getPostIfStatement( List<Statement> matlabStatements ){
		Statement lastStatement = matlabStatements.get(matlabStatements.size()-1);
		return lastStatement;
	}
	
	public static Statement getPreIfStatement( List<Statement> statement, int index ){
		Statement preAssignmentStatement = statement.get(index);
		return preAssignmentStatement;
	}
	
//TODO: try to get rid of stack	
	public static MatlabProgram appendPostAssignment( List<Statement> matlabStatements){
			
		System.out.println("In append...");
		List<Statement> postAssignmentStatement = new ArrayList<>();
		Statement lastStatement = getPostIfStatement(matlabStatements);
	//	int index = 1;
		int index = matlabStatements.size();
	
		//store all the assignment statements POST IFSTATEMENT
		while( !(lastStatement instanceof IfStatement) ){
			index--;
			assignmentStatementsStack.push(lastStatement);
			lastStatement = getPostIfStatement(matlabStatements.subList(0, index));
		}
		
//		postAssignmentStatement.add(  getPostIfStatement(matlabStatements) );
	//	while( !(postAssignmentStatement.get(index) instanceof IfStatement) ){
		
//	assignmentStatementsStack.push(lastStatement);
//		lastStatement = getPostIfStatement(matlabStatements.subList(0, index));
//		Statement s = getPostIfStatement(matlabStatements.subList(0,index));
//		postAssignmentStatement.add(s);
//		index++;
//	}
		IfStatement ifStatement = ((IfStatement)lastStatement);
	//	Iterator postAssignmentIterator = postAssignmentStatement.iterator();
	//	while ( postAssignmentIterator.hasNext() ){
		while ( !assignmentStatementsStack.isEmpty() ) {
			ifStatement.appendStatementToAllCases( assignmentStatementsStack.pop() );
			
		}
		newStatements = new ArrayList<>();
		newStatements.addAll( matlabStatements.subList(0, index));
	//	System.out.println("New Statements: "+newStatements);
		return new MatlabProgram( newStatements );
}
	
//	public static String[] getassignmentStatementsStack(){
//		String[] aS = new String[assignmentStatementsStack.size()];
//		int size = assignmentStatementsStack.size();
//		int i = 0;
//		while( i<size){
//			aS[i]=  assignmentStatementsStack.pop().toString();
//	//		System.out.println("Assignment statement "+aS);
//			i++;
//		}
//		return aS;
//	} 
	
	//updated if-else block 
//	public static String getUpdatedIFBlock(){
//		String[] assignmentsToAdd = getassignmentStatementsStack();
//		String result = assignmentsToAdd[0];
//		System.out.println("result"+result);
//		for ( int i = 1; i<assignmentsToAdd.length; i++ ){
//			result = result + assignmentsToAdd[i];
//		}
//		System.out.println(result);
//		return result;
//	}
	
	//gets the parameters defined/initialized at the beginning; doesnot get any new parameters if defined in if clause or after if.
	public static List<Statement> getInitialParameters( List<Statement> matlabStatements ){
		Statement preAssignment = getPreIfStatement(matlabStatements, 0);
		int index = 0;
		List<Statement> preIfAssignments = new ArrayList<>();
		//store all the assignment statements PRE IFSTATEMENT
		while( !(preAssignment instanceof IfStatement) ){
	//		initialAssignmentStatementStack.push(preAssignment);
			index++;
			preAssignment = getPreIfStatement( matlabStatements, index);
			preIfAssignments.add(preAssignment);
		}
	//	System.out.println( "pre assignment: "+initialAssignmentStatementStack );
		return preIfAssignments;
	}
	
	public static void findAndReplace(){
//		System.out.println("Number of Pre-IF block assignments is: "+initialAssignmentStatementStack.size());
		int index = 0;
		
		newMatlabProgram = new MatlabProgram( newStatements );			//creating new Matlab program withupdated if else block
		while( newMatlabProgram.peekFirstStatement() instanceof AssignmentStatement ) {
			AssignmentStatement assignment = (AssignmentStatement) newMatlabProgram.consumeFirstStatement();
			System.out.println("findAndReplace assignment: "+assignment);
			index++;
			
			newMatlabProgram = replaceWithAssignment( newMatlabProgram, assignment);
			
		}
	}
	
	public static MatlabProgram replaceWithAssignment( MatlabProgram program, AssignmentStatement assignment ) {
		
		System.out.println("Found assignment "+ assignment );
	
		Replacement replace = new Replacement((RealVariable)assignment.getLHS(), assignment.getRHS());
		
		
		Iterator<Statement> iterator = program.getStatements().iterator();
		MatlabProgram result = new MatlabProgram();
		AssignmentStatement sReplaced;
		while( iterator.hasNext() ){
			Statement s = iterator.next();
			System.out.println("s "+s);
			if ( s instanceof IfStatement) {
				// First, the conditions
				List<dLFormula> conditions = ((IfStatement)s).getConditions();
				List<MatlabProgram> programs = ((IfStatement)s).getPrograms();
				List<dLFormula> newConditions = new ArrayList<>();
				List<MatlabProgram> newPrograms = new ArrayList<>();
				TextOutput.debug("Replacement is: (" + replace.toMathematicaString() +")");
				for ( dLFormula condition : conditions ) {
					newConditions.add( condition.replace( replace ) );
				}
				
				for ( MatlabProgram thisProgram : programs ) {
					TextOutput.debug("This program is: " + thisProgram.toString() );
					newPrograms.add( replaceWithAssignment( thisProgram, assignment ) );
				}
				
				result.append( new IfStatement( newConditions, newPrograms ) );

			}else if ( s instanceof AssignmentStatement ) {
				RealVariable sLHS = (RealVariable)((AssignmentStatement)s).getLHS();
				Term sRHS = ((AssignmentStatement)s).getRHS();
				if ( sLHS.equals( assignment.getLHS() )) {
					sReplaced = new AssignmentStatement( sLHS , sRHS.replace( replace ) );
					replace = new Replacement( sLHS, sRHS.replace(replace) );
				} else {
					sReplaced = new AssignmentStatement( sLHS , sRHS.replace( replace ) );
				}
				result.append( sReplaced );
			}
			
		}
		TextOutput.debug( result.toString() );
		return result;

		
	}

}
