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

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.widgets.editors.MultipleValueSelectorDialog;
import org.eclipse.papyrus.infra.widgets.providers.WorkspaceContentProvider;
import org.eclipse.papyrus.infra.widgets.selectors.ReferenceSelector;
import org.eclipse.papyrus.uml.extensionpoints.utils.Util;
import org.eclipse.papyrus.uml.importt.ui.PackageImportDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.uml2.common.edit.command.ChangeCommand;
import org.eclipse.uml2.uml.Package;


public class ImportPackageFromWorkspaceHandler extends AbstractImportHandler {

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected Command getCommand() {
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

					// Start selection dialog
					ReferenceSelector selector = new ReferenceSelector();
					ILabelProvider labelProvider = WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider();
					selector.setLabelProvider(labelProvider);
					selector.setContentProvider(new WorkspaceContentProvider());

					MultipleValueSelectorDialog chooseLib = new MultipleValueSelectorDialog(shell, selector);

					chooseLib.setLabelProvider(WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider());
					chooseLib.setUnique(true);
					chooseLib.setTitle("Select the models to import");

					//ResourceSelectionDialog chooseLib = new ResourceSelectionDialog(shell, ResourcesPlugin.getWorkspace().getRoot(), Messages.ImportPackageFromFileHandler_SelectRegisteredModelLibrary);

					chooseLib.open();

					// User selection
					Object[] selection = chooseLib.getResult();

					if(selection == null) { // Cancel was selected
						return;
					}

					ResourceSet resourceSet = Util.getResourceSet(getSelectedElement());
					// Parse selection and add ModelLibrary files
					for(Object selectedElement : selection) {

						//Handle errors:
						//- The selected is not an IFile
						//- The selected file is not a valid EMF Model (Error occurs during the resource loading)
						//- The selected model is empty
						//- The selected model is not a Package

						if(!(selectedElement instanceof IFile)) {
							MessageDialog.openWarning(shell, "Selection is not a File", "The selected element is not a File: " + labelProvider.getText(selectedElement));
							continue;
						}

						IFile currentFile = (IFile)selectedElement;

						URI modelUri = URI.createURI("platform:/resource" + currentFile.getFullPath()); //$NON-NLS-1$


						Resource modelResource;
						try {
							modelResource = resourceSet.getResource(modelUri, true);
						} catch (Exception ex) {
							MessageDialog.openWarning(shell, "Invalid model", "The selected file is not a valid model: " + labelProvider.getText(selectedElement));
							//At this point, an empty resource may have been loaded in the resource set. We should clean it.
							//Remove the resource from the resource set
							modelResource = resourceSet.getResource(modelUri, false);
							if(modelResource != null) {
								resourceSet.getResources().remove(modelResource);
							}
							continue;
						}
						if(modelResource.getContents().isEmpty()) {
							MessageDialog.openWarning(shell, "Model is empty", "The selected model is empty: " + labelProvider.getText(selectedElement));
							continue;
						}
						if(!(modelResource.getContents().get(0) instanceof Package)) {
							MessageDialog.openWarning(shell, "Model is not a Package", "The selected model is not a valid UML Package: " + labelProvider.getText(selectedElement));
							continue;
						}

						PackageImportDialog dialog = new PackageImportDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), ((Package)modelResource.getContents().get(0)));

						if(dialog.open() == Window.OK) {
							List<?> result = dialog.getResult();

							for(Object resultElement : result) {
								Package selectedPackage = (Package)resultElement;
								if(dialog.isCopy()) {
									handleCopyPackage(selectedPackage);
								} else {
									handleImportPackage(selectedPackage);
								}
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

			}, "Import Libraries", "Import Libraries from Workspace"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
}
