/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Ansgar Radermacher (CEA LIST) - ansgar.radermacher@cea.fr 
 *****************************************************************************/

package org.eclipse.papyrus.infra.services.decoration.util;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.services.decoration.Activator;
import org.eclipse.papyrus.infra.services.decoration.IDecorationSpecificFunctions;



/**
 * Return access to the extensions of interface IDecorationSpecificFunctions
 * 
 * @author ansgar
 * 
 */
public class DecorationSpecificFunctions {

	public static final String DECORATION_SPECIFIC_FUNCTIONS_ID = Activator.PLUGIN_ID + ".decorationSpecificFunctions";

	public static final String DECORATION_TYPE_ID = "decorationType";

	public static IDecorationSpecificFunctions getDecorationInterface(String decorationType) {
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] configElements = reg.getConfigurationElementsFor(DECORATION_SPECIFIC_FUNCTIONS_ID);
		for(IConfigurationElement configElement : configElements) {
			try {
				final String iConfiguratorIDext = configElement.getAttribute(DECORATION_TYPE_ID);
				if((iConfiguratorIDext != null) && iConfiguratorIDext.equals(decorationType)) {
					// TODO: cache returned instance (avoid creating a new instance each time => more efficient, no need for static attributes)
					final Object obj = configElement.createExecutableExtension("class");
					if(obj instanceof IDecorationSpecificFunctions) {
						return (IDecorationSpecificFunctions)obj;
					}
				}
			} catch (CoreException exception) {
				exception.printStackTrace();
			}
		}
		return null;
	}
}
