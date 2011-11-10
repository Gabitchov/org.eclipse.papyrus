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
package org.eclipse.papyrus.views.properties.runtime.controller.descriptor;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collections;
import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.state.AbstractState;
import org.eclipse.papyrus.views.properties.runtime.state.ITraversableModelElement;
import org.eclipse.swt.widgets.Composite;
import org.w3c.dom.Document;
import org.w3c.dom.Node;


/**
 * State for controller descriptors
 */
public class ControllerDescriptorState extends AbstractState {

	/** identifier for the controller descriptor editor dialog */
	private static final String CONTROLLER_DESCRIPTOR_EDITOR_DLG = "ControllerDescriptorEditorDialog";

	/** descriptor managed by this state */
	protected IPropertyEditorControllerDescriptor descriptor;

	/** id of the controller managed by this state */
	protected String id;

	/** change support for this bean */
	private PropertyChangeSupport changeSupport;

	/**
	 * Creates a new ControllerDescriptorState.
	 * 
	 * @param descriptor
	 *        descriptor to manage
	 * @param readOnly
	 *        the read only mode of this state
	 */
	public ControllerDescriptorState(IPropertyEditorControllerDescriptor descriptor, boolean readOnly) {
		super(readOnly);
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
	public List<? extends ITraversableModelElement> getChildren() {
		return Collections.emptyList();
	}

	/**
	 * {@inheritDoc}
	 */
	public Node generateNode(Document document) {
		// should be subclassed...
		Activator.log.error("not implemented", null);
		return null;
	}

	/**
	 * Generates the preview for this controller
	 * 
	 * @param composite
	 *        the parent composite where to create the view for this controller
	 */
	public void createPreview(Composite composite) {
		Activator.log.error("not implements...", null);
	}
}
