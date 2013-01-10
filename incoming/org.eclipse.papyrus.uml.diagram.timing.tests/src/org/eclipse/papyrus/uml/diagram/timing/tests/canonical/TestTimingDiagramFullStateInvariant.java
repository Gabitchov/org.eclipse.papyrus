/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.tests.canonical;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullStateInvariantEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.StateDefinitionEditPart;
import org.junit.Test;

public class TestTimingDiagramFullStateInvariant extends AbstractTimingDiagramTestCase {

	@Override
	public void setUp() throws Exception {
		// create the project, model and diagram
		super.setUp();
		createDefaultInteraction(new Point(0, 0), new Dimension(800, 600));
		createDefaultFullLifeline();
		createThreeStateDefinitionsInDefaultFullLifeline();
		createThreeOccurrenceSpecificationsInDefaultFullLifeline();
	}

	@Test
	public void testMoveStateInvariants() {
		final List<FullStateInvariantEditPartCN> stateInvariantEditParts = findStateInvariantsInDefaultFullLifeline();
		assertEquals("We should have 4 StateInvariants at the beginning of this test", 4, stateInvariantEditParts.size());
		final List<StateDefinitionEditPart> stateDefinitionEditParts = findStateDefinitions();
		assertEquals("We should have 3 StateDefinitions at the beginning of this test", 3, stateDefinitionEditParts.size());

		// computeTimelineStringPattern();
		checkFullTimelinePattern("StateInvariant(State 1);OccurrenceSpecification(State 1_1_To_State 1_2);VerticalLine;" + "StateInvariant(State 1);OccurrenceSpecification(State 1_2_To_State 1_3);VerticalLine;" + "StateInvariant(State 1);OccurrenceSpecification(State 1_3_To_State 1_4);VerticalLine;" + "StateInvariant(State 1);");

		final Rectangle stateDefBounds1 = getAbsoluteBounds(stateDefinitionEditParts.get(0));
		final Rectangle stateDefBounds2 = getAbsoluteBounds(stateDefinitionEditParts.get(1));
		// final Rectangle stateDefBounds3 = getAbsoluteBounds(stateDefinitionEditParts.get(2));
		final int distanceBetweenStates = stateDefBounds2.y - stateDefBounds1.y;

		// final Rectangle stateInvBounds1 = getAbsoluteBounds(stateInvariantEditParts.get(0));
		// final Rectangle stateInvBounds2 = getAbsoluteBounds(stateInvariantEditParts.get(1));
		// final Rectangle stateInvBounds3 = getAbsoluteBounds(stateInvariantEditParts.get(2));
		// final Rectangle stateInvBounds4 = getAbsoluteBounds(stateInvariantEditParts.get(3));

		// TODO: check state invariant in front of state definitions

		moveEditPart(stateInvariantEditParts.get(0), getDefaultFullLifelineTimelineCompartment(), new Point(0, distanceBetweenStates));
		checkFullTimelinePattern("StateInvariant(State 2);OccurrenceSpecification(State 2_1_To_State 1_1);VerticalLine;" + "StateInvariant(State 1);OccurrenceSpecification(State 1_1_To_State 1_2);VerticalLine;" + "StateInvariant(State 1);OccurrenceSpecification(State 1_2_To_State 1_3);VerticalLine;StateInvariant(State 1);");
		moveEditPart(stateInvariantEditParts.get(1), getDefaultFullLifelineTimelineCompartment(), new Point(0, 2 * distanceBetweenStates));
		checkFullTimelinePattern("StateInvariant(State 2);OccurrenceSpecification(State 2_1_To_State 3_1);VerticalLine;" + "StateInvariant(State 3);OccurrenceSpecification(State 3_1_To_State 1_1);VerticalLine;" + "StateInvariant(State 1);OccurrenceSpecification(State 1_1_To_State 1_2);VerticalLine;StateInvariant(State 1);");
		moveEditPart(stateInvariantEditParts.get(3), getDefaultFullLifelineTimelineCompartment(), new Point(0, distanceBetweenStates));
		checkFullTimelinePattern("StateInvariant(State 2);OccurrenceSpecification(State 2_1_To_State 3_1);VerticalLine;" + "StateInvariant(State 3);OccurrenceSpecification(State 3_1_To_State 1_1);VerticalLine;" + "StateInvariant(State 1);OccurrenceSpecification(State 1_1_To_State 2_2);VerticalLine;StateInvariant(State 2);");
		moveEditPart(stateInvariantEditParts.get(3), getDefaultFullLifelineTimelineCompartment(), new Point(0, distanceBetweenStates));
		checkFullTimelinePattern("StateInvariant(State 2);OccurrenceSpecification(State 2_1_To_State 3_1);VerticalLine;" + "StateInvariant(State 3);OccurrenceSpecification(State 3_1_To_State 1_1);VerticalLine;" + "StateInvariant(State 1);OccurrenceSpecification(State 1_1_To_State 3_2);VerticalLine;StateInvariant(State 3);");
		moveEditPart(stateInvariantEditParts.get(2), getDefaultFullLifelineTimelineCompartment(), new Point(0, 2 * distanceBetweenStates));
		checkFullTimelinePattern("StateInvariant(State 2);OccurrenceSpecification(State 2_1_To_State 3_1);VerticalLine;" + "StateInvariant(State 3);OccurrenceSpecification(State 3_1_To_State 3_2);VerticalLine;" + "StateInvariant(State 3);OccurrenceSpecification(State 3_2_To_State 3_3);VerticalLine;StateInvariant(State 3);");
		moveEditPart(stateInvariantEditParts.get(2), getDefaultFullLifelineTimelineCompartment(), new Point(0, -distanceBetweenStates));
		checkFullTimelinePattern("StateInvariant(State 2);OccurrenceSpecification(State 2_1_To_State 3_1);VerticalLine;" + "StateInvariant(State 3);OccurrenceSpecification(State 3_1_To_State 2_2);VerticalLine;" + "StateInvariant(State 2);OccurrenceSpecification(State 2_2_To_State 3_2);VerticalLine;StateInvariant(State 3);");
		moveEditPart(stateInvariantEditParts.get(1), getDefaultFullLifelineTimelineCompartment(), new Point(0, -2 * distanceBetweenStates));
		checkFullTimelinePattern("StateInvariant(State 2);OccurrenceSpecification(State 2_1_To_State 1_1);VerticalLine;" + "StateInvariant(State 1);OccurrenceSpecification(State 1_1_To_State 2_2);VerticalLine;" + "StateInvariant(State 2);OccurrenceSpecification(State 2_2_To_State 3_1);VerticalLine;StateInvariant(State 3);");
	}

