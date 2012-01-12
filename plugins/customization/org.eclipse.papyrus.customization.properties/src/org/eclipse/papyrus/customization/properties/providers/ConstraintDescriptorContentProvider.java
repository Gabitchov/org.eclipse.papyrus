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
package org.eclipse.papyrus.customization.properties.providers;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.constraints.ConstraintDescriptor;
import org.eclipse.papyrus.infra.constraints.DisplayUnit;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.contexts.Section;
import org.eclipse.papyrus.views.properties.contexts.Tab;
import org.eclipse.papyrus.views.properties.contexts.View;

/**
 * A ContentProvider for retrieving the available ConstraintDescriptors
 * 
 * 
 * @author Camille Letavernier
 */
public class ConstraintDescriptorContentProvider extends AbstractContextualContentProvider {

	private EClass type;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param source
	 *        The source Object used to retrieve the available ConstraintDescriptors
	 */
	public ConstraintDescriptorContentProvider(EObject source, EClass type) {
		super(source);
		this.type = type;
	}

	public Object[] getElements() {
		List<ConstraintDescriptor> result = new LinkedList<ConstraintDescriptor>();
		for(Context context : contexts) {
			for(View view : context.getViews()) {
				result.addAll(getFilteredConstraintsFromDisplayUnit(view));
			}
			for(Tab tab : context.getTabs()) {
				for(Section section : tab.getSections()) {
					result.addAll(getFilteredConstraintsFromDisplayUnit(section));
				}
			}
		}
		return result.toArray();
	}

	private List<ConstraintDescriptor> getFilteredConstraintsFromDisplayUnit(DisplayUnit unit) {
		List<ConstraintDescriptor> result = new LinkedList<ConstraintDescriptor>();
		for(ConstraintDescriptor constraint : unit.getConstraints()) {
			if(type.isInstance(constraint)) {
				result.add(constraint);
			}
		}
		return result;
	}

	public Object[] getElements(Object inputElement) {
		return getElements();
	}

}
