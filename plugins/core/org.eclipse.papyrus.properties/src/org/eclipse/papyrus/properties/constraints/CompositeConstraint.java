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
package org.eclipse.papyrus.properties.constraints;

import java.util.LinkedList;
import java.util.List;

/**
 * A Composite constraint. It matches a given selection if and only if
 * all its sub constraints match this selection.
 * 
 * @author Camille Letavernier
 */
public class CompositeConstraint extends AbstractConstraint {

	public void addConstraint(Constraint constraint) {
		constraints.add(constraint);
	}

	/**
	 * A Composite Constraints matches a selection if and only if
	 * all its inner constraints match it
	 */
	public boolean match(Object selection) {
		for(Constraint constraint : constraints) {
			if(!constraint.match(selection))
				return false;
		}
		return true;
	}

	@Override
	public boolean overrides(Constraint constraint) {
		for(Constraint c : constraints) {
			if(c.overrides(constraint))
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return constraints.toString();
	}

	private List<Constraint> constraints = new LinkedList<Constraint>();

}
