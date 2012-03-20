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

public class NaturalLiteralExpression extends LiteralExpression {

	// Synthesized Properties
	public String image ;
	
	// Constraints
	
	/*
	 * The type of a natural literal is the Alf library type Natural.
	 * 	NOTE: If the context of a natural literal expression unambiguously requires either an Integer or an
	 * 	UnlimitedNatural value, then the result of the literal expression is implicitly downcast to the required
	 * 	type. If the context is ambiguous, however, than an explicit cast to Integer or UnlimitedNatural must be
	 * 	used.
	 */
	public void checkNaturalLiteralExpressionTypeDerivation() {
		
	}
	
}
