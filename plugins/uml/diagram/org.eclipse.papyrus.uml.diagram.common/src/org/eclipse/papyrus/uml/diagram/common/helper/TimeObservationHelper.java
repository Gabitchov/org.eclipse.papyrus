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
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This helper provides interesting features for TimeObservation objects
 */
public class TimeObservationHelper {

	/**
	 * Get the list of all TimeObservation observing a given element
	 * 
	 * @param element
	 *        the observed element
	 * @return list of TimeObservation
	 */
	public static List<TimeObservation> getTimeObservations(NamedElement element) {
		Collection<Setting> inverseReferences = EMFHelper.getUsages(element);
		// TimeConstraint referencing element
		List<TimeObservation> referencing = new LinkedList<TimeObservation>();
		for(Setting ref : inverseReferences) {
			if(UMLPackage.eINSTANCE.getTimeObservation_Event().equals(ref.getEStructuralFeature()) && ref.getEObject().eContainer() != null) {
				referencing.add((TimeObservation)ref.getEObject());
			}
		}
		return referencing;
	}
}
