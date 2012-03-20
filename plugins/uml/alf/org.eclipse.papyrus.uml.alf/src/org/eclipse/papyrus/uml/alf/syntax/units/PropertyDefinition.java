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
package org.eclipse.papyrus.uml.alf.syntax.units;

import org.eclipse.papyrus.uml.alf.syntax.expressions.Expression;

public class PropertyDefinition extends TypedElementDefinition {

	// Synthesized Properties
	public Expression initializer ;
	public boolean isComposite = false ;
	
	// Derived Properties
	public boolean isBitStringConversion ;
	public boolean isCollectionConversion ;
	
	// Constraints
	
	/*
	 * If a property definition has an initializer, then the initializer expression must be assignable to the
	 * 	property definition.
	 */
	public void checkPropertyDefinitionInitializer() {
		
	}
	
	/*
	 * A property definition requires BitString conversion if its type is BitString and the type of its initializer is
	 * 	Integer or a collection class whose argument type is Integer.
	 */
	public void checkPropertyDefinitionIsBitStringConversion() {
		
	}
	
	/*
	 * A property definition requires collection conversion if its initializer has a collection class as its type and
	 * 	the property definition does not.
	 */
	public void checkPropertyDefinitionIsCollectionConversionDerivation() {
		
	}
	
	/*
	 * A property definition is a feature.
	 */
	public void checkPropertyDefinitionIsFeatureDerivation() {
		
	}
	
	
	// Helper Operations
	
	/*
	 * Returns true if the annotation is for a stereotype that has a metaclass consistent with Property.
	 */
	public boolean annotationAllowed(StereotypeAnnotation annotation) {
		return false ;
	}
	
	/*
	 * Return true if the given member is either a PropertyDefinition or an imported member whose referent is
	 * 	a PropertyDefinition or a Property.
	 */
	public boolean isSameKindAs(Member member) {
		return false ;
	}
	
	
}
