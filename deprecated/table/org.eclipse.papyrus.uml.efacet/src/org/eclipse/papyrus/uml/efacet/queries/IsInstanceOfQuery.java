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
package org.eclipse.papyrus.uml.efacet.queries;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.emf.facet.query.java.core.IParameterValueList2;

/**
 * 
 * Duplicate code from org.eclipse.papyrus.uml.modelexplorer. This code moved
 * when we rewrite the customization for uml.
 */
//TODO this query should be moved in the emf.efacet plugin
public class IsInstanceOfQuery implements IJavaQuery2<EObject, Boolean> {

	/**
	 * 
	 * @see org.eclipse.emf.facet.query.java.core.IJavaQuery2#evaluate(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.facet.query.java.core.IParameterValueList2, org.eclipse.emf.facet.efacet.core.IFacetManager)
	 * 
	 * @param context
	 * @param parameterValues
	 * @param facetManager
	 * @return
	 * @throws DerivedTypedElementException
	 */
	public Boolean evaluate(final EObject context, final IParameterValueList2 parameterValues, final IFacetManager facetManager) throws DerivedTypedElementException {
		final ParameterValue wantedEClassParameter = parameterValues.getParameterValueByName("wantedEClass"); //$NON-NLS-1$
		final EClass wantedEClass = (EClass)wantedEClassParameter.getValue();
		return wantedEClass.isInstance(context);
	}

}
