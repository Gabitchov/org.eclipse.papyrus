/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.test.canonical;

import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.diagram.tests.canonical.TestTopNode;
import org.eclipse.papyrus.uml.diagram.clazz.CreateClassDiagramCommand;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;


// TODO: Auto-generated Javadoc
/**
 * The Class TestClassDiagramTopNode.
 */
public class TestClassDiagramTopNode extends TestTopNode {
	
	
	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return  new CreateClassDiagramCommand();
	}
	
	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManageComponent() {
		testToManageNode(UMLElementTypes.Component_2002, UMLPackage.eINSTANCE.getComponent(), UMLElementTypes.Package_2007, true);
	}
	
	/**
	 * Test to manage instance specification.
	 */
	@Test
	public void testToManageInstanceSpecification() {
		testToManageNode(UMLElementTypes.InstanceSpecification_2001, UMLPackage.eINSTANCE.getInstanceSpecification(), UMLElementTypes.Package_2007, true);
	}
	
	/**
	 * Test to manage signal.
	 */
	@Test
	public void testToManageSignal() {
		testToManageNode(UMLElementTypes.Signal_2003, UMLPackage.eINSTANCE.getSignal(), UMLElementTypes.Package_2007, true);
	}
	
	/**
	 * Test to manage model.
	 */
	@Test
	public void testToManageModel() {
		testToManageNode(UMLElementTypes.Model_2005, UMLPackage.eINSTANCE.getModel(), UMLElementTypes.Package_2007, true);
	}
	
	/**
	 * Test to manage enumeration.
	 */
	@Test
	public void testToManageEnumeration() {
		testToManageNode(UMLElementTypes.Enumeration_2006, UMLPackage.eINSTANCE.getEnumeration(), UMLElementTypes.Package_2007, true);
	}
	
	/**
	 * Test to manage i package.
	 */
	@Test
	public void testToManageIPackage() {
		testToManageNode(UMLElementTypes.Package_2007, UMLPackage.eINSTANCE.getPackage(), UMLElementTypes.Package_2007, true);
	}
	
	/**
	 * Test to manage class.
	 */
	@Test
	public void testToManageClass() {
		testToManageNode(UMLElementTypes.Class_2008, UMLPackage.eINSTANCE.getClass_(), UMLElementTypes.Package_2007, true);
	}
	
	/**
	 * Test to manage primitive type.
	 */
	@Test
	public void testToManagePrimitiveType() {
		testToManageNode(UMLElementTypes.PrimitiveType_2009, UMLPackage.eINSTANCE.getPrimitiveType(), UMLElementTypes.Package_2007, true);
	}
	
	/**
	 * Test to manage data type.
	 */
	@Test
	public void testToManageDataType() {
		testToManageNode(UMLElementTypes.DataType_2010, UMLPackage.eINSTANCE.getDataType(), UMLElementTypes.Package_2007, true);
	}
	
	/**
	 * Test to manage constraint.
	 */
	@Test
	public void testToManageConstraint() {
		testToManageNode(UMLElementTypes.Constraint_2011, UMLPackage.eINSTANCE.getConstraint(), UMLElementTypes.Package_2007, true);
	}
	
	/**
	 * Test to manage comment.
	 */
	@Test
	public void testToManageComment() {
		testToManageNode(UMLElementTypes.Comment_2012, UMLPackage.eINSTANCE.getComment(), UMLElementTypes.Package_2007, true);
	}
	
	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManageInformationItem() {
		testToManageNode(UMLElementTypes.InformationItem_2099, UMLPackage.eINSTANCE.getInformationItem(), UMLElementTypes.Package_2007, true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CreateViewRequest createViewRequestShapeContainer() {
		return CreateViewRequestFactory.getCreateShapeRequest(UMLElementTypes.Package_2007, getDiagramEditPart().getDiagramPreferencesHint());
	}
	
}
