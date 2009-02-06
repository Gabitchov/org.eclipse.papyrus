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

import org.eclipse.uml2.uml.OpaqueExpression;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.OpaqueExpressionForm;


import org.eclipse.uml2.uml.OpaqueExpression;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The OpaqueExpression property section for the OpaqueExpression element
 * 
 * An opaque expression is an uninterpreted textual statement that denotes a (possibly empty) set of values when evaluated in a context.
 * Provides a mechanism for precisely defining the behavior of an opaque expression. An opaque expression is defined by a behavior restricted to return one result.
 *
 * @generated
 */
public class OpaqueExpressionSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private OpaqueExpressionForm opaqueExpression;

	/**
	 * The OpaqueExpression to edit 
	 * @generated
	 */
	private OpaqueExpression opaqueExpressionElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public OpaqueExpressionSection() {
	
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
		opaqueExpression = new OpaqueExpressionForm("Opaque Expression Specifications","An opaque expression is an uninterpreted textual statement that denotes a (possibly empty) set of values when evaluated in a context."+
""+
"Provides a mechanism for precisely defining the behavior of an opaque expression. An opaque expression is defined by a behavior restricted to return one result.");
		return opaqueExpression;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//The text of the expression, possibly in multiple languages.
		//---------------------------------------------------------------------
				
			 
		//more complex listener to manage 0..* feature body of OpaqueExpression
		ListPropertyChangeListener<String> bodyFormListener =new ListPropertyChangeListener<String>(){
			public void addValue(PropertyEditor editor, String newValue) {
				// TODO Auto-generated method stub
				AddReferenceCommand command = new AddReferenceCommand(editingDomain,opaqueExpressionElement,UMLPackage.eINSTANCE.getOpaqueExpression_Body(),newValue);
				editingDomain.getCommandStack().execute(command);
			}

			public void moveValue(PropertyEditor editor, String newValue,
					int newIndex) {
				MoveReferenceCommand command = new MoveReferenceCommand(editingDomain,opaqueExpressionElement,UMLPackage.eINSTANCE.getOpaqueExpression_Body(),newValue,newIndex);
				editingDomain.getCommandStack().execute(command);
				
			}

			public void removeValue(PropertyEditor editor, String removedValue) {
				RemoveReferenceCommand command = new RemoveReferenceCommand(editingDomain,opaqueExpressionElement,UMLPackage.eINSTANCE.getOpaqueExpression_Body(),removedValue);
				editingDomain.getCommandStack().execute(command);	
			}
		};

		opaqueExpression.getBodyForm().setPropertyChangeListener(bodyFormListener);

		//---------------------------------------------------------------------
		//Specifies the languages in which the expression is stated. The interpretation of the expression body depends on the languages. If the languages are unspecified, they might be implicit from the expression body or the context. Languages are matched to body strings by order.
		//---------------------------------------------------------------------
				
			 
		//more complex listener to manage 0..* feature language of OpaqueExpression
		ListPropertyChangeListener<String> languageFormListener =new ListPropertyChangeListener<String>(){
			public void addValue(PropertyEditor editor, String newValue) {
				// TODO Auto-generated method stub
				AddReferenceCommand command = new AddReferenceCommand(editingDomain,opaqueExpressionElement,UMLPackage.eINSTANCE.getOpaqueExpression_Language(),newValue);
				editingDomain.getCommandStack().execute(command);
			}

			public void moveValue(PropertyEditor editor, String newValue,
					int newIndex) {
				MoveReferenceCommand command = new MoveReferenceCommand(editingDomain,opaqueExpressionElement,UMLPackage.eINSTANCE.getOpaqueExpression_Language(),newValue,newIndex);
				editingDomain.getCommandStack().execute(command);
				
			}

			public void removeValue(PropertyEditor editor, String removedValue) {
				RemoveReferenceCommand command = new RemoveReferenceCommand(editingDomain,opaqueExpressionElement,UMLPackage.eINSTANCE.getOpaqueExpression_Language(),removedValue);
				editingDomain.getCommandStack().execute(command);	
			}
		};

		opaqueExpression.getLanguageForm().setPropertyChangeListener(languageFormListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
						//set many referenced Element
		opaqueExpression.getBodyForm().setValue((java.util.List)opaqueExpressionElement.eGet(UMLPackage.eINSTANCE.getOpaqueExpression_Body()));
	

			 
						//set many referenced Element
		opaqueExpression.getLanguageForm().setValue((java.util.List)opaqueExpressionElement.eGet(UMLPackage.eINSTANCE.getOpaqueExpression_Language()));
	

 

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
    	this.opaqueExpressionElement = (OpaqueExpression)getBusinessElement(input);
    	
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof OpaqueExpression;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		opaqueExpressionElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		opaqueExpressionElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(opaqueExpressionElement!=null){
		opaqueExpressionElement.eAdapters().remove(modelListener);}
		if(opaqueExpression!=null){
		opaqueExpression.dispose();
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