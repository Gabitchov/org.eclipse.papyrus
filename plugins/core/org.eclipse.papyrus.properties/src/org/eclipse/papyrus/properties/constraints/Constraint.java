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

import org.eclipse.papyrus.properties.contexts.ConstraintDescriptor;
import org.eclipse.papyrus.properties.contexts.View;

/**
 * An interface representing a Constraint. A Constraint is used to test if a selection
 * is matching a pre-configured property view.
 * 
 * @author Camille Letavernier
 * 
 */
public interface Constraint {

	public void setConstraintDescriptor(ConstraintDescriptor descriptor);

	public boolean match(Object selection);

	public View getView();

	public boolean overrides(Constraint constraint);

	public ConstraintDescriptor getDescriptor();
}
