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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil;



public class GetEObjectMultiReference extends GetGenericMultiValue<EObject> {

	@Override
	public List<EObject> evaluate(Element source, ParameterValueList parameterValues) throws ModelQueryExecutionException {
		final List<EObject> value = super.evaluate(source, parameterValues);
		if(value == null) {
			return Collections.emptyList();
		} else {
			final List<EObject> returnedValue = new ArrayList<EObject>();
			for(EObject eObject : value) {
				if(UMLUtil.getStereotype(eObject) != null) {
					returnedValue.add(UMLUtil.getBaseElement(eObject));
				} else {
					returnedValue.add(eObject);
				}
			}
			return returnedValue;
		}
	}
}
