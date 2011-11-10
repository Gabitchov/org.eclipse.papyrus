/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.importt.handlers;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.uml.extensionpoints.utils.Util;
import org.eclipse.papyrus.uml.importt.messages.Messages;
import org.eclipse.papyrus.uml.profile.ui.dialogs.PackageImportTreeSelectionDialog;
import org.eclipse.papyrus.views.modelexplorer.handler.AbstractCommandHandler;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;
import org.eclipse.uml2.common.edit.command.ChangeCommand;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.UMLFactory;


public class ImportPackageFromWorkspaceHandler extends AbstractCommandHandler {

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected Command getCommand() {
		return new ImportFromFileCommand(getEditingDomain());
	}

	/**
	 * Specific {@link ChangeCommand} that imports libraries from repository
	 */
	public class ImportFromFileCommand extends ChangeCommand {

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
		public ImportFromFileCommand(EditingDomain editingDomain) {
			super(editingDomain, new Runnable() {

				public void run() {

					// Retrieve shell instance
					Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

					// Start selection dialog
					ResourceSelectionDialog chooseLib = new ResourceSelectionDialog(shell, ResourcesPlugin.getWorkspace().getRoot(), Messages.ImportPackageFromFileHandler_SelectRegisteredModelLibrary);

					chooseLib.open();

					// User selection
					Object[] selection = chooseLib.getResult();

					if(selection == null) { // Cancel was selected
						return;
					}

					ResourceSet resourceSet = Util.getResourceSet(getSelectedElement());
					// Parse selection and add ModelLibrary files
					for(int i = 0; i < selection.length; i++) {

						if(selection[i] instanceof IFile) {

							IFile currentFile = (IFile)selection[i];

							URI modelUri = URI.createURI("platform:/resource" + currentFile.getFullPath()); //$NON-NLS-1$
							Resource modelResource = resourceSet.getResource(modelUri, true);

							PackageImportTreeSelectionDialog eisd = new PackageImportTreeSelectionDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), ((Package)modelResource.getContents().get(0)));
							int ret = eisd.open();

							if(ret == Window.OK) {
								ArrayList<?> result = eisd.getResult();
								Iterator<?> resultIter = result.iterator();
								while(resultIter.hasNext()) {
									Element element = (Element)resultIter.next();
									PackageImport ei = UMLFactory.eINSTANCE.createPackageImport();
									ei.setImportedPackage((Package)element);
									((Package)getSelectedElement()).getPackageImports().add(ei);
								}
							}

							/*
							 * Element root = (Element) modelResource.getContents().get(0);
							 * 
							 * // Import model library Package libToImport = (Package) root; // create import package PackageImport pi =
							 * UMLFactory.eINSTANCE.createPackageImport();
							 * pi.setImportedPackage(libToImport); ((Package) selectedElement).getPackageImports().add(pi);
							 */
						}
					}
				}
			}, "Import Libraries", "Import Libraries from Workspace"); //$NON-NLS-1$ //$NON-NLS-2$
		}

		/**
		 * 
		 * @see org.eclipse.emf.common.command.AbstractCommand#canExecute()
		 * 
		 * @return
		 */
		@Override
		public boolean canExecute() {
			if(getSelectedElements().size() == 1) {
				return (getSelectedElement() instanceof Package);
			}
			return false;
		}
	}
}
