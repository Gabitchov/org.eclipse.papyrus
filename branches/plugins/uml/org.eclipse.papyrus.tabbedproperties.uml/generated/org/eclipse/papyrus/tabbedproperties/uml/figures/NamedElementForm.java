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

import org.eclipse.papyrus.tabbedproperties.core.forms.InputTextControls;
import org.eclipse.papyrus.tabbedproperties.core.forms.RadioButtons;
//End of user code for user imports

/**
 * The NamedElement form
 *
 * this is the form for all named Element
 *
 * @generated
 */ 
public class NamedElementForm extends AbstractControlsGroup {

	/**
	 * The label used as a title of the composite section
	 */
	private String label;
	
	/**
	 * The description used as a tool tip text of the composite
	 */
	private String description;
	
	public NamedElementForm(String label, String description){
		this.label=label;
		this.description=description;
	}

	protected InputTextControls nameForm;
	protected RadioButtons visibilityForm;
    
    /**
     * Creates direct children
     * @generated
     */
    public void createDirectChildren() {
		//this is the form to display the name
		nameForm = new InputTextControls("Name", "this is the form to display the name");
		 this.add(nameForm);
     
		//this is a form to display the visibility
		// Start of user code to define buttons description for visibilityForm form
		//TODO: define buttons description         
		Object buttonDesc[] = { "public", org.eclipse.uml2.uml.VisibilityKind.PUBLIC_LITERAL,
								"protected", org.eclipse.uml2.uml.VisibilityKind.PROTECTED_LITERAL,
							    "private", org.eclipse.uml2.uml.VisibilityKind.PRIVATE_LITERAL,
							    "package", org.eclipse.uml2.uml.VisibilityKind.PACKAGE_LITERAL };
		//End of user code to define buttons description for visibilityForm form
		 
		// Create buttons
		visibilityForm = new RadioButtons("Visibility",buttonDesc);
		this.add(visibilityForm);
     

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
     * @return the nameForm
     */
    public InputTextControls getNameForm() {
        return nameForm;
    }
 	
 	    /**
     * @return the visibilityForm
     */
    public RadioButtons getVisibilityForm() {
        return visibilityForm;
    }
 	
}