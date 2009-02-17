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

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;
import org.eclipse.uml2.uml.edit.providers.UMLResourceItemProviderAdapterFactory;

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class UMLComposedAdapterFactory {

	private static ComposedAdapterFactory umlCompAdapterFactory;

	public final static ComposedAdapterFactory getAdapterFactory() {
		if (umlCompAdapterFactory == null)
			umlCompAdapterFactory = new ComposedAdapterFactory(createFactoryList());
		return umlCompAdapterFactory;
	}
	
	//TODO maybe use : backboneContext.getResourceSet().getAdapterFactory()
	private final static ArrayList<AdapterFactory> createFactoryList() {
		// Common factories
		ArrayList<AdapterFactory> factories = new ArrayList<AdapterFactory>();
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new EcoreItemProviderAdapterFactory());
		//factories.add(new ReflectiveItemProviderAdapterFactory());
		factories.add(new UMLResourceItemProviderAdapterFactory());
		//factories.add(new UMLReflectiveItemProviderAdapterFactory());
		factories.add(new UMLItemProviderAdapterFactory());
		// factories.add(new UMLItemDiagramProviderAdapterFactory());
		// factories.add(new DiagramPackageProviderAdapterFactory());
		
		// ILabelDecorator labelDecorator = getLabelDecorator();
		// DecoratingLabelProvider decoratedLabelProvider;
		// if (labelDecorator != null) {
		// decoratedLabelProvider = new DecoratingLabelProvider(
		// new AdapterFactoryLabelProvider(factory), labelDecorator);
		// } else {
		// decoratedLabelProvider = null;
		// }

		// groupableFactory = new GroupableAdapterFactory(factory);

		// resource factories
		// if (resourceFactories == null) {
		// resourceFactories = new HashMap<String, Object>();
		// resourceFactories.put("uml", UMLResourceFactoryImpl.class);
		// resourceFactories.put("uml_diagram", GMFResourceFactory.class);
		// resourceFactories.put("ecore", ResourceFactoryImpl.class);
		// }

		return factories;
	}

}
