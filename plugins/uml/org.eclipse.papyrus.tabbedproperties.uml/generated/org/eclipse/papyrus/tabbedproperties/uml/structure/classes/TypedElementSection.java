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

import org.eclipse.uml2.uml.TypedElement;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.TypedElementForm;


import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.Type;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The TypedElement property section for the TypedElement element
 * 
 * A typed element is an element that has a type that serves as a constraint on the range of values the element can represent.
 *
 * @generated
 */
public class TypedElementSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private TypedElementForm typedElement;

	/**
	 * The TypedElement to edit 
	 * @generated
	 */
	private TypedElement typedElementElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public TypedElementSection() {
	
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
		typedElement = new TypedElementForm("Typed Element Specifications","A typed element is a kind of named element that represents an element with a type."+
""+
"A typed element has a type.");
		return typedElement;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//Values represented by the element are constrained to be instances of the type. A typed element with no associated type may represent values of any type.
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature type of TypedElement
		PropertyChangeListener<Type> typeListener = new PropertyChangeListener<Type>(){
		   public void propertyChanged(PropertyEditor editor, Type newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, typedElementElement, UMLPackage.eINSTANCE.getTypedElement_Type(), newValue);
			editingDomain.getCommandStack().execute(command);
			}
		};

		typedElement.getType().setPropertyChangeListener(typeListener);
		//create listener to create directly element
		CreateElementListener typeCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,typedElementElement,UMLPackage.eINSTANCE.getTypedElement_Type(),UMLPackage.eINSTANCE.getType());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is not a container or it is abstract
		typedElement.getType().setCreateElement(typeCreateListener);
		typedElement.getType().setAbstractElement(true);
		//set the navigation service
		typedElement.getType().setNavigationListener(navigationListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
				 
														   				 
		//set simple Referenced Element
		if(typedElementElement.getType()==null){
		    typedElement.getType().setValue("<UNDEFINED>");}
		else{
			typedElement.getType().setValue(typedElementElement.getType().getQualifiedName());
			navigationListener.setTheElement(typedElementElement.getType());
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
    	this.typedElementElement = (TypedElement)getBusinessElement(input);
    	
		 // setup the backbone for referencedElementForm
		typedElement.getType().setBackboneContext(backbone);
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof TypedElement;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		typedElementElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		typedElementElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(typedElementElement!=null){
		typedElementElement.eAdapters().remove(modelListener);}
		if(typedElement!=null){
		typedElement.dispose();
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