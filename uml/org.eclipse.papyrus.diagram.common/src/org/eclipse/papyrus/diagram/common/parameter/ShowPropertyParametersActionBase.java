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
package org.eclipse.papyrus.diagram.common.parameter;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.uml.Operation;

/*
 * TODO :
 * - old to new property parameters merge(probably in accordance with the name)
 * - make action totally undoable (now only label refresh can be undone)
 */

public abstract class ShowPropertyParametersActionBase extends DiagramAction {

	private IWorkbenchPage myWorkbechPage;

	public ShowPropertyParametersActionBase(IWorkbenchPage workbenchPage) {
		super(workbenchPage);
		setText("Manage Parameters...");
		myWorkbechPage = workbenchPage;
	}

	@Override
	protected void doRun(IProgressMonitor progressMonitor) {
		EditPropertyParametersDialog dialog = createDialog(getShell(), getOperationToEdit());
		dialog.create();
		dialog.open();
		execute(new RefreshEditPartCommand(getSelectedEditPart()), new NullProgressMonitor());
	}

	abstract protected EditPropertyParametersDialog createDialog(Shell shell, Operation operation);

	@Override
	protected Request createTargetRequest() {
		return null;
	}

	@Override
	protected Command getCommand() {
		// return nothing because all functionality is implemented in #doRun(IProgressMonitor) method
		return new Command("Fake Manage Property Parameters") {
		};
	}

	@Override
	protected boolean isSelectionListener() {
		return true;
	}

	private Shell getShell() {
		return myWorkbechPage.getActivePart().getSite().getShell();
	}

	private GraphicalEditPart getSelectedEditPart() {
		return (GraphicalEditPart) getStructuredSelection().getFirstElement();
	}

	private Operation getOperationToEdit() {
		GraphicalEditPart selected = getSelectedEditPart();
		return (Operation) selected.getNotationView().getElement();
	}

	private static class RefreshEditPartCommand extends Command {

		private GraphicalEditPart myEditPart;

		public RefreshEditPartCommand(GraphicalEditPart editPart) {
			super("Refresh Property Label");
			myEditPart = editPart;
		}

		@Override
		public void execute() {
			// refresh PropertyEditPArt
			myEditPart.refresh();
			// refresh parent Compartment
			myEditPart.getParent().refresh();
		}
	}

}
