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
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.papyrus.tabbedproperties.core.listeners.NavigationListener;

import org.eclipse.uml2.uml.ObjectNode;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.papyrus.tabbedproperties.core.sections.AbstractEnhancedPropertySection;
import org.eclipse.papyrus.tabbedproperties.core.listeners.BooleanPropertyChangeListener;
import org.eclipse.papyrus.tabbedproperties.core.listeners.EmfAdapterWrapper;
import org.eclipse.papyrus.tabbedproperties.core.listeners.PropertyChangeListener;
import org.eclipse.papyrus.tabbedproperties.core.listeners.ListPropertyChangeListener;
import org.eclipse.papyrus.tabbedproperties.core.listeners.CreateElementListener;
import org.eclipse.papyrus.tabbedproperties.core.forms.PropertyEditor;
import org.eclipse.papyrus.tabbedproperties.core.forms.InputTextControls;
import org.eclipse.papyrus.tabbedproperties.core.commands.AddReferenceCommand;
import org.eclipse.papyrus.tabbedproperties.core.commands.CreateElementCommand;
import org.eclipse.papyrus.tabbedproperties.core.commands.CustomizableSetValueCommand;
import org.eclipse.papyrus.tabbedproperties.core.commands.MoveReferenceCommand;
import org.eclipse.papyrus.tabbedproperties.core.commands.RemoveReferenceCommand;
import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

import org.eclipse.papyrus.tabbedproperties.uml.figures.ObjectNodeForm;


import org.eclipse.uml2.uml.ObjectNode;
import org.eclipse.uml2.uml.ObjectNodeOrderingKind;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The ObjectNode property section for the ObjectNode element
 * 
 * An object node is an abstract activity node that is part of defining object flow in an activity.
 * Object nodes have support for token selection, limitation on the number of tokens, specifying the state required for tokens, and carrying control values.
 *
 * @generated
 */
public class ObjectNodeSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private ObjectNodeForm objectNode;

	/**
	 * The ObjectNode to edit 
	 * @generated
	 */
	private ObjectNode objectNodeElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public ObjectNodeSection() {
	
	}
	
	/**
	 * the navigation service
	 * @generated
	 **/
	private NavigationListener navigationListener= new NavigationListener(this);

    /**
     * Create the associated form
     * @return the created form
     * @generated
     */
	public PropertyEditor createFigure() {
		objectNode = new ObjectNodeForm("","An object node is an abstract activity node that is part of defining object flow in an activity."+
""+
"Object nodes have support for token selection, limitation on the number of tokens, specifying the state required for tokens, and carrying control values.");
		objectNode.setBackContext(backbone);
		return objectNode;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//Tells whether and how the tokens in the object node are ordered for selection to traverse edges outgoing from the object node.
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature ordering of ObjectNode
		PropertyChangeListener<ObjectNodeOrderingKind> orderingFormListener = new PropertyChangeListener<ObjectNodeOrderingKind>(){
		   public void propertyChanged(PropertyEditor editor, ObjectNodeOrderingKind newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, objectNodeElement, UMLPackage.eINSTANCE.getObjectNode_Ordering(), newValue);
			editingDomain.getCommandStack().execute(command);
			}
		};

		objectNode.getOrderingForm().setPropertyChangeListener(orderingFormListener);

		//---------------------------------------------------------------------
		//Tells whether the type of the object node is to be treated as control.
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature isControlType of ObjectNode
		BooleanPropertyChangeListener isControlTypeFormListener = new BooleanPropertyChangeListener(){
			public void propertyChanged(PropertyEditor editor, boolean newValue) {
			SetValueCommand command = new SetValueCommand(editingDomain,objectNodeElement, UMLPackage.eINSTANCE.getObjectNode_IsControlType(),newValue);		
			editingDomain.getCommandStack().execute(command);
			}
		};

		objectNode.getIsControlTypeForm().setPropertyChangeListener(isControlTypeFormListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
				 
														   						objectNode.getOrderingForm().setValue(objectNodeElement.getOrdering());
 
 

	

			 
				 
														   						objectNode.getIsControlTypeForm().setValue(objectNodeElement.isControlType());
 
 

	

 

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
    	this.objectNodeElement = (ObjectNode)getBusinessElement(input);
    	
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof ObjectNode;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		objectNodeElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		objectNodeElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(objectNodeElement!=null){
		objectNodeElement.eAdapters().remove(modelListener);}
		if(objectNode!=null){
		objectNode.dispose();
		}
		super.dispose();
	}

	/**
	 * Listen to change in the property from the model..
	 * @author Patrick Tessier
	 *
	 */
	public class BusinessModelListener extends EmfAdapterWrapper {
		
		/**
     	 * @{inheritDoc}
     	 * @generated
     	 */
		public void notifyChanged(Notification notification) {
			if(Notification.REMOVING_ADAPTER != notification.getEventType()){
				refresh();
			}
		}
	}

}