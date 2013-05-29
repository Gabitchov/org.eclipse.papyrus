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
 *   CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.tests.bug;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * All tests for bug.
 */
@RunWith(Suite.class)
@SuiteClasses({ TestCombinedFragmentKind_364710.class, TestCombinedFragmentOperand_364701.class, TestLifelineAlignment_364688.class, TestMessageEndConstraint_364817.class, TestMessagesDeletion_364828.class, TestMovingCombinedFragment_364711.class, TestNestedCombinedFragment_364795.class, TestSynchronousMessageCreation_364827.class, /*
																																																																																			 * TestCombinedFragmentGates_364816
																																																																																			 * .
																																																																																			 * class
																																																																																			 * ,
																																																																																			 */TestCombinedFragmentDeletion_364804.class, TestDecompositionCombinedFragment_364813.class, TestDecompositionMove_364812.class, TestAdvancedDragDrop_364696.class, TestGuardEdition_364808.class, TestObservationLink_364826.class })
public class BugTests {

}
