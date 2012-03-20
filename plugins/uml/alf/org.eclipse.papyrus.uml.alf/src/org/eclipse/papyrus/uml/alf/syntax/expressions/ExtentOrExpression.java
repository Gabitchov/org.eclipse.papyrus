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

public class ExtentOrExpression {

	// Synthesized Properties
	public QualifiedName name ;
	public Expression nonNameExpression ;


	//Derived Properties
	public Expression expression ;
	
	// Constraints
	
	/*
	 * The effective expression for the target is the parsed primary expression, if the target is not a qualified
	name, a name expression, if the target is a qualified name other than a class name, or a class extent
	expression, if the target is the qualified name of a class.
	 */
	public void checkExtentOrExpressionExpressionDerivation() {
		
	}
	
}
