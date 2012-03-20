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

public class SignalDefinition extends ClassifierDefinition {

	// Constraints
	
	/*
	 * The specialization referents of a signal definition must all be signals.
	 */
	public void checkSignalDefinitionSpecializationReferent() {
		
	}
	
	// Helper Operations
	
	/*
	 * In addition to the annotations allowed for classifiers in general, a signal definition allows an annotation
	 * 	for any stereotype whose metaclass is consistent with Signal.
	 */
	public boolean annotationAllowed(StereotypeAnnotation annotation) {
		return false ;
	}
	
	/*
	 * Return true if the given member is either a SignalDefinition or an imported member whose referent is a
	 * 	SignalDefinition or a Reception (where signal reception definitions are considered to be kinds of signal
	 * 	definitions).
	 */
	public boolean isSameKindAs(Member member) {
		return false ;
	}
	
	/*
	 * Returns true if the given unit definition matches this signal definition considered as a classifier
	 * 	definition and the subunit is for a signal definition.
	 */
	public boolean matchForStub(UnitDefinition unit) {
		return false ;
	}
	
}
