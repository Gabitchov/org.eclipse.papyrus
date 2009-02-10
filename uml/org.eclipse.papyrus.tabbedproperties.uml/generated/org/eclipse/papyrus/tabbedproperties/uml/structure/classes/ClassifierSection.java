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

import org.eclipse.uml2.uml.Classifier;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.ClassifierFormForm;


import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Classifier;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The Classifier property section for the Classifier element
 * 
 * A classifier is a namespace whose members can include features. Classifier is an abstract metaclass
 *
 * @generated
 */
public class ClassifierSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private ClassifierFormForm classifierForm;

	/**
	 * The Classifier to edit 
	 * @generated
	 */
	private Classifier classifierElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public ClassifierSection() {
	
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
		classifierForm = new ClassifierFormForm("Classifier Specifications","A classifier is a classification of instances - it describes a set of instances that have features in common. A classifier can specify a generalization hierarchy by referencing its general classifiers."+
""+
"A classifier has the capability to own collaboration uses. These collaboration uses link a collaboration with the classifier to give a description of the workings of the classifier."+
""+
"A classifier has the capability to own use cases. Although the owning classifier typically represents the subject to which the owned use cases apply, this is not necessarily the case. In principle, the same use case can be applied to multiple subjects, as identified by the subject association role of a use case."+
""+
"Classifier is defined to be a kind of templateable element so that a classifier can be parameterized. It is also defined to be a kind of parameterable element so that a classifier can be a formal template parameter.");
		return classifierForm;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//mapping is abstract
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature isAbstract of Classifier
		BooleanPropertyChangeListener isAbstractListener = new BooleanPropertyChangeListener(){
			public void propertyChanged(PropertyEditor editor, boolean newValue) {
			SetValueCommand command = new SetValueCommand(editingDomain,classifierElement, UMLPackage.eINSTANCE.getClassifier_IsAbstract(),newValue);		
			editingDomain.getCommandStack().execute(command);
			}
		};

		classifierForm.getIsAbstract().setPropertyChangeListener(isAbstractListener);

		//---------------------------------------------------------------------
		//mapping Generalization
		//---------------------------------------------------------------------
				
			 
		//more complex listener to manage 0..* feature generalization of Classifier
		ListPropertyChangeListener<Generalization> generalizationListener =new ListPropertyChangeListener<Generalization>(){
			public void addValue(PropertyEditor editor, Generalization newValue) {
				// TODO Auto-generated method stub
				AddReferenceCommand command = new AddReferenceCommand(editingDomain,classifierElement,UMLPackage.eINSTANCE.getClassifier_Generalization(),newValue);
				editingDomain.getCommandStack().execute(command);
			}

			public void moveValue(PropertyEditor editor, Generalization newValue,
					int newIndex) {
				MoveReferenceCommand command = new MoveReferenceCommand(editingDomain,classifierElement,UMLPackage.eINSTANCE.getClassifier_Generalization(),newValue,newIndex);
				editingDomain.getCommandStack().execute(command);
				
			}

			public void removeValue(PropertyEditor editor, Generalization removedValue) {
				RemoveReferenceCommand command = new RemoveReferenceCommand(editingDomain,classifierElement,UMLPackage.eINSTANCE.getClassifier_Generalization(),removedValue);
				editingDomain.getCommandStack().execute(command);	
			}
		};

		classifierForm.getGeneralization().setPropertyChangeListener(generalizationListener);
		//create listener to create directly element
		CreateElementListener generalizationCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,classifierElement,UMLPackage.eINSTANCE.getClassifier_Generalization(),UMLPackage.eINSTANCE.getGeneralization());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is a container and not abstract feature
		classifierForm.getGeneralization().setCreateElementOnButton(generalizationCreateListener);
		//set the navigation service
		classifierForm.getGeneralization().setNavigationListener(navigationListener);

		//---------------------------------------------------------------------
		//mapping redefined Classifier
		//---------------------------------------------------------------------
				
			 
		//more complex listener to manage 0..* feature redefinedClassifier of Classifier
		ListPropertyChangeListener<Classifier> redefinedClassifierListener =new ListPropertyChangeListener<Classifier>(){
			public void addValue(PropertyEditor editor, Classifier newValue) {
				// TODO Auto-generated method stub
				AddReferenceCommand command = new AddReferenceCommand(editingDomain,classifierElement,UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(),newValue);
				editingDomain.getCommandStack().execute(command);
			}

			public void moveValue(PropertyEditor editor, Classifier newValue,
					int newIndex) {
				MoveReferenceCommand command = new MoveReferenceCommand(editingDomain,classifierElement,UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(),newValue,newIndex);
				editingDomain.getCommandStack().execute(command);
				
			}

			public void removeValue(PropertyEditor editor, Classifier removedValue) {
				RemoveReferenceCommand command = new RemoveReferenceCommand(editingDomain,classifierElement,UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(),removedValue);
				editingDomain.getCommandStack().execute(command);	
			}
		};

		classifierForm.getRedefinedClassifier().setPropertyChangeListener(redefinedClassifierListener);
		//create listener to create directly element
		CreateElementListener redefinedClassifierCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,classifierElement,UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier(),UMLPackage.eINSTANCE.getClassifier());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is not a container or it is abstract
		classifierForm.getRedefinedClassifier().setCreateElement(redefinedClassifierCreateListener);
		classifierForm.getRedefinedClassifier().setAbstractElement(true);
		//set the navigation service
		classifierForm.getRedefinedClassifier().setNavigationListener(navigationListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
				 
														   						classifierForm.getIsAbstract().setValue(classifierElement.isAbstract());
 
 

	

			 
						//set many referenced Element
		classifierForm.getGeneralization().setValue((java.util.List)classifierElement.eGet(UMLPackage.eINSTANCE.getClassifier_Generalization()));
	

			 
						//set many referenced Element
		classifierForm.getRedefinedClassifier().setValue((java.util.List)classifierElement.eGet(UMLPackage.eINSTANCE.getClassifier_RedefinedClassifier()));
	

 

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
    	this.classifierElement = (Classifier)getBusinessElement(input);
    	
		 // setup the backbone for referencedElementForm
		classifierForm.getGeneralization().setBackboneContext(backbone);
		 // setup the backbone for referencedElementForm
		classifierForm.getRedefinedClassifier().setBackboneContext(backbone);
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof Classifier;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		classifierElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		classifierElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(classifierElement!=null){
		classifierElement.eAdapters().remove(modelListener);}
		if(classifierForm!=null){
		classifierForm.dispose();
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