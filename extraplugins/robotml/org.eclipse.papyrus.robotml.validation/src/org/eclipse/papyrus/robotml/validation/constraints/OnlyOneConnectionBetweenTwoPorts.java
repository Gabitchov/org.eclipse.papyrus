/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.robotml.validation.constraints;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;

public class OnlyOneConnectionBetweenTwoPorts extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {

		Connector elt = (Connector)ctx.getTarget();
		if (ConstraintsUtil.verifyRobotMLApplied(elt)){
		List<ConnectorEnd> cends = new ArrayList<ConnectorEnd>();
		cends = elt.getEnds();
		if(cends != null) {//if1
			if(cends.size() == 2) {//if2
				if((cends.get(0) instanceof ConnectorEnd) && (cends.get(1) instanceof ConnectorEnd)) {//if3
					final ConnectableElement connectorEndRole0 = cends.get(0).getRole();
					ConnectableElement connectorEndRole1 = cends.get(1).getRole();
					Property partWithPort0 = cends.get(0).getPartWithPort();
					Property partWithPort1 = cends.get(1).getPartWithPort();
					if((connectorEndRole0 instanceof Port) && (connectorEndRole1 instanceof Port)) {//if4
						List<ConnectorEnd> port1Ends = new ArrayList<ConnectorEnd>();
						List<ConnectorEnd> port0Ends = new ArrayList<ConnectorEnd>();
						port0Ends = connectorEndRole0.getEnds();
						port1Ends = connectorEndRole1.getEnds();
						for(ConnectorEnd end0 : port0Ends) {

							for(ConnectorEnd end1 : port1Ends) {

								if((end0.eContainer().equals(end1.eContainer())) && !(end0.eContainer().equals(elt))) {
									//verify that partwithPort of the found connector ends are the same than those of the connector that will be created
									if(end0.getPartWithPort().equals(partWithPort0) && end1.getPartWithPort().equals(partWithPort1)) {
										return ctx.createFailureStatus("Connection must be set between ports that are not already connected. There is already a connector named : " + ((Connector)end0.eContainer()).getQualifiedName());
									}


								}
							}
						}
					}
				}
			}
		}
		}
		return ctx.createSuccessStatus();
	}

}
