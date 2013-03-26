/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.storage;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.papyrus.views.properties.contexts.Context;

/**
 * This is the ContextStorageRegistry type. Enjoy.
 */
public class ContextStorageRegistry {

	private static final String EXT_POINT = "contextStorage"; //$NON-NLS-1$

	private final List<IContextStorageProvider> providers = new java.util.ArrayList<IContextStorageProvider>();

	private final ResourceSet resourceSet;

	public ContextStorageRegistry(ResourceSet resourceSet) {
		super();

		this.resourceSet = resourceSet;

		new MyRegistryReader().readRegistry();
	}

	public List<IContextStorageProvider> getStorageProviders() {
		return Collections.unmodifiableList(providers);
	}

	public IContextStorageProvider getStorageProvider(Context context) {
		IContextStorageProvider result = IContextStorageProvider.NULL;

		for(IContextStorageProvider next : providers) {
			if(next.providesFor(context)) {
				result = next;
				break;
			}
		}

		return result;
	}

	//
	// Nested types
	//

	private class MyRegistryReader extends RegistryReader {

		private static final String A_CLASS = "class"; //$NON-NLS-1$

		private static final String E_PROVIDER = "provider"; //$NON-NLS-1$

		MyRegistryReader() {
			super(Platform.getExtensionRegistry(), Activator.PLUGIN_ID, EXT_POINT);
		}

		@Override
		public void readRegistry() {
			super.readRegistry();
		}

		@Override
		protected boolean readElement(IConfigurationElement element, boolean add) {
			boolean result = true;

			if(E_PROVIDER.equals(element.getName())) {
				if(add) {
					try {
						IContextStorageProvider provider = (IContextStorageProvider)element.createExecutableExtension(A_CLASS);
						provider.initialize(resourceSet);
						providers.add(provider);
					} catch (Exception e) {
						result = false;
						Activator.log.error("Failed to initialize context storage provider extension.", e); //$NON-NLS-1$
					}
				} else {
					try {
						String className = element.getAttribute(A_CLASS);
						for(Iterator<IContextStorageProvider> iter = providers.iterator(); iter.hasNext();) {
							IContextStorageProvider next = iter.next();
							if(className.equals(next.getClass().getName())) {
								// dispose of the provider
								try {
									next.dispose();
								} catch (Exception e) {
									Activator.log.error("Uncaught exception in disposal of context storage provider extension.", e); //$NON-NLS-1$
								}
								
								// and forget it
								iter.remove();
							}
						}
					} catch (Exception e) {
						result = false;
						Activator.log.error("Failed to remove context storage provider extension.", e); //$NON-NLS-1$
					}
				}
			}

			return result;
		}
	}
}
