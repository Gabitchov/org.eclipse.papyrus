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
package org.eclipse.papyrus.core.extension.commands;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.core.extension.ExtensionException;
import org.eclipse.papyrus.core.extension.NotFoundException;
import org.eclipse.papyrus.core.utils.IDebugChannel;
import org.eclipse.papyrus.core.utils.PapyrusTrace;
import org.eclipse.papyrus.sasheditor.Activator;

/**
 * {@inheritDoc}
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class CreationCommandRegistry implements ICreationCommandRegistry {

	/** ID of the editor extension (schema filename) */
	public static final String EDITOR_EXTENSION_ID = "papyrusDiagram";

	/** Namespace where to look for the extension points. */
	protected String extensionPointNamespace;

	/**
	 * Registered creation command descriptors.
	 */
	private Map<Object, CreationCommandDescriptor> creationCommandDescriptors;

	public CreationCommandRegistry(String extensionPointNamespace) {
		this.extensionPointNamespace = extensionPointNamespace;
		initializeCreationCommandDescriptors();
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<CreationCommandDescriptor> getCommandDescriptors() {
		return creationCommandDescriptors.values();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws NotFoundException
	 */
	public ICreationCommand getCommand(String commandId) throws NotFoundException {
		try {
			CreationCommandDescriptor desc = creationCommandDescriptors.get(commandId);
			return desc.getCommand();
		} catch (Exception e) {
			throw new NotFoundException("No creation command registered under id '" + commandId + "'.");
		}
	}

	/**
	 * Read command descriptors from extension points.
	 */
	private void initializeCreationCommandDescriptors() {

		creationCommandDescriptors = new HashMap<Object, CreationCommandDescriptor>();
		// Reading data from plugins
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(extensionPointNamespace, EDITOR_EXTENSION_ID);

		CreationCommandExtensionFactory extensionReader = new CreationCommandExtensionFactory();

		for (IConfigurationElement ele : configElements) {
			CreationCommandDescriptor desc;
			try {
				if (CreationCommandExtensionFactory.CREATION_COMMAND_EXTENSIONPOINT.equals(ele.getName())) {
					desc = extensionReader.createCreationCommand(ele);
					creationCommandDescriptors.put(desc.commandId, desc);
				}
			} catch (ExtensionException e) {
				Activator.getDefault().getLog().log(new Status(IStatus.WARNING, Activator.PLUGIN_ID, e.getMessage(), e));
				PapyrusTrace.error(IDebugChannel.PAPYRUS_EXTENSIONPOINT_LOADING, this, "Initialization creation command problem " + e);
			}
		}
		PapyrusTrace.trace(IDebugChannel.PAPYRUS_EXTENSIONPOINT_LOADING, this, "" + creationCommandDescriptors.size() + " creationCommands loaded");

	}

}
