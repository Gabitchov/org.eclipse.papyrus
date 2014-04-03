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
import org.eclipse.papyrus.qompass.designer.core.transformations.LazyCopier;

/**
 * Interface for listeners that are notified when an eObject
 * is copied
 *
 * @see org.eclipse.papyrus.qompass.designer.core.transformations.LazyCopier
 */
public interface PostCopyListener {

	/**
	 * Is called for each EObject after is has been copied.
	* 
	 * @param targetEObj
	 *        the EObject that has been copied
	 */
	public void postCopyEObject(LazyCopier copy, EObject targetEObj);
}
