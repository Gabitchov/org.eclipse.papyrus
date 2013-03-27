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
package org.eclipse.papyrus.cdo.internal.ui.markers;

import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.cdo.validation.problems.EProblem;
import org.eclipse.papyrus.cdo.validation.problems.edit.ProblemEditUtil;
import org.eclipse.papyrus.cdo.validation.problems.util.ProblemsManager;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;
import org.eclipse.papyrus.infra.services.markerlistener.providers.AbstractMarkerProvider;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

/**
 * This is the CDOMarkerProvider type. Enjoy.
 */
public class CDOMarkerProvider extends AbstractMarkerProvider {

	private final ProblemEditUtil defaultUtil = new ProblemEditUtil(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	public CDOMarkerProvider() {
		super();
	}

	public boolean canProvideMarkersFor(Resource resource) {
		return resource instanceof CDOResource;
	}

	public Collection<? extends IPapyrusMarker> getMarkers(final Resource resource, String type, boolean includeSubtypes) throws CoreException {

		// run in a read-only transaction because the problems manager accesses
		// a cross-reference adapter
		return run(resource, CoreException.class, new RunnableWithResult.Impl<Collection<? extends IPapyrusMarker>>() {

			public void run() {
				setResult(Lists.newArrayList(Iterators.transform(getProblemsManager(resource).getAllProblems(resource), CDOPapyrusMarker.wrap(getProblemEditUtil(resource)))));
			}
		});
	}

	@Override
	public void createMarkers(final Resource resource, final Diagnostic diagnostic, final IProgressMonitor monitor) throws CoreException {

		// run in a read-only transaction because the problems manager accesses
		// a cross-reference adapter. Note that a read/write transaction is not
		// needed because we aren't modifying the contents of the resource set
		// (the problems model is not stored in a resource)
		run(resource, CoreException.class, new Runnable() {

			public void run() {
				try {
					basicCreateMarkers(resource, diagnostic, monitor);
				} catch (CoreException e) {
					throw new WrappedException(e);
				}
			}
		});
	}

	final void basicCreateMarkers(Resource resource, Diagnostic diagnostic, IProgressMonitor monitor) throws CoreException {

		super.createMarkers(resource, diagnostic, monitor);
	}

	@Override
	protected void doCreateMarker(Resource resource, Diagnostic diagnostic) throws CoreException {

		ProblemsManager mgr = getProblemsManager(resource);
		EProblem problem = mgr.createProblem(diagnostic);
		if(problem != null) {
			mgr.addProblem(problem);
		}
	}

	@Override
	protected void batchCreated(Resource resource) {
		super.batchCreated(resource);

		ResourceSet rset = resource.getResourceSet();
		if(rset instanceof ModelSet) {
			// yield the resource set to any other threads that might
			// be waiting to read it
			((ModelSet)rset).getTransactionalEditingDomain().yield();
		}
	}

	@Override
	public void deleteMarkers(final EObject object, final IProgressMonitor monitor) throws CoreException {

		// run in a read-only transaction because the problems manager accesses
		// a cross-reference adapter. Note that a read/write transaction is not
		// needed because we aren't modifying the contents of the resource set
		// (the problems model is not stored in a resource)
		run(object.eResource(), CoreException.class, new Runnable() {

			public void run() {
				try {
					basicDeleteMarkers(object, monitor);
				} catch (CoreException e) {
					throw new WrappedException(e);
				}
			}
		});
	}

	protected final void basicDeleteMarkers(EObject object, IProgressMonitor monitor) throws CoreException {

		super.deleteMarkers(object, monitor);
	}

	public void deleteMarkers(final Resource resource, IProgressMonitor monitor) {
		try {
			this.deleteMarkers(resource, monitor, null, true);
		} catch (CoreException e) {
			Activator.log.error(e);
		}
	}

	public void deleteMarkers(final Resource resource, IProgressMonitor monitor, String markerType, boolean includeSubtypes) throws CoreException {
		// FIXME This code has been copied from Deprecated deleteMarkers above. Need to check if some changes are required.
		SubMonitor sub = SubMonitor.convert(monitor, IProgressMonitor.UNKNOWN);

		// run in a read-only transaction because the problems manager accesses
		// a cross-reference adapter. Note that a read/write transaction is not
		// needed because we aren't modifying the contents of the resource set
		// (the problems model is not stored in a resource)
		run(resource, new Runnable() {

			public void run() {
				getProblemsManager(resource).purgeProblems(resource);
			}
		});

		sub.done();
	}

	private ProblemsManager getProblemsManager(Resource resource) {
		return ProblemsManager.getProblemsManager(resource.getResourceSet());
	}

	private ProblemEditUtil getProblemEditUtil(Resource resource) {
		ProblemEditUtil result = defaultUtil;

		ResourceSet rset = resource.getResourceSet();
		if(rset instanceof ModelSet) {
			AdapterFactory factory = ((AdapterFactoryEditingDomain)((ModelSet)rset).getTransactionalEditingDomain()).getAdapterFactory();
			result = new ProblemEditUtil(factory);
		}

		return result;
	}

	static <X extends Throwable> void run(Resource context, Runnable runnable) {
		run(context, RuntimeException.class, runnable);
	}

	static <X extends Throwable> void run(Resource context, Class<X> exceptionType, Runnable runnable) throws X {

		ResourceSet rset = context.getResourceSet();
		if(rset instanceof ModelSet) {
			try {
				((ModelSet)rset).getTransactionalEditingDomain().runExclusive(runnable);
			} catch (WrappedException e) {
				throw exceptionType.cast(e.exception());
			} catch (InterruptedException e) {
				Activator.log.error("CDO problem markers runnable interrupted.", e); //$NON-NLS-1$
			}
		} else {
			runnable.run();
		}
	}

	static <T, X extends Throwable> T run(Resource context, Class<X> exceptionType, RunnableWithResult<T> runnable) throws X {

		T result;

		ResourceSet rset = context.getResourceSet();
		if(rset instanceof ModelSet) {
			try {
				result = TransactionUtil.runExclusive(((ModelSet)rset).getTransactionalEditingDomain(), runnable);
			} catch (WrappedException e) {
				throw exceptionType.cast(e.exception());
			} catch (InterruptedException e) {
				Activator.log.error("CDO problem markers runnable interrupted.", e); //$NON-NLS-1$
				result = null;
			}
		} else {
			runnable.run();
			result = runnable.getResult();
		}

		return result;
	}

}
