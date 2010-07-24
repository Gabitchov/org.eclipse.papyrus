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
package org.eclipse.papyrus.diagram.sequence.edit.policies;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.uml2.uml.Interaction;

import org.eclipse.papyrus.diagram.common.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.papyrus.diagram.common.editpolicies.ViewResolver;
import org.eclipse.papyrus.diagram.sequence.edit.commands.InitializeInteractionViewCommand;

/**
 * Drag and Drop edit policy for the sequence <Diagram>. Will perform the
 * drag&drop of an <Interaction> correctly, creating views according to the
 * general order of the <Message>s in the <Interaction>.
 * 
 * @author fjcano
 * 
 */
public class SequenceDiagramDragAndDropEditPolicy extends
		DiagramDragDropEditPolicy {

	/**
	 * Default constructor.
	 * 
	 * @param resolver
	 */
	public SequenceDiagramDragAndDropEditPolicy(ViewResolver resolver) {
		super(resolver);
	}

	@Override
	public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {
		// - get Interaction from DropRequest
		List<EObject> nodeObjects = findNodesInDrop(dropRequest);

		// We are only interested in Interactions
		List<Interaction> interactionObjects = new BasicEList<Interaction>();
		for (EObject obj : nodeObjects) {
			if (obj instanceof Interaction)
				interactionObjects.add((Interaction) obj);
		}
		if (interactionObjects.size() == 0) {
			return UnexecutableCommand.INSTANCE;
		}
		// - build and return command
		IGraphicalEditPart parentEditPart = getHost() instanceof IGraphicalEditPart ? (IGraphicalEditPart) getHost()
				: null;
		if (parentEditPart != null) {
			TransactionalEditingDomain domain = parentEditPart
					.getEditingDomain();
			if (domain != null) {
				CompoundCommand cCommand = new CompoundCommand();
				for (Interaction interaction : interactionObjects) {
					InitializeInteractionViewCommand command = new InitializeInteractionViewCommand(
							domain, "Initialize Interaction view", null);
					command.setParentEditPart(parentEditPart);
					command.setInteraction(interaction);
					command.setOffset(dropRequest.getLocation());
					cCommand.add(new ICommandProxy(command));
				}
				return cCommand;
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

}
