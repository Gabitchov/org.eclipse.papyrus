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
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ModelElementItem;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.AppliedStereotypeConstraintDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.views.properties.tabbed.core.view.DynamicSectionDescriptor;
import org.eclipse.papyrus.views.properties.tabbed.core.view.SectionSetDescriptor;
import org.eclipse.papyrus.views.properties.tabbed.core.view.SectionSetDescriptorState;
import org.eclipse.papyrus.views.properties.tabbed.customization.Activator;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.uml2.uml.Stereotype;


/**
 * Menu creator for section sets
 */
@SuppressWarnings("restriction")
public class StereotypeMenuCreator extends AbstractMenuCreator {

	/** element on which the menu should be created */
	private final ModelElementItem item;

	/** menu manager used to create elements */
	private MenuManager manager;

	/** list of available section set descriptors */
	private final List<SectionSetDescriptorState> sectionSetDescriptorStates;

	/** tree viewer that displays the element */
	private TreeViewer treeViewer;

	/**
	 * Creates a new EClassifierMenuCreator.
	 * 
	 * @param object
	 *        object on which the menu is created
	 */
	public StereotypeMenuCreator(ModelElementItem item, List<SectionSetDescriptorState> sectionSetDescriptorStates, TreeViewer treeViewer, SectionSetDescriptorState sectionSetDescriptorState, EClassifier currentMetaclass, Stereotype currentStereotype) {
		super(sectionSetDescriptorState, currentMetaclass, currentStereotype);
		this.item = item;
		this.sectionSetDescriptorStates = sectionSetDescriptorStates;
		this.treeViewer = treeViewer;
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

		// create a new SectionSetDescriptor state
		menu = manager.createContextMenu(parent);

		IAction createAction = new Action("Create Section Set for single selection", Activator.imageDescriptorFromPlugin(Activator.ID, "/icons/NewSectionSet.gif")) {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void run() {
				// remove this section descriptor set state from its parent
				// create the constraint for the kind of object
				List<IConstraintDescriptor> constraints = new ArrayList<IConstraintDescriptor>();

				AppliedStereotypeConstraintDescriptor constraintDescriptor = new AppliedStereotypeConstraintDescriptor(Arrays.asList(getCurrentStereotype().getQualifiedName()));
				constraints.add(constraintDescriptor);
				SectionSetDescriptor descriptor = new SectionSetDescriptor(getNewSectionSetName(1), new ArrayList<DynamicSectionDescriptor>(), constraints, 1);
				SectionSetDescriptorState state = descriptor.createState(false);
				sectionSetDescriptorStates.add(state);
				treeViewer.refresh();
				// try to select the new element
				treeViewer.setSelection(new TreeSelection(new TreePath(new Object[]{ item, state })));

			}
		};
		manager.add(new Separator(ADD_GROUP));
		manager.appendToGroup(ADD_GROUP, createAction);

		IAction createMultipleElementAction = new Action("Create Section Set for multiple selection", Activator.imageDescriptorFromPlugin(Activator.ID, "/icons/NewSectionSet.gif")) {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void run() {
				// remove this section descriptor set state from its parent
				// create the constraint for the kind of object
				List<IConstraintDescriptor> constraints = new ArrayList<IConstraintDescriptor>();

				AppliedStereotypeConstraintDescriptor constraintDescriptor = new AppliedStereotypeConstraintDescriptor(Arrays.asList(getCurrentStereotype().getQualifiedName()));
				constraints.add(constraintDescriptor);
				SectionSetDescriptor descriptor = new SectionSetDescriptor(getNewSectionSetName(-1), new ArrayList<DynamicSectionDescriptor>(), constraints, -1);
				SectionSetDescriptorState state = descriptor.createState(false);
				sectionSetDescriptorStates.add(state);
				treeViewer.refresh();
				// try to select the new element
				treeViewer.setSelection(new TreeSelection(new TreePath(new Object[]{ item, state })));

			}
		};
		manager.appendToGroup(ADD_GROUP, createMultipleElementAction);

		return menu;
	}

	protected String getNewSectionSetName(int selectionSize) {
		for(int i = 0; i < 100; i++) { // no need to go to more than 100, because 100 is already a very big number of fragments
			boolean found = false; // indicates if the id has been found in already fragments or not


			StringBuffer buffer = new StringBuffer();
			buffer.append("sectionSet_");
			if(selectionSize == 1) {
				buffer.append("single");
			} else if(selectionSize < 0) {
				buffer.append("multi");
			} else {
				buffer.append(selectionSize);
			}
			buffer.append("_");

			if(getCurrentStereotype() != null && getCurrentStereotype().getQualifiedName() != null) {
				buffer.append(getCurrentStereotype().getQualifiedName());
			} else {
				buffer.append("NoName");
			}
			if(i > 0) {
				buffer.append(i);
			}
			String name = buffer.toString();

			Iterator<SectionSetDescriptorState> it = sectionSetDescriptorStates.iterator();
			while(it.hasNext()) {
				SectionSetDescriptorState sectionSetDescriptorState = it.next();
				String id = sectionSetDescriptorState.getDescriptor().getName();
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
