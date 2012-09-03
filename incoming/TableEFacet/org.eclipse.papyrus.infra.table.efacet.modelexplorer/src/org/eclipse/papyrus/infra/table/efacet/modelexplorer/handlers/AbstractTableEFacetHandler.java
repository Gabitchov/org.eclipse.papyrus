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
package org.eclipse.papyrus.infra.table.efacet.modelexplorer.handlers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.views.modelexplorer.handler.AbstractCommandHandler;
import org.eclipse.ui.PlatformUI;


public abstract class AbstractTableEFacetHandler extends AbstractCommandHandler {

	/**
	 * Returns the list of selected tables
	 * 
	 * @return
	 *         the list of selected tables
	 */
	protected List<PapyrusTable> getSelectedTables() {
		final List<PapyrusTable> tables = new ArrayList<PapyrusTable>();
		final ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();

		// Get first element if the selection is an IStructuredSelection
		if(selection instanceof IStructuredSelection) {
			final IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			final Iterator<?> iter = structuredSelection.iterator();
			while(iter.hasNext()) {
				final Object current = iter.next();
				if(current instanceof IAdaptable) {
					final EObject table = (EObject)((IAdaptable)current).getAdapter(EObject.class);
					if(table instanceof PapyrusTable) {
						tables.add((PapyrusTable)table);
					}
				}
			}
		}
		return tables;
	}

}
