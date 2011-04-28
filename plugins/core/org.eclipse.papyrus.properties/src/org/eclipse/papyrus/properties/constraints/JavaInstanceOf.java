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
package org.eclipse.papyrus.properties.constraints;

import org.eclipse.papyrus.properties.contexts.ConfigProperty;
import org.eclipse.papyrus.properties.contexts.ConstraintDescriptor;
import org.eclipse.papyrus.properties.contexts.ValueProperty;
import org.eclipse.papyrus.properties.util.ClassLoader;

public class JavaInstanceOf extends AbstractConstraint {

	private Class<?> clazz;

	@Override
	public void setConstraintDescriptor(ConstraintDescriptor descriptor) {
		super.setConstraintDescriptor(descriptor);
		ClassLoader loader = new ClassLoader();
		for(ConfigProperty property : descriptor.getProperties()) {
			if(property.getName().equals("class") && property instanceof ValueProperty) { //$NON-NLS-1$
				clazz = loader.loadClass(((ValueProperty)property).getValue());
			}
		}
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
