package org.eclipse.papyrus.alf.syntax.expressions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.alf.syntax.common.AssignedSource;

public class SequenceOperationExpression extends InvocationExpression {

	// Synthesized Properties
	public QualifiedName operation ;
	public ExtentOrExpression primary ;
	
	// Derived Properties
	public boolean isBitStringConversion ;
	public boolean isCollectionConversion ;
	
	// Constraints
	/*
	 * The type of an input argument expression of a sequence operation parameter must be assignable to its
	 * 	corresponding parameter. The type of an output parameter must be assignable to its corresponding
	 * 	argument expression. (Note that this implies that the type of an argument expression for an inout
	 * 	parameter must be the same as the type of that parameter.)
	 */
	public void checkSequenceOperationExpressionArgumentCompatibility() {
		
	}
	
	/*
	 * The assignments before the primary expression of a sequence operation expression are the same as the
	 * 	assignments before the sequence operation expression.
	 */
	public void checkSequenceOperationExpressionAssignmentsBefore() {
		
	}
	
	/*
	 * There is no feature for a sequence operation expression.
	 */
	public void checkSequenceOperationExpressionFeatureDerivation() {
		
	}
	
	/*
	 * BitString conversion is required if type of the first parameter of the referent of a sequence operation
	 * 	expression is BitString and either the type of its primary expression is Integer or collection conversion is
	 * 	required and the type of its primary expression is a collection class whose argument type is Integer.
	 */
	public void checkSequenceOperationExpressionIsBitStringConversionDerivation() {
		
	}
	
	/*
	 * Collection conversion is required if the type of the primary expression of a sequence operation
	 * 	expression is a collection class.
	 */
	public void checkSequenceOperationExpressionIsCollectionConversionDerivation() {
		
	}
	
	/*
	 * There must be a single behavior that is a resolution of the operation qualified name of a sequence
	 * 	operation expression with a least one parameter, whose first parameter has direction in or inout, has
	 * 	multiplicity [0..*] and to which the target primary expression is assignable.
	 */
	public void checkSequenceOperationExpressionOperationReferent() {
		
	}
	
	/*
	 * The referent for a sequence operation expression is the behavior named by the operation for the
	 * 	expression.
	 */
	public void checkSequenceOperationExpressionReferentDerivation() {
		
	}
	
	/*
	 * If the first parameter of the referent has direction inout, then the parameter type must have the same type
	as the primary expression.
	 */
	public void checkSequenceOperationExpressionTargetCompatibility() {
		
	}
	
	//Helper Operations
	/*
	 * The assignments after a sequence operation expression include those made in the primary expression
	 * 	and those made in the tuple and, for an "in place" operation (one whose first parameter is inout), that
	 * 	made by the sequence operation expression itself.
	 */
	public List<AssignedSource> updateAssignments() {
		return new ArrayList<AssignedSource>() ;
	}
}
