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

import org.eclipse.uml2.uml.InterfaceRealization;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.InterfaceRealizationForm;


import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.BehavioredClassifier;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The InterfaceRealization property section for the InterfaceRealization element
 * 
 * An InterfaceRealization is a specialized Realization relationship between a Classifier and an Interface. This relationship signifies that the realizing classifier conforms to the contract specified by the Interface.
 *
 * @generated
 */
public class InterfaceRealizationSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private InterfaceRealizationForm interfaceRealization;

	/**
	 * The InterfaceRealization to edit 
	 * @generated
	 */
	private InterfaceRealization interfaceRealizationElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public InterfaceRealizationSection() {
	
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
		interfaceRealization = new InterfaceRealizationForm("","An interface realization is a specialized realization relationship between a classifier and an interface. This relationship signifies that the realizing classifier conforms to the contract specified by the interface.");
		interfaceRealization.setBackContext(backbone);
		return interfaceRealization;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//mapping Contract
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature contract of InterfaceRealization
		PropertyChangeListener<Interface> contractListener = new PropertyChangeListener<Interface>(){
		   public void propertyChanged(PropertyEditor editor, Interface newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, interfaceRealizationElement, UMLPackage.eINSTANCE.getInterfaceRealization_Contract(), newValue);
			editingDomain.getCommandStack().execute(command);
			}
		};

		interfaceRealization.getContract().setPropertyChangeListener(contractListener);
		//create listener to create directly element
		CreateElementListener contractCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,interfaceRealizationElement,UMLPackage.eINSTANCE.getInterfaceRealization_Contract(),UMLPackage.eINSTANCE.getInterface());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is not a container or it is abstract
		interfaceRealization.getContract().setCreateElement(contractCreateListener);
		//set the navigation service
		interfaceRealization.getContract().setNavigationListener(navigationListener);

		//---------------------------------------------------------------------
		//mapping implementing Classifier
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature implementingClassifier of InterfaceRealization
		PropertyChangeListener<BehavioredClassifier> implementingClassifierListener = new PropertyChangeListener<BehavioredClassifier>(){
		   public void propertyChanged(PropertyEditor editor, BehavioredClassifier newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, interfaceRealizationElement, UMLPackage.eINSTANCE.getInterfaceRealization_ImplementingClassifier(), newValue);
			editingDomain.getCommandStack().execute(command);
			}
		};

		interfaceRealization.getImplementingClassifier().setPropertyChangeListener(implementingClassifierListener);
		//create listener to create directly element
		CreateElementListener implementingClassifierCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,interfaceRealizationElement,UMLPackage.eINSTANCE.getInterfaceRealization_ImplementingClassifier(),UMLPackage.eINSTANCE.getBehavioredClassifier());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is not a container or it is abstract
		interfaceRealization.getImplementingClassifier().setCreateElement(implementingClassifierCreateListener);
		interfaceRealization.getImplementingClassifier().setAbstractElement(true);
		//set the navigation service
		interfaceRealization.getImplementingClassifier().setNavigationListener(navigationListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
				 
														   				 
		//set simple Referenced Element
		if(interfaceRealizationElement.getContract()==null){
		    interfaceRealization.getContract().setValue("<UNDEFINED>");}
		else{
			interfaceRealization.getContract().setValue(interfaceRealizationElement.getContract().getQualifiedName());
			navigationListener.setTheElement(interfaceRealizationElement.getContract());
			}
							
 
 

	

			 
				 
														   				 
		//set simple Referenced Element
		if(interfaceRealizationElement.getImplementingClassifier()==null){
		    interfaceRealization.getImplementingClassifier().setValue("<UNDEFINED>");}
		else{
			interfaceRealization.getImplementingClassifier().setValue(interfaceRealizationElement.getImplementingClassifier().getQualifiedName());
			navigationListener.setTheElement(interfaceRealizationElement.getImplementingClassifier());
			}
							
 
 

	

 

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
    	this.interfaceRealizationElement = (InterfaceRealization)getBusinessElement(input);
    	
		 // setup the backbone for referencedElementForm
		interfaceRealization.getContract().setBackboneContext(backbone);
		 // setup the backbone for referencedElementForm
		interfaceRealization.getImplementingClassifier().setBackboneContext(backbone);
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof InterfaceRealization;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		interfaceRealizationElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		interfaceRealizationElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(interfaceRealizationElement!=null){
		interfaceRealizationElement.eAdapters().remove(modelListener);}
		if(interfaceRealization!=null){
		interfaceRealization.dispose();
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