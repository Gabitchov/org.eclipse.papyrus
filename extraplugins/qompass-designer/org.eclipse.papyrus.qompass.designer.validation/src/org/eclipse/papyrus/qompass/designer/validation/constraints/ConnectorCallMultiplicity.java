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
import org.eclipse.papyrus.FCM.DerivedElement;
import org.eclipse.papyrus.uml.tools.utils.ConnectorUtil;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;

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
		String portsStr = ""; //$NON-NLS-1$
		
		Property part = (Property) ctx.getTarget();
		if (!StereotypeUtil.isApplicable(part, DerivedElement.class)) {
			// make rule Qompass specific: only perform check, if the FCM profile is applied (checked via applicability
			// the DerviedElement stereotype)
			return ctx.createSuccessStatus();
		}
		Class owner = part.getClass_ ();
		if (owner != null) {
			if (part.getType () instanceof Class) {
				Class class_ = (Class) part.getType ();
				for (Port port : class_.getOwnedPorts ()) {
					if (port.getRequireds ().size () > 0) {
						int connections = 0;
						for (Connector connector : owner.getOwnedConnectors ()) {
							if (ConnectorUtil.connectsPort (connector, port)) {
								connections ++;
								break;
							}
						}
						if (connections > port.getUpper ()) {
							if (portsStr.length () != 0) {
								portsStr += ", "; //$NON-NLS-1$
							}
							portsStr += port.getName ();
						}
					}
				}
			}
		}
		if (portsStr.length () > 0) {
			return ctx.createFailureStatus (String.format(
					"The port(s) %s with a required interface of part %s have more connections than their multiplicty within composite %s",
					portsStr, part.getName(), owner.getQualifiedName()));

		}
		else {
			return ctx.createSuccessStatus();
		}
	}
}
