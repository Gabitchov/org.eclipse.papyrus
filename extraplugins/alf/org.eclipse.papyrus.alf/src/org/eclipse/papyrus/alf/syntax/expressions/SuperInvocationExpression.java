package org.eclipse.papyrus.alf.syntax.expressions;

public class SuperInvocationExpression extends InvocationExpression {

	// Synthesized Properties
	
	/*
	 * The name of the operation to be invoked, optionally qualified with the name of the appropriate
	 * superclass.
	 */
	public QualifiedName target ;

	//Constraints
	
	/*
	 * If the referent is the method of a constructor operation, the super invocation expression must occur in an
	 * 	expression statement at the start of the definition for the method of a constructor operation, such that any
	 * 	statements preceding it are also super constructor invocations.
	 */
	public void checkSuperInvocationExpressionConstructorCall() {
		
	}
	
	/*
	 * If the referent is the method of a destructor operation, the super invocation expression must occur in an
	 * 	within the method of a destructor operation.
	 */
	public void checkSuperInvocationExpressionDestructorCall() {
		
	}
	
	/*
	 * There is no feature for a super invocation.
	 */
	public void checkSuperInvocationExpressionFeatureDerivation() {
		
	}
	
	/*
	 * If the target is empty, the referent must be the method for a constructor operation.
	 */
	public void checkSuperInvocationExpressionImplicitTarget() {
		
	}
	
	/*
	 * It must be possible to identify a single valid operation denoted by the target of a super invocation
	 * 	expression that satisfies the overloading resolution rules.
	 */
	public void checkSuperInvocationExpressionOperation() {
		
	}
	
	/*
	 * If the target has a qualification, then this must resolve to one of the superclasses of the current context
	 * 	class.
	 */
	public void checkSuperInvocationExpressionQualification() {
		
	}
	
	/*
	 * The referent of a super invocation expression is the method behavior of the operation identified using
	 * 	the overloading resolution rules.
	 */
	public void checkSuperInvocationExpressionReferentDerivation() {
		
	}
	
}
