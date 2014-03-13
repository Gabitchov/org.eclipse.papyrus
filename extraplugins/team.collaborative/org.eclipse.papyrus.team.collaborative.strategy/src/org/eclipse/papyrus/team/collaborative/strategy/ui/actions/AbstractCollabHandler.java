/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.strategy.ui.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.infra.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.team.collaborative.core.utils.CollabUtils;
import org.eclipse.papyrus.team.collaborative.strategy.utils.UIUtils;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;


/**
 * Abstract class for Collaborative handler which are enable only if the project is collaborative.
 * 
 * @author adaussy
 */
public abstract class AbstractCollabHandler extends AbstractHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		EObject firstSelection = UIUtils.getFirstSelection();
		if(firstSelection != null) {
			return CollabUtils.isCollab(firstSelection);
		}
		return false;
	}

	protected ResourceSet getResourceSet() {
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if(editor instanceof CoreMultiDiagramEditor) {
			CoreMultiDiagramEditor papyrusEditor = (CoreMultiDiagramEditor)editor;
			return papyrusEditor.getEditingDomain().getResourceSet();
		} else {
			return null;
		}
	}


}
