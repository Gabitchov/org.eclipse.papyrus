/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Boutheina Bannour (CEA LIST) boutheina.bannour@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.policies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLinkLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusUMLElementFigure;


/**
 * Edit Policy for Applied Stereotype Label for {@link ContextLink}.
 */
public class CustomAppliedStereotypeContextLinkLabelDisplayEditPolicy extends AppliedStereotypeLinkLabelDisplayEditPolicy {

	/**
	 * Creates the EditPolicy, with the correct tag.
	 */
	public CustomAppliedStereotypeContextLinkLabelDisplayEditPolicy() {
		super("context"); //$NON-NLS-1$
	}

	public void activate() {
		// retrieve the view
		View view = getView();
		if(view == null) {
			return;
		}
		//call the refresh overridden in this class
		refreshDisplay();
	}

	/**
	 * Refreshes the tag display
	 */
	protected void refreshStereotypeDisplay() {
		IFigure figure = ((GraphicalEditPart)getHost()).getFigure();
		// the tag displayed here is <code>&laquo context &raquo</code> see the class constructor
		if(figure instanceof IPapyrusUMLElementFigure) {
			((IPapyrusUMLElementFigure)figure).setStereotypeDisplay(tag, null);
		}
	}

}
