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

import org.eclipse.papyrus.tabbedproperties.core.forms.VerticalBox;

import org.eclipse.papyrus.tabbedproperties.core.forms.RadioButtons;
import org.eclipse.papyrus.tabbedproperties.core.forms.HorizontalBox;

import org.eclipse.papyrus.tabbedproperties.core.forms.LabeledCheckBoxFigure;
import org.eclipse.papyrus.tabbedproperties.core.forms.LabeledCheckBoxFigure;
import org.eclipse.papyrus.tabbedproperties.core.forms.LabeledCheckBoxFigure;
//End of user code for user imports

/**
 * The Property form
 *
 *
 * @generated
 */ 
public class PropertyForm extends AbstractControlsGroup {

	/**
	 * The label used as a title of the composite section
	 */
	private String label;
	
	/**
	 * The description used as a tool tip text of the composite
	 */
	private String description;
	
	public PropertyForm(String label, String description){
		this.label=label;
		this.description=description;
	}

	
	protected RadioButtons aggregationForm;
	
	protected LabeledCheckBoxFigure isDerivedForm;
	protected LabeledCheckBoxFigure isDerivedUnionForm;
	protected LabeledCheckBoxFigure isCompositeForm;
    
    /**
     * Creates direct children
     * @generated
     */
    public void createDirectChildren() {
		//
		VerticalBox vbox = new VerticalBox();
		this.add((PropertyEditor) vbox);
		// Start of user code to define buttons description for aggregationForm form
		//TODO: define buttons description         
		Object buttonDesc[] = { "public", org.eclipse.uml2.uml.VisibilityKind.PUBLIC_LITERAL,
								"protected", org.eclipse.uml2.uml.VisibilityKind.PROTECTED_LITERAL,
							    "private", org.eclipse.uml2.uml.VisibilityKind.PRIVATE_LITERAL,
							    "package", org.eclipse.uml2.uml.VisibilityKind.PACKAGE_LITERAL };
		//End of user code to define buttons description for aggregationForm form
		 
		// Create buttons
		aggregationForm = new RadioButtons("Aggregation",buttonDesc);
		vbox.add(aggregationForm);
		HorizontalBox hbox = new HorizontalBox();
		vbox.add((PropertyEditor) hbox);
		isDerivedForm = new LabeledCheckBoxFigure("IsDerived", "");
		hbox.add(isDerivedForm);
		isDerivedUnionForm = new LabeledCheckBoxFigure("IsDerivedUnion", "isDerivedUnion");
		hbox.add(isDerivedUnionForm);
		isCompositeForm = new LabeledCheckBoxFigure("IsComposite", "");
		hbox.add(isCompositeForm);
		 

		 
     

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
     * @return the aggregationForm
     */
    public RadioButtons getAggregationForm() {
        return aggregationForm;
    }
 	
 	
 	
 	    /**
     * @return the isDerivedForm
     */
    public LabeledCheckBoxFigure  getIsDerivedForm() {
        return isDerivedForm;
    }
 	
 	    /**
     * @return the isDerivedUnionForm
     */
    public LabeledCheckBoxFigure  getIsDerivedUnionForm() {
        return isDerivedUnionForm;
    }
 	
 	    /**
     * @return the isCompositeForm
     */
    public LabeledCheckBoxFigure  getIsCompositeForm() {
        return isCompositeForm;
    }
 	
}