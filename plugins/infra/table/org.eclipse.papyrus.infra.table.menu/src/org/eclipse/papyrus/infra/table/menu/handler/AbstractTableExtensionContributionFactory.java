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
package org.eclipse.papyrus.infra.table.menu.handler;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.facet.widgets.nattable.INatTableWidgetProvider;
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
	public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {
		this.serviceLocator = serviceLocator;
	}

	/**
	 * 
	 * @return
	 *         the {@link INatTableWidgetProvider} or <code>null</code> if not found
	 */
	protected INatTableWidgetProvider getINatTableWidgetProvider() {
		INatTableWidgetProvider provider = null;;
		if(PlatformUI.getWorkbench() != null && PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null && PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage() != null) {
			IWorkbenchPart activePart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
			if(activePart != null) {
				if(activePart instanceof CoreMultiDiagramEditor) {
					IEditorPart activeEditor = ((CoreMultiDiagramEditor)activePart).getActiveEditor();
					if(activeEditor instanceof IAdaptable) {
						provider = (INatTableWidgetProvider)activeEditor.getAdapter(INatTableWidgetProvider.class);
					}
				}
			}
		}
		return provider;
	}
}
