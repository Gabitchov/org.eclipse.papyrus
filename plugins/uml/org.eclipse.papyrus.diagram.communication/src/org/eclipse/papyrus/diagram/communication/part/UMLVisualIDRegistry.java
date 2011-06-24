/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib saadia.dhouib@cea.fr  
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.communication.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.providers.BaseViewInfo;
import org.eclipse.papyrus.diagram.common.providers.ViewInfo;
import org.eclipse.papyrus.diagram.communication.edit.parts.AppliedStereotypeMessageEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.CommentBodyEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.ConstraintBodyEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.ConstraintEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.ConstraintNameEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.DiagramNameEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.DurationObservationEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.DurationObservationLabelEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.DurationObservationStereotypeLabelEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.InteractionCompartmentEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.InteractionNameEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.LifelineEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.LifelineNameEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.MessageEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.MessageNameEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.ModelEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.ShortCutDiagramEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.TimeObservationEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.TimeObservationNameEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.TimeObservationStereotypeLabelEditPartCN;
import org.eclipse.papyrus.diagram.communication.expressions.UMLOCLFactory;
import org.eclipse.uml2.uml.Message;
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
	private static final String DEBUG_KEY = "org.eclipse.papyrus.diagram.communication/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if(view instanceof Diagram) {
			if(ModelEditPart.MODEL_ID.equals(view.getType())) {
				return ModelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.papyrus.diagram.communication.part.UMLVisualIDRegistry.getVisualID(view.getType());
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
		if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass()) && isDiagram((Package)domainElement)) {
			return ModelEditPart.VISUAL_ID;
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
		String containerModelID = org.eclipse.papyrus.diagram.communication.part.UMLVisualIDRegistry.getModelID(containerView);
		if(!ModelEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if(ModelEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.communication.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if(containerView instanceof Diagram) {
				containerVisualID = ModelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch(containerVisualID) {
		case ModelEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInteraction().isSuperTypeOf(domainElement.eClass())

			) {
				return InteractionEditPart.VISUAL_ID;
			}
			if(NotationPackage.eINSTANCE.getDiagram().isSuperTypeOf(domainElement.eClass())

			) {
				return ShortCutDiagramEditPart.VISUAL_ID;
			}
			break;
		case InteractionCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getLifeline().isSuperTypeOf(domainElement.eClass())

			) {
				return LifelineEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getComment().isSuperTypeOf(domainElement.eClass())

			) {
				return CommentEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return ConstraintEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getTimeObservation().isSuperTypeOf(domainElement.eClass())

			) {
				return TimeObservationEditPartCN.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getDurationObservation().isSuperTypeOf(domainElement.eClass())

			) {
				return DurationObservationEditPartCN.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.papyrus.diagram.communication.part.UMLVisualIDRegistry.getModelID(containerView);
		if(!ModelEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if(ModelEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.communication.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if(containerView instanceof Diagram) {
				containerVisualID = ModelEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch(containerVisualID) {
		case ModelEditPart.VISUAL_ID:
			if(InteractionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ShortCutDiagramEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InteractionEditPart.VISUAL_ID:
			if(InteractionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(InteractionCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ShortCutDiagramEditPart.VISUAL_ID:
			if(DiagramNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LifelineEditPartCN.VISUAL_ID:
			if(LifelineNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConstraintEditPartCN.VISUAL_ID:
			if(ConstraintNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintBodyEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case CommentEditPartCN.VISUAL_ID:
			if(CommentBodyEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TimeObservationEditPartCN.VISUAL_ID:
			if(TimeObservationNameEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TimeObservationStereotypeLabelEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DurationObservationEditPartCN.VISUAL_ID:
			if(DurationObservationLabelEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DurationObservationStereotypeLabelEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InteractionCompartmentEditPart.VISUAL_ID:
			if(LifelineEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(CommentEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ConstraintEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(TimeObservationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(DurationObservationEditPartCN.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MessageEditPart.VISUAL_ID:
			if(MessageNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(AppliedStereotypeMessageEditPart.VISUAL_ID == nodeVisualID) {
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
		if(UMLPackage.eINSTANCE.getMessage().isSuperTypeOf(domainElement.eClass())

		&& isMessage_8009((Message)domainElement)

		) {
			return MessageEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * "User can change implementation of this method to handle some specific\n""situations not covered by default logic.\n"
	 * @generated
	 */
	private static boolean isDiagram(Package element) {
		return true;
	}



	/**
	 * @generated
	 */
	private static boolean isMessage_8009(Message domainElement) {
		Object result = UMLOCLFactory.getExpression(5, UMLPackage.eINSTANCE.getMessage(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean)result).booleanValue();
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

		viewInfo = new BaseViewInfo(8002, ViewInfo.Node, "Interaction");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(8016, ViewInfo.Node, "Diagram");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(8009, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		labelInfo = new BaseViewInfo(6001, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		labelInfo = new BaseViewInfo(6012, ViewInfo.Label, "", null, viewInfo);
		viewInfo.getChildren().add(labelInfo);


		viewInfo = new BaseViewInfo(8010, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		viewInfo = new BaseViewInfo(8011, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		viewInfo = new BaseViewInfo(8012, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		viewInfo = new BaseViewInfo(8013, ViewInfo.Edge, "");
		root.addNode(1000, viewInfo);


		viewInfo = new BaseViewInfo(8001, ViewInfo.Node, "Lifeline");

		root.addNode(7001, viewInfo);


		viewInfo = new BaseViewInfo(8004, ViewInfo.Node, "Constraint");

		root.addNode(7001, viewInfo);


		viewInfo = new BaseViewInfo(8005, ViewInfo.Node, "Comment");

		root.addNode(7001, viewInfo);


		viewInfo = new BaseViewInfo(8006, ViewInfo.Node, "TimeObservation");

		root.addNode(7001, viewInfo);


		viewInfo = new BaseViewInfo(8007, ViewInfo.Node, "DurationObservation");

		root.addNode(7001, viewInfo);

		return root;
	}

}
