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
import org.eclipse.papyrus.properties.runtime.controller.PropertyEditorControllerService;
import org.eclipse.papyrus.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.eclipse.papyrus.properties.runtime.state.AbstractState;
import org.eclipse.papyrus.properties.runtime.view.constraints.ConstraintDescriptorState;
import org.eclipse.papyrus.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.properties.runtime.view.constraints.ObjectTypeConstraintDescriptor;
import org.eclipse.papyrus.properties.runtime.view.content.AbstractContainerDescriptor;
import org.eclipse.papyrus.properties.runtime.view.content.ContainerDescriptor;
import org.eclipse.papyrus.properties.tabbed.customization.Activator;
import org.eclipse.papyrus.properties.tabbed.customization.dialog.ContentHolder;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;


/**
 * State for the container descriptors. this is used to do some customization on elements
 */
public class ContainerDescriptorState extends AbstractState implements IMenuCreator {

	/** descriptor managed by this state */
	protected AbstractContainerDescriptor descriptor;

	/** list of controllers managed by this state */
	protected final List<ControllerDescriptorState> controllerDescriptorStates = new ArrayList<ControllerDescriptorState>();

	/** change support for this bean */
	private PropertyChangeSupport changeSupport;

	/** menu manager used to create elements */
	private MenuManager manager;


	/**
	 * Creates a new ContainerDescriptorState.
	 * 
	 * @param descriptor
	 *        the descriptor managed by this state
	 */
	public ContainerDescriptorState(ContainerDescriptor descriptor) {
		this.descriptor = descriptor;

		// read the current list of controller descriptor managed by this state
		List<IPropertyEditorControllerDescriptor> controllerDescriptors = descriptor.getUnparsedControllerDescriptors();
		for(IPropertyEditorControllerDescriptor controllerDescriptor : controllerDescriptors) {
			controllerDescriptorStates.add(new ControllerDescriptorState(controllerDescriptor));
		}
		// register change support
		changeSupport = new PropertyChangeSupport(this);
	}

	/**
	 * Returns the descriptor described by this state
	 * 
	 * @return the descriptor described by this state
	 */
	public AbstractContainerDescriptor getDescriptor() {
		return descriptor;
	}


	/**
	 * Returns the controllerDescriptor States for this descriptor
	 * 
	 * @return the controllerDescriptor States for this descriptor
	 */
	public List<ControllerDescriptorState> getControllerDescriptorStates() {
		return controllerDescriptorStates;
	}


	/**
	 * {@inheritDoc}
	 */
	public String getEditionDialogId() {
		return "ContainerDescriptorStateDialog";
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
	 * Adds a Property editor controller state to the list of controller states owned by this Container descriptor state
	 * 
	 * @param state
	 *        the state to add
	 */
	public void addPropertyEditorControllerState(ControllerDescriptorState state) {
		controllerDescriptorStates.add(state);

		changeSupport.firePropertyChange(PROPERTY_ADD_CHILD, null, controllerDescriptorStates);
	}

	/**
	 * Removes a Property editor controller state to the list of controller states owned by this Container descriptor state
	 * 
	 * @param state
	 *        the state to remove
	 */
	public void removePropertyEditorControllerState(ControllerDescriptorState state) {
		controllerDescriptorStates.remove(state);

		changeSupport.firePropertyChange(PROPERTY_REMOVE_CHILD, null, controllerDescriptorStates);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ControllerDescriptorState> getChildren() {
		return getControllerDescriptorStates();
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
		IAction removeAction = new Action("Remove Container", Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/delete.gif")) {

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
					if((parent instanceof FragmentDescriptorState)) {
						((FragmentDescriptorState)parent).removeContainerDescriptorState(ContainerDescriptorState.this);
					}
				}
			}

		};
		manager.add(removeAction);
		manager.add(new Separator(ADD_GROUP));
		Class<?> selectionClass = null;
		if(parent instanceof Tree) {
			Tree tree = (Tree)parent;
			TreeItem[] items = tree.getSelection();
			if(items.length < 1) {
				Activator.log.warn("impossible to find an element in the selection");
				return menu;
			}
			TreeItem root = retrieveRoot(items[0]);
			if(root != null) {
				Object rootElement = root.getData();
				if(rootElement instanceof ContentHolder) {
					List<ConstraintDescriptorState> constraintDescriptorStates = ((ContentHolder)rootElement).getSectionSetDescriptorState().getConstraintDescriptorStates();
					for(ConstraintDescriptorState constraintDescriptorState : constraintDescriptorStates) {
						IConstraintDescriptor descriptor = constraintDescriptorState.getDescriptor();
						if(descriptor instanceof ObjectTypeConstraintDescriptor) { // check class compatibility. Should also check the other constraints...
							selectionClass = ((ObjectTypeConstraintDescriptor)descriptor).getElementClass();
						}
					}
				}
			}
		}

		// action to add a predefined controller => must retrieve the list of predefined controllers for this element
		// => find the correct predefined controllers ? They should meet the constraints
		List<IPropertyEditorControllerDescriptor> predefinedDescriptors = PropertyEditorControllerService.getInstance().getAllPredefinedControllers();

		for(final IPropertyEditorControllerDescriptor propertyEditorControllerDescriptor : predefinedDescriptors) {
			for(IConstraintDescriptor constraintDescriptor : propertyEditorControllerDescriptor.getConstraintDescriptors()) {
				if(constraintDescriptor instanceof ObjectTypeConstraintDescriptor) {
					Class<?> elementClass = ((ObjectTypeConstraintDescriptor)constraintDescriptor).getElementClass();
					// check element class is compatible
					if(elementClass.isAssignableFrom(selectionClass)) {
						// build the action to add the controller
						IAction action = new Action("Add Predefined Controller " + propertyEditorControllerDescriptor.getText(), Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/NewPredefinedController.gif")) {

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
									ControllerDescriptorState state = new ControllerDescriptorState(propertyEditorControllerDescriptor);
									ContainerDescriptorState.this.addPropertyEditorControllerState(state);
								}
							}

						};
						manager.appendToGroup(ADD_GROUP, action);
					}
				}
			}
		}

		return menu;
	}

	protected TreeItem retrieveRoot(TreeItem item) {
		if(item.getParentItem() == null) {
			return item;
		}
		return retrieveRoot(item.getParentItem());
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
