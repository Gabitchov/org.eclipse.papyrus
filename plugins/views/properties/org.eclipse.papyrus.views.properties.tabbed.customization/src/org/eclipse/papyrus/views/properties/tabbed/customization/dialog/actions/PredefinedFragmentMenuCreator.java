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
import org.eclipse.papyrus.views.properties.runtime.view.PredefinedFragmentDescriptorState;
import org.eclipse.papyrus.views.properties.tabbed.core.view.SectionDescriptorState;
import org.eclipse.papyrus.views.properties.tabbed.core.view.SectionSetDescriptorState;
import org.eclipse.papyrus.views.properties.tabbed.customization.Activator;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.uml2.uml.Stereotype;


/**
 * Menu creator for {@link PredefinedFragmentDescriptorState}
 */
public class PredefinedFragmentMenuCreator extends AbstractMenuCreator {

	/** element on which the menu should be created */
	private final PredefinedFragmentDescriptorState predefinedFragmentDescriptorState;

	/** menu manager used to create elements */
	private MenuManager manager;

	/**
	 * Creates a new ContainerMenuCreator.
	 * 
	 * @param containerDescriptorState
	 *        the state on which this menu is created
	 */
	public PredefinedFragmentMenuCreator(PredefinedFragmentDescriptorState predefinedFragmentDescriptorState, SectionSetDescriptorState sectionSetDescriptorState, EClassifier currentMetaclass, Stereotype currentStereotype) {
		super(sectionSetDescriptorState, currentMetaclass, currentStereotype);
		this.predefinedFragmentDescriptorState = predefinedFragmentDescriptorState;
	}

	/**
	 * Returns the current selected container
	 * 
	 * @return the current selected container or null
	 */
	protected PredefinedFragmentDescriptorState getSelectedPredefinedFragmentDescriptorState(Object parent) {
		if(parent instanceof Tree) {
			TreeItem[] selectedItems = ((Tree)parent).getSelection();
			if(selectedItems.length < 1) {
				Activator.log.warn("Impossible to find the current selection in the tree");
				return null;
			}
			TreeItem selectedItem = selectedItems[0];
			Object data = selectedItem.getData();
			if(data instanceof PredefinedFragmentDescriptorState) {
				return ((PredefinedFragmentDescriptorState)data);
			}
		}
		return null;
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
		IAction removeAction = new Action("Remove Fragment", Activator.imageDescriptorFromPlugin(Activator.ID, "/icons/delete.gif")) {

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
					if((parent instanceof SectionDescriptorState)) {
						((SectionDescriptorState)parent).removeFragmentDescriptorState(predefinedFragmentDescriptorState);
					}
				}
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean isEnabled() {
				PredefinedFragmentDescriptorState state = getSelectedPredefinedFragmentDescriptorState(parent);
				if(state == null || state.isReadOnly()) {
					setEnabled(false);
				}
				return super.isEnabled();
			}

		};
		manager.add(removeAction);

		return menu;
	}

}
