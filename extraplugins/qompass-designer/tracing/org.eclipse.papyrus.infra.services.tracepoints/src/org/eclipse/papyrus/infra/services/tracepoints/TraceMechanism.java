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
 *  Ansgar Radermacher (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.tracepoints;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;


/**
 * Support for multiple trace mechanisms via the Eclipse extension mechanism
 */

public class TraceMechanism {

	public static final String ITRACE_MECHANISM_ID = Activator.PLUGIN_ID + ".traceMechanism";

	public static EList<ITraceMechanism> getTraceMechanisms()
	{
		EList<ITraceMechanism> mechanisms = new BasicEList<ITraceMechanism>();
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] configElements = reg.getConfigurationElementsFor(ITRACE_MECHANISM_ID);
		for(IConfigurationElement configElement : configElements) {
			try {
				// TODO: cache returned instance (avoid creating a new instance each time => more efficient, no need for static attributes)
				final Object obj = configElement.createExecutableExtension("class");
				if(obj instanceof ITraceMechanism) {
					mechanisms.add((ITraceMechanism)obj);
				}
			} catch (CoreException exception) {
				exception.printStackTrace();
			}
		}
		return mechanisms;
	}
}
