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

public class ClassDefinition extends ClassifierDefinition {

	// Constraints
	
	/*
	 * The specialization referents of a class definition must all be classes. A class definition may not have any
	 * 	referents that are active classes unless this is an active class definition.
	 */
	public void checkClassDefinitionSpecializationReferent() {
		
	}
	
	
	// Helper Operations
	
	/*
	 * In addition to the annotations allowed for classifiers in general, a class definition allows an annotation
	 * 	for any stereotype whose metaclass is consistent with Class.
	 */
	public boolean annotationAllowed(StereotypeAnnotation annotation) {
		return super.annotationAllowed(annotation) && false ;
	}
	
	/*
	 * Return true if the given member is either a ClassDefinition or an imported member whose referent is a
	 * 	ClassDefinition or a Class.
	 */
	public boolean isSameKindAs(Member member) {
		return false ;
	}
	
	/*
	 * Returns true if the given unit definition matches this class definition considered as a classifier definition
	 * 	and the subunit is for a class definition.
	 */
	public boolean matchForStub(UnitDefinition unit) {
		return false ;
	}
	
}
