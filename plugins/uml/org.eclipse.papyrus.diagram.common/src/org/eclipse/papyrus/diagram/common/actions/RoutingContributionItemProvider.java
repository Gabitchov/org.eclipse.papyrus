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

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContributionItemProvider;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.papyrus.diagram.common.layout.RoutingConstants;
import org.eclipse.ui.IWorkbenchPage;

/**
 * This class provides actions to put a link vertical or horizontal, moving only one anchor.
 * To put a link horizontally, we can move the right anchor or the left anchor.
 * To put a link vertically, we can move the top anchor or the bottom anchor.
 */
public class RoutingContributionItemProvider extends DiagramContributionItemProvider {


	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContributionItemProvider#createAction(java.lang.String,
	 *      org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor)
	 * 
	 * @param actionId
	 *        the action identifier
	 * @param partDescriptor
	 *        the workbench part descriptor
	 * @return
	 */
	@Override
	protected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {
		IWorkbenchPage workbenchPage = partDescriptor.getPartPage();

		/* ToolBar and Menu Diagram */
		if(RoutingConstants.ROUTING_HORIZONTALLY_BY_LEFT.equals(actionId)) {
			return new RouteAction(workbenchPage, actionId, PositionConstants.LEFT, true);
		} else if(RoutingConstants.ROUTING_HORIZONTALLY_BY_RIGHT.equals(actionId)) {
			return new RouteAction(workbenchPage, actionId, PositionConstants.RIGHT, true);
		} else if(RoutingConstants.ROUTING_VERTICALLY_BY_TOP.equals(actionId)) {
			return new RouteAction(workbenchPage, actionId, PositionConstants.TOP, true);
		} else if(RoutingConstants.ROUTING_VERTICALLY_BY_BOTTOM.equals(actionId)) {
			return new RouteAction(workbenchPage, actionId, PositionConstants.BOTTOM, true);
			/* Right Click */
		} else if(RoutingConstants.ROUTING_HORIZONTALLY_BY_LEFT_ACTION.equals(actionId)) {
			return new RouteAction(workbenchPage, actionId, PositionConstants.LEFT, false);
		} else if(RoutingConstants.ROUTING_HORIZONTALLY_BY_RIGHT_ACTION.equals(actionId)) {
			return new RouteAction(workbenchPage, actionId, PositionConstants.RIGHT, false);
		} else if(RoutingConstants.ROUTING_VERTICALLY_BY_TOP_ACTION.equals(actionId)) {
			return new RouteAction(workbenchPage, actionId, PositionConstants.TOP, false);
		} else if(RoutingConstants.ROUTING_VERTICALLY_BY_BOTTOM_ACTION.equals(actionId)) {
			return new RouteAction(workbenchPage, actionId, PositionConstants.BOTTOM, false);
		}
		return super.createAction(actionId, partDescriptor);
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContributionItemProvider#createMenuManager(java.lang.String,
	 *      org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor)
	 * 
	 * @param menuId
	 * @param partDescriptor
	 * @return
	 */
	@Override
	protected IMenuManager createMenuManager(String menuId, IWorkbenchPartDescriptor partDescriptor) {
		if(menuId.equals(RoutingConstants.MENU_ROUTE)) {
			return new RouteMenuManager();
		}
		return super.createMenuManager(menuId, partDescriptor);
	}
}
