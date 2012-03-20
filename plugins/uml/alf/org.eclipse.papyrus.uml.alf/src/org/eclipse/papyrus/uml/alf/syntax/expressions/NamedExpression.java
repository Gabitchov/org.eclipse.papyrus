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

import org.eclipse.papyrus.uml.alf.syntax.common.SyntaxElement;

public class NamedExpression extends SyntaxElement {

	// Synthesized Properties
	public Expression expression ;
	public Expression index ;
	public String name ;
	
	// Derived Properties
	public boolean isBitStringConverstion ;
	public boolean isCollectionConversion ;
	
	// Constraints
	
	/*
	 * Bit string conversion is required if the type of the type of the corresponding parameter is BitString, or a
	 * 	collection class instantiated with a BitString type, and the type of the argument expression is not
	 * 	BitString.
	 */
	public void checkNamedExpressionIsBitStringConversionDerivation() {
		
	}
	
	/*
	 * Collection conversion is required if the type of the corresponding parameter is a collection class and the
	 * 	type of the argument expression is not.
	 */
	public void checkNamedExpressionIsCollectionConversionDerivation() {
		
	}
	
}
