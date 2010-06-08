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

import org.eclipse.papyrus.properties.runtime.state.AbstractState;
import org.eclipse.papyrus.properties.runtime.state.ITraversableModelElement;
import org.eclipse.papyrus.properties.runtime.view.IConfigurableDescriptor;
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

	/**
	 * Creates a new TabDescriptorState.
	 * 
	 * @param tabDescriptor
	 *        tab descriptor managed by this state
	 */
	public TabDescriptorState(ITabDescriptor tabDescriptor, boolean readOnly) {
		super(readOnly);
		this.tabDescriptor = tabDescriptor;

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
		return "NotImplemented: TabDescriptorState";
	}


	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return null;
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
		Element node = document.createElement("tab");

		return node;
	}


	/**
	 * {@inheritDoc}
	 */
	public List<? extends ITraversableModelElement> getChildren() {
		return Collections.emptyList();
	}
}
