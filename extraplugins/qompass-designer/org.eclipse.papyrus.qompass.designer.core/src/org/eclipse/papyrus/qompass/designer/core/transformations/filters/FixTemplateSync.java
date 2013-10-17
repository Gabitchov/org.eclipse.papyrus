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

package org.eclipse.papyrus.qompass.designer.core.transformations.filters;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.qompass.designer.core.listeners.CopyListener;
import org.eclipse.papyrus.qompass.designer.core.sync.CompImplSync;
import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;

/**
 * Synchronize derived realizations (after copying). If re-synchronization is not done, the
 * relationship would point to wrong interface, if it is derived and depending on a formal parameter. 
 * (e.g. derived push interface with formal parameter T would be at wrong location).
 */
public class FixTemplateSync implements CopyListener {

	public static FixTemplateSync getInstance() {
		if(instance == null) {
			instance = new FixTemplateSync();
		}
		return instance;
	}

	public EObject copyEObject(Copy copy, EObject targetEObj) {
		// if (copy.get(sourceEObj) isWithinTemplate)
		if (!(targetEObj instanceof Behavior)) {
			if((targetEObj instanceof Class) && Utils.isCompImpl((Class)targetEObj)) {
				Class implementation = (Class)targetEObj;
				CompImplSync.updatePorts(implementation);
				CompImplSync.syncRealizations(implementation);
				CompImplSync.syncDerivedOperations(implementation);
			}
		}
		return targetEObj;
	}

	private static FixTemplateSync instance = null;
}
