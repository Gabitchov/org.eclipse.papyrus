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
import org.eclipse.papyrus.properties.runtime.view.FragmentDescriptor;
import org.eclipse.papyrus.properties.runtime.view.PropertyViewService;
import org.eclipse.papyrus.properties.tabbed.core.view.DynamicSectionDescriptor;
import org.eclipse.papyrus.properties.tabbed.customization.Activator;
import org.eclipse.papyrus.properties.tabbed.customization.dialog.ContentHolder;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;


/**
 * State for section descriptors
 */
public class SectionDescriptorState extends AbstractState implements IMenuCreator {

	/** section descriptor managed by this state */
	protected DynamicSectionDescriptor sectionDescriptor;

	/** list of fragment descriptor states */
	private List<FragmentDescriptorState> fragmentDescriptorStates = new ArrayList<FragmentDescriptorState>();

	/** change support for this bean */
	private PropertyChangeSupport changeSupport;

	/** id of the section managed by this state */
	protected String id;

	/** id of the tab in which the section managed by this state is */
	protected String targetTab;

	/** menu manager used to create elements */
	private MenuManager manager;

	/**
	 * Creates a new SectionDescriptorState.
	 * 
	 * @param sectionDescriptor
	 *        the section descriptor managed by this state
	 */
	public SectionDescriptorState(DynamicSectionDescriptor sectionDescriptor) {
		this.sectionDescriptor = sectionDescriptor;
		id = sectionDescriptor.getId();
		targetTab = sectionDescriptor.getTargetTab();

		List<String> fragmentIds = sectionDescriptor.getFragmentsId();
		for(String id : fragmentIds) {
			/// retrieve the descriptor and creates a state on it
			FragmentDescriptor fragmentDescriptor = PropertyViewService.getInstance().getFragmentDescriptor(id);
			if(fragmentDescriptor != null) {
				getFragmentDescriptorStates().add(new FragmentDescriptorState(fragmentDescriptor));
			}
		}
		// register change support
		changeSupport = new PropertyChangeSupport(this);
	}

	/**
	 * Returns the section Descriptor managed by this state
	 * 
	 * @return the section Descriptor managed by this state
	 */
	public DynamicSectionDescriptor getDescriptor() {
		return sectionDescriptor;
	}

	/**
	 * Returns the fragmentDescriptor States for the section descriptor
	 * 
	 * @return the fragmentDescriptorStates for the section descriptor
	 */
	public List<FragmentDescriptorState> getFragmentDescriptorStates() {
		return fragmentDescriptorStates;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEditionDialogId() {
		return "SectionDescriptorStateDialog";
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
	 * Sets the targetTab
	 * 
	 * @param targetTab
	 *        the targetTab to set
	 */
	public void setTargetTab(String targetTab) {
		String oldTargetTab = this.targetTab;
		this.targetTab = targetTab;

		changeSupport.firePropertyChange("targetTab", oldTargetTab, targetTab);
	}

	/**
	 * Returns the targetTab
	 * 
	 * @return the targetTab
	 */
	public String getTargetTab() {
		return targetTab;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return "Section: " + getId() + " in tab: " + getTargetTab();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<? extends ITraversableModelElement> getChildren() {
		return getFragmentDescriptorStates();
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
		IAction action = new Action("Remove Section", Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/delete.gif")) {

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
						sectionSetDescriptorState.removeSectionDescriptorState(SectionDescriptorState.this);
					}
				}
			}

		};

		manager.add(action);
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
		// nothing to do
		return null;
	}
}
