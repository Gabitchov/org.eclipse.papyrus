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
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.sysml.efacet.utils;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.uml2.uml.Element;


public class IsAppliedSysMLStereotypeQuery implements IJavaQuery2<EObject, Boolean> {

	public Boolean evaluate(EObject source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		ParameterValue val = parameterValues.getParameterValueByName("stereotype"); //$NON-NLS-1$
		EClass value = (EClass)val.getValue();
		if(source instanceof Element) {
			List<EObject> stereotypeApplications = ((Element)source).getStereotypeApplications();
			for(final EObject current : stereotypeApplications) {
				if(current.eClass() == value) {
					return Boolean.TRUE;
				}
			}
		}
		return Boolean.FALSE;
	}
}
