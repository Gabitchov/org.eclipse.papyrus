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

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.constraints.Activator;
import org.eclipse.papyrus.infra.constraints.ConstraintDescriptor;
import org.eclipse.papyrus.infra.constraints.DisplayUnit;
import org.eclipse.papyrus.infra.constraints.constraints.Constraint;

/**
 * The default, generic implementation for ConstraintEngine
 * 
 * @author Camille Letavernier
 * @param <E>
 *        The type of DisplayUnit managed by this Constraint Engine
 */
public abstract class DefaultConstraintEngine<E extends DisplayUnit> implements ConstraintEngine<E> {

	/**
	 * The constraints instantiated by this Engine
	 */
	protected final Set<Constraint> constraints = new LinkedHashSet<Constraint>();

	public abstract void refresh();

	public synchronized void addConstraint(ConstraintDescriptor descriptor) {
		Constraint constraint = ConstraintFactory.getInstance().createFromModel(descriptor);
		if(constraint != null) {
			constraints.add(constraint);
		}
	}

	public synchronized Set<E> getDisplayUnits(final ISelection forSelection) {
		Set<E> result = new HashSet<E>();

		IStructuredSelection selection;
		if(forSelection instanceof IStructuredSelection) {
			selection = (IStructuredSelection)forSelection;
		} else {
			return result;
		}

		Set<Constraint> matchedConstraints = match(selection);

		return getDisplayUnits(matchedConstraints);
	}

	private Set<Constraint> match(final IStructuredSelection selection) {
		Set<Constraint> matchedConstraints = new LinkedHashSet<Constraint>();

		if(selection.isEmpty()) {
			return matchedConstraints;
		}

		for(Constraint c : constraints) {
			try {
				if(c.match(selection)) {
					matchedConstraints.add(c);
				}
			} catch (Throwable ex) {
				String errorMessage = String.format("An error occurred when executing the matching constraint %s. This constraint will be ignored", c.getDescriptor().getName());
				Activator.log.error(errorMessage, ex);
			}

		}

		//		String logValue;
		//
		//		logValue = "Filtered Constraints : "; //$NON-NLS-1$
		//		for(Constraint constraint : matchedConstraints) {
		//			logValue += constraint.getDescriptor().getName() + ", ";
		//		}
		//		Activator.log.warn(logValue);

		resolveConstraintConflicts(matchedConstraints);

		//		logValue = "Filtered Constraints : "; //$NON-NLS-1$
		//		for(Constraint constraint : matchedConstraints) {
		//			logValue += constraint.getDescriptor().getName() + ", ";
		//		}
		//
		//		Activator.log.warn(logValue);

		return matchedConstraints;
	}

	private void resolveConstraintConflicts(final Set<Constraint> matchedConstraints) {
		Set<Constraint> constraintsSet = new HashSet<Constraint>(matchedConstraints);
		for(Constraint c : constraintsSet) {
			for(Constraint c2 : constraintsSet) {
				if(c == c2) {
					continue;
				}

				if(c.getDescriptor().getOverriddenConstraints().contains(c2.getDescriptor())) {
					matchedConstraints.remove(c2);
					continue;
				}

				if(c2.getDescriptor().isOverrideable() && c.overrides(c2)) {
					matchedConstraints.remove(c2);
					continue;
				}
			}
		}
	}

	private Set<E> getDisplayUnits(final Set<Constraint> matchedConstraints) {
		Set<E> displayUnits = new LinkedHashSet<E>();
		for(Constraint c : matchedConstraints) {
			displayUnits.add((E)c.getDescriptor().getDisplay());
		}
		return displayUnits;
	}
}
