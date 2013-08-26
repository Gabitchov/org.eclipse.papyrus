package org.eclipse.papyrus.sysml.diagram.parametric.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;

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
