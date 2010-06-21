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

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.resource.Resource;
import org.eclipse.papyrus.sysml.blocks.Block;
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
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;

/**
 * @generated
 */
public class SysmlDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch(SysmlVisualIDRegistry.getVisualID(view)) {
		case BlockValueCompartmentEditPart.VISUAL_ID:
			return getBlockValueCompartment_7006SemanticChildren(view);
		case BlockPartCompartmentEditPart.VISUAL_ID:
			return getBlockPartCompartment_7004SemanticChildren(view);
		case BlockReferenceCompartmentEditPart.VISUAL_ID:
			return getBlockReferenceCompartment_7005SemanticChildren(view);
		case BlockAttributeCompartmentEditPart.VISUAL_ID:
			return getBlockAttributeCompartment_7001SemanticChildren(view);
		case BlockOperationCompartmentEditPart.VISUAL_ID:
			return getBlockOperationCompartment_7002SemanticChildren(view);
		case BlockConstraintCompartmentEditPart.VISUAL_ID:
			return getBlockConstraintCompartment_7003SemanticChildren(view);
		case ResourceEditPart.VISUAL_ID:
			return getResource_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	private static List getBlockConstraintCompartment_7003SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Block modelElement = (Block)containerView.getElement();
		List result = new LinkedList();



		for(Object element : modelElement.getBase_Class().getOwnedRules()) {
			Constraint childElement = (Constraint)element;
			int visualID = SysmlVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConstraintEditPart.VISUAL_ID) {
				result.add(new SysmlNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getBlockAttributeCompartment_7001SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Block modelElement = (Block)containerView.getElement();
		List result = new LinkedList();



		for(Object element : modelElement.getBase_Class().getOwnedAttributes()) {
			Property childElement = (Property)element;
			if(childElement.getType() == null) {
				int visualID = SysmlVisualIDRegistry.getNodeVisualID(view, childElement);
				if(visualID == PropertyEditPart.VISUAL_ID) {
					result.add(new SysmlNodeDescriptor(childElement, visualID));
					continue;
				}
			}
		}
		return result;
	}

	/**
	 * 
	 * @param view
	 * @return
	 */
	public static List getBlockPartCompartment_7004SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Block modelElement = (Block)containerView.getElement();
		List result = new LinkedList();



		for(Object element : modelElement.getBase_Class().getOwnedAttributes()) {
			Property childElement = (Property)element;
			if(childElement.getType() instanceof org.eclipse.uml2.uml.Class && childElement.isComposite()) {
				int visualID = SysmlVisualIDRegistry.getNodeVisualID(view, childElement);
				if(visualID == PropertyEditPart.VISUAL_ID) {
					result.add(new SysmlNodeDescriptor(childElement, visualID));
					continue;
				}
			}
		}
		return result;
	}

	/**
	 *
	 */
	public static List getBlockReferenceCompartment_7005SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Block modelElement = (Block)containerView.getElement();
		List result = new LinkedList();

		for(Object element : modelElement.getBase_Class().getOwnedAttributes()) {
			Property childElement = (Property)element;
			if(childElement.getType() instanceof org.eclipse.uml2.uml.Class && !childElement.isComposite()) {
				int visualID = SysmlVisualIDRegistry.getNodeVisualID(view, childElement);
				if(visualID == PropertyEditPart.VISUAL_ID) {
					result.add(new SysmlNodeDescriptor(childElement, visualID));
					continue;
				}
			}
		}
		return result;
	}

	/**
	 *
	 */
	public static List getBlockValueCompartment_7006SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Block modelElement = (Block)containerView.getElement();
		List result = new LinkedList();

		for(Object element : modelElement.getBase_Class().getOwnedAttributes()) {
			Property childElement = (Property)element;
			if(childElement.getType() instanceof org.eclipse.uml2.uml.DataType) {
				int visualID = SysmlVisualIDRegistry.getNodeVisualID(view, childElement);
				if(visualID == PropertyEditPart.VISUAL_ID) {
					result.add(new SysmlNodeDescriptor(childElement, visualID));
					continue;
				}
			}
		}
		return result;
	}



	/**
	 * @generated NOT
	 */
	public static List getBlockOperationCompartment_7002SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Block modelElement = (Block)containerView.getElement();
		List result = new LinkedList();
		for(Object element : modelElement.getBase_Class().getOwnedOperations()) {
			Operation childElement = (Operation)element;
			int visualID = SysmlVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == OperationEditPart.VISUAL_ID) {
				result.add(new SysmlNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	public static List getResource_1000SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Resource modelElement = (Resource)view.getElement();
		List result = new LinkedList();
		for(Object element : modelElement.getEobjects()) {
			EObject childElement = (EObject)element;
			int visualID = SysmlVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == BlockEditPart.VISUAL_ID) {
				result.add(new SysmlNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch(SysmlVisualIDRegistry.getVisualID(view)) {
		case ResourceEditPart.VISUAL_ID:
			return getResource_1000ContainedLinks(view);
		case BlockEditPart.VISUAL_ID:
			return getBlock_2001ContainedLinks(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3001ContainedLinks(view);
		case OperationEditPart.VISUAL_ID:
			return getOperation_3102ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch(SysmlVisualIDRegistry.getVisualID(view)) {
		case BlockEditPart.VISUAL_ID:
			return getBlock_2001IncomingLinks(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3001IncomingLinks(view);
		case OperationEditPart.VISUAL_ID:
			return getOperation_3102IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch(SysmlVisualIDRegistry.getVisualID(view)) {
		case BlockEditPart.VISUAL_ID:
			return getBlock_2001OutgoingLinks(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3001OutgoingLinks(view);
		case OperationEditPart.VISUAL_ID:
			return getOperation_3102OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getResource_1000ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBlock_2001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperation_3102ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBlock_2001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperation_3102IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBlock_2001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperation_3102OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

}
