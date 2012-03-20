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

import org.eclipse.papyrus.uml.alf.syntax.common.ElementReference;

public class ImportedMember extends Member {

	// Synthesized Properties
	public ElementReference referent ;

	// Constraints
	
	/*
	 * An imported element is a feature if its referent is a feature.
	 */
	public void checkImportedElementFeatureDerivation() {
		
	}
	
	/*
	 * An imported element is not a stub.
	 */
	public void checkImportedElementNotStub() {
		
	}
	
	
	// Helper Operations
	
	/*
	 * Returns false. (Imported members do not have annotations.)
	 */
	public boolean annotationAllowed(StereotypeAnnotation annotation) {
		return false ;
	}
	
	/*
	 * If the given member is not an imported member, then return the result of checking whether the given
	 * 	member is distinguishable from this member. Else, if the element of the referent for this member is an
	 * 	Alf member, then return the result of checking whether that element is distinguishable from the given
	 * 	member. Else, if the element of the referent for the given member is an Alf member, then return the
	 * 	result of checking whether that element is distinguishable from this member. Else, the referents for both
	 * 	this and the given member are UML elements, so return the result of checking their distinguishability
	 * 	according to the rules of the UML superstructure.
	 */
	public boolean isSameKindAs(Member member) {
		return false ;
	}
	
}
