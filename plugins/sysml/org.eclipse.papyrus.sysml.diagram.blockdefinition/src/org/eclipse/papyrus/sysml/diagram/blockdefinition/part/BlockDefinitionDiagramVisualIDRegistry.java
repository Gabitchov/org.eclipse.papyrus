package org.eclipse.papyrus.sysml.diagram.blockdefinition.part;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.BlockDefinitionDiagramElementTypes;

/**
 * @generated
 */
public class BlockDefinitionDiagramVisualIDRegistry {

	/**
	 * @generated
	 */
	public static String getNodeVisualID(org.eclipse.gmf.runtime.notation.View containerView, org.eclipse.emf.ecore.EObject domainElement) {
		if(domainElement == null) {
			return null;
		}
		String containerModelID = org.eclipse.papyrus.sysml.diagram.blockdefinition.part.BlockDefinitionDiagramVisualIDRegistry.getModelID(containerView);
		if(!org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockDefinitionDiagramEditPart.DIAGRAM_ID.equals(containerModelID)) { //TODO check shortcuts  
			return null;
		}
		String containerVisualID;
		if(org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockDefinitionDiagramEditPart.DIAGRAM_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.sysml.diagram.blockdefinition.part.BlockDefinitionDiagramVisualIDRegistry.getVisualID(containerView);
		} else {
			if(containerView instanceof org.eclipse.gmf.runtime.notation.Diagram) {
				containerVisualID = BlockDefinitionDiagramElementTypes.BLOCK_DEFINITION_DIAGRAM.getSemanticHint();
			} else {
				return null;
			}
		}
		if(org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockDefinitionDiagramEditPart.DIAGRAM_ID.equals(containerVisualID)) {

			if(domainElement instanceof org.eclipse.uml2.uml.AssociationClass) {
				return BlockDefinitionDiagramElementTypes.ASSOCIATION_CLASS.getSemanticHint();
			}


			if(domainElement instanceof org.eclipse.uml2.uml.InstanceSpecification) {
				return BlockDefinitionDiagramElementTypes.INSTANCE_SPECIFICATION.getSemanticHint();
			}



			if(domainElement instanceof org.eclipse.uml2.uml.Interface) {
				return BlockDefinitionDiagramElementTypes.INTERFACE.getSemanticHint();
			}

			if(domainElement instanceof org.eclipse.uml2.uml.Model) {
				return BlockDefinitionDiagramElementTypes.MODEL.getSemanticHint();
			}

			if(domainElement instanceof org.eclipse.uml2.uml.Enumeration) {
				return BlockDefinitionDiagramElementTypes.ENUMERATION.getSemanticHint();
			}

			if(domainElement instanceof org.eclipse.uml2.uml.Package) {
				return BlockDefinitionDiagramElementTypes.PACKAGE.getSemanticHint();
			}

			if(domainElement instanceof org.eclipse.uml2.uml.Class) {
				return BlockDefinitionDiagramElementTypes.CLASS.getSemanticHint();
			}

			if(domainElement instanceof org.eclipse.uml2.uml.PrimitiveType) {
				return BlockDefinitionDiagramElementTypes.PRIMITIVE_TYPE.getSemanticHint();
			}

			if(domainElement instanceof org.eclipse.uml2.uml.DataType) {
				return BlockDefinitionDiagramElementTypes.DATA_TYPE.getSemanticHint();
			}

			if(domainElement instanceof org.eclipse.uml2.uml.Constraint) {
				return BlockDefinitionDiagramElementTypes.CONSTRAINT.getSemanticHint();
			}

			if(domainElement instanceof org.eclipse.uml2.uml.Comment) {
				return BlockDefinitionDiagramElementTypes.COMMENT.getSemanticHint();
			}





		};





		if(BlockDefinitionDiagramElementTypes.INTERFACE.getSemanticHint().equals(containerVisualID)) {

		};
		if(BlockDefinitionDiagramElementTypes.INTERFACE_COMPARTMENT_ATTRIBUTE_HINT.equals(containerVisualID)) {
			if(domainElement instanceof org.eclipse.uml2.uml.Property) {
				return BlockDefinitionDiagramElementTypes.INTERFACE_PROPERTY_CLN.getSemanticHint();
			}
		};

		if(BlockDefinitionDiagramElementTypes.INTERFACE_COMPARTMENT_OPERATION_HINT.equals(containerVisualID)) {
			if(domainElement instanceof org.eclipse.uml2.uml.Operation) {
				return BlockDefinitionDiagramElementTypes.INTERFACE_OPERATION_CLN.getSemanticHint();
			}
		};

		if(BlockDefinitionDiagramElementTypes.INTERFACE_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerVisualID)) {
			if(domainElement instanceof org.eclipse.uml2.uml.Class) {
				return BlockDefinitionDiagramElementTypes.INTERFACE_CLASS_CLN.getSemanticHint();
			}
		};


