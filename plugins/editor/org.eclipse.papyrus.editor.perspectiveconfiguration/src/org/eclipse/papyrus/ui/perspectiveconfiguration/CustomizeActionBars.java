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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.ui.perspectiveconfiguration;

import java.util.List;

import org.eclipse.jface.action.CoolBarManager;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.internal.provisional.action.IToolBarContributionItem;
import org.eclipse.jface.internal.provisional.action.ToolBarContributionItem2;
import org.eclipse.ui.IActionBars2;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.internal.provisional.application.IActionBarConfigurer2;
import org.eclipse.ui.internal.registry.IActionSetDescriptor;
import org.eclipse.ui.services.IServiceLocator;


/**
 * this class is used to collection all information about menu, cool bar, statusline...
 * 
 */
public class CustomizeActionBars implements IActionBarConfigurer2, IActionBars2 {

	protected List<IActionSetDescriptor> actionSet = null;


	/**
	 * get the list of action set
	 * 
	 * @return
	 */
	public List<IActionSetDescriptor> getActionSet() {
		return actionSet;
	}

	/**
	 * set the list of action Set
	 * 
	 * @param actionSet
	 */
	public void setActionSet(List<IActionSetDescriptor> actionSet) {
		this.actionSet = actionSet;
	}

	protected MenuManager menuManager = new MenuManager();

	protected CoolBarManager coolBarManager = new CoolBarManager();

	protected StatusLineManager statusLineManager = new StatusLineManager();

	protected ToolBarManager toolBarManager = new ToolBarManager();

	/**
	 * Create a new instance of this class.
	 * 
	 * @param configurer
	 *        the configurer
	 */
	public CustomizeActionBars(IWorkbenchWindowConfigurer configurer) {
	}

	/**
	 * do not call this method
	 */
	public IWorkbenchWindowConfigurer getWindowConfigurer() {
		return null;
	}

	/**
	 * get the manager in charge to display all menu
	 */

	public IMenuManager getMenuManager() {
		return menuManager;
	}

	/**
	 * the manager in charge to display the status line
	 */
	public IStatusLineManager getStatusLineManager() {
		return statusLineManager;
	}

	/**
	 * the manager in charge to display the cool bar, this also the tool bar in eclipse
	 */
	public ICoolBarManager getCoolBarManager() {
		return coolBarManager;
	}

	/**
	 * see the getCoolBarManager
	 */
	public IToolBarManager getToolBarManager() {
		return toolBarManager;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setGlobalActionHandler(String actionID, IAction handler) {
	}

	/**
	 * {@inheritDoc}
	 */
	public void updateActionBars() {
	}

	/**
	 * {@inheritDoc}
	 */
	public void clearGlobalActionHandlers() {
	}

	/**
	 * {@inheritDoc}
	 */
	public IAction getGlobalActionHandler(String actionId) {
		return null;
	}

	public void registerGlobalAction(IAction action) {
	}

	/**
	 * Clean up the action bars.
	 */
	public void dispose() {
		coolBarManager.dispose();
		menuManager.dispose();
		statusLineManager.dispose();
		toolBarManager.dispose();
	}

	/**
	 * {@inheritDoc}
	 */
	public final IServiceLocator getServiceLocator() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public IToolBarManager createToolBarManager() {
		return toolBarManager;
	}

	/**
	 * {@inheritDoc}
	 */
	public IToolBarContributionItem createToolBarContributionItem(IToolBarManager toolBarManager, String id) {
		return new ToolBarContributionItem2(toolBarManager, id);
	}



}
