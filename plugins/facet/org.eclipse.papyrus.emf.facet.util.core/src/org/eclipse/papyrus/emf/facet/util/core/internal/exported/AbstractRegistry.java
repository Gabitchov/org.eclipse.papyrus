/*******************************************************************************
 * Copyright (c) 2009 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *    Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *******************************************************************************/

package org.eclipse.emf.facet.util.core.internal.exported;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.facet.util.core.Logger;
import org.eclipse.emf.facet.util.core.internal.Activator;
import org.eclipse.emf.facet.util.core.internal.Messages;
import org.eclipse.osgi.util.NLS;

/**
 * Provides common functionality for extension registries. Call
 * {@link #initialize()} in a sub-class to read the extension points. Implement
 * {@link #handleRootElement(IConfigurationElement)} to read the root
 * configuration elements of each extension.
 * @since 0.2
 */
public abstract class AbstractRegistry {
// copy of org.eclipse.emf.facet.infra.common.core.internal.extensions.AbstractRegistry
	/**
	 * Initialize the registry by reading the extension point to discover
	 * extensions. This method calls
	 * {@link #handleRootElement(IConfigurationElement)} on each root
	 * configuration element.
	 */
	protected void initialize() {
		final IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		final IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(
				getExtensionPointNamespace(), getExtensionPointName());

		if (extensionPoint == null) {
			Logger.logError("Extension point not found:" + getExtensionPointNamespace() //$NON-NLS-1$
					+ "." + getExtensionPointName(), Activator.getDefault()); //$NON-NLS-1$
			return;
		}

		final IExtension[] extensions = extensionPoint.getExtensions();
		for (final IExtension extension : extensions) {
			final IConfigurationElement[] configurationElements = extension
					.getConfigurationElements();
			for (final IConfigurationElement configurationElement : configurationElements) {
				try {
					handleRootElement(configurationElement);
				} catch (Exception e) {
					final String errogMsg = NLS
							.bind("An exception occurred while loading registry of the extension point {0}. The problem occurred with the an extension contributed by the plug-in {1}", //$NON-NLS-1$
									getExtensionPointNamespace() + '.'
											+ getExtensionPointName(),
									extension.getContributor().getName());
					Logger.logError(e, errogMsg, Activator.getDefault());
				}
			}
		}
	}

	protected abstract String getExtensionPointNamespace();

	protected abstract String getExtensionPointName();

	/** Called for each root {@link IConfigurationElement} in the extension */
	protected abstract void handleRootElement(IConfigurationElement configurationElement);

	/**
	 * Logs the error in the log using the provided text and the information in
	 * the configuration element.
	 */
	protected static void logError(final IConfigurationElement element, final String text) {
		final IExtension extension = element.getDeclaringExtension();
		final StringBuffer buf = new StringBuffer();
		buf.append(NLS.bind(Messages.AbstractRegistry_pluginExtension, extension
				.getNamespaceIdentifier(), extension.getExtensionPointUniqueIdentifier()));
		// look for an ID if available - this should help debugging
		final String id = element.getAttribute("id"); //$NON-NLS-1$
		if (id != null) {
			buf.append(Messages.AbstractRegistry_id);
			buf.append(id);
		}
		buf.append(Messages.AbstractRegistry_colon + text);
		Logger.logError(buf.toString(), Activator.getDefault());
	}

	/**
	 * Logs a very common registry error when a required attribute is missing.
	 */
	protected static void logMissingAttribute(final IConfigurationElement element,
			final String attributeName) {
		logError(element, NLS.bind(Messages.AbstractRegistry_requiredAttributeNotDefined,
				attributeName));
	}

	/**
	 * Logs a registry error when the configuration element is unknown.
	 */
	protected static void logUnknownElement(final IConfigurationElement element) {
		logError(element, Messages.AbstractRegistry_unknownExtensionTag + element.getName());
	}
}
