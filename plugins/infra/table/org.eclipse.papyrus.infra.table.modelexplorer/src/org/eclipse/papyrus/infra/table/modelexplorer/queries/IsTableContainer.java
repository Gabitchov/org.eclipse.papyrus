/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.modelexplorer.queries;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.views.modelexplorer.NavigatorUtils;
import org.eclipse.papyrus.views.modelexplorer.queries.AbstractEditorContainerQuery;

/** Returns true if the element contains a Table */
//FIXME this query is declared using Element in the querySet -> change into EObject when the EMF-Facet bug will be corrected 365744
public class IsTableContainer extends AbstractEditorContainerQuery implements IJavaModelQuery<EObject, Boolean> {

	/**
	 * {@inheritDoc}
	 */
	public Boolean evaluate(final EObject context, ParameterValueList parameterValues) throws ModelQueryExecutionException {
		Iterator<EObject> roots = NavigatorUtils.getNotationRoots(context);
		if (roots == null)
			return false;
		while (roots.hasNext()) {
			EObject root = roots.next();
			if (root instanceof PapyrusTableInstance) {
				if (EcoreUtil.equals(((PapyrusTableInstance)root).getTable().getContext(), context))
					return true;
			}
		}
		return false;
	}
}
