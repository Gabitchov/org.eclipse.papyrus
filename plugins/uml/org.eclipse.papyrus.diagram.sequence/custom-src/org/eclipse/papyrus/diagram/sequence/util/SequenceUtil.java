/*****************************************************************************
 * Copyright (c) 2009 CEA
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
package org.eclipse.papyrus.diagram.sequence.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.draw2d.AbstractPointListShape;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.OccurrenceSpecification;


public class SequenceUtil {

	private static final double MAXIMAL_DISTANCE_FROM_EVENT = 10;

	/**
	 * Find the container interaction fragment at the given location.
	 * The elements are drawn under the lifeline, but their model container is an interaction fragment.
	 * It can be of type Interaction or InteractionOperand
	 * 
	 * @param location
	 *        the location
	 * @return the interaction fragment or null
	 */
	public static InteractionFragment findInteractionFragmentAt(Point location, EditPart host) {

		if(host == null) {
			return null;
		}

		List<IFigure> exclusionSet = new ArrayList<IFigure>();

		InteractionFragment interactionFragment = null;
		EditPart ep = host.getRoot().getViewer().findObjectAtExcluding(location, exclusionSet);
		while(ep instanceof LifelineEditPart || ep instanceof BehaviorExecutionSpecificationEditPart || ep instanceof ActionExecutionSpecificationEditPart) {
			exclusionSet.add(((GraphicalEditPart)ep).getFigure());
			ep = host.getRoot().getViewer().findObjectAtExcluding(location, exclusionSet);
		}
		// Get the rootEditpart Content
		if(ep != null && ep.getModel() instanceof View) {
			EObject eObject = ViewUtil.resolveSemanticElement((View)ep.getModel());
			if(eObject instanceof InteractionOperand || eObject instanceof Interaction) {
				interactionFragment = (InteractionFragment)eObject;
			}
		}

		return interactionFragment;
	}

	/**
	 * Find the occurrence specification covering the lifeline near the given location.
	 * If none is close enough, null is returned.
	 * 
	 * @param location
	 *        the location
	 * @param lifelineEditPart
	 *        the Lifeline edit part
	 * @return an entry with the nearest OccurrenceSpecification and its corresponding location or null if none is close enough
	 */
	public static Entry<OccurrenceSpecification, Point> findNearestEvent(Point location, LifelineEditPart lifelineEditPart) {
		if(lifelineEditPart == null) {
			return null;
		}
		// Map referencing children occurrences by their location on the lifeline.
		Map<OccurrenceSpecification, Point> occurrences = new HashMap<OccurrenceSpecification, Point>();
		// children executions
		List<?> children = lifelineEditPart.getChildren();
		for(Object child : children) {
			if(child instanceof ActionExecutionSpecificationEditPart || child instanceof BehaviorExecutionSpecificationEditPart) {
				EObject element = ((GraphicalEditPart)child).resolveSemanticElement();
				if(element instanceof ExecutionSpecification) {
					// find start and finish events of the execution
					Rectangle bounds = ((GraphicalEditPart)child).getFigure().getBounds().getCopy();
					lifelineEditPart.getFigure().translateToAbsolute(bounds);
					occurrences.put(((ExecutionSpecification)element).getStart(), bounds.getTop());
					occurrences.put(((ExecutionSpecification)element).getFinish(), bounds.getBottom());
				}
			}
		}
		// messages to the lifeline
		List<?> targetConnections = lifelineEditPart.getTargetConnections();
		for(Object conn : targetConnections) {
			if(conn instanceof ConnectionNodeEditPart) {
				EObject element = ((ConnectionNodeEditPart)conn).resolveSemanticElement();
				if(element instanceof Message && ((Message)element).getReceiveEvent() instanceof MessageOccurrenceSpecification) {
					// finish events of the message
					IFigure figure = ((ConnectionNodeEditPart)conn).getFigure();
					if(figure instanceof AbstractPointListShape) {
						Point end = ((AbstractPointListShape)figure).getEnd();
						occurrences.put((MessageOccurrenceSpecification)((Message)element).getReceiveEvent(), end);
					}
				}
			}
		}
		// messages from the lifeline
		List<?> sourceConnections = lifelineEditPart.getSourceConnections();
		for(Object conn : sourceConnections) {
			if(conn instanceof ConnectionNodeEditPart) {
				EObject element = ((ConnectionNodeEditPart)conn).resolveSemanticElement();
				if(element instanceof Message && ((Message)element).getSendEvent() instanceof MessageOccurrenceSpecification) {
					// start events of the message
					IFigure figure = ((ConnectionNodeEditPart)conn).getFigure();
					if(figure instanceof AbstractPointListShape) {
						Point start = ((AbstractPointListShape)figure).getStart();
						occurrences.put((MessageOccurrenceSpecification)((Message)element).getSendEvent(), start);
					}
				}
			}
		}

		// Find the nearest object within acceptable distance
		double smallerDistance = MAXIMAL_DISTANCE_FROM_EVENT;
		Entry<OccurrenceSpecification, Point> nearestObject = null;
		for(Entry<OccurrenceSpecification, Point> entry : occurrences.entrySet()) {
			double distance = location.getDistance(entry.getValue());
			if(distance < smallerDistance) {
				smallerDistance = distance;
				nearestObject = entry;
			}
		}

		return nearestObject;
	}
}
