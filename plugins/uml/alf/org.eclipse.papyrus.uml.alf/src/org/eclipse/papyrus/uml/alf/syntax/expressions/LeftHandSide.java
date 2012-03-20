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
package org.eclipse.papyrus.uml.alf.syntax.expressions;

import java.util.List;

import org.eclipse.papyrus.uml.alf.syntax.common.AssignedSource;
import org.eclipse.papyrus.uml.alf.syntax.common.SyntaxElement;

public class LeftHandSide extends SyntaxElement {

	// Derived Properties
	public List<AssignedSource> assignmentAfter ;
	public List<AssignedSource> assignmentBefore ;
	
	// Constraints
	
	/*
	 * If a left-hand side has an index, then the index expression must have a multiplicity upper bound no
	 * 	greater than 1.
	 */
	public void checkLeftHandSideIndexExpression() {
		
	}
	
}
