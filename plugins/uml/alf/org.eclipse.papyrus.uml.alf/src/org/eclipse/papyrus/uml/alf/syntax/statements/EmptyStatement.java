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

public class EmptyStatement extends Statement {

	// Constraints
	
	/*
	 * The assignments after and empty statement are the same as the assignments before the statement.
	 */
	public void checkEmptyStatementAssignmentsAfter() {
		
	}
	
	// Helper Operations
	public boolean annotationAllowed (Annotation annotation) {
		return false ;
	}
	
}
