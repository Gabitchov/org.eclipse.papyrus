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
package org.eclipse.papyrus.infra.table.modelexplorer.handlers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.views.modelexplorer.handler.AbstractCommandHandler;
import org.eclipse.ui.PlatformUI;


public abstract class AbstractTableModelExplorerHandler extends AbstractCommandHandler {

	/**
	 * Returns the list of selected tables
	 * 
	 * @return
	 *         the list of selected tables
	 */
	protected List<PapyrusTableInstance> getSelectedTables() {
		List<PapyrusTableInstance> tables = new ArrayList<PapyrusTableInstance>();
		ISelection selection = null;

		// Get current selection
		selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();

		// Get first element if the selection is an IStructuredSelection
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			Iterator<?> iter = structuredSelection.iterator();
			while(iter.hasNext()) {
				Object current = iter.next();
				if(current instanceof IAdaptable){
					EObject table = (EObject)((IAdaptable)current).getAdapter(EObject.class);
					if(table instanceof PapyrusTableInstance){
						tables.add((PapyrusTableInstance)table);
					}
				}
			}
		}
		return tables;
	}

}
