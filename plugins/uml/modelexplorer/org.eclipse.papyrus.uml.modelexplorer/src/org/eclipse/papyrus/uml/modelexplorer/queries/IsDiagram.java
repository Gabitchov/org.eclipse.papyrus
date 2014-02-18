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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.gmf.runtime.notation.Diagram;

/**
 * Return tru eif the element is a diagram * FIXME : delete this class when the bug EMF-Facet 365744 will be corrected!
 * 
 * @Deprecated : use oep.infra.gmfdiag.modelexplorer#queries.IsDiagram
 */
@Deprecated
public class IsDiagram implements IJavaQuery2<EObject, Boolean> {


	public Boolean evaluate(EObject source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		return source instanceof Diagram;
		}
}
