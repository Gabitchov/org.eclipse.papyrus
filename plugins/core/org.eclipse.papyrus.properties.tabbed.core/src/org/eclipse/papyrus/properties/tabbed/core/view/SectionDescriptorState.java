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
package org.eclipse.papyrus.properties.tabbed.core.view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.properties.runtime.state.AbstractState;
import org.eclipse.papyrus.properties.runtime.state.ITraversableModelElement;
import org.eclipse.papyrus.properties.runtime.view.FragmentDescriptor;
import org.eclipse.papyrus.properties.runtime.view.FragmentDescriptorState;
import org.eclipse.papyrus.properties.runtime.view.PropertyViewService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


/**
 * State for section descriptors
 */
public class SectionDescriptorState extends AbstractState {

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

	/** adapter Identifier for the descriptor */
	private String adapterId;

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
		adapterId = sectionDescriptor.getAdapterId();

		List<String> fragmentIds = sectionDescriptor.getFragmentsId();
		for(String id : fragmentIds) {
			/// retrieve the descriptor and creates a state on it
			FragmentDescriptor fragmentDescriptor = PropertyViewService.getInstance().getFragmentDescriptor(id);
			if(fragmentDescriptor != null) {
				getFragmentDescriptorStates().add(fragmentDescriptor.createState());
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
	 * Returns the adapterId for this section descriptor state
	 * 
	 * @return the adapterId for this section descriptor state
	 */
	public String getAdapterId() {
		return adapterId;
	}


	/**
	 * Sets the adapterId for this section descriptor state
	 * 
	 * @param adapterId
	 *        the adapterId to set for this section descriptor state
	 */
	public void setAdapterId(String adapterId) {
		String oldId = this.adapterId;
		this.adapterId = adapterId;

		changeSupport.firePropertyChange("adapterId", oldId, adapterId);
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
	 * Adds a fragment descriptor state and throws an event using the change support
	 * 
	 * @param state
	 *        the state to add
	 */
	public void addFragmentDescriptorState(FragmentDescriptorState state) {
		fragmentDescriptorStates.add(state);

		changeSupport.firePropertyChange(PROPERTY_ADD_CHILD, null, state);
	}

	/**
	 * Adds a fragment descriptor state and throws an event using the change support
	 * 
	 * @param state
	 *        the state to add
	 */
	public void removeFragmentDescriptorState(FragmentDescriptorState state) {
		fragmentDescriptorStates.remove(state);

		changeSupport.firePropertyChange(PROPERTY_REMOVE_CHILD, null, state);
	}

	/**
	 * Serializes this section descriptor state
	 * 
	 * @param document
	 *        document used to create XML nodes
	 * 
	 * @return the node result of the parsing of this state
	 */
	public Node generateNode(Document document) {
		Element node = document.createElement("section");
		node.setAttribute("id", getId());
		node.setAttribute("tabId", getTargetTab());
		node.setAttribute("adapterId", getAdapterId());

		generateFragmentDescriptorStateNodes(node, document);

		return node;
	}

	/**
	 * Generates for children fragment descriptors
	 * 
	 * @param node
	 *        the parent node for generated nodes
	 * @param document
	 *        the document used to create elements
	 */
	protected void generateFragmentDescriptorStateNodes(Element node, Document document) {
		for(FragmentDescriptorState fragmentDescriptorState : getFragmentDescriptorStates()) {
			node.appendChild(fragmentDescriptorState.generateNode(document));
		}
	}

}
