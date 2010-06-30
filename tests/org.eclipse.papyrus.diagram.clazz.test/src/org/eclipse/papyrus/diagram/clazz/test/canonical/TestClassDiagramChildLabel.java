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

import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassAttributeCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassNestedClassifierCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassOperationCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ComponentAttributeCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ComponentNestedClassifierCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ComponentOperationCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.EnumerationEnumerationLiteralCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InstanceSpecificationSlotCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceAttributeCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceNestedClassifierCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.InterfaceOperationCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.SignalAttributeCompartmentEditPart;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.junit.Test;


// TODO: Auto-generated Javadoc
/**
 * The Class TestClassDiagramChildLabel.
 */
public class TestClassDiagramChildLabel extends TestChildLabel {

	
	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManageComponent() {
		//instance specification
		testToManageTopNode(UMLElementTypes.InstanceSpecification_2001, UMLElementTypes.Slot_3030, InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID);
		//component
		testToManageTopNode(UMLElementTypes.Component_2002, UMLElementTypes.Property_3002, ComponentAttributeCompartmentEditPart.VISUAL_ID);
		testToManageTopNode(UMLElementTypes.Component_2002, UMLElementTypes.Operation_3003, ComponentOperationCompartmentEditPart.VISUAL_ID);
		testToManageTopNode(UMLElementTypes.Component_2002, UMLElementTypes.Class_3004, ComponentNestedClassifierCompartmentEditPart.VISUAL_ID);
		//signal
		testToManageTopNode(UMLElementTypes.Signal_2003, UMLElementTypes.Property_3005, SignalAttributeCompartmentEditPart.VISUAL_ID);
		//interface
		testToManageTopNode(UMLElementTypes.Interface_2004, UMLElementTypes.Property_3006, InterfaceAttributeCompartmentEditPart.VISUAL_ID);
		testToManageTopNode(UMLElementTypes.Interface_2004, UMLElementTypes.Operation_3007, InterfaceOperationCompartmentEditPart.VISUAL_ID);
		testToManageTopNode(UMLElementTypes.Interface_2004, UMLElementTypes.Class_3008, InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID);
		//Enumeration
		testToManageTopNode(UMLElementTypes.Enumeration_2006, UMLElementTypes.EnumerationLiteral_3017, EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID);
		
		//class
		testToManageTopNode(UMLElementTypes.Class_2008, UMLElementTypes.Property_3012, ClassAttributeCompartment2EditPart.VISUAL_ID);
		testToManageTopNode(UMLElementTypes.Class_2008, UMLElementTypes.Reception_3011, ClassOperationCompartment2EditPart.VISUAL_ID);
		testToManageTopNode(UMLElementTypes.Class_2008, UMLElementTypes.Operation_3013, ClassOperationCompartment2EditPart.VISUAL_ID);
		testToManageTopNode(UMLElementTypes.Class_2008, UMLElementTypes.Class_3014, ClassNestedClassifierCompartment2EditPart.VISUAL_ID);

		//DataType
		//toDo
		
	}
	
	
}
