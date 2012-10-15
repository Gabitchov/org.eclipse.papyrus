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
import org.eclipse.papyrus.diagram.tests.canonical.TestChildLabel;
import org.eclipse.papyrus.uml.diagram.clazz.CreateClassDiagramCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassNestedClassifierCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassOperationCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentNestedClassifierCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentOperationCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.EnumerationEnumerationLiteralCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InstanceSpecificationSlotCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceNestedClassifierCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceOperationCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.SignalAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.junit.Test;


// TODO: Auto-generated Javadoc
/**
 * The Class TestClassDiagramChildLabel.
 */
public class TestClassDiagramChildLabel extends TestChildLabel {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return  new CreateClassDiagramCommand();
	}
	@Test
	public void testToManageinstanceSlot() {
		//instance specification
		testToManageTopNode(UMLElementTypes.InstanceSpecification_2001, UMLElementTypes.Slot_3030, InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID);
	}
	@Test
	public void testToManageComponentProperty() {
		//instance specification
		testToManageTopNode(UMLElementTypes.Component_2002, UMLElementTypes.Property_3002, ComponentAttributeCompartmentEditPart.VISUAL_ID);
	}
	
	@Test
	public void testToManageComponentNestedClass() {
		//instance specification
		testToManageTopNode(UMLElementTypes.Component_2002, UMLElementTypes.Class_3004, ComponentNestedClassifierCompartmentEditPart.VISUAL_ID);
	}
	@Test
	public void testToManageComponentOperation() {
		//instance specification
		testToManageTopNode(UMLElementTypes.Component_2002, UMLElementTypes.Operation_3003, ComponentOperationCompartmentEditPart.VISUAL_ID);
	}
	
	@Test
	public void testToManageSignalProperty() {
		//instance specification
		testToManageTopNode(UMLElementTypes.Signal_2003, UMLElementTypes.Property_3005, SignalAttributeCompartmentEditPart.VISUAL_ID);
	}
	
	public void testToManageInterfaceProperty() {
		//interface
		testToManageTopNode(UMLElementTypes.Interface_2004, UMLElementTypes.Property_3006, InterfaceAttributeCompartmentEditPart.VISUAL_ID);
	}	
	public void testToManageInterfaceOperation() {
		//interface
		testToManageTopNode(UMLElementTypes.Interface_2004, UMLElementTypes.Operation_3007, InterfaceOperationCompartmentEditPart.VISUAL_ID);
	}
	
	public void testToManageInterfaceNestedClass() {
		//interface
		testToManageTopNode(UMLElementTypes.Interface_2004, UMLElementTypes.Class_3008, InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID);
	}	
	
	public void testToManageEnumerationLiteralEnumeration() {
		//Enumeration
		testToManageTopNode(UMLElementTypes.Enumeration_2006, UMLElementTypes.EnumerationLiteral_3017, EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID);
		}
	
	public void testToManageClassProperty() {
		//Enumeration
		testToManageTopNode(UMLElementTypes.Class_2008, UMLElementTypes.Property_3012, ClassAttributeCompartmentEditPart.VISUAL_ID);
			}
	
	public void testToManageClassReception() {
		//Enumeration
		testToManageTopNode(UMLElementTypes.Class_2008, UMLElementTypes.Reception_3011, ClassOperationCompartmentEditPart.VISUAL_ID);
				}
	
	public void testToManageClassOperation() {
		//Enumeration
		testToManageTopNode(UMLElementTypes.Class_2008, UMLElementTypes.Operation_3013, ClassOperationCompartmentEditPart.VISUAL_ID);
				}
	@Test
	public void testToManageClassNestedClass() {
		//class
		testToManageTopNode(UMLElementTypes.Class_2008, UMLElementTypes.Class_3014, ClassNestedClassifierCompartmentEditPart.VISUAL_ID);
	}
	
	
	@Test
	public void testToManageComponentReception() {
		//class
		testToManageTopNode(UMLElementTypes.Component_2002, UMLElementTypes.Reception_3011,ComponentOperationCompartmentEditPart.VISUAL_ID );
	}
	@Test
	public void testToManageInterfaceReception() {
		//class
		testToManageTopNode(UMLElementTypes.Interface_2004, UMLElementTypes.Reception_3039,InterfaceOperationCompartmentEditPart.VISUAL_ID );
	}
}
