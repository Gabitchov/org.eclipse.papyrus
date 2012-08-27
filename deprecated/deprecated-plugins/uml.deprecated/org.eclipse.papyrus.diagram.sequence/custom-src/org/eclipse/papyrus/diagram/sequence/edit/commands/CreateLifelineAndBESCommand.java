/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano Muñoz - Expanded functionality
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;

public class CreateLifelineAndBESCommand extends AbstractTransactionalCommand {

	private ViewDescriptor viewDescriptor = null;

	private EditPartViewer viewer = null;

	public CreateLifelineAndBESCommand(TransactionalEditingDomain domain,
			ViewDescriptor descriptor, EditPartViewer viewer) {
		super(domain, "Create Lifeline and BES", null);
		viewDescriptor = descriptor;
		this.viewer = viewer;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {

		View view = (View) viewDescriptor.getAdapter(View.class);
		if (view == null) {
			return CommandResult
					.newErrorCommandResult("Lifeline view not created");
		}

		Command command = getBESCreateCommand(view);
		if (command != null) {
			command.execute();
		}

		return CommandResult.newOKCommandResult();
	}

	@Override
	public boolean canExecute() {
		return viewDescriptor != null && viewer != null;
	}

	private Command getBESCreateCommand(View view) {
		IGraphicalEditPart newLifelineEditPart = (IGraphicalEditPart) viewer
				.getEditPartRegistry().get(view);
		newLifelineEditPart.getFigure().getUpdateManager().performUpdate();

		CreateElementRequest elementRequest = new CreateElementRequest(
				UMLElementTypes.BehaviorExecutionSpecification_2003);
		CreateElementRequestAdapter requestAdatper = new CreateElementRequestAdapter(
				elementRequest);
		ViewAndElementDescriptor descriptor = new ViewAndElementDescriptor(
				requestAdatper, Node.class, "2003",
				UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);

		CreateViewAndElementRequest request = new CreateViewAndElementRequest(
				descriptor);

		Command command = newLifelineEditPart.getCommand(request);
		return command;
	}
}
