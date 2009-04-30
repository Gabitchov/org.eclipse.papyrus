/***************************************************************************
 * Copyright (c) 2007-2009 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Francisco Javier Cano Muñoz (Prodevelop) - initial API and implementation
 *  Marc Gil Sendra (Prodevelop)
 * 
 *
 ******************************************************************************/

package org.eclipse.papyrus.diagram.activity.edit.policies;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.edit.commands.ActivityPartitionViewAlignerCommand;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityPartition2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityPartitionEditPart;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.uml2.uml.ActivityPartition;

/**
 * The Class ActivityXYLayoutEditPolicy.
 */
public class ActivityXYLayoutEditPolicy extends XYLayoutEditPolicy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy#getCommand(org.eclipse.gef.Request)
	 */
	@Override
	public Command getCommand(Request request) {

		// element moved
		if (request instanceof ChangeBoundsRequest) {
			ChangeBoundsRequest chr = (ChangeBoundsRequest) request;

			// if the element to move is a Label, deny it
			for (Object o : chr.getEditParts()) {
				if (o instanceof LabelEditPart)
					return UnexecutableCommand.INSTANCE;
			}
			
			for (Iterator<EditPart> it = chr.getEditParts().iterator(); it
					.hasNext();) {
				EditPart ep = it.next();

				if (((View) ep.getModel()).getElement() instanceof ActivityPartition) {
					GraphicalEditPart apep = (GraphicalEditPart) ep;

					TransactionalEditingDomain editingDomain;
					String label = "Move or resize ActivityPartition";
					Rectangle boundsDelta;

					editingDomain = apep.getEditingDomain();
					boundsDelta = new Rectangle(chr.getMoveDelta().x, chr
							.getMoveDelta().y, chr.getSizeDelta().width, chr
							.getSizeDelta().height);
					Command superCommand = super.getCommand(request);
					if (superCommand != null) {
						superCommand = superCommand
								.chain(new ICommandProxy(
										new ActivityPartitionViewAlignerCommand(
												editingDomain, label, ep,
												boundsDelta)));
					}

					return superCommand;
				}
			}
		}

		// element and view creation
		if (request instanceof CreateViewAndElementRequest) {
			GraphicalEditPart host = (GraphicalEditPart) getHost();

			CreateElementRequest createElementRequest = (CreateElementRequest) ((CreateViewAndElementRequest) request)
					.getViewAndElementDescriptor()
					.getCreateElementRequestAdapter().getAdapter(
							CreateElementRequest.class);

			IAdaptable adaptableToView = ((CreateViewAndElementRequest) request)
					.getViewAndElementDescriptor();
			Point location = ((CreateViewAndElementRequest) request)
					.getLocation();

			if (!createElementRequest.getElementType().equals(
					UMLElementTypes.ActivityPartition_2031)
					&& !createElementRequest.getElementType().equals(
							UMLElementTypes.ActivityPartition_2030)) {
				((CreateViewAndElementRequest) request)
						.setLocation(adaptLocationToVisibleRegion(host,
								((CreateViewAndElementRequest) request)
										.getLocation()));
				return new ICommandProxy(new SetBoundsCommand(host
						.getEditingDomain(), "Set Element initial location",
						adaptableToView, adaptLocationToVisibleRegion(host,
								location)));
			}

			Rectangle bounds = getActivityPartitionBounds(host,
					((CreateViewAndElementRequest) request).getLocation());
			if (bounds != null) {
				SetBoundsCommand setBoundsCommand = new SetBoundsCommand(host
						.getEditingDomain(),
						"Set ActivityPartition initial Location",
						adaptableToView, bounds);
				return new ICommandProxy(setBoundsCommand);
			}
		}

		// view creation
		if (request instanceof CreateViewRequest) {
			GraphicalEditPart host = (GraphicalEditPart) getHost();

			CreateViewRequest createViewRequest = (CreateViewRequest) request;
			ViewDescriptor viewDescriptor = createViewRequest
					.getViewDescriptors().size() > 0 ? ((ViewDescriptor) createViewRequest
					.getViewDescriptors().get(0))
					: null;
			if (viewDescriptor == null) {
				return super.getCommand(request);
			}
			Object adapted = viewDescriptor.getElementAdapter().getAdapter(
					EObject.class);
			if (adapted instanceof EObject == false) {
				return super.getCommand(request);
			}
			int elementType = UMLVisualIDRegistry.getNodeVisualID(host
					.getNotationView(), (EObject) adapted);
			if (elementType != ActivityPartitionEditPart.VISUAL_ID
					&& elementType != ActivityPartition2EditPart.VISUAL_ID) {
				createViewRequest.setLocation(adaptLocationToVisibleRegion(
						host, createViewRequest.getLocation()));
				return new ICommandProxy(new SetBoundsCommand(host
						.getEditingDomain(), "Set Element initial location",
						viewDescriptor, adaptLocationToVisibleRegion(host,
								createViewRequest.getLocation())));
			}

			Rectangle bounds = getActivityPartitionBounds(host,
					createViewRequest.getLocation());
			if (bounds != null) {
				SetBoundsCommand setBoundsCommand = new SetBoundsCommand(host
						.getEditingDomain(),
						"Set ActivityPartition initial Location",
						viewDescriptor, bounds);
				return new ICommandProxy(setBoundsCommand);
			}
		}

		// delete partition by keyboard
		if (RequestConstants.REQ_DELETE.equals(request.getType())) {
			GroupRequest groupRequest = (GroupRequest) request;
			// check that there are any EditParts selected.
			if (groupRequest.getEditParts() != null
					&& groupRequest.getEditParts().size() > 0) {

				for (Iterator<EditPart> it = this.getHost().getChildren()
						.iterator(); it.hasNext();) {
					EditPart ep = it.next();

					// if the ActivityPartition selected is the same of the
					// recent
					// element, continue with the next
					if (ep.equals(groupRequest.getEditParts().get(0)))
						continue;

					if (ep instanceof ActivityPartitionEditPart
							|| ep instanceof ActivityPartition2EditPart) {
						GraphicalEditPart apep = (GraphicalEditPart) ep;

						TransactionalEditingDomain editingDomain;
						String label = "Move or resize ActivityPartition";
						Rectangle boundsDelta;

						editingDomain = apep.getEditingDomain();
						boundsDelta = new Rectangle(0, 0, 0, 0);
						EditPart epart = (EditPart) groupRequest.getEditParts()
								.get(0);
						View v = (View) epart.getModel();
						EObject e = v.getElement();

						return new ICommandProxy(
								new ActivityPartitionViewAlignerCommand(
										editingDomain, label, ep, boundsDelta));
					}
				}
			}
		}

		// delete partition by context menu
		if (request instanceof EditCommandRequestWrapper
				&& ((EditCommandRequestWrapper) request)
						.getEditCommandRequest() instanceof DestroyElementRequest) {
			EditCommandRequestWrapper ecrw = (EditCommandRequestWrapper) request;
			DestroyElementRequest der = (DestroyElementRequest) ecrw
					.getEditCommandRequest();

			for (Iterator<EditPart> it = this.getHost().getChildren()
					.iterator(); it.hasNext();) {
				EditPart ep = it.next();

				if (der.getElementToDestroy() != null
						&& ((ep instanceof ActivityPartitionEditPart && !((ActivityPartitionEditPart) ep)
								.resolveSemanticElement().equals(
										der.getElementToDestroy())))
						|| (ep instanceof ActivityPartition2EditPart && !((ActivityPartition2EditPart) ep)
								.resolveSemanticElement().equals(
										der.getElementToDestroy()))) {
					GraphicalEditPart apep = (GraphicalEditPart) ep;

					TransactionalEditingDomain editingDomain;
					String label = "Move or resize ActivityPartition";
					Rectangle boundsDelta;

					editingDomain = apep.getEditingDomain();
					boundsDelta = new Rectangle(0, 0, 0, 0);
					return new ICommandProxy(
							new ActivityPartitionViewAlignerCommand(
									editingDomain, label, ep, boundsDelta));
				}
				if (der.getElementToDestroy() == null
						&& ep instanceof ActivityPartitionEditPart) {
					GraphicalEditPart apep = (GraphicalEditPart) ep;

					TransactionalEditingDomain editingDomain;
					String label = "Move or resize ActivityPartition";
					Rectangle boundsDelta;

					editingDomain = apep.getEditingDomain();
					boundsDelta = new Rectangle(0, 0, 0, 0);
					return new ICommandProxy(
							new ActivityPartitionViewAlignerCommand(
									editingDomain, label, ep, boundsDelta));
				}
			}
		}

		Command command = super.getCommand(request);
		return command;
	}

	/**
	 * Adapt location to visible region.
	 * 
	 * @param host
	 *            the host
	 * @param bounds
	 *            the bounds
	 * 
	 * @return the point
	 */

	private Point adaptLocationToVisibleRegion(GraphicalEditPart host,
			Point bounds) {
		Point newBounds = new Point();

		Point hostPoint = host.getFigure().getBounds().getTopLeft().getCopy();
		host.getFigure().translateToAbsolute(hostPoint);
		Rectangle hostBounds = host.getFigure().getBounds();

		newBounds.x = bounds.x - hostPoint.x;
		newBounds.y = bounds.y - hostPoint.y;

		if (newBounds.x < 0)
			newBounds.x = 0;
		if (newBounds.y < 0)
			newBounds.y = 0;
		if (newBounds.x >= hostBounds.width)
			newBounds.x = hostBounds.width - (int) (hostBounds.width * 0.2);
		if (newBounds.y >= hostBounds.height)
			newBounds.y = hostBounds.height - (int) (hostBounds.height * 0.2);

		return newBounds;
	}

	/**
	 * Gets the activity partition bounds.
	 * 
	 * @param host
	 *            the host
	 * @param location
	 *            the location
	 * 
	 * @return the activity partition bounds
	 */
	private Rectangle getActivityPartitionBounds(GraphicalEditPart host,
			Point location) {
		List<GraphicalEditPart> sortedPartitions = SortActivitiesPartitionsByX(getAllActivityPartitions(host));

		Rectangle bounds = new Rectangle();

		if (sortedPartitions.size() <= 0) {
			Point adaptedBounds = adaptLocationToVisibleRegion(host, location);
			bounds.x = adaptedBounds.x;
			bounds.y = adaptedBounds.y;
			bounds.width = -1;
			bounds.height = -1;
		} else {
			GraphicalEditPart last = sortedPartitions.get(sortedPartitions
					.size() - 1);
			Rectangle lastBounds = last.getFigure().getBounds();

			bounds.x = lastBounds.x + lastBounds.width;
			bounds.y = lastBounds.y;
			bounds.height = lastBounds.height;
			bounds.width = lastBounds.width <= 200 ? lastBounds.width : 200;
		}

		return bounds;
	}

	/**
	 * Gets the all activity partitions.
	 * 
	 * @param apep
	 *            the apep
	 * 
	 * @return the all activity partitions
	 */
	private List<GraphicalEditPart> getAllActivityPartitions(
			GraphicalEditPart apep) {

		List<GraphicalEditPart> activities = new LinkedList<GraphicalEditPart>();
		for (Iterator<EditPart> it = apep.getChildren().iterator(); it
				.hasNext();) {
			EditPart ep = it.next();
			if (((View) ep.getModel()).getElement() instanceof ActivityPartition) {
				activities.add((GraphicalEditPart) ep);
			}
		}

		return activities;
	}

	/**
	 * Sort activities partitions by x.
	 * 
	 * @param activities
	 *            the activities
	 * 
	 * @return the list< graphical edit part>
	 */
	private List<GraphicalEditPart> SortActivitiesPartitionsByX(
			List<GraphicalEditPart> activities) {
		// Compare two ActivityPartitionEditParts by their x coordinate
		Comparator<GraphicalEditPart> comp = new Comparator<GraphicalEditPart>() {

			public int compare(GraphicalEditPart o1, GraphicalEditPart o2) {

				int o1x, o2x;
				o1x = o1.getFigure().getBounds().x;
				o2x = o2.getFigure().getBounds().x;

				if (o1x > o2x) {
					return 1;
				} else if (o1x < o2x) {
					return -1;
				}

				return 0;
			}

		};

		GraphicalEditPart[] activitiesArray = new GraphicalEditPart[activities
				.size()];
		activities.toArray(activitiesArray);

		Arrays.sort(activitiesArray, comp);

		List<GraphicalEditPart> sortedActivities = new LinkedList<GraphicalEditPart>();

		for (GraphicalEditPart ap : activitiesArray) {
			sortedActivities.add(ap);
		}

		return sortedActivities;
	}
}
