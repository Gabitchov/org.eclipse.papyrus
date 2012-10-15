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
package org.eclipse.papyrus.uml.diagram.common.helper;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This helper provides interesting features for TimeConstraint objects
 */
public class TimeConstraintHelper {

	/**
	 * Get the list of all TimeConstraint constraining a given element
	 * 
	 * @param element
	 *        the constrained element
	 * @return list of TimeConstraint
	 */
	public static List<TimeConstraint> getTimeConstraintsOn(NamedElement element) {
		Collection<Setting> inverseReferences = EMFHelper.getUsages(element);
		// TimeConstraint referencing element
		List<TimeConstraint> referencing = new LinkedList<TimeConstraint>();
		for(Setting ref : inverseReferences) {
			if(UMLPackage.eINSTANCE.getConstraint_ConstrainedElement().equals(ref.getEStructuralFeature()) && ref.getEObject() instanceof TimeConstraint && ref.getEObject().eContainer() != null) {
				referencing.add((TimeConstraint)ref.getEObject());
			}
		}
		return referencing;
	}
}
