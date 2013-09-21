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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResourceSet;
import org.eclipse.papyrus.infra.services.localizer.DefaultObjectLocalizer;
import org.eclipse.papyrus.infra.services.localizer.IObjectLocalizer;
import org.eclipse.papyrus.infra.services.localizer.internal.Activator;


/**
 * Utilities for getting/working with localizers.
 */
public class LocalizerUtil {

	/**
	 * Not instantiable by clients.
	 */
	private LocalizerUtil() {
		super();
	}

	public static IObjectLocalizer getDefault() {
		return DefaultObjectLocalizer.INSTANCE;
	}

	public static IObjectLocalizer getInstance(ResourceSet rset) {
		try {
			return getInstance(ServiceUtilsForResourceSet.getInstance().getServiceRegistry(rset));
		} catch (ServiceException e) {
			Activator.log.error("Failed to get localizer service.", e); //$NON-NLS-1$
		}

		return getDefault();
	}

	public static IObjectLocalizer getInstance(Resource resource) {
		try {
			return getInstance(ServiceUtilsForResource.getInstance().getServiceRegistry(resource));
		} catch (ServiceException e) {
			Activator.log.error("Failed to get localizer service.", e); //$NON-NLS-1$
		}

		return getDefault();
	}

	public static IObjectLocalizer getInstance(EObject object) {
		try {
			return getInstance(ServiceUtilsForEObject.getInstance().getServiceRegistry(object));
		} catch (ServiceException e) {
			Activator.log.error("Failed to get localizer service.", e); //$NON-NLS-1$
		}

		return getDefault();
	}

	public static IObjectLocalizer getInstance(ServicesRegistry services) {
		try {
			return services.getService(IObjectLocalizer.class);
		} catch (ServiceException e) {
			Activator.log.error("Failed to get localizer service.", e); //$NON-NLS-1$
		}

		return getDefault();
	}

}
