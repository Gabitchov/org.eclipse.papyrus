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
package org.eclipse.papyrus.sysml.diagram.internalblock.tests.reorient.dependency;

import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestPrepareUtils.createGraphicalNode;

import java.util.HashMap;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.reorient.AbstractLinkReorientTargetTest;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.EditorUtils;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestPrepareUtils;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.junit.BeforeClass;

/**
 * JUnit tests for Dependency re-orient.
 */
public class TestLinkReorientTargetDependency extends AbstractLinkReorientTargetTest {
	
	@BeforeClass
	public static void initRelationship() throws Exception {
		
		// Prepare source and target
		View container = ViewUtil.getChildBySemanticHint(getDiagramView(), SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID);
		View blockStructureView = ViewUtil.getChildBySemanticHint(container, SysMLGraphicalTypes.COMPARTMENT_SYSML_STRUCTURE_ID);
		View actorPartSourceView = createGraphicalNode(SysMLElementTypes.ACTOR_PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		View actorPartTargetView = createGraphicalNode(SysMLElementTypes.ACTOR_PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);

		// Prepare relationship
		relationshipView = TestPrepareUtils.createGraphicalLink(
			UMLElementTypes.DEPENDENCY, 
			UMLGraphicalTypes.LINK_UML_DEPENDENCY_ID, 
			container, 
			EditorUtils.getEditPart(actorPartSourceView), 
			EditorUtils.getEditPart(actorPartTargetView));
	}	
	
	@BeforeClass
	public static void initExpectedResults() throws Exception {
		
		// Initialize source creation results
		isReorientAllowed = new HashMap<View, Boolean>();
		
		isReorientAllowed.put(getDiagramView(), false);

		isReorientAllowed.put(blockTargetView, true);
		
		isReorientAllowed.put(actorPartTargetView, true);
		isReorientAllowed.put(nestedActorPartTargetView, true);
		
		isReorientAllowed.put(portOnBlockTargetView, true);
		isReorientAllowed.put(portOnPartTargetView, true);
		isReorientAllowed.put(portOnNestedPartTargetView, true);
		
		isReorientAllowed.put(flowportOnBlockTargetView, true);
		isReorientAllowed.put(flowportOnPartTargetView, true);
		isReorientAllowed.put(flowportOnNestedPartTargetView, true);
		
		isReorientAllowed.put(partTargetView, true);
		isReorientAllowed.put(nestedPartTargetView, true);
		
		isReorientAllowed.put(propertyTargetView, true);
		isReorientAllowed.put(nestedPropertyTargetView, true);
		
		isReorientAllowed.put(referenceTargetView, true);
		isReorientAllowed.put(nestedReferenceTargetView, true);
		
		isReorientAllowed.put(valueTargetView, true);
		isReorientAllowed.put(nestedValueTargetView, true);
		
		isReorientAllowed.put(commentTargetView, false);
		isReorientAllowed.put(commentCNTargetView, false);
		isReorientAllowed.put(constraintTargetView, true);
		isReorientAllowed.put(constraintCNTargetView, true);
	}

}
