/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.emf.facet.efacet.sdk.ui.internal;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

/**
 * Utils methods for using the workbench.
 * 
 * @since 0.3
 */
public final class WorkbenchUtils {

	private WorkbenchUtils() {
		// Private constructor.
	}

	public static void openNewFile(final IFile modelFile,
			final IWorkbench currentWorkbench,
			final IWorkbenchWindow workbenchWindow, final IWorkbenchPage page) {
		// Open an editor on the new file.
		try {
			page.openEditor(
					new FileEditorInput(modelFile),
					currentWorkbench
							.getEditorRegistry()
							.getDefaultEditor(
									modelFile.getFullPath().toString()).getId());
		} catch (final PartInitException exception) {
			MessageDialog.openError(workbenchWindow.getShell(),
					"Open Editor", exception.getMessage()); //$NON-NLS-1$
		}
	}

	public static IWorkbenchPage selectNewFile(final IFile modelFile,
			final IWorkbenchWindow workbenchWindow) {
		final IWorkbenchPage page = workbenchWindow.getActivePage();
		final IWorkbenchPart activePart = page.getActivePart();
		if (activePart instanceof ISetSelectionTarget) {
			final ISelection targetSelection = new StructuredSelection(
					modelFile);
			workbenchWindow.getShell().getDisplay().asyncExec(new Runnable() {
				public void run() {
					((ISetSelectionTarget) activePart)
							.selectReveal(targetSelection);
				}
			});
		}
		return page;
	}

}
