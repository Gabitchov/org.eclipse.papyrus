package org.eclipse.papyrus.sysml.facets.portandflows.query.value.getter;

import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.sysml.portandflows.FlowDirection;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.sysml.util.ElementUtil;
import org.eclipse.uml2.uml.Port;

/** Query to qet the attribute "Direction" of the FlowPort */
public class GetFlowPortDirectionQuery implements IJavaModelQuery<Port, FlowDirection> {

	public FlowDirection evaluate(final Port context, final ParameterValueList parameterValues)
			throws ModelQueryExecutionException {
		FlowPort flowPort = ElementUtil.getStereotypeApplication(context, FlowPort.class);
		if(flowPort != null) {
			return flowPort.getDirection();
		}
		return null;
	}
}
