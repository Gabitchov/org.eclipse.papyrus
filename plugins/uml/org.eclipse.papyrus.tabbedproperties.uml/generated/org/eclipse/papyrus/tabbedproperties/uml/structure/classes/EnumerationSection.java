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

import org.eclipse.uml2.uml.Enumeration;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.EnumerationFormForm;


import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The Enumeration property section for the Enumeration element
 * 
 *
 * @generated
 */
public class EnumerationSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private EnumerationFormForm enumerationForm;

	/**
	 * The Enumeration to edit 
	 * @generated
	 */
	private Enumeration enumerationElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public EnumerationSection() {
	
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
		enumerationForm = new EnumerationFormForm("Enumeration Literal Specifications","An enumeration is a data type whose values are enumerated in the model as enumeration literals.");
		return enumerationForm;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//mapping owned enumerationliteral
		//---------------------------------------------------------------------
				
			 
		//more complex listener to manage 0..* feature ownedLiteral of Enumeration
		ListPropertyChangeListener<EnumerationLiteral> ownedLiteralListener =new ListPropertyChangeListener<EnumerationLiteral>(){
			public void addValue(PropertyEditor editor, EnumerationLiteral newValue) {
				// TODO Auto-generated method stub
				AddReferenceCommand command = new AddReferenceCommand(editingDomain,enumerationElement,UMLPackage.eINSTANCE.getEnumeration_OwnedLiteral(),newValue);
				editingDomain.getCommandStack().execute(command);
			}

			public void moveValue(PropertyEditor editor, EnumerationLiteral newValue,
					int newIndex) {
				MoveReferenceCommand command = new MoveReferenceCommand(editingDomain,enumerationElement,UMLPackage.eINSTANCE.getEnumeration_OwnedLiteral(),newValue,newIndex);
				editingDomain.getCommandStack().execute(command);
				
			}

			public void removeValue(PropertyEditor editor, EnumerationLiteral removedValue) {
				RemoveReferenceCommand command = new RemoveReferenceCommand(editingDomain,enumerationElement,UMLPackage.eINSTANCE.getEnumeration_OwnedLiteral(),removedValue);
				editingDomain.getCommandStack().execute(command);	
			}
		};

		enumerationForm.getOwnedLiteral().setPropertyChangeListener(ownedLiteralListener);
		//create listener to create directly element
		CreateElementListener ownedLiteralCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,enumerationElement,UMLPackage.eINSTANCE.getEnumeration_OwnedLiteral(),UMLPackage.eINSTANCE.getEnumerationLiteral());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is a container and not abstract feature
		enumerationForm.getOwnedLiteral().setCreateElementOnButton(ownedLiteralCreateListener);
		//set the navigation service
		enumerationForm.getOwnedLiteral().setNavigationListener(navigationListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
						//set many referenced Element
		enumerationForm.getOwnedLiteral().setValue((java.util.List)enumerationElement.eGet(UMLPackage.eINSTANCE.getEnumeration_OwnedLiteral()));
	

 

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
    	this.enumerationElement = (Enumeration)getBusinessElement(input);
    	
		 // setup the backbone for referencedElementForm
		enumerationForm.getOwnedLiteral().setBackboneContext(backbone);
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof Enumeration;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		enumerationElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		enumerationElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(enumerationElement!=null){
		enumerationElement.eAdapters().remove(modelListener);}
		if(enumerationForm!=null){
		enumerationForm.dispose();
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