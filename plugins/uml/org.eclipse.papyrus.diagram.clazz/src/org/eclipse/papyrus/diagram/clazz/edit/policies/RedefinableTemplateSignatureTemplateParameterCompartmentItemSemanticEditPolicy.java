package org.eclipse.papyrus.diagram.clazz.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.clazz.edit.commands.TemplateParameterCreateCommand;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;

/**
 * @generated
 */
public class RedefinableTemplateSignatureTemplateParameterCompartmentItemSemanticEditPolicy
		extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public RedefinableTemplateSignatureTemplateParameterCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.RedefinableTemplateSignature_3015);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.TemplateParameter_3016 == req.getElementType()) {
			return getGEFWrapper(new TemplateParameterCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
