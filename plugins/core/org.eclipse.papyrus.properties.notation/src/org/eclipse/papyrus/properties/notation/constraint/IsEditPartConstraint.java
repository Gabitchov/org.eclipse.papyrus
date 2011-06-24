package org.eclipse.papyrus.properties.notation.constraint;

import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.properties.constraints.AbstractConstraint;
import org.eclipse.papyrus.properties.constraints.Constraint;


public class IsEditPartConstraint extends AbstractConstraint {

	public boolean match(Object selection) {
		return selection instanceof EditPart;
	}

	@Override
	protected boolean equivalent(Constraint constraint) {
		return false;
	}

}
