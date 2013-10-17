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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.texteditor.model.texteditormodel.TextEditorModel;
import org.eclipse.papyrus.texteditor.model.texteditormodel.TextEditorModelPackage;
import org.eclipse.papyrus.views.modelexplorer.NavigatorUtils;
import org.eclipse.papyrus.views.modelexplorer.queries.AbstractEditorContainerQuery;

import com.google.common.base.Predicate;

/** Returns true if the element contains a Table */
//FIXME this query is declared using Element in the querySet -> change into EObject when the EMF-Facet bug will be corrected 365744
public class IsTextEditorContainer extends AbstractEditorContainerQuery implements IJavaModelQuery<EObject, Boolean> {

	/**
	 * {@inheritDoc}
	 */
	public Boolean evaluate(final EObject context, ParameterValueList parameterValues) throws ModelQueryExecutionException {
		Predicate<EObject> p = new Predicate<EObject>() {

			public boolean apply(EObject arg0) {
				if(arg0 instanceof TextEditorModel) {
					TextEditorModel textEditorInstance = (TextEditorModel)arg0;
					if (textEditorInstance.getEditedObject() == context) {
				//		System.err.println("isContainer = true: " + context); //$NON-NLS-1$
					}
					return (textEditorInstance.getEditedObject() == context);
				}
				return false;
			}
		};

		return NavigatorUtils.any(context, TextEditorModelPackage.eINSTANCE.getTextEditorModel(), false, p);
	}
}
