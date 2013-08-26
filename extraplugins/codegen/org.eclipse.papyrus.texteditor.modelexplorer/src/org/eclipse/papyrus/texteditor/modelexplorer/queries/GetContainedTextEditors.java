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

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.texteditor.model.texteditormodel.TextEditorModel;
import org.eclipse.papyrus.views.modelexplorer.queries.AbstractEditorContainerQuery;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/** Get the collection of all contained tables */
//FIXME this query is declared using Element in the querySet -> change into EObject when the EMF-Facet bug will be corrected 365744
public class GetContainedTextEditors extends AbstractEditorContainerQuery implements IJavaModelQuery<EObject, Collection<TextEditorModel>> {

	/**
	 * {@inheritDoc}
	 */
	public Collection<TextEditorModel> evaluate(final EObject context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		Predicate<EStructuralFeature.Setting> p = new Predicate<EStructuralFeature.Setting>() {

			public boolean apply(EStructuralFeature.Setting setting) {
				return (setting.getEObject() instanceof TextEditorModel);
			}
		};
		
		Function<EStructuralFeature.Setting, TextEditorModel> f = new Function<EStructuralFeature.Setting, TextEditorModel>() {

			public TextEditorModel apply(EStructuralFeature.Setting setting) {
				if (setting.getEObject() instanceof TextEditorModel) {
					return (TextEditorModel) setting.getEObject();
				}
				return null;
			}

		};

		Iterable<TextEditorModel> transform = Iterables.transform(Iterables.filter(EMFHelper.getUsages(context), p), f);
		transform = Iterables.filter(transform, new Predicate<TextEditorModel>() {

			public boolean apply(TextEditorModel table) {
				return table != null;
			}
		});
		return Sets.newHashSet(transform);
	}

}
