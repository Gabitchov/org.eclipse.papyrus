/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profilefacet.queries.getter;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil;


public class GetEObjectSingleReference extends GetGenericSingleValue<EObject> {

	@Override
	public EObject evaluate(final Element source, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		EObject obj = super.evaluate(source, parameterValues);

		if(UMLUtil.getStereotype(obj) != null) {
			obj = UMLUtil.getBaseElement(obj);
		}
		return obj;
	}
}
