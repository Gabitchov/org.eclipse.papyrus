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
package org.eclipse.papyrus.cdo.core.resource;

import java.io.IOException;

import org.eclipse.emf.cdo.dawn.gmf.util.DawnDiagramUpdater;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.cdo.view.CDOViewInvalidationEvent;
import org.eclipse.emf.cdo.view.CDOViewSet;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.core.IPapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.services.resourceloading.OnDemandLoadingModelSet;

import com.google.common.collect.Iterables;

/**
 * This is the CDOAwareModelSet type. Enjoy.
 */
public class CDOAwareModelSet
		extends OnDemandLoadingModelSet {

	private final ThreadLocal<Boolean> inGetResource = new ThreadLocal<Boolean>();

	private final IPapyrusRepositoryManager repositoryManager;

	private IPapyrusRepository repository;

	private IListener invalidationListener;

	public CDOAwareModelSet(IPapyrusRepositoryManager repositoryManager) {
		super();

		this.repositoryManager = repositoryManager;
	}

	@Override
	public EObject getEObject(URI uri, boolean loadOnDemand) {
		return CDOUtils.isCDOURI(uri)
			? basicGetEObject(uri, loadOnDemand)
			: super.getEObject(uri, loadOnDemand);
	}

	protected EObject basicGetEObject(URI uri, boolean loadOnDemand) {
		Resource resource = getResource(uri.trimFragment(), loadOnDemand);

		return (resource == null)
			? null
			: resource.getEObject(uri.fragment());
	}

	@Override
	public Resource getResource(URI uri, boolean loadOnDemand) {
		Boolean oldValue = inGetResource.get();
		inGetResource.set(Boolean.TRUE);

		try {
			return super.getResource(uri, loadOnDemand);
		} finally {
			inGetResource.set(oldValue);
		}
	}

	boolean isInGetResource() {
		return inGetResource.get() == Boolean.TRUE;
	}

	@Override
	public Resource createResource(URI uri, String contentType) {
		initTransaction(uri);
		return super.createResource(uri, contentType);
	}

	@Override
	protected void demandLoad(Resource resource)
			throws IOException {

		if (CDOUtils.isCDOURI(resource.getURI())) {
			// XML options not applicable to CDO resources
			resource.load(null);

			resourceLoadedHook(resource);
		} else {
			super.demandLoad(resource);
		}
	}

	protected void resourceLoadedHook(Resource resource) {
		for (Diagram next : Iterables.filter(resource.getContents(),
			Diagram.class)) {

			DawnDiagramUpdater.initializeElement(next);
		}
	}

	public CDOView getCDOView() {
		CDOViewSet viewSet = CDOUtil.getViewSet(this);
		CDOView[] views = (viewSet == null)
			? null
			: viewSet.getViews();

		return ((views != null) && (views.length > 0))
			? views[0]
			: null;
	}

	@Override
	public void createModels(URI newURI) {
		initTransaction(newURI);
		super.createModels(newURI);
	}

	@Override
	public void loadModels(URI uri)
			throws ModelMultiException {

		initTransaction(uri);
		super.loadModels(uri);
	}

	protected void initTransaction(URI uri) {
		if (getCDOView() == null) {
			// get the repository and start a transaction on it

			if (repository == null) {
				repository = repositoryManager.getRepositoryForURI(uri);
			}

			if (repository != null) {
				repository.createTransaction(this);
				CDOView view = getCDOView();
				if (view != null) {
					view.addListener(getInvalidationListener());
				}
			}
		}
	}

	@Override
	public void unload() {
		if ((repository != null) && (getCDOView() != null)) {
			CDOView view = getCDOView();
			if (view != null) {
				view.removeListener(getInvalidationListener());
			}
			invalidationListener = null;

			// dispose the transaction
			repository.close(this);
		}

		repository = null;

		super.unload();
	}

	protected final IListener getInvalidationListener() {
		if (invalidationListener == null) {
			invalidationListener = createInvalidationListener();
		}
		return invalidationListener;
	}

	protected IListener createInvalidationListener() {
		return new IListener() {

			public void notifyEvent(IEvent event) {
				if (event instanceof CDOViewInvalidationEvent) {
					TransactionalEditingDomain domain = getTransactionalEditingDomain();
					if (domain instanceof CDOAwareTransactionalEditingDomain) {
						((CDOAwareTransactionalEditingDomain) domain)
						.fireResourceSetChanged((CDOViewInvalidationEvent) event);
					}
				}
			}
		};
	}
}
