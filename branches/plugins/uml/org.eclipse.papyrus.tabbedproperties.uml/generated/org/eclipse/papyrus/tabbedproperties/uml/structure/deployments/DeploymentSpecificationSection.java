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
package org.eclipse.papyrus.tabbedproperties.uml.structure.deployments;

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

import org.eclipse.uml2.uml.DeploymentSpecification;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.DeploymentSpecificationForm;


import org.eclipse.uml2.uml.DeploymentSpecification;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The DeploymentSpecification property section for the DeploymentSpecification element
 * 
 * A deployment specification specifies a set of properties that determine execution parameters of a component artifact that is deployed on a node. A deployment specification can be aimed at a specific type of container. An artifact that reifies or implements deployment specification properties is a deployment descriptor.
 *
 * @generated
 */
public class DeploymentSpecificationSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private DeploymentSpecificationForm deploymentSpecification;

	/**
	 * The DeploymentSpecification to edit 
	 * @generated
	 */
	private DeploymentSpecification deploymentSpecificationElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public DeploymentSpecificationSection() {
	
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
		deploymentSpecification = new DeploymentSpecificationForm("Deployment Specifications","A deployment specification specifies a set of properties that determine execution parameters of a component artifact that is deployed on a node. A deployment specification can be aimed at a specific type of container. An artifact that reifies or implements deployment specification properties is a deployment descriptor.");
		return deploymentSpecification;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//The location where an Artifact is deployed onto a Node. This is typically a 'directory' or 'memory address'.
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature deploymentLocation of DeploymentSpecification
		PropertyChangeListener<String> deploymentLocationFormListener = new PropertyChangeListener<String>(){
		   public void propertyChanged(PropertyEditor editor, java.lang.String newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, deploymentSpecificationElement, UMLPackage.eINSTANCE.getDeploymentSpecification_DeploymentLocation(), newValue);
			editingDomain.getCommandStack().execute(command);
			}
		};

		deploymentSpecification.getDeploymentLocationForm().setPropertyChangeListener(deploymentLocationFormListener);

		//---------------------------------------------------------------------
		//The location where a component Artifact executes. This may be a local or remote location.
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature executionLocation of DeploymentSpecification
		PropertyChangeListener<String> executionLocationFormListener = new PropertyChangeListener<String>(){
		   public void propertyChanged(PropertyEditor editor, java.lang.String newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, deploymentSpecificationElement, UMLPackage.eINSTANCE.getDeploymentSpecification_ExecutionLocation(), newValue);
			editingDomain.getCommandStack().execute(command);
			}
		};

		deploymentSpecification.getExecutionLocationForm().setPropertyChangeListener(executionLocationFormListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
				 
														   						deploymentSpecification.getDeploymentLocationForm().setValue(deploymentSpecificationElement.getDeploymentLocation());
 
 

	

			 
				 
														   						deploymentSpecification.getExecutionLocationForm().setValue(deploymentSpecificationElement.getExecutionLocation());
 
 

	

 

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
    	this.deploymentSpecificationElement = (DeploymentSpecification)getBusinessElement(input);
    	
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof DeploymentSpecification;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		deploymentSpecificationElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		deploymentSpecificationElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(deploymentSpecificationElement!=null){
		deploymentSpecificationElement.eAdapters().remove(modelListener);}
		if(deploymentSpecification!=null){
		deploymentSpecification.dispose();
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