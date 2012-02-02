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

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.constraints.ConstraintDescriptor;
import org.eclipse.papyrus.infra.constraints.DisplayUnit;

/**
 * An interface representing a Constraint. A Constraint is used to test if a selection
 * is matching a pre-configured property view.
 * 
 * @author Camille Letavernier
 * 
 */
public interface Constraint {

	/**
	 * Sets the Constraint Descriptor for this constraint.
	 * The constraint descriptor may contain some parameters to configure this
	 * constraint
	 * 
	 * @param descriptor
	 *        The constraint descriptor to be associated to this constraint
	 */
	public void setConstraintDescriptor(ConstraintDescriptor descriptor);

	/**
	 * Tests if this constraint matches the given selection
	 * 
	 * @param selection
	 *        The selection to be tested against this constraint
	 * @return
	 *         True if this constraint matches the given selection
	 */
	public boolean match(IStructuredSelection selection);

	/**
	 * Returns the view associated to this constraint, or null if the constraint is associated to another
	 * kind of display unit (e.g. a section)
	 * 
	 * @return
	 *         The view associated to this constraint
	 */
	public DisplayUnit getDisplayUnit();

	/**
	 * Tests if this constraint should override the given constraint. If true,
	 * the other constraint's display unit won't be displayed. A constraint should
	 * never override itself, and you should ensure that there are no loops in the
	 * constraint overriding graph. If such a loops occurs, nothing will be displayed
	 * 
	 * @param constraint
	 *        The tested constraint
	 * @return
	 *         True if this constraint overrides the given constraint
	 */
	public boolean overrides(Constraint constraint);

	/**
	 * @return the constraint descriptor associated to this constraint
	 */
	public ConstraintDescriptor getDescriptor();
}
