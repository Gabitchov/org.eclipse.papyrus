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
 *  Tristan FAURE tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.modelsetquery;

import java.util.Collection;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

/**
 * interface to manage services to return objects from type
 * 
 * @author tfaure
 * 
 */
public interface IModelSetQueryAdapter {

	/**
	 * Return all the objects of type type
	 * 
	 * @param object
	 *        , the object to start the search
	 * @param type
	 *        , the type searched
	 * @return the list of the instance of type
	 */
	Collection<EObject> getReachableObjectsOfType(EObject object, EClassifier type);
}
