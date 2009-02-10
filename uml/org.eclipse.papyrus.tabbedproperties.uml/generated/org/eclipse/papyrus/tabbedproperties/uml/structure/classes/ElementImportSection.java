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

import org.eclipse.uml2.uml.ElementImport;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.ElementImportForm;


import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.PackageableElement;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The ElementImport property section for the ElementImport element
 * 
 * An element import identifies an element in another package, and allows the element to be referenced using its name without a qualifier.
 *
 * @generated
 */
public class ElementImportSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private ElementImportForm elementImport;

	/**
	 * The ElementImport to edit 
	 * @generated
	 */
	private ElementImport elementImportElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public ElementImportSection() {
	
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
		elementImport = new ElementImportForm("Element Import Specifications","An element import identifies an element in another package, and allows the element to be referenced using its name without a qualifier.");
		return elementImport;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//Specifies the visibility of the imported PackageableElement within the importing Package. The default visibility is the same as that of the imported element. If the imported element does not have a visibility, it is possible to add visibility to the element import.
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature visibility of ElementImport
		PropertyChangeListener<VisibilityKind> visibilityListener = new PropertyChangeListener<VisibilityKind>(){
		   public void propertyChanged(PropertyEditor editor, VisibilityKind newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, elementImportElement, UMLPackage.eINSTANCE.getElementImport_Visibility(), newValue);
			editingDomain.getCommandStack().execute(command);
			}
		};

		elementImport.getVisibility().setPropertyChangeListener(visibilityListener);

		//---------------------------------------------------------------------
		//Specifies the name that should be added to the namespace of the importing package in lieu of the name of the imported packagable element. The aliased name must not clash with any other member name in the importing package. By default, no alias is used.
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature alias of ElementImport
		PropertyChangeListener<String> aliasFormListener = new PropertyChangeListener<String>(){
		   public void propertyChanged(PropertyEditor editor, java.lang.String newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, elementImportElement, UMLPackage.eINSTANCE.getElementImport_Alias(), newValue);
			editingDomain.getCommandStack().execute(command);
			}
		};

		elementImport.getAliasForm().setPropertyChangeListener(aliasFormListener);

		//---------------------------------------------------------------------
		//mapping to display the imported element
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature importedElement of ElementImport
		PropertyChangeListener<PackageableElement> importedElementListener = new PropertyChangeListener<PackageableElement>(){
		   public void propertyChanged(PropertyEditor editor, PackageableElement newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, elementImportElement, UMLPackage.eINSTANCE.getElementImport_ImportedElement(), newValue);
			editingDomain.getCommandStack().execute(command);
			}
		};

		elementImport.getImportedElement().setPropertyChangeListener(importedElementListener);
		//create listener to create directly element
		CreateElementListener importedElementCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,elementImportElement,UMLPackage.eINSTANCE.getElementImport_ImportedElement(),UMLPackage.eINSTANCE.getPackageableElement());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is not a container or it is abstract
		elementImport.getImportedElement().setCreateElement(importedElementCreateListener);
		elementImport.getImportedElement().setAbstractElement(true);
		//set the navigation service
		elementImport.getImportedElement().setNavigationListener(navigationListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
				 
											  
		elementImport.getVisibility().setSelected(elementImportElement.getVisibility());
 

	

			 
				 
														   						elementImport.getAliasForm().setValue(elementImportElement.getAlias());
 
 

	

			 
				 
														   				 
		//set simple Referenced Element
		if(elementImportElement.getImportedElement()==null){
		    elementImport.getImportedElement().setValue("<UNDEFINED>");}
		else{
			elementImport.getImportedElement().setValue(elementImportElement.getImportedElement().getQualifiedName());
			navigationListener.setTheElement(elementImportElement.getImportedElement());
			}
							
 
 

	

 

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
    	this.elementImportElement = (ElementImport)getBusinessElement(input);
    	
		 // setup the backbone for referencedElementForm
		elementImport.getImportedElement().setBackboneContext(backbone);
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof ElementImport;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		elementImportElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		elementImportElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(elementImportElement!=null){
		elementImportElement.eAdapters().remove(modelListener);}
		if(elementImport!=null){
		elementImport.dispose();
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