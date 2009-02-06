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
import org.eclipse.uml2.uml.AggregationKind;

/**
 * A property figure showing the aggregationKind
 * 
 * @author dumoulin
 * 
 */
public class AggregationKindFigure extends LabeledPropertyEditor {

	protected String label;

	/**
	 * User listener ?
	 */
	protected PropertyChangeListener<AggregationKind> propertyChangeListener;

	private ComboList<AggregationKind> combo;

	/**
     * 
     */
	public AggregationKindFigure() {
		super("Aggr.Kind", "");
	}

	/**
     * 
     */
	public AggregationKindFigure(String label, String description) {
		super(label, description);
	}

	/**
	 * Set a listener on property changed
	 * 
	 * @param listener
	 */
	public void setPropertyChangeListener(PropertyChangeListener<AggregationKind> listener) {
		propertyChangeListener = listener;
		if (combo != null)
			combo.setPropertyChangeListener(listener);
	}

	/**
	 * Set the value of the figure.
	 * 
	 * @param visibility
	 */
	public void setValue(AggregationKind visibility) {
		combo.setSelected(visibility);

	}

	/**
	 * Create control associated to this figure.
	 */
	@Override
	protected ControlWrapper createRightEditor(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {

		Object comboDesc[] = { "Simple", AggregationKind.NONE_LITERAL, "Aggregation", AggregationKind.SHARED_LITERAL, "Composition", AggregationKind.COMPOSITE_LITERAL };
		combo = new ComboList<AggregationKind>(comboDesc);
		return combo;
	}

}
