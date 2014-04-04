/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.tests.canonical;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.junit.utils.classification.FailingTest;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.InteractionEditPartTN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.StateDefinitionEditPart;
import org.junit.Test;

public class TestTimingDiagramFullLifelineLayout extends AbstractTimingDiagramTestCase {

	/**
	 * This tests the layout of StateDefinitions, with some error margins in order to accommodate possible future
	 * modifications of the layout.
	 */
	@FailingTest("To be verified. Seems to work for standard user, but not in raw test environment")
	@Test
	public void testStateDefinitionsLayout() {
		final Point interactionLocation = new Point(12, 17);
		final Dimension interactionSize = new Dimension(867, 729);
		final InteractionEditPartTN interactionEditPart = createInteraction(interactionLocation, interactionSize);
		assertBounds(interactionEditPart, interactionLocation, interactionSize, 0, 0, 0, 0);
		final FullLifelineEditPartCN lifelineEditPart = createFullLifeline(interactionEditPart);
		assertBounds(lifelineEditPart, new Rectangle(23, 45, 845, 694), 50, 50, 100, 100);
		// a single StateDefinition: should be centered
		final StateDefinitionEditPart stateDefinition1 = createStateDefinition(lifelineEditPart);
		assertBounds(stateDefinition1, new Rectangle(84, 382, 40, 20), 50, 50, 30, 10);
		// two StateDefinitions: should be regularly spaced
		final StateDefinitionEditPart stateDefinition2 = createStateDefinition(lifelineEditPart);
		assertBounds(stateDefinition1, new Rectangle(84, 266, 40, 20), 50, 50, 30, 10);
		assertBounds(stateDefinition2, new Rectangle(84, 498, 40, 20), 50, 50, 30, 10);
		// three StateDefinitions: should be regularly spaced
		final StateDefinitionEditPart stateDefinition3 = createStateDefinition(lifelineEditPart);
		assertBounds(stateDefinition1, new Rectangle(84, 151, 40, 20), 50, 50, 30, 10);
		assertBounds(stateDefinition2, new Rectangle(84, 382, 40, 20), 50, 50, 30, 10);
		assertBounds(stateDefinition3, new Rectangle(84, 613, 40, 20), 50, 50, 30, 10);
	}
}
