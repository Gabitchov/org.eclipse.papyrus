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
 *  Nizar GUEDIDI (CEA LIST) - Add tests for Primitive Type properties and operations 
 *  Nizar GUEDIDI (CEA LIST) - Add tests for nested classifier compartments
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
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InstanceSpecificationSlotCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceNestedClassifierCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceOperationCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PrimitiveTypeAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PrimitiveTypeOperationCompartmentEditPart;
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
		return new CreateClassDiagramCommand();
	}

	@Test
	public void testToManageInstanceSlot() {
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
		//Class
		testToManageTopNode(UMLElementTypes.Component_2002, UMLElementTypes.Class_3004, ComponentNestedClassifierCompartmentEditPart.VISUAL_ID);
	}

	@Test
	public void testToManageComponentNestedInterface() {
		//Interface
		testToManageTopNode(UMLElementTypes.Component_2002, UMLElementTypes.Interface_3037, ComponentNestedClassifierCompartmentEditPart.VISUAL_ID);

	}

	@Test
	public void testToManageComponentNestedSignal() {
		//Signal
		testToManageTopNode(UMLElementTypes.Component_2002, UMLElementTypes.Signal_3051, ComponentNestedClassifierCompartmentEditPart.VISUAL_ID);

	}

	@Test
	public void testToManageComponentNestedDataType() {
		//Data Type
		testToManageTopNode(UMLElementTypes.Component_2002, UMLElementTypes.DataType_3045, ComponentNestedClassifierCompartmentEditPart.VISUAL_ID);

	}

	@Test
	public void testToManageComponentNestedEnumeration() {
		//Enumeration
		testToManageTopNode(UMLElementTypes.Component_2002, UMLElementTypes.Enumeration_3053, ComponentNestedClassifierCompartmentEditPart.VISUAL_ID);

	}

	@Test
	public void testToManageComponentNestedPrimitiveType() {
		//primitive Type
		testToManageTopNode(UMLElementTypes.Component_2002, UMLElementTypes.PrimitiveType_3046, ComponentNestedClassifierCompartmentEditPart.VISUAL_ID);

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

	@Test
	public void testToManageInterfaceProperty() {
		//interface
		testToManageTopNode(UMLElementTypes.Interface_2004, UMLElementTypes.Property_3006, InterfaceAttributeCompartmentEditPart.VISUAL_ID);
	}

	@Test
	public void testToManageInterfaceOperation() {
		//interface
		testToManageTopNode(UMLElementTypes.Interface_2004, UMLElementTypes.Operation_3007, InterfaceOperationCompartmentEditPart.VISUAL_ID);
	}

	@Test
	public void testToManageInterfaceNestedClass() {
		//Class
		testToManageTopNode(UMLElementTypes.Interface_2004, UMLElementTypes.Class_3008, InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID);

	}

	@Test
	public void testToManageInterfaceNestedInterface() {
		//Interface
		testToManageTopNode(UMLElementTypes.Interface_2004, UMLElementTypes.Interface_3038, InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID);

	}

	@Test
	public void testToManageInterfaceNestedSignal() {
		//Signal
		testToManageTopNode(UMLElementTypes.Interface_2004, UMLElementTypes.Signal_3049, InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID);

	}

	@Test
	public void testToManageInterfaceNestedDataType() {
		//Data Type
		testToManageTopNode(UMLElementTypes.Interface_2004, UMLElementTypes.DataType_3043, InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID);

	}

	@Test
	public void testToManageInterfaceNestedEnumeration() {
		//Enumeration
		testToManageTopNode(UMLElementTypes.Interface_2004, UMLElementTypes.Enumeration_3054, InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID);

	}

	@Test
	public void testToManageInterfaceNestedPrimitiveType() {
		//Primitive Type
		testToManageTopNode(UMLElementTypes.Interface_2004, UMLElementTypes.PrimitiveType_3048, InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID);

	}

	@Test
	public void testToManageEnumerationLiteralEnumeration() {
		//Enumeration
		//testToManageTopNode(UMLElementTypes.Enumeration_2006, UMLElementTypes.EnumerationLiteral_3017, EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID);
	}

	@Test
	public void testToManageClassProperty() {
		//Enumeration
		testToManageTopNode(UMLElementTypes.Class_2008, UMLElementTypes.Property_3012, ClassAttributeCompartmentEditPart.VISUAL_ID);
	}

	@Test
	public void testToManageClassReception() {
		//Enumeration
		testToManageTopNode(UMLElementTypes.Class_2008, UMLElementTypes.Reception_3011, ClassOperationCompartmentEditPart.VISUAL_ID);
	}

	@Test
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
	public void testToManageClassNestedInetrface() {
		//Interface
		testToManageTopNode(UMLElementTypes.Class_2008, UMLElementTypes.Interface_3036, ClassNestedClassifierCompartmentEditPart.VISUAL_ID);

	}

	@Test
	public void testToManageClassNestedSignal() {
		//Signal
		testToManageTopNode(UMLElementTypes.Class_2008, UMLElementTypes.Signal_3050, ClassNestedClassifierCompartmentEditPart.VISUAL_ID);

	}

	@Test
	public void testToManageClassNestedDataType() {
		//Data Type
		testToManageTopNode(UMLElementTypes.Class_2008, UMLElementTypes.DataType_3044, ClassNestedClassifierCompartmentEditPart.VISUAL_ID);

	}

	@Test
	public void testToManageClassNestedEnumeration() {
		//Enumeration
		testToManageTopNode(UMLElementTypes.Class_2008, UMLElementTypes.Enumeration_3052, ClassNestedClassifierCompartmentEditPart.VISUAL_ID);

	}

	@Test
	public void testToManageClassNestedPrimitiveType() {
		//Primitive Type
		testToManageTopNode(UMLElementTypes.Class_2008, UMLElementTypes.PrimitiveType_3047, ClassNestedClassifierCompartmentEditPart.VISUAL_ID);

	}

	@Test
	public void testToManageComponentReception() {
		//class
		testToManageTopNode(UMLElementTypes.Component_2002, UMLElementTypes.Reception_3011, ComponentOperationCompartmentEditPart.VISUAL_ID);
	}

	@Test
	public void testToManageInterfaceReception() {
		//class
		testToManageTopNode(UMLElementTypes.Interface_2004, UMLElementTypes.Reception_3039, InterfaceOperationCompartmentEditPart.VISUAL_ID);
	}

	@Test
	public void testToManagePrimitiveTypeProperty() {
		//class
		testToManageTopNode(UMLElementTypes.PrimitiveType_2009, UMLElementTypes.Property_3041, PrimitiveTypeAttributeCompartmentEditPart.VISUAL_ID);
	}

	@Test
	public void testToManagePrimitiveTypeOperation() {
		//class
		testToManageTopNode(UMLElementTypes.PrimitiveType_2009, UMLElementTypes.Operation_3042, PrimitiveTypeOperationCompartmentEditPart.VISUAL_ID);
	}
}
