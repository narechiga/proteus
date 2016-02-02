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
import matlab.syntax.*;
import matlab.syntax.Statement;

public class SubstitutionStage {
	
	//stack to store the Statements
	static Stack<Statement> assignmentStatementsStack = new Stack<>();
	static Stack<Statement> initialAssignemntStatementStack = new Stack<>();
	static MatlabProgram newMatlabProgram ;
	static List<Statement> newStatements; 	//list to store the updated if-else block statements
	
	
	//check for more than one assignment features at the end of if statement
	public static void main(String[] arg){
	
	// uncomment below to check if-else if-else and more than one assignment statements at the end	
	//  MatlabProgram mp = new MatlabProgram (" k1 = 5; k2 = 7*k1; if ( x > k1*6) y = k2*x; elseif (n==0) y = k1*x;else k2 = 100; end z = x^2 + k2*y^2;p=0;");
		
		MatlabProgram mp = new MatlabProgram (" k1 = 5; k2 = 7*k1; if ( x > k1*6) y = k2*x; else y = k1*x;k2 = 100; end z = x^2 + k2*y^2;p=0;");
		System.out.println(mp.getStatements());
		List<Statement> matlabStatements = mp.getStatements();
		MatlabProgram appended = appendPostAssignment( matlabStatements );
		System.out.println("processed Program is:"+ appended.getStatements());
		getInitialParameters(matlabStatements);
		findAndReplace();
	}
	
	
	public static Statement getPostIfStatement( List<Statement> matlabStatements ){
		Statement lastStatement = matlabStatements.get(matlabStatements.size()-1);
		return lastStatement;
	}
	
	public static Statement getPreIfStatement( List<Statement> statement, int index ){
		Statement preAssignmentStatement = statement.get(index);
		return preAssignmentStatement;
	}
	
	
	public static MatlabProgram appendPostAssignment( List<Statement> matlabStatements){
			
		System.out.println("In append...");
			
		Statement lastStatement = getPostIfStatement(matlabStatements);
		int index = matlabStatements.size();
		
		//store all the assignment statements POST IFSTATEMENT
		while( !(lastStatement instanceof IfStatement) ){
			index--;
			assignmentStatementsStack.push(lastStatement);
			lastStatement = getPostIfStatement(matlabStatements.subList(0, index));
		}
		
		IfStatement ifStatement = ((IfStatement)lastStatement);
		while ( !assignmentStatementsStack.isEmpty() ) {
			ifStatement.appendStatementToAllCases( assignmentStatementsStack.pop() );
		}
		newStatements = new ArrayList<>();
		newStatements.addAll( matlabStatements.subList(0, index));
		System.out.println("New Statements: "+newStatements);
		return new MatlabProgram( newStatements );
}
	
	public static String[] getassignmentStatementsStack(){
		String[] aS = new String[assignmentStatementsStack.size()];
		int size = assignmentStatementsStack.size();
		int i = 0;
		while( i<size){
			aS[i]=  assignmentStatementsStack.pop().toString();
	//		System.out.println("Assignment statement "+aS);
			i++;
		}
		return aS;
	} 
	
	//updated if-else block 
	public static String getUpdatedIFBlock(){
		String[] assignmentsToAdd = getassignmentStatementsStack();
		String result = assignmentsToAdd[0];
		System.out.println("result"+result);
		for ( int i = 1; i<assignmentsToAdd.length; i++ ){
			result = result + assignmentsToAdd[i];
		}
		System.out.println(result);
		return result;
	}
	
	//gets the parameters defined/initialized at the beginning; doesnot get any new parameters if defined in if clause or after if.
	public static void getInitialParameters( List<Statement> matlabStatements ){
		Statement preAssignment = getPreIfStatement(matlabStatements, 0);
		int index = 0;
		
		//store all the assignment statements PRE IFSTATEMENT
		while( !(preAssignment instanceof IfStatement) ){
			initialAssignemntStatementStack.push(preAssignment);
			index++;
			preAssignment = getPreIfStatement( matlabStatements, index);
			
		}
		System.out.println( "pre assignment: "+initialAssignemntStatementStack );
	}
	
	public static void findAndReplace(){
		System.out.println("Number of Pre-IF block assignments is: "+initialAssignemntStatementStack.size());
		int index = 0;
		
		newMatlabProgram = new MatlabProgram( initialAssignemntStatementStack );			//creating new Matlab program withupdated if else block
		while( index < initialAssignemntStatementStack.size()){
			Statement assignment = initialAssignemntStatementStack.elementAt(index);
			System.out.println("findAndReplace assignment: "+assignment);
			index++;
			
			replaceWithAssignment(assignment);
			
		}
	}
	
	public static void replaceWithAssignment( Statement assignment ){
		
		
		String[] sides = assignment.toString().split( "=" );
		RealVariable LHS = new RealVariable( sides[0] );
		Term RHS = new Term();
		RHS.setArgument(0, RHS);
		Replacement replace = new Replacement(LHS, RHS);
		Iterator<Statement> iterator = newStatements.iterator();
	//	System.out.println("Found LHS "+ LHS);
		while( iterator.hasNext() ){
			Statement underInvestigation = iterator.next();
			if( underInvestigation instanceof Statement && !underInvestigation.equals(assignment))
				
				System.out.println("Found LHS "+underInvestigation);
//				underInvestigation.replaceAll(LHS.toString(), RHS.toString());
//				System.out.println("output "+underInvestigation);
//			}
		}
		
		
	
		
		
	//	System.out.println( "subjectToAssignment"+ subjectToAssignment);
	//	for ( int i = 0; i<subjectToAssignment.length(); i++){
	//		System.out.println("Number of "+LHS+" present:"+subjectToAssignment.contains(LHS.toString()));
	//	}
		
	}

}
