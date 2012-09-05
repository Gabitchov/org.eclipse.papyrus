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
package org.eclipse.papyrus.infra.table.efacet.nestededitor.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;

/**
 * 
 * This query returns all editors referenced by the context of the current editor or its childen
 * 
 */
public class GetAllSubNestedEditorsQuery extends AbstractNestedEditorQuery<Object> {

	/**
	 * 
	 * @see org.eclipse.emf.facet.query.java.core.IJavaQuery2#evaluate(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.facet.query.java.core.IParameterValueList2, org.eclipse.emf.facet.efacet.core.IFacetManager)
	 * 
	 * @param sourceEditor
	 * @param parameterValues
	 * @param facetManager
	 * @return
	 * @throws DerivedTypedElementException
	 */
	public List<Object> evaluate(final EObject sourceEditor, final IParameterValueList2 parameterValues, final IFacetManager facetManager) throws DerivedTypedElementException {
		final IPageMngr pageMngr = getPageMngr(sourceEditor);
		final List<Object> allPages = pageMngr.allPages();
		final List<Object> subPages = new ArrayList<Object>();
		final GetEditorContextQuery q = new GetEditorContextQuery();
		for(final Object currentPage : allPages) {
			if(currentPage instanceof EObject) {
				final EObject currentPageContext = q.evaluate((EObject)currentPage, null, null);
				if(currentPageContext != null) {
					final EObject sourceEditorContext = ((PapyrusTable)sourceEditor).getTable().getContext();
					if(getAllHierarchy(currentPageContext).contains(sourceEditorContext)) {
						subPages.add(currentPage);
					}
				}
			}
		}

		return subPages;
	}

	/**
	 * 
	 * @param eobject
	 * 
	 * @return
	 *         all parents of the eobject, including itself
	 */
	private Collection<EObject> getAllHierarchy(final EObject eobject) {
		final List<EObject> parents = new ArrayList<EObject>();
		EObject econtainer = eobject;
		while(econtainer != null) {
			parents.add(econtainer);
			econtainer = econtainer.eContainer();
		}
		return parents;
	}
}
