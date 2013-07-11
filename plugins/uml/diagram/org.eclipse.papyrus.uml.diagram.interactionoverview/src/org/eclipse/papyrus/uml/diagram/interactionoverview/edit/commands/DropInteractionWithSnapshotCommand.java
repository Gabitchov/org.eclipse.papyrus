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

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.interactionoverview.provider.CustomViewProvider;
import org.eclipse.papyrus.uml.diagram.interactionoverview.utils.CallBehaviorUtil;
import org.eclipse.papyrus.uml.diagram.interactionoverview.utils.CallBehaviorUtil.CallBehaviorActionType;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.ViewUtils;
import org.eclipse.uml2.uml.CallBehaviorAction;

public class DropInteractionWithSnapshotCommand extends
		AbstractTransactionalCommand {

	protected IGraphicalEditPart parentEditPart;
	
	protected CallBehaviorAction callBehaviorAction;
	
	public DropInteractionWithSnapshotCommand(final TransactionalEditingDomain domain, final IGraphicalEditPart parentEditPart, CallBehaviorAction callBehaviorAction, final String commandLabel) {
		super(domain, commandLabel, Collections.EMPTY_LIST);
		this.parentEditPart = parentEditPart;
		this.callBehaviorAction = callBehaviorAction;
	}
	
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		// creation of the node
		final View containerView = (View)parentEditPart.getModel();
		final Node callBehaviorActionNode = createTargetCallBehaviorView(callBehaviorAction, containerView, -1);
		/*// copy all EAnnotations
		final Iterator<EAnnotation> iter = this.callBehaviorActionEditPart.getNotationView().getEAnnotations().iterator();
		while(iter.hasNext()) {
			final EAnnotation annotation = EcoreUtil.copy(iter.next());
			callBehaviorActionNode.getEAnnotations().add(annotation);
		}*/
		CallBehaviorUtil.setCallBehaviorActionType(callBehaviorAction, getTargetCallBehaviorType());

		// select the new callBehaviorAction View
		parentEditPart.refresh();
		ViewUtils.selectInViewer(callBehaviorActionNode, parentEditPart.getViewer());
		EditPartViewer viewer = parentEditPart.getViewer();
		GraphicalEditPart newEditPart = (GraphicalEditPart)viewer.getEditPartRegistry().get(callBehaviorActionNode);
		return CommandResult.newOKCommandResult(callBehaviorActionNode);
	}

	protected Node createTargetCallBehaviorView(
			CallBehaviorAction callBehaviorAction, View containerView, int index) {
		CustomViewProvider viewProvider = new CustomViewProvider();
		return viewProvider.createCallBehaviorAction_5000(callBehaviorAction, containerView, index, true, this.parentEditPart.getDiagramPreferencesHint());
	}
	
	protected CallBehaviorActionType getTargetCallBehaviorType() {
		return CallBehaviorActionType.snapshot;
	}
}
