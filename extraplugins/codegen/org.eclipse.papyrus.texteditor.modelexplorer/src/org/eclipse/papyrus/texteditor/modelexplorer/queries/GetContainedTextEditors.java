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
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *  (with the help of examining table support from Vincent Lorenzo)
 *
 *****************************************************************************/

package org.eclipse.papyrus.texteditor.modelexplorer.queries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.texteditor.model.texteditormodel.TextEditorModel;
import org.eclipse.papyrus.views.modelexplorer.NavigatorUtils;
import org.eclipse.papyrus.views.modelexplorer.queries.AbstractEditorContainerQuery;

/** Get the collection of all contained tables */
//FIXME this query is declared using Element in the querySet -> change into EObject when the EMF-Facet bug will be corrected 365744
public class GetContainedTextEditors extends AbstractEditorContainerQuery implements IJavaModelQuery<EObject, Collection<TextEditorModel>> {

	/**
	 * {@inheritDoc}
	 */
	public Collection<TextEditorModel> evaluate(final EObject context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		List<TextEditorModel> result = new ArrayList<TextEditorModel>();
		Iterator<EObject> roots = NavigatorUtils.getNotationRoots(context);
		if(roots == null) {
			return result;
		}

		while(roots.hasNext()) {
			EObject root = roots.next();
			if(root instanceof TextEditorModel) {
				if(EcoreUtil.equals(((TextEditorModel)root).getEditedObject(), context)) {
					result.add((TextEditorModel)root);
				}
			}
		}
		return result;
	}
}
