package org.eclipse.papyrus.uml.diagram.statemachine.custom.commands;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.helpers.Zone;

public class CustomRegionPreDeleteCommand extends DeleteCommand {

	public CustomRegionPreDeleteCommand(TransactionalEditingDomain editingDomain, View view) {
		super(editingDomain, view);
	}

	/*
	 * Was: Prevents the removal of the last region displayed in the state machine or composite state
	 * Restriction has been removed, see bug 424449 - [State machine diagram] state machine cannot be deleted
	 */
	@Override
	public boolean canExecute() {
		return true;
	}

	/*
	 * Essentially performs a resize of the region to be removed so that
	 * neighbouring regions are updated accordingly, then resets the zone of
	 * neighbouring regions
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		// get the region to delete
		View region = getView();
		View compartment = (View)region.eContainer();
		if(compartment.getChildren().size() != 1) {
			int regionWidth = Zone.getWidth(region);
			int regionHeight = Zone.getHeight(region);

			String s = Zone.getZone(region);
			List<View> neighbours = null;
			if(Zone.isRight(s)) {
				neighbours = Zone.getRegionLeftBorderOutsideNeighbours(region);
				Iterator<View> it = neighbours.iterator();
				while(it.hasNext()) {
					View view = it.next();
					// for each of these we add regionWidth to their width
					int width = Zone.getWidth(view);
					width += regionWidth;
					Zone.setWidth(view, width);
				}
			} else if(Zone.isLeft(s)) {
				neighbours = Zone.getRegionRightBorderOutsideNeighbours(region);
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
				neighbours = Zone.getRegionBottomBorderOutsideNeighbours(region);
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
				neighbours = Zone.getRegionTopBorderOutsideNeighbours(region);
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
			Zone.resetRegionCounterpartZone(region);
		}
		// ViewUtil.destroy(region);
		return CommandResult.newOKCommandResult();
	}
}
