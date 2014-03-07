/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus (CEA) - bug 429242
 *   
 *****************************************************************************/
package org.eclipse.papyrus.cdo.core.resource;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOState;
import org.eclipse.emf.cdo.dawn.gmf.util.DawnDiagramUpdater;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.cdo.util.CommitException;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.cdo.view.CDOViewInvalidationEvent;
import org.eclipse.emf.cdo.view.CDOViewSet;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.core.IPapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.cdo.internal.core.controlmode.CDOControlModeParticipant;
import org.eclipse.papyrus.cdo.internal.core.controlmode.CDOProxyManager;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.services.resourceloading.OnDemandLoadingModelSet;

import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * This is the CDOAwareModelSet type. Enjoy.
 */
public class CDOAwareModelSet extends OnDemandLoadingModelSet {

	private static final Set<CDOState> DIRTY_STATES = EnumSet.of(CDOState.NEW, CDOState.DIRTY, CDOState.CONFLICT, CDOState.INVALID_CONFLICT);

	private final ThreadLocal<Boolean> inGetResource = new ThreadLocal<Boolean>();

	private final CDOProxyManager proxyManager = new CDOProxyManager(this);

	private final IPapyrusRepositoryManager repositoryManager;

	private IPapyrusRepository repository;

	private IListener invalidationListener;

	public CDOAwareModelSet(IPapyrusRepositoryManager repositoryManager) {
		super();

		this.resources = new SafeResourceList();

		setTrackingModification(false);

		this.repositoryManager = repositoryManager;
	}

	@Override
	public EObject getEObject(URI uri, boolean loadOnDemand) {
		return CDOUtils.isCDOURI(uri) ? getCDOObject(uri, loadOnDemand) : super.getEObject(uri, loadOnDemand);
	}

