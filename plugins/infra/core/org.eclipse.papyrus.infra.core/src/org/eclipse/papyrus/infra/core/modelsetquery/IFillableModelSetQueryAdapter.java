/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE tristan.faure@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.modelsetquery;

import java.util.HashSet;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

public interface IFillableModelSetQueryAdapter extends IModelSetQueryAdapter {
	/**
	 * This method provides a way for user to force first entries in the cache.
	 * The list of element must be a HashSet to optimize the performances
	 * 
	 * @param type
	 * @param list
	 */
	void addEntriesInCache(EClassifier type, HashSet<EObject> list);
	
	/**
	 * Determines if the cache already contain this EClassifier
	 * @param type, the desired type
	 * @return true if the cache already compute this entry
	 */
	boolean isAlreadyComputed(EClassifier type);
}
