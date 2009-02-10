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
package org.eclipse.papyrus.tabbedproperties.uml2.figures;

import org.eclipse.papyrus.tabbedproperties.core.forms.ControlWrapper;
import org.eclipse.papyrus.tabbedproperties.core.forms.LabeledPropertyEditor;
import org.eclipse.papyrus.tabbedproperties.core.forms.PropertyEditor;
import org.eclipse.papyrus.tabbedproperties.core.forms.RadioButtons;
import org.eclipse.papyrus.tabbedproperties.core.listeners.PropertyChangeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.uml2.uml.VisibilityKind;

public class VisibilityFigure extends LabeledPropertyEditor implements PropertyEditor {

	/**
	 * The label with its value to be set.
	 */
	protected RadioButtons<VisibilityKind> radioButtons;

	protected PropertyChangeListener<VisibilityKind> propertyChangeListener;

	public VisibilityFigure(String label, String description) {
		super(label, description);
	}

	/**
	 * Create the editor.
	 * 
	 * @param parent
	 * @param aTabbedPropertySheetPage
	 */
	public ControlWrapper createRightEditor(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		// buttons description
		Object buttonDesc[] = { "public", VisibilityKind.PUBLIC_LITERAL, "protected", VisibilityKind.PROTECTED_LITERAL, "private", VisibilityKind.PRIVATE_LITERAL, "package",
				VisibilityKind.PACKAGE_LITERAL };
		// Create buttons
		radioButtons = new RadioButtons<VisibilityKind>("Visibility", buttonDesc);

		return radioButtons;
	}

	/**
	 * @param listener
	 */
	public void setPropertyChangeListener(PropertyChangeListener<VisibilityKind> listener) {
		propertyChangeListener = listener;
		if (radioButtons != null)
			radioButtons.setPropertyChangeListener(listener);
	}

	/**
	 * Set the value of the figure.
	 * 
	 * @param visibility
	 */
	public void setValue(VisibilityKind visibility) {
		// System.out.println(this.getClass().getName() + ".setValue(" + visibility + ")");
		if (radioButtons != null) {
			radioButtons.setSelected(visibility);
		}

	}

}
