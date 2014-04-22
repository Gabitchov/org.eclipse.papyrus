/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.core.services.internal;

import org.eclipse.papyrus.infra.core.services.BadStateException;
import org.eclipse.papyrus.infra.core.services.IService;
import org.eclipse.papyrus.infra.core.services.ServiceDescriptor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;


/**
 * Entry for POJO services that have service lifecycle adapters.
 */
public class ServiceAdapterEntry extends PojoServiceEntry {

	private IService serviceAdapter;

	public ServiceAdapterEntry(ServiceDescriptor serviceDescriptor, Object serviceInstance, IService serviceAdapter) {
		super(serviceDescriptor, serviceInstance);

		this.serviceAdapter = serviceAdapter;
	}

	@Override
	public void initService(ServicesRegistry servicesRegistry) throws ServiceException {
		checkAdapter();
		serviceAdapter.init(servicesRegistry);
		super.initService(servicesRegistry);
	}

	protected final void checkAdapter() throws ServiceException {
		if(serviceAdapter == null) {
			throw new BadStateException("Service is disposed", state, serviceDescriptor);
		}
	}

	@Override
	public void startService() throws ServiceException {
		checkAdapter();
		serviceAdapter.startService();
		super.startService();
	}

	@Override
	public void disposeService() throws ServiceException {
		if(serviceAdapter != null) {
			serviceAdapter.disposeService();
			serviceAdapter = null;
		}
		super.disposeService();
	}

}
