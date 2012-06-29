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
package org.eclipse.papyrus.uml.compare.diff.tests;

import org.eclipse.papyrus.uml.compare.diff.tests.nested.NestedModelElementChangeLeftTargetTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.NestedModelElementChangeLeftTargetTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.NestedModelElementChangeRightTargetTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.NestedModelElementChangeRightTargetTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.NestedUpdateAttributeTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.NestedUpdateAttributeTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.AttributeChangeLeftTargetTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.AttributeChangeLeftTargetTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.AttributeChangeRightTargetTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.AttributeChangeRightTargetTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.ModelElementChangeLeftTargetTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.ModelElementChangeLeftTargetTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.ModelElementChangeRightTargetTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.ModelElementChangeRightTargetTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.MoveModelElementTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.MoveModelElementTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.MoveModelElementTest_2_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.MoveModelElementTest_2_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.ReferenceChangeLeftTargetTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.ReferenceChangeLeftTargetTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.ReferenceChangeRightTargetTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.ReferenceChangeRightTargetTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.ReferenceOrderChangeTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.ReferenceOrderChangeTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.UpdateAttributeTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.UpdateAttributeTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.UpdateReferenceTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.UpdateReferenceTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.UpdateReferenceTest_2_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.UpdateReferenceTest_2_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.standalone.GeneralizationSourceChangedTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.standalone.GeneralizationSourceChangedTest_1_RightToLeft;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({

NestedModelElementChangeRightTargetTest_1_LeftToRight.class, NestedModelElementChangeRightTargetTest_1_RightToLeft.class,

NestedModelElementChangeLeftTargetTest_1_LeftToRight.class, NestedModelElementChangeLeftTargetTest_1_RightToLeft.class,

NestedUpdateAttributeTest_1_LeftToRight.class, NestedUpdateAttributeTest_1_RightToLeft.class,

AttributeChangeLeftTargetTest_1_LeftToRight.class, AttributeChangeLeftTargetTest_1_RightToLeft.class,

AttributeChangeRightTargetTest_1_LeftToRight.class, AttributeChangeRightTargetTest_1_RightToLeft.class,

ModelElementChangeLeftTargetTest_1_LeftToRight.class, ModelElementChangeLeftTargetTest_1_RightToLeft.class,

ModelElementChangeRightTargetTest_1_LeftToRight.class, ModelElementChangeRightTargetTest_1_RightToLeft.class,

MoveModelElementTest_1_LeftToRight.class, MoveModelElementTest_1_RightToLeft.class,

MoveModelElementTest_2_LeftToRight.class, MoveModelElementTest_2_RightToLeft.class,

ReferenceChangeLeftTargetTest_1_LeftToRight.class, ReferenceChangeLeftTargetTest_1_RightToLeft.class,

ReferenceChangeRightTargetTest_1_LeftToRight.class, ReferenceChangeRightTargetTest_1_RightToLeft.class,

ReferenceOrderChangeTest_1_LeftToRight.class, ReferenceOrderChangeTest_1_RightToLeft.class,

UpdateAttributeTest_1_LeftToRight.class, UpdateAttributeTest_1_RightToLeft.class,

UpdateReferenceTest_1_LeftToRight.class, UpdateReferenceTest_1_RightToLeft.class,

UpdateReferenceTest_2_LeftToRight.class, UpdateReferenceTest_2_RightToLeft.class,

GeneralizationSourceChangedTest_1_LeftToRight.class, GeneralizationSourceChangedTest_1_RightToLeft.class })
public class AllTests {
	// JUnit 4 test suite
}