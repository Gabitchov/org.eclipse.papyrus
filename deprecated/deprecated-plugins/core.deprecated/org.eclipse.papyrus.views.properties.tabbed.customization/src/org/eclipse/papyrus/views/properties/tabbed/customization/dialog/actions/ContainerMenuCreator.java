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

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.papyrus.views.properties.runtime.controller.PropertyEditorControllerService;
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.ControllerDescriptorState;
import org.eclipse.papyrus.views.properties.runtime.controller.predefined.PredefinedControllerDescriptor;
import org.eclipse.papyrus.views.properties.runtime.controller.predefined.PredefinedControllerState;
import org.eclipse.papyrus.views.properties.runtime.view.FragmentDescriptorState;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.AppliedStereotypeConstraintDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.ConstraintDescriptorState;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.ObjectTypeConstraintDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.content.ContainerDescriptorState;
import org.eclipse.papyrus.views.properties.tabbed.core.view.SectionSetDescriptorState;
import org.eclipse.papyrus.views.properties.tabbed.customization.Activator;
import org.eclipse.papyrus.views.properties.tabbed.customization.dialog.ContentHolder;
import org.eclipse.papyrus.views.properties.tabbed.customization.state.ConstraintStateUtils;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.uml2.uml.Stereotype;


/**
 * Menu creator for {@link ContainerDescriptorState}
 */
public class ContainerMenuCreator extends AbstractMenuCreator {

	/** element on which the menu should be created */
	private final ContainerDescriptorState containerDescriptorState;

	/** menu manager used to create elements */
	private MenuManager manager;

	/**
	 * Creates a new ContainerMenuCreator.
	 * 
	 * @param containerDescriptorState
	 *        the state on which this menu is created
	 */
	public ContainerMenuCreator(ContainerDescriptorState containerDescriptorState, SectionSetDescriptorState sectionSetDescriptorState, EClassifier currentMetaclass, Stereotype currentStereotype) {
		super(sectionSetDescriptorState, currentMetaclass, currentStereotype);
		this.containerDescriptorState = containerDescriptorState;
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
		IAction removeAction = new Action("Remove Container", Activator.imageDescriptorFromPlugin(Activator.ID, "/icons/delete.gif")) {

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
						((FragmentDescriptorState)parent).removeContainerDescriptorState(containerDescriptorState);
					}
				}
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean isEnabled() {
				ContainerDescriptorState state = getSelectedContainerDescriptorState(parent);
				if(state == null || state.isReadOnly()) {
					setEnabled(false);
				}
				return super.isEnabled();
			}

		};
		manager.add(removeAction);
		manager.add(new Separator(ADD_GROUP));

		ContainerDescriptorState state = getSelectedContainerDescriptorState(parent);
		if(state == null || state.isReadOnly()) {
			return menu;
		}

		Class<?> selectionClass = null;
		List<String> appliedStereotypes = null;
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
						} else if(descriptor instanceof AppliedStereotypeConstraintDescriptor) {
							appliedStereotypes = ((AppliedStereotypeConstraintDescriptor)descriptor).getStereotypeQualifiedNames();
						}
					}
				}
			}
		}

		// action to add a predefined controller => must retrieve the list of predefined controllers for this element
		// => find the correct predefined controllers ? They should meet the constraints
		Map<String, PredefinedControllerDescriptor> predefinedDescriptors = PropertyEditorControllerService.getInstance().getAllPredefinedControllers();

		for(final String predefinedId : predefinedDescriptors.keySet()) {
			final PredefinedControllerDescriptor propertyEditorControllerDescriptor = predefinedDescriptors.get(predefinedId);
			List<IConstraintDescriptor> constraints = propertyEditorControllerDescriptor.getConstraintDescriptors();

			boolean isValid = ConstraintStateUtils.areCompatible(constraints, getSectionSetDescriptorState().getConstraintDescriptorStates());

			if(isValid) {
				// build the action to add the controller
				IAction action = new Action("Add " + propertyEditorControllerDescriptor.getText() + " (" + propertyEditorControllerDescriptor.getPredefinedId() + ")", Activator.imageDescriptorFromPlugin(Activator.ID, "/icons/NewPredefinedController.gif")) {

					/**
					 * {@inheritDoc}
					 */
					@Override
					public void run() {
						// add this section descriptor state from its parent
						if(parent instanceof Tree) {
							TreeItem[] selectedItems = ((Tree)parent).getSelection();
							if(selectedItems.length < 1) {
								Activator.log.warn("Impossible to find the current selection in the tree");
								return;
							}
							ControllerDescriptorState state = new PredefinedControllerState(propertyEditorControllerDescriptor, false);
							containerDescriptorState.addPropertyEditorControllerState(state);
						}
					}

				};
				manager.appendToGroup(ADD_GROUP, action);
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
	 * Returns the current selected container
	 * 
	 * @return the current selected container or null
	 */
	protected ContainerDescriptorState getSelectedContainerDescriptorState(Object parent) {
		if(parent instanceof Tree) {
			TreeItem[] selectedItems = ((Tree)parent).getSelection();
			if(selectedItems.length < 1) {
				Activator.log.warn("Impossible to find the current selection in the tree");
				return null;
			}
			TreeItem selectedItem = selectedItems[0];
			Object data = selectedItem.getData();
			if(data instanceof ContainerDescriptorState) {
				return ((ContainerDescriptorState)data);
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
}
