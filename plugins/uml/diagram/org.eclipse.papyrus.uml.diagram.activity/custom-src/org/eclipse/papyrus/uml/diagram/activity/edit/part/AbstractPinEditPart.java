package org.eclipse.papyrus.uml.diagram.activity.edit.part;

import org.eclipse.draw2d.AbstractPointListShape;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ControlFlowEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ObjectFlowEditPart;
import org.eclipse.papyrus.uml.diagram.activity.figures.PinFigure;
import org.eclipse.papyrus.uml.diagram.activity.helper.ActivityFigureDrawer;


public abstract class AbstractPinEditPart  extends BorderedBorderItemEditPart {

	public AbstractPinEditPart(View view) {
		super(view);
	}
	
	/**
	 * Notifies listeners that a target connection has been added.
	 * 
	 * @param connection
	 *        <code>ConnectionEditPart</code> being added as child.
	 * @param index
	 *        Position child is being added into.
	 */
	@Override
	protected void fireTargetConnectionAdded(ConnectionEditPart connection, int index) {
		super.fireTargetConnectionAdded(connection, index);
		// undraw the pin arrow
		if(connection instanceof ObjectFlowEditPart || connection instanceof ControlFlowEditPart) {
			PinFigure pinFigure = getPrimaryShape();
			AbstractPointListShape arrow = pinFigure.getOptionalArrowFigure();
			ActivityFigureDrawer.undrawFigure(arrow);
		}
	}
	
	/**
	 * Notifies listeners that a target connection has been removed.
	 * 
	 * @param connection
	 *        <code>ConnectionEditPart</code> being added as child.
	 * @param index
	 *        Position child is being added into.
	 */
	@Override
	protected void fireRemovingTargetConnection(ConnectionEditPart connection, int index) {
		super.fireRemovingTargetConnection(connection, index);
		// redraw the pin arrow if no other target connection left
		boolean hasActivityEdge = false;
		for(Object connect : getTargetConnections()) {
			if(!connection.equals(connect) && (connect instanceof ObjectFlowEditPart || connect instanceof ControlFlowEditPart)) {
				hasActivityEdge = true;
				break;
			}
		}
		if(!hasActivityEdge) {
			PinFigure pinFigure = getPrimaryShape();
			AbstractPointListShape arrow = pinFigure.getOptionalArrowFigure();
			int side = getBorderItemLocator().getCurrentSideOfParent();
			int direction = ActivityFigureDrawer.getOppositeDirection(side);
			ActivityFigureDrawer.redrawPinArrow(arrow, getMapMode(), getSize(), direction);
		}
	}
	
	public abstract PinFigure getPrimaryShape();
	
	/**
	 * Registers this editpart to recieve notation and semantic events.
	 * 
	 */
	@Override
	public void activate() {
		super.activate();
		// redraw the pin arrow if no connection
		boolean hasActivityEdge = false;
		for(Object connection : getTargetConnections()) {
			if(connection instanceof ObjectFlowEditPart || connection instanceof ControlFlowEditPart) {
				hasActivityEdge = true;
				break;
			}
		}
		if(!hasActivityEdge) {
			PinFigure pinFigure = getPrimaryShape();
			AbstractPointListShape arrow = pinFigure.getOptionalArrowFigure();
			int side = getBorderItemLocator().getCurrentSideOfParent();
			int direction = ActivityFigureDrawer.getOppositeDirection(side);
			ActivityFigureDrawer.redrawPinArrow(arrow, getMapMode(), getSize(), direction);
		}
	}
}
