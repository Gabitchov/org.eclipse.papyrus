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
public class AssociationEndOwnerHandlerState extends AbstractState implements IEMFModelHandlerState {

	/** model handler managed by this state */
	private final AssociationEndOwnerModelHandler modelHandler;

	/**
	 * Creates a new MultiplicityHandlerState.
	 * 
	 * @param modelHandler
	 *        the model handler managed by this state
	 * @param readOnly
	 *        the read only mode for this state
	 */
	public AssociationEndOwnerHandlerState(AssociationEndOwnerModelHandler modelHandler, boolean readOnly) {
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
	public AssociationEndOwnerModelHandler getDescriptor() {
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
		Element node = document.createElement("feature");
		node.setAttribute("handlerID", getDescriptor().getId());
		return node;
	}
}
