/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.handles.ResizableHandleKit;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableCompartmentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.internal.handles.CompartmentResizeHandle;

/**
 * 
 * this class is used to display an handle and command to make a compartment
 * resizable by the user
 */
// @unused
public class CResizableCompartmentEditPolicy extends ResizableCompartmentEditPolicy {

	public CResizableCompartmentEditPolicy() {
		super(true);
	}

	/**
	 * use to create handle to see the small triangle to collapse a compartment
	 */
	protected void addCollapsableHandles() {
		removeSelectionHandles();
		IFigure layer = getLayer(LayerConstants.HANDLE_LAYER);
		handles = createCollapseHandles();
		for(int i = 0; i < handles.size(); i++) {
			layer.add((IFigure)handles.get(i));
		}
	}

	/**
	 * @see org.eclipse.gef.editpolicies.SelectionHandlesEditPolicy#createSelectionHandles()
	 */
	@Override
	protected List createSelectionHandles() {
		List selectionHandles = new ArrayList();
		IGraphicalEditPart part = (IGraphicalEditPart)getHost();
		int d1 = isHorizontal() ? PositionConstants.WEST : PositionConstants.NORTH;
		int d2 = isHorizontal() ? PositionConstants.EAST : PositionConstants.SOUTH;
		selectionHandles.addAll(createCollapseHandles());// add collapsable
		// handle
		selectionHandles.add(new CompartmentResizeHandle(part, d1));
		selectionHandles.add(new CompartmentResizeHandle(part, d2));
		// add resize handle in the south
		ResizableHandleKit.addHandle((GraphicalEditPart)getHost(), selectionHandles, PositionConstants.SOUTH);

		return selectionHandles;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected Command getResizeCommand(ChangeBoundsRequest request) {
		int indexOfTheLast = getHost().getParent().getChildren().size() - 1;
		ChangeBoundsRequest req = new ChangeBoundsRequest(REQ_RESIZE_CHILDREN);
		req.setEditParts(getHost());
		req.setMoveDelta(request.getMoveDelta());
		req.setSizeDelta(request.getSizeDelta());
		req.setLocation(request.getLocation());
		req.setExtendedData(request.getExtendedData());
		req.setResizeDirection(request.getResizeDirection());
		// if this is the last compartment the command is redirect to the parent
		if(getHost().getParent().getChildren().indexOf(getHost()) == indexOfTheLast) {
			req.setEditParts(getHost().getParent());
			return getHost().getParent().getParent().getCommand(req);
		} else {
			return getHost().getParent().getCommand(req);
		}

		// return super.getResizeCommand(request);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
		IFigure feedback = getDragSourceFeedbackFigure();

		PrecisionRectangle rect = new PrecisionRectangle(getInitialFeedbackBounds().getCopy());
		getHostFigure().translateToAbsolute(rect);
		rect.translate(request.getMoveDelta());
		rect.resize(request.getSizeDelta());

		feedback.translateToRelative(rect);
		feedback.setBounds(rect);
	}

	/**
	 * @see org.eclipse.gef.editpolicies.SelectionEditPolicy#showSelection()
	 */
	@Override
	protected void showSelection() {
		// not selected but we want to see collapsable handle
		if(getHost().getSelected() == EditPart.SELECTED_NONE) {
			addCollapsableHandles();
		}
		// selected we want to see collapsable handle and resize handle
		if(getHost().getSelected() == EditPart.SELECTED_PRIMARY) {
			super.showSelection();
		}

	}

}
