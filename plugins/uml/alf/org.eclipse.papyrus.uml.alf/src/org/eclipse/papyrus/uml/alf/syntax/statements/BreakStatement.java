/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.syntax.statements;

public class BreakStatement extends Statement {

	// Derived Properties
	public Statement target ;
	
	// Constraints
	/*
	 * The target of a break statement may not have a @parallel annotation.
	 */
	public void checkBreakStatementNonparallelTarget() {
		
	}
	
	/*
	 * The target of a break statement is the innermost switch, while, do or for statement enclosing the break
	 * 	statement.
	 */
	public void checkBreakStatementTargetDerivation() {
		
	}
	
	// Helper Operations
	
	/*
	 * A break statement may not have any annotations.
	 */
	public boolean annotationAllowed (Annotation annotation) {
		return false ;
	}
	
	
}
