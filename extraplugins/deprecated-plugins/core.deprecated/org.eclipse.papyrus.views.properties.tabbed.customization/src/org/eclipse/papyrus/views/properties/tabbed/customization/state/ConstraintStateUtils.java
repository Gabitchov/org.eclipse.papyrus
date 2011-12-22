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
package org.eclipse.papyrus.views.properties.tabbed.customization.state;

import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.view.constraints.AppliedStereotypeConstraintDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.AppliedStereotypeConstraintDescriptor.AppliedStereotypeConstraintDescriptorState;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.ConstraintDescriptorState;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.ObjectTypeConstraintDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.ObjectTypeConstraintDescriptor.ObjectTypeConstraintDescriptorState;

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
	public static boolean areCompatible(List<IConstraintDescriptor> constraintsToTest, List<ConstraintDescriptorState> referenceConstraints) {

		// check for each category of constraints
		// 1. Object type constraints
		// 2. stereotype constraints

		boolean classCompatible = areClassCompatibles(retrieveObjectTypeConstraint(constraintsToTest), retrieveObjectTypeConstraintState(referenceConstraints));


		boolean stereotypesCompatible = areStereotypesCompatibles(retrieveStereotypeConstraint(constraintsToTest), retrieveStereotypeConstraintState(referenceConstraints));

		return classCompatible && stereotypesCompatible;
	}

	/**
	 * @param retrieveStereotypeConstraint
	 * @param retrieveStereotypeConstraintState
	 * @return
	 */
	private static boolean areStereotypesCompatibles(AppliedStereotypeConstraintDescriptor retrieveStereotypeConstraint, AppliedStereotypeConstraintDescriptorState retrieveStereotypeConstraintState) {
		if(retrieveStereotypeConstraint == null && retrieveStereotypeConstraintState == null) {
			return true;
		} else if(retrieveStereotypeConstraint == null) {
			return true;
		} else if(retrieveStereotypeConstraintState == null) {
			return false;
		}

		String stereotypeName = (retrieveStereotypeConstraint.getStereotypeQualifiedNames().size() > 0) ? retrieveStereotypeConstraint.getStereotypeQualifiedNames().get(0) : null;
		if(stereotypeName == null) {
			return false;
		}

		String referenceStereotypeName = (retrieveStereotypeConstraintState.getStereotypesToApply().size() > 0) ? retrieveStereotypeConstraintState.getStereotypesToApply().get(0) : null;
		if(referenceStereotypeName == null) {
			return false;
		}

		return referenceStereotypeName.equalsIgnoreCase(stereotypeName);
	}

	/**
	 * @param referenceConstraints
	 * @return
	 */
	private static AppliedStereotypeConstraintDescriptorState retrieveStereotypeConstraintState(List<ConstraintDescriptorState> referenceConstraints) {
		for(ConstraintDescriptorState descriptor : referenceConstraints) {
			if(descriptor instanceof AppliedStereotypeConstraintDescriptorState) {
				return (AppliedStereotypeConstraintDescriptorState)descriptor;
			}
		}
		return null;
	}

	/**
	 * Retrieves the first stereotype constraint in the
	 * 
	 * @param constraintsToTest
	 *        the list of constraints
	 * @return the found AppliedStereotypeConstraintDescriptor or <code>null</code>
	 */
	private static AppliedStereotypeConstraintDescriptor retrieveStereotypeConstraint(List<IConstraintDescriptor> constraintsToTest) {
		for(IConstraintDescriptor descriptor : constraintsToTest) {
			if(descriptor instanceof AppliedStereotypeConstraintDescriptor) {
				return (AppliedStereotypeConstraintDescriptor)descriptor;
			}
		}
		return null;
	}

	/**
	 * Check if the constraint to test is compatible with the reference constraint
	 * 
	 * @param constraintToTest
	 *        the constraint to test
	 * @param referenceConstraint
	 *        the constraint against which the first one is tested
	 * @return <code>true</code> if both constraints are valid.
	 */
	private static boolean areClassCompatibles(Class<?> constraintClass, Class<?> referenceClass) {
		if(constraintClass == null) {
			return true;
		}
		if(referenceClass == null) {
			return false; // should never happen, but it can be hard to determine the reference class constraint from the stereotypes application (missing information at this level)
		}
		return constraintClass.isAssignableFrom(referenceClass);
	}

	/**
	 * Returns the first Object Type constraints in the list of given constraints
	 * 
	 * @param constraintsToTest
	 *        the list of constraints
	 * @return the first Object Type constraints in the list of given constraints or null
	 */
	private static Class<?> retrieveObjectTypeConstraintState(List<ConstraintDescriptorState> constraintsToTest) {
		for(ConstraintDescriptorState state : constraintsToTest) {
			if(state instanceof ObjectTypeConstraintDescriptorState) {
				return ((ObjectTypeConstraintDescriptorState)state).getElementClassState();
			}
		}
		return null;
	}

	/**
	 * Returns the first Object Type constraints in the list of given constraints
	 * 
	 * @param constraintsToTest
	 *        the list of constraints
	 * @return the first Object Type constraints in the list of given constraints or null
	 */
	private static Class<?> retrieveObjectTypeConstraint(List<IConstraintDescriptor> constraintsToTest) {
		for(IConstraintDescriptor state : constraintsToTest) {
			if(state instanceof ObjectTypeConstraintDescriptor) {
				return ((ObjectTypeConstraintDescriptor)state).getElementClass();
			}
		}

		//		// no object constraint. retrieve class constraint working with applied stereotypes
		//		for(IConstraintDescriptor state : constraintsToTest) {
		//			if(state instanceof AppliedStereotypeConstraintDescriptor) {
		//				List<String> stereotypes = ((AppliedStereotypeConstraintDescriptor)state).getStereotypeQualifiedNames();
		//				// retrieve the stereotypes using their qualified name... should have access to applied profiles
		//				
		//			}
		//		}

		return null;
	}

}
