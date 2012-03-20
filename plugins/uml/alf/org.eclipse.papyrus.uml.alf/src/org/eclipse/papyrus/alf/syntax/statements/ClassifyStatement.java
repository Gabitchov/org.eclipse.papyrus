package org.eclipse.papyrus.alf.syntax.statements;

import java.util.List;

import org.eclipse.papyrus.alf.syntax.common.ElementReference;
import org.eclipse.papyrus.alf.syntax.expressions.Expression;

public class ClassifyStatement extends Statement {

	// Synthesized Properties
	public Expression expression ;
	public QualifiedNameList fromList ;
	public boolean isReclassifyAll = false ;
	public QualifiedNameList toList ;
	
	// Derived Properties
	public List<ElementReference> fromClass ;
	public List<ElementReference> toClass ;
	
	// Constraints
	
	/*
	 * The assignments after a classify statement are the same as the assignments after its expression.
	 */
	public void checkClassifyStatementAssignmentsAfter() {
		
	}
	
	/*
	 * The assignments before the expression of a classify statement are the same as the assignments before the
	 * 	statement.
	 */
	public void checkClassifyStatementAssignmentsBefore() {
		
	}
	
	/*
	 * All the from and to classes of a classify statement must be subclasses of the type of the target expression
	 * 	and none of them may have a common superclass that is a subclass of the type of the target expression
	 * 	(that is, they must be disjoint subclasses).
	 */
	public void checkClassifyStatementClasses() {
		
	}
	
	/*
	 * All qualified names listed in the from or to lists of a classify statement must resolve to classes.
	 */
	public void checkClassifyStatementClassNames() {
		
	}
	
	/*
	 * The expression in a classify statement must have a class as its type and multiplicity upper bound of 1.
	 */
	public void checkClassifyStatementExpression() {
		
	}
	
	/*
	 * The from classes of a classify statement are the class referents of the qualified names in the from list for
	 * 	the statement.
	 */
	public void checkClassifyStatementFromClassDerivation() {
		
	}
	
	/*
	 * The to classes of a classify statement are the class referents of the qualified names in the to list for the
	 * 	statement.
	 */
	public void checkClassifyStatementToClassDerivation() {
		
	}
	
}
