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
package org.eclipse.papyrus.tabbedproperties.uml.structure.classes;

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

import org.eclipse.uml2.uml.InstanceSpecification;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.InstanceSpecificationFormForm;


import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Slot;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The InstanceSpecification property section for the InstanceSpecification element
 * 
 * An instance specification is a model element that represents an instance in a modeled system
 *
 * @generated
 */
public class InstanceSpecificationSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private InstanceSpecificationFormForm instanceSpecificationForm;

	/**
	 * The InstanceSpecification to edit 
	 * @generated
	 */
	private InstanceSpecification instanceSpecificationElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public InstanceSpecificationSection() {
	
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
		instanceSpecificationForm = new InstanceSpecificationFormForm("Instance Specification Specifications","An instance specification is a model element that represents an instance in a modeled system."+
""+
"An instance specification has the capability of being a deployment target in a deployment relationship, in the case that it is an instance of a node. It is also has the capability of being a deployed artifact, if it is an instance of an artifact.");
		return instanceSpecificationForm;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//mapping classifier
		//---------------------------------------------------------------------
				
			 
		//more complex listener to manage 0..* feature classifier of InstanceSpecification
		ListPropertyChangeListener<Classifier> classifierListener =new ListPropertyChangeListener<Classifier>(){
			public void addValue(PropertyEditor editor, Classifier newValue) {
				// TODO Auto-generated method stub
				AddReferenceCommand command = new AddReferenceCommand(editingDomain,instanceSpecificationElement,UMLPackage.eINSTANCE.getInstanceSpecification_Classifier(),newValue);
				editingDomain.getCommandStack().execute(command);
			}

			public void moveValue(PropertyEditor editor, Classifier newValue,
					int newIndex) {
				MoveReferenceCommand command = new MoveReferenceCommand(editingDomain,instanceSpecificationElement,UMLPackage.eINSTANCE.getInstanceSpecification_Classifier(),newValue,newIndex);
				editingDomain.getCommandStack().execute(command);
				
			}

			public void removeValue(PropertyEditor editor, Classifier removedValue) {
				RemoveReferenceCommand command = new RemoveReferenceCommand(editingDomain,instanceSpecificationElement,UMLPackage.eINSTANCE.getInstanceSpecification_Classifier(),removedValue);
				editingDomain.getCommandStack().execute(command);	
			}
		};

		instanceSpecificationForm.getClassifier().setPropertyChangeListener(classifierListener);
		//create listener to create directly element
		CreateElementListener classifierCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,instanceSpecificationElement,UMLPackage.eINSTANCE.getInstanceSpecification_Classifier(),UMLPackage.eINSTANCE.getClassifier());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is not a container or it is abstract
		instanceSpecificationForm.getClassifier().setCreateElement(classifierCreateListener);
		instanceSpecificationForm.getClassifier().setAbstractElement(true);
		//set the navigation service
		instanceSpecificationForm.getClassifier().setNavigationListener(navigationListener);

		//---------------------------------------------------------------------
		//mapping slot
		//---------------------------------------------------------------------
				
			 
		//more complex listener to manage 0..* feature slot of InstanceSpecification
		ListPropertyChangeListener<Slot> slotListener =new ListPropertyChangeListener<Slot>(){
			public void addValue(PropertyEditor editor, Slot newValue) {
				// TODO Auto-generated method stub
				AddReferenceCommand command = new AddReferenceCommand(editingDomain,instanceSpecificationElement,UMLPackage.eINSTANCE.getInstanceSpecification_Slot(),newValue);
				editingDomain.getCommandStack().execute(command);
			}

			public void moveValue(PropertyEditor editor, Slot newValue,
					int newIndex) {
				MoveReferenceCommand command = new MoveReferenceCommand(editingDomain,instanceSpecificationElement,UMLPackage.eINSTANCE.getInstanceSpecification_Slot(),newValue,newIndex);
				editingDomain.getCommandStack().execute(command);
				
			}

			public void removeValue(PropertyEditor editor, Slot removedValue) {
				RemoveReferenceCommand command = new RemoveReferenceCommand(editingDomain,instanceSpecificationElement,UMLPackage.eINSTANCE.getInstanceSpecification_Slot(),removedValue);
				editingDomain.getCommandStack().execute(command);	
			}
		};

		instanceSpecificationForm.getSlot().setPropertyChangeListener(slotListener);
		//create listener to create directly element
		CreateElementListener slotCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,instanceSpecificationElement,UMLPackage.eINSTANCE.getInstanceSpecification_Slot(),UMLPackage.eINSTANCE.getSlot());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is a container and not abstract feature
		instanceSpecificationForm.getSlot().setCreateElementOnButton(slotCreateListener);
		//set the navigation service
		instanceSpecificationForm.getSlot().setNavigationListener(navigationListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
						//set many referenced Element
		instanceSpecificationForm.getClassifier().setValue((java.util.List)instanceSpecificationElement.eGet(UMLPackage.eINSTANCE.getInstanceSpecification_Classifier()));
	

			 
						//set many referenced Element
		instanceSpecificationForm.getSlot().setValue((java.util.List)instanceSpecificationElement.eGet(UMLPackage.eINSTANCE.getInstanceSpecification_Slot()));
	

 

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
    	this.instanceSpecificationElement = (InstanceSpecification)getBusinessElement(input);
    	
		 // setup the backbone for referencedElementForm
		instanceSpecificationForm.getClassifier().setBackboneContext(backbone);
		 // setup the backbone for referencedElementForm
		instanceSpecificationForm.getSlot().setBackboneContext(backbone);
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof InstanceSpecification;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		instanceSpecificationElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		instanceSpecificationElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(instanceSpecificationElement!=null){
		instanceSpecificationElement.eAdapters().remove(modelListener);}
		if(instanceSpecificationForm!=null){
		instanceSpecificationForm.dispose();
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