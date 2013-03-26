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
package org.eclipse.papyrus.customization.properties.storage.actions;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.papyrus.customization.properties.Activator;
import org.eclipse.papyrus.views.properties.contexts.Context;

/**
 * This is the ContextStorageActionRegistry type. Enjoy.
 */
public class ContextStorageActionRegistry {

	private static final String EXT_POINT = "contextStorage"; //$NON-NLS-1$

	private final List<IContextStorageActionProvider> providers = new java.util.ArrayList<IContextStorageActionProvider>();

	public ContextStorageActionRegistry() {
		super();

		new MyRegistryReader().readRegistry();
	}

	public List<IContextStorageActionProvider> getStorageActionProviders() {
		return Collections.unmodifiableList(providers);
	}

	public IContextStorageActionProvider getStorageActionProvider(Context context) {
		IContextStorageActionProvider result = IContextStorageActionProvider.READ_ONLY;

		for(IContextStorageActionProvider next : providers) {
			if(next.providesFor(context)) {
				result = next;
				break;
			}
		}

		return result;
	}

	public IContextCopyAction getContextCopyAction(Context context) {
		return getStorageActionProvider(context).getContextCopyAction();
	}
	
	public IContextEditAction getContextEditAction(Context context) {
		return getStorageActionProvider(context).getContextEditAction();
	}
	
	public IContextDeleteAction getContextDeleteAction(Context context) {
		return getStorageActionProvider(context).getContextDeleteAction();
	}
	
	//
	// Nested types
	//

	private class MyRegistryReader extends RegistryReader {

		private static final String A_CLASS = "class"; //$NON-NLS-1$

		private static final String E_ACTION_PROVIDER = "actionProvider"; //$NON-NLS-1$

		private Map<IContextStorageActionProvider, IConfigurationElement> providerElements = new java.util.HashMap<IContextStorageActionProvider, IConfigurationElement>();

		MyRegistryReader() {
			super(Platform.getExtensionRegistry(), Activator.PLUGIN_ID, EXT_POINT);
		}

		@Override
		public void readRegistry() {
			super.readRegistry();

			// sort any providers contributed by this plug-in to the front
			Collections.sort(providers, new Comparator<IContextStorageActionProvider>() {

				public int compare(IContextStorageActionProvider o1, IContextStorageActionProvider o2) {
					int result = 0;

					if(isOurs(o1)) {
						result = isOurs(o2) ? 0 : -1;
					} else if(isOurs(o2)) {
						result = +1;
					}

					return result;
				}
			});
		}

		private boolean isOurs(IContextStorageActionProvider provider) {
			boolean result = false;

			IConfigurationElement config = providerElements.get(provider);
			if(config != null) {
				Activator.PLUGIN_ID.equals(config.getContributor().getName());
			}

			return result;
		}

		@Override
		protected boolean readElement(IConfigurationElement element) {
			boolean result = true;

			if(E_ACTION_PROVIDER.equals(element.getName())) {
				try {
					providers.add((IContextStorageActionProvider)element.createExecutableExtension(A_CLASS));
				} catch (Exception e) {
					result = false;
					Activator.log.error("Failed to instantiate context storage action provider extension.", e); //$NON-NLS-1$
				}
			}

			return result;
		}
	}
}
