package org.eclipse.papyrus.diagram.statemachine.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.providers.BaseViewInfo;
import org.eclipse.papyrus.diagram.common.providers.ViewInfo;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ConnectionPointReferenceEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ConnectionPointReferenceNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.ConnectionPointReferenceStereotypeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.FinalStateEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.FinalStateNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.FinalStateStereotypeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateChoiceEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateChoiceNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateChoiceStereotypeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateDeepHistoryEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateDeepHistoryNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateDeepHistoryStereotypeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateEntryPointEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateEntryPointNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateEntryPointStereotypeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateExitPointEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateExitPointNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateExitPointStereotypeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateForkEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateForkNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateForkStereotypeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateInitialEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateInitialNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateInitialStereotypeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateJoinEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateJoinNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateJoinStereotypeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateJunctionEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateJunctionNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateJunctionStereotypeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateShallowHistoryEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateShallowHistoryNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateShallowHistoryStereotypeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateTerminateEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateTerminateNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudostateTerminateStereotypeEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionCompartmentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateCompartmentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineCompartmentEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionGuardEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionNameEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.TransitionStereotypeEditPart;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented by
 * a domain model object.
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
	private static ViewInfo diagramViewInfo = null;

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
			if (PseudostateEntryPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateExitPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RegionEditPart.VISUAL_ID:
			if (RegionCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FinalStateEditPart.VISUAL_ID:
			if (FinalStateNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FinalStateStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateEditPart.VISUAL_ID:
			if (StateNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StateCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RegionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateEntryPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateExitPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConnectionPointReferenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PseudostateInitialEditPart.VISUAL_ID:
			if (PseudostateInitialNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateInitialStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PseudostateJoinEditPart.VISUAL_ID:
			if (PseudostateJoinNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateJoinStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PseudostateForkEditPart.VISUAL_ID:
			if (PseudostateForkNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateForkStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PseudostateChoiceEditPart.VISUAL_ID:
			if (PseudostateChoiceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateChoiceStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PseudostateJunctionEditPart.VISUAL_ID:
			if (PseudostateJunctionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateJunctionStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PseudostateShallowHistoryEditPart.VISUAL_ID:
			if (PseudostateShallowHistoryNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateShallowHistoryStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PseudostateDeepHistoryEditPart.VISUAL_ID:
			if (PseudostateDeepHistoryNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateDeepHistoryStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PseudostateTerminateEditPart.VISUAL_ID:
			if (PseudostateTerminateNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateTerminateStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PseudostateEntryPointEditPart.VISUAL_ID:
			if (PseudostateEntryPointNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateEntryPointStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PseudostateExitPointEditPart.VISUAL_ID:
			if (PseudostateExitPointNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateExitPointStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConnectionPointReferenceEditPart.VISUAL_ID:
			if (ConnectionPointReferenceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConnectionPointReferenceStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RegionCompartmentEditPart.VISUAL_ID:
			if (PseudostateInitialEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateJoinEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateForkEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateChoiceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateJunctionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateShallowHistoryEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateDeepHistoryEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateTerminateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FinalStateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateEntryPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateExitPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateMachineCompartmentEditPart.VISUAL_ID:
			if (RegionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateEntryPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateExitPointEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateCompartmentEditPart.VISUAL_ID:
			if (RegionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConnectionPointReferenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TransitionEditPart.VISUAL_ID:
			if (TransitionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransitionGuardEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransitionStereotypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

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
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (UMLPackage.eINSTANCE.getTransition().isSuperTypeOf(
				domainElement.eClass())

		) {
			return TransitionEditPart.VISUAL_ID;
		}
		return -1;
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
		case StateMachineEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_16000(containerView,
							(Pseudostate) domainElement)) {
				return PseudostateEntryPointEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_17000(containerView,
							(Pseudostate) domainElement)) {
				return PseudostateExitPointEditPart.VISUAL_ID;
			}
			break;
		case StateEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRegion().isSuperTypeOf(
					domainElement.eClass())

			) {
				return RegionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_16000(containerView,
							(Pseudostate) domainElement)) {
				return PseudostateEntryPointEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_17000(containerView,
							(Pseudostate) domainElement)) {
				return PseudostateExitPointEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getConnectionPointReference()
					.isSuperTypeOf(domainElement.eClass())

			) {
				return ConnectionPointReferenceEditPart.VISUAL_ID;
			}
			break;
		case RegionCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_8000(containerView,
							(Pseudostate) domainElement)) {
				return PseudostateInitialEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_9000(containerView,
							(Pseudostate) domainElement)) {
				return PseudostateJoinEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_10000(containerView,
							(Pseudostate) domainElement)) {
				return PseudostateForkEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_11000(containerView,
							(Pseudostate) domainElement)) {
				return PseudostateChoiceEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_12000(containerView,
							(Pseudostate) domainElement)) {
				return PseudostateJunctionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_13000(containerView,
							(Pseudostate) domainElement)) {
				return PseudostateShallowHistoryEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_14000(containerView,
							(Pseudostate) domainElement)) {
				return PseudostateDeepHistoryEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_15000(containerView,
							(Pseudostate) domainElement)) {
				return PseudostateTerminateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getFinalState().isSuperTypeOf(
					domainElement.eClass())

			) {
				return FinalStateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())

			) {
				return StateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_16000(containerView,
							(Pseudostate) domainElement)) {
				return PseudostateEntryPointEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_17000(containerView,
							(Pseudostate) domainElement)) {
				return PseudostateExitPointEditPart.VISUAL_ID;
			}
			break;
		case StateMachineCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRegion().isSuperTypeOf(
					domainElement.eClass())

			) {
				return RegionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_16000(containerView,
							(Pseudostate) domainElement)) {
				return PseudostateEntryPointEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())
					&& isPseudostate_17000(containerView,
							(Pseudostate) domainElement)) {
				return PseudostateExitPointEditPart.VISUAL_ID;
			}
			break;
		case StateCompartmentEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRegion().isSuperTypeOf(
					domainElement.eClass())

			) {
				return RegionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getConnectionPointReference()
					.isSuperTypeOf(domainElement.eClass())

			) {
				return ConnectionPointReferenceEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
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

		viewInfo = new BaseViewInfo(7000, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);

		labelInfo = new BaseViewInfo(7001, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		labelInfo = new BaseViewInfo(7002, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		labelInfo = new BaseViewInfo(7003, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);

		viewInfo = new BaseViewInfo(3000, ViewInfo.Node, "Region");

		root.addNode(2002, viewInfo);

		root.addNode(6002, viewInfo);

		root.addNode(6000, viewInfo);

		viewInfo = new BaseViewInfo(5000, ViewInfo.Node, "FinalState");

		root.addNode(3002, viewInfo);

		viewInfo = new BaseViewInfo(6000, ViewInfo.Node, "State");

		root.addNode(3002, viewInfo);

		viewInfo = new BaseViewInfo(8000, ViewInfo.Node, "Pseudostate");

		root.addNode(3002, viewInfo);

		viewInfo = new BaseViewInfo(9000, ViewInfo.Node, "Pseudostate");

		root.addNode(3002, viewInfo);

		viewInfo = new BaseViewInfo(10000, ViewInfo.Node, "Pseudostate");

		root.addNode(3002, viewInfo);

		viewInfo = new BaseViewInfo(11000, ViewInfo.Node, "Pseudostate");

		root.addNode(3002, viewInfo);

		viewInfo = new BaseViewInfo(12000, ViewInfo.Node, "Pseudostate");

		root.addNode(3002, viewInfo);

		viewInfo = new BaseViewInfo(13000, ViewInfo.Node, "Pseudostate");

		root.addNode(3002, viewInfo);

		viewInfo = new BaseViewInfo(14000, ViewInfo.Node, "Pseudostate");

		root.addNode(3002, viewInfo);

		viewInfo = new BaseViewInfo(15000, ViewInfo.Node, "Pseudostate");

		root.addNode(3002, viewInfo);

		viewInfo = new BaseViewInfo(16000, ViewInfo.Node, "Pseudostate");

		root.addNode(2000, viewInfo);

		root.addNode(3002, viewInfo);

		root.addNode(2002, viewInfo);

		root.addNode(6000, viewInfo);

		viewInfo = new BaseViewInfo(17000, ViewInfo.Node, "Pseudostate");

		root.addNode(3002, viewInfo);

		root.addNode(2002, viewInfo);

		root.addNode(2000, viewInfo);

		root.addNode(6000, viewInfo);

		viewInfo = new BaseViewInfo(18000, ViewInfo.Node,
				"ConnectionPointReference");

		root.addNode(6000, viewInfo);

		root.addNode(6002, viewInfo);

		return root;
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

	private static boolean isPseudostate_10000(View containerView,
			Pseudostate domainElement) {

		// Test if the pseudostate is a fork
		if (domainElement instanceof Pseudostate) {
			PseudostateKind kind = ((Pseudostate) domainElement).getKind();
			if (kind.equals(PseudostateKind.FORK_LITERAL))
				return true;
		}
		return false;
	}

	/**
	 * @generated
	 */

	private static boolean isPseudostate_11000(View containerView,
			Pseudostate domainElement) {

		// Test if the pseudostate is a choice
		if (domainElement instanceof Pseudostate) {
			PseudostateKind kind = ((Pseudostate) domainElement).getKind();
			if (kind.equals(PseudostateKind.CHOICE_LITERAL))
				return true;
		}
		return false;
	}

	/**
	 * @generated
	 */

	private static boolean isPseudostate_12000(View containerView,
			Pseudostate domainElement) {

		// Test if the pseudostate is a junction
		if (domainElement instanceof Pseudostate) {
			PseudostateKind kind = ((Pseudostate) domainElement).getKind();
			if (kind.equals(PseudostateKind.JUNCTION_LITERAL))
				return true;
		}
		return false;
	}

	/**
	 * @generated
	 */

	private static boolean isPseudostate_13000(View containerView,
			Pseudostate domainElement) {

		// Test if the pseudostate is a shallowHistory
		if (domainElement instanceof Pseudostate) {
			PseudostateKind kind = ((Pseudostate) domainElement).getKind();
			if (kind.equals(PseudostateKind.SHALLOW_HISTORY_LITERAL))
				return true;
		}
		return false;
	}

	/**
	 * @generated
	 */

	private static boolean isPseudostate_14000(View containerView,
			Pseudostate domainElement) {

		// Test if the pseudostate is a deepHistory
		if (domainElement instanceof Pseudostate) {
			PseudostateKind kind = ((Pseudostate) domainElement).getKind();
			if (kind.equals(PseudostateKind.DEEP_HISTORY_LITERAL))
				return true;
		}
		return false;
	}

	/**
	 * @generated
	 */

	private static boolean isPseudostate_15000(View containerView,
			Pseudostate domainElement) {

		// Test if the pseudostate is a terminate
		if (domainElement instanceof Pseudostate) {
			PseudostateKind kind = ((Pseudostate) domainElement).getKind();
			if (kind.equals(PseudostateKind.TERMINATE_LITERAL))
				return true;
		}
		return false;
	}

	/**
	 * @generated
	 */

	private static boolean isPseudostate_16000(View containerView,
			Pseudostate domainElement) {

		// Test if the pseudostate is an entryPoint
		if (domainElement instanceof Pseudostate) {
			PseudostateKind kind = ((Pseudostate) domainElement).getKind();
			if (kind.equals(PseudostateKind.ENTRY_POINT_LITERAL))
				return true;
		}
		return false;
	}

	/**
	 * @generated
	 */

	private static boolean isPseudostate_17000(View containerView,
			Pseudostate domainElement) {

		// Test if the pseudostate is an exitPoint
		if (domainElement instanceof Pseudostate) {
			PseudostateKind kind = ((Pseudostate) domainElement).getKind();
			if (kind.equals(PseudostateKind.EXIT_POINT_LITERAL))
				return true;
		}
		return false;
	}

	/**
	 * @generated
	 */

	private static boolean isPseudostate_8000(View containerView,
			Pseudostate domainElement) {

		// Test if the pseudostate is an initial
		if (domainElement instanceof Pseudostate) {
			PseudostateKind kind = ((Pseudostate) domainElement).getKind();
			if (kind.equals(PseudostateKind.INITIAL_LITERAL))
				return true;
		}
		return false;
	}

	/**
	 * @generated
	 */

	private static boolean isPseudostate_9000(View containerView,
			Pseudostate domainElement) {

		// Test if the pseudostate is a join
		if (domainElement instanceof Pseudostate) {
			PseudostateKind kind = ((Pseudostate) domainElement).getKind();
			if (kind.equals(PseudostateKind.JOIN_LITERAL))
				return true;
		}
		return false;
	}

}
