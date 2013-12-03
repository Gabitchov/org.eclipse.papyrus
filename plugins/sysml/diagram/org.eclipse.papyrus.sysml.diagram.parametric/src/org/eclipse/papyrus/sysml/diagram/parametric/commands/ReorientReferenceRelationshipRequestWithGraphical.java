/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Régis CHEVREL: chevrel.regis <at> gmail.com
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;

/**
 * This class extends "classical" ReorientReferenceRelationshipRequest with the source and the target editPart.
 * These EditPart are needed for algorithms based on graphics:
 * - determine if a property is a ConstraintParameter
 * - calculate nestedPath
 */
public class ReorientReferenceRelationshipRequestWithGraphical extends
		ReorientReferenceRelationshipRequest {

	private EditPart sourceEditPart;
	private EditPart targetEditPart;

	public ReorientReferenceRelationshipRequestWithGraphical(
			TransactionalEditingDomain editingDomain, EObject referenceOwner,
			EObject newRelationshipEnd, EObject oldRelationshipEnd,
			int direction, EditPart sourceEditPart, EditPart targetEditPart) {
		super(editingDomain, referenceOwner, newRelationshipEnd, oldRelationshipEnd, direction);
		this.sourceEditPart = sourceEditPart;
		this.targetEditPart = targetEditPart;
	}


	public EditPart getSourceEditPart() {
		return sourceEditPart;
	}

	public EditPart getTargetEditPart() {
		return targetEditPart;
	}

}
