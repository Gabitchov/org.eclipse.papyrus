/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author Patrick Tessier
 * 
 *         this class is used to create a resize command for border items and
 *         add the {@link BorderItemResizableEditPolicy} on border Item
 */
public class ConstrainedItemBorderLayoutEditPolicy extends ConstrainedLayoutEditPolicy {

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected Command createChangeConstraintCommand(EditPart child, Object constraint) {

		// code that comes form XYLayoutEditPolicy
		Rectangle newBounds = (Rectangle)constraint;
		View shapeView = (View)child.getModel();

		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();

		ICommand boundsCommand = new SetBoundsCommand(editingDomain, DiagramUIMessages.SetLocationCommand_Label_Resize, new EObjectAdapter(shapeView), newBounds);
		return new ICommandProxy(boundsCommand);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected EditPolicy createChildEditPolicy(EditPart child) {
		if(child instanceof IBorderItemEditPart) {
			// return new BorderItemSelectionEditPolicy();
			return new BorderItemResizableEditPolicy();
		}
		EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		if(result == null) {
			result = new NonResizableEditPolicy();
		}
		return result;

	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public Command getCommand(Request request) {
		if(REQ_RESIZE_CHILDREN.equals(request.getType()))
			return getResizeChildrenCommand((ChangeBoundsRequest)request);

		return super.getCommand(request);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected Object getConstraintFor(ChangeBoundsRequest request, GraphicalEditPart child) {
		// TODO Auto-generated method stub
		return super.getConstraintFor(request, child);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected Object getConstraintFor(Point point) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected Object getConstraintFor(Rectangle rect) {
		return rect;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected Command getCreateCommand(CreateRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
