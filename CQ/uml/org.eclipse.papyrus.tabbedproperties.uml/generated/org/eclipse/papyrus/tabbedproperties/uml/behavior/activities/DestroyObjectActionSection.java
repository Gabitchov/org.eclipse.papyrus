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

import org.eclipse.uml2.uml.DestroyObjectAction;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.DestroyObjectActionForm;


import org.eclipse.uml2.uml.DestroyObjectAction;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The DestroyObjectAction property section for the DestroyObjectAction element
 * 
 * A destroy object action is an action that destroys objects.
 *
 * @generated
 */
public class DestroyObjectActionSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private DestroyObjectActionForm destroyObjectAction;

	/**
	 * The DestroyObjectAction to edit 
	 * @generated
	 */
	private DestroyObjectAction destroyObjectActionElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public DestroyObjectActionSection() {
	
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
		destroyObjectAction = new DestroyObjectActionForm("","A destroy object action is an action that destroys objects.");
		destroyObjectAction.setBackContext(backbone);
		return destroyObjectAction;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//Specifies whether links in which the object participates are destroyed along with the object.
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature isDestroyLinks of DestroyObjectAction
		BooleanPropertyChangeListener isDestroyLinksFormListener = new BooleanPropertyChangeListener(){
			public void propertyChanged(PropertyEditor editor, boolean newValue) {
			SetValueCommand command = new SetValueCommand(editingDomain,destroyObjectActionElement, UMLPackage.eINSTANCE.getDestroyObjectAction_IsDestroyLinks(),newValue);		
			editingDomain.getCommandStack().execute(command);
			}
		};

		destroyObjectAction.getIsDestroyLinksForm().setPropertyChangeListener(isDestroyLinksFormListener);

		//---------------------------------------------------------------------
		//Specifies whether objects owned by the object are destroyed along with the object.
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature isDestroyOwnedObjects of DestroyObjectAction
		BooleanPropertyChangeListener isDestroyOwnedObjectsFormListener = new BooleanPropertyChangeListener(){
			public void propertyChanged(PropertyEditor editor, boolean newValue) {
			SetValueCommand command = new SetValueCommand(editingDomain,destroyObjectActionElement, UMLPackage.eINSTANCE.getDestroyObjectAction_IsDestroyOwnedObjects(),newValue);		
			editingDomain.getCommandStack().execute(command);
			}
		};

		destroyObjectAction.getIsDestroyOwnedObjectsForm().setPropertyChangeListener(isDestroyOwnedObjectsFormListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
				 
														   						destroyObjectAction.getIsDestroyLinksForm().setValue(destroyObjectActionElement.isDestroyLinks());
 
 

	

			 
				 
														   						destroyObjectAction.getIsDestroyOwnedObjectsForm().setValue(destroyObjectActionElement.isDestroyOwnedObjects());
 
 

	

 

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
    	this.destroyObjectActionElement = (DestroyObjectAction)getBusinessElement(input);
    	
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof DestroyObjectAction;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		destroyObjectActionElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		destroyObjectActionElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(destroyObjectActionElement!=null){
		destroyObjectActionElement.eAdapters().remove(modelListener);}
		if(destroyObjectAction!=null){
		destroyObjectAction.dispose();
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