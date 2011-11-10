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
package org.eclipse.papyrus.views.properties.runtime.view;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gmf.runtime.common.core.service.IProvider;


/**
 * Interface for Property view providers
 */
public interface IPropertyViewProvider extends IProvider {

	/**
	 * Configures this provider, retrieving the xml file and parsing it.
	 * 
	 * @param element
	 *        the configuration element for this provider
	 */
	public void configure(IConfigurationElement element);

	/**
	 * Returns the fragment descriptor, given its ID
	 * 
	 * @param descriptorID
	 *        the id of the descriptor to retrieve
	 * @return the found fragment descriptor or <code>null</code>
	 */
	public FragmentDescriptor getFragmentDescriptor(String descriptorID);

	/**
	 * returns the full map of fragments descriptors proposed by this provider, key is their identifier
	 * 
	 * @return the full map of fragments descriptors proposed by this provider, key is their identifier
	 */
	public Map<String, FragmentDescriptor> getAllFragmentDescriptors();

	/**
	 * returns <code>true</code> if this provider can handle the fragment descriptor specified by its identifier
	 * 
	 * @param descriptorId
	 *        the id of the descriptor
	 * @return <code>true</code> if the provider can handle this fragment provider
	 */
	public boolean managesFragmentDescriptor(String descriptorId);

	/**
	 * Returns the dialog descriptor, given its ID
	 * 
	 * @param descriptorID
	 *        the id of the descriptor to retrieve
	 * @return the found dialog descriptor or <code>null</code>
	 */
	public DialogDescriptor getDialogDescriptor(String descriptorID);

	/**
	 * Returns the list of dialog descriptors, valid for the list of given objects
	 * 
	 * @param objectsToEdit
	 *        list of objects to edit
	 * @return the found dialog descriptors or <code>null</code>
	 */
	public List<DialogDescriptor> getDialogDescriptor(List<Object> objectsToEdit);

	/**
	 * returns <code>true</code> if this provider can handle the dialog descriptor specified by its identifier
	 * 
	 * @param descriptorId
	 *        the id of the descriptor
	 * @return <code>true</code> if the provider can handle this dialog provider
	 */
	public boolean managesDialogDescriptor(String descriptorId);


}
