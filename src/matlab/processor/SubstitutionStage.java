package matlab.processor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import matlab.syntax.MatlabProgram;
import matlab.syntax.Statement;

public class SubstitutionStage {
	
	//stack to store the Statements
	static Stack<Statement> assignmentStatementsStack = new Stack<>();
	static Stack<String> ifStatmentStack = new Stack<>();
	
	
	//check for more than one assignment features at the end of if statement
	public static void main(String[] arg){
	
	// uncomment below to check if-else if-else and more than one assignment statements at the end	
		MatlabProgram mp = new MatlabProgram (" k1 = 5; k2 = 7*k1; if ( x > k1*6) y = k2*x; elseif (n==0) y = k1*x;else k2 = 100; end z = x^2 + k2*y^2;p=0;");
		
		//MatlabProgram mp = new MatlabProgram (" k1 = 5; k2 = 7*k1; if ( x > k1*6) y = k2*x; else y = k1*x;k2 = 100; end z = x^2 + k2*y^2;p=0;");
		System.out.println(mp.getStatements());
		List<Statement> matlabStatements = mp.getStatements();
		appendPostAssignment( matlabStatements );
	}
	
	
	public static Statement getPostIfStatement( List<Statement> matlabStatements ){
		Statement lastStatement = matlabStatements.get(matlabStatements.size()-1);
		return lastStatement;
	}
	
	
	public static void appendPostAssignment( List<Statement> matlabStatements){
		
		
		System.out.println("In append..."+matlabStatements.get(matlabStatements.size()-1));
			
		Statement lastStatement = getPostIfStatement(matlabStatements);
		int index = matlabStatements.size()-1;
		
		//store all the assignment statements POST IFSTATEMENT
		while(lastStatement.toString().startsWith("If") == false){
			assignmentStatementsStack.push(lastStatement);
			lastStatement = getPostIfStatement(matlabStatements.subList(0, index));
			index--;
		}
		
		//when the controll comes here check whether lastStatement has ifStatment or not, if it has then store individual code for if-elseif-else
		//in respective arrays/data structure to work on later.
		
			if ( lastStatement.toString().startsWith("If") == true){
					getOccurance("Else", lastStatement);
							
				String[] ifElseBlock = getIfStatementsStack();
				String[] updatedIfBlock = new String[ ifElseBlock.length ];
				System.out.println("Assignment statement2 "+ifElseBlock[0]+""+ifElseBlock[1]);
				String temp = getString();
				for( int s = 0 ; s<ifElseBlock.length; s++){
					//copying the assignment statements into if and else individual blocks	
					String block = ifElseBlock[s] + temp;
					updatedIfBlock[s] = block ;
				}
				for ( int st = 0; st<updatedIfBlock.length; st++){
					System.out.println( updatedIfBlock[st] );
				}
			}
		
		
		
		
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
	
	public static String getString(){
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
	//		System.out.println("Assignment statement "+aS);
			i++;
		}
		return ifs;
	} 
	
	
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
		
	}
	

}
