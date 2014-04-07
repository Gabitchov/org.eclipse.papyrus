/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.statemachine.custom.commands;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.helpers.Zone;

public class CustomRegionMoveCommand extends AbstractTransactionalCommand {


	IAdaptable adaptableForTargetRegion;

	IAdaptable adaptableForRegionToMove;

	String dropLocation = Zone.RIGHT;

	PreferencesHint prefHints;

	CreateViewRequest.ViewDescriptor viewDescriptor;


	public CustomRegionMoveCommand(IAdaptable adaptableForTargetRegion, IAdaptable adaptableForRegionToMove, PreferencesHint prefHints, TransactionalEditingDomain domain, String label, String dropLocation) {
		super(domain, label, null);
		this.adaptableForTargetRegion = adaptableForTargetRegion;
		this.adaptableForRegionToMove = adaptableForRegionToMove;
		this.prefHints = prefHints;

		viewDescriptor = new ViewDescriptor(adaptableForRegionToMove, prefHints);

		// make sure the return object is available even before
		// executing/undoing/redoing
		setResult(CommandResult.newOKCommandResult(viewDescriptor));

		this.dropLocation = dropLocation;
	}

	/*
	 * Essentially performs a resize of the region to be removed so that
	 * neighbouring regions are updated accordingly, then resets the zone of
	 * neighbouring regions and finally remove the region
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		// adapt the view of the existing region
		View targetRegion = (View)adaptableForTargetRegion.getAdapter(View.class);
		// adapt the view of the dropped region
		View regionToMove = (View)adaptableForRegionToMove.getAdapter(View.class);

		// manage the fake removal of regionToMove
		View compartment = (View)regionToMove.eContainer();
		if(compartment.getChildren().size() != 1) {
			int regionWidth = Zone.getWidth(regionToMove);
			int regionHeight = Zone.getHeight(regionToMove);

			String s = Zone.getZone(regionToMove);
			List<View> neighbours = null;
			if(Zone.isRight(s)) {
				neighbours = Zone.getRegionLeftBorderOutsideNeighbours(regionToMove);
				Iterator<View> it = neighbours.iterator();
				while(it.hasNext()) {
					View view = it.next();
					// for each of these we add regionWidth to their width
					int width = Zone.getWidth(view);
					width += regionWidth;
					Zone.setWidth(view, width);
				}
			} else if(Zone.isLeft(s)) {
				neighbours = Zone.getRegionRightBorderOutsideNeighbours(regionToMove);
				Iterator<View> it = neighbours.iterator();
				while(it.hasNext()) {
					View view = it.next();
					// for each of these we add regionWidth to their width and
					// translate their x of
					// -regionWidth
					int width = Zone.getWidth(view);
					width += regionWidth;
					Zone.setWidth(view, width);
					int x = Zone.getX(view);
					x -= regionWidth;
					Zone.setX(view, x);
				}
			} else if(Zone.isTop(s)) {
				neighbours = Zone.getRegionBottomBorderOutsideNeighbours(regionToMove);
				Iterator<View> it = neighbours.iterator();
				while(it.hasNext()) {
					View view = it.next();
					// for each of these we add regionHeight to their height and
					// -regionHeight to their
					// y
					int height = Zone.getHeight(view);
					height += regionHeight;
					Zone.setHeight(view, height);
					int y = Zone.getY(view);
					y -= regionHeight;
					Zone.setY(view, y);
				}
			} else if(Zone.isBottom(s)) {
				neighbours = Zone.getRegionTopBorderOutsideNeighbours(regionToMove);
				Iterator<View> it = neighbours.iterator();
				while(it.hasNext()) {
					View view = it.next();
					// for each of these we add regionHeight to their height
					int height = Zone.getHeight(view);
					height += regionHeight;
					Zone.setHeight(view, height);
				}
			}

			// set the zone accordingly
			// get its counterpart
			Zone.resetRegionCounterpartZone(regionToMove);
		}

		// now perform the move
		// get targetRegion bounds (i.e. the space which needs to be divided)
		int height = Zone.getHeight(targetRegion);
		int width = Zone.getWidth(targetRegion);
		int x = Zone.getX(targetRegion);
		int y = Zone.getY(targetRegion);

		// the test itself and change of bounds
		if(Zone.isRight(dropLocation)) {
			// the new region zone should reflect that of other branch
			Zone.copyZone(targetRegion, regionToMove);
			// now set new region as RIGHT
			Zone.setRight(regionToMove);
			// and existing region to LEFT
			Zone.setLeft(targetRegion);

			// shrink width of existing region
			width *= 0.5;
			Zone.setWidth(targetRegion, width);
			// new region will have same height and width
			Zone.setWidth(regionToMove, width);
			Zone.setHeight(regionToMove, height);

			// set new region to location (x+width,y) (existing region is not
			// moved)
			Zone.setX(regionToMove, x + width);
			Zone.setY(regionToMove, y);
		} else if(Zone.isLeft(dropLocation)) {
			// the new region zone should reflect that of existing region
			Zone.copyZone(targetRegion, regionToMove);
			// now set new region as LEFT
			Zone.setLeft(regionToMove);
			// and existing region to RIGHT
			Zone.setRight(targetRegion);

			// shrink width of existing region
			width *= 0.5;
			Zone.setWidth(targetRegion, width);
			// new region will have same height and width
			Zone.setWidth(regionToMove, width);
			Zone.setHeight(regionToMove, height);

			// set existing region to location (x+width,y) and new region at
			// (x,y)
			Zone.setX(targetRegion, x + width);
			Zone.setX(regionToMove, x);
			Zone.setY(regionToMove, y);
		} else if(Zone.isBottom(dropLocation)) {
			// the new region zone should reflect that of existing region
			Zone.copyZone(targetRegion, regionToMove);
			// now set new region as BOTTOM
			Zone.setBottom(regionToMove);
			// and existing region to TOP
			Zone.setTop(targetRegion);

			// shrink height of existing region
			height *= 0.5;
			Zone.setHeight(targetRegion, height);
			// new region will have same height and width
			Zone.setWidth(regionToMove, width);
			Zone.setHeight(regionToMove, height);

			// set new region to location (x,y+height) (existing region is not
			// moved)
			Zone.setX(regionToMove, x);
			Zone.setY(regionToMove, y + height);
		} else if(Zone.isTop(dropLocation)) {
			// the new region zone should reflect that of existing region
			Zone.copyZone(targetRegion, regionToMove);
			// now set new region as TOP
			Zone.setTop(regionToMove);
			// and existing region to BOTTOM
			Zone.setBottom(targetRegion);

			// shrink height of existing region
			height *= 0.5;
			Zone.setHeight(targetRegion, height);
			// new region will have same height and width
			Zone.setWidth(regionToMove, width);
			Zone.setHeight(regionToMove, height);

			// set existing region to location (x,y+height) and new region at
			// (x,y)
			Zone.setY(targetRegion, y + height);
			Zone.setX(regionToMove, x);
			Zone.setY(regionToMove, y);
		}
		viewDescriptor.setView(regionToMove);

		return CommandResult.newOKCommandResult();
	}
}
