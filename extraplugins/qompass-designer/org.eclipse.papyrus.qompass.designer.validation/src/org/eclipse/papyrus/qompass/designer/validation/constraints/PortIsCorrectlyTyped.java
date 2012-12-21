package org.eclipse.papyrus.qompass.designer.validation.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Port;

import org.eclipse.papyrus.qompass.designer.core.StUtils;

/**
 * Check whether the port is not correctly typed, e.g. the port kind ProvideInterface is used in
 * conjunction with a data type.
 * Technically, the criterion will be that not both, derived provided and derived required interfaces
 * are empty. 
 * @author ansgar
 *
 */
public class PortIsCorrectlyTyped  extends AbstractModelConstraint {

	@Override
	public IStatus validate (IValidationContext ctx)
	{
		Port port = (Port) ctx.getTarget ();
		FCM.Port fcmPort = StUtils.getApplication(port, FCM.Port.class);
		if (fcmPort != null) {
			
			if ((fcmPort.getProvidedInterface() == null) && (fcmPort.getRequiredInterface() == null)) {
				Class class_ = port.getClass_ ();
				return ctx.createFailureStatus ("The port '" + port.getName () + "' owned by class '" + class_.getQualifiedName () + "' is not correctly typed, since derived provided and required interface is null");
			}
		}
		return ctx.createSuccessStatus();

	}
}
