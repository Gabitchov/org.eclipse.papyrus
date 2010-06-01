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
package org.eclipse.papyrus.properties.tabbed.customization.state;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.papyrus.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.eclipse.papyrus.properties.runtime.view.FragmentDescriptor;
import org.eclipse.papyrus.properties.runtime.view.content.ContainerDescriptor;
import org.eclipse.papyrus.properties.runtime.view.content.ExpandableContainerDescriptor;
import org.eclipse.papyrus.properties.runtime.view.content.GroupContainerDescriptor;
import org.eclipse.papyrus.properties.tabbed.customization.Activator;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;


/**
 * state for Fragment descriptor
 */
public class FragmentDescriptorState extends AbstractState implements IMenuCreator {

	/** descriptor managed by this state */
	protected FragmentDescriptor descriptor;

	/** list of container descriptors state children of this state */
	protected final List<ContainerDescriptorState> containerDescriptorStates = new ArrayList<ContainerDescriptorState>();

	/** change support for this bean */
	private PropertyChangeSupport changeSupport;

	/** menu manager used to create elements */
	private MenuManager manager;

	/**
	 * Creates a new FragmentDescriptorState.
	 * 
	 * @param descriptor
	 *        the fragment descriptor managed by this state
	 */
	public FragmentDescriptorState(FragmentDescriptor descriptor) {
		this.descriptor = descriptor;

		// retrieve and build the states for the container children
		List<ContainerDescriptor> containerDescriptors = descriptor.getContainerDescriptors();
		for(ContainerDescriptor containerDescriptor : containerDescriptors) {
			containerDescriptorStates.add(new ContainerDescriptorState(containerDescriptor));
		}
		// register change support
		changeSupport = new PropertyChangeSupport(this);
	}

	public FragmentDescriptor getDescriptor() {
		return descriptor;
	}


	/**
	 * Returns the containerDescriptor States for this fragment
	 * 
	 * @return the containerDescriptor States for this fragment
	 */
	public List<ContainerDescriptorState> getContainerDescriptorStates() {
		return containerDescriptorStates;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEditionDialogId() {
		return "FragmentDescriptorStateDialog";
	}

	/**
	 * Adds a property change listener to this class
	 * 
	 * @param listener
	 *        the listener to add
	 */
	public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(listener);
	}

	/**
	 * Removes a property change listener from this class
	 * 
	 * @param listener
	 *        the listener to remove
	 */
	public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(listener);
	}

	/**
	 * Adds the {@link ContainerDescriptorState} to the list of descriptor states belonging to this fragment
	 * 
	 * @param containerDescriptorState
	 *        the state to add
	 */
	public void addContainerDescriptorState(ContainerDescriptorState containerDescriptorState) {
		containerDescriptorStates.add(containerDescriptorState);

		changeSupport.firePropertyChange(PROPERTY_ADD_CHILD, null, containerDescriptorStates);
	}

	/**
	 * Removes the {@link ContainerDescriptorState} from the list of descriptor states belonging to this fragment
	 * 
	 * @param containerDescriptorState
	 *        the state to remove
	 */
	public void removeContainerDescriptorState(ContainerDescriptorState containerDescriptorState) {
		containerDescriptorStates.remove(containerDescriptorState);

		changeSupport.firePropertyChange(PROPERTY_REMOVE_CHILD, null, containerDescriptorStates);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ContainerDescriptorState> getChildren() {
		return getContainerDescriptorStates();
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
		IAction removeAction = new Action("Remove Fragment", Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/delete.gif")) {

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
						((SectionDescriptorState)parent).removeFragmentDescriptorState(FragmentDescriptorState.this);
					}
				}
			}

		};
		manager.add(removeAction);
		manager.add(new Separator(ADD_GROUP));

		IAction addSimpleContainerAction = new Action("Add Simple Container", Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/NewSimpleContainer.gif")) {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void run() {
				// adds a simple container to the current element
				ContainerDescriptor containerDescriptor = new ContainerDescriptor(new GridLayout(), new ArrayList<IPropertyEditorControllerDescriptor>());
				ContainerDescriptorState containerDescriptorState = new ContainerDescriptorState(containerDescriptor);
				FragmentDescriptorState.this.addContainerDescriptorState(containerDescriptorState);
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

		IAction addExpandableContainerAction = new Action("Add Expandable Container", Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/NewExpandableContainer.gif")) {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void run() {
				// adds an expandable container to the current element
				ExpandableContainerDescriptor containerDescriptor = new ExpandableContainerDescriptor(new GridLayout(), "Label", new ArrayList<IPropertyEditorControllerDescriptor>());
				ContainerDescriptorState containerDescriptorState = new ContainerDescriptorState(containerDescriptor);
				FragmentDescriptorState.this.addContainerDescriptorState(containerDescriptorState);
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

		IAction addGroupContainerAction = new Action("Add Group Container", Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/NewGroupContainer.gif")) {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void run() {
				// adds an expandable container to the current element
				GroupContainerDescriptor containerDescriptor = new GroupContainerDescriptor(new GridLayout(), "Label", new ArrayList<IPropertyEditorControllerDescriptor>());
				ContainerDescriptorState containerDescriptorState = new ContainerDescriptorState(containerDescriptor);
				FragmentDescriptorState.this.addContainerDescriptorState(containerDescriptorState);

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

	/**
	 * {@inheritDoc}
	 */
	public Menu getMenu(Menu parent) {
		// nothing to do here
		return null;
	}
}
