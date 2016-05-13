package matlab.syntax;

import dl.syntax.*;
import java.util.*;

public class MatlabSequence extends MatlabProgram {
	
	private final MatlabProgram firstProgram;
	private final MatlabProgram secondProgram;
	
	public MatlabSequence( MatlabProgram firstProgram, MatlabProgram secondProgram ) {
		this.firstProgram = firstProgram;
		this.secondProgram = secondProgram;
	}
	
	public MatlabSequence( ArrayList<MatlabProgram> programs ) {
		
		ArrayList<MatlabProgram> programsCopy = ((ArrayList<MatlabProgram>)(programs.clone()));

		if ( programs.size() == 1 ) {
			firstProgram = new NoOp();
			secondProgram = programsCopy.get(0);
		} else {	
			firstProgram = programsCopy.get(0);
			programsCopy.remove(0);
			secondProgram = new MatlabSequence( programsCopy );
		}
		
	}
	
	public MatlabProgram getFirstProgram() {
		return firstProgram;
	}
	
	public MatlabProgram getSecondProgram() {
		return secondProgram;
	}
	
	public MatlabProgram replace( Replacement replacement ) {
		return new MatlabSequence( firstProgram.replace(replacement), secondProgram.replace(replacement) );
	}

}
