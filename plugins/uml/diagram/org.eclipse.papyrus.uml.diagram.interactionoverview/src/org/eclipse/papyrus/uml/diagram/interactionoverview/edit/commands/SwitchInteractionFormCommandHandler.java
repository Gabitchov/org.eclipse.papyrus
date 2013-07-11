/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.edit.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.handlers.GraphicalCommandHandler;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.part.CallBehaviorActionAsInteractionEditPart;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.part.CustomInteractionUseEditPartCN;
import org.eclipse.papyrus.uml.diagram.interactionoverview.part.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.RefreshCommandForDo;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.RefreshCommandForUndo;

public class SwitchInteractionFormCommandHandler extends
		GraphicalCommandHandler {

	@Override
	protected Command getCommand() throws ExecutionException {
		
		List<IGraphicalEditPart> elements = getSelectedElements();
		if(elements.size() == 1 && elements.get(0) instanceof CustomInteractionUseEditPartCN){
			CustomInteractionUseEditPartCN callBehaviorActionEditPart = (CustomInteractionUseEditPartCN)elements.get(0);
			View callBehaviorView = (View)callBehaviorActionEditPart.getModel();
			CompoundCommand cc = new CompoundCommand(Messages.SwitchInteractionFormCommandHandler_InteractionUseToInteractionCommandTitle);
			ChangeInteractionUseToInteraction changeCommand = new ChangeInteractionUseToInteraction(getEditingDomain(), callBehaviorActionEditPart);
			cc.add(new RefreshCommandForUndo((GraphicalEditPart)callBehaviorActionEditPart.getParent()));
			cc.add(new ICommandProxy(changeCommand));
			cc.add(new ICommandProxy(new DestroyElementCommand(new DestroyElementRequest(callBehaviorView, true))));
			CreateSnapshotForInteractionFromViewDescriptorCommand snapshotCommand = new CreateSnapshotForInteractionFromViewDescriptorCommand(getEditingDomain(), changeCommand, (GraphicalEditPart)callBehaviorActionEditPart.getParent()); 
			cc.add(new ICommandProxy(snapshotCommand));
			cc.add(new ICommandProxy(new AddHyperlinkDiagram(changeCommand, snapshotCommand)));
			cc.add(new RefreshCommandForDo((GraphicalEditPart)callBehaviorActionEditPart.getParent()));
			return cc;
		}else if(elements.size() == 1 && elements.get(0) instanceof CallBehaviorActionAsInteractionEditPart){
			CallBehaviorActionAsInteractionEditPart callBehaviorActionEditPart = (CallBehaviorActionAsInteractionEditPart)elements.get(0);
			View callBehaviorView = (View)callBehaviorActionEditPart.getModel();
			CompoundCommand cc = new CompoundCommand(Messages.SwitchInteractionFormCommandHandler_InteractionToInteractionUseCommandTitle);
			ChangeInteractionToInteractionUseCommand changeCommand = new ChangeInteractionToInteractionUseCommand(getEditingDomain(), callBehaviorActionEditPart);
			cc.add(new ICommandProxy(changeCommand));
			cc.add(new ICommandProxy(new DestroyElementCommand(new DestroyElementRequest(callBehaviorView, true))));
			return cc;
		}
		return UnexecutableCommand.INSTANCE;
	}

}
