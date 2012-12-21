package org.eclipse.papyrus.qompass.designer.validation.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.IValidationContext;


public class UnconnectedReqPorts extends UnconnectedPorts {
	
	@Override
	public IStatus validate(IValidationContext ctx) {
		return super.validatePorts (ctx, false);
	}
}
