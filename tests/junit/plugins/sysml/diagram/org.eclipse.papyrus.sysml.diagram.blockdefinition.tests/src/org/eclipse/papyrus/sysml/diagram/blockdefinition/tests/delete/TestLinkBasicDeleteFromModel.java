/*****************************************************************************
 * Copyright (c) 2011-2012 CEA LIST.
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
package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.delete;

import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestPrepareUtils.createGraphicalNode;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestPrepareUtils.createLink;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestPrepareUtils.dropFromModelExplorer;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestUtils.deleteElement;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.AbstractTest;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * JUnit tests for link element Delete test (via palette tools) in diagram.
 */
public class TestLinkBasicDeleteFromModel extends AbstractTest {
	
	public static EObject blockSource;
	public static EObject blockTarget;
	public static EObject interfaceTarget;
	
	public static View dependency;
	public static View usage;
	public static View interfaceRealization;
	public static View generalization;
	
	public static View associationComposite;
	public static View associationCompositeDirected;
	public static View associationNone;
	public static View associationNoneDirected;
	public static View associationShared;
	public static View associationSharedDirected;
	
	@BeforeClass
	public static void prepare() throws Exception {
		// Prepare elements for link creation tests
		blockSource = createGraphicalNode(SysMLElementTypes.BLOCK, SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID, getDiagramView()).getElement();
		blockTarget = createGraphicalNode(SysMLElementTypes.BLOCK, SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID, getDiagramView()).getElement();
		interfaceTarget = createGraphicalNode(UMLElementTypes.INTERFACE, UMLGraphicalTypes.SHAPE_UML_INTERFACE_AS_CLASSIFIER_ID, getDiagramView()).getElement();
		
		EObject tmp = null;
		
		tmp = createLink(UMLElementTypes.DEPENDENCY, blockSource, blockTarget);
		dependency = dropFromModelExplorer(tmp, getDiagramView());
		tmp = createLink(UMLElementTypes.USAGE, blockSource, blockTarget);
		usage = dropFromModelExplorer(tmp, getDiagramView());
		tmp = createLink(UMLElementTypes.INTERFACE_REALIZATION, blockSource, interfaceTarget);
		interfaceRealization = dropFromModelExplorer(tmp, getDiagramView());
		tmp = createLink(UMLElementTypes.GENERALIZATION, blockSource, blockTarget);
		generalization = dropFromModelExplorer(tmp, getDiagramView());
		tmp = createLink(SysMLElementTypes.ASSOCIATION_COMPOSITE, blockSource, blockTarget);
		associationComposite = dropFromModelExplorer(tmp, getDiagramView());
		tmp = createLink(SysMLElementTypes.ASSOCIATION_COMPOSITE_DIRECTED, blockSource, blockTarget);
		associationCompositeDirected = dropFromModelExplorer(tmp, getDiagramView());
		tmp = createLink(SysMLElementTypes.ASSOCIATION_NONE, blockSource, blockTarget);
		associationNone = dropFromModelExplorer(tmp, getDiagramView());
		tmp = createLink(SysMLElementTypes.ASSOCIATION_NONE_DIRECTED, blockSource, blockTarget);
		associationNoneDirected = dropFromModelExplorer(tmp, getDiagramView());
		tmp = createLink(SysMLElementTypes.ASSOCIATION_SHARED, blockSource, blockTarget);
		associationShared = dropFromModelExplorer(tmp, getDiagramView());
		tmp = createLink(SysMLElementTypes.ASSOCIATION_SHARED_DIRECTED, blockSource, blockTarget);
		associationSharedDirected = dropFromModelExplorer(tmp, getDiagramView());
	}
	
	@Test
	public void testBasicDeleteFromModelDependency() throws Exception {
		deleteElement(dependency, true);
	}

	@Test
	public void testBasicDeleteFromModelUsage() throws Exception {
		deleteElement(usage, true);
	}

	@Test
	public void testBasicDeleteFromModelInterfaceRealization() throws Exception {
		deleteElement(interfaceRealization, true);
	}

	@Test
	public void testBasicDeleteFromModelGeneralization() throws Exception {
		deleteElement(generalization, true);
	}

	@Test
	public void testBasicDeleteFromModelAssociationComposite() throws Exception {
		deleteElement(associationComposite, true);
	}

	@Test
	public void testBasicDeleteFromModelAssociationCompositeDirected() throws Exception {
		deleteElement(associationCompositeDirected, true);
	}
	
	@Test
	public void testBasicDeleteFromModelAssociationNone() throws Exception {
		deleteElement(associationNone, true);
	}
	
	@Test
	public void testBasicDeleteFromModelAssociationNoneDirected() throws Exception {
		deleteElement(associationNoneDirected, true);
	}
	
	@Test
	public void testBasicDeleteFromModelAssociationShared() throws Exception {
		deleteElement(associationShared, true);
	}
	
	@Test
	public void testBasicDeleteFromModelAssociationSharedDirected() throws Exception {
		deleteElement(associationSharedDirected, true);
	}

}
