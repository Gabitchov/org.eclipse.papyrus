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
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.suites;

import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.copypaste.TestCopyGraphicallyPasteBlock;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.copypaste.TestCopyPasteElementsWithDiagrams;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * Test suite for Copy/Paste/PasteWithModel actions
 */
@RunWith(Suite.class)
@SuiteClasses({ 
 TestCopyGraphicallyPasteBlock.class,
 TestCopyPasteElementsWithDiagrams.class
})
public class AllCopyPasteTests {
}
