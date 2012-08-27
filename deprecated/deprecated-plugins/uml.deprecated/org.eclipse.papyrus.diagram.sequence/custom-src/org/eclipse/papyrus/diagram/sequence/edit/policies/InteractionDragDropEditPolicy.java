/*******************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Sequence Diagram Implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;

import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;

public class InteractionDragDropEditPolicy extends DragDropEditPolicy {

	@Override
	protected Command getDropCommand(ChangeBoundsRequest request) {
		for(Object ep : request.getEditParts())
		{
			if (ep instanceof BehaviorExecutionSpecificationEditPart)
			{
				return UnexecutableCommand.INSTANCE;
			}
			else if(ep instanceof LifelineEditPart)
			{
				return UnexecutableCommand.INSTANCE;
			}
		}
		
		return super.getDropCommand(request);
	}
}
