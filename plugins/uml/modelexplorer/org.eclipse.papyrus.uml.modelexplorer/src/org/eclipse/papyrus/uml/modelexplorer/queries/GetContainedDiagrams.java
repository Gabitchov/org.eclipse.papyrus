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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.views.modelexplorer.NavigatorUtils;
import org.eclipse.papyrus.views.modelexplorer.queries.AbstractEditorContainerQuery;
import org.eclipse.uml2.uml.Element;

/**
 * Get the collection of all contained diagrams
 * FIXME : delete this class when the bug EMF-Facet 365744 will be corrected!
 * 
 * @Deprecated : use oep.infra.gmfdiag.modelexplorer#queries.GetContainedDiagrams
 */
@Deprecated
public class GetContainedDiagrams extends AbstractEditorContainerQuery implements IJavaQuery2<Element, Collection<org.eclipse.gmf.runtime.notation.Diagram>> {


	public Collection<Diagram> evaluate(Element source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		List<Diagram> result = new ArrayList<Diagram>();
		Iterator<EObject> roots = NavigatorUtils.getNotationRoots(source);
		if(roots == null) {
			return result;
		}

		while(roots.hasNext()) {
			EObject root = roots.next();
			if(root instanceof Diagram) {
				if(EcoreUtil.equals(((Diagram)root).getElement(), source)) {
					result.add((Diagram)root);
				}
			}
		}
		return result;
	}
}