	@Test
	public void testDeleteStateInvariants() {
		checkInteractionFragmentsWithPattern("-o-o-o-");
		checkSimpleFullTimelinePattern("-o|-o|-o|-");
		final FullStateInvariantEditPartCN stateInvariantEditPart = findStateInvariantsInDefaultFullLifeline().get(1);
		executeDestroyCommand(stateInvariantEditPart);
		checkInteractionFragmentsWithPattern("-o-o-");
		checkSimpleFullTimelinePattern("-o|-o|-");
		undoOnUIThread();
		checkInteractionFragmentsWithPattern("-o-o-o-");
		checkSimpleFullTimelinePattern("-o|-o|-o|-");
		redoOnUIThread();
		checkInteractionFragmentsWithPattern("-o-o-");
		checkSimpleFullTimelinePattern("-o|-o|-");
	}

	@Test
	public void testHideStateInvariants() {
		checkInteractionFragmentsWithPattern("-o-o-o-");
		checkSimpleFullTimelinePattern("-o|-o|-o|-");
		final FullStateInvariantEditPartCN stateInvariantEditPart = findStateInvariantsInDefaultFullLifeline().get(1);
		executeHideCommand(stateInvariantEditPart);
		checkInteractionFragmentsWithPattern("-o-o-o-");
		checkSimpleFullTimelinePattern("-o|-o|-");
		undoOnUIThread();
		checkInteractionFragmentsWithPattern("-o-o-o-");
		checkSimpleFullTimelinePattern("-o|-o|-o|-");
		redoOnUIThread();
		checkInteractionFragmentsWithPattern("-o-o-o-");
		checkSimpleFullTimelinePattern("-o|-o|-");
	}
}
