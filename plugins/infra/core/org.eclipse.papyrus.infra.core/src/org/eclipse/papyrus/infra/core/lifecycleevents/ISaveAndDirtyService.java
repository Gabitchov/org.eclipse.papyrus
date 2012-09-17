/*****************************************************************************
 * Copyright (c) 2010 LIFL & CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin (LIFL) cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.lifecycleevents;

import org.eclipse.ui.ISaveablePart;

/**
 * @author dumoulin
 * 
 */
public interface ISaveAndDirtyService extends ISaveablePart {

	/**
	 * Register a nested {@link ISaveablePart} as a listener that will be
	 * notified each time a {@link #doSave(IProgressMonitor)} or {@link #doSaveAs()} is performed. Also, it will be asked for the
	 * dirtyState.
	 * 
	 * @param saveablePart
	 */
	public abstract void registerIsaveablePart(ISaveablePart saveablePart);

	/**
	 * Remove the specified {@link ISaveablePart} from the list of listeners.
	 * 
	 * @param saveablePart
	 */
	public abstract void removeIsaveablePart(ISaveablePart saveablePart);

	/**
	 * Add a listeners on input changed event.
	 * 
	 * @param inputChangedListener
	 */
	public void addInputChangedListener(IEditorInputChangedListener inputChangedListener);

	/**
	 * Remove a listeners on input changed event.
	 * 
	 * @param inputChangedListener
	 */
	public void removeInputChangedListener(IEditorInputChangedListener inputChangedListener);

}
