/***************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano Muñoz - Initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Message;

import org.eclipse.papyrus.diagram.sequence.util.DiagramInitializationUtil;
import org.eclipse.papyrus.diagram.sequence.util.InteractionViewInitializationUtil;
import org.eclipse.papyrus.diagram.sequence.util.InteractionViewInitializationUtil.NodeInitDataFigure;

/**
 * Creates the views of an <Interaction>, its <Lifeline>s,
 * <BehaviorExecutionSpecification>s and <Message>s.
 * 
 * @author fjcano
 * 
 */
public class InitializeInteractionViewCommand extends
		AbstractTransactionalCommand {

	IGraphicalEditPart parentEditPart = null;

	Interaction interaction = null;

	Point offset = null;

	public InitializeInteractionViewCommand(TransactionalEditingDomain domain,
			String label, List affectedFiles) {
		super(domain, label, affectedFiles);
	}

	public IGraphicalEditPart getParentEditPart() {
		return parentEditPart;
	}

	public Interaction getInteraction() {
		return interaction;
	}

	public Point getOffset() {
		return offset != null ? offset : new Point(0, 0);
	}

	public void setParentEditPart(IGraphicalEditPart parentEditPart) {
		this.parentEditPart = parentEditPart;
	}

	public void setInteraction(Interaction interaction) {
		this.interaction = interaction;
	}

	public void setOffset(Point offset) {
		this.offset = offset.getCopy();
	}

	@Override
	public boolean canExecute() {
		boolean canExecute = getInteraction() != null
				&& getParentEditPart() != null && getEditingDomain() != null;
		return canExecute;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		if (getInteraction() != null || getParentEditPart() != null
				&& getEditingDomain() != null) {
			List<List<Message>> orderedMessages = DiagramInitializationUtil
					.getGlobalMsgOrdering(getInteraction());
			if (orderedMessages != null && orderedMessages.size() >= 0) {
				NodeInitDataFigure interactionData = InteractionViewInitializationUtil
						.calculateInteractionInitData(interaction,
								orderedMessages, getOffset());
				if (interactionData != null) {
					InteractionViewInitializationUtil.createViews(
							getParentEditPart(), interactionData);
					return CommandResult.newOKCommandResult();
				}
			}
		}
		return CommandResult
				.newErrorCommandResult("Unable to initialize Interaction Views.");
	}
}
