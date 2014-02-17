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
package org.eclipse.papyrus.uml.diagram.profile.part;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.AssociationBranchEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.AssociationNodeEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ClassOperationEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ClassPropertyEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ConstraintEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DataTypeAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DataTypeAttributeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DataTypeEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DataTypeEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DataTypeOperationCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DataTypeOperationCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DataTypeOperationEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DataTypePropertyEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DependencyBranchEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.DependencyNodeEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ElementImportEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.EnumerationEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.EnumerationEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.EnumerationEnumerationLiteralCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.EnumerationEnumerationLiteralCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.EnumerationLiteralEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ExtensionEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.MetaclassEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.MetaclassEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ModelEditPartTN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ModelPackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ModelPackageableElementCompartmentEditPartTN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.PackageImportEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.PackagePackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.PrimitiveTypeEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.PrimitiveTypeEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ProfileApplicationEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ProfileDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ProfileEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ProfileEditPartTN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ProfilePackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ProfilePackageableElementCompartmentEditPartTN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ShortCutDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.StereotypeAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.StereotypeAttributeCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.StereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.StereotypeEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.StereotypeOperationCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.StereotypeOperationCompartmentEditPartCN;
import org.eclipse.uml2.uml.Profile;

/**
 * @generated
 */
public class UMLDiagramContentInitializer {

	/**
	 * @generated
	 */
	private Map myDomain2NotationMap = new HashMap();

	/**
	 * @generated
	 */
	private Collection myLinkDescriptors = new LinkedList();

	/**
	 * @generated
	 */
	public void initDiagramContent(Diagram diagram) {
		if(!ProfileDiagramEditPart.MODEL_ID.equals(diagram.getType())) {
			UMLDiagramEditorPlugin.getInstance().logError("Incorrect diagram passed as a parameter: " + diagram.getType());
			return;
		}
		if(false == diagram.getElement() instanceof Profile) {
			UMLDiagramEditorPlugin.getInstance().logError("Incorrect diagram element specified: " + diagram.getElement() + " instead of Profile");
			return;
		}
		createProfile_1000Children(diagram);
		createLinks(diagram);
	}

