package ha;

import dl.syntax.HybridProgram;
import dl.syntax.dLFormula;

class Edge {

	protected dLFormula guard;
	protected HybridProgram reset;

	public Edge( dLFormula guard, HybridProgram reset ) {

		if (!guard.isStatic() ) {
			throw new RuntimeException("Cannot use a dynamic guard: " +
				guard.toKeYmaeraString() );

		} else if (!reset.isPurelyDiscrete() ) {
			throw new RuntimeException("Cannot use a non-discrete reset: " +
				reset.toKeYmaeraString() );
		}

		this.guard = guard;
		this.reset = reset;
	}

	public dLFormula getGuard() {
		return guard;
	}

	public HybridProgram getReset() {
		return reset;
	}
}
