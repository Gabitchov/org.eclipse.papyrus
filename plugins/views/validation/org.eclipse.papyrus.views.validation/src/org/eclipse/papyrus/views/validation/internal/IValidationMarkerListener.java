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

import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;

/**
 * This is the IValidationMarkerListener type. Enjoy.
 */
public interface IValidationMarkerListener {

	void notifyMarkerChange(IPapyrusMarker marker, MarkerChangeKind kind);

	enum MarkerChangeKind {
		ADDED, REMOVED;
	}
}
