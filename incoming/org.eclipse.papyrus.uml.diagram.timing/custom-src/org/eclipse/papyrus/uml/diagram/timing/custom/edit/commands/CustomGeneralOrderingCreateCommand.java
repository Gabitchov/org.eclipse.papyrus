/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.custom.parts.AbstractTwoPointCreationTool;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.UMLFactory;

public class CustomGeneralOrderingCreateCommand extends EditElementCommand {

	public CustomGeneralOrderingCreateCommand(final CreateElementRequest req) {
		super(req.getLabel(), null, req);
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
		final CreateElementRequest request = (CreateElementRequest) getRequest();
		final EditPart firstTarget = (EditPart) request.getParameter(AbstractTwoPointCreationTool.FIRST_TARGET);
		final EditPart secondTarget = (EditPart) request.getParameter(AbstractTwoPointCreationTool.SECOND_TARGET);

		final GeneralOrdering generalOrdering = UMLFactory.eINSTANCE.createGeneralOrdering();
		final OccurrenceSpecification beforeOccurrence = (OccurrenceSpecification) ((View) firstTarget.getModel()).getElement();
		final OccurrenceSpecification afterOccurrence = (OccurrenceSpecification) ((View) secondTarget.getModel()).getElement();

		beforeOccurrence.getGeneralOrderings().add(generalOrdering);
		generalOrdering.setBefore(beforeOccurrence);
		generalOrdering.setAfter(afterOccurrence);
		beforeOccurrence.getToAfters().add(generalOrdering);

		return CommandResult.newOKCommandResult(generalOrdering);
	}
}
