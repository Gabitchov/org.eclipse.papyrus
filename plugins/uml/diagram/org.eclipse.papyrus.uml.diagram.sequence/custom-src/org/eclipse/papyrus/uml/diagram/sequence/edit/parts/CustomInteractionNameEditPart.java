/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.util.ElementIconUtil;
import org.eclipse.swt.graphics.Image;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomInteractionNameEditPart extends InteractionNameEditPart {

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomInteractionNameEditPart(View view) {
		super(view);
	}

	@Override
	protected Image getLabelIcon() {
		return ElementIconUtil.getLabelIcon(this);
	}

	protected void refreshLabelContainer() {
		Object p = getParent();
		if(p instanceof InteractionEditPart) {
			InteractionEditPart iep = (InteractionEditPart)p;
			IFigure container = iep.getPrimaryShape().getHeaderLabel().getParent();
			if(container != null) {
				container.revalidate();
				container.repaint();
			}
		}
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionNameEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
	 * 
	 * @param event
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);
		if(ElementIconUtil.isIconNotification(event)) {
			refreshLabelContainer();
		}
	}
}
