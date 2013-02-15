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
package org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.link;

import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestPrepareUtils.createConnectorLink;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestPrepareUtils.createGraphicalNode;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestPrepareUtils.createLink;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestUtils.dropFromModelExplorer;
import junit.framework.Assert;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.AbstractTest;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorKind;
import org.eclipse.uml2.uml.EncapsulatedClassifier;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * JUnit tests for Link DnD tests (via palette tools).
 */
public class TestLinkDropOnBlockPropertyStructureCpt extends AbstractTest {

	public static EObject dependency;
	public static EObject connector;
	

	public static EObject nestedDependency;
	public static EObject nestedConnector;
	public static EObject delegationNestedConnector;
    public static EObject crossNestedConnector;
	
	public static View blockStructureView;
	public static View partStructureView;
	public static View sourcePartStructureView;
	
	

	
	@BeforeClass
	public static void prepare() throws Exception {

		View blockView = ViewUtil.getChildBySemanticHint(getDiagramView(), SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID);
		blockStructureView = ViewUtil.getChildBySemanticHint(blockView, SysMLGraphicalTypes.COMPARTMENT_SYSML_STRUCTURE_ID);

		View partView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, blockStructureView);
		partStructureView = ViewUtil.getChildBySemanticHint(partView, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
		
		View partSourceView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partStructureView);
		View portOnPartSourceView = createGraphicalNode(UMLElementTypes.PORT, (EObject)partSourceView.getElement().eGet(UMLPackage.eINSTANCE.getTypedElement_Type()), UMLGraphicalTypes.SHAPE_UML_PORT_AS_AFFIXED_ID, partSourceView);
		View partTargetView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, partStructureView);
		
		sourcePartStructureView = ViewUtil.getChildBySemanticHint(partView, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
		View nestedPartSourceView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, sourcePartStructureView);
		
		View nestedPartTargetViewInPartSourceView = createGraphicalNode(SysMLElementTypes.PART_PROPERTY, SysMLGraphicalTypes.SHAPE_SYSML_BLOCKPROPERTY_AS_COMPOSITE_ID, sourcePartStructureView);
		
		dependency = createLink(UMLElementTypes.DEPENDENCY, partSourceView.getElement(), partTargetView.getElement());
		connector = createConnectorLink((EncapsulatedClassifier) blockView.getElement(), (ConnectableElement)partSourceView.getElement(), (Property)null, (ConnectableElement)partTargetView.getElement(), (Property)null);
		
		nestedDependency = createLink(UMLElementTypes.DEPENDENCY, nestedPartSourceView.getElement(), nestedPartTargetViewInPartSourceView.getElement());
		nestedConnector = createConnectorLink((EncapsulatedClassifier) ((Property)partSourceView.getElement()).getType(), (ConnectableElement)nestedPartSourceView.getElement(), (Property)null, (ConnectableElement)nestedPartTargetViewInPartSourceView.getElement(), (Property)null);
		delegationNestedConnector = createConnectorLink((EncapsulatedClassifier) blockView.getElement(), (ConnectableElement)portOnPartSourceView.getElement(), (Property)null, (ConnectableElement)nestedPartTargetViewInPartSourceView.getElement(), (Property)null);
		Assert.assertEquals("Connector should be a delegation connector", ConnectorKind.DELEGATION_LITERAL, ((Connector)delegationNestedConnector).getKind()); // be sure that we really test drop of a delegation connector
		
		crossNestedConnector = createConnectorLink((EncapsulatedClassifier) blockView.getElement(), (ConnectableElement)nestedPartSourceView.getElement(), (Property)null, (ConnectableElement)partTargetView.getElement(), (Property)null);
		Assert.assertEquals("Connector should be a assembly connector", ConnectorKind.ASSEMBLY_LITERAL, ((Connector)crossNestedConnector).getKind()); // be sure that we really test drop of an assembly connector
		
	}

	@Test
	public void dropDependencyInBlock() throws Exception {
		dropFromModelExplorer(dependency, partStructureView, true);
	}
	
	@Test
	public void dropConnectorInBlock() throws Exception {
		dropFromModelExplorer(connector, partStructureView, true); 
	}
	
	@Test
	public void dropNestedDependencyInPart() throws Exception {
		dropFromModelExplorer(nestedDependency, sourcePartStructureView, true);
	}
	
	@Test
	public void dropNestedConnectorInPart() throws Exception {
		dropFromModelExplorer(nestedConnector, sourcePartStructureView, true); 
	}
	
	@Test
	public void dropDelegationNestedConnectorInBlock() throws Exception {
		dropFromModelExplorer(delegationNestedConnector, partStructureView, true);
	}
	
	@Test
	public void dropAssemblyNestedConnectorInBlock() throws Exception {
		dropFromModelExplorer(crossNestedConnector, partStructureView, true);
	}
}
