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

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.properties.Activator;
import org.eclipse.papyrus.properties.constraints.Constraint;
import org.eclipse.papyrus.properties.contexts.ConstraintDescriptor;
import org.eclipse.papyrus.properties.contexts.Context;
import org.eclipse.papyrus.properties.contexts.View;
import org.eclipse.papyrus.properties.root.PropertiesRoot;
import org.eclipse.papyrus.properties.util.ClassLoader;

public class DefaultConstraintEngine implements ConstraintEngine {

	private IStructuredSelection selection;

	private Set<Constraint> constraints = new LinkedHashSet<Constraint>();

	private Set<Constraint> matchedConstraints = new LinkedHashSet<Constraint>();

	public DefaultConstraintEngine() {
	}

	public void contextChanged() {
		constraints.clear();
		ConfigurationManager configManager = ConfigurationManager.instance;
		PropertiesRoot root = configManager.getPropertiesRoot();
		List<Context> contexts = root.getContexts();
		for(Context context : contexts) {
			addContext(context);
		}
	}

	public void addContext(Context context) {
		ClassLoader loader = new ClassLoader();

		for(View view : context.getViews()) {
			for(ConstraintDescriptor descriptor : view.getConstraints()) {
				String className = descriptor.getConstraintType().getConstraintClass();
				try {
					Class<? extends Constraint> clazz = loader.loadClass(className).asSubclass(Constraint.class);
					Constraint constraint = clazz.newInstance();
					constraint.setConstraintDescriptor(descriptor);
					constraints.add(constraint);
				} catch (Exception ex) {
					Activator.log.error(ex);
				}
			}
		}
	}

	public void setSelection(ISelection selection) {
		if(selection instanceof IStructuredSelection)
			this.selection = (IStructuredSelection)selection;
		else
			this.selection = null;
	}

	@SuppressWarnings("rawtypes")
	public boolean match() {
		matchedConstraints.clear();

		if(selection == null)
			return false;

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
				Iterator selectionIterator = selection.iterator();
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

		resolveConstraintConflicts();
		Activator.log.debug("Filtered Constraints : " + matchedConstraints); //$NON-NLS-1$
		return matchedConstraints.size() > 0;
	}

	public void resolveConstraintConflicts() {
		Set<Constraint> constraintsSet = new HashSet<Constraint>(matchedConstraints);
		for(Constraint c : constraintsSet) {
			for(Constraint c2 : constraintsSet) {
				if(c == c2)
					continue;

				if(c.overrides(c2)) {
					matchedConstraints.remove(c2);
				}
			}
		}
	}

	public Set<View> getViews() {
		Set<View> views = new LinkedHashSet<View>();
		for(Constraint c : matchedConstraints) {
			views.add(c.getView());
		}
		return views;
	}
}
