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
	static Stack<String> ifStatmentStack = new Stack<>();
	static MatlabProgram newMatlabProgram ;
	static String finalIfString;
	
	
	//check for more than one assignment features at the end of if statement
	public static void main(String[] arg){
	
	// uncomment below to check if-else if-else and more than one assignment statements at the end	
	//  MatlabProgram mp = new MatlabProgram (" k1 = 5; k2 = 7*k1; if ( x > k1*6) y = k2*x; elseif (n==0) y = k1*x;else k2 = 100; end z = x^2 + k2*y^2;p=0;");
		
		MatlabProgram mp = new MatlabProgram (" k1 = 5; k2 = 7*k1; if ( x > k1*6) y = k2*x; else y = k1*x;k2 = 100; end z = x^2 + k2*y^2;p=0;");
		System.out.println(mp.getStatements());
		List<Statement> matlabStatements = mp.getStatements();
		MatlabProgram appended = appendPostAssignment( matlabStatements );
		System.out.println("processed Program is:"+ appended.getStatements());
//		getInitialParameters(matlabStatements);
//		System.out.println("parameters at	beginning"+initialAssignemntStatementStack);
//		findAndReplace();
	}
	
	
	public static Statement getPostIfStatement( List<Statement> matlabStatements ){
		Statement lastStatement = matlabStatements.get(matlabStatements.size()-1);
		return lastStatement;
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
		List<Statement> newStatements = new ArrayList<>();
		newStatements.addAll( matlabStatements.subList(0, index));
		//newStatements.add( ifStatement );
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
	
	public static String[] getIfStatementsStack(){

		String[] ifs = new String[ifStatmentStack.size()];
		int size = ifStatmentStack.size();
		
		int i = 0;
		while( i<size){
			ifs[i]=  ifStatmentStack.pop().toString();
			i++;
		}
		return ifs;
	} 
	
	//helper function to get if-else blocks
	public static void getOccurance ( String findOccuranceOf, Statement givenStatement ){

		String[] ifStatementArray = givenStatement.toString().split("Else");
		
		int i = 0;
		Pattern p = Pattern.compile(findOccuranceOf);
		Matcher m = p.matcher(givenStatement.toString());
		while( m.find() ){
			i++;
		}
		System.out.println("i" +i);	
		int indexOfLast = i;
		
		// push all the if-else clauses into stack 
		while( i>=0 ){
			if ( i == indexOfLast && ifStatementArray[i].contains("True")){
				String[] temp = ifStatementArray[i].split("True");
				ifStatmentStack.push( "Else"+temp[1]);
			}else if ( i == indexOfLast)				
				ifStatmentStack.push( "Else "+ifStatementArray[i] );
			else if ( i == 0)
				ifStatmentStack.push( ifStatementArray[i] );
			else 
				ifStatmentStack.push( "Else"+ifStatementArray[i] );
			i--;
		}
		
	}
			

	//gets the parameters defined/initialized at the beginning; doesnot get any new parameters if defined in if clause or after if.
	public static void getInitialParameters( List<Statement> matlabStatements ){
		for( int i = 0; i<matlabStatements.size(); i++){
			if( matlabStatements.get(i).toString().startsWith("If") == false){
				initialAssignemntStatementStack.push(matlabStatements.get(i));
			}else
				return;
		}	
	}
	
	public static void findAndReplace(){
		System.out.println("Number of Pre-IF block assignments is: "+initialAssignemntStatementStack.size());
		int index = 0;
		
		newMatlabProgram = new MatlabProgram( finalIfString.toLowerCase() );			//creating new Matlab program withupdated if else block
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
		
		
		
//		System.out.println( "Final updated IFBlock string"+ finalIfString);
		

		
//		List<Statement> subjectToAssignment = newMatlabProgram.getStatements();
		
		
	//	System.out.println( "subjectToAssignment"+ subjectToAssignment);
	//	for ( int i = 0; i<subjectToAssignment.length(); i++){
	//		System.out.println("Number of "+LHS+" present:"+subjectToAssignment.contains(LHS.toString()));
	//	}
		
	}

}
