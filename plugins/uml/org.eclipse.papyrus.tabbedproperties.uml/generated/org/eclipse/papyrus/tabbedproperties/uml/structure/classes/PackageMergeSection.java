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

import org.eclipse.uml2.uml.PackageMerge;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.PackageMergeFormForm;


import org.eclipse.uml2.uml.PackageMerge;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Package;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The PackageMerge property section for the PackageMerge element
 * 
 * A package merge defines how the contents of one package are extended by the contents of another package.
 *
 * @generated
 */
public class PackageMergeSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private PackageMergeFormForm packageMergeForm;

	/**
	 * The PackageMerge to edit 
	 * @generated
	 */
	private PackageMerge packageMergeElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public PackageMergeSection() {
	
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
		packageMergeForm = new PackageMergeFormForm("","A package merge defines how the contents of one package are extended by the contents of another package.");
		packageMergeForm.setBackContext(backbone);
		return packageMergeForm;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//mapping package Merge
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature mergedPackage of PackageMerge
		PropertyChangeListener<Package> mergedPackageListener = new PropertyChangeListener<Package>(){
		   public void propertyChanged(PropertyEditor editor, Package newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, packageMergeElement, UMLPackage.eINSTANCE.getPackageMerge_MergedPackage(), newValue);
			editingDomain.getCommandStack().execute(command);
			}
		};

		packageMergeForm.getMergedPackage().setPropertyChangeListener(mergedPackageListener);
		//create listener to create directly element
		CreateElementListener mergedPackageCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,packageMergeElement,UMLPackage.eINSTANCE.getPackageMerge_MergedPackage(),UMLPackage.eINSTANCE.getPackage());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is not a container or it is abstract
		packageMergeForm.getMergedPackage().setCreateElement(mergedPackageCreateListener);
		//set the navigation service
		packageMergeForm.getMergedPackage().setNavigationListener(navigationListener);

		//---------------------------------------------------------------------
		//mapping receivingPackage
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature receivingPackage of PackageMerge
		PropertyChangeListener<Package> receivingPackageListener = new PropertyChangeListener<Package>(){
		   public void propertyChanged(PropertyEditor editor, Package newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, packageMergeElement, UMLPackage.eINSTANCE.getPackageMerge_ReceivingPackage(), newValue);
			editingDomain.getCommandStack().execute(command);
			}
		};

		packageMergeForm.getReceivingPackage().setPropertyChangeListener(receivingPackageListener);
		//create listener to create directly element
		CreateElementListener receivingPackageCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,packageMergeElement,UMLPackage.eINSTANCE.getPackageMerge_ReceivingPackage(),UMLPackage.eINSTANCE.getPackage());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is not a container or it is abstract
		packageMergeForm.getReceivingPackage().setCreateElement(receivingPackageCreateListener);
		//set the navigation service
		packageMergeForm.getReceivingPackage().setNavigationListener(navigationListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
				 
														   				 
		//set simple Referenced Element
		if(packageMergeElement.getMergedPackage()==null){
		    packageMergeForm.getMergedPackage().setValue("<UNDEFINED>");}
		else{
			packageMergeForm.getMergedPackage().setValue(packageMergeElement.getMergedPackage().getQualifiedName());
			navigationListener.setTheElement(packageMergeElement.getMergedPackage());
			}
							
 
 

	

			 
				 
														   				 
		//set simple Referenced Element
		if(packageMergeElement.getReceivingPackage()==null){
		    packageMergeForm.getReceivingPackage().setValue("<UNDEFINED>");}
		else{
			packageMergeForm.getReceivingPackage().setValue(packageMergeElement.getReceivingPackage().getQualifiedName());
			navigationListener.setTheElement(packageMergeElement.getReceivingPackage());
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
    	this.packageMergeElement = (PackageMerge)getBusinessElement(input);
    	
		 // setup the backbone for referencedElementForm
		packageMergeForm.getMergedPackage().setBackboneContext(backbone);
		 // setup the backbone for referencedElementForm
		packageMergeForm.getReceivingPackage().setBackboneContext(backbone);
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof PackageMerge;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		packageMergeElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		packageMergeElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(packageMergeElement!=null){
		packageMergeElement.eAdapters().remove(modelListener);}
		if(packageMergeForm!=null){
		packageMergeForm.dispose();
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