package org.eclipse.papyrus.uml.service.creation.helper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.UMLPackage;


public class PortEditHelper extends DefaultUMLHelper {

	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {

		// Set Port Aggregation to Composite on creation
		SetRequest setReq = new SetRequest(req.getElementToConfigure(), UMLPackage.eINSTANCE.getProperty_Aggregation(), AggregationKind.COMPOSITE_LITERAL);
		return new SetValueCommand(setReq);
	}
}
