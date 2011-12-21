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
package org.eclipse.papyrus.infra.constraints.constraints;

import org.eclipse.papyrus.infra.constraints.SimpleConstraint;
import org.eclipse.papyrus.infra.tools.util.ClassLoaderHelper;

/**
 * A Constraint to test if an object is an instance of a given
 * Java class
 * 
 * @author Camille Letavernier
 */
public class JavaInstanceOf extends AbstractConstraint {

	private Class<?> clazz;

	@Override
	public void setDescriptor(SimpleConstraint descriptor) {
		clazz = ClassLoaderHelper.loadClass(getValue("class")); //$NON-NLS-1$
	}

	public boolean match(Object selection) {
		if(clazz == null) {
			return false;
		}

		return clazz.isInstance(selection);
	}

	@Override
	protected boolean equivalent(Constraint constraint) {
		return false; //TODO
	}

}
