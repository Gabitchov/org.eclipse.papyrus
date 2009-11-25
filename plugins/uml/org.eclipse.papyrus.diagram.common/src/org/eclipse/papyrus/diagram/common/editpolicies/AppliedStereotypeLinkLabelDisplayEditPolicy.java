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
package org.eclipse.papyrus.diagram.common.editpolicies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.papyrus.diagram.common.figure.edge.UMLEdgeFigure;
import org.eclipse.papyrus.diagram.common.figure.node.IPapyrusUMLElementFigure;
import org.eclipse.swt.graphics.Image;

/**
 * the goal of this edit policy is to display applied stereotype and properties of stereotypes in to
 * a label attached to a link the edge figure figure has to be a {@link IPapyrusUMLElementFigure}
 */
public class AppliedStereotypeLinkLabelDisplayEditPolicy extends AppliedStereotypeLabelDisplayEditPolicy {

	public AppliedStereotypeLinkLabelDisplayEditPolicy() {
		super();
	}

	public AppliedStereotypeLinkLabelDisplayEditPolicy(String tag) {
		super(tag);
	}

	/**
	 * Refreshes the stereotype display
	 */
	protected void refreshStereotypeDisplay() {
		IFigure figure = ((GraphicalEditPart) getHost()).getFigure();
		// View view = (View) getHost().getModel();

		// calculate text and icon to display
		final String stereotypesToDisplay = stereotypesToDisplay();
		// computes the icon to be displayed
		final Image imageToDisplay = stereotypeIconToDisplay();

		// if the string is not empty, then, the figure has to display it. Else, it displays nothing
		// if (stereotypesToDisplay != "" || imageToDisplay != null) {
		if (figure instanceof IPapyrusUMLElementFigure) {
			((UMLEdgeFigure) figure).setStereotypeDisplay(tag
					+ (stereotypesToDisplay.equals("") ? stereotypesToDisplay : "\n" + stereotypesToDisplay),
					imageToDisplay);
		}
	}

}
