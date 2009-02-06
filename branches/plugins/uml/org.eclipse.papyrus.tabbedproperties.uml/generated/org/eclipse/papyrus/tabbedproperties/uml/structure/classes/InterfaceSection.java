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

import org.eclipse.uml2.uml.Interface;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.InterfaceFormForm;


import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Classifier;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The Interface property section for the Interface element
 * 
 *
 * @generated
 */
public class InterfaceSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private InterfaceFormForm interfaceForm;

	/**
	 * The Interface to edit 
	 * @generated
	 */
	private Interface interfaceElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public InterfaceSection() {
	
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
		interfaceForm = new InterfaceFormForm("Interface Specifications","An interface is a kind of classifier that represents a declaration of a set of coherent public features and obligations. An interface specifies a contract; any instance of a classifier that realizes the interface must fulfill that contract. The obligations that may be associated with an interface are in the form of various kinds of constraints (such as pre- and post-conditions) or protocol specifications, which may impose ordering restrictions on interactions through the interface."+
""+
"Interfaces may include receptions (in addition to operations)."+
""+
"Since an interface specifies conformance characteristics, it does not own detailed behavior specifications. Instead, interfaces may own a protocol state machine that specifies event sequences and pre/post conditions for the operations and receptions described by the interface.");
		return interfaceForm;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//mapping properties
		//---------------------------------------------------------------------
				
			 
		//more complex listener to manage 0..* feature attribute of Classifier
		ListPropertyChangeListener<Property> propertyListener =new ListPropertyChangeListener<Property>(){
			public void addValue(PropertyEditor editor, Property newValue) {
				// TODO Auto-generated method stub
				AddReferenceCommand command = new AddReferenceCommand(editingDomain,interfaceElement,UMLPackage.eINSTANCE.getClassifier_Attribute(),newValue);
				editingDomain.getCommandStack().execute(command);
			}

			public void moveValue(PropertyEditor editor, Property newValue,
					int newIndex) {
				MoveReferenceCommand command = new MoveReferenceCommand(editingDomain,interfaceElement,UMLPackage.eINSTANCE.getClassifier_Attribute(),newValue,newIndex);
				editingDomain.getCommandStack().execute(command);
				
			}

			public void removeValue(PropertyEditor editor, Property removedValue) {
				RemoveReferenceCommand command = new RemoveReferenceCommand(editingDomain,interfaceElement,UMLPackage.eINSTANCE.getClassifier_Attribute(),removedValue);
				editingDomain.getCommandStack().execute(command);	
			}
		};

		interfaceForm.getProperty().setPropertyChangeListener(propertyListener);
		//create listener to create directly element
		CreateElementListener propertyCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,interfaceElement,UMLPackage.eINSTANCE.getClassifier_Attribute(),UMLPackage.eINSTANCE.getProperty());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is not a container or it is abstract
		interfaceForm.getProperty().setCreateElement(propertyCreateListener);
		//set the navigation service
		interfaceForm.getProperty().setNavigationListener(navigationListener);

		//---------------------------------------------------------------------
		//mapping operation
		//---------------------------------------------------------------------
				
			 
		//more complex listener to manage 0..* feature ownedOperation of Interface
		ListPropertyChangeListener<Operation> operationListener =new ListPropertyChangeListener<Operation>(){
			public void addValue(PropertyEditor editor, Operation newValue) {
				// TODO Auto-generated method stub
				AddReferenceCommand command = new AddReferenceCommand(editingDomain,interfaceElement,UMLPackage.eINSTANCE.getInterface_OwnedOperation(),newValue);
				editingDomain.getCommandStack().execute(command);
			}

			public void moveValue(PropertyEditor editor, Operation newValue,
					int newIndex) {
				MoveReferenceCommand command = new MoveReferenceCommand(editingDomain,interfaceElement,UMLPackage.eINSTANCE.getInterface_OwnedOperation(),newValue,newIndex);
				editingDomain.getCommandStack().execute(command);
				
			}

			public void removeValue(PropertyEditor editor, Operation removedValue) {
				RemoveReferenceCommand command = new RemoveReferenceCommand(editingDomain,interfaceElement,UMLPackage.eINSTANCE.getInterface_OwnedOperation(),removedValue);
				editingDomain.getCommandStack().execute(command);	
			}
		};

		interfaceForm.getOperation().setPropertyChangeListener(operationListener);
		//create listener to create directly element
		CreateElementListener operationCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,interfaceElement,UMLPackage.eINSTANCE.getInterface_OwnedOperation(),UMLPackage.eINSTANCE.getOperation());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is a container and not abstract feature
		interfaceForm.getOperation().setCreateElementOnButton(operationCreateListener);
		//set the navigation service
		interfaceForm.getOperation().setNavigationListener(navigationListener);

		//---------------------------------------------------------------------
		//mapping nested classifier
		//---------------------------------------------------------------------
				
			 
		//more complex listener to manage 0..* feature nestedClassifier of Interface
		ListPropertyChangeListener<Classifier> nestedClassifierListener =new ListPropertyChangeListener<Classifier>(){
			public void addValue(PropertyEditor editor, Classifier newValue) {
				// TODO Auto-generated method stub
				AddReferenceCommand command = new AddReferenceCommand(editingDomain,interfaceElement,UMLPackage.eINSTANCE.getInterface_NestedClassifier(),newValue);
				editingDomain.getCommandStack().execute(command);
			}

			public void moveValue(PropertyEditor editor, Classifier newValue,
					int newIndex) {
				MoveReferenceCommand command = new MoveReferenceCommand(editingDomain,interfaceElement,UMLPackage.eINSTANCE.getInterface_NestedClassifier(),newValue,newIndex);
				editingDomain.getCommandStack().execute(command);
				
			}

			public void removeValue(PropertyEditor editor, Classifier removedValue) {
				RemoveReferenceCommand command = new RemoveReferenceCommand(editingDomain,interfaceElement,UMLPackage.eINSTANCE.getInterface_NestedClassifier(),removedValue);
				editingDomain.getCommandStack().execute(command);	
			}
		};

		interfaceForm.getNestedClassifier().setPropertyChangeListener(nestedClassifierListener);
		//create listener to create directly element
		CreateElementListener nestedClassifierCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,interfaceElement,UMLPackage.eINSTANCE.getInterface_NestedClassifier(),UMLPackage.eINSTANCE.getClassifier());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is not a container or it is abstract
		interfaceForm.getNestedClassifier().setCreateElement(nestedClassifierCreateListener);
		interfaceForm.getNestedClassifier().setAbstractElement(true);
		//set the navigation service
		interfaceForm.getNestedClassifier().setNavigationListener(navigationListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
						//set many referenced Element
		interfaceForm.getProperty().setValue((java.util.List)interfaceElement.eGet(UMLPackage.eINSTANCE.getClassifier_Attribute()));
	

			 
						//set many referenced Element
		interfaceForm.getOperation().setValue((java.util.List)interfaceElement.eGet(UMLPackage.eINSTANCE.getInterface_OwnedOperation()));
	

			 
						//set many referenced Element
		interfaceForm.getNestedClassifier().setValue((java.util.List)interfaceElement.eGet(UMLPackage.eINSTANCE.getInterface_NestedClassifier()));
	

 

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
    	this.interfaceElement = (Interface)getBusinessElement(input);
    	
		 // setup the backbone for referencedElementForm
		interfaceForm.getProperty().setBackboneContext(backbone);
		 // setup the backbone for referencedElementForm
		interfaceForm.getOperation().setBackboneContext(backbone);
		 // setup the backbone for referencedElementForm
		interfaceForm.getNestedClassifier().setBackboneContext(backbone);
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof Interface;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		interfaceElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		interfaceElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(interfaceElement!=null){
		interfaceElement.eAdapters().remove(modelListener);}
		if(interfaceForm!=null){
		interfaceForm.dispose();
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