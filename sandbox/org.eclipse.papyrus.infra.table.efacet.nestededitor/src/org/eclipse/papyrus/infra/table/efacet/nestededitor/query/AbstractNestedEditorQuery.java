package org.eclipse.papyrus.infra.table.efacet.nestededitor.query;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.table.efacet.nestededitor.Activator;


public abstract class AbstractNestedEditorQuery<T2> implements IJavaQuery2<EObject, T2> {

	protected ServicesRegistry getServiceRegistry(final EObject object) {
		ServicesRegistry serviceRegistry = null;
		final Resource res = object.eResource();
		if(res != null) {
			try {
				serviceRegistry = ServiceUtilsForResource.getInstance().getServiceRegistry(res);
			} catch (ServiceException e) {
				Activator.log.error("Service Registry not found!", e);
			}
		}
		return serviceRegistry;
	}

	protected IPageMngr getPageMngr(final EObject object) {
		IPageMngr pageManager = null;
		final ServicesRegistry serviceRegistry = getServiceRegistry(object);

		if(serviceRegistry != null) {
			try {
				pageManager = ServiceUtils.getInstance().getIPageMngr(serviceRegistry);
			} catch (ServiceException e) {
				Activator.log.error("PageManager not found", e);
			}
		}
		return pageManager;
	}

}
