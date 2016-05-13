package matlab.syntax;

import dl.syntax.*;
import java.util.*;

public class MatlabConditional extends MatlabProgram {

	private final List<dLFormula> conditions;
	private final List<MatlabProgram> subPrograms;
	
	public MatlabConditional( List<dLFormula> conditions, List<MatlabProgram> subPrograms) {
		this.conditions = conditions;
		this.subPrograms = subPrograms;
	}
	
	public List<dLFormula> getConditions() {
		return conditions;
	}
	
	public List<MatlabProgram> getPrograms() {
		return subPrograms;
	}
}
