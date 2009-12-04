/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin) tristan.faure@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.resource.migration.popup.actions;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.resource.migration.controller.GenModelUpdater;
import org.eclipse.papyrus.resource.migration.controller.exceptions.URINotValidException;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class UpdateGenModelAction implements IObjectActionDelegate {

	private Shell shell;

	/**
	 * Constructor for Action1.
	 */
	public UpdateGenModelAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		if (PlatformUI.getWorkbench() != null) {
			IWorkbench workbench = PlatformUI.getWorkbench();
			if (workbench.getActiveWorkbenchWindow() != null) {
				IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
				if (window.getSelectionService() != null) {
					ISelectionService service = window.getSelectionService();
					ISelection selection = service.getSelection();
					if (selection instanceof IStructuredSelection) {
						final IStructuredSelection structuredSelection = (IStructuredSelection) selection;
						BusyIndicator.showWhile(shell.getDisplay(), new Runnable() {

							public void run() {
								runProcess(structuredSelection);
							}
						});
					}
				}
			}
		}
	}

	/**
	 * perform the process
	 * 
	 * @param structuredSelection
	 */
	private void runProcess(final IStructuredSelection structuredSelection) {
		try {
			Iterator<?> iterator = structuredSelection.iterator();
			GenModelUpdater updater = new GenModelUpdater();
			while (iterator.hasNext()) {
				Object next = iterator.next();
				if (next instanceof IFile) {
					IFile ifile = (IFile) next;
					updater.transform(URI.createURI(ifile.getLocationURI().toString()));
					ifile.getParent().refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor());
				}
			}
			MessageDialog.openInformation(shell, "Finish", "The genmodel has been updated");
		} catch (URINotValidException e) {
			MessageDialog.openError(shell, "Error", e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			MessageDialog.openError(shell, "Error", "An error occurs during save process");
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

}
