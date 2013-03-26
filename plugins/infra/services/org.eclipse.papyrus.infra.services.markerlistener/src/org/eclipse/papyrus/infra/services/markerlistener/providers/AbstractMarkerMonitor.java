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

import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.services.markerlistener.Activator;
import org.eclipse.papyrus.infra.services.markerlistener.IMarkerEventListener;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;
import org.eclipse.swt.widgets.Display;

/**
 * This is the AbstractMarkerMonitor type. Enjoy.
 */
public abstract class AbstractMarkerMonitor
		implements IMarkerMonitor {

	private ModelSet modelSet;

	private final CopyOnWriteArrayList<IMarkerEventListener> listeners = new CopyOnWriteArrayList<IMarkerEventListener>();

	public AbstractMarkerMonitor() {
		super();
	}

	public void initialize(ModelSet modelSet) {
		this.modelSet = modelSet;
	}

	protected final ModelSet getModelSet() {
		return modelSet;
	}

	public void dispose() {
		listeners.clear();
		modelSet = null;
	}

	protected void fireMarkerAdded(final IPapyrusMarker marker) {
		if (this.listeners != null) {
			Display.getDefault().syncExec(new Runnable() {
				public void run() {
					for (IMarkerEventListener listener : AbstractMarkerMonitor.this.listeners) {
						try {
							listener.notifyMarkerChange(marker.getEObject(), marker,
								IMarkerEventListener.MARKER_ADDED);
						} catch (Exception e) {
							Activator.log.error(
								"Uncaught exception in marker listener.", e);
						}
					}
				}
			}) ;
		}
	}

	protected void fireMarkerRemoved(final IPapyrusMarker marker) {
		if (this.listeners != null) {
			Display.getDefault().syncExec(new Runnable() {
				public void run() {
					for (IMarkerEventListener listener : AbstractMarkerMonitor.this.listeners) {
						try {
							listener.notifyMarkerChange(marker.getEObject(), marker,
								IMarkerEventListener.MARKER_REMOVED);
						} catch (Exception e) {
							Activator.log.error(
								"Uncaught exception in marker listener.", e);
						}
					}
				}
			}) ;
		}
	}

	public void addMarkerEventListener(IMarkerEventListener listener) {
		listeners.addIfAbsent(listener);
	}

	public void removeMarkerEventListener(IMarkerEventListener listener) {
		listeners.remove(listener);
	}
}
