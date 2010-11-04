/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.provider;

import static org.eclipse.papyrus.core.Activator.log;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationClassEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationNodeEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Class2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Class3EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Class5EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassifierTemplateParameterEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Comment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ComponentEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ConnectableElementTemplateParameterEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Constraint2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ContainmentCircleEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DataTypeEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DataTypeEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DefaultNamedElementEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Dependency2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DurationObservationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.EnumerationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.EnumerationEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.EnumerationLiteralEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InstanceSpecificationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InstanceSpecificationEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPartTN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Operation2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Operation3EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Operation4EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.OperationEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.OperationTemplateParameterEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PrimitiveTypeEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PrimitiveTypeEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Property2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Property3EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Property4EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Property5EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PropertyEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ReceptionEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.RedefinableTemplateSignatureEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ShapeNamedElementEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ShortCutDiagramEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.SignalEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.SignalEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.SlotEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.TemplateParameterEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.TemplateSignatureEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.TimeObservationEditPart;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.clazz.providers.UMLViewProvider;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.part.BlockDefinitionDiagramEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.part.BlockDefinitionDiagramVisualIDRegistry;
import org.eclipse.uml2.uml.NamedElement;

public class InheritedClassDiagramElementViewProvider extends UMLViewProvider {

	@Override
	public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		Edge createdEdge = super.createEdge(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);

		if(createdEdge == null) {
			log.error(new Exception("Could not create Edge."));
		}

