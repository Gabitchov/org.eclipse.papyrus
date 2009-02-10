/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.tabbedproperties.uml2;

import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.tabbedproperties.core.forms.ControlGroup;
import org.eclipse.papyrus.tabbedproperties.core.sections.AbstractCompositeSection;
import org.eclipse.papyrus.tabbedproperties.uml2.figures.RolesFigure;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.uml2.uml.Association;

/**
 * Show all roles of an association.
 * 
 * 
 */
public class RolesSection extends AbstractCompositeSection implements IFilter {

	public RolesSection() {
	}

	/**
	 * TODO Create the appropriate figure
	 */
	@Override
	public ControlGroup createFigure() {
		return new RolesFigure();
	}

	/**
     * 
     */
	public void initializeFigure() {
		// Nothing to do. All is done in children.

	}

	/**
	 * Create two role section as child.
	 */
	@Override
	public void createChilds() {
		// Create two roles.
		RoleSection child = new RoleSection();
		add(child);
		child = new RoleSection();
		add(child);

	}

	@Override
	public void refresh() {
		super.refresh();
		// Nothing to do. All is done in children.
	}

	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		assert (selection instanceof IStructuredSelection);
		Object input = ((IStructuredSelection) selection).getFirstElement();

		// this.namedElement = (Property)getBusinessElement(input);
		Association assoc = (Association) getBusinessElement(input);
		// Create a selection object with the sub element ?
		StructuredSelection childSelection = new StructuredSelection(assoc.getMemberEnds().get(0));
		childs.get(0).setInput(part, childSelection);
		childSelection = new StructuredSelection(assoc.getMemberEnds().get(1));
		childs.get(1).setInput(part, childSelection);
	}

	/**
	 * Return true if this section can select such element.
	 * 
	 * @param toTest
	 * @return
	 */
	public boolean select(Object toTest) {
		// return getBusinessElement(toTest) instanceof Property;
		return getBusinessElement(toTest) instanceof Association;
	}

}