/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.sequence.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.diagram.common.providers.UIAdapterImpl;

public class Notifier {

	private UIAdapterImpl modelListener;

	public Notifier(UIAdapterImpl modelListener) {
		this.modelListener = modelListener;
	}

	/**
	 * Add listener on a EObject
	 * 
	 * @param eObject
	 *            The object to listen
	 */
	public void listenEObject(EObject eObject) {
		// Only listen the object if it isn't yet listened
		if (eObject != null && !eObject.eAdapters().contains(modelListener)) {
			eObject.eAdapters().add(modelListener);
		}
	}

	/**
	 * Remove listener on a EObject
	 * 
	 * @param eObject
	 *            The object to unlisten
	 */
	public void unlistenEObject(EObject eObject) {
		// Only listen the object if it isn't yet listened
		if (eObject != null && eObject.eAdapters().contains(modelListener)) {
			eObject.eAdapters().remove(modelListener);
		}
	}

}
