/*******************************************************************************
 * Copyright (c) 2011 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Anass RADOUANI (AtoS)
 *******************************************************************************/

package org.eclipse.papyrus.navigation.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * handler for Up command
 * 
 */
public class BackNavigateHandler extends AbstractHandler {

	private IEditorPart editor;

	private IPageMngr pageMngr;

	public Object execute(ExecutionEvent event) throws ExecutionException {
		editor = HandlerUtil.getActiveEditor(event);

		if(editor instanceof CoreMultiDiagramEditor) {
			CoreMultiDiagramEditor papyrusEditor = (CoreMultiDiagramEditor)editor;
			EditingDomain editingDomain = papyrusEditor.getEditingDomain();
			if(editingDomain instanceof TransactionalEditingDomain) {
				try {
					pageMngr = papyrusEditor.getServicesRegistry().getService(IPageMngr.class);
					pageMngr.openPrevious();
				} catch (ServiceException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

}
