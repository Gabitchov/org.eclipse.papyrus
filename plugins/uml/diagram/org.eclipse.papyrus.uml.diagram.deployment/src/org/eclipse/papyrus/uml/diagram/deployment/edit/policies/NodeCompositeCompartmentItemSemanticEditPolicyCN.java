/*
 * 
 */
package org.eclipse.papyrus.uml.diagram.deployment.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.uml.diagram.deployment.edit.commands.ArtifactCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.commands.DeviceCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.commands.ExecutionEnvironmentCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.commands.NodeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes;

/**
 * @generated
 */
public class NodeCompositeCompartmentItemSemanticEditPolicyCN extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public NodeCompositeCompartmentItemSemanticEditPolicyCN() {
		super(UMLElementTypes.Node_42);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		IElementType requestElementType = req.getElementType();
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
		if(UMLElementTypes.Device_16 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new DeviceCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.ExecutionEnvironment_21 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ExecutionEnvironmentCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Node_23 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new NodeCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if(UMLElementTypes.Artifact_25 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ArtifactCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		return super.getCreateCommand(req);
	}
}
