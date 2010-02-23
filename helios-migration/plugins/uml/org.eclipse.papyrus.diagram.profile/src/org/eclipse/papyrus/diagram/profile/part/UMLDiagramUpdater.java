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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.profile.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.profile.edit.parts.AssociationBranchEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.AssociationNodeEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.ClassOperationEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.ClassPropertyEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.ConstraintEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.DataTypeAttributeCompartmentEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.DataTypeAttributeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.DataTypeEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.DataTypeEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.DataTypeOperationCompartmentEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.DataTypeOperationCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.DataTypeOperationEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.DataTypePropertyEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.DependencyBranchEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.DependencyNodeEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.ElementImportEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.EnumerationEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.EnumerationEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.EnumerationEnumerationLiteralCompartmentEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.EnumerationEnumerationLiteralCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.EnumerationLiteralEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.ExtensionEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.MetaclassEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.MetaclassEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ModelEditPartTN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ModelPackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ModelPackageableElementCompartmentEditPartTN;
import org.eclipse.papyrus.diagram.profile.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.PackageImportEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.PackagePackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ProfileApplicationEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.ProfileDiagramEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.ProfileEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ProfileEditPartTN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ProfilePackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ProfilePackageableElementCompartmentEditPartTN;
import org.eclipse.papyrus.diagram.profile.edit.parts.ShortCutDiagramEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.StereotypeAttributeCompartmentEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.StereotypeAttributeCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.StereotypeEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.StereotypeEditPartCN;
import org.eclipse.papyrus.diagram.profile.edit.parts.StereotypeOperationCompartmentEditPart;
import org.eclipse.papyrus.diagram.profile.edit.parts.StereotypeOperationCompartmentEditPartCN;
import org.eclipse.papyrus.diagram.profile.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case PackageEditPartCN.VISUAL_ID:
			return getPackage_1012SemanticChildren(view);
		case PackagePackageableElementCompartmentEditPart.VISUAL_ID:
			return getPackagePackageableElementCompartment_1005SemanticChildren(view);
		case PackagePackageableElementCompartmentEditPartCN.VISUAL_ID:
			return getPackagePackageableElementCompartmentCN_11SemanticChildren(view);
		case ProfilePackageableElementCompartmentEditPartTN.VISUAL_ID:
			return getProfileProfilePackageableElementCompartmentTN_1042SemanticChildren(view);
		case ProfilePackageableElementCompartmentEditPartCN.VISUAL_ID:
			return getProfileProfilePackageableElementCompartmentTN_1051SemanticChildren(view);
		case StereotypeAttributeCompartmentEditPart.VISUAL_ID:
			return getStereotypeAttributeCompartment_1071SemanticChildren(view);
		case StereotypeAttributeCompartmentEditPartCN.VISUAL_ID:
			return getStereotypeAttributeCompartment_1052SemanticChildren(view);
		case StereotypeOperationCompartmentEditPart.VISUAL_ID:
			return getStereotypeOperationCompartment_1019SemanticChildren(view);
		case StereotypeOperationCompartmentEditPartCN.VISUAL_ID:
			return getStereotypeOperationCompartment_1053SemanticChildren(view);
		case ModelPackageableElementCompartmentEditPartTN.VISUAL_ID:
			return getModelModelElementCompartment_1057SemanticChildren(view);
		case ModelPackageableElementCompartmentEditPartCN.VISUAL_ID:
			return getModelModelElementCompartment_1058SemanticChildren(view);
		case EnumerationEnumerationLiteralCompartmentEditPartCN.VISUAL_ID:
			return getEnumerationEnumerationEnumerationLiteral_1062SemanticChildren(view);
		case EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID:
			return getEnumerationEnumerationEnumerationLiteral_1063SemanticChildren(view);
		case DataTypeAttributeCompartmentEditPart.VISUAL_ID:
			return getDataTypeDataTypeAttributeCompartment_1067SemanticChildren(view);
		case DataTypeAttributeCompartmentEditPartCN.VISUAL_ID:
			return getDataTypeDataTypeAttributeCompartment_1069SemanticChildren(view);
		case DataTypeOperationCompartmentEditPart.VISUAL_ID:
			return getDataTypeDataTypeOperationCompartment_1068SemanticChildren(view);
		case DataTypeOperationCompartmentEditPartCN.VISUAL_ID:
			return getDataTypeDataTypeOperationCompartment_1070SemanticChildren(view);
		case ProfileDiagramEditPart.VISUAL_ID:
			return getProfile_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}



	/**
	 * @generated
	 */
	public static List getPackage_1012SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package)view.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == PackageEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}




	/**
	 * @generated
	 */
	public static List getPackagePackageableElementCompartment_1005SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ModelEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProfileEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PackageEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}




	/**
	 * @generated
	 */
	public static List getPackagePackageableElementCompartmentCN_11SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Package modelElement = (Package)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ModelEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProfileEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PackageEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}




	/**
	 * @generated
	 */
	public static List getProfileProfilePackageableElementCompartmentTN_1042SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Profile modelElement = (Profile)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getOwnedStereotypes().iterator(); it.hasNext();) {
			Stereotype childElement = (Stereotype)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == StereotypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ModelEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProfileEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PackageEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == MetaclassEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}




	/**
	 * @generated
	 */
	public static List getProfileProfilePackageableElementCompartmentTN_1051SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Profile modelElement = (Profile)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getOwnedStereotypes().iterator(); it.hasNext();) {
			Stereotype childElement = (Stereotype)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == StereotypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ModelEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProfileEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PackageEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == MetaclassEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}




	/**
	 * @generated
	 */
	public static List getStereotypeAttributeCompartment_1071SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Stereotype modelElement = (Stereotype)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ClassPropertyEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}




	/**
	 * @generated
	 */
	public static List getStereotypeAttributeCompartment_1052SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Stereotype modelElement = (Stereotype)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ClassPropertyEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}




	/**
	 * @generated
	 */
	public static List getStereotypeOperationCompartment_1019SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Stereotype modelElement = (Stereotype)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ClassOperationEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}




	/**
	 * @generated
	 */
	public static List getStereotypeOperationCompartment_1053SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Stereotype modelElement = (Stereotype)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ClassOperationEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}




	/**
	 * @generated
	 */
	public static List getModelModelElementCompartment_1057SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Model modelElement = (Model)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ModelEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProfileEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PackageEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}




	/**
	 * @generated
	 */
	public static List getModelModelElementCompartment_1058SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Model modelElement = (Model)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == ModelEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProfileEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PackageEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPartCN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}




	/**
	 * @generated
	 */
	public static List getEnumerationEnumerationEnumerationLiteral_1062SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Enumeration modelElement = (Enumeration)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getOwnedLiterals().iterator(); it.hasNext();) {
			EnumerationLiteral childElement = (EnumerationLiteral)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == EnumerationLiteralEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}




	/**
	 * @generated
	 */
	public static List getEnumerationEnumerationEnumerationLiteral_1063SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Enumeration modelElement = (Enumeration)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getOwnedLiterals().iterator(); it.hasNext();) {
			EnumerationLiteral childElement = (EnumerationLiteral)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == EnumerationLiteralEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}




	/**
	 * @generated
	 */
	public static List getDataTypeDataTypeAttributeCompartment_1067SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		DataType modelElement = (DataType)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DataTypePropertyEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}




	/**
	 * @generated
	 */
	public static List getDataTypeDataTypeAttributeCompartment_1069SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		DataType modelElement = (DataType)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DataTypePropertyEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}




	/**
	 * @generated
	 */
	public static List getDataTypeDataTypeOperationCompartment_1068SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		DataType modelElement = (DataType)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DataTypeOperationEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}




	/**
	 * @generated
	 */
	public static List getDataTypeDataTypeOperationCompartment_1070SemanticChildren(View view) {
		if(false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View)view.eContainer();
		if(!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		DataType modelElement = (DataType)containerView.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DataTypeOperationEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}




	/**
	 * @generated
	 */
	public static List getProfile_1000SemanticChildren(View view) {
		if(!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Profile modelElement = (Profile)view.getElement();
		List result = new LinkedList();
		for(Iterator it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == DependencyNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == AssociationNodeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == MetaclassEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ConstraintEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ModelEditPartTN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == ProfileEditPartTN.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == PackageEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == EnumerationEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if(visualID == DataTypeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getOwnedStereotypes().iterator(); it.hasNext();) {
			Stereotype childElement = (Stereotype)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == StereotypeEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for(Iterator it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment)it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if(visualID == CommentEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		Resource resource = modelElement.eResource();
		for(Iterator semanticIterator = getPhantomNodesIterator(resource); semanticIterator.hasNext();) {
			EObject childElement = (EObject)semanticIterator.next();
			if(childElement == modelElement) {
				continue;
			}
			if(UMLVisualIDRegistry.getNodeVisualID(view, childElement) == ShortCutDiagramEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(childElement, ShortCutDiagramEditPart.VISUAL_ID));
				continue;
			}
		}
		return result;
	}


	/**
	 * @generated
	 */
	private static Iterator getPhantomNodesIterator(Resource resource) {
		return resource.getAllContents();
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case ProfileDiagramEditPart.VISUAL_ID:
			return getProfile_1000ContainedLinks(view);
		case DependencyNodeEditPart.VISUAL_ID:
			return getDependency_2014ContainedLinks(view);
		case AssociationNodeEditPart.VISUAL_ID:
			return getAssociation_2015ContainedLinks(view);
		case StereotypeEditPart.VISUAL_ID:
			return getStereotype_1026ContainedLinks(view);
		case MetaclassEditPart.VISUAL_ID:
			return getClass_1031ContainedLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_1002ContainedLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_1014ContainedLinks(view);
		case ModelEditPartTN.VISUAL_ID:
			return getModel_2005ContainedLinks(view);
		case ProfileEditPartTN.VISUAL_ID:
			return getProfile_1030ContainedLinks(view);
		case PackageEditPart.VISUAL_ID:
			return getPackage_2007ContainedLinks(view);
		case EnumerationEditPart.VISUAL_ID:
			return getEnumeration_2006ContainedLinks(view);
		case DataTypeEditPart.VISUAL_ID:
			return getDataType_2010ContainedLinks(view);
		case ShortCutDiagramEditPart.VISUAL_ID:
			return getDiagram_2016ContainedLinks(view);
		case DataTypeOperationEditPart.VISUAL_ID:
			return getOperation_3019ContainedLinks(view);
		case EnumerationLiteralEditPart.VISUAL_ID:
			return getEnumerationLiteral_1037ContainedLinks(view);
		case DataTypePropertyEditPart.VISUAL_ID:
			return getProperty_3018ContainedLinks(view);
		case ClassPropertyEditPart.VISUAL_ID:
			return getProperty_3002ContainedLinks(view);
		case ClassOperationEditPart.VISUAL_ID:
			return getOperation_3020ContainedLinks(view);
		case StereotypeEditPartCN.VISUAL_ID:
			return getStereotype_1023ContainedLinks(view);
		case MetaclassEditPartCN.VISUAL_ID:
			return getClass_3028ContainedLinks(view);
		case CommentEditPartCN.VISUAL_ID:
			return getComment_1007ContainedLinks(view);
		case ModelEditPartCN.VISUAL_ID:
			return getModel_1027ContainedLinks(view);
		case ProfileEditPartCN.VISUAL_ID:
			return getProfile_1024ContainedLinks(view);
		case PackageEditPartCN.VISUAL_ID:
			return getPackage_1012ContainedLinks(view);
		case ConstraintEditPartCN.VISUAL_ID:
			return getConstraint_1028ContainedLinks(view);
		case EnumerationEditPartCN.VISUAL_ID:
			return getEnumeration_3025ContainedLinks(view);
		case DataTypeEditPartCN.VISUAL_ID:
			return getDataType_3027ContainedLinks(view);
		case ExtensionEditPart.VISUAL_ID:
			return getExtension_1013ContainedLinks(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_4001ContainedLinks(view);
		case ProfileApplicationEditPart.VISUAL_ID:
			return getProfileApplication_1045ContainedLinks(view);
		case AssociationBranchEditPart.VISUAL_ID:
			return getAssociation_4019ContainedLinks(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4002ContainedLinks(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4008ContainedLinks(view);
		case DependencyBranchEditPart.VISUAL_ID:
			return getDependency_4018ContainedLinks(view);
		case ElementImportEditPart.VISUAL_ID:
			return getElementImport_1064ContainedLinks(view);
		case PackageImportEditPart.VISUAL_ID:
			return getPackageImport_1065ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case DependencyNodeEditPart.VISUAL_ID:
			return getDependency_2014IncomingLinks(view);
		case AssociationNodeEditPart.VISUAL_ID:
			return getAssociation_2015IncomingLinks(view);
		case StereotypeEditPart.VISUAL_ID:
			return getStereotype_1026IncomingLinks(view);
		case MetaclassEditPart.VISUAL_ID:
			return getClass_1031IncomingLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_1002IncomingLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_1014IncomingLinks(view);
		case ModelEditPartTN.VISUAL_ID:
			return getModel_2005IncomingLinks(view);
		case ProfileEditPartTN.VISUAL_ID:
			return getProfile_1030IncomingLinks(view);
		case PackageEditPart.VISUAL_ID:
			return getPackage_2007IncomingLinks(view);
		case EnumerationEditPart.VISUAL_ID:
			return getEnumeration_2006IncomingLinks(view);
		case DataTypeEditPart.VISUAL_ID:
			return getDataType_2010IncomingLinks(view);
		case ShortCutDiagramEditPart.VISUAL_ID:
			return getDiagram_2016IncomingLinks(view);
		case DataTypeOperationEditPart.VISUAL_ID:
			return getOperation_3019IncomingLinks(view);
		case EnumerationLiteralEditPart.VISUAL_ID:
			return getEnumerationLiteral_1037IncomingLinks(view);
		case DataTypePropertyEditPart.VISUAL_ID:
			return getProperty_3018IncomingLinks(view);
		case ClassPropertyEditPart.VISUAL_ID:
			return getProperty_3002IncomingLinks(view);
		case ClassOperationEditPart.VISUAL_ID:
			return getOperation_3020IncomingLinks(view);
		case StereotypeEditPartCN.VISUAL_ID:
			return getStereotype_1023IncomingLinks(view);
		case MetaclassEditPartCN.VISUAL_ID:
			return getClass_3028IncomingLinks(view);
		case CommentEditPartCN.VISUAL_ID:
			return getComment_1007IncomingLinks(view);
		case ModelEditPartCN.VISUAL_ID:
			return getModel_1027IncomingLinks(view);
		case ProfileEditPartCN.VISUAL_ID:
			return getProfile_1024IncomingLinks(view);
		case PackageEditPartCN.VISUAL_ID:
			return getPackage_1012IncomingLinks(view);
		case ConstraintEditPartCN.VISUAL_ID:
			return getConstraint_1028IncomingLinks(view);
		case EnumerationEditPartCN.VISUAL_ID:
			return getEnumeration_3025IncomingLinks(view);
		case DataTypeEditPartCN.VISUAL_ID:
			return getDataType_3027IncomingLinks(view);
		case ExtensionEditPart.VISUAL_ID:
			return getExtension_1013IncomingLinks(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_4001IncomingLinks(view);
		case ProfileApplicationEditPart.VISUAL_ID:
			return getProfileApplication_1045IncomingLinks(view);
		case AssociationBranchEditPart.VISUAL_ID:
			return getAssociation_4019IncomingLinks(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4002IncomingLinks(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4008IncomingLinks(view);
		case DependencyBranchEditPart.VISUAL_ID:
			return getDependency_4018IncomingLinks(view);
		case ElementImportEditPart.VISUAL_ID:
			return getElementImport_1064IncomingLinks(view);
		case PackageImportEditPart.VISUAL_ID:
			return getPackageImport_1065IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case DependencyNodeEditPart.VISUAL_ID:
			return getDependency_2014OutgoingLinks(view);
		case AssociationNodeEditPart.VISUAL_ID:
			return getAssociation_2015OutgoingLinks(view);
		case StereotypeEditPart.VISUAL_ID:
			return getStereotype_1026OutgoingLinks(view);
		case MetaclassEditPart.VISUAL_ID:
			return getClass_1031OutgoingLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_1002OutgoingLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_1014OutgoingLinks(view);
		case ModelEditPartTN.VISUAL_ID:
			return getModel_2005OutgoingLinks(view);
		case ProfileEditPartTN.VISUAL_ID:
			return getProfile_1030OutgoingLinks(view);
		case PackageEditPart.VISUAL_ID:
			return getPackage_2007OutgoingLinks(view);
		case EnumerationEditPart.VISUAL_ID:
			return getEnumeration_2006OutgoingLinks(view);
		case DataTypeEditPart.VISUAL_ID:
			return getDataType_2010OutgoingLinks(view);
		case ShortCutDiagramEditPart.VISUAL_ID:
			return getDiagram_2016OutgoingLinks(view);
		case DataTypeOperationEditPart.VISUAL_ID:
			return getOperation_3019OutgoingLinks(view);
		case EnumerationLiteralEditPart.VISUAL_ID:
			return getEnumerationLiteral_1037OutgoingLinks(view);
		case DataTypePropertyEditPart.VISUAL_ID:
			return getProperty_3018OutgoingLinks(view);
		case ClassPropertyEditPart.VISUAL_ID:
			return getProperty_3002OutgoingLinks(view);
		case ClassOperationEditPart.VISUAL_ID:
			return getOperation_3020OutgoingLinks(view);
		case StereotypeEditPartCN.VISUAL_ID:
			return getStereotype_1023OutgoingLinks(view);
		case MetaclassEditPartCN.VISUAL_ID:
			return getClass_3028OutgoingLinks(view);
		case CommentEditPartCN.VISUAL_ID:
			return getComment_1007OutgoingLinks(view);
		case ModelEditPartCN.VISUAL_ID:
			return getModel_1027OutgoingLinks(view);
		case ProfileEditPartCN.VISUAL_ID:
			return getProfile_1024OutgoingLinks(view);
		case PackageEditPartCN.VISUAL_ID:
			return getPackage_1012OutgoingLinks(view);
		case ConstraintEditPartCN.VISUAL_ID:
			return getConstraint_1028OutgoingLinks(view);
		case EnumerationEditPartCN.VISUAL_ID:
			return getEnumeration_3025OutgoingLinks(view);
		case DataTypeEditPartCN.VISUAL_ID:
			return getDataType_3027OutgoingLinks(view);
		case ExtensionEditPart.VISUAL_ID:
			return getExtension_1013OutgoingLinks(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_4001OutgoingLinks(view);
		case ProfileApplicationEditPart.VISUAL_ID:
			return getProfileApplication_1045OutgoingLinks(view);
		case AssociationBranchEditPart.VISUAL_ID:
			return getAssociation_4019OutgoingLinks(view);
		case GeneralizationEditPart.VISUAL_ID:
			return getGeneralization_4002OutgoingLinks(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4008OutgoingLinks(view);
		case DependencyBranchEditPart.VISUAL_ID:
			return getDependency_4018OutgoingLinks(view);
		case ElementImportEditPart.VISUAL_ID:
			return getElementImport_1064OutgoingLinks(view);
		case PackageImportEditPart.VISUAL_ID:
			return getPackageImport_1065OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProfile_1000ContainedLinks(View view) {
		Profile modelElement = (Profile)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Extension_1013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ProfileApplication_1045(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDependency_2014ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_2015ContainedLinks(View view) {
		Association modelElement = (Association)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStereotype_1026ContainedLinks(View view) {
		Stereotype modelElement = (Stereotype)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_1031ContainedLinks(View view) {
		Class modelElement = (Class)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_1002ContainedLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_1014ContainedLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModel_2005ContainedLinks(View view) {
		Model modelElement = (Model)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Extension_1013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ProfileApplication_1045(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProfile_1030ContainedLinks(View view) {
		Profile modelElement = (Profile)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Extension_1013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ProfileApplication_1045(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_2007ContainedLinks(View view) {
		Package modelElement = (Package)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Extension_1013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ProfileApplication_1045(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_2006ContainedLinks(View view) {
		Enumeration modelElement = (Enumeration)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataType_2010ContainedLinks(View view) {
		DataType modelElement = (DataType)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDiagram_2016ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperation_3019ContainedLinks(View view) {
		Operation modelElement = (Operation)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumerationLiteral_1037ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3018ContainedLinks(View view) {
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
	public static List getOperation_3020ContainedLinks(View view) {
		Operation modelElement = (Operation)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStereotype_1023ContainedLinks(View view) {
		Stereotype modelElement = (Stereotype)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_3028ContainedLinks(View view) {
		Class modelElement = (Class)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_1007ContainedLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModel_1027ContainedLinks(View view) {
		Model modelElement = (Model)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Extension_1013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ProfileApplication_1045(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProfile_1024ContainedLinks(View view) {
		Profile modelElement = (Profile)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Extension_1013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ProfileApplication_1045(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_1012ContainedLinks(View view) {
		Package modelElement = (Package)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Extension_1013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ProfileApplication_1045(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_1028ContainedLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_3025ContainedLinks(View view) {
		Enumeration modelElement = (Enumeration)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataType_3027ContainedLinks(View view) {
		DataType modelElement = (DataType)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getExtension_1013ContainedLinks(View view) {
		Extension modelElement = (Extension)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4001ContainedLinks(View view) {
		Association modelElement = (Association)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProfileApplication_1045ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4019ContainedLinks(View view) {
		Association modelElement = (Association)view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGeneralization_4002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDependency_4008ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDependency_4018ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getElementImport_1064ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackageImport_1065ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDependency_2014IncomingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_1064(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_2015IncomingLinks(View view) {
		Association modelElement = (Association)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_1064(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStereotype_1026IncomingLinks(View view) {
		Stereotype modelElement = (Stereotype)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Extension_1013(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_1064(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_1031IncomingLinks(View view) {
		Class modelElement = (Class)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Extension_1013(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_1064(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_1002IncomingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_1014IncomingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_1064(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModel_2005IncomingLinks(View view) {
		Model modelElement = (Model)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_1064(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageImport_1065(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProfile_1030IncomingLinks(View view) {
		Profile modelElement = (Profile)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ProfileApplication_1045(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_1064(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageImport_1065(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_2007IncomingLinks(View view) {
		Package modelElement = (Package)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_1064(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageImport_1065(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_2006IncomingLinks(View view) {
		Enumeration modelElement = (Enumeration)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_1064(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataType_2010IncomingLinks(View view) {
		DataType modelElement = (DataType)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_1064(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDiagram_2016IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperation_3019IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEnumerationLiteral_1037IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3018IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperation_3020IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getStereotype_1023IncomingLinks(View view) {
		Stereotype modelElement = (Stereotype)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Extension_1013(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_1064(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_3028IncomingLinks(View view) {
		Class modelElement = (Class)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Extension_1013(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_1064(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_1007IncomingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModel_1027IncomingLinks(View view) {
		Model modelElement = (Model)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_1064(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageImport_1065(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProfile_1024IncomingLinks(View view) {
		Profile modelElement = (Profile)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_ProfileApplication_1045(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_1064(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageImport_1065(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_1012IncomingLinks(View view) {
		Package modelElement = (Package)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_1064(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_PackageImport_1065(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_1028IncomingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_1064(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_3025IncomingLinks(View view) {
		Enumeration modelElement = (Enumeration)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_1064(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataType_3027IncomingLinks(View view) {
		DataType modelElement = (DataType)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_1064(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getExtension_1013IncomingLinks(View view) {
		Extension modelElement = (Extension)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_1064(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4001IncomingLinks(View view) {
		Association modelElement = (Association)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_1064(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProfileApplication_1045IncomingLinks(View view) {
		ProfileApplication modelElement = (ProfileApplication)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4019IncomingLinks(View view) {
		Association modelElement = (Association)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4019(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Generalization_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_1064(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGeneralization_4002IncomingLinks(View view) {
		Generalization modelElement = (Generalization)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDependency_4008IncomingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_1064(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDependency_4018IncomingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ElementImport_1064(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getElementImport_1064IncomingLinks(View view) {
		ElementImport modelElement = (ElementImport)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackageImport_1065IncomingLinks(View view) {
		PackageImport modelElement = (PackageImport)view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDependency_2014OutgoingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_2015OutgoingLinks(View view) {
		Association modelElement = (Association)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStereotype_1026OutgoingLinks(View view) {
		Stereotype modelElement = (Stereotype)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_1031OutgoingLinks(View view) {
		Class modelElement = (Class)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_1002OutgoingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_1014OutgoingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModel_2005OutgoingLinks(View view) {
		Model modelElement = (Model)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ProfileApplication_1045(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProfile_1030OutgoingLinks(View view) {
		Profile modelElement = (Profile)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ProfileApplication_1045(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_2007OutgoingLinks(View view) {
		Package modelElement = (Package)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ProfileApplication_1045(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_2006OutgoingLinks(View view) {
		Enumeration modelElement = (Enumeration)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataType_2010OutgoingLinks(View view) {
		DataType modelElement = (DataType)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDiagram_2016OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperation_3019OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEnumerationLiteral_1037OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3018OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getProperty_3002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOperation_3020OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getStereotype_1023OutgoingLinks(View view) {
		Stereotype modelElement = (Stereotype)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getClass_3028OutgoingLinks(View view) {
		Class modelElement = (Class)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getComment_1007OutgoingLinks(View view) {
		Comment modelElement = (Comment)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getModel_1027OutgoingLinks(View view) {
		Model modelElement = (Model)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ProfileApplication_1045(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProfile_1024OutgoingLinks(View view) {
		Profile modelElement = (Profile)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ProfileApplication_1045(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPackage_1012OutgoingLinks(View view) {
		Package modelElement = (Package)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_ProfileApplication_1045(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getConstraint_1028OutgoingLinks(View view) {
		Constraint modelElement = (Constraint)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnumeration_3025OutgoingLinks(View view) {
		Enumeration modelElement = (Enumeration)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataType_3027OutgoingLinks(View view) {
		DataType modelElement = (DataType)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getExtension_1013OutgoingLinks(View view) {
		Extension modelElement = (Extension)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4001OutgoingLinks(View view) {
		Association modelElement = (Association)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getProfileApplication_1045OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_4019OutgoingLinks(View view) {
		Association modelElement = (Association)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4019(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Generalization_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_ElementImport_1064(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_PackageImport_1065(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGeneralization_4002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDependency_4008OutgoingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDependency_4018OutgoingLinks(View view) {
		Dependency modelElement = (Dependency)view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4018(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getElementImport_1064OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPackageImport_1065OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Extension_1013(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Extension) {
				continue;
			}
			Extension link = (Extension)linkObject;
			if(ExtensionEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			Class dst = link.getMetaclass();
			List sources = link.getOwnedEnds();


			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if(false == theSource instanceof Property) {
				continue;
			}
			Property src = (Property)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Extension_1013, ExtensionEditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Association_4001(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association)linkObject;
			if(AssociationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			//Papyrus GenCode 
			List targets = link.getEndTypes();
			Object theTarget = targets.size() >= 2 ? targets.get(1) : null;
			if(false == theTarget instanceof Type) {
				continue;
			}
			Type dst = (Type)theTarget;
			List sources = link.getEndTypes();


			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if(false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Association_4001, AssociationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_ProfileApplication_1045(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getProfileApplications().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof ProfileApplication) {
				continue;
			}
			ProfileApplication link = (ProfileApplication)linkObject;
			if(ProfileApplicationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			Profile dst = link.getAppliedProfile();
			Package src = link.getApplyingPackage();
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.ProfileApplication_1045, ProfileApplicationEditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Association_4019(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association)linkObject;
			if(AssociationBranchEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			//Papyrus GenCode 
			List targets = link.getEndTypes();
			Object theTarget = targets.size() >= 2 ? targets.get(1) : null;
			if(false == theTarget instanceof Type) {
				continue;
			}
			Type dst = (Type)theTarget;
			List sources = link.getEndTypes();


			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if(false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Association_4019, AssociationBranchEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Generalization_4002(Classifier container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getGeneralizations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Generalization) {
				continue;
			}
			Generalization link = (Generalization)linkObject;
			if(GeneralizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			Classifier dst = link.getGeneral();
			result.add(new UMLLinkDescriptor(container, dst, link, UMLElementTypes.Generalization_4002, GeneralizationEditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Dependency_4008(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency)linkObject;
			if(DependencyEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();


			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4008, DependencyEditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Dependency_4018(Package container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency)linkObject;
			if(DependencyBranchEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();


			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4018, DependencyBranchEditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_ElementImport_1064(Namespace container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getElementImports().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof ElementImport) {
				continue;
			}
			ElementImport link = (ElementImport)linkObject;
			if(ElementImportEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			PackageableElement dst = link.getImportedElement();
			Namespace src = link.getImportingNamespace();
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.ElementImport_1064, ElementImportEditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_PackageImport_1065(Namespace container) {
		Collection result = new LinkedList();
		for(Iterator links = container.getPackageImports().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof PackageImport) {
				continue;
			}
			PackageImport link = (PackageImport)linkObject;
			if(PackageImportEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			Package dst = link.getImportedPackage();
			Namespace src = link.getImportingNamespace();
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.PackageImport_1065, PackageImportEditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Extension_1013(Class target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getExtension_Metaclass() || false == setting.getEObject() instanceof Extension) {
				continue;
			}
			Extension link = (Extension)setting.getEObject();
			if(ExtensionEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getOwnedEnds();


			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if(false == theSource instanceof Property) {
				continue;
			}
			Property src = (Property)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Extension_1013, ExtensionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Association_4001(Type target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getAssociation_EndType() || false == setting.getEObject() instanceof Association) {
				continue;
			}
			Association link = (Association)setting.getEObject();
			if(AssociationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getEndTypes();


			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if(false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Association_4001, AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_ProfileApplication_1045(Profile target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getProfileApplication_AppliedProfile() || false == setting.getEObject() instanceof ProfileApplication) {
				continue;
			}
			ProfileApplication link = (ProfileApplication)setting.getEObject();
			if(ProfileApplicationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Package src = link.getApplyingPackage();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.ProfileApplication_1045, ProfileApplicationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Association_4019(Type target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getAssociation_EndType() || false == setting.getEObject() instanceof Association) {
				continue;
			}
			Association link = (Association)setting.getEObject();
			if(AssociationBranchEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getEndTypes();


			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if(false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Association_4019, AssociationBranchEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Generalization_4002(Classifier target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getGeneralization_General() || false == setting.getEObject() instanceof Generalization) {
				continue;
			}
			Generalization link = (Generalization)setting.getEObject();
			if(GeneralizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			if(false == link.eContainer() instanceof Classifier) {
				continue;
			}
			Classifier container = (Classifier)link.eContainer();
			result.add(new UMLLinkDescriptor(container, target, link, UMLElementTypes.Generalization_4002, GeneralizationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Dependency_4008(NamedElement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency)setting.getEObject();
			if(DependencyEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();


			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Dependency_4008, DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Dependency_4018(NamedElement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency)setting.getEObject();
			if(DependencyBranchEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();


			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Dependency_4018, DependencyBranchEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_ElementImport_1064(PackageableElement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getElementImport_ImportedElement() || false == setting.getEObject() instanceof ElementImport) {
				continue;
			}
			ElementImport link = (ElementImport)setting.getEObject();
			if(ElementImportEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Namespace src = link.getImportingNamespace();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.ElementImport_1064, ElementImportEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_PackageImport_1065(Package target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getPackageImport_ImportedPackage() || false == setting.getEObject() instanceof PackageImport) {
				continue;
			}
			PackageImport link = (PackageImport)setting.getEObject();
			if(PackageImportEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Namespace src = link.getImportingNamespace();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.PackageImport_1065, PackageImportEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getComment_AnnotatedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.CommentAnnotatedElement_1022, CommentAnnotatedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(Element target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection)crossReferences.get(target);
		for(Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
			if(setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getConstraint_ConstrainedElement()) {
				result.add(new UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.ConstraintConstrainedElement_4014, ConstraintConstrainedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Association_4001(Type source) {
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
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association)linkObject;
			if(AssociationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			//Papyrus GenCode 
			List targets = link.getEndTypes();
			Object theTarget = targets.size() >= 2 ? targets.get(1) : null;
			if(false == theTarget instanceof Type) {
				continue;
			}
			Type dst = (Type)theTarget;
			List sources = link.getEndTypes();


			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if(false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Association_4001, AssociationEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_ProfileApplication_1045(Package source) {
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
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getProfileApplications().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof ProfileApplication) {
				continue;
			}
			ProfileApplication link = (ProfileApplication)linkObject;
			if(ProfileApplicationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			Profile dst = link.getAppliedProfile();
			Package src = link.getApplyingPackage();
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.ProfileApplication_1045, ProfileApplicationEditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Association_4019(Type source) {
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
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association)linkObject;
			if(AssociationBranchEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			//Papyrus GenCode 
			List targets = link.getEndTypes();
			Object theTarget = targets.size() >= 2 ? targets.get(1) : null;
			if(false == theTarget instanceof Type) {
				continue;
			}
			Type dst = (Type)theTarget;
			List sources = link.getEndTypes();


			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if(false == theSource instanceof Type) {
				continue;
			}
			Type src = (Type)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Association_4019, AssociationBranchEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Dependency_4008(NamedElement source) {
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
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency)linkObject;
			if(DependencyEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();


			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4008, DependencyEditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Dependency_4018(NamedElement source) {
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
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency)linkObject;
			if(DependencyBranchEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if(false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement)theTarget;
			List sources = link.getClients();


			Object theSource = sources.size() >= 1 ? sources.get(0) : null;

			if(false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement)theSource;
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4018, DependencyBranchEditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_ElementImport_1064(Namespace source) {
		Namespace container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Namespace) {
				container = (Namespace)element;
			}
		}
		if(container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getElementImports().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof ElementImport) {
				continue;
			}
			ElementImport link = (ElementImport)linkObject;
			if(ElementImportEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			PackageableElement dst = link.getImportedElement();
			Namespace src = link.getImportingNamespace();
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.ElementImport_1064, ElementImportEditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_PackageImport_1065(Namespace source) {
		Namespace container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null && container == null; element = element.eContainer()) {
			if(element instanceof Namespace) {
				container = (Namespace)element;
			}
		}
		if(container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for(Iterator links = container.getPackageImports().iterator(); links.hasNext();) {
			EObject linkObject = (EObject)links.next();
			if(false == linkObject instanceof PackageImport) {
				continue;
			}
			PackageImport link = (PackageImport)linkObject;
			if(PackageImportEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}





			Package dst = link.getImportedPackage();
			Namespace src = link.getImportingNamespace();
			if(src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.PackageImport_1065, PackageImportEditPart.VISUAL_ID));


		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_1022(Comment source) {
		Collection result = new LinkedList();
		for(Iterator destinations = source.getAnnotatedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.CommentAnnotatedElement_1022, CommentAnnotatedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4014(Constraint source) {
		Collection result = new LinkedList();
		for(Iterator destinations = source.getConstrainedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element)destinations.next();
			result.add(new UMLLinkDescriptor(source, destination, UMLElementTypes.ConstraintConstrainedElement_4014, ConstraintConstrainedElementEditPart.VISUAL_ID));
		}
		return result;
	}

}
