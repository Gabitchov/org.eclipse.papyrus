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

import org.eclipse.uml2.uml.MultiplicityElement;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.MultiplicityElementForm;


import org.eclipse.uml2.uml.MultiplicityElement;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The MultiplicityElement property section for the MultiplicityElement element
 * 
 * A multiplicity is a definition of an inclusive interval of non-negative integers beginning with a lower bound and ending with a (possibly infinite) upper bound. A multiplicity element embeds this information to specify the allowable cardinalities for an instantiation of this element.
 *
 * @generated
 */
public class MultiplicityElementSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private MultiplicityElementForm multiplicityElement;

	/**
	 * The MultiplicityElement to edit 
	 * @generated
	 */
	private MultiplicityElement multiplicityElementElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public MultiplicityElementSection() {
	
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
		multiplicityElement = new MultiplicityElementForm("Multiplicity Specifications","A multiplicity is a definition of an inclusive interval of non-negative integers beginning with a lower bound and ending with a (possibly infinite) upper bound. A multiplicity element embeds this information to specify the allowable cardinalities for an instantiation of this element.");
		return multiplicityElement;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//Specifies the upper bound of the multiplicity interval.
		//---------------------------------------------------------------------
		 
		//listener for a MultipleMappingDefinition of MultiplicityElement
		PropertyChangeListener<String> mutiplicityformListener= new PropertyChangeListener<String>(){
	
		public void propertyChanged(PropertyEditor editor, String newValue) {
			//parsing
			//injector to manage multimapping
			org.eclipse.papyrus.tabbedproperties.core.bridge.MultiplicityElementBridge bridge =new org.eclipse.papyrus.tabbedproperties.core.bridge.MultiplicityElementBridge();
			bridge.inject(newValue,multiplicityElementElement ,editingDomain);
		}
		};
		multiplicityElement.getMutiplicityform().setPropertyChangeListener(mutiplicityformListener);

		//---------------------------------------------------------------------
		//For a multivalued multiplicity, this attribute specifies whether the values in an instantiation of this element are sequentially ordered.
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature isOrdered of MultiplicityElement
		BooleanPropertyChangeListener isOrderedFormListener = new BooleanPropertyChangeListener(){
			public void propertyChanged(PropertyEditor editor, boolean newValue) {
			SetValueCommand command = new SetValueCommand(editingDomain,multiplicityElementElement, UMLPackage.eINSTANCE.getMultiplicityElement_IsOrdered(),newValue);		
			editingDomain.getCommandStack().execute(command);
			}
		};

		multiplicityElement.getIsOrderedForm().setPropertyChangeListener(isOrderedFormListener);

		//---------------------------------------------------------------------
		//For a multivalued multiplicity, this attributes specifies whether the values in an instantiation of this element are unique.
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature isUnique of MultiplicityElement
		BooleanPropertyChangeListener isUniqueFormListener = new BooleanPropertyChangeListener(){
			public void propertyChanged(PropertyEditor editor, boolean newValue) {
			SetValueCommand command = new SetValueCommand(editingDomain,multiplicityElementElement, UMLPackage.eINSTANCE.getMultiplicityElement_IsUnique(),newValue);		
			editingDomain.getCommandStack().execute(command);
			}
		};

		multiplicityElement.getIsUniqueForm().setPropertyChangeListener(isUniqueFormListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
		//extractor to manage multimapping
		org.eclipse.papyrus.tabbedproperties.core.bridge.MultiplicityElementBridge bridge =new org.eclipse.papyrus.tabbedproperties.core.bridge.MultiplicityElementBridge();
		multiplicityElement.getMutiplicityform().setValue(bridge.extract(multiplicityElementElement));

			 
				 
														   						multiplicityElement.getIsOrderedForm().setValue(multiplicityElementElement.isOrdered());
 
 

	

			 
				 
														   						multiplicityElement.getIsUniqueForm().setValue(multiplicityElementElement.isUnique());
 
 

	

 

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
    	this.multiplicityElementElement = (MultiplicityElement)getBusinessElement(input);
    	
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof MultiplicityElement;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		multiplicityElementElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		multiplicityElementElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(multiplicityElementElement!=null){
		multiplicityElementElement.eAdapters().remove(modelListener);}
		if(multiplicityElement!=null){
		multiplicityElement.dispose();
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