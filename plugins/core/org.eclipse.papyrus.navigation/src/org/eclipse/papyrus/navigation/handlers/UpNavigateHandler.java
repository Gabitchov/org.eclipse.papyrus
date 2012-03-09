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

import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.core.adaptor.gmf.DiagramsUtil;
import org.eclipse.papyrus.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.core.utils.OpenDiagramCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.navigation.Activator;
import org.eclipse.papyrus.navigation.utils.MultiDiagramDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.window.Window;

/**
 * handler for Up command
 * 
 */
public class UpNavigateHandler extends AbstractHandler {

	private IEditorPart editor;

	public Object execute(ExecutionEvent event) throws ExecutionException {
		editor = HandlerUtil.getActiveEditor(event);
		if(editor instanceof CoreMultiDiagramEditor) {
			CoreMultiDiagramEditor papyrusEditor = (CoreMultiDiagramEditor)editor;
			EObject parent = papyrusEditor.getDiagram().getElement().eContainer();
			List<Diagram> diagrams = Collections.emptyList();
			if(parent != null) {
				while(parent != null && diagrams.size() == 0) {
					diagrams = DiagramsUtil.getAssociatedDiagrams(parent);
					parent = parent.eContainer();
				}
				openDialog(papyrusEditor, diagrams);

			}
		}
		return null;
	}

	/**
	 * open the diagram if there is just one or open a dialog to choose the
	 * diagram to open if there is more than one
	 * 
	 * @param papyrusEditor
	 * @param diagrams
	 */
	private void openDialog(CoreMultiDiagramEditor papyrusEditor, List<Diagram> diagrams) {
		if(diagrams != null) {
			if(diagrams.size() == 1) {
				openDiagram(papyrusEditor, diagrams.get(0));
			} else if(diagrams.size() > 1) {
				MultiDiagramDialog multiDiagramDialog = new MultiDiagramDialog(Activator.getActiveWorkbenchShell(), diagrams);
				if(multiDiagramDialog.open() == Window.OK) {
					openDiagram(papyrusEditor, diagrams.get(multiDiagramDialog.getSelectedDiagram()));
				}
			}
		}
	}

	/**
	 * open a dialog to choose which diagram have to be opened
	 * 
	 * @param papyrusEditor
	 * @param diagram
	 */
	private void openDiagram(CoreMultiDiagramEditor papyrusEditor, Diagram diagram) {
		if(papyrusEditor.getEditingDomain() instanceof TransactionalEditingDomain) {
			TransactionalEditingDomain domain = (TransactionalEditingDomain)papyrusEditor.getEditingDomain();
			OpenDiagramCommand openDiagramCommand = new OpenDiagramCommand(domain, diagram);
			domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(openDiagramCommand));
		}
	}

}
