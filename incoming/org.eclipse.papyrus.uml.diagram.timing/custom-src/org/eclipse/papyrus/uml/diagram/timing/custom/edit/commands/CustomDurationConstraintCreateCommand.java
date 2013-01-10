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
import org.eclipse.uml2.uml.Duration;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.DurationInterval;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;

public class CustomDurationConstraintCreateCommand extends EditElementCommand {

	public CustomDurationConstraintCreateCommand(final CreateElementRequest req) {
		super(req.getLabel(), null, req);
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
		final CreateElementRequest request = (CreateElementRequest)getRequest();
		final EditPart firstTarget = (EditPart)request.getParameter(AbstractTwoPointCreationTool.FIRST_TARGET);
		final EditPart secondTarget = (EditPart)request.getParameter(AbstractTwoPointCreationTool.SECOND_TARGET);

		final DurationConstraint durationConstraint = UMLFactory.eINSTANCE.createDurationConstraint();
		final NamedElement firstTargetElement = (NamedElement)((View)firstTarget.getModel()).getElement();
		final NamedElement secondTargetElement = (NamedElement)((View)secondTarget.getModel()).getElement();

		final Package containingPackage = EcoreUtils.getContaining(request.getContainer(), Package.class);
		if(containingPackage == null) {
			return CommandResult.newErrorCommandResult("The container must be in a Package"); //$NON-NLS-1$
		}

		containingPackage.getPackagedElements().add(durationConstraint);
		durationConstraint.getConstrainedElements().clear();
		durationConstraint.getFirstEvents().clear();
		if(firstTargetElement == secondTargetElement) {
			durationConstraint.getConstrainedElements().add(firstTargetElement);
		} else {
			durationConstraint.getConstrainedElements().add(firstTargetElement);
			durationConstraint.getConstrainedElements().add(secondTargetElement);
			durationConstraint.getFirstEvents().add(Boolean.TRUE);
			durationConstraint.getFirstEvents().add(Boolean.FALSE);
		}

		final DurationInterval durationInterval = UMLFactory.eINSTANCE.createDurationInterval();
		durationConstraint.setSpecification(durationInterval);

		final Duration minTime = UMLFactory.eINSTANCE.createDuration();
		final Duration maxTime = UMLFactory.eINSTANCE.createDuration();
		containingPackage.getPackagedElements().add(minTime);
		containingPackage.getPackagedElements().add(maxTime);
		durationInterval.setMin(minTime);
		durationInterval.setMax(maxTime);

		final LiteralString minExpr = UMLFactory.eINSTANCE.createLiteralString();
		final LiteralString maxExpr = UMLFactory.eINSTANCE.createLiteralString();
		minTime.setExpr(minExpr);
		maxTime.setExpr(maxExpr);
		minExpr.setValue("d1"); //$NON-NLS-1$
		maxExpr.setValue("d2"); //$NON-NLS-1$

		request.setNewElement(durationConstraint);
		return CommandResult.newOKCommandResult(durationConstraint);
	}
}
