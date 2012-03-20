package org.eclipse.papyrus.alf.syntax.expressions;

import java.util.List;

public class SequenceExpressionList extends SequenceElements {

	// Synthesized Properties
	public List<Expression> element ;
	
	// Constraints
	/*
	 * The multiplicity lower bound of the elements of a sequence expression list is given by the sum of the
	 * 	lower bounds of each of the expressions in the list.
	 */
	public void checkSequenceExpressionListLowerDerivation() {
		
	}
	
	/*
	 * The multiplicity lower bound of the elements of a sequence expression list is given by the sum of the
	 * 	lower bounds of each of the expressions in the list. If any of the expressions in the list have an
	 * 	unbounded upper bound, then the sequence expression list also has an unbounded upper bound.
	 */
	public void checkSequenceExpressionListUpperDerivation() {
		
	}
	
}
