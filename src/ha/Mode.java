package ha;

import dl.syntax.*;
import java.util.*;

class Mode {

	protected List<ExplicitODE> odes;
	protected dLFormula invariant;

	protected List<Edge> incomingEdges;
	protected List<Edge> outgoingEdges;

	public Mode( List<ExplicitODE> odes,
								dLFormula invariant, 
								List<Edge> incomingEdges, 
								List<Edge> outgoingEdges ) {

		if ( !invariant.isStatic() ) {
			throw new RuntimeException("Cannot use dynamic invariant: "
				+ invariant.toKeYmaeraString() );
		}

		this.odes = odes;
		this.invariant = invariant;
		this.incomingEdges = incomingEdges;
		this.outgoingEdges = outgoingEdges;
	}

// Plain old getters
	public List<ExplicitODE> getODEs() {
		return odes;
	}
	public dLFormula getInvariant() {
		return invariant;
	}
	public List<Edge> getIncomingEdges() {
		return incomingEdges;
	}
	public List<Edge> getOutgoingEdges() {
		return outgoingEdges;
	}

// Slightly more sophisticated getters
	public List<dLFormula> getInvariantList() {
		return invariant.splitOnAnds();
	}

}
