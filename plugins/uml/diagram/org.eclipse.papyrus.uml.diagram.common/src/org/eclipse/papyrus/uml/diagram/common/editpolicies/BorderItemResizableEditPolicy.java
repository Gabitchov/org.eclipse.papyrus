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
 *  Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr - Allow the alignment Request
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;

/**
 * 
 * @author Patrick Tessier Policy that allows resizing border item code comes
 *         form {@link BorderItemSelectionEditPolicy} and modify in order to use
 *         resize behavior
 */
public class BorderItemResizableEditPolicy extends ResizableShapeEditPolicy {

	@Override
	public void eraseSourceFeedback(Request request) {
		if((REQ_MOVE.equals(request.getType()) && isDragAllowed()) || REQ_CLONE.equals(request.getType()) || REQ_ADD.equals(request.getType()) || RequestConstants.REQ_DROP.equals(request.getType()) || REQ_RESIZE.equals(request.getType()))
			eraseChangeBoundsFeedback((ChangeBoundsRequest)request);

	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected Command getMoveCommand(ChangeBoundsRequest request) {
		IBorderItemEditPart borderItemEP = (IBorderItemEditPart)getHost();
		IBorderItemLocator borderItemLocator = borderItemEP.getBorderItemLocator();

		if(borderItemLocator != null) {
			PrecisionRectangle rect = new PrecisionRectangle(getInitialFeedbackBounds().getCopy());
			getHostFigure().translateToAbsolute(rect);
			rect.translate(request.getMoveDelta());
			rect.resize(request.getSizeDelta());

			getHostFigure().translateToRelative(rect);
			Rectangle realLocation = borderItemLocator.getValidLocation(rect.getCopy(), borderItemEP.getFigure());

			Point parentOrigin = borderItemEP.getFigure().getParent().getBounds().getTopLeft();
			Dimension d = realLocation.getTopLeft().getDifference(parentOrigin);
			Point location = new Point(d.width, d.height);

			ICommand moveCommand = new SetBoundsCommand(borderItemEP.getEditingDomain(), DiagramUIMessages.Commands_MoveElement, new EObjectAdapter((View)getHost().getModel()), location);
			return new ICommandProxy(moveCommand);
		}
		return null;
	}

	/**
	 * Shows or updates feedback for a change bounds request.
	 * 
	 * @param request
	 *        the request
	 */
	@Override
	protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
		IBorderItemEditPart borderItemEP = (IBorderItemEditPart)getHost();
		IBorderItemLocator borderItemLocator = borderItemEP.getBorderItemLocator();

		if(borderItemLocator != null) {
			IFigure feedback = getDragSourceFeedbackFigure();
			PrecisionRectangle rect = new PrecisionRectangle(getInitialFeedbackBounds().getCopy());
			getHostFigure().translateToAbsolute(rect);
			rect.translate(request.getMoveDelta());
			rect.resize(request.getSizeDelta());
			getHostFigure().translateToRelative(rect);
			Rectangle realLocation = borderItemLocator.getValidLocation(rect.getCopy(), borderItemEP.getFigure());
			getHostFigure().translateToAbsolute(realLocation);
			feedback.translateToRelative(realLocation);
			feedback.setBounds(realLocation);
		}
	}

	/**
	 * Calls other methods as appropriate.
	 */
	@Override
	public void showSourceFeedback(Request request) {
		if((REQ_MOVE.equals(request.getType()) && isDragAllowed()) || REQ_ADD.equals(request.getType()) || REQ_CLONE.equals(request.getType()) || RequestConstants.REQ_DROP.equals(request.getType()) || REQ_RESIZE.equals(request.getType()))
			showChangeBoundsFeedback((ChangeBoundsRequest)request);
	}
}
