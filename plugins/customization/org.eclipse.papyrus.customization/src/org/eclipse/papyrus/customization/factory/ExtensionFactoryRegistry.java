/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.factory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.customization.Activator;
import org.eclipse.papyrus.customization.model.customizationplugin.CustomizationPluginPackage;

public class ExtensionFactoryRegistry {

	public static final String EXTENSION_ID = Activator.PLUGIN_ID + ".factory";

	public static ExtensionFactoryRegistry instance = new ExtensionFactoryRegistry();

	private final Map<EClass, ExtensionFactory> factories;

	private ExtensionFactoryRegistry() {
		factories = new HashMap<EClass, ExtensionFactory>();
		loadExtensionFactories();
	}

	private void loadExtensionFactories() {
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

		for(IConfigurationElement e : config) {
			ExtensionFactory factory;
			try {
				factory = (ExtensionFactory)e.createExecutableExtension("factory"); //$NON-NLS-1$
				if(!CustomizationPluginPackage.eINSTANCE.getCustomizableElement().isSuperTypeOf(factory.getCustomizableElementClass())) {
					Activator.log.warn(String.format("The plugin %s contributed an invalid factory (%s).\nThe associated EClass must implement CustomizableElement", e.getContributor().getName(), e.getAttribute("factory")));
					continue;
				}

				factories.put(factory.getCustomizableElementClass(), factory);
			} catch (Exception ex) {
				Activator.log.warn(String.format("The plugin %s contributed an invalid factory (%s)", e.getContributor().getName(), e.getAttribute("factory")));
				Activator.log.error(ex);
			}
		}
	}

	public ExtensionFactory getFactory(EClass type) {
		return factories.get(type);
	}

	public void registerFactory(EClass forType, ExtensionFactory factory) {
		factories.put(forType, factory);
	}

	public Collection<? extends ExtensionFactory> getFactories() {
		return factories.values();
	}
}
