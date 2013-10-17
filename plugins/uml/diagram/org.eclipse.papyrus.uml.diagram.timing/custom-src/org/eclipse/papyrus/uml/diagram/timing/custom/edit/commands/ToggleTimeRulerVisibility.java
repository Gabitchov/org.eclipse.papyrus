/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.handlers.GraphicalCommandHandler;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.CompactLifelineFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.FullLifelineFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.LifelineFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EditPartUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.FigureUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.ViewUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.InteractionEditPartTN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.LifelineEditPart;

public class ToggleTimeRulerVisibility extends GraphicalCommandHandler {

	@Override
	protected Command getCommand() {
		final CompoundCommand cmd = new CompoundCommand(Messages.ToggleTimeRulerVisibility_ToggleTimeRulerVisibility);
		final List<IGraphicalEditPart> selectedElements = getSelectedElements();
		boolean first = true;
		InteractionEditPartTN interactionEditPart = null;
		for(final IGraphicalEditPart selectedEditPart : selectedElements) {
			if(selectedEditPart instanceof FullLifelineEditPartCN || selectedEditPart instanceof CompactLifelineEditPartCN) {
				if(first) {
					interactionEditPart = (InteractionEditPartTN)EditPartUtils.findParentEditPartWithId(selectedEditPart, InteractionEditPartTN.VISUAL_ID);
					if(interactionEditPart != null) {
						cmd.add(new RefreshCommandForUndo(interactionEditPart));
						first = false;
					}
				}
				cmd.add(toggleTimeRulerVisibility(selectedEditPart));
			}
		}
		if(interactionEditPart != null) {
			cmd.add(new RefreshCommandForDo(interactionEditPart));
		}
		return cmd;
	}

	private Command toggleTimeRulerVisibility(final IGraphicalEditPart object) {
		return new ICommandProxy(new AbstractTransactionalCommand(getEditingDomain(), Messages.ToggleTimeRulerVisibility_ToggleTimeRulerVisibility, null, null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				final LifelineEditPart lifelineEditPart = (LifelineEditPart)object;
				final View lifelineView = (View)lifelineEditPart.getModel();
				final View timeRulerCompartmentView = ViewUtils.findTimeRulerCompartmentView(lifelineView);
				timeRulerCompartmentView.setVisible(!timeRulerCompartmentView.isVisible());
				return CommandResult.newOKCommandResult();
			}
		});
	}

	protected static final LifelineFigure getLifelineFigure(final IFigure figure) {
		LifelineFigure result = null;
		result = FigureUtils.findChildFigureInstance(figure, FullLifelineFigure.class);
		if(result == null) {
			result = FigureUtils.findChildFigureInstance(figure, CompactLifelineFigure.class);
		}
		return result;
	}
}
