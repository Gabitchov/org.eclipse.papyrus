/*****************************************************************************
 * Copyright (c) 2011, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - Refactoring package/profile import/apply UI for CDO
 *  Christian W. Damus (CEA) - bug 323802
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.importt.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.uml.extensionpoints.library.FilteredRegisteredLibrariesSelectionDialog;
import org.eclipse.papyrus.uml.extensionpoints.library.RegisteredLibrary;
import org.eclipse.papyrus.uml.extensionpoints.utils.Util;
import org.eclipse.papyrus.uml.importt.ui.PackageImportDialog;
import org.eclipse.papyrus.uml.profile.ui.dialogs.ElementImportTreeSelectionDialog.ImportSpec;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Package;


public class ImportRegisteredPackageHandler extends AbstractImportHandler {

	@Override
	protected ICommand getGMFCommand() {
		return new ImportLibraryFromRepositoryCommand();
	}

	/**
	 * Apply the result of the dialog, i.e. it adds package imports to libraries
	 *
	 * @param librariesToImport
	 *        the array of Libraries to import
	 */
	protected void importLibraries(RegisteredLibrary[] librariesToImport) {
		// retrieve the current resource set
		ResourceSet resourceSet = Util.createTemporaryResourceSet();

		for(int i = 0; i < librariesToImport.length; i++) {
			RegisteredLibrary currentLibrary = (librariesToImport[i]);
			URI modelUri = currentLibrary.uri;

			Resource modelResource = resourceSet.getResource(modelUri, true);
			PackageImportDialog dialog = new PackageImportDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), ((Package)modelResource.getContents().get(0)));

			if(dialog.open() == Window.OK) {
				Collection<ImportSpec<Package>> result = dialog.getResult();

				for(ImportSpec<Package> resultElement : result) {
					Package selectedPackage = resultElement.getElement();
					switch(resultElement.getAction()) {
					case COPY:
						handleCopyPackage(selectedPackage);
						break;
					case IMPORT:
						handleImportPackage(selectedPackage);
						break;
					default: //Load
						handleLoadPackage(selectedPackage);
						break;
					}
				}
			}
		}
	}

	/**
	 * Returns the array of available libraries for the currently selected package.
	 * <p>
	 * It returns all registered libraries except the already imported ones.
	 * </p>
	 *
	 * @return the array of available libraries for the currently selected package
	 */
	protected RegisteredLibrary[] getAvailableLibraries() {
		List<RegisteredLibrary> libraries = new ArrayList<RegisteredLibrary>();
		RegisteredLibrary[] allLibraries = RegisteredLibrary.getRegisteredLibraries();
		for(int i = 0; i < allLibraries.length; i++) {
			RegisteredLibrary registeredLibrary = allLibraries[i];
			List<String> importedPackageNames = PackageUtil.getImportedPackagesNames((Package)getSelectedElement());
			if(!(importedPackageNames.contains(registeredLibrary.getName()))) {
				libraries.add(registeredLibrary);
			}
		}
		return libraries.toArray(new RegisteredLibrary[libraries.size()]);
	}

	/**
	 * Returns the array of already selected libraries for the currently selected package.
	 * <p>
	 * It returns all already imported libraries.
	 * </p>
	 *
	 * @return the array of already selected libraries for the currently selected package
	 */
	protected Collection<RegisteredLibrary> getImportedLibraries() {
		List<RegisteredLibrary> libraries = new ArrayList<RegisteredLibrary>();
		RegisteredLibrary[] allLibraries = RegisteredLibrary.getRegisteredLibraries();
		for(int i = 0; i < allLibraries.length; i++) {
			RegisteredLibrary registeredLibrary = allLibraries[i];
			List<String> importedPackageNames = PackageUtil.getImportedPackagesNames((Package)getSelectedElement());
			// problem: name of library might be different from name of top-level package
			if(importedPackageNames.contains(registeredLibrary.getName())) {
				libraries.add(registeredLibrary);
			}
		}
		return libraries;
	}

	/**
	 * Specific {@link ChangeCommand} that imports libraries from repository
	 */
	public class ImportLibraryFromRepositoryCommand extends AbstractImportCommand {

		/**
		 * Creates a new ImportLibraryFromRepositoryCommand
		 *
		 * @param editingDomain
		 *        editing domain that manages the changed objects
		 * @param runnable
		 *        process that executes the modifications
		 * @param label
		 *        the label of the command
		 * @param description
		 *        description of the command
		 */
		public ImportLibraryFromRepositoryCommand() {
			super(new Runnable() {

				public void run() {
					// Retrieve shell instance
					Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

					// get the set of registered libraries available
					RegisteredLibrary[] allLibraries = RegisteredLibrary.getRegisteredLibraries();

					// Open Registered ModelLibrary selection dialog
					FilteredRegisteredLibrariesSelectionDialog dialog = new FilteredRegisteredLibrariesSelectionDialog(shell, true, allLibraries, getImportedLibraries());
					dialog.open();
					if(Dialog.OK == dialog.getReturnCode()) {
						// get the result, which is the set of libraries to import
						List<Object> librariesToImport = Arrays.asList(dialog.getResult());
						importLibraries(librariesToImport.toArray(new RegisteredLibrary[librariesToImport.size()]));
					}
				}
			}, "Import Libraries", "Import Libraries from Repository"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
}
