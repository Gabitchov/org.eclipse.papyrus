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
import org.eclipse.papyrus.tabbedproperties.core.forms.PropertyEditor;
import org.eclipse.papyrus.tabbedproperties.core.listeners.BooleanPropertyChangeListener;
import org.eclipse.papyrus.tabbedproperties.core.sections.AbstractCheckBoxSection;
import org.eclipse.ui.IWorkbenchPart;

/**
 * The Label section on the Button tab.
 * 
 * 
 */
public class ClassActiveSection extends AbstractCheckBoxSection<org.eclipse.uml2.uml.Class> implements IFilter {

	public ClassActiveSection() {
		super("Active:", "");
	}

	/**
	 * Create the listener on the figure change
	 * 
	 * @return
	 */
	protected BooleanPropertyChangeListener createFigurePropertyChangedListener() {
		// Listener to listen to the property change
		BooleanPropertyChangeListener editorListener = new BooleanPropertyChangeListener() {

			public void propertyChanged(PropertyEditor editor, boolean newValue) {
				// to change to send a command
				businessElement.setIsActive(newValue);
			}

		};
		return editorListener;
	}

	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		assert (selection instanceof IStructuredSelection);
		Object input = ((IStructuredSelection) selection).getFirstElement();

		this.businessElement = (org.eclipse.uml2.uml.Class) getBusinessElement(input);
	}

	@Override
	public void refresh() {
		super.refresh();
		checkboxFigure.setValue(businessElement.isActive());
	}

	/**
	 * Return true if this section can select such element.
	 * 
	 * @param toTest
	 * @return
	 */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof org.eclipse.uml2.uml.Class;
	}

}