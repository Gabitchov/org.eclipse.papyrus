/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.designer.validation.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.papyrus.FCM.InteractionComponent;
import org.eclipse.papyrus.qompass.designer.core.templates.ConnectorBinding;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.util.UMLUtil;

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

		org.eclipse.papyrus.FCM.Connector fcmConnector = UMLUtil.getStereotypeApplication(connector, org.eclipse.papyrus.FCM.Connector.class);
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
