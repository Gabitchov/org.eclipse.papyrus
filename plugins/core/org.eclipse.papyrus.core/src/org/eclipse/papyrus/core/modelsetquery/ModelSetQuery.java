/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.modelsetquery;

import static org.eclipse.papyrus.core.modelsetquery.impl.ModelSetQueryAdapter.getExistingTypeCacheAdapter;

import java.util.Collection;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.core.modelsetquery.impl.IModelSetQueryAdapter;

/**
 * The Class ModelSetQuery provides service to get objects of specified type using cache mechanism
 */
public class ModelSetQuery {

	/**
	 * Return all the objects of specified type
	 * 
	 * @param eobjectInModelSet
	 *        , the object from which to search starts
	 * @param type
	 *        , the searched type
	 * @return the list of the instance of specified type
	 */
	public static Collection<EObject> getObjectsOfType(EObject eobjectInModelSet, EClassifier type) {
		IModelSetQueryAdapter adapter = getExistingTypeCacheAdapter(eobjectInModelSet);
		return adapter.getReachableObjectsOfType(eobjectInModelSet, type);
	}
}
