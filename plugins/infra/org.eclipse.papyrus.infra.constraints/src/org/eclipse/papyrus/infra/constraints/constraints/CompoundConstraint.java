/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.constraints.constraints;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * A Composite constraint. It matches a given selection if and only if
 * all its sub constraints match this selection.
 * 
 * @author Camille Letavernier
 */
public class CompoundConstraint extends AbstractConstraint {

	/**
	 * Adds a sub-constraint to this constraint
	 * 
	 * @param subConstraint
	 *        The sub-constraint to be added
	 */
	public void addConstraint(Constraint subConstraint) {
		if(subConstraint == null) {
			throw new IllegalArgumentException("The subConstraint shall not be null");
		}
		constraints.add(subConstraint);
	}

	/**
	 * A Composite Constraints matches a selection if and only if
	 * all its inner constraints match it
	 */
	@Override
	public boolean match(IStructuredSelection selection) {
		for(Constraint constraint : constraints) {
			if(!constraint.match(selection)) {
				return false;
			}
		}
		return true;
	}

	@Override
	protected boolean match(Object selection) {
		//Unused: we override AbstractConstraint#match(IStructuredSelection)
		return false;
	}

	@Override
	public boolean overrides(Constraint constraint) {
		if(constraints.size() == 0) {
			return false;
		}

		if(constraints.size() == 1) {
			return constraints.get(0).overrides(constraint);
		}

		//A Composite overrides another Composite if at least one sub-constraint overrides another one,
		//and each sub-constraint is at least equal to another one
		if(constraint instanceof CompoundConstraint) {
			boolean atLeastOneOverride = false;
			for(Constraint subConstraint : constraints) {
				boolean equalsOrOverride = false;
				for(Constraint otherSubConstraint : ((CompoundConstraint)constraint).constraints) {
					if(subConstraint.overrides(otherSubConstraint)) {
						atLeastOneOverride = true;
						break;
					}
					if(subConstraint.equals(otherSubConstraint)) {
						equalsOrOverride = true;
					}
				}

				if(!equalsOrOverride) {
					return false;
				}
			}

			if(atLeastOneOverride) {
				return true;
			}
		} else { //At least one of our constraints must override or be equal to the other constraint
			for(Constraint c : constraints) {
				if(c.overrides(constraint) || c.equals(constraint)) {
					//TODO : The equals() method is not defined for most constraint implementations.
					//We may actually need an "isEquivalent" method, defined in the Constraint Interface
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public String toString() {
		return constraints.toString();
	}

	private List<Constraint> constraints = new LinkedList<Constraint>();

	@Override
	protected boolean equivalent(Constraint constraint) {
		return false;
	}

}
