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

import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.services.markerlistener.IMarkerEventListener;

/**
 * Interface for a pluggable marker monitor, which is reponsible for listening
 * for marker changes on a particular {@link ModelSet}'s resources and
 * broadcasting them to registered listeners.
 */
public interface IMarkerMonitor {

	void initialize(ModelSet modelSet);

	void dispose();

	void addMarkerEventListener(IMarkerEventListener listener);

	void removeMarkerEventListener(IMarkerEventListener listener);
}
