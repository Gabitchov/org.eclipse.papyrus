/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.emf.facet.efacet.sdk.ui.internal.query;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.Activator;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.IQueryDialogFactoryStrategy;
import org.eclipse.emf.facet.util.core.Logger;
import org.eclipse.osgi.util.NLS;

/**
 * Implementation of the {@link IQueryWidgetCompositeFactoryFactory}.
 */
public class QueryWidgetCompositeFactoryImpl implements
		IQueryWidgetCompositeFactoryFactory {

	private static final String EXTENSION_POINT = "org.eclipse.emf.facet.efacet.sdk.ui.queryFactoryDialogRegistration"; //$NON-NLS-1$
	private static final String DIALOG_FACTORY = "dialogFactory"; //$NON-NLS-1$
	private static final String MANAGED_TYPE_NAME = "managedQueryTypeName"; //$NON-NLS-1$

	private Map<String, IQueryDialogFactoryStrategy> extensions;

	public IQueryDialogFactoryStrategy getQueryDialogFactoryStrategy(
			final String managedTypeName) {
		// Lazy Loading, we only create the necessary instance.
		for (final IConfigurationElement element : Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						QueryWidgetCompositeFactoryImpl.EXTENSION_POINT)) {
			final String elementName = element
					.getAttribute(QueryWidgetCompositeFactoryImpl.MANAGED_TYPE_NAME);
			if (elementName.equals(managedTypeName)) {
				try {
					final Object object = element
							.createExecutableExtension(QueryWidgetCompositeFactoryImpl.DIALOG_FACTORY);
					if (object instanceof IQueryDialogFactoryStrategy) {
						final IQueryDialogFactoryStrategy strategy = (IQueryDialogFactoryStrategy) object;
						this.extensions.put(elementName, strategy);
					} else {
						final String errorMsg = NLS
								.bind("The attribut {0} must contains a class implementing {1}", //$NON-NLS-1$
										QueryWidgetCompositeFactoryImpl.DIALOG_FACTORY,
										IQueryDialogFactoryStrategy.class
												.getName());
						Logger.logError(errorMsg, Activator.getDefault());
					}
				} catch (final InvalidRegistryObjectException e) {
					Logger.logError(e, Activator.getDefault());
				} catch (final CoreException e) {
					Logger.logError(e, Activator.getDefault());
				}
			}
		}
		return this.extensions.get(managedTypeName);
	}

	public List<String> getRegisteredQueryWidgetsComposite() {
		if (this.extensions == null) {
			this.extensions = new HashMap<String, IQueryDialogFactoryStrategy>();

			for (final IConfigurationElement element : Platform
					.getExtensionRegistry().getConfigurationElementsFor(
							QueryWidgetCompositeFactoryImpl.EXTENSION_POINT)) {
				this.extensions
						.put(element
								.getAttribute(QueryWidgetCompositeFactoryImpl.MANAGED_TYPE_NAME),
								null);
			}
		}

		return new LinkedList<String>(this.extensions.keySet());
	}

}
