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
package org.eclipse.papyrus.tabbedproperties.uml.behavior.activities;

//Start of user code for user imports
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.uml2.uml.LoopNode;
import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

import org.eclipse.papyrus.tabbedproperties.core.sections.AbstractCheckBoxSection;
import org.eclipse.papyrus.tabbedproperties.core.listeners.BooleanPropertyChangeListener;
import org.eclipse.papyrus.tabbedproperties.core.forms.PropertyEditor;

//End of user code for user imports

/**
 * The LoopNode property section for the LoopNode element
 * 
 * A loop node is a structured activity node that represents a loop with setup, test, and body sections.
 *
 * @generated
 */
public class LoopNodeSection extends AbstractCheckBoxSection<org.eclipse.uml2.uml.LoopNode> implements IFilter {

 	/**
	 * Constructor defining label
	 * @generated 
	 */
    public LoopNodeSection() {
        super("LoopNode", "used to to display the importedElement as qualifiedName");
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
            		SetValueCommand command = new SetValueCommand(editingDomain, businessElement, UMLPackage.eINSTANCE.getLoopNode_IsTestedFirst(), newValue);
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
         checkboxFigure.setValue(businessElement.isTestedFirst());
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
        
        this.businessElement = (org.eclipse.uml2.uml.LoopNode)getBusinessElement(input);
    }

    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     */
    public boolean select(Object toTest) {
        return getBusinessElement(toTest) instanceof org.eclipse.uml2.uml.LoopNode;
    }

}