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
package org.eclipse.papyrus.views.validation.internal;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.services.markerlistener.IMarkerEventListener;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;
import org.eclipse.papyrus.views.validation.internal.IValidationMarkerListener.MarkerChangeKind;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * This is the ValidationMarkersService type. Enjoy.
 */
public class ValidationMarkersService
		implements IMarkerEventListener {

	private ModelSet modelSet;

	private final Multimap<EObject, IPapyrusMarker> markers = HashMultimap
		.create();

	private final CopyOnWriteArrayList<IValidationMarkerListener> listeners = new CopyOnWriteArrayList<IValidationMarkerListener>();

	public ValidationMarkersService() {
		super();
	}

	public void init(ServicesRegistry services)
			throws ServiceException {

		modelSet = ServiceUtils.getInstance().getModelSet(services);
	}

	public void startService()
			throws ServiceException {

		// pass
	}

	public void disposeService()
			throws ServiceException {

		markers.clear();
		modelSet = null;
	}

	public boolean isNotifiedOnInitialMarkerCheck() {
		return true;
	}

	public void notifyMarkerChange(EObject eObjectOfMarker,
			IPapyrusMarker marker, int addedOrRemoved) {

		MarkerChangeKind kind = (addedOrRemoved == MARKER_ADDED)
			? MarkerChangeKind.ADDED
			: MarkerChangeKind.REMOVED;

		switch (kind) {
			case ADDED :
				markers.put(eObjectOfMarker, marker);
				break;
			case REMOVED :
				// workspace markers don't know their EObjects, so we can't look
				// up the mapping to remove by key
				markers.values().remove(marker);
				break;
		}

		for (IValidationMarkerListener next : listeners) {
			try {
				next.notifyMarkerChange(marker, kind);
			} catch (Exception e) {
				Activator.log.error(
					"Uncaught exception in validation marker listener.", e);
			}
		}
	}

	public ModelSet getModelSet() {
		return modelSet;
	}

	public Collection<IPapyrusMarker> getMarkers() {
		return markers.values();
	}

	public Collection<IPapyrusMarker> getMarkers(EObject object) {
		return markers.get(object);
	}

	public void addValidationMarkerListener(IValidationMarkerListener listener) {
		listeners.addIfAbsent(listener);
	}

	public void removeValidationMarkerListener(
			IValidationMarkerListener listener) {

		listeners.remove(listener);
	}
}
