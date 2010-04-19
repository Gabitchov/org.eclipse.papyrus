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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.action.ContributionManager;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.preference.IPreferenceNode;
import org.eclipse.jface.preference.PreferenceNode;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PerspectiveAdapter;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.internal.Perspective;
import org.eclipse.ui.internal.WorkbenchPage;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.internal.WorkbenchWindow;
import org.eclipse.ui.internal.registry.ActionSetDescriptor;
import org.eclipse.ui.internal.registry.ActionSetRegistry;
import org.eclipse.ui.internal.registry.IActionSetDescriptor;
import org.eclipse.ui.internal.registry.PerspectiveRegistry;
import org.eclipse.ui.menus.IMenuService;
import org.eclipse.ui.menus.MenuUtil;

/**
 * this is a listener hat has in charge to configure a perspective when it is openend etc..
 * 
 */
public class PapyrusPerspectiveListener extends PerspectiveAdapter {

	private IWorkbenchWindow window;

	protected ConfigurationService configurationservice;

	protected ArrayList<PreferenceNode> hiddenRootPref = new ArrayList<PreferenceNode>();


	/**
	 * creation of the listener
	 * 
	 * @param window
	 */
	public PapyrusPerspectiveListener(IWorkbenchWindow window) {
		this.window = window;
		this.configurationservice = new ConfigurationService();

		//this is the lauch of eclipse, so we look for which perspective is opened
		if(window.getActivePage() != null) {
			IPerspectiveDescriptor openedPerspectiveDescriptor = window.getActivePage().getPerspective();
			if(configurationservice.getConfiguration(openedPerspectiveDescriptor.getId()) != null) {
				//it is the frist time?
				if(!isAlreadySave(openedPerspectiveDescriptor.getId())) {
					//Activator.log.debug("First time to open it");
					updateTooling(openedPerspectiveDescriptor);
					window.getActivePage().savePerspective();
				}

			}
			updatePreferencePage(openedPerspectiveDescriptor);
		}
	}

