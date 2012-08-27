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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.controller.NullPropertyEditorController;
import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.swt.graphics.Image;


/**
 * Descriptor for {@link NullPropertyEditorController}
 */
public class NullPropertyEditorControllerDescriptor implements IPropertyEditorControllerDescriptor {

	/** editor descriptor */
	protected final IPropertyEditorDescriptor editorDescriptor;


	/**
	 * Creates a new NullPropertyEditorControllerDescriptor.
	 * 
	 * @param editorDescriptor
	 *        the descriptor of the editor controller
	 */
	public NullPropertyEditorControllerDescriptor(IPropertyEditorDescriptor editorDescriptor) {
		this.editorDescriptor = editorDescriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return "NullController";
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean acceptMultiSelection() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getControllerID() {
		return NullPropertyEditorController.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	public IPropertyEditorDescriptor getEditorDescriptor() {
		return editorDescriptor;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<IConstraintDescriptor> getConstraintDescriptors() {
		return new ArrayList<IConstraintDescriptor>();
	}

	/**
	 * {@inheritDoc}
	 */
	public ControllerDescriptorState createState(boolean readOnly) {
		return new ControllerDescriptorState(this, readOnly);
	}

}
