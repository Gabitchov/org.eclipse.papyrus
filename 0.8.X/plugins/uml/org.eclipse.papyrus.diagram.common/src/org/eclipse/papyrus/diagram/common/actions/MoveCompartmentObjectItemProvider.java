/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) - initial api implementation 
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.actions;

import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchPage;

/**
 * Provides the text for the menu group, and the actions contained inside
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * 
 */
public class MoveCompartmentObjectItemProvider extends AbstractContributionItemProvider implements IProvider {

	/** The Constant MENU_CREATE_DIAGRAM. */
	public static final String MENU_CREATE_DIAGRAM = "menu_order_within_compartment"; //$NON-NLS-1$

	/**
	 * It creates the menu with the list of actions.
	 */
	@Override
	protected IMenuManager createMenuManager(String menuId, IWorkbenchPartDescriptor partDescriptor) {
		if(!MENU_CREATE_DIAGRAM.equals(menuId)) {
			return super.createMenuManager(menuId, partDescriptor);
		}
		MenuManager menuManager = new MenuManager("Compartment Order");
		MenuBuilder builder = new MenuBuilder(partDescriptor);
		builder.buildMenu(menuManager);

		menuManager.addMenuListener(builder);
		return menuManager;
	}

	/**
	 * The Class MenuBuilder.
	 */
	private class MenuBuilder implements IMenuListener {

		/** The my workbench part. */
		private final IWorkbenchPartDescriptor myWorkbenchPart;

		/**
		 * Instantiates a new menu builder.
		 * 
		 * @param workbenchPart
		 *        the workbench part
		 */
		public MenuBuilder(IWorkbenchPartDescriptor workbenchPart) {
			myWorkbenchPart = workbenchPart;
		}

		/**
		 * Create the menu before showing.
		 */
		public void menuAboutToShow(IMenuManager manager) {
			buildMenu(manager);
		}

		/**
		 * Builds the menu.
		 * 
		 * @param manager
		 *        the manager
		 */
		public void buildMenu(IMenuManager manager) {
			manager.removeAll();

			// Define actions
			MoveCompartmentObjectAction actionTop, actionBottom, actionUp, actionDown;

			// Create the actions
			actionTop = new MoveCompartmentObjectAction(getWorkbenchPage(), MoveCompartmentObjectAction.MOVE_TOP);
			actionUp = new MoveCompartmentObjectAction(getWorkbenchPage(), MoveCompartmentObjectAction.MOVE_UP);
			actionDown = new MoveCompartmentObjectAction(getWorkbenchPage(), MoveCompartmentObjectAction.MOVE_DOWN);
			actionBottom = new MoveCompartmentObjectAction(getWorkbenchPage(), MoveCompartmentObjectAction.MOVE_BOTTOM);

			// Initialize the actions
			actionTop.init();
			actionUp.init();
			actionDown.init();
			actionBottom.init();

			// Add them to the menu
			manager.add(actionTop);
			manager.add(actionUp);
			manager.add(actionDown);
			manager.add(actionBottom);
		}

		/**
		 * Gets the workbench page.
		 * 
		 * @return the workbench page
		 */
		private IWorkbenchPage getWorkbenchPage() {
			return myWorkbenchPart.getPartPage();
		}
	}
}