	protected EObject getCDOObject(URI uri, boolean loadOnDemand) {
		EObject result = null;

		if(CDOProxyManager.isCDOProxyURI(uri)) {
			// get a real proxy object, out of thin air, to give CDO the non-null
			// instance that it needs (otherwise the 'non-null constraint' of
			// all kinds of reference lists will be violated)
			result = proxyManager.getProxy(uri);
		} else {
			result = super.getEObject(uri, loadOnDemand);
		}

		return result;
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
	protected void demandLoad(Resource resource) throws IOException {

		if(CDOUtils.isCDOURI(resource.getURI())) {
			// XML options not applicable to CDO resources
			resource.load(null);

			resourceLoadedHook(resource);
		} else {
			super.demandLoad(resource);
		}
	}

	protected void resourceLoadedHook(Resource resource) {
		for(Diagram next : Iterables.filter(resource.getContents(), Diagram.class)) {

			DawnDiagramUpdater.initializeElement(next);
		}
	}

	public CDOView getCDOView() {
		CDOViewSet viewSet = CDOUtil.getViewSet(this);
		CDOView[] views = (viewSet == null) ? null : viewSet.getViews();

		return ((views != null) && (views.length > 0)) ? views[0] : null;
	}

	@Override
	public void createModels(URI newURI) {
		initTransaction(newURI);
		super.createModels(newURI);
	}

	@Override
	public void loadModels(URI uri) throws ModelMultiException {

		initTransaction(uri);
		super.loadModels(uri);

		// Did any of the models create a new resource? (the DiModel and/or HistoryModel may have done)
		// If so, commit them now so that they don't dangle if we later close the editor without saving.
		out: for(CDOResource next : Iterables.filter(getResources(), CDOResource.class)) {
			switch(next.cdoState()) {
			case NEW:
			case DIRTY:
				try {
					((CDOTransaction)getCDOView()).commit(new NullProgressMonitor());
				} catch (CommitException e) {
					Activator.log.error("Commit implicitly created resources failed.", e); //$NON-NLS-1$
				}
				break out;
			default:
				// Pass
				break;
			}
		}
	}

	protected void initTransaction(URI uri) {
		if(getCDOView() == null) {
			// get the repository and start a transaction on it

			if(repository == null) {
				repository = repositoryManager.getRepositoryForURI(uri);
			}

			if(repository != null) {
				repository.createTransaction(this);
				CDOView view = getCDOView();
				if(view != null) {
					view.addListener(getInvalidationListener());
				}
			}
		}
	}

	@Override
	public void unload() {
		try {
			super.unload();
		} finally {
			if((repository != null) && (getCDOView() != null)) {
				CDOView view = getCDOView();
				if(view != null) {
					view.removeListener(getInvalidationListener());
				}
				invalidationListener = null;

				// dispose the transaction
				repository.close(this);

				// now, we can remove the CDOViewSet adapter
				eAdapters().clear();
			}

			repository = null;
		}
	}

	protected final IListener getInvalidationListener() {
		if(invalidationListener == null) {
			invalidationListener = createInvalidationListener();
		}
		return invalidationListener;
	}

	protected IListener createInvalidationListener() {
		return new IListener() {

			@Override
			public void notifyEvent(IEvent event) {
				if(event instanceof CDOViewInvalidationEvent) {
					TransactionalEditingDomain domain = getTransactionalEditingDomain();
					if(domain instanceof CDOAwareTransactionalEditingDomain) {
						((CDOAwareTransactionalEditingDomain)domain).fireResourceSetChanged((CDOViewInvalidationEvent)event);
					}
				}
			}
		};
	}

	@Override
	public boolean isUserModelResource(URI uri) {
		return super.isUserModelResource(uri) || CDOUtils.isCDOURI(uri);
	}

	@Override
	public EList<Adapter> eAdapters() {
		if(eAdapters == null) {
			eAdapters = new EAdapterList<Adapter>(this) {

				private static final long serialVersionUID = 1L;

				@Override
				public Adapter remove(int index) {
					Adapter toRemove = primitiveGet(index);
					if((toRemove instanceof CDOViewSet) && !canDisconnectCDOViewSet()) {
						// don't allow its removal if my view is still open!
						// (Papyrus attempts to clear the resource set's adapters when disposing a ModelSet)
						return null;
					}

					return super.remove(index);
				}

				@Override
				public void clear() {
					if(!canDisconnectCDOViewSet()) {
						// we can remove everything but the view-set adapter
						Adapter viewSetAdapter = getViewSetAdapter();
						if(viewSetAdapter != null) {
							retainAll(Collections.singleton(viewSetAdapter));
						} else {
							super.clear();
						}
					} else {
						super.clear();
					}
				}

				private Adapter getViewSetAdapter() {
					return Iterables.find(this, Predicates.instanceOf(CDOViewSet.class), null);
				}
			};
		}

		return eAdapters;
	}

	private boolean canDisconnectCDOViewSet() {
		CDOView view = getCDOView();
		return ((view == null) || view.isClosed()) && getResources().isEmpty();
	}

	boolean isDirty(Resource resource) {
		return (resource instanceof CDOResource) && DIRTY_STATES.contains(((CDOResource)resource).cdoState());
	}

	@Override
	protected void handleResourcesToDelete() {
		final int initialCount = getResourcesToDeleteOnSave().size();

		super.handleResourcesToDelete();

		// any changes made by resource deletions?
		CDOView view = getCDOView();
		if((view instanceof CDOTransaction) && (getResourcesToDeleteOnSave().size() < initialCount)) {
			try {
				((CDOTransaction)view).commit();
			} catch (CommitException e) {
				Activator.log.error("Failed to commit resource deletions.", e); //$NON-NLS-1$
			}
		}
	}

	@Override
	protected boolean validateDeleteResource(URI uri) {
		boolean result = true;

		Resource resource = getResource(uri, false);

		// if it was meant to be deleted, an attempt would have been made to remove it.  That may
		// have been prevented if it was dirty.  If it isn't now, then delete it.  Otherwise,
		// block again
		if((resource != null) && isDirty(resource)) {
			result = false;
			Activator.log.warn("Attempt to delete a dirty CDO resource: " + uri); //$NON-NLS-1$
		}

		return result;
	}

	@Override
	protected boolean deleteResource(URI uri) {
		Resource res = getResource(uri, false);
		boolean result = res instanceof CDOResource;

		if(!result) {
			// not a CDO resource.  Default behaviour
			result = super.deleteResource(uri);
		} else {
			try {
				res.delete(null);
				if(res.getResourceSet() != null) {
					res.unload();
					res.getResourceSet().getResources().remove(res);
				}
			} catch (IOException e) {
				Activator.log.error(e);
			}
		}

		return result;
	}

	@Override
	public void save(IProgressMonitor monitor) throws IOException {
		CDOView view = getCDOView();
		CDOTransaction transaction = null;

		Collection<CDOObject> updates;
		if((view instanceof CDOTransaction) && view.isDirty()) {
			// collect updated objects to post-process for cross-unit references
			transaction = (CDOTransaction)view;
			updates = ImmutableList.<CDOObject> builder() //
			.addAll(transaction.getNewObjects().values()) //
			.addAll(transaction.getDirtyObjects().values()) //
			.build();
		} else {
			updates = Collections.emptyList();
		}

		SubMonitor sub = SubMonitor.convert(monitor, updates.isEmpty() ? 1 : 2);

		super.save(sub.newChild(1));

		if(!updates.isEmpty()) {
			CDOControlModeParticipant control = new CDOControlModeParticipant();
			CDOControlModeParticipant.IUpdate run = CDOControlModeParticipant.IUpdate.EMPTY;

			for(CDOObject next : updates) {
				EObject object = CDOUtil.getEObject(next);
				if(object != null) {
					for(EReference xref : object.eClass().getEAllReferences()) {
						// do include containment references because we may have added a model
						// element and controlled it in the same transaction
						if(xref.isChangeable() && !xref.isDerived() && !xref.isTransient()) {
							run = run.chain(control.getProxyCrossReferencesUpdate(object, xref));
						}
					}
				}
			}

			if(!run.isEmpty()) {
				run.apply();

				try {
					transaction.commit(sub.newChild(1));
				} catch (CommitException e) {
					Activator.log.error("Follow-up commit after save failed.", e); //$NON-NLS-1$
				}
			} else {
				sub.done();
			}
		}
	}

	//
	// Nested types
	//

	/**
	 * CDO doesn't permit resources to be removed from the resource set if they are {@linkplain CDOState#DIRTY dirty}, so this specialized list
	 * prevents that.
	 */
	private class SafeResourceList extends ResourcesEList<Resource> {

		private static final long serialVersionUID = 1L;

		@Override
		public boolean remove(Object object) {
			boolean result = !(object instanceof CDOResource) || !isDirty((CDOResource)object);

			if(result) {
				result = super.remove(object);
			}

			return result;
		}
	}
}
