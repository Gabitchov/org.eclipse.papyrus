package org.eclipse.papyrus.alf.syntax.expressions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.alf.syntax.common.AssignedSource;
import org.eclipse.papyrus.alf.syntax.common.ElementReference;

public class AssignmentExpression extends Expression {
	
	// Synthesized Properties
	protected LeftHandSide leftHandSide ; 
	protected String operator ;
	protected Expression rightHandSide ; 
	
	// Derived Properties
	protected AssignedSource assignment ;
	protected Expression expression ;
	protected ElementReference feature ;
	protected boolean isArithmetic ;
	protected boolean isBitStringConversion ;
	protected boolean isCollectionConversion ;
	protected boolean isDataValueUpdate ;
	protected boolean isDefinition ;
	protected boolean isFeature ;
	protected boolean isIndexed ;
	protected boolean isSimple ;

	// Constraints
	
	/*
	 * The new assigned source for an assignment to a local name is the assignment expression. If the
	 * 	assignment is a definition, then the type is given by the right hand side, the multiplicity upper bound is 1
	 * 	if the upper bound of the right hand side is 1 and otherwise * and the multiplicity lower bound is 0.
	 * 	Otherwise, the type and multiplicity are the same as the left hand side.
	 */
	public void checkAssignmentExpressionAssignmentDerivation() {
		
	}
	
	/*
	 * The assigned source of a name before the right-hand side expression of an assignment expression is the
	 * 	same as the assigned source before the assignment expression. The assigned source of a name before the
	 * 	left-hand side is the assigned source after the right-hand side expression.
	 */
	public void checkAssignmentExpressionAssignmentsBefore() {
		
	}
	
	/*
	 * For a compound assignment, both the left-hand and right-hand sides must have a multiplicity upper
	 * 	bound of 1.
	 */
	public void checkAssignmentExpressionCompoundAssignmentMultiplicityConformance () {
		
	}
	
	/*
	 * For a compound assignment, both the left-hand side and the right-hand side must have the same type,
	 * 	consistent with the arithmetic or logical operator used in the compound assignment operator.
	 */
	public void checkAssignmentExpressionCompoundAssignmentTypeConformance () {
		
	}
	
	/*
	 * For a compound assignment, the effective expression is the left-hand side treated as a name expression,
	 * 	property access expression or sequence access expression, as appropriate for evaluation to obtain the
	 * 	original value to be updated.
	 */
	public void checkAssignmentExpressionExpressionDerivation () {
		
	}
	
	/*
	 * If the left-hand side of an assignment expression is a feature, then the feature of the assignment is the
	 * 	referent of the left-hand side.
	 */
	public void checkAssignmentExpressionFeatureDerivation () {
		
	}
	
	/*
	 * An assignment expression is an arithmetic assignment if its operator is a compound assignment operator
	 * for an arithmetic operation.
	 */
	public void checkAssignmentExpressionIsArithmeticDerivation () {
		
	}
	
	/*
	 * An assignment requires BitString conversion if the type of the left-hand side is BitString and either the
	 * 	type of the right-hand side is Integer or collection conversion is required and the type of the right-hand
	 * 	side is a collection class whose argument type is Integer.
	 */
	public void checkAssignmentExpressionIsBitStringConversionDerivation () {
		
	}
	
	/*
	 * An assignment requires collection conversion if the type of the right-hand side is a collection class and
	 * 	its multiplicity upper bound is 1, and the type of the left-hand side is not a collection class.
	 */
	public void checkAssignmentExpressionIsCollectionConversionDerivation () {
		
	}
	
	/*
	 * An assignment expression is a data value update if its left hand side is an attribute of a data value held in
	 * 	a local name or parameter.
	 */
	public void checkAssignmentExpressionIsDataValueUpdateDerivation () {
		
	}
	
	/*
	 * An assignment expression is a definition if it is a simple assignment and its left hand side is a local name
	 * 	for which there is no assignment before the expression.
	 */
	public void checkAssignmentExpressionIsDefinitionDerivation () {
		
	}
	
	/*
	 * The left hand side of an assignment expression is a feature if it is a kind of FeatureLeftHandSide.
	 */
	public void checkAssignmentExpressionIsFeatureDerivation () {
		
	}
	
	/*
	 * The left hand side of an assignment expression is indexed if it has an index.
	 */
	public void checkAssignmentExpressionIsIndexedDerivation () {
		
	}
	
	/*
	 * An assignment expression is a simple assignment if the assignment operator is "=". 
	 */
	public void checkAssignmentExpressionIsSimpleDerivation () {
		
	}
	
	/*
	 * An assignment expression has the same multiplicity lower bound as its right-hand side expression.
	 */
	public void checkAssignmentExpressionLowerDerivation () {
		
	}
	
	/*
	 * If the left-hand side of a simple assignment is not a new local name and the multiplicity upper bound of
	 * 	the left-hand side is less than or equal to 1, then the multiplicity upper bound of the right-hand side
	 * 	cannot be greater than that of the left-hand side.
	 */
	public void checkAssignmentExpressionSimpleAssignmentMultiplicityConformance () {
		
	}
	
	/*
	 * If the left-hand side of a simple assignment is not a new local name, and the right-hand side is not null,
	 * 	then the left-hand side must either be untyped or have a type that conforms to the type of the right-hand
	 * 	side expression.
	 */
	public void checkAssignmentExpressionSimpleAssignmentTypeConformance () {
		
	}
	
	/*
	 * An assignment expression has the same type as its right-hand side expression.
	 */
	public void checkAssignmentExpressionTypeDerivation () {
		
	}
	
	/*
	 * An assignment expression has the same multiplicity upper bound as its right-hand side expression.
	 */
	public void checkAssignmentExpressionUpperDerivation () {
		
	}
	
	// Helper Operations
	
	/*
	 * The assignments after an assignment expression are the assignments after the left-hand side, updated by
	 * 	the assignment from the assignment statement, if any.
	 */
	public List<AssignedSource> updateAssignments ( ) {
		return new ArrayList<AssignedSource>() ;
	}
}
