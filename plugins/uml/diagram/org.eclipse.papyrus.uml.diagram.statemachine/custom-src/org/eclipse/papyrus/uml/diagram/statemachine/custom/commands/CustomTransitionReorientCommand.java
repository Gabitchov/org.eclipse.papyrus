/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.statemachine.custom.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.commands.TransitionReorientCommand;
import org.eclipse.uml2.uml.Vertex;

/**
 * Customized transition-reorient command, takes changing of container into account.
 * 
 * @author ansgar
 *
 */
public class CustomTransitionReorientCommand extends TransitionReorientCommand {
	/**
	 * @generated
	 */
	protected final EObject newEnd;

	public CustomTransitionReorientCommand(ReorientRelationshipRequest request) {
		super(request);
		newEnd = request.getNewRelationshipEnd();
	}

	@Override
	protected CommandResult reorientSource() throws ExecutionException {
		getLink().setSource(getNewSource());
		EMFCustomTransitionRetargetContainerCommand.changeContainer(getLink());
		return CommandResult.newOKCommandResult(getLink());
	}

	@Override
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setTarget(getNewTarget());
		EMFCustomTransitionRetargetContainerCommand.changeContainer(getLink());
		return CommandResult.newOKCommandResult(getLink());
	}

	@Override
	protected boolean canReorientSource() {
		Vertex target = getLink().getTarget();
		if (!EMFCustomTransitionRetargetContainerCommand.isValid(newEnd, target)) {
			return false;
		}
		return super.canReorientSource();
	}

	@Override
	protected boolean canReorientTarget() {
		Vertex source = getLink().getSource();
		if (!EMFCustomTransitionRetargetContainerCommand.isValid(source, newEnd)) {
			return false;
		}
		return super.canReorientTarget();
	}
}
