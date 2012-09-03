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
package org.eclipse.papyrus.infra.table.efacet.common.menu;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.facet.widgets.nattable.INatTableWidgetProvider;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidgetProvider;
import org.eclipse.papyrus.infra.core.editor.CoreMultiDiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.menus.ExtensionContributionFactory;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.services.IServiceLocator;


public abstract class AbstractTableExtensionContributionFactory extends ExtensionContributionFactory {

	/**
	 * The service locator
	 */
	protected IServiceLocator serviceLocator;

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void createContributionItems(final IServiceLocator serviceLocator, final IContributionRoot additions) {
		this.serviceLocator = serviceLocator;
	}

	/**
	 * 
	 * @return
	 *         the {@link INatTableWidgetProvider} or <code>null</code> if not found
	 */
	protected ITableWidgetProvider getINatTableWidgetProvider() {
		ITableWidgetProvider provider = null;;
		if((PlatformUI.getWorkbench() != null) && (PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null) && (PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage() != null)) {
			final IWorkbenchPart activePart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
			if(activePart != null) {
				if(activePart instanceof CoreMultiDiagramEditor) {
					final IEditorPart activeEditor = ((CoreMultiDiagramEditor)activePart).getActiveEditor();
					if(activeEditor instanceof IAdaptable) {
						provider = (ITableWidgetProvider)activeEditor.getAdapter(ITableWidgetProvider.class);
					}
				}
			}
		}
		return provider;
	}
}
