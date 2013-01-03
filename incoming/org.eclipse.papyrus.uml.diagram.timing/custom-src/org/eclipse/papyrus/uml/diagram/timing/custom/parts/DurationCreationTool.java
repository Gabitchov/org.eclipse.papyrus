/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EditPartUtils;
import org.eclipse.uml2.uml.UMLPackage;

public class DurationCreationTool extends AbstractTwoPointCreationTool {

	public DurationCreationTool(final IElementType elementType) {
		super(elementType);
	}

	@Override
	protected boolean validateFirstTarget(final EditPart firstTarget) {
		return firstTarget != null
				&& EditPartUtils.isEditPartFor(firstTarget, UMLPackage.eINSTANCE.getOccurrenceSpecification(), UMLPackage.eINSTANCE.getStateInvariant());
	}

	@Override
	protected boolean validateSecondTarget(final EditPart firstTarget, final EditPart secondTarget) {
		if (secondTarget == null
				|| !EditPartUtils.isEditPartFor(secondTarget, UMLPackage.eINSTANCE.getOccurrenceSpecification(), UMLPackage.eINSTANCE.getStateInvariant())) {
			return false;
		}
		return ordered(firstTarget, secondTarget);
	}

	/** Redirect the creation request to the parent (Lifeline compartment) */
	@Override
	protected Command getCommand(final EditPart firstTarget, final EditPart secondTarget, final Request request) {
		return secondTarget.getParent().getCommand(request);
	}

	@Override
	protected void started() {
		setStatusMessage(Messages.DurationCreationTool_ClickStartElement);

	}

	@Override
	protected void firstElementSelected() {
		setStatusMessage(Messages.DurationCreationTool_ClickEndElement);

	}

}
