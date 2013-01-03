/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.DestructionOccurrenceSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageOccurrenceSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.OccurrenceSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TickEditPart;
import org.eclipse.uml2.uml.OccurrenceSpecification;

public final class TickUtils {

	private static final String OCCURRENCE_TO_TICK_ANNOTATION = "occurrenceToTick"; //$NON-NLS-1$
	private static final String TICK_TO_OCCURRENCE_ANNOTATION = "tickToOccurrence"; //$NON-NLS-1$

	private TickUtils() {
		// utility class
	}

	public static void associateTickNodeToOccurrenceNode(final Node tickNode, final Node occurrenceNode, final boolean overwrite) {
		// preconditions
		checkTickView(tickNode);
		checkOccurrenceSpecificationView(occurrenceNode);
		// associate tick to occurrence
		final EAnnotation tickEAnnotation = TickUtils.getOrCreateTickEAnnotation(tickNode);
		if (overwrite) {
			clearTickAssociation(tickNode, tickEAnnotation);
		}
		Assert.isLegal(tickEAnnotation.getReferences().isEmpty(), "A tick can only be associated to one occurrence"); //$NON-NLS-1$
		tickEAnnotation.getReferences().add(occurrenceNode);
		// associate occurrence to tick
		final EAnnotation occurrenceEAnnotation = TickUtils.getOrCreateOccurrenceEAnnotation(occurrenceNode);
		occurrenceEAnnotation.getReferences().add(tickNode);
	}

	/** Remove associations for this tick to any occurrences, and from associated occurrences to this tick. */
	private static void clearTickAssociation(final Node tickNode, final EAnnotation tickEAnnotation) {
		final EList<EObject> references = tickEAnnotation.getReferences();
		for (final EObject eObject : references) {
			final EAnnotation occurrenceAnnotation = ((EModelElement) eObject).getEAnnotation(OCCURRENCE_TO_TICK_ANNOTATION);
			if (occurrenceAnnotation != null) {
				occurrenceAnnotation.getReferences().remove(tickNode);
			}
		}
		tickEAnnotation.getReferences().clear();
	}

	public static Node getAssociatedOccurrenceView(final View tickView) {
		checkTickView(tickView);
		final EAnnotation eAnnotation = tickView.getEAnnotation(TICK_TO_OCCURRENCE_ANNOTATION);
		if (eAnnotation != null) {
			final EList<EObject> references = eAnnotation.getReferences();
			if (references.isEmpty()) {
				throw new IllegalStateException("A tick must be associated to one occurrence"); //$NON-NLS-1$
			}
			if (references.size() > 1) {
				throw new IllegalStateException("A tick can be associated to only one occurrence"); //$NON-NLS-1$
			}
			final EObject eObject = references.get(0);
			if (eObject instanceof Node) {
				final Node node = (Node) eObject;
				checkOccurrenceSpecificationView(node);
				return node;
			}
			throw new IllegalStateException("A tick must be associated to an occurrence View"); //$NON-NLS-1$
		}
		return null;
	}

	public static List<Node> getAssociatedTickViews(final View occurrenceView) {
		final List<Node> result = new ArrayList<Node>();
		checkOccurrenceSpecificationView(occurrenceView);
		final EAnnotation eAnnotation = occurrenceView.getEAnnotation(OCCURRENCE_TO_TICK_ANNOTATION);
		if (eAnnotation != null) {
			final EList<EObject> references = eAnnotation.getReferences();
			for (final EObject eObject : references) {
				if (eObject instanceof Node) {
					final Node node = (Node) eObject;
					checkTickView(node);
					result.add(node);
				} else {
					throw new IllegalStateException("Expecting only tick Nodes"); //$NON-NLS-1$
				}
			}
		}
		return result;
	}

	public static IGraphicalEditPart findOccurrenceSpecificationEditPartFromTickEditPart(final TickEditPart tickEditPart, final EditPartViewer viewer) {
		if (tickEditPart != null) {
			final Node tickNode = (Node) tickEditPart.getModel();
			final Node occurrenceView = TickUtils.getAssociatedOccurrenceView(tickNode);
			if (occurrenceView != null) {
				final IGraphicalEditPart occurrenceSpecificationEditPart = (IGraphicalEditPart) viewer.getEditPartRegistry().get(occurrenceView);
				if (occurrenceSpecificationEditPart != null) {
					return occurrenceSpecificationEditPart;
				}
			}
		}
		return null;
	}

	public static boolean containsTickFor(final View parentView, final OccurrenceSpecification occurrenceSpecification) {
		@SuppressWarnings("unchecked")
		final EList<View> children = parentView.getChildren();
		for (final View child : children) {
			checkTickView(child);
			final Node occurrenceView = TickUtils.getAssociatedOccurrenceView(child);
			if (occurrenceView != null) {
				final EObject element = occurrenceView.getElement();
				if (element == occurrenceSpecification) {
					return true;
				}
			}
		}
		return false;
	}

	private static EAnnotation getOrCreateTickEAnnotation(final View tickView) {
		checkTickView(tickView);
		EAnnotation eAnnotation = tickView.getEAnnotation(TICK_TO_OCCURRENCE_ANNOTATION);
		if (eAnnotation == null) {
			eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource(TICK_TO_OCCURRENCE_ANNOTATION);
			tickView.getEAnnotations().add(eAnnotation);
		}
		return eAnnotation;
	}

	private static EAnnotation getOrCreateOccurrenceEAnnotation(final View occurrenceView) {
		checkOccurrenceSpecificationView(occurrenceView);
		EAnnotation eAnnotation = occurrenceView.getEAnnotation(OCCURRENCE_TO_TICK_ANNOTATION);
		if (eAnnotation == null) {
			eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			eAnnotation.setSource(OCCURRENCE_TO_TICK_ANNOTATION);
			occurrenceView.getEAnnotations().add(eAnnotation);
		}
		return eAnnotation;
	}

	private static void checkTickView(final View tickView) {
		if (!Integer.toString(TickEditPart.VISUAL_ID).equals(tickView.getType())) {
			throw new IllegalArgumentException("The parameter must be a tick View (id = " + TickEditPart.VISUAL_ID + "). The id was " + tickView.getType()); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	private static void checkOccurrenceSpecificationView(final View occurrenceSpecificationView) {
		if (!Integer.toString(OccurrenceSpecificationEditPartCN.VISUAL_ID).equals(occurrenceSpecificationView.getType())
				&& !Integer.toString(MessageOccurrenceSpecificationEditPartCN.VISUAL_ID).equals(occurrenceSpecificationView.getType())
				&& !Integer.toString(DestructionOccurrenceSpecificationEditPartCN.VISUAL_ID).equals(occurrenceSpecificationView.getType())) {
			throw new IllegalArgumentException("The parameter must be an Occurrencespecification View. The id was " + occurrenceSpecificationView.getType()); //$NON-NLS-1$ 
		}
	}
}
