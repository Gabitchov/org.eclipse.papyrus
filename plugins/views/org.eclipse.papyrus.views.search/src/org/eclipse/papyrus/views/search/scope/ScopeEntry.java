/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Christian W. Damus (CEA LIST) - Fix leaking of all UML models in search results
 *  Christian W. Damus (CEA LIST) - Replace workspace IResource dependency with URI for CDO compatibility
 *  Christian W. Damus (CEA) - bug 431953 (fix start-up of selective services to require only their dependencies)
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.search.scope;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServiceMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceNotFoundException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.papyrus.infra.services.openelement.service.OpenElementService;
import org.eclipse.papyrus.infra.services.openelement.service.impl.OpenElementServiceImpl;
import org.eclipse.papyrus.views.search.Activator;
import org.eclipse.papyrus.views.search.Messages;
import org.eclipse.papyrus.views.search.utils.IServiceRegistryTracker;
import org.eclipse.papyrus.views.search.utils.ModelUtils;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * This class is used to aggregate information about the resource that contains the element that raised a match
 * 
 */
public class ScopeEntry {
	/**
	 * Tracks service registries created implicitly (not borrowed from editors) by scope entries, so that they may
	 * be properly shut down when no longer needed.
	 */
	private final IServiceRegistryTracker serviceRegistryTracker;

	/**
	 * The modelSet that contains the model element
	 */
	private ModelSet modelSet;

	/**
	 * The corresponding {@link ServicesRegistry}
	 */
	private ServicesRegistry servicesRegistry;

	/**
	 * The URI of the resource that contains the element that raised a match.
	 */
	private URI resourceURI;


	public ScopeEntry(URI resourceURI) {
		this(resourceURI, (IServiceRegistryTracker) null);
	}

	public ScopeEntry(URI resourceURI, IServiceRegistryTracker serviceRegistryTracker) {
		super();
		
		this.serviceRegistryTracker = serviceRegistryTracker;
		this.resourceURI = resourceURI;
		this.modelSet = getModelSet();
		this.servicesRegistry = getServicesRegistry();
	}

	public ScopeEntry(URI resourceURI, ServicesRegistry servicesRegistry) {
		super();
		
		this.serviceRegistryTracker = null;
		this.resourceURI = resourceURI;
		this.servicesRegistry = servicesRegistry;
		this.modelSet = getModelSet();
	}

	private Collection<IEditorPart> getEditors() {
		Collection<IEditorPart> results = new HashSet<IEditorPart>();
		IWorkbenchWindow[] windows = PlatformUI.getWorkbench().getWorkbenchWindows();
		for(IWorkbenchWindow iWorkbenchWindow : windows) {
			IWorkbenchPage[] pages = iWorkbenchWindow.getPages();
			for(IWorkbenchPage iWorkbenchPage : pages) {
				IEditorReference[] references = iWorkbenchPage.getEditorReferences();
				for(IEditorReference ref : references) {
					IEditorPart editor = ref.getEditor(true);
					results.add(editor);
				}
			}
		}

		return results;
	}

	private ServicesRegistry createServicesRegistry() {

		try {
			ServicesRegistry serviceRegistry = new ServicesRegistry();
			serviceRegistry.add(LabelProviderService.class, 10, new LabelProviderServiceImpl());
			serviceRegistry.add(OpenElementService.class, 10, new OpenElementServiceImpl());
			//			PageIconRegistryServiceFactory factory = new PageIconRegistryServiceFactory();
			//			Object instance = factory.createServiceInstance();
			//			serviceRegistry.add(IPageIconsRegistry.class, 10, instance);
			//			serviceRegistry.add(IPageIconsRegistry.class, 10, new PageIconRegistryServiceFactory());
			serviceRegistry.startRegistry();

			if(serviceRegistryTracker != null) {
				// register this service registry for automatic shut-down when it is no longer needed
				serviceRegistryTracker.track(this, serviceRegistry);
			}
			
			return serviceRegistry;
		} catch (ServiceException e) {
			Activator.log.error(Messages.ScopeEntry_0, e);
		}
		return null;
	}

	public ModelSet getModelSet() {
		//If null, try to find one or create one
		if(modelSet == null) {
			try {
				modelSet = ServiceUtils.getInstance().getModelSet(getServicesRegistry());
			} catch (ServiceException e) {
				//Create one
				try {

					modelSet = ModelUtils.openResource(getResourceURI());
					getServicesRegistry().add(ModelSet.class, 10, modelSet);
					getServicesRegistry().startServicesByClassKeys(ModelSet.class);
				} catch (ModelMultiException modelMultiException) {
					Activator.log.error(Messages.ScopeEntry_1 + this.getResourceURI(), modelMultiException);
				} catch (ServiceMultiException e1) {
					Activator.log.error(e1);
				} catch (ServiceNotFoundException e1) {
					Activator.log.error(e1);
				}
			}
		}
		return modelSet;
	}

	private IEditorPart editorOnResource() {
		Collection<IEditorPart> editors = getEditors();

		for(IEditorPart editor : editors) {

			if(editor != null) {
				if(getResourceURI().equals(EditorUtils.getResourceURI(editor))) {
					return editor;
				}
			}
		}

		return null;
	}

	private ServicesRegistry getUpdatedServiceRegistry() {
		IEditorPart editor = editorOnResource();
		if(editor != null) {

			ServicesRegistry registry = (ServicesRegistry)editor.getAdapter(ServicesRegistry.class);

			return registry;

		}

		return servicesRegistry;
	}

	public ServicesRegistry getServicesRegistry() {

		if(servicesRegistry == null) {
			//Try to find existing
			ServicesRegistry registry = getUpdatedServiceRegistry();
			if(registry != null) {
				//If the OpenElementService is no yet available, we must start it
				try {
					registry.getService(OpenElementService.class);
				} catch (ServiceException e) {
					registry.add(OpenElementService.class, 10, new OpenElementServiceImpl());
				}

				servicesRegistry = registry;

			} else {
				servicesRegistry = createServicesRegistry();
			}
		}

		return servicesRegistry;
	}

	public URI getResourceURI() {
		return resourceURI;
	}
	
	public void setResourceURI(URI resourceURI) {
		this.resourceURI = resourceURI;
	}

}
