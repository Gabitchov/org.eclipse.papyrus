/*****************************************************************************
 * Copyright (c) 2009 CEA.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.policies;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ComponentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.swt.widgets.Display;

public class CombinedFragmentItemComponentEditPolicy extends ComponentEditPolicy {

	private static final String DELETE_FROM_DIAGRAM_DLG_TITLE = DiagramUIMessages.PromptingDeleteAction_DeleteFromDiagramDialog_Title;

	private static final String DELETE_FROM_DIAGRAM_DLG_MESSAGE = "Are you sure you want to delete all messages on the combined fragment ?";

	/**
	 * Delete Combined fragment and child from the view. Also delete message if user wants.
	 * {@inheritDoc}
	 */
	@Override
	protected Command createDeleteViewCommand(GroupRequest deleteRequest) {
		CompositeCommand cmd = new DeleteCommandWithPopup("Delete combined fragment view");
		cmd.add(new CommandProxy(super.createDeleteViewCommand(deleteRequest)));

		Rectangle combinedFragmentBounds = ((GraphicalEditPart) getHost()).getFigure().getBounds();
		for (Object child : getHost().getParent().getChildren()) {
			if (child instanceof LifelineEditPart) {
				for (Object littlechild : ((LifelineEditPart) child).getChildren()) {
					if (littlechild instanceof ActionExecutionSpecificationEditPart
							|| littlechild instanceof BehaviorExecutionSpecificationEditPart) {
						ShapeNodeEditPart editPart = (ShapeNodeEditPart) littlechild;
						Rectangle executionSpecificationBounds = editPart.getFigure().getBounds();
						if (combinedFragmentBounds.intersects(executionSpecificationBounds)) {
							cmd.add(new DeleteCommand(editPart.getEditingDomain(), (View) editPart.getModel()));
						}
					}
				}
			}
		}

		return new ICommandProxy(cmd);
	}

	private final class DeleteCommandWithPopup extends CompositeCommand {

		public DeleteCommandWithPopup(String label) {
			super(label);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info)
				throws ExecutionException {
			if (showMessageDialog(DELETE_FROM_DIAGRAM_DLG_TITLE, DELETE_FROM_DIAGRAM_DLG_MESSAGE)) {
				return super.doExecuteWithResult(progressMonitor, info);
			}
			return null;
		}

		/**
		 * Show popup message
		 * 
		 * @generated NOT
		 * @param title
		 *            The title
		 * @param message
		 *            The message
		 * @return True if user click on OK
		 */
		private boolean showMessageDialog(String title, String message) {
			MessageDialogWithToggle dialog = MessageDialogWithToggle.openYesNoQuestion(Display.getCurrent()
					.getActiveShell(), title, message, null, false, (IPreferenceStore) ((IGraphicalEditPart) getHost())
					.getDiagramPreferencesHint().getPreferenceStore(),
					IPreferenceConstants.PREF_PROMPT_ON_DEL_FROM_MODEL);

			if (dialog.getReturnCode() == IDialogConstants.YES_ID)
				return true;
			else
				return false;
		}
	}

}
