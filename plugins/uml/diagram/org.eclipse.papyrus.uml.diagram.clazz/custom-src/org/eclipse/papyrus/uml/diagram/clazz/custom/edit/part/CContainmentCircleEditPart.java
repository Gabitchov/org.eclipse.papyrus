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
 *  
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.edit.part;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ContainmentCircleEditPart;

public class CContainmentCircleEditPart extends ContainmentCircleEditPart {

	public CContainmentCircleEditPart(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Papyrus codeGen
	 * 
	 * 
	 **/
	protected void handleNotificationEvent(org.eclipse.emf.common.notify.Notification event) {
		super.handleNotificationEvent(event);
		// set the good ends for the association figure
		refreshVisuals();
	}

	/**
	 * Modify the default size of the containment circle node
	 */
	protected org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure createNodePlate() {
		org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure result = new org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure(20, 20);
		// FIXME: workaround for #154536
		result.getBounds().setSize(result.getPreferredSize());
		return result;
	}
}
