/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.parts;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;

/** A creation tool that only allows creating connections between specific types. */
public class SpecificTypeCreationTool extends AspectUnspecifiedTypeConnectionTool {
	private final Collection<EClass> sourceTypes;
	private final Collection<EClass> targetTypes;

	/**
	 * @param connectionTypeToCreate
	 *            the element type of the connection to create
	 * @param sourceTypes
	 *            the connection will only be allowed if the source is of one of these types
	 * @param targetTypes
	 *            the connection will only be allowed if the target is of one of these types
	 */
	public SpecificTypeCreationTool(final IElementType connectionTypeToCreate, final Collection<EClass> sourceTypes, final Collection<EClass> targetTypes) {
		super(Collections.singletonList(connectionTypeToCreate));
		this.sourceTypes = sourceTypes;
		this.targetTypes = targetTypes;
	}

	@Override
	protected Command getCommand() {
		final EditPart targetEditPart = getTargetEditPart();
		EObject element = null;
		if (targetEditPart != null && targetEditPart.getModel() instanceof View) {
			element = ((View) targetEditPart.getModel()).getElement();
		}

		// only allow creating a connection that starts from the sourceType
		if (isInState(STATE_INITIAL)) {
			if (!isOfType(element, this.sourceTypes)) {
				return null;
			}
		}

		// only allow creating a connection that goes to the targetType
		if (isInState(STATE_CONNECTION_STARTED) || isInState(STATE_TERMINAL)) {
			if (!isOfType(element, this.targetTypes)) {
				return null;
			}
		}
		return super.getCommand();
	}

	private static boolean isOfType(final EObject element, final Collection<EClass> types) {
		for (final EClass eClass : types) {
			if (eClass.isInstance(element)) {
				return true;
			}
		}
		return false;
	}
}