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
package org.eclipse.papyrus.uml.diagram.clazz.custom.policies;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.swt.graphics.Color;

/**
 * This policy is used to change background of container when we move or connect an elent to them
 */
public class ContainerHighlightEditPolicy extends org.eclipse.gef.editpolicies.GraphicalEditPolicy {

	/**
	 * the color when the element is selected
	 */
	private Color revertColor;

	/**
	 * 
	 * {@inheritedDoc}
	 */
	public void eraseTargetFeedback(Request request) {
		if(revertColor != null) {
			setContainerBackground(revertColor);
			revertColor = null;
		}
	}

	/**
	 * 
	 * @return the background color of the figure
	 */
	private Color getContainerBackground() {
		return getContainerFigure().getBackgroundColor();
	}

	/**
	 * 
	 * get the figure attach to the editpart
	 * 
	 * @return
	 */
	private IFigure getContainerFigure() {
		return ((GraphicalEditPart)getHost()).getFigure();
	}

	/**
	 * 
	 * {@inheritedDoc}
	 */
	public EditPart getTargetEditPart(Request request) {
		return request.getType().equals(RequestConstants.REQ_SELECTION_HOVER) ? getHost() : null;
	}

	/**
	 * set the color to the figure attached to the editpart
	 * 
	 * @param c
	 *        the background color
	 */
	private void setContainerBackground(Color c) {
		getContainerFigure().setBackgroundColor(c);
	}

	/**
	 * change the color of the figure
	 */
	protected void showHighlight() {
		if(revertColor == null) {
			revertColor = getContainerBackground();
			setContainerBackground(ColorConstants.lightBlue);
		}
	}

	/**
	 * 
	 * {@inheritedDoc}
	 */
	public void showTargetFeedback(Request request) {
		if(request.getType().equals(RequestConstants.REQ_MOVE) || request.getType().equals(RequestConstants.REQ_ADD) || request.getType().equals(RequestConstants.REQ_CLONE) || request.getType().equals(RequestConstants.REQ_CONNECTION_START) || request.getType().equals(RequestConstants.REQ_CONNECTION_END) || request.getType().equals(RequestConstants.REQ_CREATE)) {
			showHighlight();
		}
	}
}
