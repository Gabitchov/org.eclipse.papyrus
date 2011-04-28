/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.databinding;

import org.eclipse.core.databinding.observable.IObservable;

/**
 * An interface for Composite IObservables
 * 
 * @author Camille Letavernier
 */
public interface MultipleObservable extends IObservable {

	/**
	 * Adds an IObservable to this composite Observable
	 * 
	 * @param observable
	 *        The IObservable to add
	 * @return
	 *         true if the observable has been successfully added, false otherwise
	 */
	public boolean add(IObservable observable);
}
