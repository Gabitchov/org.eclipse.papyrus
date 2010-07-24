/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.diagram.common.actions;

import org.eclipse.gmf.runtime.common.ui.action.ActionMenuManager;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.layout.RoutingConstants;

/**
 * the menu manager for the routing actions
 */
public class RouteMenuManager extends ActionMenuManager {

	/**
	 * 
	 * An action for this menu
	 * 
	 */
	private static class RouteMenuAction extends Action {

		public RouteMenuAction() {
			setText(RoutingConstants.RouteActionMenu_MenuTitleText);
			setToolTipText(RoutingConstants.RouteActionMenu_MenuTitleToolTipText);
			ImageDescriptor imageDesc = Activator.getImageDescriptor(RoutingConstants.ICON_SET_HORIZONTAL_BY_LEFT);
			setImageDescriptor(imageDesc);
			setHoverImageDescriptor(imageDesc);
		}
	}

	/**
	 * Creates a new instance of the route menu manager
	 */
	public RouteMenuManager() {
		super(RoutingConstants.MENU_ROUTE, new RouteMenuAction(), true);
	}

}
