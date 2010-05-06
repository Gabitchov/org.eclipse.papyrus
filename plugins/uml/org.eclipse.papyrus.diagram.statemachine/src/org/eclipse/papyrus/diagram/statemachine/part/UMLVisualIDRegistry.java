package org.eclipse.papyrus.diagram.statemachine.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.providers.BaseViewInfo;
import org.eclipse.papyrus.diagram.common.providers.ViewInfo;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.FinalStateNameLabelEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.FinalStateNodeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudoStateNodeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudoStateNodeLabelEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudoStateNodeStereotypeLabelEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionCompartmentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineCompartmentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateNameLabelEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateNodeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionEditPartEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionGuardLabelEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionNameLabelEditPart;
import org.eclipse.uml2.uml.Package;
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
	private static final String DEBUG_KEY = "org.eclipse.papyrus.diagram.statemachine/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (PackageEditPart.MODEL_ID.equals(view.getType())) {
				return PackageEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry
				.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
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
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				UMLDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((Package) domainElement)) {
			return PackageEditPart.VISUAL_ID;
		}

		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry
				.getModelID(containerView);
		if (!PackageEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (PackageEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = PackageEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case PackageEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(
					domainElement.eClass())

			) {
				return StateMachineEditPart.VISUAL_ID;
			}
			break;
		case RegionCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())

			) {
				return PseudoStateNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getFinalState().isSuperTypeOf(
					domainElement.eClass())

			) {
				return FinalStateNodeEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())

			) {
				return StateNodeEditPart.VISUAL_ID;
			}
			break;
		case StateMachineCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRegion().isSuperTypeOf(
					domainElement.eClass())

			) {
				return RegionEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry
				.getModelID(containerView);
		if (!PackageEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (PackageEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = PackageEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case PackageEditPart.VISUAL_ID:
			if (StateMachineEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateMachineEditPart.VISUAL_ID:
			if (StateMachineNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StateMachineCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RegionEditPart.VISUAL_ID:
			if (RegionCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PseudoStateNodeEditPart.VISUAL_ID:
			if (PseudoStateNodeLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudoStateNodeStereotypeLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FinalStateNodeEditPart.VISUAL_ID:
			if (FinalStateNameLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateNodeEditPart.VISUAL_ID:
			if (StateNameLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RegionCompartmentEditPart.VISUAL_ID:
			if (PseudoStateNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FinalStateNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StateNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateMachineCompartmentEditPart.VISUAL_ID:
			if (RegionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TransitionEditPartEditPart.VISUAL_ID:
			if (TransitionNameLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransitionGuardLabelEditPart.VISUAL_ID == nodeVisualID) {
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
		if (domainElement == null) {
			return -1;
		}
		if (UMLPackage.eINSTANCE.getTransition().isSuperTypeOf(
				domainElement.eClass())

		) {
			return TransitionEditPartEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Package element) {
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
		if (diagramViewInfo == null) {
			diagramViewInfo = getPackage_1000ViewInfo();
		}
		return diagramViewInfo;
	}

	/**
	 * @generated
	 */
	protected static ViewInfo getPackage_1000ViewInfo() {
		ViewInfo root = new BaseViewInfo(1000, ViewInfo.Head, "", null, null);
		ViewInfo viewInfo = null;
		ViewInfo labelInfo = null;

		viewInfo = new BaseViewInfo(2000, ViewInfo.Node, "StateMachine");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(5000, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(6000, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		labelInfo = new BaseViewInfo(6001, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(3000, ViewInfo.Node, "Region");

		root.addNode(2002, viewInfo);

		viewInfo = new BaseViewInfo(3004, ViewInfo.Node, "Pseudostate");

		root.addNode(3002, viewInfo);

		viewInfo = new BaseViewInfo(3005, ViewInfo.Node, "FinalState");

		root.addNode(3002, viewInfo);

		viewInfo = new BaseViewInfo(3006, ViewInfo.Node, "State");

		root.addNode(3002, viewInfo);

		return root;
	}

}
