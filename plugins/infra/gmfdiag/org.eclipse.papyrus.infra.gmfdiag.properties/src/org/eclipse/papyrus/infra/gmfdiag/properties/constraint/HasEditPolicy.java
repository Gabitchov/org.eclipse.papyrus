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
package org.eclipse.papyrus.infra.gmfdiag.properties.constraint;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.papyrus.infra.constraints.SimpleConstraint;
import org.eclipse.papyrus.infra.constraints.constraints.AbstractConstraint;
import org.eclipse.papyrus.infra.constraints.constraints.Constraint;

/**
 * 
 * A constraint to test whether an object has the given EditPolicy or not
 * 
 * @author Camille Letavernier
 * 
 */
public class HasEditPolicy extends AbstractConstraint {

	/**
	 * The ID of the edit policy to look for
	 */
	protected String editPolicyID;

	/**
	 * {@inheritDoc}
	 */
	public boolean match(Object selection) {
		if(editPolicyID != null && selection instanceof GraphicalEditPart) {
			return ((GraphicalEditPart)selection).getEditPolicy(editPolicyID) != null;
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setDescriptor(SimpleConstraint descriptor) {
		editPolicyID = getValue("editPolicy"); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean equivalent(Constraint constraint) {
		if(constraint == null) {
			return false;
		}

		return constraint instanceof HasEditPolicy && ((HasEditPolicy)constraint).editPolicyID == editPolicyID;
	}

}
