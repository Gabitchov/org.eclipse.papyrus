/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.modelexplorer.queries;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.views.modelexplorer.NavigatorUtils;
import org.eclipse.papyrus.views.modelexplorer.queries.AbstractEditorContainerQuery;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

/** Get the collection of all contained tables */
public class GetContainedTables extends AbstractEditorContainerQuery implements IJavaModelQuery<EObject, Collection<org.eclipse.papyrus.infra.nattable.model.nattable.Table>> {

	public Collection<org.eclipse.papyrus.infra.nattable.model.nattable.Table> evaluate(final EObject context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		Predicate<EStructuralFeature.Setting> p = new Predicate<EStructuralFeature.Setting>() {

			public boolean apply(EStructuralFeature.Setting arg0) {
				return arg0.getEObject() instanceof Table;
			}
		};
		Function<EStructuralFeature.Setting, Table> f = new Function<EStructuralFeature.Setting, Table>() {

			public Table apply(EStructuralFeature.Setting arg0) {
				return (Table)arg0.getEObject();
			}

		};
		return NavigatorUtils.findFilterAndApply(context, p, f);
	}
}
