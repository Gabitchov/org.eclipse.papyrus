/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
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
package org.eclipse.papyrus.sysml.diagram.blockdiagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.common.providers.BaseViewInfo;
import org.eclipse.papyrus.diagram.common.providers.ViewInfo;
import org.eclipse.papyrus.resource.Resource;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.part.BlockNameEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.parts.BlockAttributeCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.parts.BlockConstraintCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.parts.BlockEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.parts.BlockOperationCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.parts.BlockPartCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.parts.BlockReferenceCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.parts.BlockValueCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.parts.OperationEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.parts.PropertyEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.parts.ResourceEditPart;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class SysmlVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.eclipse.papyrus.sysml.diagram.blockdiagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if(view instanceof Diagram) {
			if(ResourceEditPart.MODEL_ID.equals(view.getType())) {
				return ResourceEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.papyrus.sysml.diagram.blockdiagram.part.SysmlVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while(view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if(annotation != null) {
				return annotation.getDetails().get("modelID"); //$NON-NLS-1$
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
				SysmlDiagramEditorPlugin.getInstance().logError("Unable to parse view type as a visualID number: " + type);
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
	 * The diagram is created under an UML Element
	 * 
	 * @generated NOT
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if(domainElement == null) {
			return -1;
		}
		if(UMLPackage.eINSTANCE.getPackage().isSuperTypeOf(domainElement.eClass())) {
			return ResourceEditPart.VISUAL_ID;
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
		String containerModelID = org.eclipse.papyrus.sysml.diagram.blockdiagram.part.SysmlVisualIDRegistry.getModelID(containerView);
		if(!ResourceEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if(ResourceEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.sysml.diagram.blockdiagram.part.SysmlVisualIDRegistry.getVisualID(containerView);
		} else {
			if(containerView instanceof Diagram) {
				containerVisualID = ResourceEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch(containerVisualID) {
		case BlockAttributeCompartmentEditPart.VISUAL_ID:
		case BlockReferenceCompartmentEditPart.VISUAL_ID:
		case BlockValueCompartmentEditPart.VISUAL_ID:
		case BlockPartCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getProperty().isSuperTypeOf(domainElement.eClass())

			) {
				return PropertyEditPart.VISUAL_ID;
			}
			break;
		case BlockOperationCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())

			) {
				return OperationEditPart.VISUAL_ID;
			}
			break;
		case BlockConstraintCompartmentEditPart.VISUAL_ID:
			if(UMLPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
				return ConstraintEditPart.VISUAL_ID;
			}
			break;
		case ResourceEditPart.VISUAL_ID:
			if(BlocksPackage.eINSTANCE.getBlock().isSuperTypeOf(domainElement.eClass())

			) {
				return BlockEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * 
	 * @generated NOT
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.papyrus.sysml.diagram.blockdiagram.part.SysmlVisualIDRegistry.getModelID(containerView);
		if(!ResourceEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if(ResourceEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.papyrus.sysml.diagram.blockdiagram.part.SysmlVisualIDRegistry.getVisualID(containerView);
		} else {
			if(containerView instanceof Diagram) {
				containerVisualID = ResourceEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch(containerVisualID) {
		case BlockEditPart.VISUAL_ID:
			if(BlockNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(BlockConstraintCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(BlockOperationCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(BlockAttributeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(BlockPartCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(BlockReferenceCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if(BlockValueCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BlockAttributeCompartmentEditPart.VISUAL_ID:
		case BlockPartCompartmentEditPart.VISUAL_ID:
		case BlockValueCompartmentEditPart.VISUAL_ID:
		case BlockReferenceCompartmentEditPart.VISUAL_ID:
			if(PropertyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BlockOperationCompartmentEditPart.VISUAL_ID:
			if(OperationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ResourceEditPart.VISUAL_ID:
			if(BlockEditPart.VISUAL_ID == nodeVisualID) {
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
	private static boolean isDiagram(Resource element) {
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
			diagramViewInfo = getResource_1000ViewInfo();
		}
		return diagramViewInfo;
	}

	/**
	 * @generated
	 */
	protected static ViewInfo getResource_1000ViewInfo() {
		ViewInfo root = new BaseViewInfo(1000, ViewInfo.Head, "", null, null);
		ViewInfo viewInfo = null;
		viewInfo = new BaseViewInfo(2001, ViewInfo.Node, "Block");
		root.addNode(1000, viewInfo);

		viewInfo = new BaseViewInfo(3001, ViewInfo.Node, "Property");

		root.addNode(7001, viewInfo);

		viewInfo = new BaseViewInfo(3102, ViewInfo.Node, "Operation");

		root.addNode(7002, viewInfo);

		return root;
	}

}
