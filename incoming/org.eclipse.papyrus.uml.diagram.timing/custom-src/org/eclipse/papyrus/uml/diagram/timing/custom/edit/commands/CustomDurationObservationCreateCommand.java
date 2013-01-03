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
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EcoreUtils;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;

public class CustomDurationObservationCreateCommand extends EditElementCommand {

	public CustomDurationObservationCreateCommand(final CreateElementRequest req) {
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

		final DurationObservation durationObservation = UMLFactory.eINSTANCE.createDurationObservation();
		final NamedElement firstTargetElement = (NamedElement) ((View) firstTarget.getModel()).getElement();
		final NamedElement secondTargetElement = (NamedElement) ((View) secondTarget.getModel()).getElement();

		final Package containingPackage = EcoreUtils.getContaining(request.getContainer(), Package.class);
		if (containingPackage == null) {
			return CommandResult.newErrorCommandResult("The container must be in a Package"); //$NON-NLS-1$
		}

		containingPackage.getPackagedElements().add(durationObservation);
		durationObservation.getEvents().clear();
		durationObservation.getFirstEvents().clear();
		if (firstTargetElement == secondTargetElement) {
			durationObservation.getEvents().add(firstTargetElement);
		} else {
			durationObservation.getEvents().add(firstTargetElement);
			durationObservation.getEvents().add(secondTargetElement);
			durationObservation.getFirstEvents().add(Boolean.TRUE);
			durationObservation.getFirstEvents().add(Boolean.FALSE);
		}

		request.setNewElement(durationObservation);
		return CommandResult.newOKCommandResult(durationObservation);
	}
}
