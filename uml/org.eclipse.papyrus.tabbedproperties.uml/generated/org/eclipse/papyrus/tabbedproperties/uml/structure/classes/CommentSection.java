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

import org.eclipse.uml2.uml.Comment;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.CommentForm;


import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The Comment property section for the Comment element
 * 
 *
 * @generated
 */
public class CommentSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private CommentForm comment;

	/**
	 * The Comment to edit 
	 * @generated
	 */
	private Comment commentElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public CommentSection() {
	
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
		comment = new CommentForm("Comment Specifications","A comment is a textual annotation that can be attached to a set of elements.");
		return comment;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//to see the body of the comment as a block
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature body of Comment
		PropertyChangeListener<String> bodyListener = new PropertyChangeListener<String>(){
		   public void propertyChanged(PropertyEditor editor, java.lang.String newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, commentElement, UMLPackage.eINSTANCE.getComment_Body(), newValue);
			editingDomain.getCommandStack().execute(command);
			}
		};

		comment.getBody().setPropertyChangeListener(bodyListener);

		//---------------------------------------------------------------------
		//to see annotatedElement
		//---------------------------------------------------------------------
				
			 
		//more complex listener to manage 0..* feature annotatedElement of Comment
		ListPropertyChangeListener<Element> annotatedElementListener =new ListPropertyChangeListener<Element>(){
			public void addValue(PropertyEditor editor, Element newValue) {
				// TODO Auto-generated method stub
				AddReferenceCommand command = new AddReferenceCommand(editingDomain,commentElement,UMLPackage.eINSTANCE.getComment_AnnotatedElement(),newValue);
				editingDomain.getCommandStack().execute(command);
			}

			public void moveValue(PropertyEditor editor, Element newValue,
					int newIndex) {
				MoveReferenceCommand command = new MoveReferenceCommand(editingDomain,commentElement,UMLPackage.eINSTANCE.getComment_AnnotatedElement(),newValue,newIndex);
				editingDomain.getCommandStack().execute(command);
				
			}

			public void removeValue(PropertyEditor editor, Element removedValue) {
				RemoveReferenceCommand command = new RemoveReferenceCommand(editingDomain,commentElement,UMLPackage.eINSTANCE.getComment_AnnotatedElement(),removedValue);
				editingDomain.getCommandStack().execute(command);	
			}
		};

		comment.getAnnotatedElement().setPropertyChangeListener(annotatedElementListener);
		//create listener to create directly element
		CreateElementListener annotatedElementCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,commentElement,UMLPackage.eINSTANCE.getComment_AnnotatedElement(),UMLPackage.eINSTANCE.getElement());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is not a container or it is abstract
		comment.getAnnotatedElement().setCreateElement(annotatedElementCreateListener);
		comment.getAnnotatedElement().setAbstractElement(true);
		//set the navigation service
		comment.getAnnotatedElement().setNavigationListener(navigationListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
				 
														   						comment.getBody().setValue(commentElement.getBody());
 
 

	

			 
						//set many referenced Element
		comment.getAnnotatedElement().setValue((java.util.List)commentElement.eGet(UMLPackage.eINSTANCE.getComment_AnnotatedElement()));
	

 

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
    	this.commentElement = (Comment)getBusinessElement(input);
    	
		 // setup the backbone for referencedElementForm
		comment.getAnnotatedElement().setBackboneContext(backbone);
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof Comment;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		commentElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		commentElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(commentElement!=null){
		commentElement.eAdapters().remove(modelListener);}
		if(comment!=null){
		comment.dispose();
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