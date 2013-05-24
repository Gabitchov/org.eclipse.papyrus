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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.views.modelexplorer.NavigatorUtils;
import org.eclipse.papyrus.views.modelexplorer.queries.AbstractEditorContainerQuery;

import com.google.common.base.Predicate;

public class IsTableContainer extends AbstractEditorContainerQuery implements IJavaModelQuery<EObject, Boolean> {

	/**
	 * Return true if the element is a Diagram Container
	 */
	public Boolean evaluate(EObject context, ParameterValueList parameterValues) throws ModelQueryExecutionException {
		Predicate<Setting> p = new Predicate<Setting>() {

			public boolean apply(Setting arg0) {
				return arg0.getEObject() instanceof Table;
			}
		};
		return NavigatorUtils.find(context, p);
	}
}
