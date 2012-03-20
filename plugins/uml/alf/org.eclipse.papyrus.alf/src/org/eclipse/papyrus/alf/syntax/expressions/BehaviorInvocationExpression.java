package org.eclipse.papyrus.alf.syntax.expressions;

public class BehaviorInvocationExpression extends InvocationExpression {

	//Synthesized Properties
	protected QualifiedName target ; 
	
	// Constraints
	
	/*
	 * An input argument expression must be assignable to its corresponding parameter. An output parameter 
	 * 	must be assignable to its corresponding argument expression. (Note that this implies that the type of an
	 * 	argument expression for an inout parameter must be the same as the type of that parameter.)
	 */
	public void checkBehaviorInvocationExpressionArgumentCompatibility () {
		
	}
	
	/*
	 * If the target qualified name disambiguates to a feature reference, then the feature of a behavior
	 * 	invocation expression is that feature reference.
	 */
	public void checkBehaviorInvocationExpressionFeatureDerivation () {
		
	}
	
	/*
	 * If the target qualified name does not disambiguate to a feature reference, then it must resolve to a
	 * 	behavior or an association end. Otherwise it must resolve to a single feature referent according to the
	 * 	overloading resolution rules, unless it is an implicit destructor call (in which case it has no referent).
	 */
	public void checkBehaviorInvocationExpressionReferentConstraint () {
		
	}
	
	/*
	 * The referent of a behavior invocation expression is the behavior named by the target or, if the target
	 * 	disambiguates to a feature reference, the operation or signal being invoked.
	 */
	public void checkBehaviorInvocationExpressionReferentDerivation () {
		
	}
	
}
