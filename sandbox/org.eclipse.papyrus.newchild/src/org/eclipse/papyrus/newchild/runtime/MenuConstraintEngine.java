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
package org.eclipse.papyrus.newchild.runtime;

import org.eclipse.papyrus.constraints.ConstraintDescriptor;
import org.eclipse.papyrus.constraints.runtime.DefaultConstraintEngine;
import org.eclipse.papyrus.newchild.MenuRoot;
import org.eclipse.papyrus.newchild.NewchildConfiguration;


public class MenuConstraintEngine extends DefaultConstraintEngine<MenuRoot> {

	public void addConfiguration(NewchildConfiguration configuration) {
		for(MenuRoot root : configuration.getRoots()) {
			for(ConstraintDescriptor descriptor : root.getConstraints()) {
				addConstraint(descriptor);
			}
		}
	}

	@Override
	public void refresh() {
		constraints.clear();
		//Find all active Configurations
	}
}
