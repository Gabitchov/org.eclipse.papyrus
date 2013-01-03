/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.parts;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.part.ICustomDiagramUpdater;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactStateInvariantEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.DestructionOccurrenceSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.DurationConstraintEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.DurationObservationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullStateInvariantEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageOccurrenceSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.OccurrenceSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLNodeDescriptor;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;

public class PropertyDiagramUpdater implements ICustomDiagramUpdater {

	public List<?> getSemanticChildren(final View view) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<UMLNodeDescriptor> getLifelineFullLifelineTimelineCompartment_8SemanticChildren(final View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		final View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		final Lifeline modelElement = (Lifeline) containerView.getElement();
		final LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();

		if ((modelElement).getCoveredBys().size() > 0) {
			final Interaction interaction = modelElement.getInteraction();

			for (final Object element : interaction.getFragments()) {

				final InteractionFragment childElement = (InteractionFragment) element;
				final int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
				if (visualID == FullStateInvariantEditPartCN.VISUAL_ID) {
					result.add(new UMLNodeDescriptor(childElement, visualID));
					continue;
				}
				if (visualID == OccurrenceSpecificationEditPartCN.VISUAL_ID) {
					result.add(new UMLNodeDescriptor(childElement, visualID));
					continue;
				}
				if (visualID == MessageOccurrenceSpecificationEditPartCN.VISUAL_ID) {
					result.add(new UMLNodeDescriptor(childElement, visualID));
					continue;
				}
				if (visualID == DestructionOccurrenceSpecificationEditPartCN.VISUAL_ID) {
					result.add(new UMLNodeDescriptor(childElement, visualID));
					continue;
				}
			}
		}

		if ((modelElement).getCoveredBys().size() > 0) {
			final Interaction interaction = modelElement.getInteraction();

			for (final Object element : interaction.getOwnedRules()) {
				final Constraint childElement = (Constraint) element;
				final int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
				if (visualID == DurationConstraintEditPartCN.VISUAL_ID) {
					result.add(new UMLNodeDescriptor(childElement, visualID));
					continue;
				}
				if (visualID == DurationObservationEditPartCN.VISUAL_ID) {
					result.add(new UMLNodeDescriptor(childElement, visualID));
					continue;
				}
			}
		}
		return result;
	}

	public static List<UMLNodeDescriptor> createLifelineCompactLifelineCompartment_23Children(final View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		final View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		final Lifeline modelElement = (Lifeline) containerView.getElement();
		final LinkedList<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();

		if ((modelElement).getCoveredBys().size() > 0) {
			final Interaction interaction = modelElement.getInteraction();

			for (final Object element : interaction.getFragments()) {

				final InteractionFragment childElement = (InteractionFragment) element;
				final int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
				if (visualID == CompactStateInvariantEditPartCN.VISUAL_ID) {
					result.add(new UMLNodeDescriptor(childElement, visualID));
					continue;
				}
				if (visualID == OccurrenceSpecificationEditPartCN.VISUAL_ID) {
					result.add(new UMLNodeDescriptor(childElement, visualID));
					continue;
				}
				if (visualID == MessageOccurrenceSpecificationEditPartCN.VISUAL_ID) {
					result.add(new UMLNodeDescriptor(childElement, visualID));
					continue;
				}
				if (visualID == DestructionOccurrenceSpecificationEditPartCN.VISUAL_ID) {
					result.add(new UMLNodeDescriptor(childElement, visualID));
					continue;
				}
			}
		}

		if ((modelElement).getCoveredBys().size() > 0) {
			final Interaction interaction = modelElement.getInteraction();

			for (final Object element : interaction.getOwnedRules()) {
				final Constraint childElement = (Constraint) element;
				final int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
				if (visualID == DurationConstraintEditPartCN.VISUAL_ID) {
					result.add(new UMLNodeDescriptor(childElement, visualID));
					continue;
				}
				if (visualID == DurationObservationEditPartCN.VISUAL_ID) {
					result.add(new UMLNodeDescriptor(childElement, visualID));
					continue;
				}
			}
		}
		return result;
	}

}
