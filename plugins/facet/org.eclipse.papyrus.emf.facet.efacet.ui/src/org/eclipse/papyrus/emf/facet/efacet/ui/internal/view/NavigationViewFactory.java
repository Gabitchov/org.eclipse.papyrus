/*******************************************************************************
 * Copyright (c) 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software)
 *     Gregoire Dupe (Mia-Software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.efacet.ui.internal.view;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.Activator;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.exported.view.INavigationView;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.exported.view.INavigationViewFactory;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class NavigationViewFactory implements INavigationViewFactory {

	public static final String VIEW_ID = "org.eclipse.papyrus.emf.facet.efacet.ui.view.navigation"; //$NON-NLS-1$

	public INavigationView openNavigationView(final EditingDomain editingDomain) {
		INavigationView result = null;
		try {
			final IWorkbenchWindow window = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow();
			if (window != null) {
				final IWorkbenchPage activePage = window.getActivePage();
				if (activePage != null) {
					result = (INavigationView) activePage
							.showView(NavigationViewFactory.VIEW_ID);
				}
			}
		} catch (final PartInitException e) {
			Logger.logError(e, Activator.getDefault());
		}
		return result;
	}

}
