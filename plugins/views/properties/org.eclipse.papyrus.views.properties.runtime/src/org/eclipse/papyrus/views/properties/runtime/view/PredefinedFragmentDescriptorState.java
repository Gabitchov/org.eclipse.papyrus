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
import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.state.AbstractState;
import org.eclipse.papyrus.views.properties.runtime.state.IFragmentDescriptorState;
import org.eclipse.papyrus.views.properties.runtime.state.ITraversableModelElement;
import org.eclipse.papyrus.views.properties.runtime.view.content.ContainerDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.content.ContainerDescriptorState;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


/**
 * State for {@link PredefinedFragmentDescriptor}
 */
public class PredefinedFragmentDescriptorState extends AbstractState implements IFragmentDescriptorState {

	/** the descriptor managed by this state */
	private final PredefinedFragmentDescriptor predefinedFragmentDescriptor;

	/** list of container descriptors state children of this state */
	private final List<ContainerDescriptorState> containerDescriptorStates = new ArrayList<ContainerDescriptorState>();

	/**
	 * Creates a new PredefinedFragmentDescriptorState.
	 * 
	 * @param predefinedFragmentDescriptor
	 *        the descriptor managed by this state
	 * @param readOnly
	 */
	public PredefinedFragmentDescriptorState(PredefinedFragmentDescriptor predefinedFragmentDescriptor, boolean readOnly) {
		super(readOnly);
		this.predefinedFragmentDescriptor = predefinedFragmentDescriptor;

		for(ContainerDescriptor containerDescriptor : predefinedFragmentDescriptor.getContainerDescriptors()) {
			getContainerDescriptorStates().add(containerDescriptor.createState(true));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<? extends ITraversableModelElement> getChildren() {
		return getContainerDescriptorStates();
	}

	/**
	 * {@inheritDoc}
	 */
	public PredefinedFragmentDescriptor getDescriptor() {
		return predefinedFragmentDescriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEditionDialogId() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// nothing here, read only
	}

	/**
	 * {@inheritDoc}
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// nothing here, read only
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ContainerDescriptorState> getContainerDescriptorStates() {
		return containerDescriptorStates;
	}

	/**
	 * {@inheritDoc}
	 */
	public Node generateNode(Document document) {
		Element element = document.createElement("fragment");
		element.setAttribute("predefinedId", getDescriptor().getId());
		return element;
	}

}
