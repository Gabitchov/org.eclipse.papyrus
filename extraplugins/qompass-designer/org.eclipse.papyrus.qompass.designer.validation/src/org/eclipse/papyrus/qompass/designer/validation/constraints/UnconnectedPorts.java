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
 * Check whether a port of a part remains without connection. Whereas it is typically problematic
 * for ports with a required interface, we also raise an info for those with a provided interface
 * [Btw. is it possible to say: "I know, don't warn me again?"]
 * 
 * 
 * @author ansgar
 *
 */
abstract public class UnconnectedPorts extends AbstractModelConstraint
{
	/**
	 * Call by one of the sub-classes (does not override a superclass method)
	 * @param ctx the validation context
	 * @param required if true, examine required ports, if false provided ports
	 * @return
	 */
	public IStatus validatePorts (IValidationContext ctx, boolean required)
	{
		String portsStr = "";
		
		Property attribute = (Property) ctx.getTarget();
		Class owner = attribute.getClass_ ();
		if (owner != null) {
			if (attribute.getType () instanceof Class) {
				Class class_ = (Class) attribute.getType ();
				for (Port port : class_.getOwnedPorts ()) {
					if (((port.getRequireds ().size () > 0) && required) ||
						((port.getProvideds ().size () > 0) && !required)) {{
							boolean found = false;
							for (Connector connector : owner.getOwnedConnectors ()) {
								if (ConnectorUtils.connectsPort (connector, port)) {
									found = true;
									break;
								}
							}
							if (!found) {
								if (portsStr.length () != 0) {
									portsStr += ", ";
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
