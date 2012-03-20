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

import org.eclipse.papyrus.uml.alf.syntax.common.ElementReference;
import org.eclipse.papyrus.uml.alf.syntax.common.SyntaxElement;

public class FeatureReference extends SyntaxElement {

	// Synthesized Properties
	
	/*
	 * The target expression.
	 */
	public Expression  expression ;
	
	/*
	 * The name of the feature
	 */
	public NameBinding nameBinding ;

	//Derived Properties
	public ElementReference referent ;

	// Constraints
	
	/*
	 * The features referenced by a feature reference include the features of the type of the target expression
	 * 	and the association ends of any binary associations whose opposite ends are typed by the type of the
	 * 	target expression.
	 */
	public void checkFeatureReferenceReferentDerivation() {
		
	}
	
	/*
	 * The target expression of the feature reference may not be untyped, nor may it have a primitive or
	 * 	enumeration type.
	 */
	public void checkFeatureReferenceTargetType() {
		
	}
	
}
