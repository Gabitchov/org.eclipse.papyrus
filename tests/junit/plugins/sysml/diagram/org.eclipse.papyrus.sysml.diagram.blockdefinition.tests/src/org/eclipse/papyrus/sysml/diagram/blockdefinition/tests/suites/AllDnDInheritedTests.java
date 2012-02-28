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

import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.dnd.inherited.TestNodeDropOnComment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.dnd.inherited.TestNodeDropOnCommentCN;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.dnd.inherited.TestNodeDropOnConstraint;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.dnd.inherited.TestNodeDropOnConstraintCN;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.dnd.inherited.TestNodeDropOnInstanceSpecification;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.dnd.inherited.TestNodeDropOnInstanceSpecificationCN;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.dnd.inherited.TestNodeDropOnInstanceSpecificationCompartment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.dnd.inherited.TestNodeDropOnInstanceSpecificationCompartmentCN;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.dnd.inherited.TestNodeDropOnModel;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.dnd.inherited.TestNodeDropOnModelCN;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.dnd.inherited.TestNodeDropOnModelCompartment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.dnd.inherited.TestNodeDropOnModelCompartmentCN;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.dnd.inherited.TestNodeDropOnPackage;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.dnd.inherited.TestNodeDropOnPackageCN;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.dnd.inherited.TestNodeDropOnPackageCompartment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.dnd.inherited.TestNodeDropOnPackageCompartmentCN;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
	TestNodeDropOnComment.class,
	TestNodeDropOnCommentCN.class,
	TestNodeDropOnConstraint.class,
	TestNodeDropOnConstraintCN.class,
	TestNodeDropOnInstanceSpecification.class,
	TestNodeDropOnInstanceSpecificationCN.class, 
	TestNodeDropOnInstanceSpecificationCompartment.class,
	TestNodeDropOnInstanceSpecificationCompartmentCN.class, 
	TestNodeDropOnModel.class,
	TestNodeDropOnModelCN.class,
	TestNodeDropOnModelCompartment.class, 
	TestNodeDropOnModelCompartmentCN.class, 
	TestNodeDropOnPackage.class, 
	TestNodeDropOnPackageCN.class,
	TestNodeDropOnPackageCompartment.class,
	TestNodeDropOnPackageCompartmentCN.class })
public class AllDnDInheritedTests {

}
