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
package org.eclipse.papyrus.views.validation.internal.providers;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;
import org.eclipse.papyrus.views.validation.internal.Activator;

/**
 * This is the TypeLabelProvider type. Enjoy.
 */
public class TypeLabelProvider
		extends ProblemLabelProvider {

	public TypeLabelProvider() {
		super();
	}

	@Override
	public String getText(Object element) {
		String result = null;

		if (element instanceof IPapyrusMarker) {
			IPapyrusMarker marker = (IPapyrusMarker) element;

			try {
				result = marker.getTypeLabel();
			} catch (CoreException e) {
				Activator.getDefault().getLog().log(e.getStatus());
			}
		}

		return result;
	}
}
