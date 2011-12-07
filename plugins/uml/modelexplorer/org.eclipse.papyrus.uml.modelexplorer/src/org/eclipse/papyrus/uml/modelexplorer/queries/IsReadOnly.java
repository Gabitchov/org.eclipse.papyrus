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
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;

/**
 * Create a query which will return true if the ressource is in read only mode.
 * 
 * @author "Arthur Daussy <a href="mailto:arthur.daussy@atos.net">arthur.daussy@atos.net</a>"
 *         FIXME : delete this class when the bug EMF-Facet 365744 will be corrected!
 * @deprecated use org.eclipse.papyrus.views.modelexploer#queries.IsReadOnly
 */
@Deprecated
public class IsReadOnly implements IJavaModelQuery<EObject, Boolean> {

	public Boolean evaluate(EObject context, ParameterValueList parameterValues) throws ModelQueryExecutionException {
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(context);
		if(editingDomain != null) {
			if(editingDomain.isReadOnly(context.eResource())) {
				return true;
			}
		}
		return false;
	}

}
