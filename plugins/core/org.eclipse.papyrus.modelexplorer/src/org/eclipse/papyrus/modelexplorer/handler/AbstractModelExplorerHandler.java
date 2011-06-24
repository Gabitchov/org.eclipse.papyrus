/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer.handler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.eclipse.ui.PlatformUI;

/**
 * This provides facilities to get the TransactionEditingDomain and the PageManager from the Model Explorer
 * 
 * 
 * 
 */
public abstract class AbstractModelExplorerHandler extends AbstractHandler {

	/**
	 * Returns the
	 * 
	 * @return
	 *         the current editing domain
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		TransactionalEditingDomain editingDomain = null;
		try {
			editingDomain = org.eclipse.papyrus.core.utils.ServiceUtilsForActionHandlers.getInstance().getTransactionalEditingDomain();
		} catch (ServiceException e) {
			//we are closing the editor, so the model explorer has nothing to display
			//			e.printStackTrace();
		}
		return editingDomain;
	}

	/**
	 * Returns the page manager
	 * 
	 * @return
	 *         the page manager
	 */
	protected IPageMngr getPageManager() {
		IPageMngr pageMngr = null;
		try {
			pageMngr = org.eclipse.papyrus.core.utils.ServiceUtilsForActionHandlers.getInstance().getIPageMngr();
		} catch (ServiceException e) {
			//we are closing the editor, so the model explorer has nothing to display
			//			e.printStackTrace();
		}
		return pageMngr;
	}

	/**
	 * Returns the list of selected diagrams
	 * 
	 * @return
	 *         the list of selected diagrams
	 */
	protected List<Diagram> getSelectedDiagrams() {
		List<Diagram> diagrams = new ArrayList<Diagram>();
		ISelection selection = null;

		// Get current selection
		selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();

		// Get first element if the selection is an IStructuredSelection
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			Iterator<?> iter = structuredSelection.iterator();
			while(iter.hasNext()) {
				Object current = iter.next();
				if(current instanceof Diagram) {
					diagrams.add((Diagram)current);
				}
			}
		}

		return diagrams;
	}
}
