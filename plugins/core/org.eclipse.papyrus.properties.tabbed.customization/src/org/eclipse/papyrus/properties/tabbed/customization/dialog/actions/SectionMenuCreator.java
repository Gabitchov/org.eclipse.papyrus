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
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.papyrus.properties.runtime.state.IFragmentDescriptorState;
import org.eclipse.papyrus.properties.runtime.view.FragmentDescriptor;
import org.eclipse.papyrus.properties.runtime.view.FragmentDescriptorState;
import org.eclipse.papyrus.properties.runtime.view.PredefinedFragmentDescriptor;
import org.eclipse.papyrus.properties.runtime.view.PredefinedFragmentDescriptorState;
import org.eclipse.papyrus.properties.runtime.view.PropertyViewService;
import org.eclipse.papyrus.properties.runtime.view.constraints.ConstraintDescriptorState;
import org.eclipse.papyrus.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.properties.runtime.view.constraints.ObjectTypeConstraintDescriptor;
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

		Class<?> selectionClass = null;
		final List<ConstraintDescriptorState> constraintDescriptorStates = getConstraintDescriptorStates(parent);

		if(constraintDescriptorStates != null) {
			for(ConstraintDescriptorState constraintDescriptorState : constraintDescriptorStates) {
				IConstraintDescriptor descriptor = constraintDescriptorState.getDescriptor();
				if(descriptor instanceof ObjectTypeConstraintDescriptor) { // check only class compatibility. Should also check the other constraints...
					selectionClass = ((ObjectTypeConstraintDescriptor)descriptor).getElementClass();
				}
			}
		}

		if(getCurrentSectionSetDescriptorState(parent) == null) {
			return menu;
		}
		IAction addFragmentAction = new Action("Add New Fragment", Activator.imageDescriptorFromPlugin(Activator.ID, "/icons/NewFragment.gif")) {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void run() {
				// adds a fragment to the current element
				FragmentDescriptor fragmentDescriptor = new FragmentDescriptor(getNewFragmentId(), new ArrayList<IConstraintDescriptor>(), new ArrayList<ContainerDescriptor>(), getCurrentSectionSetDescriptorState(parent).getSelectionSize());
				FragmentDescriptorState fragmentDescriptorState = new FragmentDescriptorState(fragmentDescriptor, false);

				// retrieve constraints from current section set
				for(ConstraintDescriptorState state : constraintDescriptorStates) {
					fragmentDescriptorState.addConstraintDescriptorState(state);
				}
				sectionDescriptorState.addFragmentDescriptorState(fragmentDescriptorState);
			}

		};
		manager.appendToGroup(ADD_GROUP, addFragmentAction);
		// adds a fragment to the current element

		IAction addReplacedSectionAction = new Action("Add New replaced section", Activator.imageDescriptorFromPlugin(Activator.ID, "/icons/NewReplacedSection.gif")) {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void run() {
				// adds a fragment to the current element
				sectionDescriptorState.addReplacedSectionState(sectionDescriptorState.new ReplacedSectionState(""));
			}

		};
		manager.appendToGroup(ADD_GROUP, addReplacedSectionAction);


		Map<String, FragmentDescriptor> availableFragmentDescriptors = PropertyViewService.getInstance().getAllFragmentDescriptors();

		for(final FragmentDescriptor descriptor : availableFragmentDescriptors.values()) {
			// check constraints 
			for(IConstraintDescriptor constraintDescriptor : descriptor.getConstraintDescriptors()) {
				if(constraintDescriptor instanceof ObjectTypeConstraintDescriptor) {
					Class<?> elementClass = ((ObjectTypeConstraintDescriptor)constraintDescriptor).getElementClass();
					// check element class is compatible
					if(elementClass.isAssignableFrom(selectionClass)) {


						IAction addPredefinedFragmentAction = new Action("Add Predefined " + descriptor.getText(), Activator.imageDescriptorFromPlugin(Activator.ID, "/icons/NewFragment.gif")) {

							/**
							 * {@inheritDoc}
							 */
							@Override
							public void run() {
								// add this fragment descriptor state from its parent
								if(parent instanceof Tree) {
									TreeItem[] selectedItems = ((Tree)parent).getSelection();
									if(selectedItems.length < 1) {
										Activator.log.warn("Impossible to find the current selection in the tree");
										return;
									}
									PredefinedFragmentDescriptor predefinedFragmentDescriptor = new PredefinedFragmentDescriptor(descriptor.getId());
									PredefinedFragmentDescriptorState state = new PredefinedFragmentDescriptorState(predefinedFragmentDescriptor, false);
									sectionDescriptorState.addFragmentDescriptorState(state);
								}
							}

						};
						manager.appendToGroup(ADD_GROUP, addPredefinedFragmentAction);
					}
				}
			}
		}

		return menu;
	}

	/**
	 * returns the current {@link SectionSetDescriptorState}
	 * 
	 * @param parent
	 *        the tree element
	 * @return the current section set descriptor state edited or <code>null</code>.
	 */
	protected SectionSetDescriptorState getCurrentSectionSetDescriptorState(Object parent) {
		if(parent instanceof Tree) {
			Tree tree = (Tree)parent;
			TreeItem[] items = tree.getSelection();
			if(items.length < 1) {
				Activator.log.warn("impossible to find an element in the selection");
				return null;
			}
			TreeItem root = retrieveRoot(items[0]);
			if(root != null) {
				Object rootElement = root.getData();
				if(rootElement instanceof ContentHolder) {
					return ((ContentHolder)rootElement).getSectionSetDescriptorState();
				}
			}
		}
		return null;
	}

	/**
	 * Returns the list of constraint descriptor states for the current selected section set descriptor state
	 * 
	 * @return the list of constraint descriptor states for the current selected section set descriptor state or an empty list
	 */
	private List<ConstraintDescriptorState> getConstraintDescriptorStates(Object parent) {
		SectionSetDescriptorState state = getCurrentSectionSetDescriptorState(parent);

		if(state != null) {
			return state.getConstraintDescriptorStates();
		}
		return Collections.emptyList();
	}

	/**
	 * Retrieves the root item in the tree
	 * 
	 * @param item
	 *        the current item
	 * @return the root item in the tree
	 */
	protected TreeItem retrieveRoot(TreeItem item) {
		if(item.getParentItem() == null) {
			return item;
		}
		return retrieveRoot(item.getParentItem());
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
			Iterator<IFragmentDescriptorState> it = sectionDescriptorState.getFragmentDescriptorStates().iterator();
			while(it.hasNext()) {
				IFragmentDescriptorState fragmentDescriptorState = it.next();
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
