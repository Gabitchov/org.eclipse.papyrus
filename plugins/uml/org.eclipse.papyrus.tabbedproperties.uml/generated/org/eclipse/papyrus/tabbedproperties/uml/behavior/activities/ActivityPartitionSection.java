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
package org.eclipse.papyrus.tabbedproperties.uml.behavior.activities;

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

import org.eclipse.uml2.uml.ActivityPartition;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.ActivityPartitionForm;


import org.eclipse.uml2.uml.ActivityPartition;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The ActivityPartition property section for the ActivityPartition element
 * 
 * An activity partition is a kind of activity group for identifying actions that have some characteristic in common.
 *
 * @generated
 */
public class ActivityPartitionSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private ActivityPartitionForm activityPartition;

	/**
	 * The ActivityPartition to edit 
	 * @generated
	 */
	private ActivityPartition activityPartitionElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public ActivityPartitionSection() {
	
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
		activityPartition = new ActivityPartitionForm("","An activity partition is a kind of activity group for identifying actions that have some characteristic in common.");
		activityPartition.setBackContext(backbone);
		return activityPartition;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//Tells whether the partition groups other partitions along a dimension.
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature isDimension of ActivityPartition
		BooleanPropertyChangeListener isDimensionFormListener = new BooleanPropertyChangeListener(){
			public void propertyChanged(PropertyEditor editor, boolean newValue) {
			SetValueCommand command = new SetValueCommand(editingDomain,activityPartitionElement, UMLPackage.eINSTANCE.getActivityPartition_IsDimension(),newValue);		
			editingDomain.getCommandStack().execute(command);
			}
		};

		activityPartition.getIsDimensionForm().setPropertyChangeListener(isDimensionFormListener);

		//---------------------------------------------------------------------
		//Tells whether the partition represents an entity to which the partitioning structure does not apply.
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature isExternal of ActivityPartition
		BooleanPropertyChangeListener isExternalFormListener = new BooleanPropertyChangeListener(){
			public void propertyChanged(PropertyEditor editor, boolean newValue) {
			SetValueCommand command = new SetValueCommand(editingDomain,activityPartitionElement, UMLPackage.eINSTANCE.getActivityPartition_IsExternal(),newValue);		
			editingDomain.getCommandStack().execute(command);
			}
		};

		activityPartition.getIsExternalForm().setPropertyChangeListener(isExternalFormListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
				 
														   						activityPartition.getIsDimensionForm().setValue(activityPartitionElement.isDimension());
 
 

	

			 
				 
														   						activityPartition.getIsExternalForm().setValue(activityPartitionElement.isExternal());
 
 

	

 

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
    	this.activityPartitionElement = (ActivityPartition)getBusinessElement(input);
    	
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof ActivityPartition;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		activityPartitionElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		activityPartitionElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(activityPartitionElement!=null){
		activityPartitionElement.eAdapters().remove(modelListener);}
		if(activityPartition!=null){
		activityPartition.dispose();
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