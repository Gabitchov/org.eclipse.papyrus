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
package org.eclipse.papyrus.cdo.internal.ui.views;

import static org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel.DI_FILE_EXTENSION;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.view.CDOQuery;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.cdo.view.CDOViewInvalidationEvent;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.net4j.util.lifecycle.ILifecycleEvent;
import org.eclipse.net4j.util.lifecycle.ILifecycleEvent.Kind;
import org.eclipse.papyrus.cdo.core.util.JobWaiter;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.cdo.internal.ui.l10n.Messages;
import org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashModel;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Display;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;

/**
 * A persistent query for DI resources in some CDO view. Server-side queries are
 * run in the background to efficiently find all {@link CDOResource}s that
 * contain DI {@link SashModel}s. The results of the query are asynchronously
 * published to the UI to refresh the tree viewer.
 */
public class DIResourceQuery {

	private static final Map<CDOView, DIResourceQuery> instances = Maps.newHashMap();

	private final StructuredViewer viewer;

	private final CDOQuery query;

	private final Job queryJob = new QueryJob();

	private final IListener cdoViewListener = createCDOViewListener();

	private AtomicReference<Set<CDOResource>> diResources = new AtomicReference<Set<CDOResource>>(Collections.<CDOResource> emptySet());

	private DIResourceQuery(StructuredViewer viewer, CDOView view) {
		super();

		this.viewer = viewer;
		this.query = view.createQuery("ocl", //$NON-NLS-1$
			"SashWindowsMngr.allInstances()->collect(oclAsType(ecore::EObject).eResource())", //$NON-NLS-1$
			DiPackage.Literals.SASH_MODEL);

		view.addListener(cdoViewListener);
		viewer.getControl().addDisposeListener(createViewerDisposeListener());

		runQuery();
	}

	public static DIResourceQuery initialize(StructuredViewer viewer, CDOView view) {

		DIResourceQuery result;

		synchronized(instances) {
			result = instances.get(view);
			if(result == null) {
				result = new DIResourceQuery(viewer, view);
				instances.put(view, result);
			}
		}

		return result;
	}

	/**
	 * Wait for the current in-progress query on the specified {@code view} to finish, if any.
	 * 
	 * @param view
	 *        a view which we are or may be querying for DI resources
	 * @param timeout
	 *        a positive timeout
	 * @param unit
	 *        the time unit for the {@code timeout}
	 * 
	 * @return {@code true} on successful wait (if required); {@code false} on time-out
	 * 
	 * @throws InterruptedException
	 *         if the wait is interrupted
	 */
	public static boolean waitFor(CDOView view, long timeout, TimeUnit unit) throws InterruptedException {
		if(timeout <= 0) {
			throw new IllegalArgumentException("Non-positive timeout"); //$NON-NLS-1$
		}

		boolean result;

		DIResourceQuery query;

		synchronized(instances) {
			query = instances.get(view);
		}

		if(query == null) {
			// have nothing to wait for
			result = true;
		} else {
			result = JobWaiter.waitFor(query, timeout, unit);
		}

		return result;
	}

	public static Set<CDOResource> getDIResources(CDOView view) {
		DIResourceQuery query;

		synchronized(instances) {
			query = instances.get(view);
		}

		Set<CDOResource> result;
		if(query == null) {
			result = Collections.emptySet();
		} else {
			result = query.getDIResources();
		}

		return result;
	}

	public static boolean isUnaffiliatedResource(CDOResource resource) {
		return getAffiliateResource(resource) == null;
	}

	public static CDOResource getAffiliateResource(CDOResource resource) {
		CDOResource result = null;

		URI uri = resource.getURI();
		if(DI_FILE_EXTENSION.equals(uri.fileExtension())) {
			// it *is* a DI resource
			result = resource;
		} else {
			uri = uri.trimFileExtension().appendFileExtension(DI_FILE_EXTENSION);

			for(CDOResource next : getDIResources(resource.cdoView())) {
				if(uri.equals(next.getURI())) {
					result = next;
					break;
				}
			}
		}

		return result;
	}

	public Set<CDOResource> getDIResources() {
		return diResources.get();
	}

	private void runQuery() {
		// we cannot query for EClasses that the server doesn't know about. And,
		// if it doesn't know about an EClass, then a priori, none of its
		// instances exist, so we don't need to run the query
		if(query.getView().getSession().getPackageRegistry().getPackageInfo(DiPackage.eINSTANCE) != null) {
			queryJob.schedule();
		}
	}

	void refresh() {
		viewer.refresh();
	}

	private void dispose() {
		synchronized(instances) {
			CDOView view = query.getView();
			view.removeListener(cdoViewListener);
			instances.remove(view);
		}
	}

	private IListener createCDOViewListener() {
		return new IListener() {

			@Override
			public void notifyEvent(IEvent event) {
				if(event instanceof ILifecycleEvent) {
					ILifecycleEvent lifecycleEvent = (ILifecycleEvent)event;
					if(lifecycleEvent.getKind() == Kind.DEACTIVATED) {
						dispose();
					}
				} else if(event instanceof CDOViewInvalidationEvent) {
					// if my view is invalidated, then some folder or resource
					// that I am showing has changed. Run the query again and
					// update asynchronously
					runQuery();
				}
			}
		};
	}

	private DisposeListener createViewerDisposeListener() {
		return new DisposeListener() {

			@Override
			public void widgetDisposed(DisposeEvent e) {
				dispose();
			}
		};
	}

	//
	// Nested types
	//

	private class QueryJob extends Job {

		QueryJob() {
			super(Messages.DIResourceQuery_2);

			setSystem(true);
		}

		@Override
		public boolean belongsTo(Object family) {
			return family == DIResourceQuery.this;
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			ImmutableSet.Builder<CDOResource> resultBuilder = ImmutableSet.builder();
			List<CDOResource> rawResult = query.getResult(CDOResource.class);

			// don't use an iterator because it won't be able to advance
			// past a resource proxy that cannot be resolved
			for(int i = 0; i < rawResult.size(); i++) {
				try {
					CDOResource next = rawResult.get(i);
					if(isContained(next)) {
						resultBuilder.add(next);
					}
				} catch (Exception e) {
					// can get "node not found" exceptions on incompletely
					// deleted resources
					Activator.log.error("Error retrieving resource result from CDO query.", e); //$NON-NLS-1$
				}
			}
			Set<CDOResource> result = resultBuilder.build();

			diResources.set(ImmutableSet.copyOf(result));

			if((viewer != null) && (viewer.getControl() != null)) {
				Display display = viewer.getControl().getDisplay();
				if(display != null) {
					display.asyncExec(new Runnable() {

						@Override
						public void run() {
							if((viewer != null) && (viewer.getControl() != null) && !viewer.getControl().isDisposed()) {
								refresh();
							}
						}
					});
				}
			}

			return Status.OK_STATUS;
		}

		private boolean isContained(CDOResource resource) {
			// determines whether a resource is properly contained in the view's
			// node hierarchy
			boolean result = false;

			CDOResourceFolder folder = resource.getFolder();
			if(folder != null) {
				// if we don't have read permission on the folder, then we shouldn't attempt to show any contents
				if(folder.cdoPermission().isReadable()) {
					result = folder.getNodes().contains(resource);
				}
			} else {
				CDOResource root = resource.cdoResource();
				if((root != null) && root.isRoot()) {
					result = root.getContents().contains(resource);
				}
			}

			return result;
		}
	}
}
