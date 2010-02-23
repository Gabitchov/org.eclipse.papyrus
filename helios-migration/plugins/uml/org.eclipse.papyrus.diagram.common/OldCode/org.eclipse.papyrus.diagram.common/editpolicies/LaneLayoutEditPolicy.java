/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Sergey Gribovsky (Borland) - initial API and implementation
 */
package org.eclipse.papyrus.diagram.common.editpolicies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.handles.ResizableHandleKit;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.draw2d.LaneLayout;

public class LaneLayoutEditPolicy extends ConstrainedLayoutEditPolicy {

	private int myLaneOrientation;

	public LaneLayoutEditPolicy() {
		this(LaneLayout.HORIZONTAL);
	}

	public LaneLayoutEditPolicy(int laneOrientation) {
		setLaneOrientation(laneOrientation);
	}

	public void setLaneOrientation(int orientation) {
		if (orientation != LaneLayout.HORIZONTAL && orientation != LaneLayout.VERTICAL) {
			throw new IllegalArgumentException("Incorrect lane orientation constant: " + orientation); //$NON-NLS-1$
		}
		myLaneOrientation = orientation;
	}

	public int getLaneOrientation() {
		return myLaneOrientation;
	}

	@Override
	protected Command createChangeConstraintCommand(EditPart child, Object constraint) {
		Dimension constraintSize = ((Rectangle) constraint).getSize();
		Dimension newSize = new Dimension(getLaneOrientation() == LaneLayout.HORIZONTAL ? -1 : constraintSize.width,
				getLaneOrientation() == LaneLayout.VERTICAL ? -1 : constraintSize.height);
		Rectangle newBounds = new Rectangle(new Point(0, 0), newSize);
		View shapeView = (View) child.getModel();
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();

		ICommand boundsCommand = new SetBoundsCommand(editingDomain, DiagramUIMessages.SetLocationCommand_Label_Resize,
				new EObjectAdapter(shapeView), newBounds);
		return new ICommandProxy(boundsCommand);
	}

	@Override
	protected Object getConstraintFor(Point point) {
		return null;
	}

	@Override
	protected Object getConstraintFor(Rectangle rect) {
		return new Rectangle(rect);
	}

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		return null;
	}

	@Override
	protected EditPolicy createChildEditPolicy(EditPart child) {
		if (child instanceof IBorderItemEditPart) {
			return new BorderItemSelectionEditPolicy();
		}

		ResizableEditPolicy editPolicy = new ResizableEditPolicy() {

			@Override
			protected List createSelectionHandles() {
				List list = new ArrayList();
				ResizableHandleKit.addMoveHandle((GraphicalEditPart) getHost(), list);

				if (getLaneOrientation() == LaneLayout.HORIZONTAL) {
					ResizableHandleKit.addHandle((GraphicalEditPart) getHost(), list, PositionConstants.NORTH);
					ResizableHandleKit.addHandle((GraphicalEditPart) getHost(), list, PositionConstants.SOUTH);
				} else {
					ResizableHandleKit.addHandle((GraphicalEditPart) getHost(), list, PositionConstants.WEST);
					ResizableHandleKit.addHandle((GraphicalEditPart) getHost(), list, PositionConstants.EAST);
				}

				return list;
			}
		};
		return editPolicy;
	}
}
