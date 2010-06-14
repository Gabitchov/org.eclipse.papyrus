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
package org.eclipse.papyrus.properties.runtime.modelhandler.emf;

import java.beans.PropertyChangeListener;
import java.util.Collections;
import java.util.List;

import org.eclipse.papyrus.properties.runtime.state.AbstractState;
import org.eclipse.papyrus.properties.runtime.state.ITraversableModelElement;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


/**
 * State for model handlers
 */
public class EMFFeatureModelHandlerState extends AbstractState implements IEMFModelHandlerState {

	/** managed model handler */
	private EMFFeatureModelHandler modelHandler;

	/**
	 * Creates a new EMFFeatureModelHandlerState.
	 * 
	 * @param readOnly
	 */
	public EMFFeatureModelHandlerState(IEMFModelHandler modelHandler, boolean readOnly) {
		super(readOnly);
		assert (modelHandler instanceof EMFFeatureModelHandler);
		this.modelHandler = (EMFFeatureModelHandler)modelHandler;
	}

	/**
	 * {@inheritDoc}
	 */
	public EMFFeatureModelHandler getDescriptor() {
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
		//FIXME add change support
	}

	/**
	 * {@inheritDoc}
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		//FIXME remove change support
	}

	/**
	 * {@inheritDoc}
	 */
	public Node generateNode(Document document) {
		//<feature name="ownedAttribute" handlerID="Reference"/>
		Element element = document.createElement("feature");
		element.setAttribute("name", modelHandler.getFeatureName());
		element.setAttribute("handlerID", modelHandler.getId());
		return element;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<? extends ITraversableModelElement> getChildren() {
		return Collections.emptyList();
	}

}
