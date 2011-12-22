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

import java.util.ArrayList;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.FragmentDescriptorState;
import org.eclipse.papyrus.views.properties.runtime.view.content.ContainerDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.content.ContainerDescriptorState;
import org.eclipse.papyrus.views.properties.runtime.view.content.ExpandableContainerDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.content.GridLayoutDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.content.GroupContainerDescriptor;
import org.eclipse.papyrus.views.properties.tabbed.core.view.SectionDescriptorState;
import org.eclipse.papyrus.views.properties.tabbed.core.view.SectionSetDescriptorState;
import org.eclipse.papyrus.views.properties.tabbed.customization.Activator;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.uml2.uml.Stereotype;


/**
 * Menu creator for {@link FragmentDescriptorState}
 */
public class FragmentMenuCreator extends AbstractMenuCreator {

	/** element on which the menu should be created */
	private final FragmentDescriptorState fragmentDescriptorState;

	/** menu manager used to create elements */
	private MenuManager manager;

	/**
	 * Creates a new FragmentMenuCreator.
	 * 
	 * @param fragmentDescriptorState
	 *        the state on which this menu is created
	 */
	public FragmentMenuCreator(FragmentDescriptorState fragmentDescriptorState, SectionSetDescriptorState sectionSetDescriptorState, EClassifier currentMetaclass, Stereotype currentStereotype) {
		super(sectionSetDescriptorState, currentMetaclass, currentStereotype);
		this.fragmentDescriptorState = fragmentDescriptorState;
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
					// test the parent is a SectionDescriptorState
					if((parent instanceof SectionDescriptorState)) {
						((SectionDescriptorState)parent).removeFragmentDescriptorState(fragmentDescriptorState);
					}
				}
			}

		};
		manager.add(removeAction);
		manager.add(new Separator(ADD_GROUP));

		IAction addSimpleContainerAction = new Action("Add Simple Container", Activator.imageDescriptorFromPlugin(Activator.ID, "/icons/NewSimpleContainer.gif")) {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void run() {
				// adds a simple container to the current element
				ContainerDescriptor containerDescriptor = new ContainerDescriptor(new GridLayoutDescriptor(), new ArrayList<IPropertyEditorControllerDescriptor>());
				ContainerDescriptorState containerDescriptorState = containerDescriptor.createState(false);
				fragmentDescriptorState.addContainerDescriptorState(containerDescriptorState);
				// try to retrieve the selection
				if(parent instanceof Tree) {
					TreeItem[] parentItems = ((Tree)parent).getSelection();
					if(parentItems.length < 1) {
						return;
					}
					parentItems[0].setExpanded(true);
					for(TreeItem child : parentItems[0].getItems()) {
						if(containerDescriptorState.equals(child.getData())) {
							((Tree)parent).select(child);
							return;
						}
					}
				}
			}

		};
		manager.appendToGroup(ADD_GROUP, addSimpleContainerAction);

		IAction addExpandableContainerAction = new Action("Add Expandable Container", Activator.imageDescriptorFromPlugin(Activator.ID, "/icons/NewExpandableContainer.gif")) {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void run() {
				// adds an expandable container to the current element
				ExpandableContainerDescriptor containerDescriptor = new ExpandableContainerDescriptor(new GridLayoutDescriptor(), "Label", new ArrayList<IPropertyEditorControllerDescriptor>());
				ContainerDescriptorState containerDescriptorState = containerDescriptor.createState(false);
				fragmentDescriptorState.addContainerDescriptorState(containerDescriptorState);
				// try to retrieve the selection
				if(parent instanceof Tree) {
					TreeItem[] parentItems = ((Tree)parent).getSelection();
					if(parentItems.length < 1) {
						return;
					}

					parentItems[0].setExpanded(true);
					for(TreeItem child : parentItems[0].getItems()) {
						if(containerDescriptorState.equals(child.getData())) {
							((Tree)parent).select(child);
							return;
						}
					}
				}
			}

		};
		manager.appendToGroup(ADD_GROUP, addExpandableContainerAction);

		IAction addGroupContainerAction = new Action("Add Group Container", Activator.imageDescriptorFromPlugin(Activator.ID, "/icons/NewGroupContainer.gif")) {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void run() {
				// adds an expandable container to the current element
				GroupContainerDescriptor containerDescriptor = new GroupContainerDescriptor(new GridLayoutDescriptor(), "Label", new ArrayList<IPropertyEditorControllerDescriptor>());
				ContainerDescriptorState containerDescriptorState = containerDescriptor.createState(false);
				fragmentDescriptorState.addContainerDescriptorState(containerDescriptorState);

				// try to retrieve the selection
				if(parent instanceof Tree) {
					TreeItem[] parentItems = ((Tree)parent).getSelection();
					if(parentItems.length < 1) {
						return;
					}
					parentItems[0].setExpanded(true);
					for(TreeItem child : parentItems[0].getItems()) {
						if(containerDescriptorState.equals(child.getData())) {
							((Tree)parent).select(child);
							return;
						}
					}
				}
			}
		};
		manager.appendToGroup(ADD_GROUP, addGroupContainerAction);


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
