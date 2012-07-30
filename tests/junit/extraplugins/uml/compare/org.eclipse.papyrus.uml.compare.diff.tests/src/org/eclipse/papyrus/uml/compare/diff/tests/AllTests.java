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

import org.eclipse.papyrus.uml.compare.diff.tests.nested.NestedAttributeChangeLeftTargetTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.NestedAttributeChangeLeftTargetTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.NestedAttributeChangeRightTargetTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.NestedAttributeChangeRightTargetTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.NestedAttributeOrderChangeTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.NestedAttributeOrderChangeTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.NestedModelElementChangeLeftTargetTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.NestedModelElementChangeLeftTargetTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.NestedModelElementChangeRightTargetTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.NestedModelElementChangeRightTargetTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.NestedMoveModelElementTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.NestedMoveModelElementTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.NestedMoveModelElementTest_2_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.NestedMoveModelElementTest_2_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.NestedUpdateAttributeTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.NestedUpdateAttributeTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.bugs.NestedModelElementChangeLeftTarget_CopyReferenceTest_bug386052_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.bugs.NestedModelElementChangeRightTarget_CopyReferenceTest_bug386052_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.options.NestedAttributeChangeLeftTargetMergeOptionsEnablementTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.options.NestedAttributeChangeLeftTargetMergeOptionsEnablementTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.options.NestedAttributeChangeRightTargetMergeOptionsEnablementTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.nested.options.NestedAttributeChangeRightTargetMergeOptionsEnablementTest_1_RightToLeft;
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
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.options.AttributeChangeLeftTargetMergeOptionsEnablementTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.options.AttributeChangeLeftTargetMergeOptionsEnablementTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.options.AttributeChangeRightTargetMergeOptionsEnablementTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.standalone.options.AttributeChangeRightTargetMergeOptionsEnablementTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.nested.oneresource.NestedUpdateAttributeLeftResourceTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.nested.oneresource.NestedUpdateAttributeRightResourceTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.nested.oneresource.NestedUpdateAttributeRightResourcetTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.nested.NestedStereotypeApplicationAdditionTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.nested.NestedStereotypeApplicationAdditionTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.nested.NestedStereotypeApplicationAdditionTest_2_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.nested.NestedStereotypeApplicationAdditionTest_2_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.nested.NestedStereotypeApplicationRemovalTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.nested.NestedStereotypeApplicationRemovalTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.nested.NestedStereotypeApplicationRemovalTest_2_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.nested.NestedStereotypeApplicationRemovalTest_2_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.standalone.UMLProfileApplicationAddition_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.standalone.UMLProfileApplicationAddition_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.standalone.UMLProfileApplicationRemoval_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.standalone.UMLProfileApplicationRemoval_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.standalone.UMLStereotypeApplicationAddition_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.standalone.UMLStereotypeApplicationAddition_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.standalone.UMLStereotypeApplicationRemoval_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.standalone.UMLStereotypeApplicationRemoval_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.standalone.UMLStereotypeAttributeChangeLeftTarget_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.standalone.UMLStereotypeAttributeChangeLeftTarget_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.standalone.UMLStereotypeAttributeChangeRightTarget_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.standalone.UMLStereotypeAttributeChangeRightTarget_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.standalone.UMLStereotypeReferenceChangeLeftTarget_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.standalone.UMLStereotypeReferenceChangeLeftTarget_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.standalone.UMLStereotypeReferenceChangeRightTarget_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.standalone.UMLStereotypeReferenceChangeRightTarget_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.standalone.UMLStereotypeReferenceOrderChange_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.standalone.UMLStereotypeReferenceOrderChange_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.standalone.UMLStereotypeUpdateAttribute_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.standalone.UMLStereotypeUpdateAttribute_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.standalone.UMLStereotypeUpdateReference_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.profile.standalone.UMLStereotypeUpdateReference_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.standalone.GeneralizationSourceChangedTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.standalone.GeneralizationSourceChangedTest_1_RightToLeft;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.standalone.GeneralizationTargetChangedTest_1_LeftToRight;
import org.eclipse.papyrus.uml.compare.diff.tests.uml.standalone.GeneralizationTargetChangedTest_1_RightToLeft;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({

//------------------------------------------ tests for DiffElement in nested mode
NestedAttributeChangeLeftTargetTest_1_LeftToRight.class, NestedAttributeChangeLeftTargetTest_1_RightToLeft.class,

NestedAttributeChangeRightTargetTest_1_LeftToRight.class, NestedAttributeChangeRightTargetTest_1_RightToLeft.class,

NestedAttributeOrderChangeTest_1_LeftToRight.class, NestedAttributeOrderChangeTest_1_RightToLeft.class,

NestedModelElementChangeRightTargetTest_1_LeftToRight.class, NestedModelElementChangeRightTargetTest_1_RightToLeft.class,

NestedModelElementChangeLeftTargetTest_1_LeftToRight.class, NestedModelElementChangeLeftTargetTest_1_RightToLeft.class,

NestedMoveModelElementTest_1_LeftToRight.class, NestedMoveModelElementTest_1_RightToLeft.class,

NestedMoveModelElementTest_2_LeftToRight.class, NestedMoveModelElementTest_2_RightToLeft.class,

NestedUpdateAttributeTest_1_LeftToRight.class, NestedUpdateAttributeTest_1_RightToLeft.class,
//------------------------------------------ tests for UML DiffElement in nested mode
NestedStereotypeApplicationAdditionTest_1_LeftToRight.class, NestedStereotypeApplicationAdditionTest_1_RightToLeft.class,

NestedStereotypeApplicationAdditionTest_2_LeftToRight.class, NestedStereotypeApplicationAdditionTest_2_RightToLeft.class,

NestedStereotypeApplicationRemovalTest_1_LeftToRight.class, NestedStereotypeApplicationRemovalTest_1_RightToLeft.class,

NestedStereotypeApplicationRemovalTest_2_LeftToRight.class, NestedStereotypeApplicationRemovalTest_2_RightToLeft.class,

NestedUpdateAttributeLeftResourceTest_1_RightToLeft.class, NestedUpdateAttributeLeftResourceTest_1_RightToLeft.class,

NestedUpdateAttributeRightResourceTest_1_LeftToRight.class, NestedUpdateAttributeRightResourcetTest_1_RightToLeft.class,

//------------------------------------------ tests for options in nested mode
NestedAttributeChangeLeftTargetMergeOptionsEnablementTest_1_LeftToRight.class, NestedAttributeChangeLeftTargetMergeOptionsEnablementTest_1_RightToLeft.class,

NestedAttributeChangeRightTargetMergeOptionsEnablementTest_1_LeftToRight.class, NestedAttributeChangeRightTargetMergeOptionsEnablementTest_1_RightToLeft.class,

//------------------------------------------ others nested tests
NestedModelElementChangeLeftTarget_CopyReferenceTest_bug386052_LeftToRight.class, NestedModelElementChangeRightTarget_CopyReferenceTest_bug386052_RightToLeft.class,

//------------------------------------------ tests for DiffElement in standalone mode
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

//------------------------------------------ tests for options in standalone mode
AttributeChangeLeftTargetMergeOptionsEnablementTest_1_LeftToRight.class, AttributeChangeLeftTargetMergeOptionsEnablementTest_1_RightToLeft.class,

AttributeChangeRightTargetMergeOptionsEnablementTest_1_LeftToRight.class, AttributeChangeRightTargetMergeOptionsEnablementTest_1_RightToLeft.class,

//------------------------------------------ tests for UML DiffElement in standalone mode
GeneralizationSourceChangedTest_1_LeftToRight.class, GeneralizationSourceChangedTest_1_RightToLeft.class,

GeneralizationTargetChangedTest_1_LeftToRight.class, GeneralizationTargetChangedTest_1_RightToLeft.class,

UMLProfileApplicationAddition_1_LeftToRight.class, UMLProfileApplicationAddition_1_RightToLeft.class,

UMLProfileApplicationRemoval_1_LeftToRight.class, UMLProfileApplicationRemoval_1_RightToLeft.class,

UMLStereotypeApplicationAddition_1_LeftToRight.class, UMLStereotypeApplicationAddition_1_RightToLeft.class,

UMLStereotypeApplicationRemoval_1_LeftToRight.class, UMLStereotypeApplicationRemoval_1_RightToLeft.class,

UMLStereotypeAttributeChangeLeftTarget_1_LeftToRight.class, UMLStereotypeAttributeChangeLeftTarget_1_RightToLeft.class,

UMLStereotypeAttributeChangeRightTarget_1_LeftToRight.class, UMLStereotypeAttributeChangeRightTarget_1_RightToLeft.class,

UMLStereotypeReferenceChangeLeftTarget_1_LeftToRight.class, UMLStereotypeReferenceChangeLeftTarget_1_RightToLeft.class,

UMLStereotypeReferenceChangeRightTarget_1_LeftToRight.class, UMLStereotypeReferenceChangeRightTarget_1_RightToLeft.class,

UMLStereotypeReferenceOrderChange_1_LeftToRight.class, UMLStereotypeReferenceOrderChange_1_RightToLeft.class,

UMLStereotypeUpdateAttribute_1_LeftToRight.class, UMLStereotypeUpdateAttribute_1_RightToLeft.class,

UMLStereotypeUpdateReference_1_LeftToRight.class, UMLStereotypeUpdateReference_1_RightToLeft.class, })
public class AllTests {
	// JUnit 4 test suite
}
