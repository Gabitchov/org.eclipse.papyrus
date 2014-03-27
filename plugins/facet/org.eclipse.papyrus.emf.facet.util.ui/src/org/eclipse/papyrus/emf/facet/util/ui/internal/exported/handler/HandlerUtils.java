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
 *  	Grégoire Dupé (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *      Grégoire Dupé (Mia-Software) - Bug 423181 - Unchecked cast in HandlerUtils.getStructuredSelection()
 */
package org.eclipse.papyrus.emf.facet.util.ui.internal.exported.handler;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * Util class for Handlers.
 * 
 * @since 0.3
 */
public final class HandlerUtils {

	private HandlerUtils() {
		// Hidden constructor.
	}

	/**
	 * Return the tree selection of the user's selection.
	 * 
	 * @return the current tree selection.
	 */
	public static IStructuredSelection getStructuredSelection() {
		ISelection selection = null;
		final IWorkbench workbench = PlatformUI.getWorkbench();
		if (workbench != null) {
			final IWorkbenchWindow[] workbenchWindows = workbench
					.getWorkbenchWindows();
			if ((workbenchWindows.length > 0)
					&& (workbenchWindows[0].getSelectionService() != null)) {
				selection = workbenchWindows[0].getSelectionService()
						.getSelection();
			}
		}
		IStructuredSelection result = null;
		if (selection instanceof IStructuredSelection) {
			result = (IStructuredSelection) selection;
		}
		return result;
	}

	/**
	 * Return the current selection.
	 * 
	 * @return the current selection.
	 */
	public static Object getSelection() {
		Object result = null;
		// on a facet model, the selection is obviously a TreeSelection
		final IStructuredSelection structSelection = getStructuredSelection();
		if (structSelection != null) {
			result = structSelection.getFirstElement();
		}
		return result;
	}

	/**
	 * Return the active workbench window.
	 * 
	 * @return the active workbench window.
	 */
	public static Shell getWorkbenchWindowShell() {
		final IWorkbenchWindow iWorkbenchWindow = PlatformUI.getWorkbench()
				.getWorkbenchWindows()[0];
		final IWorkbenchPage iWorkbenchPage = iWorkbenchWindow.getPages()[0];
		final IWorkbenchPart activePart = iWorkbenchPage.getActivePart();
		final IWorkbenchPartSite site = activePart.getSite();

		return site.getShell();
	}
}
