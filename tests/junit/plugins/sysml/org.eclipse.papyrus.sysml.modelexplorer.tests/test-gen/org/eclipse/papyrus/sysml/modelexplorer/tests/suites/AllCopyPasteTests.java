	/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 * @generated
 *****************************************************************************/
package org.eclipse.papyrus.sysml.modelexplorer.tests.suites;

import org.eclipse.papyrus.sysml.modelexplorer.tests.copypaste.CopyPasteSimpleBlock2Test;
import org.eclipse.papyrus.sysml.modelexplorer.tests.copypaste.CopyPasteSimpleBlockTest;
import org.eclipse.papyrus.sysml.modelexplorer.tests.copypaste.CopyPasteSimplePartTest;
import org.eclipse.papyrus.sysml.modelexplorer.tests.copypaste.CopyPasteSimpleReferenceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * Tests suite for Copy/Paste
 * @generated
 */
@RunWith(Suite.class)
@SuiteClasses({
// Reference
CopyPasteSimpleReferenceTest.class,
// Block
CopyPasteSimpleBlockTest.class,
CopyPasteSimpleBlock2Test.class,
// Part
CopyPasteSimplePartTest.class,

})
public class AllCopyPasteTests {

}
