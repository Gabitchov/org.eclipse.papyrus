/*****************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.localizer.util;

import org.eclipse.papyrus.infra.core.services.IServiceFactory;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.services.localizer.DefaultObjectLocalizer;


/**
 * Service factory for the default object localizer.
 */
public class DefaultObjectLocalizerFactory implements IServiceFactory {

	public DefaultObjectLocalizerFactory() {
		super();
	}

	@Override
	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		// pass.  The localizer is stateless and requires no initialization
	}

	@Override
	public void startService() throws ServiceException {
		// pass.  The localizer is stateless and requires no starting
	}

	@Override
	public void disposeService() throws ServiceException {
		// pass.  The localizer is stateless and requires no disposal
	}

	@Override
	public Object createServiceInstance() throws ServiceException {
		return DefaultObjectLocalizer.INSTANCE;
	}

}
