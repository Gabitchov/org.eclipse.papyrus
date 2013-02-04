/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.utils;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.DurationConstraintEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.DurationObservationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimeConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimeObservationEditPart;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.UMLPackage;

public final class TimeElementUtils {

	private TimeElementUtils() {
		// utility class
	}

	public static boolean isTimeElementEditPart(final int visualID) {
		return visualID == TimeObservationEditPart.VISUAL_ID || visualID == TimeConstraintEditPart.VISUAL_ID || visualID == DurationObservationEditPartCN.VISUAL_ID || visualID == DurationConstraintEditPartCN.VISUAL_ID;
	}

	public static boolean isTimeElementEditPart(final EditPart editPart) {
		return editPart instanceof TimeObservationEditPart || editPart instanceof TimeConstraintEditPart || editPart instanceof DurationObservationEditPartCN || editPart instanceof DurationConstraintEditPartCN;
	}

	/**
	 * Find time elements ({@link TimeObservation}s, {@link DurationObservation}s, {@link TimeConstraint}s and {@link DurationConstraint}s) linked to
	 * the given element.
	 * 
	 * @param element
	 *        the {@link OccurrenceSpecification} or {@link StateInvariant} for which related time elements must be
	 *        found
	 * @param hideOnly
	 *        whether to only return Views
	 * @param expectedParentView
	 *        if not <code>null</code>, then only return Views under this parent View
	 * @return the list of linked time elements to remove
	 */
	public static Set<EObject> getTimeElementsToRemove(final EObject element, final boolean hideOnly, final View expectedParentView) {
		final EReference[] references = new EReference[]{ UMLPackage.eINSTANCE.getDurationObservation_Event(), UMLPackage.eINSTANCE.getTimeObservation_Event(), UMLPackage.eINSTANCE.getConstraint_ConstrainedElement() };
		final Class<?>[] expectedClasses = new Class<?>[]{ TimeObservation.class, DurationObservation.class, TimeConstraint.class, DurationConstraint.class };
		return Utils.getReferencingElementsToRemove(element, references, hideOnly, expectedParentView, expectedClasses);
	}
}
