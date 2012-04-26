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
package org.eclipse.papyrus.infra.gmfdiag.common.providers;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;


public class ThemeInitializerManager {

	private static final String EXTENSION_ID = Activator.ID + ".initializeView";

	public static IThemeInitializer instance = loadThemeInitializer();

	private static IThemeInitializer loadThemeInitializer() {
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

		for(IConfigurationElement e : config) {
			try {
				final IThemeInitializer initializer = (IThemeInitializer)e.createExecutableExtension("initializeView"); //$NON-NLS-1$
				if(initializer != null) {
					return initializer;
				}
			} catch (Exception ex) {
				Activator.log.error("The plugin " + e.getContributor().getName() + " contributed an invalid extension for " + EXTENSION_ID, ex);
			}
		}

		return new DefaultThemeInitializer();
	}

	private static class DefaultThemeInitializer implements IThemeInitializer {

		public boolean usePreferenceInitializer(View view) {
			return true;
		}

	}
}
