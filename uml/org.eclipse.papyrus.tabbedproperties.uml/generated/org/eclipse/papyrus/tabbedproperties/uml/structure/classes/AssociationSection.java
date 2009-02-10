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

import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.AssociationFormForm;


import org.eclipse.uml2.uml.Association;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The Association property section for the Association element
 * 
 * An association describes a set of tuples whose values refer to typed instances. An instance of an association is called a link.
 *
 * @generated
 */
public class AssociationSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private AssociationFormForm associationForm;

	/**
	 * The Association to edit 
	 * @generated
	 */
	private Association associationElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public AssociationSection() {
	
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
		associationForm = new AssociationFormForm("","An association describes a set of tuples whose values refer to typed instances. An instance of an association is called a link.");
		associationForm.setBackContext(backbone);
		return associationForm;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature isDerived of Association
		BooleanPropertyChangeListener isDerivedListener = new BooleanPropertyChangeListener(){
			public void propertyChanged(PropertyEditor editor, boolean newValue) {
			SetValueCommand command = new SetValueCommand(editingDomain,associationElement, UMLPackage.eINSTANCE.getAssociation_IsDerived(),newValue);		
			editingDomain.getCommandStack().execute(command);
			}
		};

		associationForm.getIsDerived().setPropertyChangeListener(isDerivedListener);

		//---------------------------------------------------------------------
		//
		//---------------------------------------------------------------------
				
			 
		//more complex listener to manage 0..* feature memberEnd of Association
		ListPropertyChangeListener<Property> memberEndListener =new ListPropertyChangeListener<Property>(){
			public void addValue(PropertyEditor editor, Property newValue) {
				// TODO Auto-generated method stub
				AddReferenceCommand command = new AddReferenceCommand(editingDomain,associationElement,UMLPackage.eINSTANCE.getAssociation_MemberEnd(),newValue);
				editingDomain.getCommandStack().execute(command);
			}

			public void moveValue(PropertyEditor editor, Property newValue,
					int newIndex) {
				MoveReferenceCommand command = new MoveReferenceCommand(editingDomain,associationElement,UMLPackage.eINSTANCE.getAssociation_MemberEnd(),newValue,newIndex);
				editingDomain.getCommandStack().execute(command);
				
			}

			public void removeValue(PropertyEditor editor, Property removedValue) {
				RemoveReferenceCommand command = new RemoveReferenceCommand(editingDomain,associationElement,UMLPackage.eINSTANCE.getAssociation_MemberEnd(),removedValue);
				editingDomain.getCommandStack().execute(command);	
			}
		};

		associationForm.getMemberEnd().setPropertyChangeListener(memberEndListener);
		//create listener to create directly element
		CreateElementListener memberEndCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,associationElement,UMLPackage.eINSTANCE.getAssociation_MemberEnd(),UMLPackage.eINSTANCE.getProperty());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is not a container or it is abstract
		associationForm.getMemberEnd().setCreateElement(memberEndCreateListener);
		//set the navigation service
		associationForm.getMemberEnd().setNavigationListener(navigationListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
				 
														   						associationForm.getIsDerived().setValue(associationElement.isDerived());
 
 

	

			 
						//set many referenced Element
		associationForm.getMemberEnd().setValue((java.util.List)associationElement.eGet(UMLPackage.eINSTANCE.getAssociation_MemberEnd()));
	

 

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
    	this.associationElement = (Association)getBusinessElement(input);
    	
		 // setup the backbone for referencedElementForm
		associationForm.getMemberEnd().setBackboneContext(backbone);
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof Association;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		associationElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		associationElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(associationElement!=null){
		associationElement.eAdapters().remove(modelListener);}
		if(associationForm!=null){
		associationForm.dispose();
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