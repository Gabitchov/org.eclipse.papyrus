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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagramprofile.utils.StereotypeUtils;
import org.eclipse.papyrus.resource.util.ResourceUtil;
import org.eclipse.papyrus.sysml.constraints.ConstraintProperty;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.ConnectorEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.ConstraintPropertyEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.ParametricEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.Property2EditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.PropertyEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.providers.SysmlElementTypes;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class SysmlDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (SysmlVisualIDRegistry.getVisualID(view)) {
		case ConstraintPropertyEditPart.VISUAL_ID:
			return getConstraintProperty_2003SemanticChildren(view);
		case ParametricEditPart.VISUAL_ID:
			return getResource_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated NOT
	 */
	public static List getConstraintProperty_2003SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		ConstraintProperty modelElement = (ConstraintProperty) view.getElement();
		List result = new LinkedList();
		{
			Property childElement = modelElement.getBase_Property();
			int visualID = SysmlVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Property2EditPart.VISUAL_ID) {
				result.add(new SysmlNodeDescriptor(childElement, visualID));
			}
		}
		return result;
		/*
		 * if (!view.isSetElement()) { return Collections.EMPTY_LIST; } ConstraintProperty
		 * modelElement = (ConstraintProperty) view.getElement(); List result = new LinkedList();
		 * 
		 * Object oclRuleResult = OCLUtils.runOclRule("self.base_Property.type", modelElement); if
		 * (oclRuleResult != null) { if (oclRuleResult instanceof StructuredClassifier) {
		 * StructuredClassifier aClass = (StructuredClassifier) oclRuleResult; for (Iterator it =
		 * aClass.getAttributes().iterator(); it.hasNext();) { Property childElement = (Property)
		 * it.next(); int visualID = SysmlVisualIDRegistry.getNodeVisualID(view, childElement); if
		 * (visualID == Property2EditPart.VISUAL_ID) { result.add(new
		 * SysmlNodeDescriptor(childElement, visualID)); //continue; } } } else { throw new
		 * UnsupportedOperationException("Can't access with ..."); } }
		 */
	}

	/**
	 * @generated NOT
	 */
	public static List getResource_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		List result = new LinkedList();
		EObject eObject = view.getElement();
		// element is a block
		if (eObject instanceof Class) {
			Class modelElement = (Class) eObject;
			// we get the papyrus resource from the model object
			EList<EObject> eobjects = ResourceUtil.getResource(modelElement).getEobjects();
			for (Iterator it = eobjects.iterator(); it.hasNext();) {
				EObject childElement = (EObject) it.next();
				int visualID = SysmlVisualIDRegistry.getNodeVisualID(view, (EObject) childElement);
				if (visualID == ConstraintPropertyEditPart.VISUAL_ID) {
					result.add(new SysmlNodeDescriptor((EObject) childElement, visualID));
					continue;
				}
			}
			for (Iterator it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
				EObject obj = (EObject) it.next();
				if (obj instanceof Property) {
					Property childElement = (Property) obj;
					int visualID = SysmlVisualIDRegistry.getNodeVisualID(view, childElement);
					if (visualID == PropertyEditPart.VISUAL_ID
							&& !StereotypeUtils.isStereotypeApplied("SysML::Constraints::ConstraintProperty",
									childElement)) {
						result.add(new SysmlNodeDescriptor(childElement, visualID));
						continue;
					}
				}
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (SysmlVisualIDRegistry.getVisualID(view)) {
		case ParametricEditPart.VISUAL_ID:
			return getResource_1000ContainedLinks(view);
		case ConstraintPropertyEditPart.VISUAL_ID:
			return getConstraintProperty_2003ContainedLinks(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_2005ContainedLinks(view);
		case Property2EditPart.VISUAL_ID:
			return getProperty_3002ContainedLinks(view);
		case ConnectorEditPart.VISUAL_ID:
			return getConnector_4001ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (SysmlVisualIDRegistry.getVisualID(view)) {
		case ConstraintPropertyEditPart.VISUAL_ID:
			return getConstraintProperty_2003IncomingLinks(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_2005IncomingLinks(view);
		case Property2EditPart.VISUAL_ID:
			return getProperty_3002IncomingLinks(view);
		case ConnectorEditPart.VISUAL_ID:
			return getConnector_4001IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (SysmlVisualIDRegistry.getVisualID(view)) {
		case ConstraintPropertyEditPart.VISUAL_ID:
			return getConstraintProperty_2003OutgoingLinks(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_2005OutgoingLinks(view);
		case Property2EditPart.VISUAL_ID:
			return getProperty_3002OutgoingLinks(view);
		case ConnectorEditPart.VISUAL_ID:
			return getConnector_4001OutgoingLinks(view);
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
	public static List getConstraintProperty_2003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_2005ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConnector_4001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstraintProperty_2003IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_2005IncomingLinks(View view) {
		Property modelElement = (Property) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Connector_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3002IncomingLinks(View view) {
		Property modelElement = (Property) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Connector_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConnector_4001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getConstraintProperty_2003OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_2005OutgoingLinks(View view) {
		Property modelElement = (Property) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Connector_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3002OutgoingLinks(View view) {
		Property modelElement = (Property) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Connector_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConnector_4001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated NOT
	 */
	private static Collection getIncomingTypeModelFacetLinks_Connector_4001(ConnectableElement target,
			Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getConnectorEnd_Role()
					|| false == setting.getEObject() instanceof ConnectorEnd) {
				continue;
			}
			ConnectorEnd connectorEnd = (ConnectorEnd) setting.getEObject();
			Connector link = (Connector) connectorEnd.getOwner();
			if (ConnectorEditPart.VISUAL_ID != SysmlVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ConnectableElement src = null;
			EList<ConnectorEnd> ends = link.getEnds();
			if (ends != null && !ends.isEmpty()) {
				src = ends.get(0).getRole();
			}
			result.add(new SysmlLinkDescriptor(src, target, link, SysmlElementTypes.Connector_4001,
					ConnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Connector_4001(ConnectableElement source) {
		StructuredClassifier container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof StructuredClassifier) {
				container = (StructuredClassifier) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getOwnedConnectors().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Connector) {
				continue;
			}
			Connector link = (Connector) linkObject;
			if (ConnectorEditPart.VISUAL_ID != SysmlVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}

			ConnectableElement src = null;
			ConnectableElement dst = null;
			EList<ConnectorEnd> ends = link.getEnds();
			if (ends != null && !ends.isEmpty() && ends.size() > 1) {
				src = ends.get(0).getRole();
				dst = ends.get(1).getRole();
			}

			if (src != source) {
				continue;
			}
			result.add(new SysmlLinkDescriptor(src, dst, link, SysmlElementTypes.Connector_4001,
					ConnectorEditPart.VISUAL_ID));

		}
		return result;
	}

}
