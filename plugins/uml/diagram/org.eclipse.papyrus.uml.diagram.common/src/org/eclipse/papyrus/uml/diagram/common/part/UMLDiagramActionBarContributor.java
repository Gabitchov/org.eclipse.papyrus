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
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.part;

import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramActionBarContributor;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPage;

/**
 * @generated
 */
public class UMLDiagramActionBarContributor extends DiagramActionBarContributor {

	/**
	 * @generated
	 */
	protected Class getEditorClass() {
		return DiagramDocumentEditor.class;
	}

	/**
	 * @generated
	 */
	protected String getEditorId() {
		return "org.eclipse.papyrus.UMLDiagramEditorID";
	}

	/**
	 * @generated
	 */
	public void init(IActionBars bars, IWorkbenchPage page) {
		super.init(bars, page);
		IMenuManager fileMenu = bars.getMenuManager();

		IContributionItem undoAction = bars.getMenuManager().findMenuUsingPath("undoGroup");
		if(undoAction != null) {
			fileMenu.remove(undoAction);
		}
		// print preview
		// IMenuManager fileMenu =
		// bars.getMenuManager().findMenuUsingPath(IWorkbenchActionConstants.M_FILE);
		// assert fileMenu != null;
		//fileMenu.remove("pageSetupAction"); //$NON-NLS-1$

	}
}
