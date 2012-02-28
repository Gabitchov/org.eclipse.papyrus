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
package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.suites;

import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnActor;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnActorOperationCompartment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnActorPropertyCompartment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnBlock;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnBlockConstraintCompartment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnBlockFlowPortCompartment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnBlockOperationCompartment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnBlockPartCompartment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnBlockPortCompartment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnBlockPropertyCompartment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnBlockReferenceCompartment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnBlockValueCompartment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnConstraintBlock;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnConstraintBlockConstraintCompartment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnConstraintBlockParameterCompartment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnDataType;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnDataTypeOperationCompartment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnDataTypePropertyCompartment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnDimension;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnEnumeration;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnEnumerationLiteralCompartment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnFlowSpecification;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnFlowSpecificationFlowCompartment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnInterface;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnInterfaceOperationCompartment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnInterfacePropertyCompartment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnPrimitiveType;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnSignal;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnSignalOperationCompartment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnSignalPropertyCompartment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnUnit;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnValueType;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnValueTypeOperationCompartment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.custom.TestNodeCreationOnValueTypePropertyCompartment;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ 
	TestNodeCreationOnActor.class, 
	TestNodeCreationOnActorOperationCompartment.class, 
	TestNodeCreationOnActorPropertyCompartment.class,
	TestNodeCreationOnBlock.class, 
	TestNodeCreationOnBlockConstraintCompartment.class,
	TestNodeCreationOnBlockFlowPortCompartment.class, 
	TestNodeCreationOnBlockOperationCompartment.class,
	TestNodeCreationOnBlockPartCompartment.class, 
	TestNodeCreationOnBlockPortCompartment.class,
	TestNodeCreationOnBlockPropertyCompartment.class,
	TestNodeCreationOnBlockReferenceCompartment.class, 
	TestNodeCreationOnBlockValueCompartment.class, 
	TestNodeCreationOnConstraintBlock.class,
	TestNodeCreationOnConstraintBlockConstraintCompartment.class, 
	TestNodeCreationOnConstraintBlockParameterCompartment.class,
	TestNodeCreationOnDataType.class, 
	TestNodeCreationOnDataTypeOperationCompartment.class, 
	TestNodeCreationOnDataTypePropertyCompartment.class, 
	TestNodeCreationOnDimension.class,
	TestNodeCreationOnEnumeration.class, 
	TestNodeCreationOnEnumerationLiteralCompartment.class, 
	TestNodeCreationOnFlowSpecification.class, 
	TestNodeCreationOnFlowSpecificationFlowCompartment.class, 
	TestNodeCreationOnInterface.class, 
	TestNodeCreationOnInterfaceOperationCompartment.class, 
	TestNodeCreationOnInterfacePropertyCompartment.class, 
	TestNodeCreationOnPrimitiveType.class, 
	TestNodeCreationOnSignal.class, 
	TestNodeCreationOnSignalOperationCompartment.class, 
	TestNodeCreationOnSignalPropertyCompartment.class, 
	TestNodeCreationOnUnit.class, 
	TestNodeCreationOnValueType.class, 
	TestNodeCreationOnValueTypeOperationCompartment.class,
	TestNodeCreationOnValueTypePropertyCompartment.class })
public class AllCreationCustomTests {

}
