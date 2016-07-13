package propositionallogic.syntax;

import java.util.*;

public class PropositionalReplacement {
	Map<PropositionalVariable,Proposition> replacement;
	
	public PropositionalReplacement() {
		replacement = new HashMap<>();
	}
	
	public void put( PropositionalVariable variable, Proposition proposition ) {
		replacement.put( variable, proposition );
	}

}
