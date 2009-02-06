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

import org.eclipse.papyrus.tabbedproperties.core.forms.CheckBoxFigure;
import org.eclipse.papyrus.tabbedproperties.core.forms.ControlWrapper;
import org.eclipse.papyrus.tabbedproperties.core.forms.LabeledPropertyEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * @author dumoulin
 * 
 */
public class LabeledQualifiersFigure extends LabeledPropertyEditor {

	private RoleQualifiersFigure qualifiers;

	/**
	 * @param label
	 */
	public LabeledQualifiersFigure(String label, String description) {
		super(label, description);
	}

	@Override
	protected ControlWrapper createRightEditor(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		qualifiers = new RoleQualifiersFigure();
		return qualifiers;
	}

	/**
	 * @return the navigable
	 */
	public CheckBoxFigure getNavigable() {
		return qualifiers.getNavigable();
	}

	/**
	 * @return the derived
	 */
	public CheckBoxFigure getDerived() {
		return qualifiers.getDerived();
	}

}
