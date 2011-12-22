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

import org.eclipse.papyrus.views.properties.runtime.propertyeditor.descriptor.IPropertyEditorDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.IConfigurableDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.IConstraintDescriptor;


/**
 * interface for all property editor controllers
 */
public interface IPropertyEditorControllerDescriptor extends IConfigurableDescriptor {

	/**
	 * Indicates if the controller accepts multi selection
	 * 
	 * @return <code>true</code> if the controller accepts multi-selection
	 */
	public boolean acceptMultiSelection();

	/**
	 * Returns the unique identifier of the controller described by this element
	 * 
	 * @return the unique identifier of the controller described by this element
	 */
	public String getControllerID();

	/**
	 * Returns the editor descriptor for this controller
	 * 
	 * @return the editor descriptor for this controller
	 */
	public IPropertyEditorDescriptor getEditorDescriptor();

	/**
	 * Returns the list of constraints for this descriptor
	 * 
	 * @return the list of constraints for this descriptor
	 */
	public List<IConstraintDescriptor> getConstraintDescriptors();

	/**
	 * {@inheritDoc}
	 */
	public ControllerDescriptorState createState(boolean readOnly);

	//	/**
	//	 * Returns the predefined id of the described controller
	//	 * 
	//	 * @return the predefined id of the described controller
	//	 */
	//	public String getPredefinedId();
}
