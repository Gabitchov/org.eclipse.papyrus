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
package org.eclipse.papyrus.infra.services.markerlistener;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.services.markerlistener.util.MarkerListenerUtils;

/**
 * This is the PapyrusMarkerAdapter type. Enjoy.
 */
public class PapyrusMarkerAdapter
implements IPapyrusMarker {

	private final Resource resource;

	private final IMarker marker;

	@SuppressWarnings("rawtypes")
	private final Map attributes ;

	protected PapyrusMarkerAdapter(Resource resource, IMarker marker) {
		super();

		this.resource = resource;
		this.marker = marker;
		this.attributes = null ;
	}

	protected PapyrusMarkerAdapter(Resource resource, IMarker marker, @SuppressWarnings("rawtypes") Map attributes) {
		super();

		this.resource = resource;
		this.marker = marker;
		this.attributes = attributes ;
	}

	public static final PapyrusMarkerAdapter wrap(Resource resource,
			IMarker marker) {

		return new PapyrusMarkerAdapter(resource, marker);
	}

	public static final PapyrusMarkerAdapter wrap(Resource resource,
			IMarker marker, @SuppressWarnings("rawtypes") Map attributes) {

		return new PapyrusMarkerAdapter(resource, marker, attributes);
	}

	public static final List<PapyrusMarkerAdapter> wrap(Resource resource,
			Collection<? extends IMarker> markers) {

		List<PapyrusMarkerAdapter> result = new java.util.ArrayList<PapyrusMarkerAdapter>(
				markers.size());

		for (IMarker next : markers) {
			result.add(wrap(resource, next));
		}

		return result;
	}

	public final IMarker getMarker() {
		return marker;
	}

	public Resource getResource() {
		return resource;
	}

	public EObject getEObject() {
		EObject result = null;

		String uriAttribute = null ;
		if (this.attributes != null) { // attributes is not null when the PapyrusMarkerAdapter has been wrapped from WorkspaceMarkerMonitor.handleMarkerDeleted
			uriAttribute = (String)attributes.get(EValidator.URI_ATTRIBUTE) ;
		}
		else {
			uriAttribute = marker.getAttribute(EValidator.URI_ATTRIBUTE,
					(String) null);
		}
		if (uriAttribute != null) {
			URI uri = URI.createURI(uriAttribute);
			if (getResource().getURI().equals(uri.trimFragment())) {
				result = getResource().getEObject(uri.fragment());
			}
		}

		return result;
	}

	public boolean exists() {
		return marker.exists();
	}

	public String getType()
			throws CoreException {
		return marker.getType();
	}

	public String getTypeLabel()
			throws CoreException {

		return MarkerListenerUtils.getMarkerTypeLabel(getType());
	}

	public void delete()
			throws CoreException {

		marker.delete();
	}

	public Object getAttribute(String name)
			throws CoreException {

		return marker.getAttribute(name);
	}

	public String getAttribute(String name, String defaultValue) {
		return marker.getAttribute(name, defaultValue);
	}

	public boolean getAttribute(String name, boolean defaultValue) {
		return marker.getAttribute(name, defaultValue);
	}

	public int getAttribute(String name, int defaultValue) {
		return marker.getAttribute(name, defaultValue);
	}

	public Map<String, ?> getAttributes()
			throws CoreException {

		return marker.getAttributes();
	}

	public void setAttribute(String name, Object value)
			throws CoreException {

		marker.setAttribute(name, value);
	}

	public void setAttribute(String name, String value)
			throws CoreException {

		marker.setAttribute(name, value);
	}

	public void setAttribute(String name, boolean value)
			throws CoreException {

		marker.setAttribute(name, value);
	}

	public void setAttribute(String name, int value)
			throws CoreException {

		marker.setAttribute(name, value);
	}

	public void setAttributes(Map<String, ?> attributes)
			throws CoreException {

		marker.setAttributes(attributes);
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof PapyrusMarkerAdapter)
				&& marker.equals(((PapyrusMarkerAdapter) obj).marker);
	}

	@Override
	public int hashCode() {
		return marker.hashCode();
	}

	@Override
	public String toString() {
		return String.format("WorkspaceMarker:%s:%s", marker.getResource(),
				marker.getId());
	}
}
