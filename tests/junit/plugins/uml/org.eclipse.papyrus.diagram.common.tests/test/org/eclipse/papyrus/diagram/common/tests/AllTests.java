/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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

package org.eclipse.papyrus.diagram.common.tests;

import org.eclipse.papyrus.diagram.common.tests.css.Bug431694_UndoDeleteTest;
import org.eclipse.papyrus.diagram.common.tests.parser.HTMLCleanerTestCase;
import org.eclipse.papyrus.diagram.common.tests.parser.HTMLCornerBentFigureTestCase;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * All tests together
 */
@RunWith(Suite.class)
@SuiteClasses({ HTMLCleanerTestCase.class, HTMLCornerBentFigureTestCase.class, Bug431694_UndoDeleteTest.class })
public class AllTests {


}
