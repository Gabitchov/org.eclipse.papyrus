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
package org.eclipse.papyrus.infra.constraints.runtime;

import java.util.Set;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.infra.constraints.ConstraintDescriptor;
import org.eclipse.papyrus.infra.constraints.DisplayUnit;

/**
 * An interface representing a Constraint Engine.
 * The Constraint Engine is responsible for retrieving the DisplayUnits
 * to display for a given ISelection.
 * 
 * @author Camille Letavernier
 */
public interface ConstraintEngine<E extends DisplayUnit> {


	public Set<E> getDisplayUnits(ISelection forSelection);

	public void addConstraint(ConstraintDescriptor descriptor);

	public void refresh();

}
