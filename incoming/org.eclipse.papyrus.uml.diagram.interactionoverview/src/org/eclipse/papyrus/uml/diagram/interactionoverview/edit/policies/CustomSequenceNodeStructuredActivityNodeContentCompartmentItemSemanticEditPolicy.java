package org.eclipse.papyrus.uml.diagram.interactionoverview.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils;
import org.eclipse.papyrus.uml.diagram.activity.edit.policies.SequenceNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.commands.CallBehaviorActionAsInteractionUseCreateCommand;


public class CustomSequenceNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy extends SequenceNodeStructuredActivityNodeContentCompartmentItemSemanticEditPolicy {

	protected Command getCreateCommand(final CreateElementRequest req) {
		final IElementType requestElementType = req.getElementType();
		if(requestElementType == null) {
			return super.getCreateCommand(req);
		}
		IElementType baseElementType = requestElementType;
		boolean isExtendedType = false;
		if(requestElementType instanceof IExtendedHintedElementType) {
			baseElementType = ElementTypeUtils.getClosestDiagramType(requestElementType);
			if(baseElementType != null) {
				isExtendedType = true;
			} else {
				// no reference element type ID. using the closest super element type to give more opportunities, but can lead to bugs.
				baseElementType = ElementTypeUtils.findClosestNonExtendedElementType((IExtendedHintedElementType)requestElementType);
				isExtendedType = true;
			}
		}
		if(UMLElementTypes.CallBehaviorAction_3008 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new CallBehaviorActionAsInteractionUseCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}
}
