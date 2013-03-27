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
package org.eclipse.papyrus.infra.services.markerlistener.providers;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;
import org.eclipse.swt.widgets.Display;

/**
 * This is the AbstractMarkerProvider type. Enjoy.
 */
public abstract class AbstractMarkerProvider
		implements IMarkerProvider {

	/**
	 * show progress all n marker deletions
	 */
	public static int DELETE_PMARKER_INTERVAL = 50;

	/**
	 * show progress all n marker creations
	 */
	public static int CREATE_PMARKER_INTERVAL = 20;

	public AbstractMarkerProvider() {
		super();
	}

	public void createMarkers(Resource resource, Diagnostic diagnostic,
			IProgressMonitor monitor)
			throws CoreException {

		List<Diagnostic> children = diagnostic.getChildren();

		SubMonitor sub = SubMonitor.convert(monitor, children.size()
			/ CREATE_PMARKER_INTERVAL);
		CoreException exception = null;

		int i = 0;
		for (Diagnostic next : children) {
			try {
				doCreateMarker(resource, next);
			} catch (CoreException e) {
				if (exception == null) {
					exception = e;
				}
			}
			
			if (i++ > CREATE_PMARKER_INTERVAL) {
				i = 0;
				sub.worked(1);
				batchCreated(resource);
			}
		}

		sub.done();

		if (exception != null) {
			throw exception;
		}
	}

	/**
	 * Creates a single marker for the specified {@code diagnostic}. This method
	 * should not iterate the children of the {@code diagnostic}.
	 * 
	 * @param resource
	 *            the resource on which to create a marker
	 * @param diagnostic
	 *            the diagnostic describing the marker to create
	 * 
	 * @throws CoreException
	 *             on failure to create the marker
	 */
	protected abstract void doCreateMarker(Resource resource,
			Diagnostic diagnostic)
			throws CoreException;

	/**
	 * Notifies that a batch of markers has been created. This is an opportunity
	 * to update user interfaces, let other threads complete some work, etc.
	 * Subclasses should extend this method by calling {@code super}.
	 * 
	 * @param resource
	 *            the resource on which a batch of markers was created
	 */
	protected void batchCreated(Resource resource) {
		Display display = Display.getCurrent();
		if (display != null) {
			// process pending display events
			while (display.readAndDispatch());
		}
	}

	@Deprecated
	public void deleteMarkers(EObject eObject, IProgressMonitor monitor)
			throws CoreException {
		this.deleteMarkers(eObject, monitor, null, true) ;
	}

	
	public void deleteMarkers(EObject eObject, IProgressMonitor monitor, String markerType, boolean includeSubtypes)
			throws CoreException {

		Resource resource = eObject.eResource();
		Collection<? extends IPapyrusMarker> markers = getMarkers(resource,
				markerType, includeSubtypes);

		SubMonitor sub = SubMonitor.convert(monitor, markers.size()
			/ DELETE_PMARKER_INTERVAL);
		CoreException exception = null;

		int i = 0;
		for (IPapyrusMarker marker : markers) {
			if (isContainedBy(marker.getEObject(), eObject)) {
				if (monitor.isCanceled()) {
					break;
				}

				try {
					marker.delete();
				} catch (CoreException e) {
					if (exception == null) {
						exception = e;
					}
				}
			}

			if (i++ > DELETE_PMARKER_INTERVAL) {
				i = 0;
				sub.worked(1);
			}
		}

		sub.done();

		if (exception != null) {
			throw exception;
		}
	}
	
	private boolean isContainedBy(EObject subEObj, EObject eObj) {
		if (eObj == subEObj)
			return true;
		else if (subEObj != null) {
			return isContainedBy(subEObj.eContainer(), eObj);
		}
		// reached, if subEObj == null
		return false;
	}
}
