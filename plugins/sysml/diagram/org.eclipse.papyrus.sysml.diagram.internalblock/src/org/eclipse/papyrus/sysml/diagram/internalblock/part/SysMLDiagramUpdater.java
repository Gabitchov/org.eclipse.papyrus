/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.eclipse.gmf.tooling.runtime.update.UpdaterLinkDescriptor;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.ConstraintEditPartCN;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLLinkDescriptor;
import org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * 
 * @author vl222926
 *         Adapted code from generated code for UML Diagram
 *         The name of the methods are not java compliant, but it is done to be consistent with the generated classes which use the id of the elements
 */
public class SysMLDiagramUpdater {

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {

		/**
		 * 
		 * @see org.eclipse.gmf.tooling.runtime.update.DiagramUpdater#getSemanticChildren(org.eclipse.gmf.runtime.notation.View)
		 * 
		 * @param view
		 * @return
		 */
		public List<UpdaterLinkDescriptor> getSemanticChildren(View view) {
			return SysMLDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * 
		 * @see org.eclipse.gmf.tooling.runtime.update.DiagramUpdater#getContainedLinks(org.eclipse.gmf.runtime.notation.View)
		 * 
		 * @param view
		 * @return
		 */
		public List<UpdaterLinkDescriptor> getContainedLinks(View view) {
			return SysMLDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * 
		 * @see org.eclipse.gmf.tooling.runtime.update.DiagramUpdater#getIncomingLinks(org.eclipse.gmf.runtime.notation.View)
		 * 
		 * @param view
		 * @return
		 */
		public List<UpdaterLinkDescriptor> getIncomingLinks(View view) {
			return SysMLDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * 
		 * @see org.eclipse.gmf.tooling.runtime.update.DiagramUpdater#getOutgoingLinks(org.eclipse.gmf.runtime.notation.View)
		 * 
		 * @param view
		 * @return
		 */
		public List<UpdaterLinkDescriptor> getOutgoingLinks(View view) {
			return SysMLDiagramUpdater.getOutgoingLinks(view);
		}
	};

	public static List<UpdaterLinkDescriptor> getContainedLinks(final View view) {
		throw new UnsupportedOperationException("Not yet implemented"); //$NON-NLS-1$
	}

	public static List<UpdaterLinkDescriptor> getSemanticChildren(final View view) {
		throw new UnsupportedOperationException("Not yet implemented"); //$NON-NLS-1$
	}

	/**
	 * 
	 * @param view
	 *        a view
	 * @return
	 *         the list of the incoming links for this view
	 */
	public static List<UpdaterLinkDescriptor> getIncomingLinks(final View view) {
		final String id = view.getType();//TODO : could be done by the SysMLVisualIdRegistry...
		if(id.equals(UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID)) {
			return getPort_shape_uml_port_as_affixed_IncominkLink(view);
		}
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID)) {
			return getFlowPort_shape_sysml_flowport_as_affixed_IncominkLink(view);
		}
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID)) {
			return getProperty_shape_sysml_blockproperty_as_composite_IncomingLink(view);
		}
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID)) {
			return getBlock_shape_sysml_block_as_composite_IncomingLink(view);
		}
		if(id.equals(UMLGraphicalTypes.LINK_UML_DEPENDENCY_ID)) {
			return getDependency_link_uml_dependency_IncomingLink(view);
		}
		if(id.equals(UMLGraphicalTypes.LINK_UML_CONNECTOR_ID)) {
			return getConnector_link_uml_connector_IncomingLink(view);
		}
		if(id.equals(Integer.toString(CommentEditPart.VISUAL_ID))) {
			return getComment_2109IncomingLinks(view);
		}
		if(id.equals(Integer.toString(CommentEditPartCN.VISUAL_ID))) {
			return getComment_3097IncomingLinks(view);
		}
		if(id.equals(Integer.toString(ConstraintEditPart.VISUAL_ID))) {
			return getConstraint_2114IncomingLinks(view);
		}
		if(id.equals(Integer.toString(ConstraintEditPartCN.VISUAL_ID))) {
			return getConstraint_3120IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * 
	 * @param view
	 *        a view
	 * @return
	 *         the list of the outgoing links for this view
	 */
	public static List<UpdaterLinkDescriptor> getOutgoingLinks(final View view) {
		final String id = view.getType();//TODO : could be done by the SysMLVisualIdRegistry...
		if(id.equals(UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID)) {
			return getPort_shape_uml_port_as_affixed_OutgoingLink(view);
		}
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID)) {
			return getFlowPort_shape_sysml_flowport_as_affixed_OutgoingLink(view);
		}
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID)) {
			return getProperty_shape_sysml_blockproperty_as_composite_OutgoingLink(view);
		}
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID)) {
			return getBlock_shape_sysml_block_as_composite_OutgoingLink(view);
		}
		if(id.equals(UMLGraphicalTypes.LINK_UML_DEPENDENCY_ID)) {
			return getDependency_link_uml_dependency_OutgoingLink(view);
		}
		if(id.equals(UMLGraphicalTypes.LINK_UML_CONNECTOR_ID)) {
			return getConnector_link_uml_connector_OutgoingLink(view);
		}
		if(id.equals(Integer.toString(CommentEditPart.VISUAL_ID))) {
			return getComment_2109OutgoingLinks(view);
		}
		if(id.equals(Integer.toString(CommentEditPartCN.VISUAL_ID))) {
			return getComment_3097OutgoingLinks(view);
		}
		if(id.equals(Integer.toString(ConstraintEditPart.VISUAL_ID))) {
			return getConstraint_2114OutgoingLinks(view);
		}
		if(id.equals(Integer.toString(ConstraintEditPartCN.VISUAL_ID))) {
			return getConstraint_3120OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	private static List<UpdaterLinkDescriptor> getConnector_link_uml_connector_IncomingLink(View view) {
		Connector modelElement = (Connector)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetsLinks_Dependency_link_uml_dependency(modelElement, crossReferences));
		return result;

	}

	private static List<UpdaterLinkDescriptor> getConnector_link_uml_connector_OutgoingLink(View view) {
		Connector modelElement = (Connector)view.getElement();
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getDependency_link_uml_dependency_IncomingLink(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetsLinks_Dependency_link_uml_dependency(modelElement, crossReferences));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getDependency_link_uml_dependency_OutgoingLink(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement));
		return result;
	}


	private static List<UpdaterLinkDescriptor> getComment_3097IncomingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getComment_3097OutgoingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getComment_2109IncomingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getComment_2109OutgoingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getConstraint_2114IncomingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetsLinks_Dependency_link_uml_dependency(modelElement, crossReferences));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getConstraint_2114OutgoingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getConstraint_3120IncomingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetsLinks_Dependency_link_uml_dependency(modelElement, crossReferences));
		return result;
	}


	private static List<UpdaterLinkDescriptor> getConstraint_3120OutgoingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getBlock_shape_sysml_block_as_composite_IncomingLink(final View view) {
		final Class modelElement = (Class)view.getElement();
		final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		final LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetsLinks_Dependency_link_uml_dependency(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getBlock_shape_sysml_block_as_composite_OutgoingLink(final View view) {
		final Class modelElement = (Class)view.getElement();
		final LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement));
		return result;
	}

	/**
	 * 
	 * @param view
	 *        a view
	 * @return
	 *         common method to get the incoming link for a property in the SysML IBD Diagram
	 */
	private static List<UpdaterLinkDescriptor> getProperty_IncomingLink(final View view) {
		final Property modelElement = (Property)view.getElement();
		final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		final LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetsLinks_Connector_link_uml_connector(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetsLinks_Dependency_link_uml_dependency(modelElement, crossReferences));
		return result;
	}

	/**
	 * 
	 * @param view
	 *        a view
	 * @return
	 *         common method to get the outgoing link for a property in the SysML IBD Diagram
	 */
	private static List<UpdaterLinkDescriptor> getProperty_OutgoingLink(final View view) {
		final Property modelElement = (Property)view.getElement();
		final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		final LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetsLinks_Connector_link_uml_connector(modelElement, crossReferences));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement));
		return result;
	}

	private static Collection<? extends UpdaterLinkDescriptor> getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(final Element target, final Map<EObject, Collection<Setting>> crossReferences) {
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getComment_AnnotatedElement()) {
				result.add(new UpdaterLinkDescriptor(setting.getEObject(), target, UMLElementTypes.CommentAnnotatedElement_4002, CommentAnnotatedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}


	private static Collection<UpdaterLinkDescriptor> getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4002(Comment source) {
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		for(Iterator<?> destinations = source.getAnnotatedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.CommentAnnotatedElement_4002, CommentAnnotatedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	private static Collection<UpdaterLinkDescriptor> getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(Element target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getConstraint_ConstrainedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.ConstraintConstrainedElement_4003, ConstraintConstrainedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}


	private static Collection<UMLLinkDescriptor> getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4003(Constraint source) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for(Iterator<?> destinations = source.getConstrainedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.ConstraintConstrainedElement_4003, ConstraintConstrainedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	private static List<UpdaterLinkDescriptor> getProperty_shape_sysml_blockproperty_as_composite_IncomingLink(final View view) {
		return getProperty_IncomingLink(view);
	}

	private static List<UpdaterLinkDescriptor> getProperty_shape_sysml_blockproperty_as_composite_OutgoingLink(final View view) {
		return getProperty_OutgoingLink(view);
	}

	private static List<UpdaterLinkDescriptor> getFlowPort_shape_sysml_flowport_as_affixed_IncominkLink(View view) {
		return getProperty_IncomingLink(view);
	}

	private static List<UpdaterLinkDescriptor> getFlowPort_shape_sysml_flowport_as_affixed_OutgoingLink(View view) {
		return getProperty_OutgoingLink(view);
	}

	private static List<UpdaterLinkDescriptor> getPort_shape_uml_port_as_affixed_IncominkLink(View view) {
		return getProperty_IncomingLink(view);
	}

	private static List<UpdaterLinkDescriptor> getPort_shape_uml_port_as_affixed_OutgoingLink(View view) {
		return getProperty_OutgoingLink(view);
	}

	private static Collection<? extends UpdaterLinkDescriptor> getIncomingTypeModelFacetsLinks_Connector_link_uml_connector(final ConnectableElement target, Map<EObject, Collection<Setting>> crossReferences) {
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getConnectorEnd_Role() || false == setting.getEObject() instanceof ConnectorEnd) {
				continue;
			}
			final ConnectorEnd connectorEnd = (ConnectorEnd)setting.getEObject();
			if(!UMLGraphicalTypes.LINK_UML_CONNECTOR_ID.equals(SysMLVisualIDRegistry.getLinkWithClassVisualID(connectorEnd.eContainer()))) {
				continue;
			}
			final Connector connector = (Connector)connectorEnd.eContainer();

			//FIXME : verify the path
			for(final ConnectorEnd current : connector.getEnds()) {
				if(current == connectorEnd) {
					continue;
				}
				final ConnectableElement src = current.getRole();
				result.add(new UpdaterLinkDescriptor(src, target, connector, org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes.Connector_4013, -1));
			}
		}
		return result;
	}

	private static Collection<? extends UpdaterLinkDescriptor> getOutgoingTypeModelFacetsLinks_Connector_link_uml_connector(final ConnectableElement source, Map<EObject, Collection<Setting>> crossReferences) {
		//I don't know how to adapt the common case to connector, so this way works properly...
		return getIncomingTypeModelFacetsLinks_Connector_link_uml_connector(source, crossReferences);
	}

	private static Collection<? extends UpdaterLinkDescriptor> getIncomingTypeModelFacetsLinks_Dependency_link_uml_dependency(NamedElement target, Map<EObject, Collection<Setting>> crossReferences) {
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency)setting.getEObject();
			if(!UMLGraphicalTypes.LINK_UML_DEPENDENCY_ID.equals(SysMLVisualIDRegistry.getLinkWithClassVisualID(link))) {
				continue;
			}

			List<?> sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UpdaterLinkDescriptor(src, target, link, org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes.Dependency_4010, -1));
		}
		return result;
	}

	private static Collection<? extends UpdaterLinkDescriptor> getOutgoingTypeModelFacetLinks_Dependency_link_uml_dependency(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Package) {
				container = (Package)element;
			}
		}
		if(container == null) {
			return Collections.emptyList();
		}
		Collection<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		for(Iterator<?> links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency)linkObject;
			if(!UMLGraphicalTypes.LINK_UML_DEPENDENCY_ID.equals(SysMLVisualIDRegistry.getLinkWithClassVisualID(link))) {
				continue;
			}
			List<?> targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List<?> sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UpdaterLinkDescriptor(src, dst, link, org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes.Dependency_4010, -1));
		}
		return result;
	}


}
