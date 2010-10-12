package org.eclipse.papyrus.diagram.clazz.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.clazz.edit.commands.ClassifierTemplateParameterCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.OperationTemplateParameterCreateCommand;
import org.eclipse.papyrus.diagram.clazz.edit.commands.TemplateParameterCreateCommand;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;

/**
 * @generated
 */
public class TemplateSignatureTemplateParameterCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public TemplateSignatureTemplateParameterCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.TemplateSignature_3033);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.ClassifierTemplateParameter_3031 == req.getElementType()) {
			return getGEFWrapper(new ClassifierTemplateParameterCreateCommand(req));
		}
		if(UMLElementTypes.OperationTemplateParameter_3035 == req.getElementType()) {
			return getGEFWrapper(new OperationTemplateParameterCreateCommand(req));
		}
		if(UMLElementTypes.TemplateParameter_3016 == req.getElementType()) {
			return getGEFWrapper(new TemplateParameterCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
