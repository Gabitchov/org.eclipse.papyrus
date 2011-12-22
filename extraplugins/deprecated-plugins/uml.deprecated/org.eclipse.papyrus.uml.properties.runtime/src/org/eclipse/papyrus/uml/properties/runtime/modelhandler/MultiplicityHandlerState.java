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
package org.eclipse.papyrus.uml.properties.runtime.modelhandler;

import java.beans.PropertyChangeListener;
import java.util.Collections;
import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.modelhandler.emf.IEMFModelHandlerState;
import org.eclipse.papyrus.views.properties.runtime.state.AbstractState;
import org.eclipse.papyrus.views.properties.runtime.state.ITraversableModelElement;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


/**
 * state for {@link MultiplicityModelHandler}
 */
public class MultiplicityHandlerState extends AbstractState implements IEMFModelHandlerState {

	/** model handler managed by this state */
	private final MultiplicityModelHandler modelHandler;

	/**
	 * Creates a new MultiplicityHandlerState.
	 * 
	 * @param modelHandler
	 *        model handler managed by this state
	 * @param readOnly
	 *        read only mode of the state
	 */
	public MultiplicityHandlerState(MultiplicityModelHandler modelHandler, boolean readOnly) {
		super(readOnly);
		this.modelHandler = modelHandler;
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
	public MultiplicityModelHandler getDescriptor() {
		return modelHandler;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEditionDialogId() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// nothing here
	}

	/**
	 * {@inheritDoc}
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// nothing here
	}

	/**
	 * {@inheritDoc}
	 */
	public Node generateNode(Document document) {
		/*
		 * <feature handlerID="Multiplicity">
		 * <availableValue value="0..1"/>
		 * <availableValue value="1..1"/>
		 * <availableValue value="0..*"/>
		 * <availableValue value="1..*"/>
		 * </feature>
		 */
		Element node = document.createElement("feature");
		node.setAttribute("handlerID", getDescriptor().getId());

		for(String availableValue : getDescriptor().getAvailableValues(null)) { // no problem with null, as the method returns a constant value
			node.appendChild(generateAvailableValue(availableValue, document));
		}
		return node;
	}

	/**
	 * Generates the available value node for the given value
	 * 
	 * @param availableValue
	 *        the available value to generate
	 * @param document
	 *        the document used to create XML nodes
	 * @return the available value node for the given value
	 */
	protected Node generateAvailableValue(String availableValue, Document document) {
		Element node = document.createElement("availableValue");
		node.setAttribute("value", availableValue);
		return node;
	}

}
