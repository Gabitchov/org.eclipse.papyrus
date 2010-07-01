/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.tabbed.customization.state;

import java.util.List;

import org.eclipse.papyrus.properties.runtime.view.constraints.ConstraintDescriptorState;

/**
 * Utility class for constraint states
 */
public class ConstraintStateUtils {

	/**
	 * checks if the 2 sets of constraints are compatible. constraints of specific categories are compared one to each other
	 * 
	 * @param constraintsToTest
	 *        set of constraints to test
	 * @param referenceConstraints
	 *        the second set of constraints, against which constraints are tested
	 * @return <code>true</code> if the 2 sets of constraints
	 */
	public static boolean areCompatible(List<ConstraintDescriptorState> constraintsToTest, List<ConstraintDescriptorState> referenceConstraints) {

		// check for each category of constraints
		// 1. Object type constraints
		// 2. stereotype constraints

		return true;
	}

}
