/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.junit.utils;

import java.util.List;

import org.eclipse.jdt.ui.IPackagesViewPart;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.junit.Assert;

/**
 * 
 * Utils Methods for the Package Explorer
 * 
 */
public class PackageExplorerUtils {

	/** ID of the Package Explorer View */
	private static final String PACKAGE_EXPLORER_VIEW_ID = "org.eclipse.jdt.ui.PackageExplorer"; //$NON-NLS-1$

	/**
	 * This methods opens the PackageExplorerView, and give it the focus
	 * 
	 * @throws PartInitException
	 */
	public static final IPackagesViewPart openPackageExplorerView() throws PartInitException {
		final IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IPackagesViewPart pack = null;
		IViewPart packageExplorer = activeWorkbenchWindow.getActivePage().showView(PACKAGE_EXPLORER_VIEW_ID);
		pack = (IPackagesViewPart)packageExplorer;
		Assert.assertNotNull(pack);
		pack.setFocus();
		return pack;

	}

	/**
	 * Set the selection in the PackageExplorer
	 * 
	 * @param packageExplorer
	 *        the package explorer
	 * @param newSelection
	 *        the new selection
	 */
	public static final void setSelectionInPackageExplorerView(final IPackagesViewPart packageExplorer, final IStructuredSelection newSelection) {
		packageExplorer.getTreeViewer().expandAll();
		packageExplorer.getTreeViewer().setSelection(newSelection);
		//we verify that the current selection is correct in the PackageExplorer
		IStructuredSelection currentSelection = (IStructuredSelection)packageExplorer.getTreeViewer().getSelection();
		Assert.assertEquals("Package Explorer: The current selection is not the same as the wanted selection", currentSelection.toList(), newSelection.toList()); //$NON-NLS-1$

		//we verify that the current selection is correct using the selection service
		currentSelection = getCurrentSelectionInPackageExplorerView();
		Assert.assertEquals("Package Explorer: The SelectionService doesn't return the wanted selection", currentSelection.toList(), newSelection.toList()); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return
	 *         the current selection in the PackageExplorer
	 */
	public static final IStructuredSelection getCurrentSelectionInPackageExplorerView() {
		return (IStructuredSelection)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection(PACKAGE_EXPLORER_VIEW_ID);
	}

	/**
	 * 
	 * @return
	 *         the current selection in the PackageExplorer as List
	 */
	public static final List<?> getCurrentSelectionAsListInPackageExplorerView() {
		final IStructuredSelection selection = (IStructuredSelection)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection(PACKAGE_EXPLORER_VIEW_ID);
		final List<?> list = selection.toList();
		return list;
	}
}
