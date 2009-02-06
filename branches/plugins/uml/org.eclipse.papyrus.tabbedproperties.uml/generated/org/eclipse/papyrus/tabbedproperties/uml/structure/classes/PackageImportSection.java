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

import org.eclipse.uml2.uml.PackageImport;
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

import org.eclipse.papyrus.tabbedproperties.uml.figures.PackageImportForm;


import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.Package;

import org.eclipse.papyrus.tabbedproperties.core.commands.SetValueCommand;

//End of user code for user imports

/**
 * The PackageImport property section for the PackageImport element
 * 
 * A package import is a relationship that allows the use of unqualified names to refer to package members from other namespaces.
 *
 * @generated
 */
public class PackageImportSection extends AbstractEnhancedPropertySection implements IFilter {

	/**
	 * The section's form
	 * @generated 
	 */
	private PackageImportForm packageImport;

	/**
	 * The PackageImport to edit 
	 * @generated
	 */
	private PackageImport packageImportElement;

	/**
	 * The model element listener
	 * @generated
	 */
	private BusinessModelListener modelListener = new BusinessModelListener();

	/**
	 * Default constructor
	 * @generated
	 */
	public PackageImportSection() {
	
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
		packageImport = new PackageImportForm("Package Import Specifications","A package import is a relationship that allows the use of unqualified names to refer to package members from other namespaces.");
		return packageImport;
	}

    /**
     * Initialize the form
     * @generated
     */
	public void initializeFigure()
	{
				//---------------------------------------------------------------------
		//Specifies the visibility of the imported PackageableElements within the importing Namespace, i.e., whether imported elements will in turn be visible to other packages that use that importingPackage as an importedPackage. If the PackageImport is public, the imported elements will be visible outside the package, while if it is private they will not.
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature visibility of PackageImport
		PropertyChangeListener<VisibilityKind> visibilityListener = new PropertyChangeListener<VisibilityKind>(){
		   public void propertyChanged(PropertyEditor editor, VisibilityKind newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, packageImportElement, UMLPackage.eINSTANCE.getPackageImport_Visibility(), newValue);
			editingDomain.getCommandStack().execute(command);
			}
		};

		packageImport.getVisibility().setPropertyChangeListener(visibilityListener);

		//---------------------------------------------------------------------
		//mapping to show the imported package
		//---------------------------------------------------------------------
				
			 
		//listener for a simple feature importedPackage of PackageImport
		PropertyChangeListener<Package> importedPackageListener = new PropertyChangeListener<Package>(){
		   public void propertyChanged(PropertyEditor editor, Package newValue) {
				SetValueCommand command = new SetValueCommand(editingDomain, packageImportElement, UMLPackage.eINSTANCE.getPackageImport_ImportedPackage(), newValue);
			editingDomain.getCommandStack().execute(command);
			}
		};

		packageImport.getImportedPackage().setPropertyChangeListener(importedPackageListener);
		//create listener to create directly element
		CreateElementListener importedPackageCreateListener= new CreateElementListener(){
			public void mouseUp(MouseEvent e) {
			//
				CreateElementCommand command= new CreateElementCommand(editingDomain,packageImportElement,UMLPackage.eINSTANCE.getPackageImport_ImportedPackage(),UMLPackage.eINSTANCE.getPackage());
				editingDomain.getCommandStack().execute(command);
			}
		};
		//this is not a container or it is abstract
		packageImport.getImportedPackage().setCreateElement(importedPackageCreateListener);
		//set the navigation service
		packageImport.getImportedPackage().setNavigationListener(navigationListener);


	}

    /**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void refresh() {
		super.refresh();
					 
				 
											  
		packageImport.getVisibility().setSelected(packageImportElement.getVisibility());
 

	

			 
				 
														   				 
		//set simple Referenced Element
		if(packageImportElement.getImportedPackage()==null){
		    packageImport.getImportedPackage().setValue("<UNDEFINED>");}
		else{
			packageImport.getImportedPackage().setValue(packageImportElement.getImportedPackage().getQualifiedName());
			navigationListener.setTheElement(packageImportElement.getImportedPackage());
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
    	this.packageImportElement = (PackageImport)getBusinessElement(input);
    	
		 // setup the backbone for referencedElementForm
		packageImport.getImportedPackage().setBackboneContext(backbone);
	}


    /**
     * Return true if this section can select such element.
     * @param toTest the element to test
     * @return true if this section can select such element.
     * @generated
     */
	public boolean select(Object toTest) {
		return getBusinessElement(toTest) instanceof PackageImport;
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		// Listen to the model
		packageImportElement.eAdapters().add(modelListener);
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void aboutToBeHidden() {
		// Stop listening
		packageImportElement.eAdapters().remove(modelListener);
		super.aboutToBeHidden();
	}

	/**
     * @{inheritDoc}
     * @generated
     */
    @Override
	public void dispose() {
		// stop listening
		if(packageImportElement!=null){
		packageImportElement.eAdapters().remove(modelListener);}
		if(packageImport!=null){
		packageImport.dispose();
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