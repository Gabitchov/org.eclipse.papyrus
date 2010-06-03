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
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gmt.modisco.infra.browser.uicore.internal.model.ModelElementItem;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.properties.runtime.view.constraints.ObjectTypeConstraintDescriptor;
import org.eclipse.papyrus.properties.tabbed.core.view.DynamicSectionDescriptor;
import org.eclipse.papyrus.properties.tabbed.core.view.SectionSetDescriptor;
import org.eclipse.papyrus.properties.tabbed.core.view.SectionSetDescriptorState;
import org.eclipse.papyrus.properties.tabbed.customization.Activator;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;


/**
 * Menu creator for section sets
 */
public class EClassifierMenuCreator extends AbstractMenuCreator {

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
	public EClassifierMenuCreator(ModelElementItem item, List<SectionSetDescriptorState> sectionSetDescriptorStates, TreeViewer treeViewer) {
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

		IAction createAction = new Action("Create Section Set", Activator.imageDescriptorFromPlugin(Activator.ID, "/icons/NewSectionSet.gif")) {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void run() {
				// remove this section descriptor set state from its parent
				// create the constraint for the kind of object
				List<IConstraintDescriptor> constraints = new ArrayList<IConstraintDescriptor>();

				EClassifier classifier = ((EClassifier)item.getEObject());
				String qualifiedInstanceClassName = classifier.getInstanceClassName();
				Class<?> metamodelClass;
				try {
					metamodelClass = Class.forName(qualifiedInstanceClassName);
					ObjectTypeConstraintDescriptor constraintDescriptor = new ObjectTypeConstraintDescriptor(metamodelClass);
					constraints.add(constraintDescriptor);
					SectionSetDescriptor descriptor = new SectionSetDescriptor(getNewSectionSetName(), new ArrayList<DynamicSectionDescriptor>(), constraints, 1);
					SectionSetDescriptorState state = descriptor.createState();
					sectionSetDescriptorStates.add(state);
					treeViewer.refresh();
					// try to select the new element
					treeViewer.setSelection(new TreeSelection(new TreePath(new Object[]{ item, state })));
				} catch (ClassNotFoundException e) {
					Activator.log.error(e);
				}

			}
		};
		manager.add(new Separator(ADD_GROUP));
		manager.appendToGroup(ADD_GROUP, createAction);

		return menu;
	}

	protected String getNewSectionSetName() {
		for(int i = 0; i < 100; i++) { // no need to go to more than 100, because 100 is already a very big number of fragments
			boolean found = false; // indicates if the id has been found in already fragments or not
			String name = "sectionSet_" + i;
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
