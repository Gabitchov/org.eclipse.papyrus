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
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.widgets.editors.TreeSelectorDialog;
import org.eclipse.papyrus.uml.diagram.activity.edit.part.CustomActivityActivityContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.communication.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.interactionoverview.Activator;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.part.InteractionOverviewDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.interactionoverview.figures.InteractionWithSnapshotFigure;
import org.eclipse.papyrus.uml.diagram.interactionoverview.part.Messages;
import org.eclipse.papyrus.uml.diagram.interactionoverview.provider.DiagramContentProvider;
import org.eclipse.papyrus.uml.diagram.interactionoverview.utils.CallBehaviorUtil;
import org.eclipse.papyrus.uml.diagram.interactionoverview.utils.CreateDiagramImage;
import org.eclipse.papyrus.uml.diagram.interactionoverview.utils.URIUtils;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimingDiagramEditPart;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.Interaction;


public class CreateSnapshotForInteractionFromViewDescriptorCommand extends AbstractTransactionalCommand {

	protected ICommand createElementCommand;

	protected GraphicalEditPart host;

	public CreateSnapshotForInteractionFromViewDescriptorCommand(final TransactionalEditingDomain editingDomain, final ICommand createElementCommand, final GraphicalEditPart host) {
		super(editingDomain, Messages.CreateSnapshotForInteractionFromViewDescriptorCommand_CreateSnapshotForRefresh, null);
		this.createElementCommand = createElementCommand;
		this.host = host;
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	public static CreateSnapshotForInteractionFromViewDescriptorCommand create(final ICommand createElementCommand, final GraphicalEditPart host) {
		return new CreateSnapshotForInteractionFromViewDescriptorCommand(((AbstractEMFOperation)createElementCommand).getEditingDomain(), createElementCommand, host);
	}

	@Override
	protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {

		final View callBehaviorActionView = getViewFromCommandResult(createElementCommand);
		Diagram diagram = null;
		if(host instanceof CustomActivityActivityContentCompartmentEditPart) {

			final CallBehaviorAction callBehaviorAction = (CallBehaviorAction)callBehaviorActionView.getElement();
			final Behavior behavior = callBehaviorAction.getBehavior();
			diagram = findSequenceDiagram((Interaction)behavior);
			final ResourceSet resourceSet = behavior.eResource().getResourceSet();

			Resource newResource = null;
			Diagram cloneDiagram = null;
			try {
				newResource = resourceSet.createResource(org.eclipse.emf.common.util.URI.createURI(URIUtils.getTimestampedURI()));

				final Copier copier = new Copier(true, true);
				cloneDiagram = (Diagram)copier.copy(diagram);
				copier.copyReferences();
				if(cloneDiagram != null) {
					newResource.getContents().add(cloneDiagram);
				}
				final GraphicalEditPart behaviorEditPart = findBehaviorEditPart(host, callBehaviorAction);
				final IFigure borderedNodeImage = behaviorEditPart.getFigure();
				final IFigure callActionBehaviorImage = findInteractionWithSnapshotInFigure(borderedNodeImage);
				if(callActionBehaviorImage instanceof InteractionWithSnapshotFigure) {

					final ImageFigure imageFigure = ((InteractionWithSnapshotFigure)callActionBehaviorImage).getImageFigure();
					final PreferencesHint preferenceHint = getReferenceHint(diagram.getType());
					final Image image = CreateDiagramImage.getDiagramImage(cloneDiagram, preferenceHint, imageFigure, callBehaviorActionView);


					((InteractionWithSnapshotFigure)callActionBehaviorImage).setSnapshot(image);
				}
				CallBehaviorUtil.setDiagramLinked(callBehaviorActionView, diagram);
				behaviorEditPart.refresh();
			} finally {
				if(newResource != null) {
					resourceSet.getResources().remove(newResource);
				}
				if(cloneDiagram != null) {
					cloneDiagram.unsetElement();
					EcoreUtil.delete(cloneDiagram, true);
				}
			}
		}
		return CommandResult.newOKCommandResult(diagram);
	}

	protected View getViewFromCommandResult(final ICommand createElementCommand2) {
		final CommandResult commandResult = createElementCommand.getCommandResult();
		final Object resultAsObject = commandResult.getReturnValue();
		if(resultAsObject instanceof ViewDescriptor) {
			final ViewDescriptor viewDescriptor = (ViewDescriptor)resultAsObject;
			return (View)viewDescriptor.getAdapter(View.class);
		}else if(resultAsObject instanceof View){
			return (View)resultAsObject;
		}
		return null;
	}

	protected PreferencesHint getReferenceHint(final String type) {
		if(PackageEditPart.MODEL_ID.equals(type)) {
			return UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
		} else if(TimingDiagramEditPart.MODEL_ID.equals(type)) {
			return org.eclipse.papyrus.uml.diagram.timing.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
		} else if(InteractionOverviewDiagramEditPart.MODEL_ID.equals(type)) {
			return Activator.DIAGRAM_PREFERENCES_HINT;
		} else if(ModelEditPart.MODEL_ID.equals(type)) {
			return org.eclipse.papyrus.uml.diagram.communication.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
		}
		return null;
	}

	protected GraphicalEditPart findBehaviorEditPart(final EditPart parentEditPart, final CallBehaviorAction callBehaviorAction) {
		for(final Object child : parentEditPart.getChildren()) {
			if(child instanceof GraphicalEditPart) {
				final GraphicalEditPart editPartChild = (GraphicalEditPart)child;
				if(editPartChild.resolveSemanticElement() == callBehaviorAction) {
					return editPartChild;
				}
			}
		}
		return null;
	}

	protected IFigure findInteractionWithSnapshotInFigure(final IFigure containerFigure) {
		for(final Object childFigureAsObject : containerFigure.getChildren()) {
			if(childFigureAsObject instanceof IFigure) {
				final IFigure childFigure = (IFigure)childFigureAsObject;
				if(childFigure instanceof InteractionWithSnapshotFigure) {
					return childFigure;
				} else {
					if(!childFigure.getChildren().isEmpty()) {
						return findInteractionWithSnapshotInFigure(childFigure);
					}
				}
			}
		}
		return null;
	}

	protected Diagram findSequenceDiagram(final Interaction interaction) {

		final TreeSelectorDialog dialog = new TreeSelectorDialog(Display.getDefault().getActiveShell());
		final ServicesRegistry servicesRegistry = ((IMultiDiagramEditor)(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor())).getServicesRegistry();

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
			if(result != null && result.length > 0)// && result[0] instanceof ModelElementItem)
				return (Diagram)EMFHelper.getEObject(result[0]);//(Diagram)(((ModelElementItem)result[0]).getEObject());
		}

		return null;
	}
}
