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

import org.eclipse.uml2.uml.DataType;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.DataTypeFormForm;


import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Operation;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The DataType property section for the DataType element
 * 
 * A data type is a type whose instances are identified only by their value. A DataType may contain attributes to support the modeling of structured data types.
 *
 * @generated
 */
public class DataTypeSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private DataTypeFormForm dataTypeForm;

	/**
	 * The DataType to edit 
	 * @generated
	 */
	private DataType dataTypeElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public DataTypeSection() {
	
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
		dataTypeForm = new DataTypeFormForm("DataType Specifications","A data type is a type whose instances are identified only by their value. A data type may contain attributes to support the modeling of structured data types.");
		return dataTypeForm;
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
				AddReferenceCommand command = new AddReferenceCommand(editingDomain,dataTypeElement,UMLPackage.eINSTANCE.getClassifier_Attribute(),newValue);
				editingDomain.getCommandStack().execute(command);
			}

			public void moveValue(PropertyEditor editor, Property newValue,
					int newIndex) {
				MoveReferenceCommand command = new MoveReferenceCommand(editingDomain,dataTypeElement,UMLPackage.eINSTANCE.getClassifier_Attribute(),newValue,newIndex);
				editingDomain.getCommandStack().execute(command);
				
			}

			public void removeValue(PropertyEditor editor, Property removedValue) {
				RemoveReferenceCommand command = new RemoveReferenceCommand(editingDomain,dataTypeElement,UMLPackage.eINSTANCE.getClassifier_Attribute(),removedValue);
				editingDomain.getCommandStack().execute(command);	
			}
		};

		dataTypeForm.getProperty().setPropertyChangeListener(propertyListener);
		//create listener to create directly element
		CreateElementListener propertyCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,dataTypeElement,UMLPackage.eINSTANCE.getClassifier_Attribute(),UMLPackage.eINSTANCE.getProperty());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is not a container or it is abstract
		dataTypeForm.getProperty().setCreateElement(propertyCreateListener);
		//set the navigation service
		dataTypeForm.getProperty().setNavigationListener(navigationListener);

		//---------------------------------------------------------------------
		//mapping operation
		//---------------------------------------------------------------------
				
			 
		//more complex listener to manage 0..* feature ownedOperation of DataType
		ListPropertyChangeListener<Operation> operationListener =new ListPropertyChangeListener<Operation>(){
			public void addValue(PropertyEditor editor, Operation newValue) {
				// TODO Auto-generated method stub
				AddReferenceCommand command = new AddReferenceCommand(editingDomain,dataTypeElement,UMLPackage.eINSTANCE.getDataType_OwnedOperation(),newValue);
				editingDomain.getCommandStack().execute(command);
			}

			public void moveValue(PropertyEditor editor, Operation newValue,
					int newIndex) {
				MoveReferenceCommand command = new MoveReferenceCommand(editingDomain,dataTypeElement,UMLPackage.eINSTANCE.getDataType_OwnedOperation(),newValue,newIndex);
				editingDomain.getCommandStack().execute(command);
				
			}

			public void removeValue(PropertyEditor editor, Operation removedValue) {
				RemoveReferenceCommand command = new RemoveReferenceCommand(editingDomain,dataTypeElement,UMLPackage.eINSTANCE.getDataType_OwnedOperation(),removedValue);
				editingDomain.getCommandStack().execute(command);	
			}
		};

		dataTypeForm.getOperation().setPropertyChangeListener(operationListener);
		//create listener to create directly element
		CreateElementListener operationCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,dataTypeElement,UMLPackage.eINSTANCE.getDataType_OwnedOperation(),UMLPackage.eINSTANCE.getOperation());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is a container and not abstract feature
		dataTypeForm.getOperation().setCreateElementOnButton(operationCreateListener);
		//set the navigation service
		dataTypeForm.getOperation().setNavigationListener(navigationListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
						//set many referenced Element
		dataTypeForm.getProperty().setValue((java.util.List)dataTypeElement.eGet(UMLPackage.eINSTANCE.getClassifier_Attribute()));
	

			 
						//set many referenced Element
		dataTypeForm.getOperation().setValue((java.util.List)dataTypeElement.eGet(UMLPackage.eINSTANCE.getDataType_OwnedOperation()));
	

 

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
    	this.dataTypeElement = (DataType)getBusinessElement(input);
    	
		 // setup the backbone for referencedElementForm
		dataTypeForm.getProperty().setBackboneContext(backbone);
		 // setup the backbone for referencedElementForm
		dataTypeForm.getOperation().setBackboneContext(backbone);
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof DataType;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		dataTypeElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		dataTypeElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(dataTypeElement!=null){
		dataTypeElement.eAdapters().remove(modelListener);}
		if(dataTypeForm!=null){
		dataTypeForm.dispose();
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