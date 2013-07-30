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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.editparts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.View;

/**
 * Abstract EditPart for Border elements like Port
 */
public abstract class AbstractBorderEditPart extends BorderNamedElementEditPart implements IUMLNamedElementEditPart {

	/** Constructor */
	public AbstractBorderEditPart(View view) {
		super(view);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.editparts.BorderNamedElementEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
	 * 
	 * @param event
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);

		// set the figure active when the feature of the of a class is true
		if(resolveSemanticElement() != null) {
			refreshFontColor();
		}

	}
}
