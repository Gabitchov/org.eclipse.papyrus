/*****************************************************************************
 * Copyright (c) 2010-2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 
 * Ansgar Radermacher: Bug 402254: Height changes after first resize
 * 
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.statemachine.custom.commands;

import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.helpers.Zone;

public class CustomStateResizeCommand extends AbstractTransactionalCommand {

	CreateViewRequest.ViewDescriptor viewDescriptor;

	IAdaptable adaptable;

	PreferencesHint prefHints;

	/**
	 * The request to perform.
	 */
	private ChangeBoundsRequest request = null;

	/**
	 * The bounds rectangle.
	 */
	private Rectangle bounds = null;

	private boolean internalResize = false;

	public CustomStateResizeCommand(IAdaptable adaptable, PreferencesHint prefHints, TransactionalEditingDomain domain, String label, ChangeBoundsRequest request, Rectangle bounds, boolean internalResize) {
		super(domain, label, null);

		this.adaptable = adaptable;
		this.prefHints = prefHints;

		this.request = request;
		this.bounds = bounds;

		this.internalResize = internalResize;

		viewDescriptor = new ViewDescriptor(adaptable, prefHints);

		// make sure the return object is available even before
		// executing/undoing/redoing
		setResult(CommandResult.newOKCommandResult(viewDescriptor));

	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		View state = (View)adaptable.getAdapter(View.class);
		View stateLabel = (View)state.getChildren().get(0);
		View stateCompartment = (View)state.getChildren().get(1);

		// a bunch of initializations
		int direction = request.getResizeDirection();
		int dx = request.getSizeDelta().width;
		int dy = request.getSizeDelta().height;

		Iterator<Node> it = state.getChildren().iterator();

		while(it.hasNext()) {
			Node currentNode = it.next();
			if(currentNode.getLayoutConstraint() == null) {
				currentNode.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
			}
		}

		if(internalResize) {
			Zone.setHeight(stateLabel, Zone.getHeight(stateLabel) + dy);
			// dy = 0;
		}
		// first resize the state node with the constraint provided
		Zone.setBounds(state, bounds);
		// resize label and compartment
		Zone.setWidth(stateLabel, bounds.width);
		Zone.setWidth(stateCompartment, bounds.width);
		if(Zone.getHeight(stateLabel) != -1) {
			//only set height of state-compartment, if height is of label is already initialized assigned (bug 402254)
			Zone.setHeight(stateCompartment, bounds.height - Zone.getHeight(stateLabel));
		}
		Zone.setY(stateCompartment, Zone.getHeight(stateLabel));

		if(internalResize && (dx == 0))
			return CommandResult.newOKCommandResult();

		// one region displayed case
		if(stateCompartment.getChildren().size() == 1) {
			// we need to resize the region
			View defaultRegion = (View)stateCompartment.getChildren().get(0);
			Zone.setWidth(defaultRegion, Zone.getWidth(stateCompartment));
			Zone.setHeight(defaultRegion, Zone.getHeight(stateCompartment));
			return CommandResult.newOKCommandResult();

		}

		// multiple region case

		// test the direction of resize
		// the processing depends on the direction
		// basically embedded nodes to be either scaled and/or translated along
		// one or two axis
		// depending on their relative positions to the borders of the state
		// machine
		it = stateCompartment.getChildren().iterator();
		while(it.hasNext()) {
			View view = (View)it.next();
			String zone = Zone.getZone(view);
			switch(direction) {
			case PositionConstants.WEST:
				// we test whether the current node is close to the outer LEFT
				// border
				// this is the case if it has no LEFT neighbors at all
				if(!Zone.hasLeftNeighbours(zone)) {
					// these nodes need to be scaled
					// we add dx to their width
					int width = Zone.getWidth(view);
					width += dx;
					Zone.setWidth(view, width);
				} else {
					// in other cases the node needs to be translated
					// for each of these we translate their x of dx
					int x = Zone.getX(view);
					x += dx;
					Zone.setX(view, x);
				}
				break;
			case PositionConstants.EAST:
				// we test whether the current node is close to the outer RIGHT
				// border
				// this is the case if it has no RIGHT neighbours at all
				if(!Zone.hasRightNeighbours(zone)) {
					// these nodes need to be scaled
					// we add dx to their width
					int width = Zone.getWidth(view);
					width += dx;
					Zone.setWidth(view, width);
				}
				break;
			case PositionConstants.NORTH:
				// we test whether the current node is close to the outer TOP
				// border
				// this is the case if it has no TOP neighbours at all
				if(!Zone.hasTopNeighbours(zone)) {
					// these nodes need to be scaled
					// we add dy to their height
					int height = Zone.getHeight(view);
					height += dy;
					Zone.setHeight(view, height);
				} else {
					// in other cases the node needs to be translated
					// for each of these we translate their y of dy
					int y = Zone.getY(view);
					y += dy;
					Zone.setY(view, y);
				}
				break;
			case PositionConstants.SOUTH:
				// we test whether the current node is close to the outer BOTTOM
				// border
				// this is the case if it has no BOTTOM neighbours at all
				if(!Zone.hasBottomNeighbours(zone)) {
					// these nodes need to be scaled
					// we add dy to their height
					int height = Zone.getHeight(view);
					height += dy;
					Zone.setHeight(view, height);
				}
				break;
			case PositionConstants.NORTH_WEST:
				// we test whether the current node is close to the outer TOP
				// and LEFT borders
				// this is the case if it has no LEFT neighbours nor TOP
				// neighbours at all
				if(!Zone.hasLeftNeighbours(zone) && !Zone.hasTopNeighbours(zone)) {
					// for each of these we add dx to their width and dy to
					// their height
					int width = Zone.getWidth(view);
					width += dx;
					Zone.setWidth(view, width);
					int height = Zone.getHeight(view);
					height += dy;
					Zone.setHeight(view, height);
				}
				// the second case is when it has no LEFT neighbours but TOP
				// ones, i.e. close to
				// LEFT border only
				else if(!Zone.hasLeftNeighbours(zone) && Zone.hasTopNeighbours(zone)) {
					// for each of these we add dx to their width and translate
					// their y of dy
					int width = Zone.getWidth(view);
					width += dx;
					Zone.setWidth(view, width);
					int y = Zone.getY(view);
					y += dy;
					Zone.setY(view, y);
				}
				// in the reverse case, i.e. close to TOP border only
				else if(Zone.hasLeftNeighbours(zone) && !Zone.hasTopNeighbours(zone)) {
					// for each of these we add dy to their height and translate
					// their x of dx
					int height = Zone.getHeight(view);
					height += dy;
					Zone.setHeight(view, height);
					int x = Zone.getX(view);
					x += dx;
					Zone.setX(view, x);
				} else {
					// in other cases the node needs to be translated both ways
					// for each of these we translate their x of dx and their y
					// of dy
					int x = Zone.getX(view);
					x += dx;
					Zone.setX(view, x);
					int y = Zone.getY(view);
					y += dy;
					Zone.setY(view, y);
				}
				break;
			case PositionConstants.NORTH_EAST:
				// we test whether the current node is close to the outer TOP
				// and RIGHT borders
				// this is the case if it has no RIGHT neighbours nor TOP
				// neigbours at all
				if(!Zone.hasRightNeighbours(zone) && !Zone.hasTopNeighbours(zone)) {
					// for each of these we add dx to their width and dy to
					// their height
					int width = Zone.getWidth(view);
					width += dx;
					Zone.setWidth(view, width);
					int height = Zone.getHeight(view);
					height += dy;
					Zone.setHeight(view, height);
				}
				// the second case is when it has no RIGHT neighbours but TOP
				// ones, i.e. close
				// to RIGHT border only
				else if(!Zone.hasRightNeighbours(zone) && Zone.hasTopNeighbours(zone)) {
					// for each of these we add dx to their width and translate
					// their y of dy
					int width = Zone.getWidth(view);
					width += dx;
					Zone.setWidth(view, width);
					int y = Zone.getY(view);
					y += dy;
					Zone.setY(view, y);
				}
				// in the reverse case, i.e. close to TOP border only
				else if(Zone.hasRightNeighbours(zone) && !Zone.hasTopNeighbours(zone)) {
					// for each of these we add dy to their height
					int height = Zone.getHeight(view);
					height += dy;
					Zone.setHeight(view, height);
				} else {
					// in other cases the node needs to be translated along Y
					// for each of these we translate their y of dy
					int y = Zone.getY(view);
					y += dy;
					Zone.setY(view, y);
				}
				break;
			case PositionConstants.SOUTH_WEST:
				// we test whether the current node is close to the outer BOTTOM
				// and LEFT
				// borders
				// this is the case if it has no LEFT neighbours nor BOTTOM
				// neigbours at all
				if(!Zone.hasLeftNeighbours(zone) && !Zone.hasBottomNeighbours(zone)) {
					// for each of these we add dx to their width and dy to
					// their height
					int width = Zone.getWidth(view);
					width += dx;
					Zone.setWidth(view, width);
					int height = Zone.getHeight(view);
					height += dy;
					Zone.setHeight(view, height);
				}
				// the second case is when it has no LEFT neighbours but BOTTOM
				// ones, i.e. close
				// to LEFT border only
				else if(!Zone.hasLeftNeighbours(zone) && Zone.hasBottomNeighbours(zone)) {
					// for each of these we add dx to their width
					int width = Zone.getWidth(view);
					width += dx;
					Zone.setWidth(view, width);
				}
				// in the reverse case, i.e. close to BOTTOM border only
				else if(Zone.hasLeftNeighbours(zone) && !Zone.hasBottomNeighbours(zone)) {
					// for each of these we add dy to their height and translate
					// their x of dx
					int height = Zone.getHeight(view);
					height += dy;
					Zone.setHeight(view, height);
					int x = Zone.getX(view);
					x += dx;
					Zone.setX(view, x);
				} else {
					// in other cases the node needs to be translated in X
					// for each of these we translate their x of dx
					int x = Zone.getX(view);
					x += dx;
					Zone.setX(view, x);
				}
				break;
			case PositionConstants.SOUTH_EAST:
				// we test whether the current node is close to the outer BOTTOM
				// and RIGHT
				// borders
				// this is the case if it has no RIGHT neighbors nor BOTTOM
				// neigbours at all
				if(!Zone.hasRightNeighbours(zone) && !Zone.hasBottomNeighbours(zone)) {
					// for each of these we add dx to their width and dy to
					// their height
					int width = Zone.getWidth(view);
					width += dx;
					Zone.setWidth(view, width);
					int height = Zone.getHeight(view);
					height += dy;
					Zone.setHeight(view, height);
				}
				// the second case is when it has no RIGHT neighbors but BOTTOM
				// ones, i.e.
				// close to RIGHT border only
				else if(!Zone.hasRightNeighbours(zone) && Zone.hasBottomNeighbours(zone)) {
					// for each of these we add dx to their width
					int width = Zone.getWidth(view);
					width += dx;
					Zone.setWidth(view, width);
				}
				// in the reverse case, i.e. close to BOTTOM border only
				else if(Zone.hasRightNeighbours(zone) && !Zone.hasBottomNeighbours(zone)) {
					// for each of these we add dy to their height
					int height = Zone.getHeight(view);
					height += dy;
					Zone.setHeight(view, height);
				}
				break;
			}// switch
		}// while
		return CommandResult.newOKCommandResult();
	}
}
