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

import org.eclipse.uml2.uml.BehavioralFeature;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.BehavioralFeatureFormForm;


import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Type;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The BehavioralFeature property section for the BehavioralFeature element
 * 
 * A behavioral feature is a feature of a classifier that specifies an aspect of the behavior of its instances.
 * A behavioral feature is implemented (realized) by a behavior. A behavioral feature specifies that a classifier will respond to a designated request by invoking its implementing method.
 * A behavioral feature owns zero or more parameter sets.
 *
 * @generated
 */
public class BehavioralFeatureSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private BehavioralFeatureFormForm behavioralFeatureForm;

	/**
	 * The BehavioralFeature to edit 
	 * @generated
	 */
	private BehavioralFeature behavioralFeatureElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public BehavioralFeatureSection() {
	
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
		behavioralFeatureForm = new BehavioralFeatureFormForm("Behavioral Feature Specifications","A behavioral feature is a feature of a classifier that specifies an aspect of the behavior of its instances."+
""+
"A behavioral feature is implemented (realized) by a behavior. A behavioral feature specifies that a classifier will respond to a designated request by invoking its implementing method."+
""+
"A behavioral feature owns zero or more parameter sets.");
		return behavioralFeatureForm;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//If true, then the behavioral feature does not have an implementation, and one must be supplied by a more specific element. If false, the behavioral feature must have an implementation in the classifier or one must be inherited from a more general element.
		//---------------------------------------------------------------------
				
			 
		//more complex listener to manage 0..* feature ownedParameter of BehavioralFeature
		ListPropertyChangeListener<Parameter> ownedParameterListener =new ListPropertyChangeListener<Parameter>(){
			public void addValue(PropertyEditor editor, Parameter newValue) {
				// TODO Auto-generated method stub
				AddReferenceCommand command = new AddReferenceCommand(editingDomain,behavioralFeatureElement,UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameter(),newValue);
				editingDomain.getCommandStack().execute(command);
			}

			public void moveValue(PropertyEditor editor, Parameter newValue,
					int newIndex) {
				MoveReferenceCommand command = new MoveReferenceCommand(editingDomain,behavioralFeatureElement,UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameter(),newValue,newIndex);
				editingDomain.getCommandStack().execute(command);
				
			}

			public void removeValue(PropertyEditor editor, Parameter removedValue) {
				RemoveReferenceCommand command = new RemoveReferenceCommand(editingDomain,behavioralFeatureElement,UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameter(),removedValue);
				editingDomain.getCommandStack().execute(command);	
			}
		};

		behavioralFeatureForm.getOwnedParameter().setPropertyChangeListener(ownedParameterListener);
		//create listener to create directly element
		CreateElementListener ownedParameterCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,behavioralFeatureElement,UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameter(),UMLPackage.eINSTANCE.getParameter());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is a container and not abstract feature
		behavioralFeatureForm.getOwnedParameter().setCreateElementOnButton(ownedParameterCreateListener);
		//set the navigation service
		behavioralFeatureForm.getOwnedParameter().setNavigationListener(navigationListener);

		//---------------------------------------------------------------------
		//Specifies the semantics of concurrent calls to the same passive instance (i.e., an instance originating from a class with isActive being false). Active instances control access to their own behavioral features.
		//---------------------------------------------------------------------
				
			 
		//more complex listener to manage 0..* feature raisedException of BehavioralFeature
		ListPropertyChangeListener<Type> raisedExceptionListener =new ListPropertyChangeListener<Type>(){
			public void addValue(PropertyEditor editor, Type newValue) {
				// TODO Auto-generated method stub
				AddReferenceCommand command = new AddReferenceCommand(editingDomain,behavioralFeatureElement,UMLPackage.eINSTANCE.getBehavioralFeature_RaisedException(),newValue);
				editingDomain.getCommandStack().execute(command);
			}

			public void moveValue(PropertyEditor editor, Type newValue,
					int newIndex) {
				MoveReferenceCommand command = new MoveReferenceCommand(editingDomain,behavioralFeatureElement,UMLPackage.eINSTANCE.getBehavioralFeature_RaisedException(),newValue,newIndex);
				editingDomain.getCommandStack().execute(command);
				
			}

			public void removeValue(PropertyEditor editor, Type removedValue) {
				RemoveReferenceCommand command = new RemoveReferenceCommand(editingDomain,behavioralFeatureElement,UMLPackage.eINSTANCE.getBehavioralFeature_RaisedException(),removedValue);
				editingDomain.getCommandStack().execute(command);	
			}
		};

		behavioralFeatureForm.getRaisedException().setPropertyChangeListener(raisedExceptionListener);
		//create listener to create directly element
		CreateElementListener raisedExceptionCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,behavioralFeatureElement,UMLPackage.eINSTANCE.getBehavioralFeature_RaisedException(),UMLPackage.eINSTANCE.getType());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is not a container or it is abstract
		behavioralFeatureForm.getRaisedException().setCreateElement(raisedExceptionCreateListener);
		behavioralFeatureForm.getRaisedException().setAbstractElement(true);
		//set the navigation service
		behavioralFeatureForm.getRaisedException().setNavigationListener(navigationListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
						//set many referenced Element
		behavioralFeatureForm.getOwnedParameter().setValue((java.util.List)behavioralFeatureElement.eGet(UMLPackage.eINSTANCE.getBehavioralFeature_OwnedParameter()));
	

			 
						//set many referenced Element
		behavioralFeatureForm.getRaisedException().setValue((java.util.List)behavioralFeatureElement.eGet(UMLPackage.eINSTANCE.getBehavioralFeature_RaisedException()));
	

 

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
    	this.behavioralFeatureElement = (BehavioralFeature)getBusinessElement(input);
    	
		 // setup the backbone for referencedElementForm
		behavioralFeatureForm.getOwnedParameter().setBackboneContext(backbone);
		 // setup the backbone for referencedElementForm
		behavioralFeatureForm.getRaisedException().setBackboneContext(backbone);
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof BehavioralFeature;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		behavioralFeatureElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		behavioralFeatureElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(behavioralFeatureElement!=null){
		behavioralFeatureElement.eAdapters().remove(modelListener);}
		if(behavioralFeatureForm!=null){
		behavioralFeatureForm.dispose();
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