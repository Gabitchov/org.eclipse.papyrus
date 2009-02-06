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

import org.eclipse.uml2.uml.Dependency;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.DependencyFormForm;


import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.NamedElement;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The Dependency property section for the Dependency element
 * 
 * A dependency is a relationship that signifies that a single or a set of model elements requires other model elements for their specification or implementation.
 *
 * @generated
 */
public class DependencySection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private DependencyFormForm dependencyForm;

	/**
	 * The Dependency to edit 
	 * @generated
	 */
	private Dependency dependencyElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public DependencySection() {
	
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
		dependencyForm = new DependencyFormForm("","A dependency is a relationship that signifies that a single or a set of model elements requires other model elements for their specification or implementation. This means that the complete semantics of the depending elements is either semantically or structurally dependent on the definition of the supplier element(s).");
		dependencyForm.setBackContext(backbone);
		return dependencyForm;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//mapping client
		//---------------------------------------------------------------------
				
			 
		//more complex listener to manage 0..* feature client of Dependency
		ListPropertyChangeListener<NamedElement> clientListener =new ListPropertyChangeListener<NamedElement>(){
			public void addValue(PropertyEditor editor, NamedElement newValue) {
				// TODO Auto-generated method stub
				AddReferenceCommand command = new AddReferenceCommand(editingDomain,dependencyElement,UMLPackage.eINSTANCE.getDependency_Client(),newValue);
				editingDomain.getCommandStack().execute(command);
			}

			public void moveValue(PropertyEditor editor, NamedElement newValue,
					int newIndex) {
				MoveReferenceCommand command = new MoveReferenceCommand(editingDomain,dependencyElement,UMLPackage.eINSTANCE.getDependency_Client(),newValue,newIndex);
				editingDomain.getCommandStack().execute(command);
				
			}

			public void removeValue(PropertyEditor editor, NamedElement removedValue) {
				RemoveReferenceCommand command = new RemoveReferenceCommand(editingDomain,dependencyElement,UMLPackage.eINSTANCE.getDependency_Client(),removedValue);
				editingDomain.getCommandStack().execute(command);	
			}
		};

		dependencyForm.getClient().setPropertyChangeListener(clientListener);
		//create listener to create directly element
		CreateElementListener clientCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,dependencyElement,UMLPackage.eINSTANCE.getDependency_Client(),UMLPackage.eINSTANCE.getNamedElement());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is not a container or it is abstract
		dependencyForm.getClient().setCreateElement(clientCreateListener);
		dependencyForm.getClient().setAbstractElement(true);
		//set the navigation service
		dependencyForm.getClient().setNavigationListener(navigationListener);

		//---------------------------------------------------------------------
		//mapping supplier
		//---------------------------------------------------------------------
				
			 
		//more complex listener to manage 0..* feature supplier of Dependency
		ListPropertyChangeListener<NamedElement> supplierListener =new ListPropertyChangeListener<NamedElement>(){
			public void addValue(PropertyEditor editor, NamedElement newValue) {
				// TODO Auto-generated method stub
				AddReferenceCommand command = new AddReferenceCommand(editingDomain,dependencyElement,UMLPackage.eINSTANCE.getDependency_Supplier(),newValue);
				editingDomain.getCommandStack().execute(command);
			}

			public void moveValue(PropertyEditor editor, NamedElement newValue,
					int newIndex) {
				MoveReferenceCommand command = new MoveReferenceCommand(editingDomain,dependencyElement,UMLPackage.eINSTANCE.getDependency_Supplier(),newValue,newIndex);
				editingDomain.getCommandStack().execute(command);
				
			}

			public void removeValue(PropertyEditor editor, NamedElement removedValue) {
				RemoveReferenceCommand command = new RemoveReferenceCommand(editingDomain,dependencyElement,UMLPackage.eINSTANCE.getDependency_Supplier(),removedValue);
				editingDomain.getCommandStack().execute(command);	
			}
		};

		dependencyForm.getSupplier().setPropertyChangeListener(supplierListener);
		//create listener to create directly element
		CreateElementListener supplierCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,dependencyElement,UMLPackage.eINSTANCE.getDependency_Supplier(),UMLPackage.eINSTANCE.getNamedElement());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is not a container or it is abstract
		dependencyForm.getSupplier().setCreateElement(supplierCreateListener);
		dependencyForm.getSupplier().setAbstractElement(true);
		//set the navigation service
		dependencyForm.getSupplier().setNavigationListener(navigationListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
						//set many referenced Element
		dependencyForm.getClient().setValue((java.util.List)dependencyElement.eGet(UMLPackage.eINSTANCE.getDependency_Client()));
	

			 
						//set many referenced Element
		dependencyForm.getSupplier().setValue((java.util.List)dependencyElement.eGet(UMLPackage.eINSTANCE.getDependency_Supplier()));
	

 

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
    	this.dependencyElement = (Dependency)getBusinessElement(input);
    	
		 // setup the backbone for referencedElementForm
		dependencyForm.getClient().setBackboneContext(backbone);
		 // setup the backbone for referencedElementForm
		dependencyForm.getSupplier().setBackboneContext(backbone);
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof Dependency;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		dependencyElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		dependencyElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(dependencyElement!=null){
		dependencyElement.eAdapters().remove(modelListener);}
		if(dependencyForm!=null){
		dependencyForm.dispose();
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