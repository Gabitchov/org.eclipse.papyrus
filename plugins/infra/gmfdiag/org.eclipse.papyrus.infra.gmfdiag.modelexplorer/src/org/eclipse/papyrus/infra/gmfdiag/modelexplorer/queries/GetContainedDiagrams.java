/**
 *  Copyright (c) 2011 Atos.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Atos - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.infra.gmfdiag.modelexplorer.queries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.views.modelexplorer.NavigatorUtils;
import org.eclipse.papyrus.views.modelexplorer.queries.AbstractEditorContainerQuery;

/** Get the collection of all contained diagrams */
public class GetContainedDiagrams extends AbstractEditorContainerQuery implements IJavaModelQuery<EObject, Collection<org.eclipse.gmf.runtime.notation.Diagram>> {

	public Collection<Diagram> evaluate(final EObject context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		List<Diagram> result = new ArrayList<Diagram>(3);
		Iterator<EObject> roots = NavigatorUtils.getNotationRoots(context);
		if (roots == null)
			return result;
		while (roots.hasNext()) {
			EObject root = roots.next();
			if (root instanceof Diagram) {
				if (EcoreUtil.equals(((Diagram)root).getElement(), context))
					result.add((Diagram)root);
			}
		}
		return result;
	}
}
