/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.utils;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FreeTimeRulerCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.InteractionEditPartTN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimeRulerCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLViewProvider;

public final class TimeRulerUtils {

	private TimeRulerUtils() {
		// utility class
	}

	/**
	 * @param createViewCommand
	 * 
	 * @param editPart
	 * @param visible
	 * @return
	 */
	/**
	 * @param createViewCommand
	 *        the command that creates a Lifeline or Interaction View
	 * @param editingDomain
	 *        an editing domain
	 * @param visible
	 *        whether the time ruler should be visible initially
	 * @return the time ruler creation command
	 */
	public static ICommand getCreateFreeTimeRulerCommand(final Command createViewCommand, final TransactionalEditingDomain editingDomain, final boolean visible) {
		final CommandResult superCommandResult = ((ICommandProxy)createViewCommand).getICommand().getCommandResult();
		// final Interaction interaction = (Interaction) superCommandResult.getElement();
		if(editingDomain == null) {
			throw new IllegalStateException("no editing domain"); //$NON-NLS-1$
		}

		final AbstractTransactionalCommand createFreeTimeRulerCommand = new AbstractTransactionalCommand(editingDomain, Messages.CustomTimeRulerCreationEditPolicy_CreateFreeTimeRuler, null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				// the result from the super command that creates the view
				final ViewDescriptor viewDescriptor = (ViewDescriptor)superCommandResult.getReturnValue();
				final View view = (View)viewDescriptor.getAdapter(View.class);
				final Node freeTimeRulerNode = createFreeTimeRuler(view);
				final View timeRulerCompartmentView = ViewUtils.findTimeRulerCompartmentView(view);
				timeRulerCompartmentView.setVisible(visible);
				return CommandResult.newOKCommandResult(freeTimeRulerNode);
			}
		};
		return createFreeTimeRulerCommand;
	}

	public static Node createFreeTimeRuler(final View view) {
		final View timeRulerCompartmentView = ViewUtils.findTimeRulerCompartmentView(view);
		final UMLViewProvider umlViewProvider = new UMLViewProvider();
		return umlViewProvider.createNode_24(null, timeRulerCompartmentView, 0, true, UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
	}

	/**
	 * Find and return the FreeTimeRulerCompartmentEditPart in the Lifeline or Interaction that contains the given
	 * editPart. If the containing Lifeline has a time ruler, then return it. Otherwise, return the containing
	 * Interaction's time ruler.
	 */
	public static IGraphicalEditPart findClosestTimeRuler(final IGraphicalEditPart editPart) {
		IGraphicalEditPart lifelineEditPart = (IGraphicalEditPart)EditPartUtils.findParentEditPartWithId(editPart, CompactLifelineEditPartCN.VISUAL_ID);
		if(lifelineEditPart == null) {
			lifelineEditPart = (IGraphicalEditPart)EditPartUtils.findParentEditPartWithId(editPart, FullLifelineEditPartCN.VISUAL_ID);
		}
		if(lifelineEditPart != null) {
			IGraphicalEditPart tickContainerEditPart = (IGraphicalEditPart)EditPartUtils.findFirstChildEditPartWithId(lifelineEditPart, FreeTimeRulerCompartmentEditPart.VISUAL_ID);
			if(tickContainerEditPart == null) {
				// then tickContainer is in the Interaction
				final IGraphicalEditPart interactionEditPart = (IGraphicalEditPart)EditPartUtils.findParentEditPartWithId(lifelineEditPart, InteractionEditPartTN.VISUAL_ID);
				if(interactionEditPart != null) {
					final IGraphicalEditPart interactionTimeRulerCompartmentEditPart = (IGraphicalEditPart)EditPartUtils.findFirstChildEditPartWithId(interactionEditPart, TimeRulerCompartmentEditPartCN.VISUAL_ID);
					if(interactionTimeRulerCompartmentEditPart != null) {
						tickContainerEditPart = (IGraphicalEditPart)EditPartUtils.findFirstChildEditPartWithId(interactionTimeRulerCompartmentEditPart, FreeTimeRulerCompartmentEditPart.VISUAL_ID);
					}
				}
			}
			return tickContainerEditPart;
		}
		return null;
	}
}
