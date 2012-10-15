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

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OccurrenceSpecification;
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
		Collection<Setting> inverseReferences = EMFHelper.getUsages(element);
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
	 * Get the list of all DurationConstraint constraining duration between the
	 * two elements (order of parameters does not matter)
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

	/**
	 * Check whether two occurrences cover the same lifeline for enabling
	 * duration constraint creation
	 * 
	 * @param occurrence
	 *        first occurrence specification
	 * @param occurrence2
	 *        second occurrence specification
	 * @return true if occurrences cover the same lifeline
	 */
	public static boolean coversSameLifeline(OccurrenceSpecification occurrence, OccurrenceSpecification occurrence2) {
		// In fact, the covered lifeline(s) should be a size 1 list (UML
		// constraint on OccurrenceSpecification).
		List<Lifeline> coveredLifeline = new ArrayList<Lifeline>(occurrence.getCovereds());
		coveredLifeline.retainAll(occurrence2.getCovereds());
		return !coveredLifeline.isEmpty();
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
		if(occurrence instanceof MessageOccurrenceSpecification) {
			Message mess = ((MessageOccurrenceSpecification)occurrence).getMessage();
			if(mess != null && occurrence2 instanceof MessageOccurrenceSpecification) {
				Message mess2 = ((MessageOccurrenceSpecification)occurrence2).getMessage();
				return mess.equals(mess2);
			}
		}
		return false;
	}
}
