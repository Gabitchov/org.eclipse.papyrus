/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.merger.tests;

import org.eclipse.papyrus.uml.compare.merger.tests.standalone.AttributeChangeLeftTargetTest_1;
import org.eclipse.papyrus.uml.compare.merger.tests.standalone.AttributeChangeRightTargetTest_1;
import org.eclipse.papyrus.uml.compare.merger.tests.standalone.ModelElementChangeLeftTargetTest_1;
import org.eclipse.papyrus.uml.compare.merger.tests.standalone.ModelElementChangeLeftTargetTest_2;
import org.eclipse.papyrus.uml.compare.merger.tests.standalone.ModelElementChangeRightTargetTest_1;
import org.eclipse.papyrus.uml.compare.merger.tests.standalone.MoveModelElementTest_1;
import org.eclipse.papyrus.uml.compare.merger.tests.standalone.MoveModelElementTest_2;
import org.eclipse.papyrus.uml.compare.merger.tests.standalone.ReferenceChangeLeftTargetTest_1;
import org.eclipse.papyrus.uml.compare.merger.tests.standalone.ReferenceChangeLeftTargetTest_2;
import org.eclipse.papyrus.uml.compare.merger.tests.standalone.ReferenceOrderChangeTest_1;
import org.eclipse.papyrus.uml.compare.merger.tests.standalone.UpdateAttributeTest_1;
import org.eclipse.papyrus.uml.compare.merger.tests.standalone.UpdateReferenceTest_1;
import org.eclipse.papyrus.uml.compare.merger.tests.standalone.UpdateReferenceTest_2;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AttributeChangeLeftTargetTest_1.class, AttributeChangeRightTargetTest_1.class, ModelElementChangeLeftTargetTest_1.class, ModelElementChangeLeftTargetTest_2.class, ModelElementChangeRightTargetTest_1.class, MoveModelElementTest_1.class, MoveModelElementTest_2.class, ReferenceChangeLeftTargetTest_1.class, ReferenceChangeLeftTargetTest_2.class, ReferenceOrderChangeTest_1.class, UpdateAttributeTest_1.class, UpdateReferenceTest_1.class, UpdateReferenceTest_2.class })
public class AllTests {
	// JUnit 4 test suite
}
