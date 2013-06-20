/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/


package org.eclipse.papyrus.qompass.modellibs.core;

import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.part.FileEditorInput;

abstract public class ModelCopyWizard extends Wizard implements INewWizard {

	private IStructuredSelection selection;

	protected String modelName;

	WizardNewFileCreationPage selectionPage;

	public static final String modelLocation = "/models/examples/";

	@Override
	public boolean performFinish() {
		// String fileName = diagramModelFilePage.getFileName();
		IFile model = copyModel(modelName);

		if(model == null) {
			return false;
		}

		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchPage page = wb.getActiveWorkbenchWindow().getActivePage();
		try {
			IEditorDescriptor desc = wb.getEditorRegistry().getDefaultEditor(modelName + ".di");
			IEditorInput input = new FileEditorInput(model);
			page.openEditor(input, desc.getId(), false);
		} catch (PartInitException e) {
			// log.error(e);
			return false;
		}
		return true;
	}

	/**
	 * Copy a model (.di/.notation/.uml) into the selected destination folder
	 * 
	 * @param sourceModelName
	 */
	public IFile copyModel(String sourceModelName) {
		try {
			IFile model = copyFile(sourceModelName + ".di");
			copyFile(sourceModelName + ".notation");
			copyFile(sourceModelName + ".uml");

			return model;
		} catch (CoreException e) {
			Shell shell = new Shell();
			String reason = e.getMessage();
			if(reason.endsWith("already exists.")) {
				reason += "\nChoose another parent folder or delete existing model first.";
			}
			MessageDialog.openError(shell, "Cannot create copy", reason);
			return null;
		}
	}

	/**
	 * copy a source file into the selected destination folder
	 * 
	 * @param sourceFileName
	 */
	public IFile copyFile(String sourceFileName) throws CoreException {
		IPath destPath = selectionPage.getContainerFullPath();
		InputStream is = getClass().getResourceAsStream(modelLocation + sourceFileName);
		if(is != null) {
			destPath = destPath.append(sourceFileName);
			IFile destFile = ResourcesPlugin.getWorkspace().getRoot().getFile(destPath);
			destFile.create(is, false, null);
			return destFile;
		}
		else {
			throw new CoreException(new Status(0, Activator.PLUGIN_ID, "Cannot open file <" + modelLocation + sourceFileName + ">"));
		}
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// this.workbench = workbench;
		this.selection = selection;
		setWindowTitle("Create Qompass example");
		setNeedsProgressMonitor(true);
	}


	/**
	 * @generated
	 */
	@Override
	public void addPages() {
		selectionPage = new WizardNewFileCreationPage("Copy model", selection);
		selectionPage.setTitle("Select parent folder for example " + modelName);
		selectionPage.setDescription("Do not change file name (will be ignored)");
		selectionPage.setFileName(modelName);
		addPage(selectionPage);
	}
}
