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

import org.eclipse.uml2.uml.Substitution;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.SubstitutionFormForm;


import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Classifier;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The Substitution property section for the Substitution element
 * 
 *
 * @generated
 */
public class SubstitutionSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private SubstitutionFormForm substitutionForm;

	/**
	 * The Substitution to edit 
	 * @generated
	 */
	private Substitution substitutionElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public SubstitutionSection() {
	
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
		substitutionForm = new SubstitutionFormForm("","A substitution is a relationship between two classifiers signifies that the substituting classifier complies with the contract specified by the contract classifier. This implies that instances of the substituting classifier are runtime substitutable where instances of the contract classifier are expected.");
		substitutionForm.setBackContext(backbone);
		return substitutionForm;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//mapping contract
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature contract of Substitution
		PropertyChangeListener<Classifier> contractListener = new PropertyChangeListener<Classifier>(){
		   public void propertyChanged(PropertyEditor editor, Classifier newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, substitutionElement, UMLPackage.eINSTANCE.getSubstitution_Contract(), newValue);
			editingDomain.getCommandStack().execute(command);
			}
		};

		substitutionForm.getContract().setPropertyChangeListener(contractListener);
		//create listener to create directly element
		CreateElementListener contractCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,substitutionElement,UMLPackage.eINSTANCE.getSubstitution_Contract(),UMLPackage.eINSTANCE.getClassifier());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is not a container or it is abstract
		substitutionForm.getContract().setCreateElement(contractCreateListener);
		substitutionForm.getContract().setAbstractElement(true);
		//set the navigation service
		substitutionForm.getContract().setNavigationListener(navigationListener);

		//---------------------------------------------------------------------
		//mapping substitutingClassifier
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature substitutingClassifier of Substitution
		PropertyChangeListener<Classifier> substitutingClassifierListener = new PropertyChangeListener<Classifier>(){
		   public void propertyChanged(PropertyEditor editor, Classifier newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, substitutionElement, UMLPackage.eINSTANCE.getSubstitution_SubstitutingClassifier(), newValue);
			editingDomain.getCommandStack().execute(command);
			}
		};

		substitutionForm.getSubstitutingClassifier().setPropertyChangeListener(substitutingClassifierListener);
		//create listener to create directly element
		CreateElementListener substitutingClassifierCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,substitutionElement,UMLPackage.eINSTANCE.getSubstitution_SubstitutingClassifier(),UMLPackage.eINSTANCE.getClassifier());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is not a container or it is abstract
		substitutionForm.getSubstitutingClassifier().setCreateElement(substitutingClassifierCreateListener);
		substitutionForm.getSubstitutingClassifier().setAbstractElement(true);
		//set the navigation service
		substitutionForm.getSubstitutingClassifier().setNavigationListener(navigationListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
				 
														   				 
		//set simple Referenced Element
		if(substitutionElement.getContract()==null){
		    substitutionForm.getContract().setValue("<UNDEFINED>");}
		else{
			substitutionForm.getContract().setValue(substitutionElement.getContract().getQualifiedName());
			navigationListener.setTheElement(substitutionElement.getContract());
			}
							
 
 

	

			 
				 
														   				 
		//set simple Referenced Element
		if(substitutionElement.getSubstitutingClassifier()==null){
		    substitutionForm.getSubstitutingClassifier().setValue("<UNDEFINED>");}
		else{
			substitutionForm.getSubstitutingClassifier().setValue(substitutionElement.getSubstitutingClassifier().getQualifiedName());
			navigationListener.setTheElement(substitutionElement.getSubstitutingClassifier());
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
    	this.substitutionElement = (Substitution)getBusinessElement(input);
    	
		 // setup the backbone for referencedElementForm
		substitutionForm.getContract().setBackboneContext(backbone);
		 // setup the backbone for referencedElementForm
		substitutionForm.getSubstitutingClassifier().setBackboneContext(backbone);
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof Substitution;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		substitutionElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		substitutionElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(substitutionElement!=null){
		substitutionElement.eAdapters().remove(modelListener);}
		if(substitutionForm!=null){
		substitutionForm.dispose();
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