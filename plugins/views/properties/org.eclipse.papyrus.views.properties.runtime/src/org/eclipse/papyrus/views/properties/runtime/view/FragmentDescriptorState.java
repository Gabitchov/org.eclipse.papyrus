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
package org.eclipse.papyrus.views.properties.runtime.view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.state.AbstractState;
import org.eclipse.papyrus.views.properties.runtime.state.IFragmentDescriptorState;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.ConstraintDescriptorState;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.content.ContainerDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.content.ContainerDescriptorState;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


/**
 * state for Fragment descriptor
 */
public class FragmentDescriptorState extends AbstractState implements IFragmentDescriptorState {

	/** descriptor managed by this state */
	private FragmentDescriptor descriptor;

	/** list of container descriptors state children of this state */
	private final List<ContainerDescriptorState> containerDescriptorStates = new ArrayList<ContainerDescriptorState>();

	/** list of constraints descriptors state children of this state */
	private final List<ConstraintDescriptorState> constraintDescriptorStates = new ArrayList<ConstraintDescriptorState>();

	/** selection size state */
	private int selectionSize;

	/** change support for this bean */
	private PropertyChangeSupport changeSupport;

	/** id of the fragment managed by this state */
	private String id;

	/**
	 * Creates a new FragmentDescriptorState.
	 * 
	 * @param descriptor
	 *        the fragment descriptor managed by this state
	 * @param readOnly
	 *        <code>true</code> if the state should not be modifiable
	 */
	public FragmentDescriptorState(FragmentDescriptor descriptor, boolean readOnly) {
		super(readOnly);
		this.descriptor = descriptor;

		id = descriptor.getId();

		// retrieve and build the states for the container children
		List<ContainerDescriptor> containerDescriptors = descriptor.getContainerDescriptors();
		for(ContainerDescriptor containerDescriptor : containerDescriptors) {
			containerDescriptorStates.add(containerDescriptor.createState(readOnly));
		}

		for(IConstraintDescriptor constraintDescriptor : descriptor.getConstraintDescriptors()) {
			getConstraintDescriptorStates().add(constraintDescriptor.createState(readOnly));
		}

		selectionSize = descriptor.getSelectionSize();

		// register change support
		changeSupport = new PropertyChangeSupport(this);
	}

	public FragmentDescriptor getDescriptor() {
		return descriptor;
	}


	/**
	 * Returns the state for the selection size
	 * 
	 * @return the state for the selection size
	 */
	public int getSelectionSize() {
		return selectionSize;
	}

	/**
	 * Sets the state for the selection size
	 * 
	 * @param selectionSize
	 *        the selectionSize to set
	 */
	public void setSelectionSizeState(int selectionSize) {
		int oldSize = this.selectionSize;
		this.selectionSize = selectionSize;

		changeSupport.firePropertyChange("selectionSize", oldSize, this.selectionSize);
	}

	/**
	 * Returns the containerDescriptor States for this fragment
	 * 
	 * @return the containerDescriptor States for this fragment
	 */
	public List<ContainerDescriptorState> getContainerDescriptorStates() {
		return containerDescriptorStates;
	}

	/**
	 * Returns the constraintDescriptor States for this fragment
	 * 
	 * @return the constraintDescriptor States for this fragment
	 */
	public List<ConstraintDescriptorState> getConstraintDescriptorStates() {
		return constraintDescriptorStates;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEditionDialogId() {
		return "FragmentDescriptorStateDialog";
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return "Fragment: " + getId() + " (size: " + getSelectionSize() + ")";
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
	 * Adds the {@link ContainerDescriptorState} to the list of descriptor states belonging to this fragment
	 * 
	 * @param containerDescriptorState
	 *        the state to add
	 */
	public void addContainerDescriptorState(ContainerDescriptorState containerDescriptorState) {
		containerDescriptorStates.add(containerDescriptorState);

		changeSupport.firePropertyChange(PROPERTY_ADD_CHILD, null, containerDescriptorStates);
	}

	/**
	 * Removes the {@link ContainerDescriptorState} from the list of descriptor states belonging to this fragment
	 * 
	 * @param containerDescriptorState
	 *        the state to remove
	 */
	public void removeContainerDescriptorState(ContainerDescriptorState containerDescriptorState) {
		containerDescriptorStates.remove(containerDescriptorState);

		changeSupport.firePropertyChange(PROPERTY_REMOVE_CHILD, null, containerDescriptorStates);
	}

	/**
	 * Adds the {@link ContainerDescriptorState} to the list of descriptor states belonging to this fragment
	 * 
	 * @param constraintDescriptorState
	 *        the state to add
	 */
	public void addConstraintDescriptorState(ConstraintDescriptorState constraintDescriptorState) {
		constraintDescriptorStates.add(constraintDescriptorState);

		changeSupport.firePropertyChange(PROPERTY_ADD_CHILD, null, constraintDescriptorState);
	}

	/**
	 * Removes the {@link ContainerDescriptorState} from the list of descriptor states belonging to this fragment
	 * 
	 * @param constraintDescriptorState
	 *        the state to remove
	 */
	public void removeContainerDescriptorState(ConstraintDescriptorState constraintDescriptorState) {
		constraintDescriptorStates.remove(constraintDescriptorState);

		changeSupport.firePropertyChange(PROPERTY_REMOVE_CHILD, null, constraintDescriptorState);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ContainerDescriptorState> getChildren() {
		return getContainerDescriptorStates();
	}

	/**
	 * {@inheritDoc}
	 */
	public Node generateNode(Document document) {
		Element node = document.createElement("fragment");

		generateAttributes(node, document);

		// generate for children(containers and constraints)
		generateConstraints(node, document);
		generateContainers(node, document);

		return node;
	}

	/**
	 * Generates attributes for this fragment
	 * 
	 * @param node
	 *        the node to complete
	 * @param document
	 *        the document used to create nodes
	 */
	protected void generateAttributes(Element node, Document document) {
		node.setAttribute("id", getId());

	}

	/**
	 * Generates the constraints for the fragment descriptor
	 * 
	 * @param node
	 *        the parent node for generated nodes
	 * @param document
	 *        the document used to create elements
	 */
	protected void generateConstraints(Element node, Document document) {
		Element contentElement = document.createElement("context");
		// add the enables for attribute
		contentElement.setAttribute("enablesFor", "" + getSelectionSize());

		// generate for each constraint
		for(ConstraintDescriptorState state : getConstraintDescriptorStates()) {
			contentElement.appendChild(state.generateNode(document));
		}
		node.appendChild(contentElement);

	}

	/**
	 * Generate the children nodes for all containers
	 * 
	 * @param node
	 *        the parent node for generated nodes
	 * @param document
	 *        the document used to create elements
	 */
	protected void generateContainers(Element node, Document document) {
		Element contentElement = document.createElement("content");
		for(ContainerDescriptorState state : getContainerDescriptorStates()) {
			contentElement.appendChild(state.generateNode(document));
		}
		node.appendChild(contentElement);
	}

	/**
	 * Sets the id
	 * 
	 * @param id
	 *        the id to set
	 */
	public void setId(String id) {
		changeSupport.firePropertyChange("id", this.id, this.id = id);
	}

	/**
	 * Returns the id
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}
}
