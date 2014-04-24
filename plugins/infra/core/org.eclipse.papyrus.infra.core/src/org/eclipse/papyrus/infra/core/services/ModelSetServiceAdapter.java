/*****************************************************************************
 * Copyright (c) 2012, 2014 Cedric Dumoulin, CEA, and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 431953 (adapted from the ServiceRegistryAdapterFactory class)
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.services;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.core.resource.ModelSet;

import com.google.common.collect.ImmutableList;


/**
 * A service lifecycle adapter for {@link ModelSet}s that are injected into a {@link ServicesRegistry} that were not created by their factory.
 */
public class ModelSetServiceAdapter extends AdapterFactoryImpl implements IService {

	/**
	 * ID used to register the factory in the ResourceSet.
	 */
	private static final String TYPE_ID = ModelSetServiceAdapter.class.getName() + "TypeId";

	private final ResourceSet modelSet;

	private ServicesRegistry registry;

	public ModelSetServiceAdapter(ResourceSet modelSet) {
		super();

		this.modelSet = modelSet;
	}

	public ServicesRegistry getServiceRegistry() {
		return registry;
	}

	public static ModelSetServiceAdapter getInstance(ResourceSet resourceSet) {
		ModelSetServiceAdapter result = null;

		if(resourceSet != null) {
			AdapterFactory factory = EcoreUtil.getAdapterFactory(resourceSet.getAdapterFactories(), TYPE_ID);
			if(factory instanceof ModelSetServiceAdapter) {
				result = (ModelSetServiceAdapter)factory;
			}
		}

		return result;
	}

	//
	// EMF Adapter Factory protocol
	//

	@Override
	public boolean isFactoryForType(Object type) {
		return type.equals(TYPE_ID);
	}

	//
	// IService lifecycle protocol
	//

	@Override
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		this.registry = servicesRegistry;
	}

	@Override
	public void startService() throws ServiceException {
		// First, remove any existing adapter
		AdapterFactory factory = EcoreUtil.getAdapterFactory(modelSet.getAdapterFactories(), TYPE_ID);
		if(factory != null) {
			modelSet.getAdapterFactories().remove(factory);
		}

		modelSet.getAdapterFactories().add(this);
	}

	public void stopService() {
		modelSet.getAdapterFactories().remove(this);
	}
	
	@Override
	public void disposeService() throws ServiceException {
		try {
			stopService();
		} finally {
			if(modelSet instanceof ModelSet) {
				((ModelSet)modelSet).unload();
			} else {
				for(Resource next : ImmutableList.copyOf(modelSet.getResources())) {
					next.unload();
					next.eAdapters().clear();
				}
				modelSet.getResources().clear();
				modelSet.eAdapters().clear();
			}
		}
	}

	//
	// Nested types
	//

	/**
	 * Factory for the external {@link IService} adapters for service lifecycle management of {@link ModelSet}s.
	 */
	public static class Factory implements IAdapterFactory {

		private final Class<?>[] adapterTypes = { IService.class };

		@SuppressWarnings("rawtypes")
		@Override
		public Class[] getAdapterList() {
			return adapterTypes;
		}

		@Override
		public Object getAdapter(Object adaptableObject, @SuppressWarnings("rawtypes") Class adapterType) {
			Object result = null;

			if(adapterType == IService.class) {
				if((adaptableObject instanceof ModelSet)) {
					result = new ModelSetServiceAdapter((ModelSet)adaptableObject);
				}
			}

			return result;
		}
	}
}
