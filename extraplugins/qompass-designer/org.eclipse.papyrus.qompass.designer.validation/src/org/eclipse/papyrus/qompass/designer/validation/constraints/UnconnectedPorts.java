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
import org.eclipse.papyrus.uml.tools.utils.ConnectorUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Check whether a port of a part remains without connection. Whereas it is typically problematic
 * for ports with a required interface, we also raise an info for those with a provided interface
 * 
 */
abstract public class UnconnectedPorts extends AbstractModelConstraint
{
	/**
	 * Called by one of the sub-classes (does not override a superclass method)
	 * @param ctx the validation context
	 * @param required if true, examine required ports, if false provided ports
	 * @return
	 */
	public IStatus validatePorts (IValidationContext ctx, boolean required)
	{
		String portsStr = ""; //$NON-NLS-1$
		
		Property attribute = (Property) ctx.getTarget();
		Class owner = attribute.getClass_ ();
		if (owner != null) {
			if (attribute.getType () instanceof Class) {
				Class class_ = (Class) attribute.getType ();
				for (Port port : class_.getOwnedPorts ()) {
					org.eclipse.papyrus.FCM.Port fcmPort = UMLUtil.getStereotypeApplication(port, org.eclipse.papyrus.FCM.Port.class);
					if (fcmPort == null) {
						continue;	// make rule Qompass specific, only check ports with FCM stereotype
					}
					if (((fcmPort.getRequiredInterface() != null) && required) ||
						((fcmPort.getProvidedInterface() != null) && !required)) {{
							boolean found = false;
							for (Connector connector : owner.getOwnedConnectors ()) {
								if (ConnectorUtil.connectsPort (connector, port)) {
									found = true;
									break;
								}
							}
							if (!found) {
								if (portsStr.length () != 0) {
									portsStr += ", "; //$NON-NLS-1$
								}
								portsStr += port.getName ();
							}
						}
					}
				}
			}
		}
		if (portsStr.length () > 0) {
			return ctx.createFailureStatus ("The port(s) '" + portsStr + "' of part '" + attribute.getName () + "' remains unconnected within composite class '" + owner.getQualifiedName () + "'");

		}
		else {
			return ctx.createSuccessStatus();
		}
	}
}
