/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.robotml.deployment.listener;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.robotml.deployment.Copy;

/**
 * Interface for listeners that are notified for the addition of a classifier
 * via copy
 * 
 * @see com.cea.ec3m.gentools.core.transformations.Copy
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
