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

public class ClassifierTemplateParameter extends ClassifierDefinition {

	// Helper Operations
	
	/*
	 * Annotations are not allowed on classifier template parameters.
	 */
	public boolean annotationAllowed(StereotypeAnnotation annotation) {
		return false ;
	}
	
	/*
	 * Return true if the given member is a classifier template parameter.
	 */
	public boolean isSameKindAs(Member member) {
		return false ;
	}
	
	/*
	 * Returns false. (Classifier template parameters cannot be stubs.)
	 */
	public boolean matchForStub(UnitDefinition unit) {
		return false ;
	}
	
	
}
