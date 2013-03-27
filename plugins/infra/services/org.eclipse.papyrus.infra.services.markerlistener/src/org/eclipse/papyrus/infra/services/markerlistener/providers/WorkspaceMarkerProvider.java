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

import static org.eclipse.papyrus.infra.services.markerlistener.util.MarkerListenerUtils.getFile;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;
import org.eclipse.papyrus.infra.services.markerlistener.PapyrusMarkerAdapter;
import org.eclipse.papyrus.infra.services.markerlistener.util.MarkerListenerUtils;


/**
 * This is the WorkspaceMarkerProvider type.  Enjoy.
 */
public class WorkspaceMarkerProvider
		extends AbstractMarkerProvider {

	public WorkspaceMarkerProvider() {
		super();
	}

	public boolean canProvideMarkersFor(Resource resource) {
		return getFile(resource) != null;
	}
	
	public Collection<? extends IPapyrusMarker> getMarkers(Resource resource,
			String type, boolean includeSubtypes)
			throws CoreException {
		
		IFile file = getFile(resource);
		
		if (file != null) {
			// TODO: quite inefficient, since requested for each element (could cache markers, already done
			// by findMarkers operation?) 
			IMarker[] markers = file.findMarkers(type, true, 0);
			return PapyrusMarkerAdapter.wrap(resource, Arrays.asList(markers));
		}
		
		return Collections.emptyList();
	}

	public void createMarkers(Resource resource, Diagnostic diagnostic) {
	}
	
	@Override
	protected void doCreateMarker(Resource resource, Diagnostic diagnostic)
			throws CoreException {
		
		if (MarkerListenerUtils.eclipseResourcesUtil != null) {
			MarkerListenerUtils.eclipseResourcesUtil.createMarkers(resource,
				diagnostic);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.services.markerlistener.providers.IMarkerProvider#deleteMarkers(org.eclipse.emf.ecore.resource.Resource, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Deprecated
	public void deleteMarkers(Resource resource, IProgressMonitor monitor) {
		try {
			this.deleteMarkers(resource, monitor, null, true) ;
		} catch (CoreException e) {
			Activator.log.error(e) ;
		}
	}

	public void deleteMarkers(Resource resource, IProgressMonitor monitor,
			String markerType, boolean includeSubtypes) throws CoreException {
		if (MarkerListenerUtils.eclipseResourcesUtil != null) {
			SubMonitor sub = SubMonitor.convert(monitor, IProgressMonitor.UNKNOWN);
			//FIXME Shall only delete markers of the given markerType 
			MarkerListenerUtils.eclipseResourcesUtil.deleteMarkers(resource);
			sub.done();
		}
	}
}
