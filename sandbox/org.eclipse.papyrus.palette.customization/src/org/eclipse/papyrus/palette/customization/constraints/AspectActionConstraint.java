package org.eclipse.papyrus.palette.customization.constraints;

import org.eclipse.papyrus.diagram.common.service.palette.IAspectAction;
import org.eclipse.papyrus.properties.constraints.AbstractConstraint;
import org.eclipse.papyrus.properties.constraints.Constraint;


public class AspectActionConstraint extends AbstractConstraint {

	public boolean match(Object selection) {
		return selection instanceof IAspectAction;
	}

	@Override
	protected boolean equivalent(Constraint constraint) {
		return constraint instanceof AspectActionConstraint;
	}

}
