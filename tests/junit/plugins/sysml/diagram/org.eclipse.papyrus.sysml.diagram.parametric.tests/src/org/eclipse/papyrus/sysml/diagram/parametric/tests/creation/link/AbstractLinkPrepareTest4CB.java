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
package org.eclipse.papyrus.sysml.diagram.parametric.tests.creation.link;

import static org.eclipse.papyrus.sysml.diagram.parametric.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.parametric.tests.utils.TestPrepareUtils.createGraphicalNode;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.diagram.parametric.provider.ElementTypes;
import org.eclipse.papyrus.sysml.diagram.parametric.tests.AbstractTest4CB;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.junit.BeforeClass;

/**
 * JUnit tests for link creation test (via palette tools).
 */
public class AbstractLinkPrepareTest4CB extends AbstractTest4CB {

	public static String toolID;
	
	// Custom nodes
	public static View diagramContainerSourceView, diagramContainerTargetView;
	
	// Custom child label nodes
	public static View constraintPropertySourceView, constraintPropertyTargetView;
	public static View constraintParameterSourceView, constraintParameterTargetView;
	public static View nestedConstraintPropertySourceView, nestedConstraintPropertyTargetView;
	public static View nestedConstraintParameterSourceView, nestedConstraintParameterTargetView;
	public static View partSourceView, partTargetView;
	public static View nestedPartSourceView, nestedPartTargetView;
	public static View referenceSourceView, referenceTargetView;
	public static View nestedReferenceSourceView, nestedReferenceTargetView;
	public static View valueSourceView, valueTargetView;
	public static View nestedValueSourceView, nestedValueTargetView;
		
	// Inherited nodes
	public static View commentSourceView, commentTargetView, commentCNSourceView, commentCNTargetView;
	public static View constraintSourceView, constraintTargetView, constraintCNSourceView, constraintCNTargetView;

	public static View partContainer1; // Its type block may be set encapsulated for testing purpose.
	public static View partContainer2; // Its type block may be set encapsulated for testing purpose.

	public static Map<View, Boolean> isCreationAllowed = new HashMap<View, Boolean>();

	public static View subNestedPartContainer1_1_1SourceView;

	public static View subNestedPartContainer1_2_1TargetView;

	public static View subNestedPartContainer1_1_1TargetView;

	public static View subNestedPartContainer1_1_2TargetView;

	public static View subNestedPropertyContainer1_1_1SourceView;

	public static View subNestedPropertyContainer1_1_1TargetView;

	public static View subNestedPropertyContainer1_2_1TargetView;

	public static View subNestedPropertyContainer1_1_2TargetView;

	public static View subNestedReferenceContainer1_1_1SourceView;

	public static View subNestedReferenceContainer1_1_1TargetView;

	public static View subNestedReferenceContainer1_2_1TargetView;

	public static View subNestedReferenceContainer1_1_2TargetView;

	public static View subNestedValueContainer1_1_1SourceView;

	public static View subNestedValueContainer1_1_1TargetView, subNestedValueContainer1_2_1TargetView, subNestedValueContainer1_1_2TargetView;

	public static View nestedPartContainer1_1;

	public static View nestedPartContainer2_1;

	public static View nestedPartContainer1_2;
	
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
		View constainerStructureView = ViewUtil.getChildBySemanticHint(container, SysMLGraphicalTypes.COMPARTMENT_SYSML_STRUCTURE_ID);
		// part in block (level = 1)
		partContainer1 = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, constainerStructureView);
		View partContainer1StructureView = ViewUtil.getChildBySemanticHint(partContainer1, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
		partContainer2 = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, constainerStructureView);
		View partContainer2StructureView = ViewUtil.getChildBySemanticHint(partContainer2, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
		
		
		nestedPartContainer1_1 = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partContainer1StructureView);
		nestedPartContainer2_1 = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partContainer1StructureView);
		nestedPartContainer1_2 = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partContainer2StructureView);
		
		// Prepare elements for link creation tests		
		diagramContainerSourceView = container;
		diagramContainerTargetView = container;
	
		// Prepare child nodes
		
		constraintPropertySourceView = createGraphicalNode(SysMLElementTypes.CONSTRAINT_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTBLOCKPROPERTY_AS_COMPOSITE_ID, constainerStructureView);
		constraintParameterSourceView = createGraphicalNode(UMLElementTypes.PROPERTY, UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_AFFIXED_ID, constraintPropertySourceView);

		constraintPropertyTargetView = createGraphicalNode(SysMLElementTypes.CONSTRAINT_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTBLOCKPROPERTY_AS_COMPOSITE_ID, constainerStructureView);
		constraintParameterTargetView = createGraphicalNode(UMLElementTypes.PROPERTY, UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_AFFIXED_ID, constraintPropertyTargetView);

		
		partSourceView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, constainerStructureView);
		partTargetView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, constainerStructureView);
		nestedPartSourceView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partContainer1StructureView);
		nestedPartTargetView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partContainer1StructureView);
		subNestedPartContainer1_1_1SourceView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer1_1);
		subNestedPartContainer1_1_1TargetView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer1_1);
		subNestedPartContainer1_2_1TargetView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer2_1);
		subNestedPartContainer1_1_2TargetView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer1_2);
	
		nestedConstraintPropertySourceView = createGraphicalNode(SysMLElementTypes.CONSTRAINT_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTBLOCKPROPERTY_AS_COMPOSITE_ID, partContainer1StructureView);
		nestedConstraintParameterSourceView = createGraphicalNode(UMLElementTypes.PROPERTY, UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_AFFIXED_ID, nestedConstraintPropertySourceView);
		nestedConstraintPropertyTargetView = createGraphicalNode(SysMLElementTypes.CONSTRAINT_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_CONSTRAINTBLOCKPROPERTY_AS_COMPOSITE_ID, partContainer2StructureView);
		nestedConstraintParameterTargetView = createGraphicalNode(UMLElementTypes.PROPERTY, UMLGraphicalTypes.SHAPE_UML_PROPERTY_AS_AFFIXED_ID, nestedConstraintPropertyTargetView);
	
		referenceSourceView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, constainerStructureView);
		referenceTargetView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, constainerStructureView);
		nestedReferenceSourceView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partContainer1StructureView);
		nestedReferenceTargetView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partContainer1StructureView);
		subNestedReferenceContainer1_1_1SourceView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer1_1);
		subNestedReferenceContainer1_1_1TargetView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer1_1);
		subNestedReferenceContainer1_2_1TargetView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer2_1);
		subNestedReferenceContainer1_1_2TargetView = createGraphicalNode(SysMLElementTypes.REFERENCE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer1_2);
		
		valueSourceView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, constainerStructureView);
		valueTargetView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, constainerStructureView);
		nestedValueSourceView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partContainer1StructureView);
		nestedValueTargetView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partContainer1StructureView);
		subNestedValueContainer1_1_1SourceView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer1_1);
		subNestedValueContainer1_1_1TargetView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer1_1);
		subNestedValueContainer1_2_1TargetView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer2_1);
		subNestedValueContainer1_1_2TargetView = createGraphicalNode(SysMLElementTypes.VALUE_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, nestedPartContainer1_2);
	}
}
