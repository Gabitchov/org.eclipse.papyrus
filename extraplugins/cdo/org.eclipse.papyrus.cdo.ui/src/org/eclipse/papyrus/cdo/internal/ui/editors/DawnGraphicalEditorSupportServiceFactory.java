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
package org.eclipse.papyrus.cdo.internal.ui.editors;

import org.eclipse.papyrus.infra.core.services.IServiceFactory;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;


/**
 * This is the DawnGraphicalEditorSupportServiceFactory type.  Enjoy.
 */
public class DawnGraphicalEditorSupportServiceFactory
		implements IServiceFactory {

	private ServicesRegistry registry;
	
	private DawnGraphicalEditorSupport service;
	
	public DawnGraphicalEditorSupportServiceFactory() {
		super();
	}

	public void init(ServicesRegistry servicesRegistry)
			throws ServiceException {
		
		this.registry = servicesRegistry;
	}

	public void startService()
			throws ServiceException {
		
		// pass
	}

	public void disposeService()
			throws ServiceException {
		
		if (service == null) {
			// TODO clean up?
		}
	}

	public Object createServiceInstance()
			throws ServiceException {
		
		service = new DawnGraphicalEditorSupport(registry);
		return service;
	}

}