	/**
	 * return yes id it exist a file that custom a given perspective
	 * 
	 * @param perspectiveID
	 *        the id of the perspective
	 * @return yes it find a file,if not no
	 */
	public boolean isAlreadySave(String perspectiveID) {
		PerspectiveRegistry perspRegistry = (PerspectiveRegistry)WorkbenchPlugin.getDefault().getPerspectiveRegistry();
		try {
			IMemento memento = perspRegistry.getCustomPersp(perspectiveID);
			//Activator.log.debug(""+memento);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void perspectiveActivated(IWorkbenchPage page, IPerspectiveDescriptor perspectivedescriptor) {
		//Activator.log.debug("perspectiveActivated "+perspectivedescriptor.getId());
		super.perspectiveActivated(page, perspectivedescriptor);


		//test is we are interesting by the current perspective
		if(configurationservice.getConfiguration(perspectivedescriptor.getId()) != null) {
			if(!isAlreadySave(perspectivedescriptor.getId())) {
				updateTooling(perspectivedescriptor);
				page.savePerspective();
			}


		}
		updatePreferencePage(perspectivedescriptor);
	}

	protected void updatePreferencePage(IPerspectiveDescriptor perspectivedescriptor) {
		//test is we are interesting by the current perspective
		if(configurationservice.getConfiguration(perspectivedescriptor.getId()) != null) {

			Configuration configuration = configurationservice.getConfiguration(perspectivedescriptor.getId());
			IPreferenceNode[] preferencepagelist = window.getWorkbench().getPreferenceManager().getRootSubNodes();

			// take in account the preferences
			for(int i = 0; i < preferencepagelist.length; i++) {
				if(preferencepagelist[i] instanceof PreferenceNode) {
					PreferenceNode node = (PreferenceNode)preferencepagelist[i];
					if(!configuration.getPreferenceID().contains(node.getId())) {
						hiddenRootPref.add(node);
					}
				}
			}
			Iterator<PreferenceNode> iteratorpreftoremove = hiddenRootPref.iterator();
			while(iteratorpreftoremove.hasNext()) {
				window.getWorkbench().getPreferenceManager().remove(iteratorpreftoremove.next());
			}
		} else {
			//this is not an interesting perspective
			Iterator<PreferenceNode> iteratorpreftoremove = hiddenRootPref.iterator();
			while(iteratorpreftoremove.hasNext()) {
				window.getWorkbench().getPreferenceManager().addToRoot(iteratorpreftoremove.next());
			}
			hiddenRootPref.clear();
		}

	}

	/**
	 * this method hide menu, tool bar and action hat are not interesting
	 * 
	 * @param perspectivedescriptor
	 */
	protected void updateTooling(IPerspectiveDescriptor perspectivedescriptor) {

		CustomizeActionBars customizeActionBars = loadData();


		if(configurationservice.getConfiguration(perspectivedescriptor.getId()) != null) {
			Configuration configuration = configurationservice.getConfiguration(perspectivedescriptor.getId());
			//Activator.log.debug("Update tooling");
			//Load all information about menus....
			WorkbenchPage worbenchPage = (WorkbenchPage)window.getActivePage();
			// Get the perspective
			Perspective perspective = worbenchPage.findPerspective(perspectivedescriptor);

			ICommandService cmdService = (ICommandService)worbenchPage.getActivePart().getSite().getService(ICommandService.class);


			ArrayList<String> commandIdToRemove = new ArrayList<String>();

			try {

				//put all commands that not reference to the given category
				for(int i = 0; i < cmdService.getDefinedCommands().length; i++) {
					if(!configuration.getCategoryIDList().contains(cmdService.getDefinedCommands()[i].getCategory().getId())) {
						commandIdToRemove.add(cmdService.getDefinedCommands()[i].getId());
					}
					//	else{System.err.println("keep "+cmdService.getDefinedCommands()[i].getId());}
				}

				//then verify for each command by taking account its id.
				for(int i = 0; i < cmdService.getDefinedCommands().length; i++) {
					//put the commands in the list to hide, theis command are not referenced in the given list of command id and are not in the given list of category 
					if(!configuration.getCommandIDList().contains(cmdService.getDefinedCommands()[i].getId())) {
						if(!configuration.getCategoryIDList().contains(cmdService.getDefinedCommands()[i].getCategory().getId())) {
							if(!commandIdToRemove.contains(cmdService.getDefinedCommands()[i].getId())) {
								commandIdToRemove.add(cmdService.getDefinedCommands()[i].getId());
							}
						}
					} else {//may be the id that we want to keep was in already in the list because of the filter on category
						if(commandIdToRemove.contains(cmdService.getDefinedCommands()[i].getId())) {
							commandIdToRemove.remove(cmdService.getDefinedCommands()[i].getId());
						}
					}
				}
			} catch (Exception e) {
				System.err.println(e);
			}


			perspective.getHiddenMenuItems().clear();
			perspective.getHiddenToolbarItems().clear();

			//look for all actionSet
			ArrayList<IActionSetDescriptor> actionSetToRemove = new ArrayList<IActionSetDescriptor>();
			Iterator<IActionSetDescriptor> iteratorActionSet = customizeActionBars.getActionSet().iterator();
			while(iteratorActionSet.hasNext()) {
				IActionSetDescriptor currentActionSetDescriptor = iteratorActionSet.next();
				//test if the configuationSet contains the id
				if(!configuration.getActionSetIDList().contains(currentActionSetDescriptor.getId())) {
					actionSetToRemove.add(currentActionSetDescriptor);
				}
			}



			// look for all menu
			ArrayList<String> menuToRemove = new ArrayList<String>();

			for(int i = 0; i < customizeActionBars.getMenuManager().getItems().length; i++) {
				if(!configuration.getMenuIDList().contains(customizeActionBars.getMenuManager().getItems()[i].getId())) {
					menuToRemove.add(customizeActionBars.getMenuManager().getItems()[i].getId());
				}
			}

			//look for all toolbar
			ArrayList<String> toolbarToRemove = new ArrayList<String>();
			for(int i = 0; i < customizeActionBars.getToolBarManager().getItems().length; i++) {

				if(!configuration.getToolBarID().contains(customizeActionBars.getToolBarManager().getItems()[i].getId())) {
					toolbarToRemove.add(customizeActionBars.getToolBarManager().getItems()[i].getId());
				}
			}

			perspective.getHiddenMenuItems().addAll(commandIdToRemove);
			perspective.getHiddenToolbarItems().addAll(commandIdToRemove);
			//hide elements
			perspective.turnOffActionSets((IActionSetDescriptor[])actionSetToRemove.toArray(new IActionSetDescriptor[actionSetToRemove.size()]));
			perspective.getHiddenMenuItems().addAll(menuToRemove);
			perspective.getHiddenToolbarItems().addAll(toolbarToRemove);
			perspective.updateActionBars();

		}

	}

	/**
	 * this method search all identifier of menu toolbar and actionSet that are loaded in eclipse
	 * 
	 * @return a structure that contains all references of the toolbar, menu, and actionSet..
	 */
	protected CustomizeActionBars loadData() {


		CustomizeActionBars ownedActionBar = new CustomizeActionBars(null);
		//actionSet
		// Just get the action sets at this point. Do not load the action set
		// until it is actually selected in the dialog.
		ActionSetRegistry reg = WorkbenchPlugin.getDefault().getActionSetRegistry();
		IActionSetDescriptor[] sets = reg.getActionSets();
		IActionSetDescriptor[] actionSetDescriptors = ((WorkbenchPage)window.getActivePage()).getActionSets();
		List initiallyAvailableActionSets = Arrays.asList(actionSetDescriptors);
		ownedActionBar.setActionSet(initiallyAvailableActionSets);



		// Fill fake action bars with static menu information.
		((WorkbenchWindow)window).fillActionBars(ownedActionBar, ActionBarAdvisor.FILL_PROXY | ActionBarAdvisor.FILL_MENU_BAR | ActionBarAdvisor.FILL_COOL_BAR);
		Activator.log.debug("\n+-> ActionSetDescriptor");
		for(int i = 0; i < sets.length; i++) {
			ActionSetDescriptor actionSetDesc = (ActionSetDescriptor)sets[i];
			Activator.log.debug("+--->" + actionSetDesc.getId());

		}

		final IMenuService menuService = (IMenuService)window.getService(IMenuService.class);
		menuService.populateContributionManager((ContributionManager)ownedActionBar.getMenuManager(), MenuUtil.MAIN_MENU);
		Activator.log.debug("\n+-> Menu " + ownedActionBar.getMenuManager().getItems().length);
		for(int i = 0; i < ownedActionBar.getMenuManager().getItems().length; i++) {
			IContributionItem item = ownedActionBar.getMenuManager().getItems()[i];
			Activator.log.debug("+--->" + item.getId());
		}


		IToolBarManager toolBarManager = ownedActionBar.getToolBarManager();
		menuService.populateContributionManager((ContributionManager)toolBarManager, MenuUtil.MAIN_TOOLBAR);
		Activator.log.debug("\n+-> toolbar " + ownedActionBar.getToolBarManager() + " " + ownedActionBar.getToolBarManager().getItems().length);
		for(int i = 0; i < ownedActionBar.getToolBarManager().getItems().length; i++) {
			IContributionItem item = toolBarManager.getItems()[i];
			Activator.log.debug("+--->" + item.getId());
		}

		return ownedActionBar;
	}

	/**
	 * {@inheritDoc}
	 */

	public void perspectiveDeactivated(IWorkbenchPage page, IPerspectiveDescriptor perspective) {
		//in the case of reset this method is called.
		//Activator.log.debug("perspectiveDeactivated "+perspective.getId());
		updateTooling(perspective);
		page.savePerspective();
	}
}
