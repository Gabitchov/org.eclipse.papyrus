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
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This helper provides interesting features for DurationObservation objects
 */
public class DurationObservationHelper {

	/** The label to display for the duration observation */
	private static final String DURATION_OBSERVATION_LABEL_FORMAT = "&%s";

	/**
	 * Get the list of all DurationObservation observing duration between the
	 * two elements (order of parameters does not matter)
	 * 
	 * @param element1
	 *        the first observed element
	 * @param element2
	 *        the second observed element
	 * @return list of DurationObservation
	 */
	public static List<DurationObservation> getDurationObservationsBetween(NamedElement element1, NamedElement element2) {
		// DurationObservation referencing element1
		List<DurationObservation> referencing1 = getDurationObservationsOn(element1);
		// DurationObservation referencing element2
		List<DurationObservation> referencing2 = getDurationObservationsOn(element2);
		referencing1.retainAll(referencing2);
		return referencing1;
	}

	/**
	 * Get the list of all DurationObservation observing duration from or to an
	 * element
	 * 
	 * @param element
	 *        the observed element
	 * @return list of DurationObservation
	 */
	public static List<DurationObservation> getDurationObservationsOn(NamedElement element) {
		Collection<Setting> inverseReferences = EMFHelper.getUsages(element);
		// DurationObservation referencing element
		List<DurationObservation> referencing1 = new LinkedList<DurationObservation>();
		for(Setting ref : inverseReferences) {
			if(UMLPackage.eINSTANCE.getDurationObservation_Event().equals(ref.getEStructuralFeature()) && ref.getEObject().eContainer() != null) {
				referencing1.add((DurationObservation)ref.getEObject());
			}
		}
		return referencing1;
	}

	/**
	 * Get the string for displaying label of a DurationObservation
	 * 
	 * @param observation
	 *        the duration observation to display
	 * @return string
	 */
	public static String getLabelString(DurationObservation observation) {
		return String.format(DURATION_OBSERVATION_LABEL_FORMAT, observation.getName());
	}

	/**
	 * Check whether two occurrences are ends of the same message for enabling
	 * duration constraint creation
	 * 
	 * @param occurrence
	 *        first occurrence specification
	 * @param occurrence2
	 *        second occurrence specification
	 * @return true if occurrences are ends of the same message
	 */
	public static boolean endsOfSameMessage(OccurrenceSpecification occurrence, OccurrenceSpecification occurrence2) {
		return DurationConstraintHelper.endsOfSameMessage(occurrence, occurrence2);
	}
}
