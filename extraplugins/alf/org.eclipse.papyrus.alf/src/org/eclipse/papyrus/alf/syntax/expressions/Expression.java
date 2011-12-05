package org.eclipse.papyrus.alf.syntax.expressions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.alf.syntax.common.AssignedSource;
import org.eclipse.papyrus.alf.syntax.common.ElementReference;
import org.eclipse.papyrus.alf.syntax.common.SyntaxElement;

public class Expression extends SyntaxElement {

	// Derived Properties
	public List<AssignedSource> assignmentAfter ;
	public List<AssignedSource> assignmentBefore ;
	public int lower ;
	public ElementReference type ;
	public int upper ;

	//Constraints
	
	/*
	 * The assignments after an expression are given by the result of the updateAssignments helper operation.
	 */
	public void checkExpressionAssignmentsAfterDerivation() {
		
	}
	
	/*
	 * No name may be assigned more than once before or after an expression.
	 */
	public void checkExpressionUniqueAssignments() {
		
	}
	
	// Helper Operations
	/*
	 * Returns the assignments from before this expression updated for any assignments made in the
	expression. By default, this is the same set as the assignments before the expression. This operation is
	redefined only in subclasses of Expression for kinds of expressions that make assignments.
	 */
	public List<AssignedSource> updateAssignments() {
		return new ArrayList<AssignedSource>() ;
	}
	
}
