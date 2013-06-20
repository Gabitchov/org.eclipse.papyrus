/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.designer.core.listeners;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;

/**
 * Interface for listeners that are notified for the addition of a classifier
 * via copy
 * 
 * @see org.eclipse.papyrus.qompass.designer.core.transformations.Copy
 */
public interface CopyListener {

	/**
	 * Is called for each EObject that is copied. If it returns null, the
	 * indicated object should not be copied. If it returns a different object
	 * than the passed EObject, this object is used (the returned object of the
	 * first listener is used).
	 * 
	 * @param sourceEObj
	 *        the added classifier
	 */
	public EObject copyEObject(Copy copy, EObject sourceEObj);
}
