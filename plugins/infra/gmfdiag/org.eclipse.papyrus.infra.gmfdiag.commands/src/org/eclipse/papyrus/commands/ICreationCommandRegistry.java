/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Jerome Benois (Obeo) jerome.benois@obeo.fr - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.commands;

import java.util.Collection;

import org.eclipse.papyrus.infra.core.extension.NotFoundException;

/**
 * Registry containing CreationCommand registered by Eclipse extension.
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public interface ICreationCommandRegistry {

	/**
	 * Get all registered creation command descriptors
	 * 
	 * @return collection of command descriptors
	 */
	public Collection<CreationCommandDescriptor> getCommandDescriptors();

	/**
	 * Get registered creation with given identifier
	 * 
	 * @param commandId
	 *        the command id
	 * @return the registered command
	 * @throws NotFoundException
	 *         if command not registered
	 */
	ICreationCommand getCommand(String commandId) throws NotFoundException;
}
