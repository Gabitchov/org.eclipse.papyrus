/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.part;

import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramActionBarContributor;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class UMLDiagramActionBarContributor extends DiagramActionBarContributor {

	/**
	 * @generated
	 */
	@Override
	protected Class getEditorClass() {
		return UMLDiagramEditor.class;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getEditorId() {
		return UMLDiagramEditor.ID;
	}

	/**
	 * @generated
	 */
	@Override
	public void init(final IActionBars bars, final IWorkbenchPage page) {
		super.init(bars, page);
		// print preview
		final IMenuManager fileMenu = bars.getMenuManager().findMenuUsingPath(IWorkbenchActionConstants.M_FILE);
		assert fileMenu != null;
		fileMenu.remove("pageSetupAction"); //$NON-NLS-1$
		final IMenuManager editMenu = bars.getMenuManager().findMenuUsingPath(IWorkbenchActionConstants.M_EDIT);
		assert editMenu != null;
		if(editMenu.find("validationGroup") == null) { //$NON-NLS-1$
			editMenu.add(new GroupMarker("validationGroup")); //$NON-NLS-1$
		}
		final IAction validateAction = new ValidateAction(page);
		editMenu.appendToGroup("validationGroup", validateAction); //$NON-NLS-1$
	}
}