		if(BlockDefinitionDiagramElementTypes.MODEL.getSemanticHint().equals(containerVisualID)) {


		};



		if(BlockDefinitionDiagramElementTypes.PACKAGE.getSemanticHint().equals(containerVisualID)) {


		};


		if(BlockDefinitionDiagramElementTypes.CLASS.getSemanticHint().equals(containerVisualID)) {

		};
		if(BlockDefinitionDiagramElementTypes.CLASS_COMPARTMENT_ATTRIBUTE_HINT.equals(containerVisualID)) {
			if(domainElement instanceof org.eclipse.uml2.uml.Property) {
				return BlockDefinitionDiagramElementTypes.CLASS_PROPERTY_CLN.getSemanticHint();
			}
		};

		if(BlockDefinitionDiagramElementTypes.CLASS_COMPARTMENT_OPERATION_HINT.equals(containerVisualID)) {
			if(domainElement instanceof org.eclipse.uml2.uml.Reception) {
				return BlockDefinitionDiagramElementTypes.CLASS_RECEPTION_CLN.getSemanticHint();
			}
			if(domainElement instanceof org.eclipse.uml2.uml.Operation) {
				return BlockDefinitionDiagramElementTypes.CLASS_OPERATION_CLN.getSemanticHint();
			}
		};

