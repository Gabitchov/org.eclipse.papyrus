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

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.papyrus.diagram.common.edit.policies.DiagramDragDropEditPolicy;
import org.eclipse.papyrus.diagram.common.edit.policies.ViewResolver;
import org.eclipse.papyrus.diagram.sequence.edit.commands.InitializeInteractionViewCommand;
import org.eclipse.uml2.uml.Interaction;


/**
 * Drag and Drop edit policy for the sequence <Diagram>. Will perform the drag&drop of an <Interaction> correctly, creating views according to the general order of the <Message>s in the <Interaction>.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * 
 */
public class SequenceDiagramDragAndDropEditPolicy extends DiagramDragDropEditPolicy {

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
		Interaction interaction = null;
		for (Object object : dropRequest.getObjects()) {
			if (object instanceof Interaction) {
				interaction = (Interaction) object;
				break;
			}
		}
		if (interaction == null) {
			return UnexecutableCommand.INSTANCE;
		}
		// - build and return command
		IGraphicalEditPart parentEditPart = getHost() instanceof IGraphicalEditPart ? (IGraphicalEditPart) getHost() : null;
		if (parentEditPart != null) {
			TransactionalEditingDomain domain = parentEditPart.getEditingDomain();
			if (domain != null) {
				InitializeInteractionViewCommand command = new InitializeInteractionViewCommand(domain, "Initialize Interaction view", null);
				command.setParentEditPart(parentEditPart);
				command.setInteraction(interaction);
				command.setOffset(dropRequest.getLocation());
				return new ICommandProxy(command);
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

}
