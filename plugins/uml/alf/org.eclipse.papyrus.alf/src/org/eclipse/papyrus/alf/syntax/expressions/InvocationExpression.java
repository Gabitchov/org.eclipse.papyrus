package org.eclipse.papyrus.alf.syntax.expressions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.alf.syntax.common.AssignedSource;
import org.eclipse.papyrus.alf.syntax.common.ElementReference;

public abstract class InvocationExpression extends Expression {

	// Synthesized Properties
	
	/*
	 * The tuple for the invocation expression.
	 */
	public Tuple tuple ;

	// Derived Properties
	public FeatureReference feature ;
	public boolean isAssociationEnd ;
	public boolean isBehavior ;
	public boolean isDestructor ;
	public boolean isImplicit ;
	public boolean isOperation ;
	public boolean isSignal ;
	public List<ElementReference> parameter ;
	public ElementReference referent ;

	// Constraints
	
	/*
	 * The assignments before the target expression of the feature reference of an invocation expression (if
	 * 	any) are the same as the assignments before the invocation expression.
	 */
	public void checkInvocationExpressionAssignmentsBefore() {
		
	}
	
	/*
	 * An invocation expression is an association end read if its referent is an association end.
	 */
	public void checkInvocationExpressionIsAssociationEndDerivation() {
		
	}
	
	/*
	 * An invocation expression is a behavior invocation if its referent is a behavior.
	 */
	public void checkInvocationExpressionIsBehaviorDerivation() {
		
	}
	
	/*
	 * An invocation expression is a destructor call either implicitly or if it is an explicit operation call to a
	 * 	destructor operation.
	 */
	public void checkInvocationExpressionIsDestructorDerivation() {
		
	}
	
	/*
	 * An invocation expression is an implicit object destruction if it has a feature with the name "destroy" and
	 * 	no explicit referents.
	 */
	public void checkInvocationExpressionIsImplicitDerivation() {
		
	}
	
	/*
	 * An invocation expression is an operation call if its referent is an operation.
	 */
	public void checkInvocationExpressionIsOperationDerivation() {
		
	}
	
	/*
	 * An invocation expression is a signal send if its referent is a signal.
	 */
	public void checkInvocationExpressionIsSignalDerivation() {
		
	}
	
	/*
	 * The multiplicity lower bound of an invocation expression is determined by the return parameter (if any)
	 * 	of the referent.
	 */
	public void checkInvocationExpressionLowerDerivation() {
		
	}
	
	/*
	 * The parameters of an invocation expression are given by the result of the parameterElements helper
	 * 	operation.
	 */
	public void checkInvocationExpressionParameterDerivation() {
		
	}
	
	/*
	 * The type of an invocation expression is determined by the return parameter (if any) of the referent.
	 */
	public void checkInvocationExpressionTypeDerivation() {
		
	}
	
	/*
	 * The multiplicity upper bound of an invocation expression is determined by the return parameter (if any)
	 * 	of the referent.
	 */
	public void checkInvocationExpressionUpperDerivation() {
		
	}
	
	// Helper Operations
	/*
	 * Returns references to the elements that act as the parameters of the referent. For a behavior or operation,
	 * 	these are the owned parameters, in order. Otherwise (by default), they are actually any properties of the
	 * 	referent (e.g., signal attributes), which are treated as if they were in parameters. (This is defined as a
	 * 	helper operation, so that it can be overridden by subclasses of InvocationExpression, if necessary.)
	 */
	public List<ElementReference>parameterElements() {
		return new ArrayList<ElementReference>() ;
	}
	
	/*
	 * The assignments after an invocation expression are the same as those after the tuple of the expression.
	 */
	public List<AssignedSource> updateAssignments ( ) {
		return new ArrayList<AssignedSource>() ;
	}
	
}
