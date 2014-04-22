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
 *  Christian W. Damus (CEA) - bug 431953 (pre-requisite refactoring of ModelSet service start-up)
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.utils;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.papyrus.infra.core.editor.ModelSetServiceFactory;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;

/**
 * This AdapterFactory is used to attach a reference on the ServiceRegiqtry to an EMF ResourceSet.
 * 
 * This adapterFactory is not a real factory: no adapter is created.
 * 
 * @author cedric dumoulin
 * 
 * @deprecated Since 1.0, the {@link ModelSetServiceFactory} class associates the model-set with its service registry.
 */
@Deprecated
public class ServiceRegistryAdapterFactory extends AdapterFactoryImpl {

	/**
	 * ID used to register the factory in the ResourceSet.
	 */
	static final public String TYPE_ID = ServiceRegistryAdapterFactory.class.getName() + "TypeId";

	/**
	 * The reference to the ServiceRegistry.
	 */
	protected ServicesRegistry servicesRegistry;

	/**
	 * @param servicesRegistry
	 */
	public ServiceRegistryAdapterFactory(ServicesRegistry servicesRegistry) {
		this.servicesRegistry = servicesRegistry;
	}

	/**
	 * 
	 * @return the associated {@link ServicesRegistry}
	 */
	public ServicesRegistry getServicesRegistry() {
		return servicesRegistry;
	}

	@Override
	public boolean isFactoryForType(Object type) {
		return type.equals(TYPE_ID);
	}
}
