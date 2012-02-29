/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link;

import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestPrepareUtils.createGraphicalNode;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.diagram.internalblock.provider.ElementTypes;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.AbstractTest;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.BeforeClass;

/**
 * JUnit tests for link creation test (via palette tools).
 */
public class AbstractLinkPrepareTest extends AbstractTest {

	public static String toolID;
	
	// Custom nodes
	public static View blockSourceView, blockTargetView;

	// Custom child label nodes
	public static View actorPartSourceView, actorPartTargetView;
	public static View nestedActorPartSourceView, nestedActorPartTargetView;
	public static View portOnBlockSourceView, portOnBlockTargetView;
	public static View portOnPartSourceView, portOnPartTargetView;
	public static View portOnNestedPartSourceView, portOnNestedPartTargetView;
	public static View flowportOnBlockSourceView, flowportOnBlockTargetView;
	public static View flowportOnPartSourceView, flowportOnPartTargetView;
	public static View flowportOnNestedPartSourceView, flowportOnNestedPartTargetView;
	public static View partSourceView, partTargetView;
	public static View nestedPartSourceView, nestedPartTargetView;
	public static View propertySourceView, propertyTargetView;
	public static View nestedPropertySourceView, nestedPropertyTargetView;
	public static View referenceSourceView, referenceTargetView;
	public static View nestedReferenceSourceView, nestedReferenceTargetView;
	public static View valueSourceView, valueTargetView;
	public static View nestedValueSourceView, nestedValueTargetView;
		
	// Inherited nodes
	public static View commentSourceView, commentTargetView, commentCNSourceView, commentCNTargetView;
	public static View constraintSourceView, constraintTargetView, constraintCNSourceView, constraintCNTargetView;

	public static View partContainer; // Its type block may be set encapsulated for testing purpose.

	public static Map<View, Boolean> isCreationAllowed = new HashMap<View, Boolean>();
	
	@BeforeClass
	public static void prepareInheritedNodes() throws Exception {
		View container = ViewUtil.getChildBySemanticHint(getDiagramView(), SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID);
		View containerCpt = ViewUtil.getChildBySemanticHint(container, SysMLGraphicalTypes.COMPARTMENT_SYSML_STRUCTURE_ID);
		
		// Prepare elements for link creation tests		
		commentSourceView = createGraphicalNode(UMLElementTypes.COMMENT, ElementTypes.COMMENT.getSemanticHint(), getDiagramView());
		commentTargetView = createGraphicalNode(UMLElementTypes.COMMENT, ElementTypes.COMMENT.getSemanticHint(), getDiagramView());
		commentCNSourceView = createGraphicalNode(UMLElementTypes.COMMENT, ElementTypes.COMMENT_CN.getSemanticHint(), containerCpt);
		commentCNTargetView = createGraphicalNode(UMLElementTypes.COMMENT, ElementTypes.COMMENT_CN.getSemanticHint(), containerCpt);
	
		constraintSourceView = createGraphicalNode(UMLElementTypes.CONSTRAINT, ElementTypes.CONSTRAINT.getSemanticHint(), getDiagramView());
		constraintTargetView = createGraphicalNode(UMLElementTypes.CONSTRAINT, ElementTypes.CONSTRAINT.getSemanticHint(), getDiagramView());
		constraintCNSourceView = createGraphicalNode(UMLElementTypes.CONSTRAINT, ElementTypes.CONSTRAINT_CN.getSemanticHint(), containerCpt);
		constraintCNTargetView = createGraphicalNode(UMLElementTypes.CONSTRAINT, ElementTypes.CONSTRAINT_CN.getSemanticHint(), containerCpt);
	}
	
