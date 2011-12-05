package org.eclipse.papyrus.alf.syntax.expressions;

import java.util.List;

import org.eclipse.papyrus.alf.syntax.common.AssignedSource;
import org.eclipse.papyrus.alf.syntax.common.SyntaxElement;

public class LeftHandSide extends SyntaxElement {

	// Derived Properties
	public List<AssignedSource> assignmentAfter ;
	public List<AssignedSource> assignmentBefore ;
	
	// Constraints
	
	/*
	 * If a left-hand side has an index, then the index expression must have a multiplicity upper bound no
	 * 	greater than 1.
	 */
	public void checkLeftHandSideIndexExpression() {
		
	}
	
}
