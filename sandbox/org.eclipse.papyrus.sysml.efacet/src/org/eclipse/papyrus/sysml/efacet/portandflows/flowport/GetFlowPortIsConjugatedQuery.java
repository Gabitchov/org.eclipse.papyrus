/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.sysml.efacet.portandflows.flowport;

import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.util.UMLUtil;

/** Query to qet the attribute "Direction" of the FlowPort */
public class GetFlowPortIsConjugatedQuery implements IJavaQuery2<Port, Boolean> {

	public Boolean evaluate(final Port source, final IParameterValueList2 parameterValues, final IFacetManager facetManager) throws DerivedTypedElementException {
		final FlowPort flowPort = UMLUtil.getStereotypeApplication(source, FlowPort.class);
		if(flowPort != null) {
			return flowPort.isConjugated();
		}
		return null;
	}
}