	/**
	 * @generated
	 */
	private void createProfile_1000Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getProfile_1000SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createDependency_2014Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getDependency_2014OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createAssociation_2015Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getAssociation_2015OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createStereotype_1026Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getStereotype_1026OutgoingLinks(view));
		createStereotypeAttributes_1071Children(getCompartment(view, StereotypeAttributeCompartmentEditPart.VISUAL_ID));
		createStereotypeOperations_1019Children(getCompartment(view, StereotypeOperationCompartmentEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createClass_1031Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getClass_1031OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createComment_1002Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getComment_1002OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createConstraint_1014Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getConstraint_1014OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createModel_2005Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getModel_2005OutgoingLinks(view));
		createModelPackagedelements_1057Children(getCompartment(view, ModelPackageableElementCompartmentEditPartTN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createProfile_1030Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getProfile_1030OutgoingLinks(view));
		createProfilePackagedelements_1042Children(getCompartment(view, ProfilePackageableElementCompartmentEditPartTN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createPackage_2007Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getPackage_2007OutgoingLinks(view));
		createPackagePackagedelements_1005Children(getCompartment(view, PackagePackageableElementCompartmentEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createEnumeration_2006Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getEnumeration_2006OutgoingLinks(view));
		createEnumerationLiterals_1063Children(getCompartment(view, EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createPrimitiveType_2009Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getPrimitiveType_2009OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createDataType_2010Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getDataType_2010OutgoingLinks(view));
		createDataTypeAttributes_1067Children(getCompartment(view, DataTypeAttributeCompartmentEditPart.VISUAL_ID));
		createDataTypeOperations_1068Children(getCompartment(view, DataTypeOperationCompartmentEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createDiagram_2016Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getDiagram_2016OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createPrimitiveType_3026Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getPrimitiveType_3026OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createOperation_3019Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getOperation_3019OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createEnumerationLiteral_1037Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getEnumerationLiteral_1037OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createProperty_3018Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getProperty_3018OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createProperty_3002Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getProperty_3002OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createOperation_3020Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getOperation_3020OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createStereotype_1023Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getStereotype_1023OutgoingLinks(view));
		createStereotypeAttributes_1052Children(getCompartment(view, StereotypeAttributeCompartmentEditPartCN.VISUAL_ID));
		createStereotypeOperations_1053Children(getCompartment(view, StereotypeOperationCompartmentEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createClass_3028Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getClass_3028OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createComment_1007Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getComment_1007OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createModel_1027Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getModel_1027OutgoingLinks(view));
		createModelPackagedelements_1058Children(getCompartment(view, ModelPackageableElementCompartmentEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createProfile_1024Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getProfile_1024OutgoingLinks(view));
		createProfilePackagedelements_1051Children(getCompartment(view, ProfilePackageableElementCompartmentEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createPackage_1012Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getPackage_1012OutgoingLinks(view));
		Collection childNodeDescriptors = UMLDiagramUpdater.getPackage_1012SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
		createPackagePackagedelements_11Children(getCompartment(view, PackagePackageableElementCompartmentEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createConstraint_1028Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getConstraint_1028OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createEnumeration_3025Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getEnumeration_3025OutgoingLinks(view));
		createEnumerationLiterals_1062Children(getCompartment(view, EnumerationEnumerationLiteralCompartmentEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createDataType_3027Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getDataType_3027OutgoingLinks(view));
		createDataTypeAttributes_1069Children(getCompartment(view, DataTypeAttributeCompartmentEditPartCN.VISUAL_ID));
		createDataTypeOperations_1070Children(getCompartment(view, DataTypeOperationCompartmentEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createPackagePackagedelements_1005Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getPackagePackagedelements_1005SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createPackagePackagedelements_11Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getPackagePackagedelements_11SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createProfilePackagedelements_1042Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getProfilePackagedelements_1042SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createProfilePackagedelements_1051Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getProfilePackagedelements_1051SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createStereotypeAttributes_1071Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getStereotypeAttributes_1071SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createStereotypeAttributes_1052Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getStereotypeAttributes_1052SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createStereotypeOperations_1019Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getStereotypeOperations_1019SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createStereotypeOperations_1053Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getStereotypeOperations_1053SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createModelPackagedelements_1057Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getModelPackagedelements_1057SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createModelPackagedelements_1058Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getModelPackagedelements_1058SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createEnumerationLiterals_1062Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getEnumerationLiterals_1062SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createEnumerationLiterals_1063Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getEnumerationLiterals_1063SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createDataTypeAttributes_1067Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getDataTypeAttributes_1067SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createDataTypeAttributes_1069Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getDataTypeAttributes_1069SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createDataTypeOperations_1068Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getDataTypeOperations_1068SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createDataTypeOperations_1070Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getDataTypeOperations_1070SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createNode(View parentView, UMLNodeDescriptor nodeDescriptor) {
		final String nodeType = UMLVisualIDRegistry.getType(nodeDescriptor.getVisualID());
		Node node = ViewService.createNode(parentView, nodeDescriptor.getModelElement(), nodeType, UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
		switch(nodeDescriptor.getVisualID()) {
		case DependencyNodeEditPart.VISUAL_ID:
			createDependency_2014Children(node);
			return;
		case AssociationNodeEditPart.VISUAL_ID:
			createAssociation_2015Children(node);
			return;
		case StereotypeEditPart.VISUAL_ID:
			createStereotype_1026Children(node);
			return;
		case MetaclassEditPart.VISUAL_ID:
			createClass_1031Children(node);
			return;
		case CommentEditPart.VISUAL_ID:
			createComment_1002Children(node);
			return;
		case ConstraintEditPart.VISUAL_ID:
			createConstraint_1014Children(node);
			return;
		case ModelEditPartTN.VISUAL_ID:
			createModel_2005Children(node);
			return;
		case ProfileEditPartTN.VISUAL_ID:
			createProfile_1030Children(node);
			return;
		case PackageEditPart.VISUAL_ID:
			createPackage_2007Children(node);
			return;
		case EnumerationEditPart.VISUAL_ID:
			createEnumeration_2006Children(node);
			return;
		case PrimitiveTypeEditPart.VISUAL_ID:
			createPrimitiveType_2009Children(node);
			return;
		case DataTypeEditPart.VISUAL_ID:
			createDataType_2010Children(node);
			return;
		case ShortCutDiagramEditPart.VISUAL_ID:
			createDiagram_2016Children(node);
			return;
		case PrimitiveTypeEditPartCN.VISUAL_ID:
			createPrimitiveType_3026Children(node);
			return;
		case DataTypeOperationEditPart.VISUAL_ID:
			createOperation_3019Children(node);
			return;
		case EnumerationLiteralEditPart.VISUAL_ID:
			createEnumerationLiteral_1037Children(node);
			return;
		case DataTypePropertyEditPart.VISUAL_ID:
			createProperty_3018Children(node);
			return;
		case ClassPropertyEditPart.VISUAL_ID:
			createProperty_3002Children(node);
			return;
		case ClassOperationEditPart.VISUAL_ID:
			createOperation_3020Children(node);
			return;
		case StereotypeEditPartCN.VISUAL_ID:
			createStereotype_1023Children(node);
			return;
		case MetaclassEditPartCN.VISUAL_ID:
			createClass_3028Children(node);
			return;
		case CommentEditPartCN.VISUAL_ID:
			createComment_1007Children(node);
			return;
		case ModelEditPartCN.VISUAL_ID:
			createModel_1027Children(node);
			return;
		case ProfileEditPartCN.VISUAL_ID:
			createProfile_1024Children(node);
			return;
		case PackageEditPartCN.VISUAL_ID:
			createPackage_1012Children(node);
			return;
		case ConstraintEditPartCN.VISUAL_ID:
			createConstraint_1028Children(node);
			return;
		case EnumerationEditPartCN.VISUAL_ID:
			createEnumeration_3025Children(node);
			return;
		case DataTypeEditPartCN.VISUAL_ID:
			createDataType_3027Children(node);
			return;
		}
	}

	/**
	 * @generated
	 */
	private void createLinks(Diagram diagram) {
		for(boolean continueLinkCreation = true; continueLinkCreation;) {
			continueLinkCreation = false;
			Collection additionalDescriptors = new LinkedList();
			for(Iterator it = myLinkDescriptors.iterator(); it.hasNext();) {
				UMLLinkDescriptor nextLinkDescriptor = (UMLLinkDescriptor)it.next();
				if(!myDomain2NotationMap.containsKey(nextLinkDescriptor.getSource()) || !myDomain2NotationMap.containsKey(nextLinkDescriptor.getDestination())) {
					continue;
				}
				final String linkType = UMLVisualIDRegistry.getType(nextLinkDescriptor.getVisualID());
				Edge edge = ViewService.getInstance().createEdge(nextLinkDescriptor.getSemanticAdapter(), diagram, linkType, ViewUtil.APPEND, true, UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				if(edge != null) {
					edge.setSource((View)myDomain2NotationMap.get(nextLinkDescriptor.getSource()));
					edge.setTarget((View)myDomain2NotationMap.get(nextLinkDescriptor.getDestination()));
					it.remove();
					if(nextLinkDescriptor.getModelElement() != null) {
						myDomain2NotationMap.put(nextLinkDescriptor.getModelElement(), edge);
					}
					continueLinkCreation = true;
					switch(nextLinkDescriptor.getVisualID()) {
					case ExtensionEditPart.VISUAL_ID:
						additionalDescriptors.addAll(UMLDiagramUpdater.getExtension_1013OutgoingLinks(edge));
						break;
					case AssociationEditPart.VISUAL_ID:
						additionalDescriptors.addAll(UMLDiagramUpdater.getAssociation_4001OutgoingLinks(edge));
						break;
					case ProfileApplicationEditPart.VISUAL_ID:
						additionalDescriptors.addAll(UMLDiagramUpdater.getProfileApplication_1045OutgoingLinks(edge));
						break;
					case AssociationBranchEditPart.VISUAL_ID:
						additionalDescriptors.addAll(UMLDiagramUpdater.getAssociation_4019OutgoingLinks(edge));
						break;
					case GeneralizationEditPart.VISUAL_ID:
						additionalDescriptors.addAll(UMLDiagramUpdater.getGeneralization_4002OutgoingLinks(edge));
						break;
					case DependencyEditPart.VISUAL_ID:
						additionalDescriptors.addAll(UMLDiagramUpdater.getDependency_4008OutgoingLinks(edge));
						break;
					case DependencyBranchEditPart.VISUAL_ID:
						additionalDescriptors.addAll(UMLDiagramUpdater.getDependency_4018OutgoingLinks(edge));
						break;
					case ElementImportEditPart.VISUAL_ID:
						additionalDescriptors.addAll(UMLDiagramUpdater.getElementImport_1064OutgoingLinks(edge));
						break;
					case PackageImportEditPart.VISUAL_ID:
						additionalDescriptors.addAll(UMLDiagramUpdater.getPackageImport_1065OutgoingLinks(edge));
						break;
					}
				}
			}
			myLinkDescriptors.addAll(additionalDescriptors);
		}
	}

	/**
	 * @generated
	 */
	private Node getCompartment(View node, int visualID) {
		String type = UMLVisualIDRegistry.getType(visualID);
		for(Iterator it = node.getChildren().iterator(); it.hasNext();) {
			View nextView = (View)it.next();
			if(nextView instanceof Node && type.equals(nextView.getType())) {
				return (Node)nextView;
			}
		}
		return null;
	}
}
