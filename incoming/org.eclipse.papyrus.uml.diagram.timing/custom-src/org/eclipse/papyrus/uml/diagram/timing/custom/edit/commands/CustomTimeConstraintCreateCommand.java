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
import org.eclipse.papyrus.uml.diagram.timing.custom.parts.CustomPaletteFactory;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EcoreUtils;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.TimeExpression;
import org.eclipse.uml2.uml.TimeInterval;
import org.eclipse.uml2.uml.UMLFactory;

public class CustomTimeConstraintCreateCommand extends EditElementCommand {

	public CustomTimeConstraintCreateCommand(final CreateElementRequest req) {
		super(req.getLabel(), null, req);
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
		final TimeConstraint timeConstraint = UMLFactory.eINSTANCE.createTimeConstraint();
		final CreateElementRequest request = (CreateElementRequest) getRequest();
		final EditPart originalTarget = (EditPart) request.getParameter(CustomPaletteFactory.ORIGINAL_TARGET);
		final NamedElement targetElement = (NamedElement) ((View) originalTarget.getModel()).getElement();

		// TODO: firstEvent depending on the click location relative to the originalTarget EditPart figure

		final Package containingPackage = EcoreUtils.getContaining(request.getContainer(), Package.class);
		if (containingPackage == null) {
			return CommandResult.newErrorCommandResult("The container must be in a Package"); //$NON-NLS-1$
		}
		final Interaction containingInteraction = EcoreUtils.getContaining(request.getContainer(), Interaction.class);
		if (containingInteraction == null) {
			return CommandResult.newErrorCommandResult("The container must be in an Interaction"); //$NON-NLS-1$
		}

		containingInteraction.getOwnedRules().add(timeConstraint);
		timeConstraint.getConstrainedElements().clear();
		timeConstraint.getConstrainedElements().add(targetElement);

		final TimeInterval timeInterval = UMLFactory.eINSTANCE.createTimeInterval();
		timeConstraint.setSpecification(timeInterval);

		final TimeExpression minTime = UMLFactory.eINSTANCE.createTimeExpression();
		final TimeExpression maxTime = UMLFactory.eINSTANCE.createTimeExpression();
		containingPackage.getPackagedElements().add(minTime);
		containingPackage.getPackagedElements().add(maxTime);
		timeInterval.setMin(minTime);
		timeInterval.setMax(maxTime);

		final LiteralString minExpr = UMLFactory.eINSTANCE.createLiteralString();
		final LiteralString maxExpr = UMLFactory.eINSTANCE.createLiteralString();
		minTime.setExpr(minExpr);
		maxTime.setExpr(maxExpr);
		minExpr.setValue("t1"); //$NON-NLS-1$
		maxExpr.setValue("t2"); //$NON-NLS-1$

		((CreateElementRequest) getRequest()).setNewElement(timeConstraint);
		return CommandResult.newOKCommandResult(timeConstraint);

	}
}
