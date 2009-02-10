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

import org.eclipse.uml2.uml.Generalization;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.GeneralizationFormForm;


import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Classifier;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The Generalization property section for the Generalization element
 * 
 * A generalization relates a specific classifier to a more general classifier, and is owned by the specific classifier.
 *
 * @generated
 */
public class GeneralizationSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private GeneralizationFormForm generalizationForm;

	/**
	 * The Generalization to edit 
	 * @generated
	 */
	private Generalization generalizationElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public GeneralizationSection() {
	
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
		generalizationForm = new GeneralizationFormForm("","A generalization is a taxonomic relationship between a more general classifier and a more specific classifier. Each instance of the specific classifier is also an indirect instance of the general classifier. Thus, the specific classifier inherits the features of the more general classifier."+
""+
"A generalization relates a specific classifier to a more general classifier, and is owned by the specific classifier.");
		generalizationForm.setBackContext(backbone);
		return generalizationForm;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//mapping is Substitutable
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature isSubstitutable of Generalization
		BooleanPropertyChangeListener isSubstitutableListener = new BooleanPropertyChangeListener(){
			public void propertyChanged(PropertyEditor editor, boolean newValue) {
			SetValueCommand command = new SetValueCommand(editingDomain,generalizationElement, UMLPackage.eINSTANCE.getGeneralization_IsSubstitutable(),newValue);		
			editingDomain.getCommandStack().execute(command);
			}
		};

		generalizationForm.getIsSubstitutable().setPropertyChangeListener(isSubstitutableListener);

		//---------------------------------------------------------------------
		//mapping general
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature general of Generalization
		PropertyChangeListener<Classifier> generalListener = new PropertyChangeListener<Classifier>(){
		   public void propertyChanged(PropertyEditor editor, Classifier newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, generalizationElement, UMLPackage.eINSTANCE.getGeneralization_General(), newValue);
			editingDomain.getCommandStack().execute(command);
			}
		};

		generalizationForm.getGeneral().setPropertyChangeListener(generalListener);
		//create listener to create directly element
		CreateElementListener generalCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,generalizationElement,UMLPackage.eINSTANCE.getGeneralization_General(),UMLPackage.eINSTANCE.getClassifier());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is not a container or it is abstract
		generalizationForm.getGeneral().setCreateElement(generalCreateListener);
		generalizationForm.getGeneral().setAbstractElement(true);
		//set the navigation service
		generalizationForm.getGeneral().setNavigationListener(navigationListener);

		//---------------------------------------------------------------------
		//mapping Specific
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature specific of Generalization
		PropertyChangeListener<Classifier> specificListener = new PropertyChangeListener<Classifier>(){
		   public void propertyChanged(PropertyEditor editor, Classifier newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, generalizationElement, UMLPackage.eINSTANCE.getGeneralization_Specific(), newValue);
			editingDomain.getCommandStack().execute(command);
			}
		};

		generalizationForm.getSpecific().setPropertyChangeListener(specificListener);
		//create listener to create directly element
		CreateElementListener specificCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,generalizationElement,UMLPackage.eINSTANCE.getGeneralization_Specific(),UMLPackage.eINSTANCE.getClassifier());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is not a container or it is abstract
		generalizationForm.getSpecific().setCreateElement(specificCreateListener);
		generalizationForm.getSpecific().setAbstractElement(true);
		//set the navigation service
		generalizationForm.getSpecific().setNavigationListener(navigationListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
				 
														   						generalizationForm.getIsSubstitutable().setValue(generalizationElement.isSubstitutable());
 
 

	

			 
				 
														   				 
		//set simple Referenced Element
		if(generalizationElement.getGeneral()==null){
		    generalizationForm.getGeneral().setValue("<UNDEFINED>");}
		else{
			generalizationForm.getGeneral().setValue(generalizationElement.getGeneral().getQualifiedName());
			navigationListener.setTheElement(generalizationElement.getGeneral());
			}
							
 
 

	

			 
				 
														   				 
		//set simple Referenced Element
		if(generalizationElement.getSpecific()==null){
		    generalizationForm.getSpecific().setValue("<UNDEFINED>");}
		else{
			generalizationForm.getSpecific().setValue(generalizationElement.getSpecific().getQualifiedName());
			navigationListener.setTheElement(generalizationElement.getSpecific());
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
    	this.generalizationElement = (Generalization)getBusinessElement(input);
    	
		 // setup the backbone for referencedElementForm
		generalizationForm.getGeneral().setBackboneContext(backbone);
		 // setup the backbone for referencedElementForm
		generalizationForm.getSpecific().setBackboneContext(backbone);
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof Generalization;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		generalizationElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		generalizationElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(generalizationElement!=null){
		generalizationElement.eAdapters().remove(modelListener);}
		if(generalizationForm!=null){
		generalizationForm.dispose();
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