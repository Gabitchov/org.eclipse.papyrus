/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.subelement.services;

import java.util.Map;

import org.eclipse.emf.compare.match.engine.IMatchEngine;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.ecore.EObject;

//replace MatchService
public class SubElementMatchService {

	/**
	 * Utility classes don't need to (and shouldn't) be instantiated.
	 */
	private SubElementMatchService() {
		// prevents instantiation
	}

	/**
	 * Matches three objects along with their content, then return the corresponding match model.
	 * 
	 * @param leftObject
	 *        Left (local) of the three objects to get compared.
	 * @param rightObject
	 *        Right (latest from repository) of the three objects to compare.
	 * @param ancestor
	 *        Common ancestor of the two others.
	 * @param options
	 *        Options to tweak the matching procedure. <code>null</code> or an empty map will result in
	 *        the default options to be used.
	 * @return {@link MatchModel} for these three objects' comparison.
	 * @throws InterruptedException
	 *         Thrown if the matching is interrupted somehow.
	 * @see org.eclipse.emf.compare.match.MatchOptions
	 * @see IMatchEngine#contentMatch(EObject, EObject, EObject, Map)
	 * 
	 */
	public static MatchModel doContentMatch(EObject leftObject, EObject rightObject, Map<String, Object> options) throws InterruptedException {
		final IMatchEngine engine = new SubElementUMLMatchEngine();
		final MatchModel result = engine.contentMatch(leftObject, rightObject, options);
		engine.reset();
		return result;
	}


}
