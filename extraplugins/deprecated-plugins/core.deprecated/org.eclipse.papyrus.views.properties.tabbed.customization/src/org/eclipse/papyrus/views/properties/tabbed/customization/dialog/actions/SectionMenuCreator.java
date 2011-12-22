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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.papyrus.views.properties.runtime.state.IFragmentDescriptorState;
import org.eclipse.papyrus.views.properties.runtime.view.FragmentDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.FragmentDescriptorState;
import org.eclipse.papyrus.views.properties.runtime.view.PredefinedFragmentDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.PredefinedFragmentDescriptorState;
import org.eclipse.papyrus.views.properties.runtime.view.PropertyViewService;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.ConstraintDescriptorState;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.ObjectTypeConstraintDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.content.ContainerDescriptor;
import org.eclipse.papyrus.views.properties.tabbed.core.view.SectionDescriptorState;
import org.eclipse.papyrus.views.properties.tabbed.core.view.SectionSetDescriptorState;
import org.eclipse.papyrus.views.properties.tabbed.customization.Activator;
import org.eclipse.papyrus.views.properties.tabbed.customization.dialog.ContentHolder;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.uml2.uml.Stereotype;


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
	public SectionMenuCreator(SectionDescriptorState sectionDescriptorState, SectionSetDescriptorState sectionSetDescriptorState, EClassifier currentMetaclass, Stereotype currentStereotype) {
		super(sectionSetDescriptorState, currentMetaclass, currentStereotype);
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
		if(getCurrentMetaclass() != null) {
			selectionClass = getCurrentMetaclass().getInstanceClass();
		}
		final Class<?> finalSelectionClass = selectionClass;
		SectionSetDescriptorState currentSectionSetDescriptorState = getSectionSetDescriptorState();
		if(currentSectionSetDescriptorState == null) {
			return menu;
		}
		final List<ConstraintDescriptorState> constraintDescriptorStates = getSectionSetDescriptorState().getConstraintDescriptorStates();

		final int selectionSize = currentSectionSetDescriptorState.getSelectionSize();

		IAction addFragmentAction = new Action("Add New Fragment", Activator.imageDescriptorFromPlugin(Activator.ID, "/icons/NewFragment.gif")) {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void run() {
				// adds a fragment to the current element
				FragmentDescriptor fragmentDescriptor = new FragmentDescriptor(getNewFragmentId(getCurrentMetaclass(), getCurrentStereotype(), selectionSize), new ArrayList<IConstraintDescriptor>(), new ArrayList<ContainerDescriptor>(), getSectionSetDescriptorState().getSelectionSize());
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
					if(selectionClass != null && elementClass.isAssignableFrom(selectionClass)) {

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
	 * @param selectionClass
	 *        the selected class
	 * @param selectionSize
	 *        size of the selection
	 * 
	 * @return the new Id for the section
	 */
	protected String getNewFragmentId(EClassifier selectionClass, Stereotype stereotype, int selectionSize) {
		for(int i = 0; i < 100; i++) { // no need to go to more than 100, because 100 is already a very big number of fragments
			boolean found = false; // indicates if the id has been found in already fragments or not

			StringBuffer buffer = new StringBuffer();
			buffer.append("fragment_");
			if(selectionSize == 1) {
				buffer.append("single");
			} else if(selectionSize < 0) {
				buffer.append("multi");
			} else {
				buffer.append(selectionSize);
			}
			buffer.append("_");

			if(selectionClass != null && selectionClass.getInstanceClass() != null) {
				buffer.append(selectionClass.getInstanceClass().getSimpleName());
			} else if(stereotype != null && stereotype.getName() != null) {
				buffer.append(stereotype.getName());
			} else {
				buffer.append("NoName");
			}
			if(i > 0) {
				buffer.append(i);
			}
			String name = buffer.toString();

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
