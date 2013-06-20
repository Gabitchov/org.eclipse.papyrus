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
import org.eclipse.papyrus.RobotML.DataFlowPort;
import org.eclipse.papyrus.RobotML.ServicePort;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Stereotype;

// TODO: Auto-generated Javadoc
/**
 * The Class PortsAreCorrectlyConnected.
 */
public class PortsAreCorrectlyConnected extends AbstractModelConstraint {



	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse
	 * .emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		Connector elt = (Connector)ctx.getTarget();
		List<ConnectorEnd> cends = new ArrayList<ConnectorEnd>();
		cends = elt.getEnds();
		// 1. verify that only ports of the same kind are connected
		if(cends != null) {// if1

			if(cends.size() == 2) {// if2
				if((cends.get(0) instanceof ConnectorEnd) && (cends.get(1) instanceof ConnectorEnd)) {// if3
					// verify that the connection is between two ports of two
					// subsystems

					ConnectableElement connectorEndRole0 = cends.get(0).getRole();
					ConnectableElement connectorEndRole1 = cends.get(1).getRole();

					// System.out.println(connectorEndRole0.getEnds());
					if((connectorEndRole0 instanceof Port) && (connectorEndRole1 instanceof Port)) {// if4
						// verify that the connection is between two ports of
						// two subsystems of the same containing system

						if(!(connectorEndRole0.getAppliedStereotypes().isEmpty()) && !(connectorEndRole1.getAppliedStereotypes().isEmpty())) {// if5
							// verify if the applied stereotype on the ports is
							// the same
							List<Stereotype> steretypesPort0 = new ArrayList<Stereotype>();
							steretypesPort0 = connectorEndRole0.getAppliedStereotypes();
							List<Stereotype> steretypesPort1 = new ArrayList<Stereotype>();
							steretypesPort1 = connectorEndRole1.getAppliedStereotypes();

							if(steretypesPort0.get(0).getName().equals(steretypesPort1.get(0).getName())) {// if8
								// verify that connections are set between ports
								// of the same type
								if(!(connectorEndRole0.getType().equals(connectorEndRole1.getType()))) {
									return ctx.createFailureStatus("Connection must be set between ports that have the same type (" + elt.getQualifiedName() + ")");
								}
								// here I have to check that the connection is
								// between ports of sub systems and not between
								// a port of the container system and a
								// subsystem port's.
								Boolean areSubsystems = true;

								if((elt.getOwner() == connectorEndRole0.getOwner()) || (elt.getOwner() == connectorEndRole1.getOwner())) {
									areSubsystems = false;
								}
								// System.err.println("\n\n\nConnector Owner: "
								// + elt.getOwner()+ "\nPort0 owner: "+
								// connectorEndRole0.getOwner()+
								// "\nPort1 owner: "+
								// connectorEndRole1.getOwner()+" "+areSubsystems+"\n\n");
								// verify if connections are set between in and
								// out DataFlowPorts or provided and required
								// ServicePorts
								DataFlowPort flowport0 = UMLUtil.getStereotypeApplication((Element)connectorEndRole0, DataFlowPort.class);
								DataFlowPort flowport1 = UMLUtil.getStereotypeApplication(connectorEndRole1, DataFlowPort.class);

								if(flowport0 != null && flowport1 != null) {
									if((flowport0.getDirection().getValue() == flowport1.getDirection().getValue()) && areSubsystems) {
										return ctx.createFailureStatus("Connection must be set between Flow ports that have opposite direction (" + elt.getQualifiedName() + ")");
									} else if((flowport0.getDirection().getValue() != flowport1.getDirection().getValue()) && !areSubsystems) {
										return ctx.createFailureStatus("Connection must be set between Flow ports that have the same direction (" + elt.getQualifiedName() + ")");
									}
								}

								ServicePort serviceport0 = UMLUtil.getStereotypeApplication(connectorEndRole0, ServicePort.class);

								ServicePort serviceport1 = UMLUtil.getStereotypeApplication(connectorEndRole1, ServicePort.class);
								if(serviceport0 != null && serviceport1 != null) {
									if((serviceport0.getKind().getValue() == serviceport1.getKind().getValue()) && areSubsystems) {
										return ctx.createFailureStatus("Connection must be set between Service ports that have opposite direction (" + elt.getQualifiedName() + ")");
									} else if((serviceport0.getKind().getValue() != serviceport1.getKind().getValue()) && !areSubsystems) {
										return ctx.createFailureStatus("Connection must be set between Service ports that have the same direction (" + elt.getQualifiedName() + ")");
									}
								}
								return ctx.createSuccessStatus();
							}// endif8
							else {
								return ctx.createFailureStatus("Connection must be set between ports of same kind (" + elt.getQualifiedName() + ")");
							}

						}// endif5
					}// end if4

				}// end if3
			}// end if2
		}// end if1
			// 2. verify that there is only one connection between ports

		return ctx.createSuccessStatus();
	}
}
