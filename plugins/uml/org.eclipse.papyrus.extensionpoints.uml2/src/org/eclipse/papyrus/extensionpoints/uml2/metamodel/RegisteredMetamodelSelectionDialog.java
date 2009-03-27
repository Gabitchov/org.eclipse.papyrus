/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.extensionpoints.uml2.metamodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.extensionpoints.uml2.Activator;
import org.eclipse.papyrus.extensionpoints.uml2.standard.ExtensionLabelProvider;
import org.eclipse.papyrus.extensionpoints.uml2.utils.Util;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.UMLFactory;


/**
 * 
 */
public class RegisteredMetamodelSelectionDialog extends ElementListSelectionDialog {

	/**
	 * 
	 */
	private EList importedMetamodels;
	
	/**
	 * 
	 */
	private List<String> importedMetamodelsNames;
	
	/**
	 * 
	 */
	private RegisteredMetamodel[] regMetamodels;
	
	/**
	 * 
	 */
	private Package currentModel;
	
	
	/**
	 * 
	 * 
	 * @param umlModel 
	 * @param parent 
	 */
	public RegisteredMetamodelSelectionDialog(Composite parent, Package umlModel) {
		super(parent.getShell(), new ExtensionLabelProvider());
		
		currentModel			= umlModel;
		importedMetamodels		= umlModel.getPackageImports();
		importedMetamodelsNames	= getImportedMetamodelsNames(importedMetamodels);
		
		// Retrieve registered Libraries
		regMetamodels			= RegisteredMetamodel.getRegisteredMetamodels();
		// remove already applied Libraries from the list
		regMetamodels			= removeAlreadyImportedFromSelection();
		
		this.setTitle("Import Metamodel from Papyrus repository :");
		this.setElements(regMetamodels);
	}
	
	/**
	 * 
	 */
	public void run() {
		this.open();
		this.treatSelection();
	}
	
	/**
	 * 
	 * 
	 * @param appliedLibraries 
	 * 
	 * @return 
	 */
	private List<String> getImportedMetamodelsNames(EList importedMetamodels) {
		
		List<String> Metamodels = new ArrayList<String>();
		Iterator importedIt =  importedMetamodels.iterator();
		
		while(importedIt.hasNext()) {
			org.eclipse.uml2.uml.PackageImport currentImport
								= (org.eclipse.uml2.uml.PackageImport) importedIt.next();
			String currentName	= currentImport.getImportedPackage().getName();
			Metamodels.add(currentName);
		}
		
		return Metamodels;
	}
	
	/**
	 * 
	 * 
	 * @return 
	 */
	private RegisteredMetamodel[] removeAlreadyImportedFromSelection() {
		
		List<RegisteredMetamodel> Metamodels = new ArrayList<RegisteredMetamodel>();		
		
		for (int i = 0 ; i < regMetamodels.length ; i++) {
			
			String currentName = regMetamodels[i].name;
			if (!importedMetamodelsNames.contains(currentName)) {
				Metamodels.add(regMetamodels[i]);
			}
		}
		
		RegisteredMetamodel[] cleanedList;
		cleanedList = Metamodels.toArray(new RegisteredMetamodel[Metamodels.size()]);
		
		return cleanedList;
	}
	
	/**
	 * 
	 */
	private void treatSelection() {
		
		// User selection
		Object[] selection		= this.getResult();
		
		if (selection == null) { // Cancel was selected
			return;
		}
		
		for (int i = 0 ; i < selection.length ; i++) {
			RegisteredMetamodel currentLibrary	= (RegisteredMetamodel) (selection[i]);
			URI modelUri = currentLibrary.uri;
			addModelImportFromURI(currentModel, modelUri);
			
		}
	}
	
	protected boolean addModelImportFromURI(Package currentModel, URI modelUri) {
		Resource modelResource	= Util.getResourceSet(currentModel).getResource(modelUri,true);
		
		if (modelResource.getContents().size() <= 0) {
			Activator.log("The selected uri ("+ modelUri.toString() +") does not contain any model library !");
			return false;
		}
		
		// Try to reach model
		Element root = (Element) modelResource.getContents().get(0);
		
		if (root instanceof Package) {
			
			// Import model library
			Package modelToImport = (Package) (modelResource.getContents().get(0));
			// create import package
			PackageImport modelImport = UMLFactory.eINSTANCE.createPackageImport();
			modelImport.setImportedPackage(modelToImport);
			
			return currentModel.getPackageImports().add(modelImport);
		}
		
		Activator.log("The selected uri ("+ modelUri.toString() +") does not contain any model library !");
		return false;
	}
}

