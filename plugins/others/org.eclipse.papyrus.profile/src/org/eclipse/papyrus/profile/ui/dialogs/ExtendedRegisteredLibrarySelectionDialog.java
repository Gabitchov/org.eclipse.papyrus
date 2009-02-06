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
package org.eclipse.papyrus.profile.ui.dialogs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.extensionpoints.uml2.library.FilteredRegisteredLibrariesSelectionDialog;
import org.eclipse.papyrus.extensionpoints.uml2.library.RegisteredLibrary;
import org.eclipse.papyrus.extensionpoints.uml2.standard.ExtensionLabelProvider;
import org.eclipse.papyrus.extensionpoints.uml2.utils.Util;
import org.eclipse.papyrus.profile.Activator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.UMLFactory;


/**
 * @deprecated
 * @use {@link FilteredRegisteredProfilesAsLibrarySelectionDialog} instead
 */
public class ExtendedRegisteredLibrarySelectionDialog extends ElementListSelectionDialog {

	/**
	 * 
	 */
	private EList importedLibraries;
	
	/**
	 * 
	 */
	private List<String> importedLibrariesNames;
	
	/**
	 * 
	 */
	private RegisteredLibrary[] regLibraries;
	
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
	public ExtendedRegisteredLibrarySelectionDialog(Composite parent, Package umlModel) {
		super(parent.getShell(), new ExtensionLabelProvider());
		
		currentModel			= umlModel;
		importedLibraries		= umlModel.getPackageImports();
		importedLibrariesNames	= getImportedLibraryNames(importedLibraries);
		
		// Retrieve registered Libraries
		regLibraries			= RegisteredLibrary.getRegisteredLibraries();
		// remove already applied Libraries from the list
		regLibraries			= removeAlreadyImportededFromSelection();
		
		this.setTitle("Apply Libraries from Papyrus repository :");
		this.setElements(regLibraries);
	}
	
	/**
	 * 
	 */
	public void run() {
		int returnCode = this.open();
		// this.treatSelection();
		if(returnCode == OK) {
			// some libraries have been chosen. These libraries can have nested librairies
			// a new dialog window should be opened
			Object[] selection		= this.getResult();
			
			if (selection == null) { // Cancel was selected. should never happened.
				return;
			}
			ResourceSet resourceSet = Util.getResourceSet(currentModel);
			for (int i = 0 ; i < selection.length ; i++) {
				RegisteredLibrary currentLibrary	= (RegisteredLibrary) (selection[i]);
				URI modelUri = currentLibrary.uri;
				
				Resource modelResource = resourceSet.getResource(modelUri,true);
				PackageImportTreeSelectionDialog eisd = new PackageImportTreeSelectionDialog(
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
						((Package)modelResource.getContents().get(0)));
				int ret = eisd.open();

				if(ret==Window.OK){
					ArrayList result = eisd.getResult();
					Iterator resultIter = result.iterator();
					while(resultIter.hasNext()){
						Element element = (Element)resultIter.next();
						PackageImport ei = UMLFactory.eINSTANCE.createPackageImport();
						ei.setImportedPackage((Package)element);
						currentModel.getPackageImports().add(ei);
					}
				}
			}
		}
		
	}
	
	/**
	 * 
	 * 
	 * @param appliedLibraries 
	 * 
	 * @return 
	 */
	private List<String> getImportedLibraryNames(EList appliedLibraries) {
		
		List<String> Libraries = new ArrayList<String>();
		Iterator importedIt =  appliedLibraries.iterator();
		
		while(importedIt.hasNext()) {
			org.eclipse.uml2.uml.PackageImport currentImport
								= (org.eclipse.uml2.uml.PackageImport) importedIt.next();
			String currentName	= currentImport.getImportedPackage().getName();
			Libraries.add(currentName);
		}
		
		return Libraries;
	}
	
	/**
	 * 
	 * 
	 * @return 
	 */
	private RegisteredLibrary[] removeAlreadyImportededFromSelection() {
		
		List<RegisteredLibrary> Libraries = new ArrayList<RegisteredLibrary>();		
		
		for (int i = 0 ; i < regLibraries.length ; i++) {
			
			String currentName = regLibraries[i].name;
			if (!importedLibrariesNames.contains(currentName)) {
				Libraries.add(regLibraries[i]);
			}
		}
		
		RegisteredLibrary[] cleandList;
		cleandList = Libraries.toArray(new RegisteredLibrary[Libraries.size()]);
		
		return cleandList;
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
			
			RegisteredLibrary currentLibrary	= (RegisteredLibrary) (selection[i]);
			URI modelUri = currentLibrary.uri;
				
			addModelLibraryImportFromURI(modelUri);
		}
	}
	
	/**
	 * 
	 * 
	 * @param uri 
	 * 
	 * @return 
	 */
	public boolean addModelLibraryImportFromURI(URI uri) {
		
		ResourceSet resourceSet	= Util.getResourceSet(currentModel);
		Resource modelResource	= resourceSet.getResource(uri,true);
		
		if (modelResource.getContents().size() <= 0) {
			Activator.logError("No element found in model from URI "+uri.toString());
			return false;
		}
		
		// Try to reach model
		Element root = (Element) modelResource.getContents().get(0);
		
		if (root instanceof Package) {
			
			// Import model library
			Package libToImport = (Package) (modelResource.getContents().get(0));
			// create import package
			PackageImport modelLibImport = UMLFactory.eINSTANCE.createPackageImport();
			modelLibImport.setImportedPackage(libToImport);
			return currentModel.getPackageImports().add(modelLibImport);
		}
		
		Activator.logError("The selected uri ("+ uri.toString() +") does not contain any model library !");
		return false;
	}
}

