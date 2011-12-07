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
package org.eclipse.papyrus.uml.modelexplorer.queries;

import java.util.Collection;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.views.modelexplorer.NavigatorUtils;
import org.eclipse.papyrus.views.modelexplorer.queries.AbstractEditorContainerQuery;
import org.eclipse.uml2.uml.Element;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

/**
 * Get the collection of all contained diagrams
 * FIXME : delete this class when the bug EMF-Facet 365744 will be corrected!
 * 
 * @Deprecated : use oep.infra.gmfdiag.modelexplorer#queries.GetContainedDiagrams
 */
@Deprecated
public class GetContainedDiagrams extends AbstractEditorContainerQuery implements IJavaModelQuery<Element, Collection<org.eclipse.gmf.runtime.notation.Diagram>> {

	public Collection<org.eclipse.gmf.runtime.notation.Diagram> evaluate(final Element context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		Predicate<EStructuralFeature.Setting> p = new Predicate<EStructuralFeature.Setting>() {
			public boolean apply(EStructuralFeature.Setting arg0) {
				return arg0.getEObject() instanceof Diagram ;
			}
		};
		Function<EStructuralFeature.Setting, Diagram> f = new Function<EStructuralFeature.Setting, Diagram>() {

			public Diagram apply(EStructuralFeature.Setting arg0) {
				return (Diagram)arg0.getEObject();
			}
			
		};
		return NavigatorUtils.findFilterAndApply(context, p, f);
	}
}
