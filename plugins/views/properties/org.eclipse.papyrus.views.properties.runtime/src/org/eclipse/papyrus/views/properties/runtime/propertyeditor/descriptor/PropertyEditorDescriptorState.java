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
package org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collections;
import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.state.AbstractState;
import org.eclipse.papyrus.views.properties.runtime.state.ITraversableModelElement;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;



/**
 * State for {@link PropertyEditorDescriptor}
 */
public class PropertyEditorDescriptorState extends AbstractState {

	/** descriptor managed by this state */
	private PropertyEditorDescriptor descriptor;

	/** change support listener for this state */
	private PropertyChangeSupport changeSupport;

	/** id of the editor */
	private String id;

	/** label of the editor */
	private String label;

	/** label position of the editor */
	private int labelPosition;

	/**
	 * Creates a new PropertyEditorDescriptorState.
	 * 
	 * @param descriptor
	 *        the descriptor managed by this state
	 * 
	 * @param readOnly
	 *        the read only mode for this state
	 */
	public PropertyEditorDescriptorState(PropertyEditorDescriptor descriptor, boolean readOnly) {
		super(readOnly);
		this.descriptor = descriptor;

		// inits the fields
		id = descriptor.getEditorId();
		label = descriptor.getLabel();
		labelPosition = descriptor.getLabelPosition();

		changeSupport = new PropertyChangeSupport(this);
	}

	/**
	 * Returns the id of the descriptor
	 * 
	 * @return the id of the descriptor
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id of the descriptor
	 * 
	 * @param id
	 *        the id to set
	 */
	public void setId(String id) {
		changeSupport.firePropertyChange("id", this.id, this.id = id);
	}

	/**
	 * Returns the label of the descriptor
	 * 
	 * @return the label of the descriptor
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Sets the label of the descriptor
	 * 
	 * @param label
	 *        the label to set
	 */
	public void setLabel(String label) {
		changeSupport.firePropertyChange("label", this.label, this.label = label);
	}

	/**
	 * Returns the labelPosition of the descriptor
	 * 
	 * @return the labelPosition of the descriptor
	 */
	public int getLabelPosition() {
		return labelPosition;
	}

	/**
	 * Sets the labelPosition of the descriptor
	 * 
	 * @param labelPosition
	 *        the labelPosition to set
	 */
	public void setLabelPosition(int labelPosition) {
		changeSupport.firePropertyChange("labelPosition", this.labelPosition, this.labelPosition = labelPosition);
	}

	/**
	 * {@inheritDoc}
	 */
	public PropertyEditorDescriptor getDescriptor() {
		return descriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEditionDialogId() {
		return "";
	}

	/**
	 * {@inheritDoc}
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	public Node generateNode(Document document) {
		Element node = document.createElement("editor");
		// <editor id="org.eclipse.papyrus.views.properties.runtime.textPropertyEditor" label="Body:" labelPosition="16384"/>
		node.setAttribute("id", id);
		node.setAttribute("label", label);
		node.setAttribute("labelPosition", "" + labelPosition);
		return node;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<? extends ITraversableModelElement> getChildren() {
		return Collections.emptyList();
	}

}
