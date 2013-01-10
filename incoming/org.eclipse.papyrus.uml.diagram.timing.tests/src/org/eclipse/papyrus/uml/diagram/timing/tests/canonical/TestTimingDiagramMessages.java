/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.tests.canonical;

import org.eclipse.swt.widgets.Text;
import org.junit.Test;

public class TestTimingDiagramMessages extends AbstractTimingDiagramTestCase {

	@Override
	public void setUp() throws Exception {
		// create the project, model and diagram
		super.setUp();
		createDefaultInteraction();
		createDefaultFullLifeline();
		createDefaultCompactLifeline();
		createStateDefinitionInDefaultFullLifeline();
		createThreeOccurrenceSpecificationsInDefaultFullLifeline();
		createThreeOccurrenceSpecificationsInDefaultCompactLifeline();
	}

	@Test
	public void testCreateSyncMessage() {
		clickTwiceWithTool("createMessageSyncCreationTool", findOccurrenceSpecificationsInDefaultFullLifeline().get(0), findOccurrenceSpecificationsInDefaultCompactLifeline().get(1));
		final Text text = findVisibleTextWidgetOnDiagram();
		setText(text, "abc");

		checkSimpleFullTimelinePattern("-m|-o|-o|-");
		checkSimpleCompactTimelinePattern("-o-m-o-");
		checkInteractionFragmentsWithPattern("--m-o-o-o-m-o-");

		// TODO: check covered fragments on lifelines
		// TODO: check sync Message instance
	}

	@Test
	public void testCreateAsyncMessage() {
		clickTwiceWithTool("createMessageAsyncCreationTool", findOccurrenceSpecificationsInDefaultFullLifeline().get(0), findOccurrenceSpecificationsInDefaultCompactLifeline().get(1));
		final Text text = findVisibleTextWidgetOnDiagram();
		setText(text, "def");
		// TODO: check async Message instance
	}

}
