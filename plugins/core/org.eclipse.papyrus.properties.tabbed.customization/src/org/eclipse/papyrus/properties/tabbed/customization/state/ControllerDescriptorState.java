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
import java.util.Collections;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.papyrus.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.eclipse.papyrus.properties.tabbed.customization.Activator;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;


/**
 * State for controller descriptors
 */
public class ControllerDescriptorState extends AbstractState implements IMenuCreator {

	/** identifier for the controller descriptor editor dialog */
	private static final String CONTROLLER_DESCRIPTOR_EDITOR_DLG = "ControllerDescriptorEditorDialog";

	/** descriptor managed by this state */
	protected IPropertyEditorControllerDescriptor descriptor;

	/** id of the controller managed by this state */
	protected String id;

	/** change support for this bean */
	private PropertyChangeSupport changeSupport;

	/** menu manager used to create elements */
	private MenuManager manager;

	/**
	 * Creates a new ControllerDescriptorState.
	 * 
	 */
	public ControllerDescriptorState(IPropertyEditorControllerDescriptor descriptor) {
		this.descriptor = descriptor;
		id = descriptor.getControllerID();

		// register change support
		changeSupport = new PropertyChangeSupport(this);
	}

	/**
	 * Returns the descriptor managed by this state
	 * 
	 * @return the descriptor managed by this state
	 */
	public IPropertyEditorControllerDescriptor getDescriptor() {
		return descriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEditionDialogId() {
		return CONTROLLER_DESCRIPTOR_EDITOR_DLG;
	}

	/**
	 * Sets the id of the controller managed by this state
	 * 
	 * @param id
	 *        the id to set
	 */
	public void setId(String id) {
		String oldId = this.id;
		this.id = id;

		changeSupport.firePropertyChange("id", oldId, id);
	}

	/**
	 * Returns the id of the controller managed by this state
	 * 
	 * @return the id of the controller managed by this state
	 */
	public String getId() {
		return id;
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
	 * {@inheritDoc}
	 */
	public List<ITraversableModelElement> getChildren() {
		return Collections.emptyList();
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
		IAction removeAction = new Action("Remove Controller", Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/delete.gif")) {

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
						((ContainerDescriptorState)parent).removePropertyEditorControllerState(ControllerDescriptorState.this);
					}
				}
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

	/**
	 * {@inheritDoc}
	 */
	public Menu getMenu(Menu parent) {
		// nothing to do here
		return null;
	}

}
