/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.part.EditingDomainRegistry;
import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

// TODO: Auto-generated Javadoc
/**
 * Deletes a <Diagram> from a GMF resource. First all editors showing the <Diagram> are closed, then the <Diagram> is removed from the GMF resource.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class DeleteDiagramCommand extends AbstractCommand {

	/** Diagram to delete. */
	private Diagram diagram = null;

	/**
	 * Instantiates a new delete diagram command.
	 * 
	 * @param diagram
	 *            the diagram
	 */
	public DeleteDiagramCommand(Diagram diagram) {
		this.diagram = diagram;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.AbstractCommand#canExecute()
	 */
	@Override
	public boolean canExecute() {
		return diagram != null;
	}

	/**
	 * Will close all open editors that are showing this diagram, then delete the diagram from the GMF resource containing it.
	 */
	public void execute() {
		if (diagram == null) {
			return;
		}
		// Get upper diagram to open in case the one deleted is active.
		Diagram diagramToOpen = MultiDiagramUtil.getUpperDiagram(diagram);
		if (diagramToOpen == null || diagramToOpen.equals(diagram)) {
			// This is the uppest diagram we'll look for a diagram at the same
			// level
			diagramToOpen = MultiDiagramUtil.getOtherDiagram(diagram);
			if (diagramToOpen == null) {
				// no suitable diagram to open
				return;
			}
		}

		// The diagram is Ok to be deleted. Ask user confirmation.
		MessageDialog confirmDialog = new MessageDialog(Display.getCurrent().getActiveShell(), "Delete diagram?", null, "Are oyu sure you want to delete the selected diagram?", MessageDialog.WARNING,
				new String[] { "Yes", "No" }, 1);
		int result = confirmDialog.open();
		if (result == Window.CANCEL) {
			return;
		}

		if (!isDiagramActive()) {
			// If the diagram to delete is not active it can be deleted without
			// problems.
			MultiDiagramUtil.deleteDiagramAndSave(diagram);
		} else {
			// If the diagram to delete is active, a complex process must be
			// folowed to delete it.
			// Close all diagram editors that have the diagram to be deleted
			// active.
			EditingDomainRegistry.getInstance().setChangingCachedEditors(true);
			MultiDiagramUtil.closeEditorsThatShowDiagram(diagram);
			// Delete diagram
			MultiDiagramUtil.deleteDiagramAndSave(diagram);
			// Open its upper diagram
			try {
				MultiDiagramUtil.openDiagram(diagramToOpen);
			} catch (ExecutionException ex) {
				IStatus status = new Status(IStatus.ERROR, Activator.ID, "Can't open diagram");
				Activator.getDefault().getLog().log(status);
			} finally {
				EditingDomainRegistry.getInstance().setChangingCachedEditors(false);
			}
		}
	}

	/**
	 * Returns true if the active editor diagram is the one to delete.
	 * 
	 * @return true, if checks if is diagram active
	 */
	protected boolean isDiagramActive() {
		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (activeEditor instanceof DiagramEditor) {
			DiagramEditor diagramEditor = (DiagramEditor) activeEditor;
			Diagram activeDiagram = diagramEditor.getDiagram();
			if (diagram.equals(activeDiagram)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.Command#redo()
	 */
	public void redo() {
		// do nothing
		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.AbstractCommand#canUndo()
	 */
	@Override
	public boolean canUndo() {
		return false;
	}

}
