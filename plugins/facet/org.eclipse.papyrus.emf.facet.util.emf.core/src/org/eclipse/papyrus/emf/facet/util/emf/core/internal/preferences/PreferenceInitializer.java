/**
 * Copyright (c) 2011 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Nicolas Guyomar (Mia-Software) - Bug 333652 Extension point offering the possibility to declare an EPackage browser
 * 	Nicolas Bros (Mia-Software) - Bug 335218 - Extension point for registering EObject, EPackage, model editor
 *  Laurent Pichierri (Soft-Maint) - Bug 371204 - Compatibility with Helios
 */
package org.eclipse.emf.facet.util.emf.core.internal.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.emf.facet.util.emf.core.IBrowserRegistry;
import org.eclipse.emf.facet.util.emf.core.IEObjectBrowserOpener;
import org.eclipse.emf.facet.util.emf.core.IEPackageBrowserOpener;
import org.eclipse.emf.facet.util.emf.core.IResourceBrowserOpener;
import org.eclipse.emf.facet.util.emf.core.internal.Activator;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		IEclipsePreferences preferenceNode = new DefaultScope().getNode(Activator.PLUGIN_ID);
		// general rule is to keep the same behavior as EMF by default
		IEObjectBrowserOpener defaultEObjectBrowserOpener = IBrowserRegistry.INSTANCE
				.getDefaultEObjectBrowserOpener();
		if (defaultEObjectBrowserOpener != null) {
			preferenceNode.put(PreferenceConstants.P_DEFAULT_EOBJECT_VIEWER,
					defaultEObjectBrowserOpener.getClass().getName());
		}

		IEPackageBrowserOpener defaultEPackageBrowserOpener = IBrowserRegistry.INSTANCE
				.getDefaultEPackageBrowserOpener();
		if (defaultEPackageBrowserOpener != null) {
			preferenceNode.put(PreferenceConstants.P_DEFAULT_EPACKAGE_VIEWER,
					defaultEPackageBrowserOpener.getClass().getName());
		}

		IResourceBrowserOpener defaultResourceBrowserOpener = IBrowserRegistry.INSTANCE
				.getDefaultResourceBrowserOpener();
		if (defaultResourceBrowserOpener != null) {
			preferenceNode.put(PreferenceConstants.P_DEFAULT_RESOURCE_VIEWER,
					defaultResourceBrowserOpener.getClass().getName());
		}

	}

}