		return createdEdge;
	}

	@Override
	protected boolean provides(CreateEdgeViewOperation op) {

		// Must have a container
		if(op.getContainerView() == null) {
			return false;
		}

		// This provider is registered for Block Definition Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if(!BlockDefinitionDiagramEditPart.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		if((elementType == BlockDefinitionDiagramElementTypes.DEPENDENCY) || (elementType == BlockDefinitionDiagramElementTypes.USAGE) || (elementType == BlockDefinitionDiagramElementTypes.INTERFACE_REALIZATION) || (elementType == BlockDefinitionDiagramElementTypes.ASSOCIATION) || (elementType == BlockDefinitionDiagramElementTypes.ASSOCIATION_CLASS_EDGE) || (elementType == BlockDefinitionDiagramElementTypes.ASSOCIATION_CLASS_LINK) || (elementType == BlockDefinitionDiagramElementTypes.GENERALIZATION) || (elementType == BlockDefinitionDiagramElementTypes.GENERALIZATION_SET) || (elementType == BlockDefinitionDiagramElementTypes.COMMENT_LINK) || (elementType == BlockDefinitionDiagramElementTypes.CONSTRAINT_LINK) || (elementType == BlockDefinitionDiagramElementTypes.CONTAINMENT_LINK) || (elementType == BlockDefinitionDiagramElementTypes.CONTAINMENT_ADDED_LINK)) {

			return true;
		}

		return false;
	}

	@Override
	protected boolean provides(CreateNodeViewOperation op) {

		// Must have a container
		if(op.getContainerView() == null) {
			return false;
		}

		// This provider is registered for Block Definition Diagram only
		String diagramType = op.getContainerView().getDiagram().getType();
		if(!BlockDefinitionDiagramEditPart.DIAGRAM_ID.equals(diagramType)) {
			return false;
		}

		IElementType elementType = (IElementType)op.getSemanticAdapter().getAdapter(IElementType.class);

		EObject eobject = (EObject)op.getSemanticAdapter().getAdapter(EObject.class);
		if(eobject instanceof NamedElement) {
			return true;
		}

		return InheritedClassDiagramElementViewProvider.provides(elementType);
	}
	
	public static boolean provides(IElementType elementType) {
		if((elementType == BlockDefinitionDiagramElementTypes.PACKAGE) || (elementType == BlockDefinitionDiagramElementTypes.PACKAGE_CN)

				|| (elementType == BlockDefinitionDiagramElementTypes.MODEL) || (elementType == BlockDefinitionDiagramElementTypes.MODEL_CN)

				|| (elementType == BlockDefinitionDiagramElementTypes.CLASS) || (elementType == BlockDefinitionDiagramElementTypes.CLASS_CN) || (elementType == BlockDefinitionDiagramElementTypes.CLASS_PROP_CLN) || (elementType == BlockDefinitionDiagramElementTypes.CLASS_OPER_CLN) || (elementType == BlockDefinitionDiagramElementTypes.CLASS_RECP_CLN) || (elementType == BlockDefinitionDiagramElementTypes.CLASS_NEST_CLN)

				|| (elementType == BlockDefinitionDiagramElementTypes.INTERFACE) || (elementType == BlockDefinitionDiagramElementTypes.INTERFACE_CN) || (elementType == BlockDefinitionDiagramElementTypes.INTERFACE_PROP_CLN) || (elementType == BlockDefinitionDiagramElementTypes.INTERFACE_OPER_CLN) || (elementType == BlockDefinitionDiagramElementTypes.INTERFACE_NEST_CLN)

				|| (elementType == BlockDefinitionDiagramElementTypes.PRIMITIVETYPE) || (elementType == BlockDefinitionDiagramElementTypes.PRIMITIVETYPE_CN)

				|| (elementType == BlockDefinitionDiagramElementTypes.ENUMERATION) || (elementType == BlockDefinitionDiagramElementTypes.ENUMERATION_CN) || (elementType == BlockDefinitionDiagramElementTypes.ENUMERATION_LITERAL_CLN)

				|| (elementType == BlockDefinitionDiagramElementTypes.DATATYPE) || (elementType == BlockDefinitionDiagramElementTypes.DATATYPE_CN) || (elementType == BlockDefinitionDiagramElementTypes.DATATYPE_PROP_CLN) || (elementType == BlockDefinitionDiagramElementTypes.DATATYPE_OPER_CLN)

				|| (elementType == BlockDefinitionDiagramElementTypes.INSTANCE_SPECIFICATION) || (elementType == BlockDefinitionDiagramElementTypes.INSTANCE_SPEC_CN) || (elementType == BlockDefinitionDiagramElementTypes.INSTANCE_SPEC_SLOT_CLN)

				|| (elementType == BlockDefinitionDiagramElementTypes.ASSOCIATION_CLASS) || (elementType == BlockDefinitionDiagramElementTypes.ASSOCIATION_CLASS_PROP_CLN) || (elementType == BlockDefinitionDiagramElementTypes.ASSOCIATION_CLASS_OPER_CLN) || (elementType == BlockDefinitionDiagramElementTypes.ASSOCIATION_CLASS_NEST_CLN)

				|| (elementType == BlockDefinitionDiagramElementTypes.COMMENT) || (elementType == BlockDefinitionDiagramElementTypes.COMMENT_CN)

				|| (elementType == BlockDefinitionDiagramElementTypes.CONSTRAINT) || (elementType == BlockDefinitionDiagramElementTypes.CONSTRAINT_CN)

				|| (elementType == BlockDefinitionDiagramElementTypes.CONTAINMENT_CIRCLE)) {
					return true;
				}
		return false;
	}

	public Node createNode(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		final EObject domainElement = getSemanticElement(semanticAdapter);
		final int visualID;
		if(semanticHint == null) {
			semanticHint = BlockDefinitionDiagramVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		} 
		
		visualID = UMLVisualIDRegistry.getVisualID(semanticHint);
		
		switch(visualID) {
		case Dependency2EditPart.VISUAL_ID:
			return createDependency_2014(domainElement, containerView, index, persisted, preferencesHint);
		case AssociationClassEditPart.VISUAL_ID:
			return createAssociationClass_2013(domainElement, containerView, index, persisted, preferencesHint);
		case AssociationNodeEditPart.VISUAL_ID:
			return createAssociation_2015(domainElement, containerView, index, persisted, preferencesHint);
		case InstanceSpecificationEditPart.VISUAL_ID:
			return createInstanceSpecification_2001(domainElement, containerView, index, persisted, preferencesHint);
		case ComponentEditPart.VISUAL_ID:
			return createComponent_2002(domainElement, containerView, index, persisted, preferencesHint);
		case SignalEditPart.VISUAL_ID:
			return createSignal_2003(domainElement, containerView, index, persisted, preferencesHint);
		case InterfaceEditPart.VISUAL_ID:
			return createInterface_2004(domainElement, containerView, index, persisted, preferencesHint);
		case ModelEditPartTN.VISUAL_ID:
			return createModel_2005(domainElement, containerView, index, persisted, preferencesHint);
		case EnumerationEditPart.VISUAL_ID:
			return createEnumeration_2006(domainElement, containerView, index, persisted, preferencesHint);
		case PackageEditPart.VISUAL_ID:
			return createPackage_2007(domainElement, containerView, index, persisted, preferencesHint);
		case ClassEditPart.VISUAL_ID:
			return createClass_2008(domainElement, containerView, index, persisted, preferencesHint);
		case PrimitiveTypeEditPart.VISUAL_ID:
			return createPrimitiveType_2009(domainElement, containerView, index, persisted, preferencesHint);
		case DataTypeEditPart.VISUAL_ID:
			return createDataType_2010(domainElement, containerView, index, persisted, preferencesHint);
		case ConstraintEditPart.VISUAL_ID:
			return createConstraint_2011(domainElement, containerView, index, persisted, preferencesHint);
		case CommentEditPart.VISUAL_ID:
			return createComment_2012(domainElement, containerView, index, persisted, preferencesHint);
		case ShortCutDiagramEditPart.VISUAL_ID:
			return createDiagram_2016(domainElement, containerView, index, persisted, preferencesHint);
		case DurationObservationEditPart.VISUAL_ID:
			return createDurationObservation_2095(domainElement, containerView, index, persisted, preferencesHint);
		case TimeObservationEditPart.VISUAL_ID:
			return createTimeObservation_2096(domainElement, containerView, index, persisted, preferencesHint);
		case DefaultNamedElementEditPart.VISUAL_ID:
			return createNamedElement_2097(domainElement, containerView, index, persisted, preferencesHint);
		case ShapeNamedElementEditPart.VISUAL_ID:
			return createNamedElement_2098(domainElement, containerView, index, persisted, preferencesHint);
		case PropertyEditPart.VISUAL_ID:
			return createProperty_3002(domainElement, containerView, index, persisted, preferencesHint);
		case OperationEditPart.VISUAL_ID:
			return createOperation_3003(domainElement, containerView, index, persisted, preferencesHint);
		case Class2EditPart.VISUAL_ID:
			return createClass_3004(domainElement, containerView, index, persisted, preferencesHint);
		case RedefinableTemplateSignatureEditPart.VISUAL_ID:
			return createRedefinableTemplateSignature_3015(domainElement, containerView, index, persisted, preferencesHint);
		case ConnectableElementTemplateParameterEditPart.VISUAL_ID:
			return createConnectableElementTemplateParameter_3034(domainElement, containerView, index, persisted, preferencesHint);
		case OperationTemplateParameterEditPart.VISUAL_ID:
			return createOperationTemplateParameter_3035(domainElement, containerView, index, persisted, preferencesHint);
		case ClassifierTemplateParameterEditPart.VISUAL_ID:
			return createClassifierTemplateParameter_3031(domainElement, containerView, index, persisted, preferencesHint);
		case TemplateParameterEditPart.VISUAL_ID:
			return createTemplateParameter_3016(domainElement, containerView, index, persisted, preferencesHint);
		case Property2EditPart.VISUAL_ID:
			return createProperty_3005(domainElement, containerView, index, persisted, preferencesHint);
		case Property3EditPart.VISUAL_ID:
			return createProperty_3006(domainElement, containerView, index, persisted, preferencesHint);
		case Operation2EditPart.VISUAL_ID:
			return createOperation_3007(domainElement, containerView, index, persisted, preferencesHint);
		case Class3EditPart.VISUAL_ID:
			return createClass_3008(domainElement, containerView, index, persisted, preferencesHint);
		case InstanceSpecificationEditPartCN.VISUAL_ID:
			return createInstanceSpecification_3020(domainElement, containerView, index, persisted, preferencesHint);
		case ComponentEditPartCN.VISUAL_ID:
			return createComponent_3021(domainElement, containerView, index, persisted, preferencesHint);
		case SignalEditPartCN.VISUAL_ID:
			return createSignal_3022(domainElement, containerView, index, persisted, preferencesHint);
		case InterfaceEditPartCN.VISUAL_ID:
			return createInterface_3023(domainElement, containerView, index, persisted, preferencesHint);
		case ModelEditPartCN.VISUAL_ID:
			return createModel_3024(domainElement, containerView, index, persisted, preferencesHint);
		case EnumerationEditPartCN.VISUAL_ID:
			return createEnumeration_3025(domainElement, containerView, index, persisted, preferencesHint);
		case EnumerationLiteralEditPart.VISUAL_ID:
			return createEnumerationLiteral_3017(domainElement, containerView, index, persisted, preferencesHint);
		case PackageEditPartCN.VISUAL_ID:
			return createPackage_3009(domainElement, containerView, index, persisted, preferencesHint);
		case ClassEditPartCN.VISUAL_ID:
			return createClass_3010(domainElement, containerView, index, persisted, preferencesHint);
		case ReceptionEditPart.VISUAL_ID:
			return createReception_3011(domainElement, containerView, index, persisted, preferencesHint);
		case Property4EditPart.VISUAL_ID:
			return createProperty_3012(domainElement, containerView, index, persisted, preferencesHint);
		case Operation3EditPart.VISUAL_ID:
			return createOperation_3013(domainElement, containerView, index, persisted, preferencesHint);
		case Class5EditPart.VISUAL_ID:
			return createClass_3014(domainElement, containerView, index, persisted, preferencesHint);
		case PrimitiveTypeEditPartCN.VISUAL_ID:
			return createPrimitiveType_3026(domainElement, containerView, index, persisted, preferencesHint);
		case DataTypeEditPartCN.VISUAL_ID:
			return createDataType_3027(domainElement, containerView, index, persisted, preferencesHint);
		case Property5EditPart.VISUAL_ID:
			return createProperty_3018(domainElement, containerView, index, persisted, preferencesHint);
		case Operation4EditPart.VISUAL_ID:
			return createOperation_3019(domainElement, containerView, index, persisted, preferencesHint);
		case Comment2EditPart.VISUAL_ID:
			return createComment_3028(domainElement, containerView, index, persisted, preferencesHint);
		case Constraint2EditPart.VISUAL_ID:
			return createConstraint_3029(domainElement, containerView, index, persisted, preferencesHint);
		case SlotEditPart.VISUAL_ID:
			return createSlot_3030(domainElement, containerView, index, persisted, preferencesHint);
		case ContainmentCircleEditPart.VISUAL_ID:
			return createPort_3032(domainElement, containerView, index, persisted, preferencesHint);
		case TemplateSignatureEditPart.VISUAL_ID:
			return createTemplateSignature_3033(domainElement, containerView, index, persisted, preferencesHint);
		}
		// can't happen, provided #provides(CreateNodeViewOperation) is correct
		return null;
	}

	@Override
	protected void stampShortcut(View containerView, Node target) {
		if(!BlockDefinitionDiagramEditPart.DIAGRAM_ID.equals(UMLVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", BlockDefinitionDiagramEditPart.DIAGRAM_ID); //$NON-NLS-1$
			target.getEAnnotations().add(shortcutAnnotation);
		}
	}
}
