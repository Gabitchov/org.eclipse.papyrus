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

import org.eclipse.uml2.uml.Class;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.ClassFormForm;


import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Classifier;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The Class property section for the Class element
 * 
 *
 * @generated
 */
public class ClassSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private ClassFormForm classForm;

	/**
	 * The Class to edit 
	 * @generated
	 */
	private Class classElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public ClassSection() {
	
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
		classForm = new ClassFormForm("Class Specifications","A class describes a set of objects that share the same specifications of features, constraints, and semantics."+
""+
"A class may be designated as active (i.e., each of its instances having its own thread of control) or passive (i.e., each of its instances executing within the context of some other object). A class may also specify which signals the instances of this class handle."+
""+
"A class has the capability to have an internal structure and ports."+
""+
"Class has derived association that indicates how it may be extended through one or more stereotypes. Stereotype is the only kind of metaclass that cannot be extended by stereotypes.");
		return classForm;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//mapping properties attribute
		//---------------------------------------------------------------------
				
			 
		//more complex listener to manage 0..* feature ownedAttribute of StructuredClassifier
		ListPropertyChangeListener<Property> propertyListener =new ListPropertyChangeListener<Property>(){
			public void addValue(PropertyEditor editor, Property newValue) {
				// TODO Auto-generated method stub
				AddReferenceCommand command = new AddReferenceCommand(editingDomain,classElement,UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute(),newValue);
				editingDomain.getCommandStack().execute(command);
			}

			public void moveValue(PropertyEditor editor, Property newValue,
					int newIndex) {
				MoveReferenceCommand command = new MoveReferenceCommand(editingDomain,classElement,UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute(),newValue,newIndex);
				editingDomain.getCommandStack().execute(command);
				
			}

			public void removeValue(PropertyEditor editor, Property removedValue) {
				RemoveReferenceCommand command = new RemoveReferenceCommand(editingDomain,classElement,UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute(),removedValue);
				editingDomain.getCommandStack().execute(command);	
			}
		};

		classForm.getProperty().setPropertyChangeListener(propertyListener);
		//create listener to create directly element
		CreateElementListener propertyCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,classElement,UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute(),UMLPackage.eINSTANCE.getProperty());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is a container and not abstract feature
		classForm.getProperty().setCreateElementOnButton(propertyCreateListener);
		//set the navigation service
		classForm.getProperty().setNavigationListener(navigationListener);

		//---------------------------------------------------------------------
		//mapping owned operation
		//---------------------------------------------------------------------
				
			 
		//more complex listener to manage 0..* feature ownedOperation of Class
		ListPropertyChangeListener<Operation> operationListener =new ListPropertyChangeListener<Operation>(){
			public void addValue(PropertyEditor editor, Operation newValue) {
				// TODO Auto-generated method stub
				AddReferenceCommand command = new AddReferenceCommand(editingDomain,classElement,UMLPackage.eINSTANCE.getClass_OwnedOperation(),newValue);
				editingDomain.getCommandStack().execute(command);
			}

			public void moveValue(PropertyEditor editor, Operation newValue,
					int newIndex) {
				MoveReferenceCommand command = new MoveReferenceCommand(editingDomain,classElement,UMLPackage.eINSTANCE.getClass_OwnedOperation(),newValue,newIndex);
				editingDomain.getCommandStack().execute(command);
				
			}

			public void removeValue(PropertyEditor editor, Operation removedValue) {
				RemoveReferenceCommand command = new RemoveReferenceCommand(editingDomain,classElement,UMLPackage.eINSTANCE.getClass_OwnedOperation(),removedValue);
				editingDomain.getCommandStack().execute(command);	
			}
		};

		classForm.getOperation().setPropertyChangeListener(operationListener);
		//create listener to create directly element
		CreateElementListener operationCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,classElement,UMLPackage.eINSTANCE.getClass_OwnedOperation(),UMLPackage.eINSTANCE.getOperation());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is a container and not abstract feature
		classForm.getOperation().setCreateElementOnButton(operationCreateListener);
		//set the navigation service
		classForm.getOperation().setNavigationListener(navigationListener);

		//---------------------------------------------------------------------
		//mapping nested Classifier
		//---------------------------------------------------------------------
				
			 
		//more complex listener to manage 0..* feature nestedClassifier of Class
		ListPropertyChangeListener<Classifier> nestedClassifierListener =new ListPropertyChangeListener<Classifier>(){
			public void addValue(PropertyEditor editor, Classifier newValue) {
				// TODO Auto-generated method stub
				AddReferenceCommand command = new AddReferenceCommand(editingDomain,classElement,UMLPackage.eINSTANCE.getClass_NestedClassifier(),newValue);
				editingDomain.getCommandStack().execute(command);
			}

			public void moveValue(PropertyEditor editor, Classifier newValue,
					int newIndex) {
				MoveReferenceCommand command = new MoveReferenceCommand(editingDomain,classElement,UMLPackage.eINSTANCE.getClass_NestedClassifier(),newValue,newIndex);
				editingDomain.getCommandStack().execute(command);
				
			}

			public void removeValue(PropertyEditor editor, Classifier removedValue) {
				RemoveReferenceCommand command = new RemoveReferenceCommand(editingDomain,classElement,UMLPackage.eINSTANCE.getClass_NestedClassifier(),removedValue);
				editingDomain.getCommandStack().execute(command);	
			}
		};

		classForm.getNestedClassifier().setPropertyChangeListener(nestedClassifierListener);
		//create listener to create directly element
		CreateElementListener nestedClassifierCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,classElement,UMLPackage.eINSTANCE.getClass_NestedClassifier(),UMLPackage.eINSTANCE.getClassifier());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is not a container or it is abstract
		classForm.getNestedClassifier().setCreateElement(nestedClassifierCreateListener);
		classForm.getNestedClassifier().setAbstractElement(true);
		//set the navigation service
		classForm.getNestedClassifier().setNavigationListener(navigationListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
						//set many referenced Element
		classForm.getProperty().setValue((java.util.List)classElement.eGet(UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute()));
	

			 
						//set many referenced Element
		classForm.getOperation().setValue((java.util.List)classElement.eGet(UMLPackage.eINSTANCE.getClass_OwnedOperation()));
	

			 
						//set many referenced Element
		classForm.getNestedClassifier().setValue((java.util.List)classElement.eGet(UMLPackage.eINSTANCE.getClass_NestedClassifier()));
	

 

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
    	this.classElement = (Class)getBusinessElement(input);
    	
		 // setup the backbone for referencedElementForm
		classForm.getProperty().setBackboneContext(backbone);
		 // setup the backbone for referencedElementForm
		classForm.getOperation().setBackboneContext(backbone);
		 // setup the backbone for referencedElementForm
		classForm.getNestedClassifier().setBackboneContext(backbone);
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof Class;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		classElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		classElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(classElement!=null){
		classElement.eAdapters().remove(modelListener);}
		if(classForm!=null){
		classForm.dispose();
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