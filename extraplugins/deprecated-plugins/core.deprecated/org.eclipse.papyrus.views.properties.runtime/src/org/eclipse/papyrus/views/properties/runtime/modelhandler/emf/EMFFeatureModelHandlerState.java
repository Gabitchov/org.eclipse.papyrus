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
package org.eclipse.papyrus.views.properties.runtime.modelhandler.emf;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collections;
import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.state.AbstractState;
import org.eclipse.papyrus.views.properties.runtime.state.ITraversableModelElement;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 * State for model handlers
 */
public class EMFFeatureModelHandlerState extends AbstractState implements IEMFModelHandlerState {

	/** managed model handler */
	private EMFFeatureModelHandler modelHandler;

	/** change support */
	private PropertyChangeSupport changeSupport;

	/** name of the feature to edit */
	private String name;

	/** id of the model handler */
	private String id;

	/**
	 * Creates a new EMFFeatureModelHandlerState.
	 * 
	 * @param modelHandler
	 *        managed model handler
	 * 
	 * @param readOnly
	 */
	public EMFFeatureModelHandlerState(IEMFModelHandler modelHandler, boolean readOnly) {
		super(readOnly);
		assert (modelHandler instanceof EMFFeatureModelHandler);
		this.modelHandler = (EMFFeatureModelHandler)modelHandler;
		this.name = ((EMFFeatureModelHandler)modelHandler).getFeatureName();
		this.id = ((EMFFeatureModelHandler)modelHandler).getId();
		changeSupport = new PropertyChangeSupport(this);
	}

	/**
	 * {@inheritDoc}
	 */
	public EMFFeatureModelHandler getDescriptor() {
		return modelHandler;
	}

	/**
	 * Sets the name
	 * 
	 * @param name
	 *        the name to set
	 */
	public void setName(String name) {
		changeSupport.firePropertyChange("name", this.name, this.name = name);
	}

	/**
	 * Returns the name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
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
	public Element generateNode(Document document) {
		//<feature name="ownedAttribute" handlerID="Reference"/>
		Element element = document.createElement("feature");
		element.setAttribute("name", name);
		element.setAttribute("handlerID", id);
		return element;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<? extends ITraversableModelElement> getChildren() {
		return Collections.emptyList();
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
