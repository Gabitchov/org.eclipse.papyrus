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
import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.interactionoverview.utils.CallBehaviorUtil;
import org.eclipse.papyrus.uml.diagram.interactionoverview.utils.CallBehaviorUtil.CallBehaviorActionType;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.ViewUtils;
import org.eclipse.uml2.uml.CallBehaviorAction;

public abstract class AbstractChangeInteractionTypeCommand extends
		AbstractTransactionalCommand {

	protected IGraphicalEditPart callBehaviorActionEditPart;

	/**
	 * Constructor of this command
	 * 
	 * @param domain
	 *        the transactional editing domain to execute the transaction
	 * @param callBehaviorActionEditPart
	 *        the editpart that will be transformed
	 * @param commandLabel
	 */
	public AbstractChangeInteractionTypeCommand(final TransactionalEditingDomain domain, final IGraphicalEditPart callBehaviorActionEditPart, final String commandLabel) {
		super(domain, commandLabel, Collections.EMPTY_LIST);
		this.callBehaviorActionEditPart = callBehaviorActionEditPart;
	}

	@Override
	protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
		final EditPart parentEditPart = this.callBehaviorActionEditPart.getParent();
		// creation of the node
		final CallBehaviorAction callBehaviorAction = (CallBehaviorAction)this.callBehaviorActionEditPart.resolveSemanticElement();
		final View view = this.callBehaviorActionEditPart.getNotationView();
		final View containerView = (View)view.eContainer();
		final int index = containerView.getChildren().indexOf(view);
		final Node callBehaviorActionNode = createTargetCallBehaviorView(callBehaviorAction, containerView, index);
		callBehaviorActionNode.setLayoutConstraint(((Node)this.callBehaviorActionEditPart.getNotationView()).getLayoutConstraint());
		// copy all EAnnotations
		final Iterator<EAnnotation> iter = this.callBehaviorActionEditPart.getNotationView().getEAnnotations().iterator();
		while(iter.hasNext()) {
			final EAnnotation annotation = EcoreUtil.copy(iter.next());
			callBehaviorActionNode.getEAnnotations().add(annotation);
		}
		CallBehaviorUtil.setCallBehaviorActionType(callBehaviorAction, getTargetCallBehaviorType());

		// select the new callBehaviorAction View
		parentEditPart.refresh();
		ViewUtils.selectInViewer(callBehaviorActionNode, parentEditPart.getViewer());
		EditPartViewer viewer = parentEditPart.getViewer();
		GraphicalEditPart newEditPart = (GraphicalEditPart)viewer.getEditPartRegistry().get(callBehaviorActionNode);
		return CommandResult.newOKCommandResult(callBehaviorActionNode);
	}

	protected abstract CallBehaviorActionType getTargetCallBehaviorType();

	protected abstract Node createTargetCallBehaviorView(final CallBehaviorAction callBehaviorAction, final View containerView, final int index);

}
