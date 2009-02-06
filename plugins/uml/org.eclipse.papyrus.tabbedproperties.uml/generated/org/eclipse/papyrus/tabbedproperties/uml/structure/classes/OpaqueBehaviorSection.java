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

import org.eclipse.uml2.uml.OpaqueBehavior;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.OpaqueBehaviorForm;


import org.eclipse.uml2.uml.OpaqueBehavior;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The OpaqueBehavior property section for the OpaqueBehavior element
 * 
 * An behavior with implementation-specific semantics.
 *
 * @generated
 */
public class OpaqueBehaviorSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private OpaqueBehaviorForm opaqueBehavior;

	/**
	 * The OpaqueBehavior to edit 
	 * @generated
	 */
	private OpaqueBehavior opaqueBehaviorElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public OpaqueBehaviorSection() {
	
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
		opaqueBehavior = new OpaqueBehaviorForm("","An behavior with implementation-specific semantics.");
		opaqueBehavior.setBackContext(backbone);
		return opaqueBehavior;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//Specifies the behavior in one or more languages.
		//---------------------------------------------------------------------
				
			 
		//more complex listener to manage 0..* feature body of OpaqueBehavior
		ListPropertyChangeListener<String> bodyFormListener =new ListPropertyChangeListener<String>(){
			public void addValue(PropertyEditor editor, String newValue) {
				// TODO Auto-generated method stub
				AddReferenceCommand command = new AddReferenceCommand(editingDomain,opaqueBehaviorElement,UMLPackage.eINSTANCE.getOpaqueBehavior_Body(),newValue);
				editingDomain.getCommandStack().execute(command);
			}

			public void moveValue(PropertyEditor editor, String newValue,
					int newIndex) {
				MoveReferenceCommand command = new MoveReferenceCommand(editingDomain,opaqueBehaviorElement,UMLPackage.eINSTANCE.getOpaqueBehavior_Body(),newValue,newIndex);
				editingDomain.getCommandStack().execute(command);
				
			}

			public void removeValue(PropertyEditor editor, String removedValue) {
				RemoveReferenceCommand command = new RemoveReferenceCommand(editingDomain,opaqueBehaviorElement,UMLPackage.eINSTANCE.getOpaqueBehavior_Body(),removedValue);
				editingDomain.getCommandStack().execute(command);	
			}
		};

		opaqueBehavior.getBodyForm().setPropertyChangeListener(bodyFormListener);

		//---------------------------------------------------------------------
		//Languages the body strings use in the same order as the body strings.
		//---------------------------------------------------------------------
				
			 
		//more complex listener to manage 0..* feature language of OpaqueBehavior
		ListPropertyChangeListener<String> languageFormListener =new ListPropertyChangeListener<String>(){
			public void addValue(PropertyEditor editor, String newValue) {
				// TODO Auto-generated method stub
				AddReferenceCommand command = new AddReferenceCommand(editingDomain,opaqueBehaviorElement,UMLPackage.eINSTANCE.getOpaqueBehavior_Language(),newValue);
				editingDomain.getCommandStack().execute(command);
			}

			public void moveValue(PropertyEditor editor, String newValue,
					int newIndex) {
				MoveReferenceCommand command = new MoveReferenceCommand(editingDomain,opaqueBehaviorElement,UMLPackage.eINSTANCE.getOpaqueBehavior_Language(),newValue,newIndex);
				editingDomain.getCommandStack().execute(command);
				
			}

			public void removeValue(PropertyEditor editor, String removedValue) {
				RemoveReferenceCommand command = new RemoveReferenceCommand(editingDomain,opaqueBehaviorElement,UMLPackage.eINSTANCE.getOpaqueBehavior_Language(),removedValue);
				editingDomain.getCommandStack().execute(command);	
			}
		};

		opaqueBehavior.getLanguageForm().setPropertyChangeListener(languageFormListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
						//set many referenced Element
		opaqueBehavior.getBodyForm().setValue((java.util.List)opaqueBehaviorElement.eGet(UMLPackage.eINSTANCE.getOpaqueBehavior_Body()));
	

			 
						//set many referenced Element
		opaqueBehavior.getLanguageForm().setValue((java.util.List)opaqueBehaviorElement.eGet(UMLPackage.eINSTANCE.getOpaqueBehavior_Language()));
	

 

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
    	this.opaqueBehaviorElement = (OpaqueBehavior)getBusinessElement(input);
    	
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof OpaqueBehavior;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		opaqueBehaviorElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		opaqueBehaviorElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(opaqueBehaviorElement!=null){
		opaqueBehaviorElement.eAdapters().remove(modelListener);}
		if(opaqueBehavior!=null){
		opaqueBehavior.dispose();
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