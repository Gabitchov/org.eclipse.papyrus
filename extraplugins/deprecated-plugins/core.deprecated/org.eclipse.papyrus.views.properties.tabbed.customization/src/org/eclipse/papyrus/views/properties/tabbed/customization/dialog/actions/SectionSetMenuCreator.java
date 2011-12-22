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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.views.properties.tabbed.core.view.SectionSetDescriptorState;
import org.eclipse.papyrus.views.properties.tabbed.customization.Activator;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.uml2.uml.Stereotype;


/**
 * Menu creator for section sets
 */
public class SectionSetMenuCreator extends AbstractMenuCreator {

	/** list of states */
	private final List<SectionSetDescriptorState> sectionSetDescriptorStates;

	/** menu manager used to create elements */
	private MenuManager manager;

	/** tree viewer displaying elements */
	private TreeViewer metamodelViewer;

	/**
	 * Creates a new SectionSetMenuCreator.
	 * 
	 * @param sectionSetDescriptorState
	 *        state on which the menu is created
	 */
	public SectionSetMenuCreator(List<SectionSetDescriptorState> sectionSetDescriptorStates, TreeViewer metamodelViewer, SectionSetDescriptorState sectionSetDescriptorState, EClassifier currentMetaclass, Stereotype currentStereotype) {
		super(sectionSetDescriptorState, currentMetaclass, currentStereotype);
		this.sectionSetDescriptorStates = sectionSetDescriptorStates;
		this.metamodelViewer = metamodelViewer;
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
		IAction removeAction = new Action("Remove Section Set", Activator.imageDescriptorFromPlugin(Activator.ID, "/icons/delete.gif")) {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void run() {
				// remove this section descriptor set state from its parent
				sectionSetDescriptorStates.remove(getSectionSetDescriptorState());
				metamodelViewer.refresh();
			}

		};
		manager.add(removeAction);
		manager.add(new Separator(ADD_GROUP));

		return menu;
	}

}
