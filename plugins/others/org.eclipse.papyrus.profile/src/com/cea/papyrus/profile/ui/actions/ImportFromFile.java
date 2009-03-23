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
package com.cea.papyrus.profile.ui.actions;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.UMLFactory;

import com.cea.papyrus.extensionpoints.uml2.utils.Util;
import com.cea.papyrus.profile.ui.dialogs.PackageImportTreeSelectionDialog;

// TODO: Auto-generated Javadoc
/**
 * The Class ImportFromFile.
 */
public class ImportFromFile extends AbstractViewActionDelegate {

	/**
	 * Run.
	 * 
	 * @param action the action
	 */
	@Override
	public void run(IAction action) {
		// TODO Auto-generated method stub


		// Retrieve shell instance
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		// Start selection dialog
		ResourceSelectionDialog chooseLib = 
			new ResourceSelectionDialog (
					shell
					, ResourcesPlugin.getWorkspace().getRoot()
					, "Select Registered ModelLibrary");

		chooseLib.open();


		// User selection
		Object[] selection		= chooseLib.getResult();

		if (selection == null) { // Cancel was selected
			return;
		}

		ResourceSet resourceSet	= Util.getResourceSet(selectedElement);
		// Parse selection and add ModelLibrary files
		for (int i = 0 ; i < selection.length ; i++) {

			if (selection[i] instanceof IFile) {

				IFile currentFile		= (IFile) selection[i];

				URI modelUri			= URI.createURI("platform:/resource"+currentFile.getFullPath());
				Resource modelResource	= resourceSet.getResource(modelUri, true);

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
						((Package)selectedElement).getPackageImports().add(ei);
					}
				}
				
				
				/*
				Element root = (Element) modelResource.getContents().get(0);

				// Import model library
				Package libToImport = (Package) root;
				// create import package
				PackageImport pi = UMLFactory.eINSTANCE.createPackageImport();
				pi.setImportedPackage(libToImport);
				((Package) selectedElement).getPackageImports().add(pi);
				*/
			}						
		}
	}
}
