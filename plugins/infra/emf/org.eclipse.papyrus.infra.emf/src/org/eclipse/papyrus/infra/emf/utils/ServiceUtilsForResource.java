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
 *  Christian W. Damus (CEA) - bug 431953 (fix start-up of selective services to require only their dependencies)
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.emf.utils;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.editor.ModelSetServiceFactory;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServiceNotFoundException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.AbstractServiceUtils;

/**
 * Get the {@link ServicesRegistry} from a {@link EObject} or a {@link Resource}.
 * This class allow to retrieve the {@code ServicesRegistry} associated to the {@link ResourceSet} owning the {@code Resource}
 * containing the {@code EObject}.
 * <p>
 * To work properly, the EObject should be associated to a {@link Resource}, itself registered in a {@link ResourceSet}.
 * Also, the {@code ServicesRegistry} should be associated to the {@code ResourceSet}.
 * Normally, this is automatically done thanks to the {@link ModelSetServiceFactory} service.
 * If you access this class from a service, you can ensure that the latter service is started by letting your service
 * depend on the <tt>org.eclipse.papyrus.infra.core.editor.ModelSetServiceFactory</tt>.
 * </p>
 * 
 * @author cedric dumoulin
 * 
 */
public class ServiceUtilsForResource extends AbstractServiceUtils<Resource> {

	private final static ServiceUtilsForResource instance = new ServiceUtilsForResource();

	/**
	 * Get the singleton instance of the class.
	 * 
	 * @return
	 */
	public static final ServiceUtilsForResource getInstance() {
		return instance;
	}

	/**
	 * Get the {@link ServicesRegistry} from a {@link Resource}.
	 * 
	 * @param from
	 *        The {@link Resource} from which we want the associated {@link ServicesRegistry}.
	 * @return
	 * @throws ServiceException
	 *         If there is no {@link ServicesRegistry} associated to the {@link ResourceSet} owning the {@link Resource}.
	 */
	@Override
	public ServicesRegistry getServiceRegistry(Resource from) throws ServiceException {
		if(from == null) {
			throw new ServiceNotFoundException("Can't find the ResourceSet needed retrieve the ServiceRegistry."); //$NON-NLS-1$
		}
		return ServiceUtilsForResourceSet.getInstance().getServiceRegistry(from.getResourceSet());
	}

}
