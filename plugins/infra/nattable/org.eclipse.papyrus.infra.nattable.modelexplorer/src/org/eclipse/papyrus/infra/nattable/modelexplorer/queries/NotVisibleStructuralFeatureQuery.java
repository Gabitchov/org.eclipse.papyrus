/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters (CEA LIST) laurent.wouters@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.modelexplorer.queries;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;

public class NotVisibleStructuralFeatureQuery implements IJavaQuery2<Table, Boolean> {
	public Boolean evaluate(final Table context,
			final IParameterValueList2 parameterValues,
			final IFacetManager facetManager)
			throws DerivedTypedElementException {
		ParameterValue parameterValue= (ParameterValue)parameterValues.getParameterValueByName("eStructuralFeature");
		EStructuralFeature eStructuralFeature=(EStructuralFeature)parameterValue.getValue();
		//if eStructural feature ==null this is root model explorer.
		//border effect of  this kind of queries
		if (eStructuralFeature==null){
			return true;
		}
		
		return false;
	}
}
