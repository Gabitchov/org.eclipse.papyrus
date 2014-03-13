/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.composite.custom.edit.parts;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.editparts.IUMLNamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart;

/**
 * 
 * 
 */
public abstract class AbstractObservationEditPart extends NamedElementEditPart implements IUMLNamedElementEditPart {

	public AbstractObservationEditPart(View view) {
		super(view);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected void refreshBounds() {

		int width = 20;
		int height = 20;
		Dimension size = new Dimension(width, height);
		int x = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_X())).intValue();
		int y = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_Y())).intValue();
		Point loc = new Point(x, y);
		((GraphicalEditPart)getParent()).setLayoutConstraint(this, getFigure(), new Rectangle(loc, size));

	}

	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);
		// set the figure active when the feature of the of a class is true
		if(resolveSemanticElement() != null) {
			refreshFontColor();

			// To adapt the display of the container to the icon!
			refreshBounds();
		}

	}

}
