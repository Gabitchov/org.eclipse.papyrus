package org.eclipse.papyrus.diagram.component.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.providers.BaseViewInfo;
import org.eclipse.papyrus.diagram.common.providers.ViewInfo;
import org.eclipse.papyrus.diagram.component.edit.parts.AbstractionAppliedStereotypeEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.AbstractionEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.AbstractionNameEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.CommentBodyEditPartPCN;
import org.eclipse.papyrus.diagram.component.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.CommentEditPartPCN;
import org.eclipse.papyrus.diagram.component.edit.parts.ComponentCompositeCompartmentEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.ComponentCompositeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.component.edit.parts.ComponentCompositeCompartmentEditPartPCN;
import org.eclipse.papyrus.diagram.component.edit.parts.ComponentDiagramEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.ComponentEditPartCN;
import org.eclipse.papyrus.diagram.component.edit.parts.ComponentEditPartPCN;
import org.eclipse.papyrus.diagram.component.edit.parts.ComponentNameEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.ComponentNameEditPartCN;
import org.eclipse.papyrus.diagram.component.edit.parts.ComponentNameEditPartPCN;
import org.eclipse.papyrus.diagram.component.edit.parts.ComponentRealizationAppliedStereotypeEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.ComponentRealizationEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.ComponentRealizationNameEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.ConstraintEditPartPCN;
import org.eclipse.papyrus.diagram.component.edit.parts.ConstraintNameEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.ConstraintNameEditPartPCN;
import org.eclipse.papyrus.diagram.component.edit.parts.ConstraintSpecificationEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.ConstraintSpecificationEditPartPCN;
import org.eclipse.papyrus.diagram.component.edit.parts.DependencyAppliedStereotypeEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.DependencyNameEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.GeneralizationAppliedStereotypeEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.InterfaceEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.InterfaceEditPartPCN;
import org.eclipse.papyrus.diagram.component.edit.parts.InterfaceNameEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.InterfaceNameEditPartPCN;
import org.eclipse.papyrus.diagram.component.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.ManifestationAppliedStereotypeEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.ManifestationEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.ManifestationNameEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.PackageNameEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.PortAppliedStereotypeEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.PortEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.PortNameEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.SubstitutionAppliedStereotypeEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.SubstitutionEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.SubstitutionNameEditPart;
import org.eclipse.papyrus.diagram.component.edit.parts.UsageEditPart;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class UMLVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.eclipse.papyrus.diagram.component/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if(view instanceof Diagram) {
			if(ComponentDiagramEditPart.MODEL_ID.equals(view.getType())) {
				return ComponentDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.papyrus.diagram.component.part.UMLVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while(view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if(annotation != null) {
				return (String)annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View)view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if(Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				UMLDiagramEditorPlugin.getInstance().logError("Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if(domainElement == null) {
			return -1;
		}
		if(UMLPackage.eINSTANCE.getModel().isSuperTypeOf(domainElement.eClass()) && isDiagram((Model)domainElement)) {
			return ComponentDiagramEditPart.VISUAL_ID;
		}

		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if(domainElement == null) {
			return -1;
		}
		String containerModelID = org.eclipse.papyrus.diagram.component.part.UMLVisualIDRegistry.getModelID(containerView);
		if(!ComponentDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if(ComponentDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.component.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if(containerView instanceof Diagram) {
				containerVisualID = ComponentDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch(containerVisualID) {
		case ComponentDiagramEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())

			) {
				return PackageEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return ConstraintEditPart.VISUAL_ID;
			}
			break;
		case ComponentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())

			) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case ComponentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())

			) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case ComponentEditPartPCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getPort().isSuperTypeOf(domainElement.eClass())

			) {
				return PortEditPart.VISUAL_ID;
			}
			break;
		case ComponentCompositeCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentEditPartCN.VISUAL_ID;
			}
			break;
		case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInterface().isSuperTypeOf(domainElement.eClass())

			) {
				return InterfaceEditPartPCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartPCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return ConstraintEditPartPCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentEditPartPCN.VISUAL_ID;
			}
			break;
		case ComponentCompositeCompartmentEditPartCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentEditPartCN.VISUAL_ID;
			}
			break;
		case ComponentCompositeCompartmentEditPartPCN.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getComponent().isSuperTypeOf(domainElement.eClass())

			) {
				return ComponentEditPartCN.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.papyrus.diagram.component.part.UMLVisualIDRegistry.getModelID(containerView);
		if(!ComponentDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if(ComponentDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.component.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if(containerView instanceof Diagram) {
				containerVisualID = ComponentDiagramEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch(containerVisualID) {
		case ComponentDiagramEditPart.VISUAL_ID:
			if(ComponentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InterfaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PackageEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentEditPart.VISUAL_ID:
			if(ComponentNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceEditPart.VISUAL_ID:
			if(InterfaceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackageEditPart.VISUAL_ID:
			if(PackageNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PackagePackageableElementCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CommentEditPart.VISUAL_ID:
			if(CommentBodyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConstraintEditPart.VISUAL_ID:
			if(ConstraintNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintSpecificationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PortEditPart.VISUAL_ID:
			if(PortNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentEditPartCN.VISUAL_ID:
			if(ComponentNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeCompartmentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentEditPartPCN.VISUAL_ID:
			if(ComponentNameEditPartPCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentCompositeCompartmentEditPartPCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(PortEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterfaceEditPartPCN.VISUAL_ID:
			if(InterfaceNameEditPartPCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CommentEditPartPCN.VISUAL_ID:
			if(CommentBodyEditPartPCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConstraintEditPartPCN.VISUAL_ID:
			if(ConstraintNameEditPartPCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintSpecificationEditPartPCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentCompositeCompartmentEditPart.VISUAL_ID:
			if(ComponentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			if(InterfaceEditPartPCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartPCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPartPCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentEditPartPCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentCompositeCompartmentEditPartCN.VISUAL_ID:
			if(ComponentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentCompositeCompartmentEditPartPCN.VISUAL_ID:
			if(ComponentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GeneralizationEditPart.VISUAL_ID:
			if(GeneralizationAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SubstitutionEditPart.VISUAL_ID:
			if(SubstitutionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(SubstitutionAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ManifestationEditPart.VISUAL_ID:
			if(ManifestationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ManifestationAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ComponentRealizationEditPart.VISUAL_ID:
			if(ComponentRealizationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ComponentRealizationAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AbstractionEditPart.VISUAL_ID:
			if(AbstractionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AbstractionAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DependencyEditPart.VISUAL_ID:
			if(DependencyNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DependencyAppliedStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if(domainElement == null) {
			return -1;
		}
		if(UMLPackage.eINSTANCE.getUsage().isSuperTypeOf(domainElement.eClass())



		) {
			return UsageEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getInterfaceRealization().isSuperTypeOf(domainElement.eClass())



		) {
			return InterfaceRealizationEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getGeneralization().isSuperTypeOf(domainElement.eClass())



		) {
			return GeneralizationEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getSubstitution().isSuperTypeOf(domainElement.eClass())



		) {
			return SubstitutionEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getManifestation().isSuperTypeOf(domainElement.eClass())



		) {
			return ManifestationEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getComponentRealization().isSuperTypeOf(domainElement.eClass())



		) {
			return ComponentRealizationEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getAbstraction().isSuperTypeOf(domainElement.eClass())



		) {
			return AbstractionEditPart.VISUAL_ID;
		}
		if(UMLPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass())



		) {
			return DependencyEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * "User can change implementation of this method to handle some specific\n""situations not covered by default logic.\n"
	 * @generated
	 */
	private static boolean isDiagram(Model element) {
		return true;
	}





	/**
	 * @generated
	 */
	private static ViewInfo diagramViewInfo = null;


	/**
	 * @generated
	 */
	public static ViewInfo getDiagramViewInfo() {
		if(diagramViewInfo == null) {
			diagramViewInfo = getModel_1000ViewInfo();
		}
		return diagramViewInfo;
	}



	/**
	 * @generated
	 */
	protected static ViewInfo getModel_1000ViewInfo() {
		ViewInfo root = new BaseViewInfo(1000, ViewInfo.Head, "", null, null);
		ViewInfo viewInfo = null;
		ViewInfo labelInfo = null;

		viewInfo = new BaseViewInfo(2002, ViewInfo.Node, "Component");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(2003, ViewInfo.Node, "Interface");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(3200, ViewInfo.Node, "Package");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(3201, ViewInfo.Node, "Comment");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(3199, ViewInfo.Node, "Constraint");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(4001, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		viewInfo = new BaseViewInfo(4006, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		viewInfo = new BaseViewInfo(4003, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(2, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(4012, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6006, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6020, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(4014, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6008, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6022, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(4007, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(3, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(4, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(4013, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6007, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6021, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(4016, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		viewInfo = new BaseViewInfo(4015, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		viewInfo = new BaseViewInfo(4009, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		viewInfo = new BaseViewInfo(4010, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6009, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6023, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(3069, ViewInfo.Node, "Port");

		root.addNode(2002, viewInfo);

		root.addNode(3070, viewInfo);

		root.addNode(3071, viewInfo);


		viewInfo = new BaseViewInfo(3070, ViewInfo.Node, "Component");

		root.addNode(7003, viewInfo);

		root.addNode(7004, viewInfo);

		root.addNode(7001, viewInfo);


		viewInfo = new BaseViewInfo(3071, ViewInfo.Node, "Component");

		root.addNode(7002, viewInfo);


		viewInfo = new BaseViewInfo(3072, ViewInfo.Node, "Interface");

		root.addNode(7002, viewInfo);


		viewInfo = new BaseViewInfo(3074, ViewInfo.Node, "Comment");

		root.addNode(7002, viewInfo);


		viewInfo = new BaseViewInfo(3075, ViewInfo.Node, "Constraint");

		root.addNode(7002, viewInfo);

		return root;
	}

}
