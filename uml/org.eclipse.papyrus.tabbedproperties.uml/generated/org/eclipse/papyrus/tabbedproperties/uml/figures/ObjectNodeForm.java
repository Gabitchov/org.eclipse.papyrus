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
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;

import org.eclipse.papyrus.tabbedproperties.core.forms.PropertyEditor;
import org.eclipse.papyrus.tabbedproperties.core.forms.AbstractControlsGroup;

import org.eclipse.papyrus.tabbedproperties.core.forms.ComboList;
import org.eclipse.papyrus.tabbedproperties.core.forms.LabeledCheckBoxFigure;
//End of user code for user imports

/**
 * The ObjectNode form
 *
 *
 * @generated
 */ 
public class ObjectNodeForm extends AbstractControlsGroup {

	/**
	 * The label used as a title of the composite section
	 */
	private String label;
	
	/**
	 * The description used as a tool tip text of the composite
	 */
	private String description;
	
	public ObjectNodeForm(String label, String description){
		this.label=label;
		this.description=description;
	}

	protected ComboList orderingForm;
	protected LabeledCheckBoxFigure isControlTypeForm;
    
    /**
     * Creates direct children
     * @generated
     */
    public void createDirectChildren() {
		//
		// Start of user code to define combo description for orderingForm form
				//TODO: define combo description here
				Object comboDescOrderingForm[] = {
				        "Simple", org.eclipse.uml2.uml.AggregationKind.NONE_LITERAL,
				        "Aggregation", org.eclipse.uml2.uml.AggregationKind.SHARED_LITERAL,
				        "Composition", org.eclipse.uml2.uml.AggregationKind.COMPOSITE_LITERAL
				};
				//End of user code to define combo description for orderingForm form

				orderingForm = new ComboList(comboDescOrderingForm);
			 	this.add(orderingForm);
     
		//
		isControlTypeForm = new LabeledCheckBoxFigure("isControlType", "");
		this.add(isControlTypeForm);
     

    }

    /**
     * Create the composite used to lay children.
     * @generated
     */
     public Composite createLocalControls(Composite parent) {
        Composite composite = getWidgetFactory().createComposite(parent);
        composite.setToolTipText(description);
        
        //Start of user code for create local controls    	
       //RowLayout rowLayout = new RowLayout();
		FillLayout layout = new FillLayout(SWT.VERTICAL);
		
		//composite.setLayout(rowLayout);
        //layout.spacing = ITabbedPropertyConstants.HSPACE;
        composite.setLayout(layout);

    	//End of user code for create local controls
        return composite;
    }

 	    /**
     * @return the orderingForm
     */
    public ComboList getOrderingForm() {
        return orderingForm;
    }
 	
 	    /**
     * @return the isControlTypeForm
     */
    public LabeledCheckBoxFigure  getIsControlTypeForm() {
        return isControlTypeForm;
    }
 	
}