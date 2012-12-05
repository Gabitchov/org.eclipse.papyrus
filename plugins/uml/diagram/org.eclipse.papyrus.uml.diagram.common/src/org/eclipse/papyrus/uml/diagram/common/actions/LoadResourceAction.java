/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Francisco Javier Cano Muñoz (Prodevelop) - prepared the hadler for IDiagramWorkbenchParts 
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Load resource action hnalder. Works with any {@link IDiagramWorkbenchPart}.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * 
 */
public class LoadResourceAction extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart diagramEditor = HandlerUtil.getActiveEditorChecked(event);
		Shell shell = diagramEditor.getEditorSite().getShell();

		IDiagramWorkbenchPart workbenchPart;
		if(diagramEditor instanceof IDiagramWorkbenchPart) {
			workbenchPart = (IDiagramWorkbenchPart)diagramEditor;
		} else {
			workbenchPart = (IDiagramWorkbenchPart)diagramEditor.getAdapter(IDiagramWorkbenchPart.class);
		}
		assert diagramEditor != null;
		TransactionalEditingDomain editingDomain = workbenchPart.getDiagramEditPart().getEditingDomain();
		org.eclipse.emf.edit.ui.action.LoadResourceAction.LoadResourceDialog loadResourceDialog = new org.eclipse.emf.edit.ui.action.LoadResourceAction.LoadResourceDialog(shell, editingDomain);
		loadResourceDialog.open();
		return null;
	}

}
