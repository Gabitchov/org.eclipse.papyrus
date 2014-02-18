/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.modelexplorer.queries;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.emf.facet.query.java.core.IParameterValueList2;

/**
 * Create a query which will return true if the ressource is in read only mode.
 * 
 * @author "Arthur Daussy <a href="mailto:arthur.daussy@atos.net">arthur.daussy@atos.net</a>"
 *         FIXME : delete this class when the bug EMF-Facet 365744 will be corrected!
 * @deprecated use org.eclipse.papyrus.views.modelexploer#queries.IsReadOnly
 */
@Deprecated
public class IsReadOnly implements IJavaQuery2<EObject, Boolean> {


	public Boolean evaluate(EObject source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(source);
		if(editingDomain != null) {
			if(editingDomain.isReadOnly(source.eResource())) {
				return true;
			}
		}
		return false;
	}

}
