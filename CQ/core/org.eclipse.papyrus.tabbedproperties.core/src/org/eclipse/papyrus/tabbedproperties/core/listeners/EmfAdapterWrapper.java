/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.tabbedproperties.core.listeners;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

/**
 * A wrapper implementing the bases for EMF Adapter. Subclasses should implements notifiedChanged.
 * 
 * @author dumoulin
 * 
 */
public abstract class EmfAdapterWrapper implements Adapter {

	Notifier target;

	public Notifier getTarget() {
		return target;
	}

	public boolean isAdapterForType(Object type) {
		// just use as a listener
		return false;
	}

	public void setTarget(Notifier newTarget) {
		target = newTarget;
	}

}