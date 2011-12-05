package org.eclipse.papyrus.alf.syntax.expressions;

public class SequenceRange extends SequenceElements {

	// Synthesized Properties
	public Expression rangeLower ;
	public Expression rangeUpper ;
	
	// Constraints
	/*
	 * The multiplicity lower bound of a sequence range is 0.
	 */
	public void checkSequenceRangeLowerDerivation() {
		
	}
	
	/*
	 * The multiplicity uper bound of a sequence range is * (since it is not possible, in general, to statically
	 * 	determine a more constrained upper bound).
	 */
	public void checkSequenceRangeUpperDerivation() {
		
	}
	
	
}
