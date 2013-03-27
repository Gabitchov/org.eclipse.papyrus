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
import java.util.Collections;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;

/**
 * This is the IMarkerProvider type. Enjoy.
 */
public interface IMarkerProvider {

	IMarkerProvider NULL = new IMarkerProvider() {

		public boolean canProvideMarkersFor(Resource resource) {
			return false;
		}

		public Collection<? extends IPapyrusMarker> getMarkers(
				Resource resource, String type, boolean includeSubtypes) {
			
			return Collections.emptyList();
		}

		public void createMarkers(Resource resource, Diagnostic diagnostic,
				IProgressMonitor monitor) {
			// pass
		}

		@Deprecated
		public void deleteMarkers(EObject object, IProgressMonitor monitor) {
			// pass
		}

		@Deprecated
		public void deleteMarkers(Resource resource, IProgressMonitor monitor) {
			// pass
		}

		public void deleteMarkers(EObject object, IProgressMonitor monitor,
				String markerType, boolean includeSubtypes)
				throws CoreException {
			// pass
		}

		public void deleteMarkers(Resource resource, IProgressMonitor monitor,
				String markerType, boolean includeSubtypes)
				throws CoreException {
			// pass
		}
	};

	/**
	 * Queries whether the specified {@code resource} is one for which I know
	 * how to provide markers, regardless of whether it actually has any. This
	 * method should agree with the XML enablement expression in the
	 * contribution XML, if any.
	 * 
	 * @param resource
	 *            a resource
	 * 
	 * @return whether I recognize the {@code resource} as something I can
	 *         provide markers for
	 */
	boolean canProvideMarkersFor(Resource resource);

	/**
	 * Gets the markers of the specified {@code type} on a {@code resource}/
	 * 
	 * @param resource
	 *            a resource for which to get markers
	 * @param type
	 *            the marker type to request, or {@code null} to get all markers
	 *            of all types
	 * @param includeSubtypes
	 *            whether to get also markers of subtypes of the named
	 *            {@code type}; implied if the {@code type} is {@code null}
	 * 
	 * @return the markers, or an empty collection if none
	 * 
	 * @throws CoreException
	 *             on failure to get markers that I should be able to get
	 */
	Collection<? extends IPapyrusMarker> getMarkers(Resource resource,
			String type, boolean includeSubtypes)
			throws CoreException;

	/**
	 * Creates markers on the specified {@code resource} from a tree of
	 * diagnostics.
	 * 
	 * @param resource
	 *            a resource on which to create markers
	 * @param diagnostic
	 *            a tree of diagnostics for model elements in the
	 *            {@code resource}
	 * @param monitor
	 *            an optional monitor for reporting progress. May be
	 *            {@code null}
	 * 
	 * @throws CoreException
	 *             on failure to create any marker
	 */
	void createMarkers(Resource resource, Diagnostic diagnostic,
			IProgressMonitor monitor)
			throws CoreException;

	/**
	 * Deletes all of the markers attached to an {@code object} and its content
	 * tree.
	 * 
	 * @param object
	 *            a content tree from which to delete markers
	 * @param monitor
	 *            an optional monitor for reporting progress. May be
	 *            {@code null}
	 * 
	 * @throws CoreException
	 *             on failure to delete any marker
	 */
	@Deprecated
	void deleteMarkers(EObject object, IProgressMonitor monitor)
			throws CoreException;
	
	/**
	 * Deletes all of the markers attached to an {@code object} and its content
	 * tree. If {@code markerType} is specified, only markers of this type
	 * (including subtypes or not, as specified by {@code includeSubtypes})
	 * will be deleted.
	 * 
	 * @param object
	 *            a content tree from which to delete markers
	 * @param monitor
	 *            an optional monitor for reporting progress. May be
	 *            {@code null}
	 * @param markerType
	 * 			  an optional String representing the type of markers
	 * 			  to be deleted. May be {@code null}. If not specified,
	 * 			  all markers will be deleted.
	 * @param includeSubtypes
	 * 			  if markerType is specified, indicates whether 
	 * 			  subtypes must be deleted as well 
	 * 
	 * @throws CoreException
	 *             on failure to delete any marker
	 */
	void deleteMarkers(EObject object, IProgressMonitor monitor, String markerType, boolean includeSubtypes)
			throws CoreException;

	/**
	 * Deletes all of the markers attached to a {@code resource}.
	 * 
	 * @param resource
	 *            a resource from which to delete markers
	 * @param monitor
	 *            an optional monitor for reporting progress. May be
	 *            {@code null}
	 * 
	 * @throws CoreException
	 *             on failure to delete any marker
	 */
	@Deprecated
	void deleteMarkers(Resource resource, IProgressMonitor monitor)
			throws CoreException;
	
	/**
	 * Deletes all of the markers attached to a {@code resource}.
	 * If {@code markerType} is specified, only markers of this type
	 * (including subtypes or not, as specified by {@code includeSubtypes})
	 * will be deleted.
	 * 
	 * @param resource
	 *            a resource from which to delete markers
	 * @param monitor
	 *            an optional monitor for reporting progress. May be
	 *            {@code null}
	 * @param markerType
	 * 			  an optional String representing the type of markers
	 * 			  to be deleted. May be {@code null}. If not specified,
	 * 			  all markers will be deleted.
	 * @param includeSubtypes
	 * 			  if {@code markerType} is specified, indicates whether 
	 * 			  subtypes must be deleted as well.
	 * 
	 * @throws CoreException
	 *             on failure to delete any marker
	 */
	void deleteMarkers(Resource resource, IProgressMonitor monitor, String markerType, boolean includeSubtypes)
			throws CoreException;
}
