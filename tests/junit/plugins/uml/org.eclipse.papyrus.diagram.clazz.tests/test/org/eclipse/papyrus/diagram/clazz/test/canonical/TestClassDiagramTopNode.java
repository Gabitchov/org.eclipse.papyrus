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

import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.diagram.tests.canonical.TestTopNode;
import org.eclipse.papyrus.uml.diagram.clazz.CreateClassDiagramCommand;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
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
		testToManageTopNode(UMLElementTypes.Component_2002, UMLElementTypes.Package_2007);
	}
	
	/**
	 * Test to manage instance specification.
	 */
	@Test
	public void testToManageInstanceSpecification() {
		testToManageTopNode(UMLElementTypes.InstanceSpecification_2001, UMLElementTypes.Package_2007);
	}
	
	/**
	 * Test to manage signal.
	 */
	@Test
	public void testToManageSignal() {
		testToManageTopNode(UMLElementTypes.Signal_2003, UMLElementTypes.Package_2007);
	}
	
	/**
	 * Test to manage model.
	 */
	@Test
	public void testToManageModel() {
		testToManageTopNode(UMLElementTypes.Model_2005, UMLElementTypes.Package_2007);
	}
	
	/**
	 * Test to manage enumeration.
	 */
	@Test
	public void testToManageEnumeration() {
		testToManageTopNode(UMLElementTypes.Enumeration_2006, UMLElementTypes.Package_2007);
	}
	
	/**
	 * Test to manage i package.
	 */
	@Test
	public void testToManageIPackage() {
		testToManageTopNode(UMLElementTypes.Package_2007, UMLElementTypes.Package_2007);
	}
	
	/**
	 * Test to manage class.
	 */
	@Test
	public void testToManageClass() {
		testToManageTopNode(UMLElementTypes.Class_2008, UMLElementTypes.Package_2007);
	}
	
	/**
	 * Test to manage primitive type.
	 */
	@Test
	public void testToManagePrimitiveType() {
		testToManageTopNode(UMLElementTypes.PrimitiveType_2009, UMLElementTypes.Package_2007);
	}
	
	/**
	 * Test to manage data type.
	 */
	@Test
	public void testToManageDataType() {
		testToManageTopNode(UMLElementTypes.DataType_2010, UMLElementTypes.Package_2007);
	}
	
	/**
	 * Test to manage constraint.
	 */
	@Test
	public void testToManageConstraint() {
		testToManageTopNode(UMLElementTypes.Constraint_2011, UMLElementTypes.Package_2007);
	}
	
	/**
	 * Test to manage comment.
	 */
	@Test
	public void testToManageComment() {
		testToManageTopNode(UMLElementTypes.Comment_2012, UMLElementTypes.Package_2007);
	}
	
	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManageInformationItem() {
		testToManageTopNode(UMLElementTypes.InformationItem_2099, UMLElementTypes.Package_2007);
	}
	
}
