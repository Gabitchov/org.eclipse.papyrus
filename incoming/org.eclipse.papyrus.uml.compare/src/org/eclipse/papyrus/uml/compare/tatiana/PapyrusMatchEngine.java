/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.tatiana;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.compare.match.MatchOptions;
import org.eclipse.emf.compare.match.engine.GenericMatchEngine;
import org.eclipse.emf.compare.match.engine.IMatchScope;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Element;


/**
 * Implementation of MatchEngine for UML Diagrams:
 * <li>Processes changes in stereotypes and tagged values as children of the base element, not of resource</li> 
 */
public class PapyrusMatchEngine extends GenericMatchEngine {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.match.engine.GenericMatchEngine#resourceMatch(org.eclipse.emf.ecore.resource.Resource, org.eclipse.emf.ecore.resource.Resource, java.util.Map)
	 */
	@Override
	public MatchModel resourceMatch(Resource leftResource, Resource rightResource, Map<String, Object> optionMap) throws InterruptedException {
		optionMap.put(MatchOptions.OPTION_MATCH_SCOPE_PROVIDER, new PapyrusMatchScopeProvider(leftResource, rightResource));
		return super.resourceMatch(leftResource, rightResource, optionMap);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.match.engine.GenericMatchEngine#getScopeInternalContents(org.eclipse.emf.ecore.EObject, org.eclipse.emf.compare.match.engine.IMatchScope)
	 */
	@Override
	protected List<EObject> getScopeInternalContents(EObject eObject, IMatchScope scope) {
		ArrayList<EObject> result = new ArrayList<EObject>(super.getScopeInternalContents(eObject, scope));
		result.addAll(getStereotypeApplications(eObject));
		return result;
	}

	/**
	 * Gets the stereotype applications.
	 *
	 * @param eObject the e object
	 * @return the stereotype applications
	 */
	private List<EObject> getStereotypeApplications(EObject eObject) {
		if(eObject instanceof Element) {
			return ((Element)eObject).getStereotypeApplications();
		} else {
			return Collections.emptyList();
		}
	}

}
