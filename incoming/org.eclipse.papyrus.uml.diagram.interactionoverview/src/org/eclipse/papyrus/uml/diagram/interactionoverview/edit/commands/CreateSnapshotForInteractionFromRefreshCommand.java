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

import java.util.Iterator;

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
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.communication.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.interactionoverview.Activator;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.part.InteractionOverviewDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.interactionoverview.figures.InteractionWithSnapshotFigure;
import org.eclipse.papyrus.uml.diagram.interactionoverview.part.Messages;
import org.eclipse.papyrus.uml.diagram.interactionoverview.utils.CallBehaviorUtil;
import org.eclipse.papyrus.uml.diagram.interactionoverview.utils.CreateDiagramImage;
import org.eclipse.papyrus.uml.diagram.interactionoverview.utils.DiagramUtils;
import org.eclipse.papyrus.uml.diagram.interactionoverview.utils.URIUtils;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimingDiagramEditPart;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallBehaviorAction;


public class CreateSnapshotForInteractionFromRefreshCommand extends AbstractTransactionalCommand {

	protected View callBehaviorView;

	protected CallBehaviorAction callBehaviorAction;

	protected GraphicalEditPart host;

	protected boolean isOverrideImage;

	public CreateSnapshotForInteractionFromRefreshCommand(final TransactionalEditingDomain editingDomain, final View callBehaviorActionView, final GraphicalEditPart host) {
		super(editingDomain, Messages.CreateSnapshotForInteractionFromRefreshCommand_CreateSnapshotForRefresh, null);
		this.callBehaviorView = callBehaviorActionView;
		this.callBehaviorAction = (CallBehaviorAction)callBehaviorActionView.getElement();
		this.host = host;
		isOverrideImage = false;
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	public static CreateSnapshotForInteractionFromRefreshCommand create(final View callBehaviorActionView, final GraphicalEditPart host) {
		return new CreateSnapshotForInteractionFromRefreshCommand(TransactionUtil.getEditingDomain(callBehaviorActionView.getElement()), callBehaviorActionView, host);
	}

	@Override
	protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {

		final Behavior behavior = callBehaviorAction.getBehavior();
		final Diagram diagram = findSequenceDiagram();
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
				if(isOverrideImage || imageFigure.getImage() == null) {
					///test sur le bound
					final PreferencesHint preferenceHint = getReferenceHint(diagram.getType());
					final Image image = CreateDiagramImage.getDiagramImage(cloneDiagram, preferenceHint, imageFigure, callBehaviorView);


					((InteractionWithSnapshotFigure)callActionBehaviorImage).setSnapshot(image);
					CallBehaviorUtil.setDiagramLinked(callBehaviorView, diagram);
				}
			}
		} finally {
			if(newResource != null) {
				resourceSet.getResources().remove(newResource);
			}
			if(cloneDiagram != null) {
				cloneDiagram.unsetElement();
				EcoreUtil.delete(cloneDiagram, true);
			}
		}

		return CommandResult.newOKCommandResult();
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

	protected Diagram findSequenceDiagram() {
		final String uuidDiagram = CallBehaviorUtil.getDiagramLinked(callBehaviorView);
		if(uuidDiagram != null && !uuidDiagram.equals("")) {
			final ResourceSet resourceSet = callBehaviorAction.eResource().getResourceSet();
			final Iterator<?> ite = resourceSet.getAllContents();
			while(ite.hasNext()) {
				final Object eObject = ite.next();
				if(eObject instanceof Diagram) {
					final Diagram diagram = (Diagram)eObject;
					if(uuidDiagram.equals(DiagramUtils.getUUIDForSnapshot(diagram))) {
						return diagram;
					}
				}
			}
		}
		return null;
	}
}