	@BeforeClass
	public static void prepareCustomNodes() throws Exception {
		View container = ViewUtil.getChildBySemanticHint(getDiagramView(), SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID);
		View blockStructureView = ViewUtil.getChildBySemanticHint(container, SysMLGraphicalTypes.COMPARTMENT_SYSML_STRUCTURE_ID);
		partContainer = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		View partStructureView = ViewUtil.getChildBySemanticHint(partContainer, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
		View nestedPartContainer = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_NESTEDBLOCKPROPERTY_AS_COMPOSITE_ID, partStructureView);

		// Prepare elements for link creation tests		

		blockSourceView = container;
		blockTargetView = container;
	
		// Prepare child nodes
		
		actorPartSourceView = createGraphicalNode(SysMLElementTypes.ACTOR_PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		actorPartTargetView = createGraphicalNode(SysMLElementTypes.ACTOR_PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		nestedActorPartSourceView = createGraphicalNode(SysMLElementTypes.ACTOR_PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_NESTEDBLOCKPROPERTY_AS_COMPOSITE_ID, partStructureView);
		nestedActorPartTargetView = createGraphicalNode(SysMLElementTypes.ACTOR_PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_NESTEDBLOCKPROPERTY_AS_COMPOSITE_ID, partStructureView);

		// Port & FlowPorts no distinction made on FlowPorts kind...
		portOnBlockSourceView = createGraphicalNode(UMLElementTypes.PORT, UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, container);
		portOnBlockTargetView = createGraphicalNode(UMLElementTypes.PORT, UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, container);
		portOnPartSourceView = createGraphicalNode(UMLElementTypes.PORT, (EObject)partContainer.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, partContainer);;
		portOnPartTargetView = createGraphicalNode(UMLElementTypes.PORT, (EObject)partContainer.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, partContainer);;
		portOnNestedPartSourceView = createGraphicalNode(UMLElementTypes.PORT, (EObject)nestedPartContainer.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, nestedPartContainer);;
		portOnNestedPartTargetView = createGraphicalNode(UMLElementTypes.PORT, (EObject)nestedPartContainer.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, nestedPartContainer);;

		flowportOnBlockSourceView = createGraphicalNode(SysMLElementTypes.FLOW_PORT, SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, container);
		flowportOnBlockTargetView = createGraphicalNode(SysMLElementTypes.FLOW_PORT, SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, container);
		flowportOnPartSourceView = createGraphicalNode(SysMLElementTypes.FLOW_PORT, (EObject)partContainer.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, partContainer);;
		flowportOnPartTargetView = createGraphicalNode(SysMLElementTypes.FLOW_PORT, (EObject)partContainer.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, partContainer);;
		flowportOnNestedPartSourceView = createGraphicalNode(SysMLElementTypes.FLOW_PORT, (EObject)nestedPartContainer.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, nestedPartContainer);;
		flowportOnNestedPartTargetView = createGraphicalNode(SysMLElementTypes.FLOW_PORT, (EObject)nestedPartContainer.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), SysMLGraphicalTypes.SHAPE_SYSML_FLOWPORT_AS_AFFIXED_ID, nestedPartContainer);;
		
		partSourceView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		partTargetView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		nestedPartSourceView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_NESTEDBLOCKPROPERTY_AS_COMPOSITE_ID, partStructureView);
		nestedPartTargetView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_NESTEDBLOCKPROPERTY_AS_COMPOSITE_ID, partStructureView);
		
		propertySourceView = createGraphicalNode(UMLElementTypes.PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		propertyTargetView = createGraphicalNode(UMLElementTypes.PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		nestedPropertySourceView = createGraphicalNode(UMLElementTypes.PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_NESTEDBLOCKPROPERTY_AS_COMPOSITE_ID, partStructureView);
		nestedPropertyTargetView = createGraphicalNode(UMLElementTypes.PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_NESTEDBLOCKPROPERTY_AS_COMPOSITE_ID, partStructureView);
		
		referenceSourceView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		referenceTargetView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		nestedReferenceSourceView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_NESTEDBLOCKPROPERTY_AS_COMPOSITE_ID, partStructureView);
		nestedReferenceTargetView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_NESTEDBLOCKPROPERTY_AS_COMPOSITE_ID, partStructureView);
		
		valueSourceView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		valueTargetView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		nestedValueSourceView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_NESTEDBLOCKPROPERTY_AS_COMPOSITE_ID, partStructureView);
		nestedValueTargetView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_NESTEDBLOCKPROPERTY_AS_COMPOSITE_ID, partStructureView);
	}
}