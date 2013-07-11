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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.widgets.editors.TreeSelectorDialog;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityActivityContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.interactionoverview.Activator;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.part.CallBehaviorActionAsInteractionEditPart;
import org.eclipse.papyrus.uml.diagram.interactionoverview.figures.InteractionWithSnapshotFigure;
import org.eclipse.papyrus.uml.diagram.interactionoverview.part.Messages;
import org.eclipse.papyrus.uml.diagram.interactionoverview.provider.DiagramContentProvider;
import org.eclipse.papyrus.uml.diagram.interactionoverview.utils.CallBehaviorUtil;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EditPartUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.Interaction;


public class CreateSnapshotFromContextMenuCommand extends CreateSnapshotForInteractionFromRefreshCommand {

	protected CallBehaviorActionAsInteractionEditPart callBehaviorEditPart;

	public CreateSnapshotFromContextMenuCommand(final TransactionalEditingDomain editingDomain, final CallBehaviorActionAsInteractionEditPart callBehaviorActionEditPart) {

		super(editingDomain, (View)callBehaviorActionEditPart.getModel(), (GraphicalEditPart)EditPartUtils.findParentEditPartWithId(callBehaviorActionEditPart, ActivityActivityContentCompartmentEditPart.VISUAL_ID));
		setLabel(Messages.CreateSnapshotFromContextMenuCommand_createNewSnapshot);
		callBehaviorEditPart = callBehaviorActionEditPart;
		//Force update in command super class doExecute even though the ImageFigure already has an image
		isOverrideImage = true;
	}

	@Override
	protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
		CallBehaviorUtil.resetSnapshotEannotation(this.callBehaviorView);
		return super.doExecuteWithResult(monitor, info);
	}

	@Override
	protected Diagram findSequenceDiagram() {
		final TreeSelectorDialog dialog = new TreeSelectorDialog(Display.getDefault().getActiveShell());
		final ServicesRegistry servicesRegistry = ((IMultiDiagramEditor)(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor())).getServicesRegistry();
		final Interaction interaction = (Interaction)((CallBehaviorAction)(callBehaviorView.getElement())).getBehavior();
		if(interaction != null) {
			dialog.setContentProvider(new DiagramContentProvider(interaction));
			dialog.setInput(servicesRegistry);
			try {
				dialog.setLabelProvider(servicesRegistry.getService(LabelProviderService.class).getLabelProvider());
			} catch (final ServiceException e) {
				Activator.log.error(e);
			}
			dialog.setMessage(Messages.CreateSnapshotForInteractionFromViewDescriptorCommand_DiagramSelectorMessage);
			dialog.setTitle(Messages.CreateSnapshotForInteractionFromViewDescriptorCommand_DiagramSelectorTitle);
			if(dialog.open() == org.eclipse.jface.window.Window.OK) {
				final Object[] result = dialog.getResult();
				if(result != null && result.length > 0)
					return (Diagram)EMFHelper.getEObject(result[0]);
			}
		}
		return null;
	}

	@Override
	protected IStatus doUndo(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
		final IStatus status = super.doUndo(monitor, info);

		//force update of the snapshot
		final InteractionWithSnapshotFigure snapshotFigure = (InteractionWithSnapshotFigure)callBehaviorEditPart.getPrimaryShape();
		snapshotFigure.resetImage();
		callBehaviorEditPart.refresh();
		return status;
	}

	@Override
	protected IStatus doRedo(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
		final IStatus status = super.doRedo(monitor, info);

		//force update of the snapshot
		final InteractionWithSnapshotFigure snapshotFigure = (InteractionWithSnapshotFigure)callBehaviorEditPart.getPrimaryShape();
		snapshotFigure.resetImage();
		callBehaviorEditPart.refresh();
		return status;
	}
}
