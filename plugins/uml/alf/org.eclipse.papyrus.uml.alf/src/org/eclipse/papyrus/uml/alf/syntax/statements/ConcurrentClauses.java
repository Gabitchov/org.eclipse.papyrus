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

import java.util.List;

import org.eclipse.papyrus.uml.alf.syntax.common.SyntaxElement;

public class ConcurrentClauses extends SyntaxElement {

	// Synthesized Properties
	public List<NonFinalClause> clause ;
	
	// Constraints
	/*
	 * The assignments before each of the clauses in a set of concurrent clauses are the same as the
	 * 	assignments before the concurrent clauses.
	 */
	public void checkConcurrentClausesAssignmentsBefore() {
		
	}
	
	/*
	 * The same name may not be assigned in more than one conditional expression within the same
	 * 	concurrent set of clauses.
	 */
	public void checkConcurrentClausesConditionAssignments() {
		
	}
	
}
