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

import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.views.properties.constraints.AbstractConstraint;
import org.eclipse.papyrus.views.properties.constraints.Constraint;

/**
 * Tests if the selection is an EditPart
 * 
 * @author Camille Letavernier
 */
public class IsEditPartConstraint extends AbstractConstraint {

	public boolean match(Object selection) {
		return selection instanceof EditPart;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean equivalent(Constraint constraint) {
		//TODO : This should probably not always be false
		//Potential issue : the CompositeConstraint won't be able to
		//automatically find the overriding constraints
		return false;
	}

}
