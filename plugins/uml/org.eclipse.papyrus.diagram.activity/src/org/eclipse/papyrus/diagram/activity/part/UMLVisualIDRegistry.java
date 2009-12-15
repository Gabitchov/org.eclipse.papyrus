/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityContentCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityParametersCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityPostConditionsCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityPreConditionsCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityDiagramEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityIsSingleExecutionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.Constraint2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.FlowFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InitialNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ParameterEditPart;
import org.eclipse.papyrus.diagram.common.providers.BaseViewInfo;
import org.eclipse.papyrus.diagram.common.providers.ViewInfo;
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
	private static final String DEBUG_KEY = "org.eclipse.papyrus.diagram.activity/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if(view instanceof Diagram) {
			if(ActivityDiagramEditPart.MODEL_ID.equals(view.getType())) {
				return ActivityDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry.getVisualID(view.getType());
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
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if(domainElement == null) {
			return -1;
		}
		if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass()) && isDiagram((Package)domainElement)) {
			return ActivityDiagramEditPart.VISUAL_ID;
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
		String containerModelID = org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry.getModelID(containerView);
		if(!ActivityDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if(ActivityDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if(containerView instanceof Diagram) {
				containerVisualID = ActivityDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch(containerVisualID) {
		case ActivityActivityParametersCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getParameter().isSuperTypeOf(domainElement.eClass())

			) {
				return ParameterEditPart.VISUAL_ID;
			}
			break;
		case ActivityActivityPreConditionsCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return ConstraintEditPart.VISUAL_ID;
			}
			break;
		case ActivityActivityPostConditionsCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getConstraint().isSuperTypeOf(domainElement.eClass())

			) {
				return Constraint2EditPart.VISUAL_ID;
			}
			break;
		case ActivityActivityContentCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getInitialNode().isSuperTypeOf(domainElement.eClass())

			) {
				return InitialNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getActivityFinalNode().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityFinalNodeEditPart.VISUAL_ID;
			}
			if(UMLPackage.eINSTANCE.getFlowFinalNode().isSuperTypeOf(domainElement.eClass())

			) {
				return FlowFinalNodeEditPart.VISUAL_ID;
			}
			break;
		case ActivityDiagramEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getActivity().isSuperTypeOf(domainElement.eClass())

			) {
				return ActivityEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry.getModelID(containerView);
		if(!ActivityDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if(ActivityDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if(containerView instanceof Diagram) {
				containerVisualID = ActivityDiagramEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch(containerVisualID) {
		case ActivityEditPart.VISUAL_ID:
			if(ActivityNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityIsSingleExecutionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityActivityParametersCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityActivityPreConditionsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityActivityPostConditionsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityActivityContentCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityActivityParametersCompartmentEditPart.VISUAL_ID:
			if(ParameterEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityActivityPreConditionsCompartmentEditPart.VISUAL_ID:
			if(ConstraintEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityActivityPostConditionsCompartmentEditPart.VISUAL_ID:
			if(Constraint2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityActivityContentCompartmentEditPart.VISUAL_ID:
			if(InitialNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(ActivityFinalNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(FlowFinalNodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityDiagramEditPart.VISUAL_ID:
			if(ActivityEditPart.VISUAL_ID == nodeVisualID) {
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

		viewInfo = new BaseViewInfo(2001, ViewInfo.Node, "Activity");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(3001, ViewInfo.Node, "Parameter");

		root.addNode(7001, viewInfo);


		viewInfo = new BaseViewInfo(3002, ViewInfo.Node, "Constraint");

		root.addNode(7002, viewInfo);


		viewInfo = new BaseViewInfo(3003, ViewInfo.Node, "Constraint");

		root.addNode(7003, viewInfo);


		viewInfo = new BaseViewInfo(3004, ViewInfo.Node, "InitialNode");

		root.addNode(7004, viewInfo);


		viewInfo = new BaseViewInfo(3005, ViewInfo.Node, "ActivityFinalNode");

		root.addNode(7004, viewInfo);


		viewInfo = new BaseViewInfo(3006, ViewInfo.Node, "FlowFinalNode");

		root.addNode(7004, viewInfo);

		return root;
	}

}
