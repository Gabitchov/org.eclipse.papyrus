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
package org.eclipse.papyrus.views.properties.runtime.controller.predefined;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collections;

import org.eclipse.papyrus.views.properties.runtime.controller.PropertyEditorController;
import org.eclipse.papyrus.views.properties.runtime.controller.PropertyEditorControllerService;
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.ControllerDescriptorState;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * State for predefined controllers
 */
public class PredefinedControllerState extends ControllerDescriptorState {

	/** change support for this bean */
	private PropertyChangeSupport changeSupport;

	/** id of the controller managed by this state */
	private String predefinedIdState;

	/**
	 * Creates a new PredefinedControllerState.
	 * 
	 * @param propertyEditorControllerDescriptor
	 *        descriptor managed by this state
	 * @param readOnly
	 *        the read only mode of this state
	 */
	public PredefinedControllerState(PredefinedControllerDescriptor propertyEditorControllerDescriptor, boolean readOnly) {
		super(propertyEditorControllerDescriptor, readOnly);

		predefinedIdState = propertyEditorControllerDescriptor.getPredefinedId();

		// register change support
		changeSupport = new PropertyChangeSupport(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PredefinedControllerDescriptor getDescriptor() {
		return (PredefinedControllerDescriptor)super.getDescriptor();
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
	public Node generateNode(Document document) {
		Element node = document.createElement("controller");
		node.setAttribute("predefinedId", getPredefinedIdState());
		return node;
	}

	/**
	 * Sets the predefinedIdState
	 * 
	 * @param predefinedIdState
	 *        the predefinedIdState to set
	 */
	public void setPredefinedIdState(String predefinedIdState) {
		String oldPredefinedIdState = this.predefinedIdState;
		this.predefinedIdState = predefinedIdState;

		// change also the controller descriptor as a consequence
		this.descriptor = PropertyEditorControllerService.getInstance().createPredefinedControllerDescriptor(predefinedIdState);

		changeSupport.firePropertyChange("predefinedId", oldPredefinedIdState, this.predefinedIdState);
		changeSupport.firePropertyChange("descriptor", null, descriptor);
	}

	/**
	 * Returns the predefinedIdState
	 * 
	 * @return the predefinedIdState
	 */
	public String getPredefinedIdState() {
		return predefinedIdState;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createPreview(Composite composite) {
		PropertyEditorController controller = PropertyEditorControllerService.getInstance().createPropertyEditorController(Collections.emptyList(), composite, descriptor);

		if(controller != null) {
			// use the state to create this
			controller.createPropertyEditor(this.getDescriptor().getEditorDescriptor(), new TabbedPropertySheetWidgetFactory());
		}
	}

}
