/*******************************************************************************
 * Copyright (c) 2008-2010 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are property of the CEA, their use is subject to specific agreement 
 * with the CEA.
 * 
 * Contributors:
 *    CEA LIST - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.qompass.designer.validation.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.papyrus.FCM.InteractionComponent;
import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.papyrus.qompass.designer.core.templates.ConnectorBinding;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;

/**
 * Check whether a connector is connectable, i.e. whether the ports of application parts match with those
 * of the connector types that are chosen.
 * 
 * @author ansgar
 * 
 */
public class ConnectorConnectable extends AbstractModelConstraint
{

	@Override
	public IStatus validate(IValidationContext ctx)
	{
		Connector connector = (Connector)ctx.getTarget();
		Class class_ = (Class)connector.getOwner();

		org.eclipse.papyrus.FCM.Connector fcmConnector = StUtils.getApplication(connector, org.eclipse.papyrus.FCM.Connector.class);
		if(fcmConnector != null) {
			InteractionComponent connectorComp = fcmConnector.getIc();
			if(connectorComp != null) {
				try {
					ConnectorBinding.obtainBinding(class_, connector, connectorComp.getBase_Class(), false);
				} catch (TransformationException e) {
					return ctx.createFailureStatus("The connector '" + connector.getName() + "' within composite '" + class_.getName() + "' cannot be instantiated: " + e.getMessage());
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}
