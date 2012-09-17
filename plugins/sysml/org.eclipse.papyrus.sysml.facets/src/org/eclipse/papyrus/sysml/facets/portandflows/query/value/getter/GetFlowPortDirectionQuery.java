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
package org.eclipse.papyrus.sysml.facets.portandflows.query.value.getter;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.sysml.facets.extendedsysml.extendedsysml.portandflows.NAFlowPortDirection;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.util.UMLUtil;

/** Query to qet the attribute "Direction" of the FlowPort */
public class GetFlowPortDirectionQuery implements IJavaModelQuery<Port, Enumerator> {

	public Enumerator evaluate(final Port context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		FlowPort flowPort = UMLUtil.getStereotypeApplication(context, FlowPort.class);
		if(flowPort != null) {
			if(flowPort.isAtomic()) {
				return flowPort.getDirection();
			} else {
				return NAFlowPortDirection.get(0);
			}
		}
		return null;
	}
}
