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
package org.eclipse.papyrus.properties.tabbed.customization.dialog.actions;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.papyrus.properties.runtime.view.FragmentDescriptor;
import org.eclipse.papyrus.properties.runtime.view.FragmentDescriptorState;
import org.eclipse.papyrus.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.properties.runtime.view.content.ContainerDescriptor;
import org.eclipse.papyrus.properties.tabbed.core.view.SectionDescriptorState;
import org.eclipse.papyrus.properties.tabbed.core.view.SectionSetDescriptorState;
import org.eclipse.papyrus.properties.tabbed.customization.Activator;
import org.eclipse.papyrus.properties.tabbed.customization.dialog.ContentHolder;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;


/**
 * Menu creator for {@link SectionDescriptorState}
 */
public class SectionMenuCreator extends AbstractMenuCreator {

	/** element on which the menu should be created */
	private final SectionDescriptorState sectionDescriptorState;

	/** menu manager used to create elements */
	private MenuManager manager;

	/**
	 * Creates a new SectionMenuCreator.
	 * 
	 * @param sectionDescriptorState
	 *        the state on which this menu is created
	 */
	public SectionMenuCreator(SectionDescriptorState sectionDescriptorState) {
		this.sectionDescriptorState = sectionDescriptorState;
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
		IAction removeAction = new Action("Remove Section", Activator.imageDescriptorFromPlugin(Activator.ID, "/icons/delete.gif")) {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void run() {
				// remove this section descriptor state from its parent
				if(parent instanceof Tree) {
					TreeItem[] selectedItems = ((Tree)parent).getSelection();
					if(selectedItems.length < 1) {
						Activator.log.warn("Impossible to find the curret selection in the tree");
						return;
					}
					TreeItem selectedItem = selectedItems[0];
					TreeItem parentItem = selectedItem.getParentItem();
					// parent item should be the sectionsetdescriptor set (content holder exactly)
					if(parentItem == null) {
						Activator.log.warn("Impossible to find the parent for current selection in the tree ");
						return;
					}

					Object parent = parentItem.getData();
					// test the parent is a content holder
					if((parent instanceof ContentHolder)) {
						SectionSetDescriptorState sectionSetDescriptorState = ((ContentHolder)parent).getSectionSetDescriptorState();
						sectionSetDescriptorState.removeSectionDescriptorState(sectionDescriptorState);
					}
				}
			}

		};
		manager.add(removeAction);
		manager.add(new Separator(ADD_GROUP));

		IAction addFragmentAction = new Action("Add Fragment", Activator.imageDescriptorFromPlugin(Activator.ID, "/icons/NewFragment.gif")) {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void run() {
				// adds a fragment to the current element
				FragmentDescriptor fragmentDescriptor = new FragmentDescriptor(getNewFragmentId(), new ArrayList<IConstraintDescriptor>(), new ArrayList<ContainerDescriptor>(), 1);
				FragmentDescriptorState fragmentDescriptorState = new FragmentDescriptorState(fragmentDescriptor);
				sectionDescriptorState.addFragmentDescriptorState(fragmentDescriptorState);
			}

		};
		manager.appendToGroup(ADD_GROUP, addFragmentAction);

		//		IAction addPredefinedFragmentAction = new Action("Add PredefinedFragment", Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/NewFragment.gif")) {
		//
		//			/**
		//			 * {@inheritDoc}
		//			 */
		//			@Override
		//			public void run() {
		//				// adds a fragment to the current element
		//				Map<String, FragmentDescriptor>  availableFragmentDescriptors = PropertyViewService.getInstance().getAllFragmentDescriptors();
		//				
		//				for(FragmentDescriptor descriptor : availableFragmentDescriptors.values()) {
		//					// check the constraints for this descriptor are valid ?
		//					for(IConstraintDescriptor constraintDescriptor : descriptor.getConstraintDescriptors()) {
		//						
		//					}
		//				}
		//				
		//				FragmentDescriptor fragmentDescriptor = new FragmentDescriptor(getNewFragmentId(), new ArrayList<IConstraintDescriptor>(), new ArrayList<ContainerDescriptor>());
		//				FragmentDescriptorState fragmentDescriptorState = new FragmentDescriptorState(fragmentDescriptor);
		//				SectionDescriptorState.this.addFragmentDescriptorState(fragmentDescriptorState);
		//			}
		//
		//		};
		//		manager.appendToGroup(ADD_GROUP, addPredefinedFragmentAction);
		return menu;
	}

	/**
	 * Returns the new Id for the section
	 * 
	 * @return the new Id for the section
	 */
	protected String getNewFragmentId() {
		for(int i = 0; i < 100; i++) { // no need to go to more than 100, because 100 is already a very big number of fragments
			boolean found = false; // indicates if the id has been found in already fragments or not
			String name = "fragment_" + i;
			Iterator<FragmentDescriptorState> it = sectionDescriptorState.getFragmentDescriptorStates().iterator();
			while(it.hasNext()) {
				FragmentDescriptorState fragmentDescriptorState = it.next();
				String id = fragmentDescriptorState.getDescriptor().getId();
				if(name.equalsIgnoreCase(id)) {
					found = true;
				}
			}

			if(!found) {
				return name;
			}
		}
		return "";
	}


}
