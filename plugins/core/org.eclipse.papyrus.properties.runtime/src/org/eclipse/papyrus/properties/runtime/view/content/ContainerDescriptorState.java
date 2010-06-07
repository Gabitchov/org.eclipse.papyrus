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
package org.eclipse.papyrus.properties.runtime.view.content;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.properties.runtime.controller.descriptor.ControllerDescriptorState;
import org.eclipse.papyrus.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.eclipse.papyrus.properties.runtime.state.AbstractState;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


/**
 * State for the container descriptors. this is used to do some customization on elements
 */
public class ContainerDescriptorState extends AbstractState {

	/** descriptor managed by this state */
	protected AbstractContainerDescriptor descriptor;

	/** list of controllers managed by this state */
	protected final List<ControllerDescriptorState> controllerDescriptorStates = new ArrayList<ControllerDescriptorState>();

	/** change support for this bean */
	private PropertyChangeSupport changeSupport;

	/** Layout descriptor state */
	private final LayoutDescriptorState layoutDescriptorState;

	/**
	 * Creates a new ContainerDescriptorState.
	 * 
	 * @param descriptor
	 *        the descriptor managed by this state
	 */
	public ContainerDescriptorState(ContainerDescriptor descriptor) {
		this.descriptor = descriptor;

		layoutDescriptorState = descriptor.getLayoutDescriptor().createState();

		// read the current list of controller descriptor managed by this state
		List<IPropertyEditorControllerDescriptor> controllerDescriptors = descriptor.getUnparsedControllerDescriptors();
		for(IPropertyEditorControllerDescriptor controllerDescriptor : controllerDescriptors) {
			controllerDescriptorStates.add(controllerDescriptor.createState());
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
	 * Returns the layoutDescriptor state for this element
	 * 
	 * @return the layoutDescriptor state for this element
	 */
	public LayoutDescriptorState getLayoutDescriptorState() {
		return layoutDescriptorState;
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
	public List<AbstractState> getChildren() {
		ArrayList<AbstractState> states = new ArrayList<AbstractState>();
		states.add(layoutDescriptorState);
		states.addAll(getControllerDescriptorStates());
		return states;
	}

	/**
	 * {@inheritDoc}
	 */
	public Node generateNode(Document document) {
		Element node = document.createElement("container");
		// attributes of the node: example: layout="Grid" columns="2" sameSize="false"
		generateContainerAttributes(node, document);

		// generate for owned controllers
		generateControllers(node, document);

		return node;
	}

	/**
	 * Generates the attributes for the given node
	 * 
	 * @param node
	 *        the node to complete
	 * @param document
	 *        the document used to create elements
	 */
	protected void generateContainerAttributes(Element node, Document document) {
		node.setAttribute("layout", "Grid");
		node.setAttribute("columns", "2");
		node.setAttribute("sameSize", "false");
	}

	/**
	 * Generate the controllers node
	 * 
	 * @param node
	 *        the node owner of the generated nodes
	 * @param document
	 *        the document used to create elements
	 */
	protected void generateControllers(Element node, Document document) {
		for(ControllerDescriptorState state : getControllerDescriptorStates()) {
			node.appendChild(state.generateNode(document));
		}
	}

}
