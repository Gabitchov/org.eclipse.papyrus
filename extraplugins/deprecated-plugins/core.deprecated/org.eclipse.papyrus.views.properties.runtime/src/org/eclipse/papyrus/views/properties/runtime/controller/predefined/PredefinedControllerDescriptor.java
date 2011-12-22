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

import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.ControllerDescriptorState;
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.IPropertyEditorControllerDescriptor;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.swt.graphics.Image;


/**
 * Descriptor for predefined controllers
 */
public class PredefinedControllerDescriptor implements IPropertyEditorControllerDescriptor {

	/** real descriptor */
	private final IPropertyEditorControllerDescriptor descriptor;

	/**
	 * Returns the predefined descriptor
	 * 
	 * @return the predefined descriptor
	 */
	public IPropertyEditorControllerDescriptor getDescriptor() {
		return descriptor;
	}

	/** predefined id of the controller */
	private final String predefinedId;

	/**
	 * Creates a new PredefinedControllerDescriptor.
	 * 
	 * @param predefinedId
	 *        the id of the predefined descriptor
	 * 
	 * @param descriptor
	 *        the predefined descriptor
	 */
	public PredefinedControllerDescriptor(String predefinedId, IPropertyEditorControllerDescriptor descriptor) {
		this.predefinedId = predefinedId;
		this.descriptor = descriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return descriptor.getText();
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return descriptor.getImage();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean acceptMultiSelection() {
		return descriptor.acceptMultiSelection();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getControllerID() {
		return descriptor.getControllerID();
	}

	/**
	 * {@inheritDoc}
	 */
	public IPropertyEditorDescriptor getEditorDescriptor() {
		return descriptor.getEditorDescriptor();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<IConstraintDescriptor> getConstraintDescriptors() {
		return descriptor.getConstraintDescriptors();
	}

	/**
	 * {@inheritDoc}
	 */
	public ControllerDescriptorState createState(boolean readOnly) {
		return new PredefinedControllerState(this, readOnly);
	}

	/**
	 * Returns the predefinedId of the controller
	 * 
	 * @return the predefinedId of the controller
	 */
	public String getPredefinedId() {
		return predefinedId;
	}

}
