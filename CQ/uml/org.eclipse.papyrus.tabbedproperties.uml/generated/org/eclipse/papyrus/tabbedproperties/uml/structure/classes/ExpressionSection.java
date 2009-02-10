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

import org.eclipse.uml2.uml.Expression;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.ExpressionFormForm;


import org.eclipse.uml2.uml.Expression;
import org.eclipse.uml2.uml.ValueSpecification;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The Expression property section for the Expression element
 * 
 * An expression is a structured tree of symbols that denotes a (possibly empty) set of values when evaluated in a context.
 * An expression represents a node in an expression tree, which may be non-terminal or terminal. It defines a symbol, and has a possibly empty sequence of operands which are value specifications.
 *
 * @generated
 */
public class ExpressionSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private ExpressionFormForm expressionForm;

	/**
	 * The Expression to edit 
	 * @generated
	 */
	private Expression expressionElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public ExpressionSection() {
	
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
		expressionForm = new ExpressionFormForm("","An expression is a structured tree of symbols that denotes a (possibly empty) set of values when evaluated in a context."+
""+
"An expression represents a node in an expression tree, which may be non-terminal or terminal. It defines a symbol, and has a possibly empty sequence of operands which are value specifications.");
		expressionForm.setBackContext(backbone);
		return expressionForm;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//The symbol associated with the node in the expression tree.
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature symbol of Expression
		PropertyChangeListener<String> symbolListener = new PropertyChangeListener<String>(){
		   public void propertyChanged(PropertyEditor editor, java.lang.String newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, expressionElement, UMLPackage.eINSTANCE.getExpression_Symbol(), newValue);
			editingDomain.getCommandStack().execute(command);
			}
		};

		expressionForm.getSymbol().setPropertyChangeListener(symbolListener);

		//---------------------------------------------------------------------
		//mapping operands
		//---------------------------------------------------------------------
				
			 
		//more complex listener to manage 0..* feature operand of Expression
		ListPropertyChangeListener<ValueSpecification> operandListener =new ListPropertyChangeListener<ValueSpecification>(){
			public void addValue(PropertyEditor editor, ValueSpecification newValue) {
				// TODO Auto-generated method stub
				AddReferenceCommand command = new AddReferenceCommand(editingDomain,expressionElement,UMLPackage.eINSTANCE.getExpression_Operand(),newValue);
				editingDomain.getCommandStack().execute(command);
			}

			public void moveValue(PropertyEditor editor, ValueSpecification newValue,
					int newIndex) {
				MoveReferenceCommand command = new MoveReferenceCommand(editingDomain,expressionElement,UMLPackage.eINSTANCE.getExpression_Operand(),newValue,newIndex);
				editingDomain.getCommandStack().execute(command);
				
			}

			public void removeValue(PropertyEditor editor, ValueSpecification removedValue) {
				RemoveReferenceCommand command = new RemoveReferenceCommand(editingDomain,expressionElement,UMLPackage.eINSTANCE.getExpression_Operand(),removedValue);
				editingDomain.getCommandStack().execute(command);	
			}
		};

		expressionForm.getOperand().setPropertyChangeListener(operandListener);
		//this a value Specification
		expressionForm.getOperand().setValueSpecification(true);
		//create listener to create directly element
		CreateElementListener operandCreateListener= new CreateElementListener(){
			public void fireCreate(EClass eclass) {
				CreateElementCommand command= new CreateElementCommand(editingDomain,expressionElement,UMLPackage.eINSTANCE.getExpression_Operand(),eclass);
				editingDomain.getCommandStack().execute(command);
			}
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,expressionElement,UMLPackage.eINSTANCE.getExpression_Operand(),UMLPackage.eINSTANCE.getValueSpecification());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is not a container or it is abstract
		expressionForm.getOperand().setCreateElement(operandCreateListener);
		expressionForm.getOperand().setAbstractElement(true);
		//set the navigation service
		expressionForm.getOperand().setNavigationListener(navigationListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
				 
														   						expressionForm.getSymbol().setValue(expressionElement.getSymbol());
 
 

	

			 
						//set many referenced Element
		expressionForm.getOperand().setValue((java.util.List)expressionElement.eGet(UMLPackage.eINSTANCE.getExpression_Operand()));
	

 

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
    	this.expressionElement = (Expression)getBusinessElement(input);
    	
		 // setup the backbone for referencedElementForm
		expressionForm.getOperand().setBackboneContext(backbone);
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof Expression;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		expressionElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		expressionElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(expressionElement!=null){
		expressionElement.eAdapters().remove(modelListener);}
		if(expressionForm!=null){
		expressionForm.dispose();
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