package org.eclipse.papyrus.qompass.designer.validation.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.papyrus.qompass.designer.core.PortUtils;
import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Port;

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
		org.eclipse.papyrus.FCM.Port fcmPort = StUtils.getApplication(port, org.eclipse.papyrus.FCM.Port.class);
		if((fcmPort != null) && !PortUtils.isExtendedPort(port)) {
			
			if ((fcmPort.getProvidedInterface() == null) && (fcmPort.getRequiredInterface() == null)) {
				Class class_ = port.getClass_ ();
				return ctx.createFailureStatus ("The port '" + port.getName () + "' owned by class '" + class_.getQualifiedName () + //$NON-NLS-1$ //$NON-NLS-2$
						"' is not correctly typed, since derived provided and required interface is null"); //$NON-NLS-1$
			}
		}
		return ctx.createSuccessStatus();

	}
}
