package org.eclipse.papyrus.diagram.clazz.custom.policies.itemsemantic;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.diagram.clazz.custom.command.CGeneralizationSetCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.policies.GeneralizationItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;

public class CustomGeneralizationItemSemanticEditPolicy extends GeneralizationItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {

		if (UMLElementTypes.GeneralizationSet_4020 == req.getElementType()) {
			return getGEFWrapper(new CGeneralizationSetCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return super.getCompleteCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {

		if (UMLElementTypes.GeneralizationSet_4020 == req.getElementType()) {
			return getGEFWrapper(new CGeneralizationSetCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return super.getStartCreateRelationshipCommand(req);
	}
}
