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

import org.eclipse.uml2.uml.Constraint;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.ConstraintFormForm;


import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ValueSpecification;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The Constraint property section for the Constraint element
 * 
 * A constraint is a condition or restriction expressed in natural language text or in a machine readable language for the purpose of declaring some of the semantics of an element.
 *
 * @generated
 */
public class ConstraintSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private ConstraintFormForm constraintForm;

	/**
	 * The Constraint to edit 
	 * @generated
	 */
	private Constraint constraintElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public ConstraintSection() {
	
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
		constraintForm = new ConstraintFormForm("","A constraint is a condition or restriction expressed in natural language text or in a machine readable language for the purpose of declaring some of the semantics of an element.");
		constraintForm.setBackContext(backbone);
		return constraintForm;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//mapping constrainedElement
		//---------------------------------------------------------------------
				
			 
		//more complex listener to manage 0..* feature constrainedElement of Constraint
		ListPropertyChangeListener<Element> constrainedElementListener =new ListPropertyChangeListener<Element>(){
			public void addValue(PropertyEditor editor, Element newValue) {
				// TODO Auto-generated method stub
				AddReferenceCommand command = new AddReferenceCommand(editingDomain,constraintElement,UMLPackage.eINSTANCE.getConstraint_ConstrainedElement(),newValue);
				editingDomain.getCommandStack().execute(command);
			}

			public void moveValue(PropertyEditor editor, Element newValue,
					int newIndex) {
				MoveReferenceCommand command = new MoveReferenceCommand(editingDomain,constraintElement,UMLPackage.eINSTANCE.getConstraint_ConstrainedElement(),newValue,newIndex);
				editingDomain.getCommandStack().execute(command);
				
			}

			public void removeValue(PropertyEditor editor, Element removedValue) {
				RemoveReferenceCommand command = new RemoveReferenceCommand(editingDomain,constraintElement,UMLPackage.eINSTANCE.getConstraint_ConstrainedElement(),removedValue);
				editingDomain.getCommandStack().execute(command);	
			}
		};

		constraintForm.getConstrainedElement().setPropertyChangeListener(constrainedElementListener);
		//create listener to create directly element
		CreateElementListener constrainedElementCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,constraintElement,UMLPackage.eINSTANCE.getConstraint_ConstrainedElement(),UMLPackage.eINSTANCE.getElement());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is not a container or it is abstract
		constraintForm.getConstrainedElement().setCreateElement(constrainedElementCreateListener);
		constraintForm.getConstrainedElement().setAbstractElement(true);
		//set the navigation service
		constraintForm.getConstrainedElement().setNavigationListener(navigationListener);

		//---------------------------------------------------------------------
		//mapping specification
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature specification of Constraint
		PropertyChangeListener<ValueSpecification> specificationListener = new PropertyChangeListener<ValueSpecification>(){
		   public void propertyChanged(PropertyEditor editor, ValueSpecification newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, constraintElement, UMLPackage.eINSTANCE.getConstraint_Specification(), newValue);
			editingDomain.getCommandStack().execute(command);
			}
		};

		constraintForm.getSpecification().setPropertyChangeListener(specificationListener);
		//this a value Specification
		constraintForm.getSpecification().setValueSpecification(true);
		//create listener to create directly element
		CreateElementListener specificationCreateListener= new CreateElementListener(){
			public void fireCreate(EClass eclass) {
				CreateElementCommand command= new CreateElementCommand(editingDomain,constraintElement,UMLPackage.eINSTANCE.getConstraint_Specification(),eclass);
				editingDomain.getCommandStack().execute(command);
			}
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,constraintElement,UMLPackage.eINSTANCE.getConstraint_Specification(),UMLPackage.eINSTANCE.getValueSpecification());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is not a container or it is abstract
		constraintForm.getSpecification().setCreateElement(specificationCreateListener);
		constraintForm.getSpecification().setAbstractElement(true);
		//set the navigation service
		constraintForm.getSpecification().setNavigationListener(navigationListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
						//set many referenced Element
		constraintForm.getConstrainedElement().setValue((java.util.List)constraintElement.eGet(UMLPackage.eINSTANCE.getConstraint_ConstrainedElement()));
	

			 
				 
														   				 
		//set simple Referenced Element
		if(constraintElement.getSpecification()==null){
		    constraintForm.getSpecification().setValue("<UNDEFINED>");}
		else{
			constraintForm.getSpecification().setValue(constraintElement.getSpecification().getQualifiedName());
			navigationListener.setTheElement(constraintElement.getSpecification());
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
    	this.constraintElement = (Constraint)getBusinessElement(input);
    	
		 // setup the backbone for referencedElementForm
		constraintForm.getConstrainedElement().setBackboneContext(backbone);
		 // setup the backbone for referencedElementForm
		constraintForm.getSpecification().setBackboneContext(backbone);
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof Constraint;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		constraintElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		constraintElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(constraintElement!=null){
		constraintElement.eAdapters().remove(modelListener);}
		if(constraintForm!=null){
		constraintForm.dispose();
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