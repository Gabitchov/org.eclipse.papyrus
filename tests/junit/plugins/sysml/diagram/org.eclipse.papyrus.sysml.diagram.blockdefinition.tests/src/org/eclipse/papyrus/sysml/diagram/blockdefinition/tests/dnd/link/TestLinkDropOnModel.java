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
package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.dnd.link;

import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestPrepareUtils.createElement;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestPrepareUtils.createGraphicalNode;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestPrepareUtils.createLink;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestUtils.dropFromModelExplorer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.ElementTypes;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.AbstractTest;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * JUnit tests for Link DnD tests (via palette tools).
 */
public class TestLinkDropOnModel extends AbstractTest {

	public static View container;
	public static View containerNode;
	
	public static EObject blockSource;
	public static EObject blockTarget;
	public static EObject interfaceTarget;
	
	public static EObject dependency;
	public static EObject usage;
	public static EObject interfaceRealization;
	public static EObject generalization;
	
	public static EObject associationComposite;
	public static EObject associationCompositeDirected;
	public static EObject associationNone;
	public static EObject associationNoneDirected;
	public static EObject associationShared;
	public static EObject associationSharedDirected;
	
	@BeforeClass
	public static void prepare() throws Exception {
		// Prepare elements for link creation tests
		containerNode = createGraphicalNode(UMLElementTypes.MODEL, ElementTypes.MODEL.getSemanticHint(), getDiagramView());
		container = ViewUtil.getChildBySemanticHint(containerNode, ElementTypes.MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT);
		
		blockSource = createElement(SysMLElementTypes.BLOCK, container);
		blockTarget = createElement(SysMLElementTypes.BLOCK, container);
		interfaceTarget = createElement(UMLElementTypes.INTERFACE, container);
		
		dependency = createLink(UMLElementTypes.DEPENDENCY, blockSource, blockTarget);
		usage = createLink(UMLElementTypes.USAGE, blockSource, blockTarget);
		interfaceRealization = createLink(UMLElementTypes.INTERFACE_REALIZATION, blockSource, interfaceTarget);
		generalization = createLink(UMLElementTypes.GENERALIZATION, blockSource, blockTarget);
		
		associationComposite = createLink(SysMLElementTypes.ASSOCIATION_COMPOSITE, blockSource, blockTarget);
		associationCompositeDirected = createLink(SysMLElementTypes.ASSOCIATION_COMPOSITE_DIRECTED, blockSource, blockTarget);
		associationNone = createLink(SysMLElementTypes.ASSOCIATION_NONE, blockSource, blockTarget);
		associationNoneDirected = createLink(SysMLElementTypes.ASSOCIATION_NONE_DIRECTED, blockSource, blockTarget);
		associationShared = createLink(SysMLElementTypes.ASSOCIATION_SHARED, blockSource, blockTarget);
		associationSharedDirected = createLink(SysMLElementTypes.ASSOCIATION_SHARED_DIRECTED, blockSource, blockTarget);
	}

	@Test
	public void dropDependency() throws Exception {
		dropFromModelExplorer(dependency, container, true);
	}
	
	@Test
	public void dropUsage() throws Exception {
		dropFromModelExplorer(usage, container, true);
	}
	
	@Test
	public void dropInterfaceRealization() throws Exception {
		dropFromModelExplorer(interfaceRealization, container, true);
	}
	
	@Test
	public void dropGeneralization() throws Exception {
		dropFromModelExplorer(generalization, container, true);
	}
	
	@Test
	public void dropAssociationComposite() throws Exception {
		dropFromModelExplorer(associationComposite, container, true);
	}
	
	@Test
	public void dropAssociationCompositeDirected() throws Exception {
		dropFromModelExplorer(associationCompositeDirected, container, true);
	}
	
	@Test
	public void dropAssociationNone() throws Exception {
		dropFromModelExplorer(associationNone, container, true);
	}
	
	@Test
	public void dropAssociationNoneDirected() throws Exception {
		dropFromModelExplorer(associationNoneDirected, container, true);
	}
	
	@Test
	public void dropAssociationShared() throws Exception {
		dropFromModelExplorer(associationShared, container, true);
	}
	
	@Test
	public void dropAssociationSharedDirected() throws Exception {
		dropFromModelExplorer(associationSharedDirected, container, true);
	}
}
