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
package org.eclipse.papyrus.views.properties.runtime.controller.descriptor;

import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * Descriptor for controller based on java.beans properties
 */
public class BeanPropertyEditorControllerDescriptor implements IPropertyEditorControllerDescriptor {

	/** id of the controller described by this descriptor */
	private final String controllerID;

	/** indicates if the controller can handle several objects to edit */
	private final boolean multiSelection;

	/** name of the property to edit */
	private final String propertyName;

	/** descriptor of the editor managed by the controller */
	private final IPropertyEditorDescriptor editorDescriptor;

	/** list of constraints applied to this descriptor */
	private final List<IConstraintDescriptor> constraints;

	/**
	 * Creates a new BeanPropertyEditorControllerDescriptor.
	 * 
	 * @param controllerID
	 *        id of the controller described by this descriptor
	 * @param multiSelection
	 *        <code>true</code> when the controller can handle several objects to edit
	 * @param propertyName
	 *        the name of the property to edit
	 * @param editorDescriptor
	 *        the descriptor of the editor managed by this controller
	 * @param constraints
	 *        list of constraints that should be verified for this descriptor
	 */
	public BeanPropertyEditorControllerDescriptor(String controllerID, boolean multiSelection, String propertyName, IPropertyEditorDescriptor editorDescriptor, List<IConstraintDescriptor> constraints) {
		this.controllerID = controllerID;
		this.multiSelection = multiSelection;
		this.propertyName = propertyName;
		this.editorDescriptor = editorDescriptor;
		this.constraints = constraints;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return "Bean controller: " + getControllerID();
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return Activator.getImage("/icons/BeanController.gif");
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean acceptMultiSelection() {
		return multiSelection;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getControllerID() {
		return controllerID;
	}

	/**
	 * {@inheritDoc}
	 */
	public IPropertyEditorDescriptor getEditorDescriptor() {
		return editorDescriptor;
	}

	/**
	 * Returns the name of the property to edit
	 * 
	 * @return the name of the property to edit
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<IConstraintDescriptor> getConstraintDescriptors() {
		return constraints;
	}

	/**
	 * {@inheritDoc}
	 */
	public ControllerDescriptorState createState(boolean readOnly) {
		return new ControllerDescriptorState(this, readOnly);
	}

}
