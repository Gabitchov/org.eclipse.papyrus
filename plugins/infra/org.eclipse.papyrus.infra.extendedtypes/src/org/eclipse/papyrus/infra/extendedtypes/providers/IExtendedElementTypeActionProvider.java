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
package org.eclipse.papyrus.infra.extendedtypes.providers;

import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration;


/**
 * Provider for extended element types action
 */
public interface IExtendedElementTypeActionProvider extends IProvider {

	/**
	 * Returns the command to execute for the given configuration
	 * 
	 * @param elementsToEdit
	 *        list of elements to edit
	 * 
	 * @param configuration
	 *        the configuration for the command
	 * 
	 * @return the command to execute for the given configuration
	 */
	public ICommand getICommand(List<? extends Object> elementsToEdit, ActionConfiguration configuration);

	/**
	 * Returns the command to execute for the given configuration to check if it will be executable
	 * 
	 * @param elementsToEdit
	 *        list of elements to edit
	 * 
	 * @param configuration
	 *        the configuration for the command
	 * 
	 * @return the command to execute for the given configuration. should do nothing on the model (either null or identity command), only return an
	 *         Unexecutable command if creation is not allowed
	 */
	public ICommand getBeforeCreateValidationCommand(List<? extends Object> elementsToEdit, ActionConfiguration configuration);
	
	/**
	 * Sets the configuration for this provider, given the configuration element
	 * 
	 * @param element
	 *        the element that configures this provider
	 */
	public void setConfiguration(IConfigurationElement element);
}
