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
package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.dnd;

import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestPrepareUtils.createElement;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestPrepareUtils.createLink;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestUtils.dropFromModelExplorer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.AbstractTest;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * JUnit tests for Link DnD tests (via palette tools).
 */
public class TestLinkDropOnDiagram extends AbstractTest {

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
		blockSource = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		blockTarget = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		interfaceTarget = createElement(UMLElementTypes.INTERFACE, getDiagramView());
		
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
	public void dropDependencyInDiagram() throws Exception {
		dropFromModelExplorer(dependency, getDiagramView(), true);
	}
	
	@Test
	public void dropUsageInDiagram() throws Exception {
		dropFromModelExplorer(usage, getDiagramView(), true);
	}
	
	@Test
	public void dropInterfaceRealizationInDiagram() throws Exception {
		dropFromModelExplorer(interfaceRealization, getDiagramView(), true);
	}
	
	@Test
	public void dropGeneralizationInDiagram() throws Exception {
		dropFromModelExplorer(generalization, getDiagramView(), true);
	}
	
	@Test
	public void dropAssociationCompositeInDiagram() throws Exception {
		dropFromModelExplorer(associationComposite, getDiagramView(), true);
	}
	
	@Test
	public void dropAssociationCompositeDirectedInDiagram() throws Exception {
		dropFromModelExplorer(associationCompositeDirected, getDiagramView(), true);
	}
	
	@Test
	public void dropAssociationNoneInDiagram() throws Exception {
		dropFromModelExplorer(associationNone, getDiagramView(), true);
	}
	
	@Test
	public void dropAssociationNoneDirectedInDiagram() throws Exception {
		dropFromModelExplorer(associationNoneDirected, getDiagramView(), true);
	}
	
	@Test
	public void dropAssociationSharedInDiagram() throws Exception {
		dropFromModelExplorer(associationShared, getDiagramView(), true);
	}
	
	@Test
	public void dropAssociationSharedDirectedInDiagram() throws Exception {
		dropFromModelExplorer(associationSharedDirected, getDiagramView(), true);
	}
}
