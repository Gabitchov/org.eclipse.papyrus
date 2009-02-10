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

import org.eclipse.papyrus.tabbedproperties.core.forms.ComboList;
import org.eclipse.papyrus.tabbedproperties.core.forms.ControlWrapper;
import org.eclipse.papyrus.tabbedproperties.core.forms.LabeledPropertyEditor;
import org.eclipse.papyrus.tabbedproperties.core.listeners.PropertyChangeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * A property figure showing the multiplicity
 * 
 * @author dumoulin
 * 
 */
public class LabeledMultiplicityFigure extends LabeledPropertyEditor {

	/**
	 * User listener ?
	 */
	protected PropertyChangeListener<String> propertyChangeListener;

	private ComboList<String> combo;

	/**
     * 
     */
	public LabeledMultiplicityFigure() {
		super("Multiplicity:", "");
	}

	/**
     * 
     */
	public LabeledMultiplicityFigure(String label, String description) {
		super(label, description);
	}

	/**
	 * Set a listener on property changed
	 * 
	 * @param listener
	 */
	public void setPropertyChangeListener(PropertyChangeListener<String> listener) {
		propertyChangeListener = listener;
		if (combo != null)
			combo.setPropertyChangeListener(listener);
	}

	/**
	 * Set the value of the figure.
	 * 
	 * @param visibility
	 */
	public void setValue(String visibility) {
		combo.setSelected(visibility);

	}

	/**
	 * Set selectable values to be shonw by the figure
	 * 
	 * @param labelsAndValues
	 */
	public void setSelectableValues(String[] labelsAndValues) {
		combo.setSelectableValues(labelsAndValues);
	}

	/**
	 * Create control associated to this figure.
	 */
	@Override
	protected ControlWrapper createRightEditor(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {

		combo = new ComboList<String>();
		return combo;
	}

}
