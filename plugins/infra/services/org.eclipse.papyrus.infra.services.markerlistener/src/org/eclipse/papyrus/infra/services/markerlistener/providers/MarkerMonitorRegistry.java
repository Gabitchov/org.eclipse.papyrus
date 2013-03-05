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
package org.eclipse.papyrus.infra.services.markerlistener.providers;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.papyrus.infra.services.markerlistener.Activator;

/**
 * This is the MarkerProviderRegistry type. Enjoy.
 */
public class MarkerMonitorRegistry {

	private static final String EXT_POINT = "markerproviders";

	private final List<IMarkerMonitor> monitors = new java.util.ArrayList<IMarkerMonitor>();

	public MarkerMonitorRegistry() {
		super();

		new MyRegistryReader().readRegistry();
	}

	public List<IMarkerMonitor> getMarkerMonitors() {
		return Collections.unmodifiableList(monitors);
	}

	//
	// Nested types
	//

	private class MyRegistryReader
			extends RegistryReader {

		private static final String A_CLASS = "class";

		private static final String E_MONITOR = "monitor";

		MyRegistryReader() {
			super(Platform.getExtensionRegistry(), Activator.PLUGIN_ID,
				EXT_POINT);
		}

		@Override
		protected boolean readElement(IConfigurationElement element) {
			boolean result = true;

			if (E_MONITOR.equals(element.getName())) {
				try {
					monitors.add((IMarkerMonitor) element
						.createExecutableExtension(A_CLASS));
				} catch (Exception e) {
					result = false;
					Activator.log.error(
						"Failed to instantiate marker monitor extension.", e);
				}
			}

			return result;
		}
	}
}
