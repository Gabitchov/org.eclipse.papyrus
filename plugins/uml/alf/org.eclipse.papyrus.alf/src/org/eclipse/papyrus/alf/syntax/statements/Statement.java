package org.eclipse.papyrus.alf.syntax.statements;

import java.util.List;

import org.eclipse.papyrus.alf.syntax.common.AssignedSource;
import org.eclipse.papyrus.alf.syntax.common.DocumentedElement;

public abstract class Statement extends DocumentedElement{

	// Synthesized Properties
	public List<Annotation> annotation ;
	
	// Derived Properties
	public List<AssignedSource> assignmentAfter ;
	public List<AssignedSource> assignmentBefore ;
	public Statement enclosingStatement ;
	public boolean isIsolated ;
	
	// Constraints
	
	/*
	 * All the annotations of a statement must be allowed, as given by the annotationAllowed operation for the
	 * 	statement.
	 */
	public void checkStatementAnnotationsAllowed() {
		
	}
	
	/*
	 * A statement is isolated if it has an @isolated annotation.
	 */
	public void checkStatementIsIsolatedDerivation() {
		
	}
	
	/*
	 * No name may be assigned more than once before or after a statement.
	 */
	public void checkStatementUniqueAssignments() {
		
	}
	
	
	//Helper Operations
	
	/*
	 * Returns true if the given annotation is allowed for this kind of statement. By default, only an @isolated
	 * 	annotation is allowed, with no arguments. This operation is redefined only in subclasses of Statement for
	 * 	kinds of statements that allow different annotations than this default.
	 */
	public boolean annotationAllowed(Annotation annotation) {
		return false ;
	}
	
}
