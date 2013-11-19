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
package org.eclipse.papyrus.sysml.diagram.blockdefinition.part;

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
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLLinkDescriptor;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Usage;


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
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID)) {
			return getBlock_shape_sysml_block_as_classifier_IncomingLink(view);
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
		if(id.equals(SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID)) {
			return getBlock_shape_sysml_block_as_classifier_OutgoingLink(view);
		}
		return Collections.emptyList();
	}

	private static List<UpdaterLinkDescriptor> getBlock_shape_sysml_block_as_classifier_IncomingLink(View view) {
		final Class modelElement = (Class)view.getElement();
		final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		final LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Association_link_sysml_association(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_link_uml_generalization(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_link_uml_usage(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	private static List<UpdaterLinkDescriptor> getBlock_shape_sysml_block_as_classifier_OutgoingLink(final View view) {
		final Class modelElement = (Class)view.getElement();
		final LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Association_link_sysml_association(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_link_uml_generalization(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_link_uml_dependency(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_link_uml_interfacerealization(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_link_uml_usage(modelElement));
		return result;
	}

	private static Collection<UpdaterLinkDescriptor> getIncomingTypeModelFacetLinks_Dependency_link_uml_dependency(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
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
			List<NamedElement> sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Dependency_4008, -1));
		}
		return result;
	}

	private static Collection<UpdaterLinkDescriptor> getContainedTypeModelFacetLinks_InterfaceRealization_link_uml_interfacerealization(BehavioredClassifier container) {
		Collection<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		for(Iterator<InterfaceRealization> links = container.getInterfaceRealizations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof InterfaceRealization) {
				continue;
			}
			InterfaceRealization link = (InterfaceRealization)linkObject;
			if(!UMLGraphicalTypes.LINK_UML_INTERFACEREALIZATION_ID.equals(SysMLVisualIDRegistry.getLinkWithClassVisualID(link))) {
				continue;
			}
			Interface dst = link.getContract();
			result.add(new UpdaterLinkDescriptor(container, dst, link, UMLElementTypes.InterfaceRealization_4003, -1));
		}
		return result;
	}

	private static Collection<UpdaterLinkDescriptor> getIncomingTypeModelFacetLinks_Usage_link_uml_usage(NamedElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Usage) {
				continue;
			}
			Usage link = (Usage)setting.getEObject();
			if(!UMLGraphicalTypes.LINK_UML_USAGE_ID.equals(SysMLVisualIDRegistry.getLinkWithClassVisualID(link))) {
				continue;
			}
			List<NamedElement> sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UpdaterLinkDescriptor(src, target, link, UMLElementTypes.Usage_4007, -1));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UpdaterLinkDescriptor> getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(Comment source) {
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		for(Iterator<?> destinations = source.getAnnotatedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element)destinations.next();
			result.add(new UpdaterLinkDescriptor(source, destination, UMLElementTypes.CommentAnnotatedElement_4013, CommentAnnotatedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UpdaterLinkDescriptor> getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(Constraint source) {
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		for(Iterator<?> destinations = source.getConstrainedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element)destinations.next();
			result.add(new UpdaterLinkDescriptor(source, destination, UMLElementTypes.ConstraintConstrainedElement_4014, ConstraintConstrainedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UpdaterLinkDescriptor> getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4013(Element target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getComment_AnnotatedElement()) {
				result.add(new UpdaterLinkDescriptor(setting.getEObject(), target, UMLElementTypes.CommentAnnotatedElement_4013, CommentAnnotatedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<UpdaterLinkDescriptor> getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(Element target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getConstraint_ConstrainedElement()) {
				result.add(new UpdaterLinkDescriptor(setting.getEObject(), target, UMLElementTypes.ConstraintConstrainedElement_4014, ConstraintConstrainedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}


	private static Collection<UpdaterLinkDescriptor> getOutgoingTypeModelFacetLinks_Usage_link_uml_usage(NamedElement source) {
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
		for(Iterator<PackageableElement> links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Usage) {
				continue;
			}
			Usage link = (Usage)linkObject;
			if(!UMLGraphicalTypes.LINK_UML_USAGE_ID.equals(SysMLVisualIDRegistry.getLinkWithClassVisualID(linkObject))) {
				continue;
			}
			List<NamedElement> targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List<NamedElement> sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Usage_4007, -1));
		}
		return result;
	}




	private static Collection<UpdaterLinkDescriptor> getOutgoingTypeModelFacetLinks_Dependency_link_uml_dependency(NamedElement source) {
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
		for(Iterator<PackageableElement> links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency)linkObject;
			if(!UMLGraphicalTypes.LINK_UML_DEPENDENCY_ID.equals(SysMLVisualIDRegistry.getLinkWithClassVisualID(link))) {
				continue;
			}
			List<NamedElement> targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List<NamedElement> sources = link.getClients();
			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UpdaterLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4008, -1));
		}
		return result;
	}

	private static Collection<UpdaterLinkDescriptor> getContainedTypeModelFacetLinks_Generalization_link_uml_generalization(Classifier container) {
		Collection<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		for(Iterator<Generalization> links = container.getGeneralizations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Generalization) {
				continue;
			}
			Generalization link = (Generalization)linkObject;
			if(!UMLGraphicalTypes.LINK_UML_GENERALIZATION_ID.equals(SysMLVisualIDRegistry.getLinkWithClassVisualID(link))) {
				continue;
			}
			Classifier dst = link.getGeneral();
			result.add(new UpdaterLinkDescriptor(container, dst, link, UMLElementTypes.Generalization_4002, -1));
		}
		return result;
	}

	private static Collection<UpdaterLinkDescriptor> getIncomingTypeModelFacetLinks_Generalization_link_uml_generalization(Classifier target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getGeneralization_General() || false == setting.getEObject() instanceof Generalization) {
				continue;
			}
			Generalization link = (Generalization)setting.getEObject();
			if(!UMLGraphicalTypes.LINK_UML_GENERALIZATION_ID.equals(SysMLVisualIDRegistry.getLinkWithClassVisualID(link))) {
				continue;
			}
			if(false == link.eContainer() instanceof Classifier) {
				continue;
			}
			Classifier container = (Classifier)link.eContainer();
			result.add(new UpdaterLinkDescriptor(container, target, link, UMLElementTypes.Generalization_4002, -1));
		}
		return result;
	}


	private static Collection<? extends UpdaterLinkDescriptor> getIncomingTypeModelFacetLinks_Association_link_sysml_association(Class target, Map<EObject, Collection<Setting>> crossReferences) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for(EStructuralFeature.Setting setting : settings) {
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getAssociation_EndType() || false == setting.getEObject() instanceof Association) {
				continue;
			}
			Association link = (Association)setting.getEObject();
			if(!SysMLGraphicalTypes.LINK_SYSML_ASSOCIATION_ID.equals(SysMLVisualIDRegistry.getLinkWithClassVisualID(link))) {
				continue;
			}
			List<Type> sources = link.getEndTypes();
			//Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			Object theSource = sources.size() >= 2 ? sources.get(1) : null;//source and target ar einverted in BDD
			if(false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, SysMLElementTypes.ASSOCIATION, -1));
		}
		return result;
	}

	private static Collection<? extends UpdaterLinkDescriptor> getOutgoingTypeModelFacetLinks_Association_link_sysml_association(final Class source) {
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
		for(Iterator<PackageableElement> links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association)linkObject;
			if(!SysMLGraphicalTypes.LINK_SYSML_ASSOCIATION_ID.equals(SysMLVisualIDRegistry.getLinkWithClassVisualID(link))) {
				continue;
			}
			//Papyrus GenCode 
			List<Type> targets = link.getEndTypes();
			//			Object theTarget = targets.size() >= 2 ? targets.get(1) : null;
			Object theTarget = targets.size() >= 1 ? targets.get(0) : null;//source and target are inverted in BDD
			if(false == theTarget instanceof Type) {
				continue;
			}
			Type dst = (Type)theTarget;
			List<Type> sources = link.getEndTypes();
			//			Object theSource = sources.size() >= 1 ? sources.get(0) : null;
			Object theSource = sources.size() >= 2 ? sources.get(1) : null;//source and target are inverted in BDD
			if(false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type)theSource;
			if(src != source) {
				continue;
			}
			//TODO, FIXME : warning to the several link uml association?
			result.add(new UMLLinkDescriptor(src, dst, link, SysMLElementTypes.ASSOCIATION, -1));
		}
		return result;
	}


}
