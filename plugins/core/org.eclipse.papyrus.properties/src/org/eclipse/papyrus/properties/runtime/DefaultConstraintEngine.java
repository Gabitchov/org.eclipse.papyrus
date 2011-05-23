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

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.properties.constraints.Constraint;
import org.eclipse.papyrus.properties.contexts.ConstraintDescriptor;
import org.eclipse.papyrus.properties.contexts.Context;
import org.eclipse.papyrus.properties.contexts.View;
import org.eclipse.papyrus.properties.util.ClassLoader;

/**
 * The default implementation for ConstraintEngine
 * 
 * @author Camille Letavernier
 */
public class DefaultConstraintEngine implements ConstraintEngine {

	private final Set<Constraint> constraints = new LinkedHashSet<Constraint>();

	public void contextChanged() {
		constraints.clear();
		Collection<Context> contexts = ConfigurationManager.instance.getEnabledContexts();
		for(Context context : contexts) {
			addContext(context);
		}
	}

	public void addContext(final Context context) {
		ClassLoader loader = new ClassLoader();

		for(View view : context.getViews()) {
			for(ConstraintDescriptor descriptor : view.getConstraints()) {
				Constraint constraint = ConstraintFactory.getInstance().createFromModel(descriptor);
				if(constraint != null) {
					constraints.add(constraint);
				}
			}
		}
	}

	public Set<View> getViews(final ISelection forSelection) {
		Set<View> result = new HashSet<View>();

		IStructuredSelection selection;
		if(forSelection instanceof IStructuredSelection) {
			selection = (IStructuredSelection)forSelection;
		} else {
			return result;
		}

		Set<Constraint> matchedConstraints = match(selection);

		return getViews(matchedConstraints);
	}

	private Set<Constraint> match(final IStructuredSelection selection) {
		Set<Constraint> matchedConstraints = new LinkedHashSet<Constraint>();

		for(Constraint c : constraints) {
			int elementMultiplicity = c.getView().getElementMultiplicity();
			int selectionSize = selection.size();
			if(elementMultiplicity == 1) {
				if(selectionSize == 1) {
					if(c.match(selection.getFirstElement())) {
						matchedConstraints.add(c);
					}
				}
			} else if(elementMultiplicity == selectionSize || elementMultiplicity < 0) {
				boolean allMatch = true;
				Iterator<?> selectionIterator = selection.iterator();
				while(selectionIterator.hasNext()) {
					Object selectedItem = selectionIterator.next();
					if(!c.match(selectedItem)) {
						allMatch = false;
						break;
					}
				}
				if(allMatch) {
					matchedConstraints.add(c);
				}
			}
		}

		//		String logValue;

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

	private Set<View> getViews(final Set<Constraint> matchedConstraints) {
		Set<View> views = new LinkedHashSet<View>();
		for(Constraint c : matchedConstraints) {
			views.add(c.getView());
		}
		return views;
	}
}
