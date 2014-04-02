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

import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.inherited.TestNodeCreationOnComment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.inherited.TestNodeCreationOnCommentCN;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.inherited.TestNodeCreationOnConstraint;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.inherited.TestNodeCreationOnConstraintCN;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.inherited.TestNodeCreationOnInstanceSpecification;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.inherited.TestNodeCreationOnInstanceSpecificationCN;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.inherited.TestNodeCreationOnInstanceSpecificationCompartment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.inherited.TestNodeCreationOnInstanceSpecificationCompartmentCN;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.inherited.TestNodeCreationOnModel;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.inherited.TestNodeCreationOnModelCN;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.inherited.TestNodeCreationOnModelCompartment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.inherited.TestNodeCreationOnModelCompartmentCN;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.inherited.TestNodeCreationOnPackage;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.inherited.TestNodeCreationOnPackageCN;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.inherited.TestNodeCreationOnPackageCompartment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.inherited.TestNodeCreationOnPackageCompartmentCN;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	//TestNodeCreationOnComment.class, 
	//TestNodeCreationOnCommentCN.class,
	//TestNodeCreationOnConstraint.class,
	//TestNodeCreationOnConstraintCN.class, 
	//TestNodeCreationOnInstanceSpecification.class,
	TestNodeCreationOnInstanceSpecificationCN.class,
	TestNodeCreationOnInstanceSpecificationCompartment.class,
	TestNodeCreationOnInstanceSpecificationCompartmentCN.class,
	TestNodeCreationOnModel.class,
	TestNodeCreationOnModelCN.class, 
	TestNodeCreationOnModelCompartment.class,
	TestNodeCreationOnModelCompartmentCN.class, 
	TestNodeCreationOnPackage.class, 
	TestNodeCreationOnPackageCN.class,
	TestNodeCreationOnPackageCompartment.class,
	TestNodeCreationOnPackageCompartmentCN.class })
public class AllCreationInheritedTests {

}
