/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.test.canonical;

import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.diagram.tests.canonical.TestNested;
import org.eclipse.papyrus.uml.diagram.clazz.CreateClassDiagramCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassNestedClassifierCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ComponentNestedClassifierCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.InterfaceNestedClassifierCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.junit.Test;

/**
 * The Class TestClassDiagramNestedClassifier.
 */
public class TestClassDiagramNestedClassifier extends TestNested {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateClassDiagramCommand();
	}

	@Test
	public void testToManageComponentNestedClass() {
		//Class
		testToManageTopNode(UMLElementTypes.Package_2007, UMLElementTypes.Component_3021, UMLElementTypes.Class_3004, PackagePackageableElementCompartmentEditPart.VISUAL_ID, ComponentNestedClassifierCompartmentEditPartCN.VISUAL_ID);

	}

	@Test
	public void testToManageComponentNestedInterface() {
		//Interface
		testToManageTopNode(UMLElementTypes.Package_2007, UMLElementTypes.Component_3021, UMLElementTypes.Interface_3037, PackagePackageableElementCompartmentEditPart.VISUAL_ID, ComponentNestedClassifierCompartmentEditPartCN.VISUAL_ID);

	}

	@Test
	public void testToManageComponentNestedSignal() {
		//Signal
		testToManageTopNode(UMLElementTypes.Package_2007, UMLElementTypes.Component_3021, UMLElementTypes.Signal_3051, PackagePackageableElementCompartmentEditPart.VISUAL_ID, ComponentNestedClassifierCompartmentEditPartCN.VISUAL_ID);

	}

	@Test
	public void testToManageComponentNestedDataType() {
		//Data Type
		testToManageTopNode(UMLElementTypes.Package_2007, UMLElementTypes.Component_3021, UMLElementTypes.DataType_3045, PackagePackageableElementCompartmentEditPart.VISUAL_ID, ComponentNestedClassifierCompartmentEditPartCN.VISUAL_ID);

	}

	@Test
	public void testToManageComponentNestedEnumeration() {
		//Enumeration
		testToManageTopNode(UMLElementTypes.Package_2007, UMLElementTypes.Component_3021, UMLElementTypes.Enumeration_3053, PackagePackageableElementCompartmentEditPart.VISUAL_ID, ComponentNestedClassifierCompartmentEditPartCN.VISUAL_ID);

	}

	@Test
	public void testToManageComponentNestedPrimitiveType() {
		//primitive Type
		testToManageTopNode(UMLElementTypes.Package_2007, UMLElementTypes.Component_3021, UMLElementTypes.PrimitiveType_3046, PackagePackageableElementCompartmentEditPart.VISUAL_ID, ComponentNestedClassifierCompartmentEditPartCN.VISUAL_ID);

	}

	@Test
	public void testToManageInterfaceNestedClass() {
		//Class
		testToManageTopNode(UMLElementTypes.Package_2007, UMLElementTypes.Interface_3023, UMLElementTypes.Class_3008, PackagePackageableElementCompartmentEditPart.VISUAL_ID, InterfaceNestedClassifierCompartmentEditPartCN.VISUAL_ID);

	}

	@Test
	public void testToManageInterfaceNestedInterface() {
		//Interface
		testToManageTopNode(UMLElementTypes.Package_2007, UMLElementTypes.Interface_3023, UMLElementTypes.Interface_3038, PackagePackageableElementCompartmentEditPart.VISUAL_ID, InterfaceNestedClassifierCompartmentEditPartCN.VISUAL_ID);

	}

	@Test
	public void testToManageInterfaceNestedSignal() {
		//Signal
		testToManageTopNode(UMLElementTypes.Package_2007, UMLElementTypes.Interface_3023, UMLElementTypes.Signal_3049, PackagePackageableElementCompartmentEditPart.VISUAL_ID, InterfaceNestedClassifierCompartmentEditPartCN.VISUAL_ID);

	}

	@Test
	public void testToManageInterfaceNestedDataType() {
		//Data Type
		testToManageTopNode(UMLElementTypes.Package_2007, UMLElementTypes.Interface_3023, UMLElementTypes.DataType_3043, PackagePackageableElementCompartmentEditPart.VISUAL_ID, InterfaceNestedClassifierCompartmentEditPartCN.VISUAL_ID);

	}

	@Test
	public void testToManageInterfaceNestedEnumeration() {
		//Enumeration
		testToManageTopNode(UMLElementTypes.Package_2007, UMLElementTypes.Interface_3023, UMLElementTypes.Enumeration_3054, PackagePackageableElementCompartmentEditPart.VISUAL_ID, InterfaceNestedClassifierCompartmentEditPartCN.VISUAL_ID);

	}

	@Test
	public void testToManageInterfaceNestedPrimitiveType() {
		//Primitive Type
		testToManageTopNode(UMLElementTypes.Package_2007, UMLElementTypes.Interface_3023, UMLElementTypes.PrimitiveType_3048, PackagePackageableElementCompartmentEditPart.VISUAL_ID, InterfaceNestedClassifierCompartmentEditPartCN.VISUAL_ID);

	}

	@Test
	public void testToManageClassNestedClass() {
		//class
		testToManageTopNode(UMLElementTypes.Package_2007, UMLElementTypes.Class_3010, UMLElementTypes.Class_3014, PackagePackageableElementCompartmentEditPart.VISUAL_ID, ClassNestedClassifierCompartmentEditPartCN.VISUAL_ID);

	}

	@Test
	public void testToManageClassNestedInetrface() {
		//Interface
		testToManageTopNode(UMLElementTypes.Package_2007, UMLElementTypes.Class_3010, UMLElementTypes.Interface_3036, PackagePackageableElementCompartmentEditPart.VISUAL_ID, ClassNestedClassifierCompartmentEditPartCN.VISUAL_ID);

	}

	@Test
	public void testToManageClassNestedSignal() {
		//Signal
		testToManageTopNode(UMLElementTypes.Package_2007, UMLElementTypes.Class_3010, UMLElementTypes.Signal_3050, PackagePackageableElementCompartmentEditPart.VISUAL_ID, ClassNestedClassifierCompartmentEditPartCN.VISUAL_ID);

	}

	@Test
	public void testToManageClassNestedDataType() {
		//Data Type
		testToManageTopNode(UMLElementTypes.Package_2007, UMLElementTypes.Class_3010, UMLElementTypes.DataType_3044, PackagePackageableElementCompartmentEditPart.VISUAL_ID, ClassNestedClassifierCompartmentEditPartCN.VISUAL_ID);

	}

	@Test
	public void testToManageclassNestedEnumeration() {
		//Enumeration
		testToManageTopNode(UMLElementTypes.Package_2007, UMLElementTypes.Class_3010, UMLElementTypes.Enumeration_3052, PackagePackageableElementCompartmentEditPart.VISUAL_ID, ClassNestedClassifierCompartmentEditPartCN.VISUAL_ID);

	}

	@Test
	public void testToManageClassNestedPrimitiveType() {
		//Primitive Type
		testToManageTopNode(UMLElementTypes.Package_2007, UMLElementTypes.Class_3010, UMLElementTypes.PrimitiveType_3047, PackagePackageableElementCompartmentEditPart.VISUAL_ID, ClassNestedClassifierCompartmentEditPartCN.VISUAL_ID);

	}

}
