/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.tests.canonical;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

//@formatter:off
@RunWith(Suite.class)
@SuiteClasses({ TestTimingDiagramInteraction.class, TestTimingDiagramFullLifeline.class, TestTimingDiagramCompactLifeline.class,

TestTimingDiagramFullStateInvariant.class, TestTimingDiagramCompactStateInvariant.class,

TestTimingDiagramFullOccurrenceSpecification.class, TestTimingDiagramCompactOccurrenceSpecification.class,

TestTimingDiagramStateDefinition.class, TestTimingDiagramFullLifelineLayout.class,

TestTimingDiagramMessages.class, })
//@formatter:on
public class AllCanonicalTests {
	// Junit 4 test case
}
