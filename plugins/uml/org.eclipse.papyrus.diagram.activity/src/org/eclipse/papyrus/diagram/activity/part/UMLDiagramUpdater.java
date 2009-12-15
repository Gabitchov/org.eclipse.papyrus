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

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityContentCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityParametersCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityPostConditionsCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityPreConditionsCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityDiagramEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.Constraint2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.FlowFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InitialNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ParameterEditPart;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Parameter;

/**
 * @generated
 */
public class UMLDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case ActivityActivityParametersCompartmentEditPart.VISUAL_ID:
			return getActivityActivityParametersCompartment_7001SemanticChildren(view);
		case ActivityActivityPreConditionsCompartmentEditPart.VISUAL_ID:
			return getActivityActivityPreConditionsCompartment_7002SemanticChildren(view);
		case ActivityActivityPostConditionsCompartmentEditPart.VISUAL_ID:
			return getActivityActivityPostConditionsCompartment_7003SemanticChildren(view);
		case ActivityActivityContentCompartmentEditPart.VISUAL_ID:
			return getActivityActivityContentCompartment_7004SemanticChildren(view);
		case ActivityDiagramEditPart.VISUAL_ID:
			return getPackage_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActivityActivityParametersCompartment_7001SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Activity modelElement = (Activity)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getOwnedParameters().iterator(); it.hasNext();) {
			Parameter childElement = (Parameter)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ParameterEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivityActivityPreConditionsCompartment_7002SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Activity modelElement = (Activity)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getPreconditions().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ConstraintEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivityActivityPostConditionsCompartment_7003SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Activity modelElement = (Activity)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getPostconditions().iterator(); it.hasNext();) {
			Constraint childElement = (Constraint)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == Constraint2EditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivityActivityContentCompartment_7004SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Activity modelElement = (Activity)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getNodes().iterator(); it.hasNext();) {
			ActivityNode childElement = (ActivityNode)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == InitialNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ActivityFinalNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == FlowFinalNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_1000SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package)view.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ActivityEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case ActivityDiagramEditPart.VISUAL_ID:
			return getPackage_1000ContainedLinks(view);
		case ActivityEditPart.VISUAL_ID:
			return getActivity_2001ContainedLinks(view);
		case ParameterEditPart.VISUAL_ID:
			return getParameter_3001ContainedLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_3002ContainedLinks(view);
		case Constraint2EditPart.VISUAL_ID:
			return getConstraint_3003ContainedLinks(view);
		case InitialNodeEditPart.VISUAL_ID:
			return getInitialNode_3004ContainedLinks(view);
		case ActivityFinalNodeEditPart.VISUAL_ID:
			return getActivityFinalNode_3005ContainedLinks(view);
		case FlowFinalNodeEditPart.VISUAL_ID:
			return getFlowFinalNode_3006ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case ActivityEditPart.VISUAL_ID:
			return getActivity_2001IncomingLinks(view);
		case ParameterEditPart.VISUAL_ID:
			return getParameter_3001IncomingLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_3002IncomingLinks(view);
		case Constraint2EditPart.VISUAL_ID:
			return getConstraint_3003IncomingLinks(view);
		case InitialNodeEditPart.VISUAL_ID:
			return getInitialNode_3004IncomingLinks(view);
		case ActivityFinalNodeEditPart.VISUAL_ID:
			return getActivityFinalNode_3005IncomingLinks(view);
		case FlowFinalNodeEditPart.VISUAL_ID:
			return getFlowFinalNode_3006IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case ActivityEditPart.VISUAL_ID:
			return getActivity_2001OutgoingLinks(view);
		case ParameterEditPart.VISUAL_ID:
			return getParameter_3001OutgoingLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_3002OutgoingLinks(view);
		case Constraint2EditPart.VISUAL_ID:
			return getConstraint_3003OutgoingLinks(view);
		case InitialNodeEditPart.VISUAL_ID:
			return getInitialNode_3004OutgoingLinks(view);
		case ActivityFinalNodeEditPart.VISUAL_ID:
			return getActivityFinalNode_3005OutgoingLinks(view);
		case FlowFinalNodeEditPart.VISUAL_ID:
			return getFlowFinalNode_3006OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackage_1000ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActivity_2001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getParameter_3001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInitialNode_3004ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActivityFinalNode_3005ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFlowFinalNode_3006ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActivity_2001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getParameter_3001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3003IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInitialNode_3004IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActivityFinalNode_3005IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFlowFinalNode_3006IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActivity_2001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getParameter_3001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_3003OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getInitialNode_3004OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActivityFinalNode_3005OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFlowFinalNode_3006OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

}
