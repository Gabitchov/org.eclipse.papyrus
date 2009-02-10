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
package org.eclipse.papyrus.tabbedproperties.uml.behavior.statemachines;

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

import org.eclipse.uml2.uml.State;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.StateForm;


import org.eclipse.uml2.uml.State;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The State property section for the State element
 * 
 * A state models a situation during which some (usually implicit) invariant condition holds.
 * The states of protocol state machines are exposed to the users of their context classifiers. A protocol state represents an exposed stable situation of its context classifier: when an instance of the classifier is not processing any operation, users of this instance can always know its state configuration.
 *
 * @generated
 */
public class StateSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private StateForm state;

	/**
	 * The State to edit 
	 * @generated
	 */
	private State stateElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public StateSection() {
	
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
		state = new StateForm("","A state models a situation during which some (usually implicit) invariant condition holds."+
""+
"The states of protocol state machines are exposed to the users of their context classifiers. A protocol state represents an exposed stable situation of its context classifier: when an instance of the classifier is not processing any operation, users of this instance can always know its state configuration.");
		state.setBackContext(backbone);
		return state;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//A state with isComposite=true is said to be a composite state. A composite state is a state that contains at least one region.
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature isComposite of State
		BooleanPropertyChangeListener isCompositeFormListener = new BooleanPropertyChangeListener(){
			public void propertyChanged(PropertyEditor editor, boolean newValue) {
			SetValueCommand command = new SetValueCommand(editingDomain,stateElement, UMLPackage.eINSTANCE.getState_IsComposite(),newValue);		
			editingDomain.getCommandStack().execute(command);
			}
		};

		state.getIsCompositeForm().setPropertyChangeListener(isCompositeFormListener);

		//---------------------------------------------------------------------
		//A state with isOrthogonal=true is said to be an orthogonal composite state. An orthogonal composite state contains two or more regions.
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature isOrthogonal of State
		BooleanPropertyChangeListener isOrthogonalFormListener = new BooleanPropertyChangeListener(){
			public void propertyChanged(PropertyEditor editor, boolean newValue) {
			SetValueCommand command = new SetValueCommand(editingDomain,stateElement, UMLPackage.eINSTANCE.getState_IsOrthogonal(),newValue);		
			editingDomain.getCommandStack().execute(command);
			}
		};

		state.getIsOrthogonalForm().setPropertyChangeListener(isOrthogonalFormListener);

		//---------------------------------------------------------------------
		//A state with isSimple=true is said to be a simple state. A simple state does not have any regions and it does not refer to any submachine state machine.
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature isSimple of State
		BooleanPropertyChangeListener isSimpleFormListener = new BooleanPropertyChangeListener(){
			public void propertyChanged(PropertyEditor editor, boolean newValue) {
			SetValueCommand command = new SetValueCommand(editingDomain,stateElement, UMLPackage.eINSTANCE.getState_IsSimple(),newValue);		
			editingDomain.getCommandStack().execute(command);
			}
		};

		state.getIsSimpleForm().setPropertyChangeListener(isSimpleFormListener);

		//---------------------------------------------------------------------
		//A state with isSubmachineState=true is said to be a submachine state. Such a state refers to a state machine (submachine).
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature isSubmachineState of State
		BooleanPropertyChangeListener isSubmachineStateFormListener = new BooleanPropertyChangeListener(){
			public void propertyChanged(PropertyEditor editor, boolean newValue) {
			SetValueCommand command = new SetValueCommand(editingDomain,stateElement, UMLPackage.eINSTANCE.getState_IsSubmachineState(),newValue);		
			editingDomain.getCommandStack().execute(command);
			}
		};

		state.getIsSubmachineStateForm().setPropertyChangeListener(isSubmachineStateFormListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
				 
														   						state.getIsCompositeForm().setValue(stateElement.isComposite());
 
 

	

			 
				 
														   						state.getIsOrthogonalForm().setValue(stateElement.isOrthogonal());
 
 

	

			 
				 
														   						state.getIsSimpleForm().setValue(stateElement.isSimple());
 
 

	

			 
				 
														   						state.getIsSubmachineStateForm().setValue(stateElement.isSubmachineState());
 
 

	

 

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
    	this.stateElement = (State)getBusinessElement(input);
    	
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof State;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		stateElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		stateElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(stateElement!=null){
		stateElement.eAdapters().remove(modelListener);}
		if(state!=null){
		state.dispose();
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