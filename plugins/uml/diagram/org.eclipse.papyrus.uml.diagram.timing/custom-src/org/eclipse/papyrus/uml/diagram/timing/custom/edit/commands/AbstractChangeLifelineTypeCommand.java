/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands;

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.LifelineUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.LifelineUtils.LifelineType;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.ViewUtils;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLViewProvider;
import org.eclipse.uml2.uml.Lifeline;

public abstract class AbstractChangeLifelineTypeCommand extends AbstractTransactionalCommand {

	protected IGraphicalEditPart lifelineEditPart;

	/**
	 * Constructor of this command
	 * 
	 * @param domain
	 *        the transactional editing domain to execute the transaction
	 * @param lifelineEditPart
	 *        the editpart that will be transformed
	 * @param changeLifelineFromCompactToFull_commandLabel
	 */
	public AbstractChangeLifelineTypeCommand(final TransactionalEditingDomain domain, final IGraphicalEditPart lifelineEditPart, final String commandLabel) {
		super(domain, commandLabel, Collections.EMPTY_LIST);
		this.lifelineEditPart = lifelineEditPart;
	}

	@Override
	protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
		final EditPart parentEditPart = this.lifelineEditPart.getParent();
		// creation of the node
		final UMLViewProvider umlViewProvider = new UMLViewProvider();
		final Lifeline lifeline = (Lifeline)this.lifelineEditPart.resolveSemanticElement();
		final View view = this.lifelineEditPart.getNotationView();
		final View containerView = (View)view.eContainer();
		final int index = containerView.getChildren().indexOf(view);
		final Node lifelineNode = createTargetLifelineView(umlViewProvider, lifeline, containerView, index);
		lifelineNode.setLayoutConstraint(((Node)this.lifelineEditPart.getNotationView()).getLayoutConstraint());
		// copy all EAnnotations
		final Iterator<EAnnotation> iter = this.lifelineEditPart.getNotationView().getEAnnotations().iterator();
		while(iter.hasNext()) {
			final EAnnotation annotation = EcoreUtil.copy(iter.next());
			lifelineNode.getEAnnotations().add(annotation);
		}
		LifelineUtils.setLifelineType(lifeline, getTargetLifelineType());

		// select the new Lifeline View
		parentEditPart.refresh();
		ViewUtils.selectInViewer(lifelineNode, parentEditPart.getViewer());

		return CommandResult.newOKCommandResult(lifelineNode);
	}

	protected abstract LifelineType getTargetLifelineType();

	protected abstract Node createTargetLifelineView(final UMLViewProvider umlViewProvider, final Lifeline lifeline, final View containerView, final int index);
}
