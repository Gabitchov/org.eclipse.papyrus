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
package org.eclipse.papyrus.views.properties.runtime;

import org.eclipse.papyrus.infra.constraints.CompositeConstraint;
import org.eclipse.papyrus.infra.constraints.ConstraintDescriptor;
import org.eclipse.papyrus.infra.constraints.SimpleConstraint;
import org.eclipse.papyrus.infra.constraints.constraints.CompoundConstraint;
import org.eclipse.papyrus.infra.constraints.constraints.Constraint;
import org.eclipse.papyrus.infra.tools.util.ClassLoaderHelper;
import org.eclipse.papyrus.views.properties.Activator;

/**
 * A Singleton class for creating {@link Constraint}s from a {@link ConstraintDescriptor}
 * 
 * @author Camille Letavernier
 */
public class ConstraintFactory {

	private ConstraintFactory() {

	}

	/**
	 * @return the singleton instance
	 */
	public static ConstraintFactory getInstance() {
		return instance;
	}

	/**
	 * Creates a new Constraint from the given ConstraintDescriptor
	 * 
	 * @param model
	 *        The ConstraintDescriptor describing the Constraint
	 * @return
	 *         The new constraint instance
	 */
	public Constraint createFromModel(ConstraintDescriptor model) {
		Constraint constraint = null;
		try {
			if(model instanceof CompositeConstraint) {
				CompoundConstraint cConstraint = new CompoundConstraint();
				cConstraint.setConstraintDescriptor(model);
				for(SimpleConstraint descriptor : ((CompositeConstraint)model).getConstraints()) {
					Constraint subConstraint = loadConstraint(descriptor);
					cConstraint.addConstraint(subConstraint);
				}

				constraint = cConstraint;
			} else {
				constraint = loadConstraint((SimpleConstraint)model);
			}
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
		return constraint;
	}

	private Constraint loadConstraint(SimpleConstraint model) {
		String className = model.getConstraintType().getConstraintClass();
		Constraint constraint = null;

		if(model.getConstraintType().eIsProxy()) {
			Activator.log.error("The constraint URI cannot be resolved. Constraint : " + model.getName() + ". " + model.getConstraintType(), null);
			return null;
		}

		constraint = ClassLoaderHelper.newInstance(className, Constraint.class);
		if(constraint == null) {
			Activator.log.warn("Cannot load constraint " + model.getName()); //$NON-NLS-1$
			return null;
		}
		constraint.setConstraintDescriptor(model);

		return constraint;
	}

	private static ConstraintFactory instance = new ConstraintFactory();
}
