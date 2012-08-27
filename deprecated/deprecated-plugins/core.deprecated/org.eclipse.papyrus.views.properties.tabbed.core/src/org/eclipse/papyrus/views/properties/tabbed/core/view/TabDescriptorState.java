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
package org.eclipse.papyrus.views.properties.tabbed.core.view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collections;
import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.state.AbstractState;
import org.eclipse.papyrus.views.properties.runtime.state.ITraversableModelElement;
import org.eclipse.papyrus.views.properties.runtime.view.IConfigurableDescriptor;
import org.eclipse.papyrus.views.properties.tabbed.core.Activator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * State for tab descriptors
 */
public class TabDescriptorState extends AbstractState {

	/** tab descriptor managed by this state */
	protected ITabDescriptor tabDescriptor;

	/** change support for this bean */
	private PropertyChangeSupport changeSupport;

	/** id of the tab descriptor */
	private String id;

	/** category of the tab descriptor */
	private String category;

	/** label of the tab descriptor */
	private String label;

	/** after tab info of the tab descriptor */
	private String afterTab;

	/**
	 * Creates a new TabDescriptorState.
	 * 
	 * @param tabDescriptor
	 *        tab descriptor managed by this state
	 * @param readOnly
	 *        read only mode of the descriptor
	 */
	public TabDescriptorState(ITabDescriptor tabDescriptor, boolean readOnly) {
		super(readOnly);
		this.tabDescriptor = tabDescriptor;
		this.id = tabDescriptor.getId();
		this.label = tabDescriptor.getLabel();
		this.afterTab = tabDescriptor.getAfterTab();
		this.category = tabDescriptor.getCategory();

		// register change support
		changeSupport = new PropertyChangeSupport(this);
	}


	/**
	 * Returns the tabDescriptor managed by this state
	 * 
	 * @return the tabDescriptor managed by this state
	 */
	public ITabDescriptor getTabDescriptor() {
		return tabDescriptor;
	}


	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return label + " (Caterory: " + category + ")";
	}

	/**
	 * Returns the id of the descriptor managed by this state
	 * 
	 * @return the id of the descriptor managed by this state
	 */
	public String getId() {
		return id;
	}

	/**
	 * Returns the label of the descriptor managed by this state
	 * 
	 * @return the label of the descriptor managed by this state
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Returns the after tab info of the descriptor managed by this state
	 * 
	 * @return the after tab info of the descriptor managed by this state
	 */
	public String getAfterTab() {
		return afterTab;
	}

	/**
	 * Returns the category of the descriptor managed by this state
	 * 
	 * @return the category of the descriptor managed by this state
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Sets the id of this tab
	 * 
	 * @param id
	 *        the identifier to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets the new label for this state
	 * 
	 * @param label
	 *        the new label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Sets the new after tab info for this state
	 * 
	 * @param afterTab
	 *        the new after tab to set
	 */
	public void setAfterTab(String afterTab) {
		this.afterTab = afterTab;
	}

	/**
	 * Sets the new category for this state
	 * 
	 * @param category
	 *        the new category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}


	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return Activator.getImage("/icons/Tab.gif");
	}


	/**
	 * {@inheritDoc}
	 */
	public IConfigurableDescriptor getDescriptor() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEditionDialogId() {
		return "TabDescriptorStateDialog";
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
	public Node generateNode(Document document) {
		Element tabDescriptorNode = document.createElement("tab");
		tabDescriptorNode.setAttribute("category", category);
		tabDescriptorNode.setAttribute("id", id);
		tabDescriptorNode.setAttribute("label", label);

		List<TabDescriptorState> tabDescriptorStates = StatesStore.getTabDescriptorStates();
		int index = tabDescriptorStates.indexOf(this);
		if(index != 0) {
			tabDescriptorNode.setAttribute("afterTab", tabDescriptorStates.get(index - 1).id);
		}

		return tabDescriptorNode;
	}


	/**
	 * {@inheritDoc}
	 */
	public List<? extends ITraversableModelElement> getChildren() {
		return Collections.emptyList();
	}
}
