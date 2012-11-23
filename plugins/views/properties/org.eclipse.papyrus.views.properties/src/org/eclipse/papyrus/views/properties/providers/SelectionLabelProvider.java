/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.providers;

import java.util.Collection;
import java.util.TreeMap;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.services.labelprovider.service.ExtensibleLabelProvider;
import org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider;
import org.eclipse.papyrus.views.properties.Activator;

/**
 * A class for providing labels for a selected element.
 * This label provider dispatchs the calls to the label providers
 * registered through an extension point, according to the given selection
 * 
 * @author Camille Letavernier
 * 
 */
public class SelectionLabelProvider extends ExtensibleLabelProvider {

	public static final String EXTENSION_ID = "org.eclipse.papyrus.views.properties.labelprovider"; //$NON-NLS-1$

	public static final String LABEL_PROVIDER_PROPERTY = "labelProvider"; //$NON-NLS-1$

	public static final String PRIORITY_PROPERTY = "priority"; //$NON-NLS-1$

	protected final TreeMap<Integer, Collection<IFilteredLabelProvider>> labelProviders = new TreeMap<Integer, Collection<IFilteredLabelProvider>>();

	public SelectionLabelProvider() {
		super();
		readExtensionPoint();
	}

	protected void readExtensionPoint() {
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

		for(IConfigurationElement e : config) {
			try {
				final IFilteredLabelProvider provider = (IFilteredLabelProvider)e.createExecutableExtension(LABEL_PROVIDER_PROPERTY);
				final int priority = Integer.parseInt(e.getAttribute(PRIORITY_PROPERTY));
				registerProvider(priority, provider);
			} catch (Exception ex) {
				Activator.log.error("Cannot load the label provider : " + e.getAttribute(LABEL_PROVIDER_PROPERTY), ex);
			}
		}
	}
}
