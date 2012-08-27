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

import org.eclipse.papyrus.views.properties.runtime.state.ITraversableModelElement;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 * State for model handlers
 */
public class EMFStereotypeFeatureModelHandlerState extends EMFFeatureModelHandlerState {

	/** managed model handler */
	private String stereotypeName;

	/** change support */
	private PropertyChangeSupport changeSupport;

	/**
	 * Creates a new EMFFeatureModelHandlerState.
	 * 
	 * @param modelHandler
	 *        the model handler to manage
	 * 
	 * @param readOnly
	 */
	public EMFStereotypeFeatureModelHandlerState(IEMFModelHandler modelHandler, boolean readOnly) {
		super(modelHandler, readOnly);
		stereotypeName = getDescriptor().getStereotypeName();
		changeSupport = new PropertyChangeSupport(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EMFStereotypeFeatureModelHandler getDescriptor() {
		return (EMFStereotypeFeatureModelHandler)super.getDescriptor();
	}

	/**
	 * Sets the stereotypeName
	 * 
	 * @param stereotypeName
	 *        the stereotypeName to set
	 */
	public void setStereotypeName(String stereotypeName) {
		changeSupport.firePropertyChange("stereotypeName", this.stereotypeName, this.stereotypeName = stereotypeName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		super.addPropertyChangeListener(listener);
		changeSupport.addPropertyChangeListener(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		super.removePropertyChangeListener(listener);
		changeSupport.removePropertyChangeListener(listener);
	}


	/**
	 * Returns the stereotypeName
	 * 
	 * @return the stereotypeName
	 */
	public String getStereotypeName() {
		return stereotypeName;
	}

	/**
	 * {@inheritDoc}
	 */
	public Element generateNode(Document document) {
		Element element = super.generateNode(document);
		element.setAttribute("stereotypeName", stereotypeName);
		return element;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<? extends ITraversableModelElement> getChildren() {
		return Collections.emptyList();
	}

}
