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
package org.eclipse.papyrus.properties.runtime;

import org.eclipse.papyrus.properties.Activator;
import org.eclipse.papyrus.properties.constraints.CompositeConstraint;
import org.eclipse.papyrus.properties.constraints.Constraint;
import org.eclipse.papyrus.properties.contexts.ConstraintDescriptor;

public class ConstraintFactory {

	private ConstraintFactory() {

	}

	public static ConstraintFactory getInstance() {
		return instance;
	}

	public Constraint createFromModel(ConstraintDescriptor model) {
		Constraint constraint = null;
		if(model.getConstraints().isEmpty()) {
			constraint = loadConstraint(model);
		} else {
			CompositeConstraint cConstraint = new CompositeConstraint();
			for(ConstraintDescriptor descriptor : model.getConstraints()) {
				cConstraint.addConstraint(loadConstraint(descriptor));
			}

			constraint = cConstraint;
		}
		return constraint;
	}

	private Constraint loadConstraint(ConstraintDescriptor model) {
		String className = model.getConstraintType().getConstraintClass();
		Constraint constraint = null;

		try {
			constraint = (Constraint)Class.forName(className).newInstance();
			constraint.setConstraintDescriptor(model);
		} catch (ClassNotFoundException ex) {
			Activator.log.error(ex);
		} catch (IllegalAccessException ex) {
			Activator.log.error(ex);
		} catch (InstantiationException ex) {
			Activator.log.error(ex);
		} catch (ClassCastException ex) {
			Activator.log.error(ex);
		}

		return constraint;
	}

	private static ConstraintFactory instance = new ConstraintFactory();
}
