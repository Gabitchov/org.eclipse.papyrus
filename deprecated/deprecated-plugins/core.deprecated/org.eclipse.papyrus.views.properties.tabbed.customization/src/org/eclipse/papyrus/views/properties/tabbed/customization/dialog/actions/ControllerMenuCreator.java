/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.tabbed.customization.dialog.actions;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.ControllerDescriptorState;
import org.eclipse.papyrus.views.properties.runtime.view.content.ContainerDescriptorState;
import org.eclipse.papyrus.views.properties.tabbed.core.view.SectionSetDescriptorState;
import org.eclipse.papyrus.views.properties.tabbed.customization.Activator;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.uml2.uml.Stereotype;


/**
 * Menu creator for {@link ControllerDescriptorState}
 */
public class ControllerMenuCreator extends AbstractMenuCreator {

	/** element on which the menu should be created */
	private final ControllerDescriptorState controllerDescriptorState;

	/** menu manager used to create elements */
	private MenuManager manager;

	/**
	 * Creates a new ControllerMenuCreator.
	 * 
	 * @param controllerDescriptorState
	 *        the state on which this menu is created
	 */
	public ControllerMenuCreator(ControllerDescriptorState controllerDescriptorState, SectionSetDescriptorState sectionSetDescriptorState, EClassifier currentMetaclass, Stereotype currentStereotype) {
		super(sectionSetDescriptorState, currentMetaclass, currentStereotype);
		this.controllerDescriptorState = controllerDescriptorState;
	}

	/**
	 * {@inheritDoc}
	 */
	public Menu getMenu(final Control parent) {
		if(manager == null) {
			manager = new MenuManager();
		}
		Menu menu = manager.getMenu();
		if(menu != null) {
			menu.dispose();
			menu = null;
		}
		manager.removeAll();
		menu = manager.createContextMenu(parent);
		IAction removeAction = new Action("Remove Controller", Activator.imageDescriptorFromPlugin(Activator.ID, "/icons/delete.gif")) {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void run() {
				// remove this section descriptor state from its parent
				if(parent instanceof Tree) {
					TreeItem[] selectedItems = ((Tree)parent).getSelection();
					if(selectedItems.length < 1) {
						Activator.log.warn("Impossible to find the current selection in the tree");
						return;
					}
					TreeItem selectedItem = selectedItems[0];
					TreeItem parentItem = selectedItem.getParentItem();
					// parent item should be the section descriptor set 
					if(parentItem == null) {
						Activator.log.warn("Impossible to find the parent for current selection in the tree ");
						return;
					}
					Object parent = parentItem.getData();
					// test the parent is a FragmentDescriptorState
					if((parent instanceof ContainerDescriptorState)) {
						((ContainerDescriptorState)parent).removePropertyEditorControllerState(controllerDescriptorState);
					}
				}
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean isEnabled() {
				if(getSelectedControllerState() == null || getSelectedControllerState().isReadOnly()) {
					setEnabled(false);
				}
				return super.isEnabled();
			}

			/**
			 * Returns the selected controller state
			 * 
			 * @return the selected controller state
			 */
			protected ControllerDescriptorState getSelectedControllerState() {
				if(parent instanceof Tree) {
					TreeItem[] selectedItems = ((Tree)parent).getSelection();
					if(selectedItems.length < 1) {
						Activator.log.warn("Impossible to find the current selection in the tree");
						return null;
					}
					TreeItem selectedItem = selectedItems[0];
					Object data = selectedItem.getData();
					if(data instanceof ControllerDescriptorState) {
						return ((ControllerDescriptorState)data);
					}
				}
				return null;
			}
		};
		manager.add(removeAction);
		manager.add(new Separator(ADD_GROUP));

		return menu;
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		if(manager != null) {
			Menu menu = manager.getMenu();
			if(menu != null) {
				menu.dispose();
				menu = null;
			}
		}
	}

}
