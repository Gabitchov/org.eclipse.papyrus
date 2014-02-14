/*******************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Nicolas Guyomar (Mia-Software) - Bug 339554 - org.eclipse.emf.facet.widgets.celleditors API cleaning
 *    Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *******************************************************************************/
package org.eclipse.emf.facet.widgets.celleditors.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.util.core.Logger;
import org.eclipse.emf.facet.util.core.internal.exported.AbstractRegistry;
import org.eclipse.emf.facet.widgets.celleditors.ICommandFactoriesRegistry;
import org.eclipse.emf.facet.widgets.celleditors.ICommandFactory;

/** Registry for the "loadingDepth" extension point */
public class CommandFactoriesRegistry extends AbstractRegistry implements ICommandFactoriesRegistry {

	private static final String EXTENSION_POINT_NAMESPACE = "org.eclipse.emf.facet.widgets.celleditors"; //$NON-NLS-1$
	private static final String EXTENSION_POINT_NAME = "commandFactories"; //$NON-NLS-1$

	private static final String COMMAND_FACTORY_ELEMENT = "commandFactory"; //$NON-NLS-1$
	private static final String CLASS_ATTRIBUTE = "class"; //$NON-NLS-1$


	private final List<ICommandFactory> commandFactories = new ArrayList<ICommandFactory>();
	private final ICommandFactory defaultCommandFactory = new DefaultCommandFactory();

	public CommandFactoriesRegistry() {
		initialize();
	}

	public List<ICommandFactory> getCommandFactories() {
		return this.commandFactories;
	}

	public ICommandFactory getCommandFactoryFor(final EditingDomain editingDomain) {
		for (ICommandFactory commandFactory : this.commandFactories) {
			if (commandFactory.handles(editingDomain)) {
				return commandFactory;
			}
		}
		return this.defaultCommandFactory;
	}

	@Override
	protected String getExtensionPointName() {
		return CommandFactoriesRegistry.EXTENSION_POINT_NAME;
	}

	@Override
	protected String getExtensionPointNamespace() {
		return CommandFactoriesRegistry.EXTENSION_POINT_NAMESPACE;
	}

	@Override
	protected void handleRootElement(final IConfigurationElement configurationElement) {
		final String name = configurationElement.getName();
		if (name.equalsIgnoreCase(CommandFactoriesRegistry.COMMAND_FACTORY_ELEMENT)) {
			readModelElement(configurationElement);
		} else {
			logUnknownElement(configurationElement);
		}
	}

	/** Read a 'cellEditorsModel' element */
	private void readModelElement(final IConfigurationElement configurationElement) {
		Object object;
		try {
			object = configurationElement
					.createExecutableExtension(CommandFactoriesRegistry.CLASS_ATTRIBUTE);
		} catch (CoreException e) {
			Logger.logError(e, Activator.getDefault());
			return;
		}
		if (object == null) {
			logMissingAttribute(configurationElement, CommandFactoriesRegistry.CLASS_ATTRIBUTE);
			return;
		}

		if (object instanceof ICommandFactory) {
			ICommandFactory commandFactory = (ICommandFactory) object;
			this.commandFactories.add(commandFactory);
		} else {
			logError(configurationElement,
					"class must implement " + ICommandFactory.class.getSimpleName()); //$NON-NLS-1$
		}
	}
}