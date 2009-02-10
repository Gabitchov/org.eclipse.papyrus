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
package org.eclipse.papyrus.tabbedproperties.uml.behavior.commonbehaviors;

//Start of user code for user imports
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

import org.eclipse.papyrus.tabbedproperties.core.sections.AbstractCheckBoxSection;
import org.eclipse.papyrus.tabbedproperties.core.listeners.BooleanPropertyChangeListener;
import org.eclipse.papyrus.tabbedproperties.core.forms.PropertyEditor;

//End of user code for user imports

/**
 * The TimeObservation property section for the TimeObservation element
 * 
 * A time observation is a reference to a time instant during an execution. It points out the element in the model to observe and whether the observation is when this model element is entered or when it is exited.
 *
 * @generated
 */
public class TimeObservationSection extends AbstractCheckBoxSection<org.eclipse.uml2.uml.TimeObservation> implements IFilter {

 	/**
	 * Constructor defining label
	 * @generated 
	 */
    public TimeObservationSection() {
        super("TimeObservation", "A time observation is a reference to a time instant during an execution. It points out the element in the model to observe and whether the observation is when this model element is entered or when it is exited.");
    }

    /**
     * Create the listener on the figure change
     * @return model element listener
     * @generated 
     */
   protected BooleanPropertyChangeListener createFigurePropertyChangedListener() {
        // Listener to listen to the property change
        BooleanPropertyChangeListener editorListener = new BooleanPropertyChangeListener(){

			public void propertyChanged(PropertyEditor editor, boolean newValue) {
            	if (editingDomain != null) {
            		SetValueCommand command = new SetValueCommand(editingDomain, businessElement, UMLPackage.eINSTANCE.getTimeObservation_FirstEvent(), newValue);
            		editingDomain.getCommandStack().execute(command);
            	}
            }
            
        };
        return editorListener;
    }
    
   /**
     * @{inheritDoc}
     * @generated
     */
    @Override
    public void refresh() {
         super.refresh();
         checkboxFigure.setValue(businessElement.isFirstEvent());
    }
    
    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
    public void setInput(IWorkbenchPart part, ISelection selection) {
        super.setInput(part, selection);
        assert(selection instanceof IStructuredSelection);
        Object input = ((IStructuredSelection) selection).getFirstElement();
        
        this.businessElement = (org.eclipse.uml2.uml.TimeObservation)getBusinessElement(input);
    }

    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     */
    public boolean select(Object toTest) {
        return getBusinessElement(toTest) instanceof org.eclipse.uml2.uml.TimeObservation;
    }

}