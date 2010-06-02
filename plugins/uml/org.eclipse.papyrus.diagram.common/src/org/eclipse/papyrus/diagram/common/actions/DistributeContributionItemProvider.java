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

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContributionItemProvider;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.papyrus.diagram.common.layout.DistributionConstants;
import org.eclipse.ui.IWorkbenchPage;

/**
 * This class is used to add our own GMF actions.
 * The following actions are concerned :
 * <ul>
 * <li>distribute {@link EditPart} horizontally in its container</li>
 * <li>distribute {@link EditPart} horizontally between the leftmost selected {@link EditPart} and the rightmost selected {@link EditPart}</li>
 * <li>distribute {@link EditPart} vertically in its container</li>
 * <li>distribute {@link EditPart} vertically between the topmost selected {@link EditPart} and the bottommost selected {@link EditPart}</li>
 * </ul>
 * 
 * 
 * 
 */
public class DistributeContributionItemProvider extends DiagramContributionItemProvider {


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
		if(DistributionConstants.DISTRIBUTE_H_CONTAINER.equals(actionId)) {
			return new DistributeAction(workbenchPage, actionId, DistributionConstants.DISTRIBUTE_H_CONTAINER_INT, true);
		} else if(DistributionConstants.DISTRIBUTE_H_NODES.equals(actionId)) {
			return new DistributeAction(workbenchPage, actionId, DistributionConstants.DISTRIBUTE_H_NODES_INT, true);
		} else if(DistributionConstants.DISTRIBUTE_V_CONTAINER.equals(actionId)) {
			return new DistributeAction(workbenchPage, actionId, DistributionConstants.DISTRIBUTE_V_CONTAINER_INT, true);
		} else if(DistributionConstants.DISTRIBUTE_V_NODES.equals(actionId)) {
			return new DistributeAction(workbenchPage, actionId, DistributionConstants.DISTRIBUTE_V_NODES_INT, true);
			/* Right Click */
		} else if(DistributionConstants.ACTION_DISTRIBUTE_H_CONTAINER.equals(actionId)) {
			return new DistributeAction(workbenchPage, actionId, DistributionConstants.DISTRIBUTE_H_CONTAINER_INT, false);
		} else if(DistributionConstants.ACTION_DISTRIBUTE_H_NODES.equals(actionId)) {
			return new DistributeAction(workbenchPage, actionId, DistributionConstants.DISTRIBUTE_H_NODES_INT, false);
		} else if(DistributionConstants.ACTION_DISTRIBUTE_V_CONTAINER.equals(actionId)) {
			return new DistributeAction(workbenchPage, actionId, DistributionConstants.DISTRIBUTE_V_CONTAINER_INT, false);
		} else if(DistributionConstants.ACTION_DISTRIBUTE_V_NODES.equals(actionId)) {
			return new DistributeAction(workbenchPage, actionId, DistributionConstants.DISTRIBUTE_V_NODES_INT, false);
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
		if(menuId.equals(DistributionConstants.MENU_DISTRIBUTE)) {
			return new DistributeMenuManager();
		}
		return super.createMenuManager(menuId, partDescriptor);
	}
}
