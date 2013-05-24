/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.modelexplorer.handlers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.views.modelexplorer.NavigatorUtils;
import org.eclipse.papyrus.views.modelexplorer.handler.AbstractCommandHandler;
import org.eclipse.ui.PlatformUI;

public abstract class AbstractTableCommandHandler extends AbstractCommandHandler {

	/**
	 * Returns the list of selected tables
	 * 
	 * @return the list of selected tables
	 */
	protected List<Table> getSelectedTables() {
		List<Table> tables = new ArrayList<Table>();
		ISelection selection = null;

		// Get current selection
		selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();

		// Get first element if the selection is an IStructuredSelection
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			Iterator<?> iter = structuredSelection.iterator();
			while(iter.hasNext()) {
				Object current = iter.next();
				/**
				 * Get the table object. This getElement is used in order to
				 * use IAdaptable mechanisme For example for Facet Elements
				 */
				EObject table = NavigatorUtils.getElement(current, EObject.class);
				if(table instanceof Table) {
					tables.add((Table)table);
				}
			}
		}

		return tables;
	}
}
