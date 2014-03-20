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

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.uml.importt.ui.PackageImportDialog;
import org.eclipse.papyrus.uml.profile.ui.dialogs.ElementImportTreeSelectionDialog.ImportSpec;
import org.eclipse.papyrus.uml.tools.importsources.PackageImportSourceDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Package;


public class ImportPackageFromUserModelHandler extends AbstractImportHandler {

	@Override
	protected ICommand getGMFCommand() {
		return new ImportFromFileCommand();
	}

	/**
	 * Specific {@link ChangeCommand} that imports libraries from repository
	 */
	public class ImportFromFileCommand extends AbstractImportCommand {

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
		public ImportFromFileCommand() {
			super(new Runnable() {

				public void run() {

					// Retrieve shell instance
					Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

					Map<String, String> extensionFilters = new LinkedHashMap<String, String>();
					extensionFilters.put("*.uml", "UML (*.uml)");
					extensionFilters.put("*.profile.uml", "UML Profiles (*.profile.uml)");
					extensionFilters.put("*", "All (*)");

					Collection<Package> packages = PackageImportSourceDialog.open(shell, "Select the models to import", getSelection(), extensionFilters);

					if(packages == null) {
						return; // user cancelled the dialog
					}

					if(!packages.isEmpty()) {
						PackageImportDialog dialog = new PackageImportDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), packages);

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
								default:
									handleLoadPackage(selectedPackage);
									break;
								}
							}
						}
					}
				}

			}, "Import Libraries", "Import Libraries from Workspace"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
}
