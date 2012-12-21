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
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;

import org.eclipse.papyrus.qompass.designer.core.ConnectorUtils;

/**
 * Check whether the multiplicity of the ports (of a part) are consistent with the defined connectors, in particular whether a
 * port with a required interface is not connected with more connectors than its own multiplicity 
 * @author ansgar
 *
 * TODO: does not find violation on composite side (partWithPort = null), simplify? (loop over connectors)
 */
public class ConnectorCallMultiplicity extends AbstractModelConstraint
{
	@Override
	public IStatus validate (IValidationContext ctx)
	{
		String portsStr = "";
		
		Property part = (Property) ctx.getTarget();
		Class owner = part.getClass_ ();
		if (owner != null) {
			if (part.getType () instanceof Class) {
				Class class_ = (Class) part.getType ();
				for (Port port : class_.getOwnedPorts ()) {
					if (port.getRequireds ().size () > 0) {
						int connections = 0;
						for (Connector connector : owner.getOwnedConnectors ()) {
							if (ConnectorUtils.connectsPort (connector, port)) {
								connections ++;
								break;
							}
						}
						if (connections > port.getUpper ()) {
							if (portsStr.length () != 0) {
								portsStr += ", ";
							}
							portsStr += port.getName ();
						}
					}
				}
			}
		}
		if (portsStr.length () > 0) {
			return ctx.createFailureStatus ("The port(s) '" + portsStr + "' with a required interface of part '" + part.getName () + "' have more connections than their multiplicty within composite '" + owner.getQualifiedName () + "'");

		}
		else {
			return ctx.createSuccessStatus();
		}
	}
}
