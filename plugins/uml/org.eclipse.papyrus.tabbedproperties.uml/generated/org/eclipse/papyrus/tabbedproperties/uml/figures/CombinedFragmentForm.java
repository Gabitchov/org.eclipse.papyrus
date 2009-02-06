/*******************************************************************************
 * Copyright (c) 2008 CEA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     CEA - initial API and implementation
 *     Obeo
 *******************************************************************************/
package org.eclipse.papyrus.tabbedproperties.uml.figures;

//Start of user code for user imports
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import org.eclipse.papyrus.tabbedproperties.core.forms.ComboList;
import org.eclipse.papyrus.tabbedproperties.core.forms.ControlWrapper;
import org.eclipse.papyrus.tabbedproperties.core.forms.LabeledPropertyEditor;
import org.eclipse.papyrus.tabbedproperties.core.listeners.PropertyChangeListener;

//End of user code for user imports

/**
 * The CombinedFragment form
 *
 *
 * @generated
 */
public class CombinedFragmentForm extends LabeledPropertyEditor {

	protected ComboList interactionOperatorForm;
	
	/**
	 * listener that tracks modification of the displayed property
	 * @generated 
	 */
    protected PropertyChangeListener propertyChangeListener;

	/**
	 * Creates a new CombinedFragmentForm.
	 * @param label the label of the editor
	 * @generated 
	 */
    public CombinedFragmentForm(String label, String description) {
        super(label, description);
    }

    /**
     * Create the editor.
     * 
     * @param parent the parent of the editor
     * @param aTabbedPropertySheetPage the page displaying the property
     * @return the newly created editor
     * @generated
     */
    public ControlWrapper createRightEditor(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		// Start of user code to define combo description for interactionOperatorForm form
				//TODO: define combo description here
				Object comboDescInteractionOperatorForm[] = {
				        "Simple", org.eclipse.uml2.uml.AggregationKind.NONE_LITERAL,
				        "Aggregation", org.eclipse.uml2.uml.AggregationKind.SHARED_LITERAL,
				        "Composition", org.eclipse.uml2.uml.AggregationKind.COMPOSITE_LITERAL
				};
				//End of user code to define combo description for interactionOperatorForm form

				interactionOperatorForm = new ComboList(comboDescInteractionOperatorForm);
			 	
		return interactionOperatorForm;
    }

    /**
     * Sets the property change listener.
     * @param listener the property change listener to add to this editor
     * @generated
     */
    public void setPropertyChangeListener(PropertyChangeListener listener) {
    	propertyChangeListener = listener;
    	if (interactionOperatorForm != null)
    	    interactionOperatorForm.setPropertyChangeListener(listener);
    }

    /**
     * Set the value of the figure.
     * @param value the value of the property
     * @generated
     */
    public void setValue(Object value) {
		if (interactionOperatorForm != null) {
			interactionOperatorForm.setSelected(value);
		}
    }

    /**
     * @return the interactionOperatorForm
     */
    public ComboList getInteractionOperatorForm() {
        return interactionOperatorForm;
    }
}