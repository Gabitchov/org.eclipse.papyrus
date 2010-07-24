/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.navigator.providers;

import java.util.ArrayList;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.papyrus.core.Activator;
import org.eclipse.papyrus.core.extension.ExtensionException;

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class NavigatorComposedAdapterFactory extends ComposedAdapterFactory {

	/** ID of the editor extension (schema filename) */
	private static final String ID = "providerAdapterFactory";


	/** Namespace where to look for the extension points. */
	private static final String NAMESPACE = "org.eclipse.papyrus.navigator";

	private static ComposedAdapterFactory navCompAdapterFactory;

	public final static ComposedAdapterFactory getAdapterFactory() {
		if(navCompAdapterFactory == null)
			navCompAdapterFactory = new ComposedAdapterFactory(createFactoryList());
		return navCompAdapterFactory;
	}

	private NavigatorComposedAdapterFactory() {
		super(createFactoryList());
	}

	private final static ArrayList<AdapterFactory> createFactoryList() {
		// Common factories
		ArrayList<AdapterFactory> factories = new ArrayList<AdapterFactory>();
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new EcoreItemProviderAdapterFactory());

		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(NAMESPACE, ID);
		ProviderAdapterFactoryReader adapterFactoryReader = new ProviderAdapterFactoryReader();

		for(IConfigurationElement ele : configElements) {
			try {
				factories.add(adapterFactoryReader.createProviderAdapterFactory(ele));
			} catch (ExtensionException e) {
				Activator.getDefault().getLog().log(new Status(IStatus.WARNING, Activator.PLUGIN_ID, e.getMessage(), e));
			}

		}

		return factories;
	}

}
