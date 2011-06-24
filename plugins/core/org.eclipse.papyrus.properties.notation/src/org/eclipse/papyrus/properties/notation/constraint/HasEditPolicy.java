/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.notation.constraint;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.papyrus.properties.constraints.AbstractConstraint;
import org.eclipse.papyrus.properties.constraints.Constraint;
import org.eclipse.papyrus.properties.contexts.SimpleConstraint;


public class HasEditPolicy extends AbstractConstraint {

	protected String editPolicyID;

	public boolean match(Object selection) {
		if(editPolicyID != null && selection instanceof GraphicalEditPart) {
			return ((GraphicalEditPart)selection).getEditPolicy(editPolicyID) != null;
		}

		return false;
	}

	@Override
	protected void setDescriptor(SimpleConstraint descriptor) {
		editPolicyID = getValue("editPolicy"); //$NON-NLS-1$
	}

	@Override
	protected boolean equivalent(Constraint constraint) {
		if(constraint == null) {
			return false;
		}

		return constraint instanceof HasEditPolicy && ((HasEditPolicy)constraint).editPolicyID == editPolicyID;
	}

}
