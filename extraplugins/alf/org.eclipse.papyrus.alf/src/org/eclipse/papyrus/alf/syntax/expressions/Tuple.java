package org.eclipse.papyrus.alf.syntax.expressions;

import java.util.List;

import org.eclipse.papyrus.alf.syntax.common.SyntaxElement;

public abstract class Tuple extends SyntaxElement {

	// Synthesized Properties
	
	/*
	 * The invocation expression of which this tuple is a part.
	 */
	public InvocationExpression invocation ;
	
	// Derived Properties
	public List<NamedExpression> input ;
	public List<OutputNamedExpression> output ;
	
	// Constraints
	
	/*
	 * A name may be assigned in at most one argument expression of a tuple.
	 */
	public void checkTupleAssignmentsAfter() {
		
	}
	
	/*
	 * The assignments before each expression in a tuple are the same as the assignments before the tuple,
	 * 	except in the case of a name expression that defines a new local name, in which case the assigned source
	 * 	for the new name is included in the assignments before the name expression. (Note that the assigned
	 * 	source for a new name is included before the name expression so that the nameExpressionResolution
	 * 	constraint is not violated.) The assignments before the tuple are the same as the assignments after the
	 * 	feature reference of the invocation of the tuple, if the invocation has one, or otherwise the assignments
	 * 	before the invocation.
	 */
	public void checkTupleAssignmentsBefore() {
		
	}
	
	/*
	 * A tuple has the same number of inputs as its invocation has input parameters. For each input parameter,
	 * 	the tuple has a corresponding input with the same name as the parameter and an expression that is the
	 * 	matching argument from the tuple, or an empty sequence construction expression if there is no matching
	 * 	argument.
	 */
	public void checkTupleInputDerivation() {
		
	}
	
	/*
	 * An input parameter may only have a null argument if it has a multiplicity lower bound of 0.
	 */
	public void checkTupleNullInputs() {
		
	}
	
	/*
	 * A tuple has the same number of outputs as its invocation has output parameters. For each output
	 * 	parameter, the tuple has a corresponding output with the same name as the parameter and an expression
	 * 	that is the matching argument from the tuple, or an empty sequence construction expression if there is no
	 * 	matching argument.
	 */
	public void checkTupleOutputDerivation() {
		
	}
	
	/*
	 * An output parameter may only have a null argument if it is an out parameter.
	 */
	public void checkTupleOutputs() {
		
	}
	
}
