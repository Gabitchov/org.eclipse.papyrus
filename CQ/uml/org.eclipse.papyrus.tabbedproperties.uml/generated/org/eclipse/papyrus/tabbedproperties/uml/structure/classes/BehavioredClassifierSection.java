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

import org.eclipse.uml2.uml.BehavioredClassifier;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.BehavioredClassifierFormForm;


import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.InterfaceRealization;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The BehavioredClassifier property section for the BehavioredClassifier element
 * 
 * Class is a kind of classifier whose features are attributes and operations. Attributes of a class are represented by instances of Property that are owned by the class. Some of these attributes may represent the navigable ends of binary associations.
 *
 * @generated
 */
public class BehavioredClassifierSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private BehavioredClassifierFormForm behavioredClassifierForm;

	/**
	 * The BehavioredClassifier to edit 
	 * @generated
	 */
	private BehavioredClassifier behavioredClassifierElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public BehavioredClassifierSection() {
	
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
		behavioredClassifierForm = new BehavioredClassifierFormForm("Behaviored Classifier Specifications","A behaviored classifier may have an interface realization."+
""+
"A classifier can have behavior specifications defined in its namespace. One of these may specify the behavior of the classifier itself.");
		return behavioredClassifierForm;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//mapping interfaceRealizations
		//---------------------------------------------------------------------
				
			 
		//more complex listener to manage 0..* feature interfaceRealization of BehavioredClassifier
		ListPropertyChangeListener<InterfaceRealization> interfaceRealizationListener =new ListPropertyChangeListener<InterfaceRealization>(){
			public void addValue(PropertyEditor editor, InterfaceRealization newValue) {
				// TODO Auto-generated method stub
				AddReferenceCommand command = new AddReferenceCommand(editingDomain,behavioredClassifierElement,UMLPackage.eINSTANCE.getBehavioredClassifier_InterfaceRealization(),newValue);
				editingDomain.getCommandStack().execute(command);
			}

			public void moveValue(PropertyEditor editor, InterfaceRealization newValue,
					int newIndex) {
				MoveReferenceCommand command = new MoveReferenceCommand(editingDomain,behavioredClassifierElement,UMLPackage.eINSTANCE.getBehavioredClassifier_InterfaceRealization(),newValue,newIndex);
				editingDomain.getCommandStack().execute(command);
				
			}

			public void removeValue(PropertyEditor editor, InterfaceRealization removedValue) {
				RemoveReferenceCommand command = new RemoveReferenceCommand(editingDomain,behavioredClassifierElement,UMLPackage.eINSTANCE.getBehavioredClassifier_InterfaceRealization(),removedValue);
				editingDomain.getCommandStack().execute(command);	
			}
		};

		behavioredClassifierForm.getInterfaceRealization().setPropertyChangeListener(interfaceRealizationListener);
		//create listener to create directly element
		CreateElementListener interfaceRealizationCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,behavioredClassifierElement,UMLPackage.eINSTANCE.getBehavioredClassifier_InterfaceRealization(),UMLPackage.eINSTANCE.getInterfaceRealization());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is a container and not abstract feature
		behavioredClassifierForm.getInterfaceRealization().setCreateElementOnButton(interfaceRealizationCreateListener);
		//set the navigation service
		behavioredClassifierForm.getInterfaceRealization().setNavigationListener(navigationListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
						//set many referenced Element
		behavioredClassifierForm.getInterfaceRealization().setValue((java.util.List)behavioredClassifierElement.eGet(UMLPackage.eINSTANCE.getBehavioredClassifier_InterfaceRealization()));
	

 

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
    	this.behavioredClassifierElement = (BehavioredClassifier)getBusinessElement(input);
    	
		 // setup the backbone for referencedElementForm
		behavioredClassifierForm.getInterfaceRealization().setBackboneContext(backbone);
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof BehavioredClassifier;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		behavioredClassifierElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		behavioredClassifierElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(behavioredClassifierElement!=null){
		behavioredClassifierElement.eAdapters().remove(modelListener);}
		if(behavioredClassifierForm!=null){
		behavioredClassifierForm.dispose();
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