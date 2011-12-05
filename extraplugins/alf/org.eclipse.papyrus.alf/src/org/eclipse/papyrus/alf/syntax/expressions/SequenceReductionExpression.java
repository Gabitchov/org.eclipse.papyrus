package org.eclipse.papyrus.alf.syntax.expressions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.alf.syntax.common.AssignedSource;
import org.eclipse.papyrus.alf.syntax.common.ElementReference;

public class SequenceReductionExpression extends Expression {

	// Synthesized Properties
	public QualifiedName behaviorName ;
	public boolean isOrdered = false ;
	public ExtentOrExpression primary ;
	
	// Derived Properties
	public ElementReference referent ; 
	
	// Constraints
	/*
	 * The assignments before the target expression of a sequence reduction expression are the same as the
	 * 	assignments before the sequence reduction expression.
	 */
	public void checkSequenceReductionExpressionAssignmentsBefore() {
		
	}
	
	/*
	 * The behavior name in a sequence reduction expression must denote a behavior.
	 */
	public void checkSequenceReductionExpressionBehavior() {
		
	}
	
	/*
	 * The referent behavior must have two in parameters, a return parameter and no other parameters. The
	 * 	parameters must all have the same type as the argument expression and multiplicity [1..1].
	 */
	public void checkSequenceReductionExpressionBehaviorParameters() {
		
	}
	
	/*
	 * A sequence reduction expression has a multiplicity lower bound of 1.
	 */
	public void checkSequenceReductionExpressionLowerDerivation() {
		
	}
	
	/*
	 * The referent for a sequence reduction expression is the behavior denoted by the behavior name of the
	 * 	expression.
	 */
	public void checkSequenceReductionExpressionReferentDerivation() {
		
	}
	
	/*
	 * A sequence reduction expression has the same type as its primary expression.
	 */
	public void checkSequenceReductionExpressionTypeDerivation() {
		
	}
	
	/*
	 * A sequence reduction expression has a multiplicity upper bound of 1.
	 */
	public void checkSequenceReductionExpressionUpperDerivation() {
		
	}
	
	
	//Helper Operations
	/*
	 * The assignments after a sequence reduction expression are the same as after its primary expression.
	 */
	public List<AssignedSource> updateAssignments() {
		return new ArrayList<AssignedSource>() ;
	}
	
}
