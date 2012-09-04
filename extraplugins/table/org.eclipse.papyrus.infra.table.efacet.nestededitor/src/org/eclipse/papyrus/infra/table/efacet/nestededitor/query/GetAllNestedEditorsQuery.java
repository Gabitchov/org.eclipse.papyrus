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

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;

public class GetAllNestedEditorsQuery extends AbstractNestedEditorQuery<Object> {

	public List<Object> evaluate(EObject source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		IPageMngr pageMngr = getPageMngr(source);
		if(pageMngr != null) {
			return pageMngr.allPages();
		}
		return Collections.emptyList();
	}

}
