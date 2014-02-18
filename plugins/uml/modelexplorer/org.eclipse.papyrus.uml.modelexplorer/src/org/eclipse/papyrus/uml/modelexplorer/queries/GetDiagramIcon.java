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

import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.views.modelexplorer.queries.AbstractGetEditorIconQuery;

/**
 * Return the path to the icon of the corresponding diagram * FIXME : delete this class when the bug EMF-Facet 365744 will be corrected!
 * 
 * @Deprecated : use oep.infra.gmfdiag.modelexplorer#queries.GetDiagramIcon
 */
@Deprecated
public class GetDiagramIcon extends AbstractGetEditorIconQuery implements IJavaQuery2<Diagram, String> {


	public String evaluate(Diagram source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		return "/" + getEditorRegistry(source).getEditorURLIcon(source); //$NON-NLS-1$
	}
}
