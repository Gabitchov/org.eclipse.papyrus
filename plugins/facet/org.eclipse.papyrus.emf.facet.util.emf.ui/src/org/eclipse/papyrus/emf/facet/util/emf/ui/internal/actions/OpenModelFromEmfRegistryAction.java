/*******************************************************************************
 * Copyright (c) 2008, 2010, 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Gabriel Barbier (Mia-Software) - initial API and implementation
 *    Nicolas Bros (Mia-Software)
 *    Nicolas Guyomar (Mia-Software) - Bug 333652 Extension point offering the possibility to declare an EPackage browser
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.util.emf.ui.internal.actions;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.emf.facet.util.emf.core.IBrowserRegistry;
import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.dialogs.UriSelectionDialog;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

/**
 * This is an action class which opens a dialog to select an EPackage to browse
 */
public class OpenModelFromEmfRegistryAction implements IWorkbenchWindowActionDelegate {

	private IWorkbenchWindow fWorkbenchWindow;

	public void dispose() {
		// nothing
	}

	public void init(final IWorkbenchWindow window) {
		this.fWorkbenchWindow = window;
	}

	public void run(final IAction action) {
		final IWorkbenchPage activePage = this.fWorkbenchWindow.getActivePage();
		if (activePage != null) {
			final UriSelectionDialog launcher = new UriSelectionDialog(
					this.fWorkbenchWindow.getShell());
			if (launcher.open() == Window.OK) {
				final String nsURI = launcher.getUriSelected();
				if (nsURI != null && nsURI.length() > 0) {
					EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(nsURI);
					IBrowserRegistry.INSTANCE.browseEPackage(ePackage);
				}
			}
		}
	}

	public void selectionChanged(final IAction action, final ISelection selection) {
		// nothing
	}
}
