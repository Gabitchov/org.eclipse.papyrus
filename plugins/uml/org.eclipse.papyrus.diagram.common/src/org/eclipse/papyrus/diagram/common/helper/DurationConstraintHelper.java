/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.helper;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This helper provides interesting features for DurationConstraint objects
 */
public class DurationConstraintHelper {

	/**
	 * Get the list of all DurationConstraint constraining a given element
	 * 
	 * @param element
	 *        the constrained element
	 * @return list of DurationConstraint
	 */
	public static List<DurationConstraint> getDurationConstraintsOn(NamedElement element) {
		Collection<Setting> inverseReferences = CacheAdapter.INSTANCE.getNonNavigableInverseReferences(element);
		// DurationConstraint referencing element
		List<DurationConstraint> referencing = new LinkedList<DurationConstraint>();
		for(Setting ref : inverseReferences) {
			if(UMLPackage.eINSTANCE.getConstraint_ConstrainedElement().equals(ref.getEStructuralFeature()) && ref.getEObject() instanceof DurationConstraint && ref.getEObject().eContainer() != null) {
				referencing.add((DurationConstraint)ref.getEObject());
			}
		}
		return referencing;
	}

	/**
	 * Get the list of all DurationConstraint constraining duration between the two elements (order of parameters does not matter)
	 * 
	 * @param element1
	 *        the first observed element
	 * @param element2
	 *        the second observed element
	 * @return list of DurationConstraint
	 */
	public static List<DurationConstraint> getDurationConstraintsBetween(NamedElement element1, NamedElement element2) {
		List<DurationConstraint> referencing = getDurationConstraintsOn(element1);
		referencing.retainAll(getDurationConstraintsOn(element2));
		return referencing;
	}
}