		if(BlockDefinitionDiagramElementTypes.CLASS_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerVisualID)) {
			if(domainElement instanceof org.eclipse.uml2.uml.Class) {
				return BlockDefinitionDiagramElementTypes.CLASS_CLASS_CLN.getSemanticHint();
			}
		};



		if(BlockDefinitionDiagramElementTypes.DATA_TYPE.getSemanticHint().equals(containerVisualID)) {

		};
		if(BlockDefinitionDiagramElementTypes.DATA_TYPE_COMPARTMENT_ATTRIBUTE_HINT.equals(containerVisualID)) {
			if(domainElement instanceof org.eclipse.uml2.uml.Property) {
				return BlockDefinitionDiagramElementTypes.DATA_TYPE_PROPERTY_CLN.getSemanticHint();
			}
		};

		if(BlockDefinitionDiagramElementTypes.DATA_TYPE_COMPARTMENT_OPERATION_HINT.equals(containerVisualID)) {
			if(domainElement instanceof org.eclipse.uml2.uml.Operation) {
				return BlockDefinitionDiagramElementTypes.DATA_TYPE_OPERATION_CLN.getSemanticHint();
			}
		};





		if(BlockDefinitionDiagramElementTypes.INTERFACE_CN.getSemanticHint().equals(containerVisualID)) {

		};
		if(BlockDefinitionDiagramElementTypes.INTERFACE_CN_COMPARTMENT_ATTRIBUTE_HINT.equals(containerVisualID)) {
			if(domainElement instanceof org.eclipse.uml2.uml.Property) {
				return BlockDefinitionDiagramElementTypes.INTERFACE_PROPERTY_CLN.getSemanticHint();
			}
		};

		if(BlockDefinitionDiagramElementTypes.INTERFACE_CN_COMPARTMENT_OPERATION_HINT.equals(containerVisualID)) {
			if(domainElement instanceof org.eclipse.uml2.uml.Operation) {
				return BlockDefinitionDiagramElementTypes.INTERFACE_OPERATION_CLN.getSemanticHint();
			}
		};

		if(BlockDefinitionDiagramElementTypes.INTERFACE_CN_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerVisualID)) {
			if(domainElement instanceof org.eclipse.uml2.uml.Class) {
				return BlockDefinitionDiagramElementTypes.INTERFACE_CLASS_CLN.getSemanticHint();
			}
		};


		if(BlockDefinitionDiagramElementTypes.MODEL_CN.getSemanticHint().equals(containerVisualID)) {


		};




		if(BlockDefinitionDiagramElementTypes.PACKAGE_CN.getSemanticHint().equals(containerVisualID)) {


		};


		if(BlockDefinitionDiagramElementTypes.CLASS_CN.getSemanticHint().equals(containerVisualID)) {

		};
		if(BlockDefinitionDiagramElementTypes.CLASS_CN_COMPARTMENT_ATTRIBUTE_HINT.equals(containerVisualID)) {
			if(domainElement instanceof org.eclipse.uml2.uml.Property) {
				return BlockDefinitionDiagramElementTypes.CLASS_PROPERTY_CLN.getSemanticHint();
			}
		};

		if(BlockDefinitionDiagramElementTypes.CLASS_CN_COMPARTMENT_OPERATION_HINT.equals(containerVisualID)) {
			if(domainElement instanceof org.eclipse.uml2.uml.Reception) {
				return BlockDefinitionDiagramElementTypes.CLASS_RECEPTION_CLN.getSemanticHint();
			}
			if(domainElement instanceof org.eclipse.uml2.uml.Operation) {
				return BlockDefinitionDiagramElementTypes.CLASS_OPERATION_CLN.getSemanticHint();
			}
		};

		if(BlockDefinitionDiagramElementTypes.CLASS_CN_COMPARTMENT_NESTED_CLASSIFIER_HINT.equals(containerVisualID)) {
			if(domainElement instanceof org.eclipse.uml2.uml.Class) {
				return BlockDefinitionDiagramElementTypes.CLASS_CLASS_CLN.getSemanticHint();
			}
		};





		if(BlockDefinitionDiagramElementTypes.DATA_TYPE_CN.getSemanticHint().equals(containerVisualID)) {

		};
		if(BlockDefinitionDiagramElementTypes.DATA_TYPE_CN_COMPARTMENT_ATTRIBUTE_HINT.equals(containerVisualID)) {
			if(domainElement instanceof org.eclipse.uml2.uml.Property) {
				return BlockDefinitionDiagramElementTypes.DATA_TYPE_PROPERTY_CLN.getSemanticHint();
			}
		};

		if(BlockDefinitionDiagramElementTypes.DATA_TYPE_CN_COMPARTMENT_OPERATION_HINT.equals(containerVisualID)) {
			if(domainElement instanceof org.eclipse.uml2.uml.Operation) {
				return BlockDefinitionDiagramElementTypes.DATA_TYPE_OPERATION_CLN.getSemanticHint();
			}
		};





		return null;
	}

	/**
	 * @generated
	 */
	public static String getModelID(org.eclipse.gmf.runtime.notation.View view) {
		org.eclipse.gmf.runtime.notation.View diagram = view.getDiagram();
		while(view != diagram) {
			org.eclipse.emf.ecore.EAnnotation annotation = view.getEAnnotation("Shortcut");
			if(annotation != null) {
				return (String)annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (org.eclipse.gmf.runtime.notation.View)view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static String getVisualID(View view) {
		if(view instanceof Diagram) {
			if(org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockDefinitionDiagramEditPart.DIAGRAM_ID.equals(view.getType())) {
				return org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockDefinitionDiagramEditPart.DIAGRAM_ID;
			} else {
				return null;
			}
		}
		return view.getType();
	}
}
