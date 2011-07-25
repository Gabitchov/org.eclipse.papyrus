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
package org.eclipse.papyrus.newchild.policies;

import org.eclipse.papyrus.constraints.ConstraintDescriptor;
import org.eclipse.papyrus.constraints.runtime.DefaultConstraintEngine;
import org.eclipse.papyrus.newchild.NewchildConfiguration;
import org.eclipse.papyrus.newchild.ncpolicy.NewChildPolicySet;


public class PolicyManager extends DefaultConstraintEngine<NewChildPolicySet> {

	@Override
	public void refresh() {
		//TODO
	}

	public void addConfiguration(NewchildConfiguration configuration) {
		for(NewChildPolicySet policy : configuration.getNewChildPolicies()) {
			for(ConstraintDescriptor descriptor : policy.getConstraints()) {
				addConstraint(descriptor);
			}
		}
	}

}
