package dl.optimizers;

import dl.semantics.*;
import java.util.*;

public class OptimizationResult {

	protected Valuation optimum;
	HashMap<String,String> textFields; // For other things the optimizer may return
		
	public OptimizationResult() {
		optimum = new Valuation();
	}
	
	public OptimizationResult( Valuation optimum ) {
		this.optimum = optimum;
	}

	public Valuation getOptimum() {
		return optimum;
	}
	
	public String getField( String name ) {
		return textFields.get( name );
	}
	
	public void setField( String name, String value ) {
		textFields.put( name, value );
	}

}
