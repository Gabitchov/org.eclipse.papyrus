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
package org.eclipse.papyrus.infra.emf.appearance.helper;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.papyrus.infra.emf.appearance.Activator;
import org.eclipse.papyrus.infra.emf.appearance.style.AnnotationStyleProvider;
import org.eclipse.papyrus.infra.emf.appearance.style.AppearanceStyleProvider;


public class AppearanceHelper {
	
	public static String EXTENSION_ID = Activator.PLUGIN_ID + ".styleProvider";
	
	private static AppearanceStyleProvider styleProvider = findStyleProvider();
	
	public static boolean showElementIcon(EModelElement modelElement) {
		return styleProvider.showElementIcon(modelElement);
	}

	public static int getQualifiedNameDepth(EModelElement modelElement) {
		return styleProvider.getQualifiedNameDepth(modelElement);
	}

	public static boolean showShadow(EModelElement modelElement) {
		return styleProvider.showShadow(modelElement);
	}
	
	public static int getLabelDisplay(EModelElement modelElement){
		return styleProvider.getLabelDisplay(modelElement);
	}

	private static AppearanceStyleProvider findStyleProvider() {
		//Default style provider
		AppearanceStyleProvider provider = new AnnotationStyleProvider();

		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

		int currentPriority = Integer.MAX_VALUE;
		for(IConfigurationElement e : config) {
			try {
				int priority = Integer.parseInt(e.getAttribute("priority")); //$NON-NLS-1$
				if(priority < currentPriority) {
					provider = (AppearanceStyleProvider)e.createExecutableExtension("styleProvider"); //$NON-NLS-1$
					currentPriority = priority;
				}
			} catch (Exception ex) {
				Activator.log.error("The plugin " + e.getContributor() + " contributed an invalid extension for " + EXTENSION_ID, ex); //$NON-NLS-1$//$NON-NLS-2$
			}
		}

		return provider;
	}

	
	
}
