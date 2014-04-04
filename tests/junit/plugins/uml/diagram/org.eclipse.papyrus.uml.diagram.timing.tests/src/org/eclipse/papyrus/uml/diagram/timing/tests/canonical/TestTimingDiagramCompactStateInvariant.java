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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.junit.utils.classification.FailingTest;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EditPartUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.StateInvariantUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactStateInvariantEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactStateInvariantNameEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.OccurrenceSpecificationEditPartCN;
import org.eclipse.uml2.uml.StateInvariant;
import org.junit.Test;

public class TestTimingDiagramCompactStateInvariant extends AbstractTimingDiagramTestCase {

	@Override
	public void setUp() throws Exception {
		// create the project, model and diagram
		super.setUp();
		createDefaultInteraction();
		createDefaultCompactLifeline();
	}

	@FailingTest("To be verified. Seems to work for standard user, but not in raw test environment")
	@Test
	public void testCutCompactStateInvariants() {
		final List<CompactStateInvariantEditPartCN> stateInvariantEditParts = findStateInvariantsInDefaultCompactLifeline();
		assertEquals("We should have one StateInvariant at the beginning of this test", 1, stateInvariantEditParts.size());
		checkCompactTimelinePattern("StateInvariant(unnamed);");
		createOccurrenceSpecificationInLastCompactStateInvariantWithRatio(1, 1.0 / 4.0);
		checkCompactTimelinePattern("StateInvariant(unnamed);OccurrenceSpecification(<unnamed>_To_<unnamed>);StateInvariant(unnamed);");
		createOccurrenceSpecificationInLastCompactStateInvariantWithRatio(2, 1.0 / 3.0);
		createOccurrenceSpecificationInLastCompactStateInvariantWithRatio(3, 1.0 / 2.0);
		checkSimpleCompactTimelinePattern("-o-o-o-");
		checkCompactTimelinePattern("StateInvariant(unnamed);OccurrenceSpecification(<unnamed>_To_<unnamed>);StateInvariant(unnamed);" + "OccurrenceSpecification(<unnamed>_To_<unnamed>);StateInvariant(unnamed);OccurrenceSpecification(<unnamed>_To_<unnamed>);StateInvariant(unnamed);");
	}

	@FailingTest("To be verified. Seems to work for standard user, but not in raw test environment")
	@Test
	public void testEditCompactStateInvariantName() {
		createThreeOccurrenceSpecificationsInDefaultCompactLifeline();
		checkSimpleCompactTimelinePattern("-o-o-o-");
		final List<CompactStateInvariantEditPartCN> stateInvariantEditParts = findStateInvariantsInDefaultCompactLifeline();
		assertEquals("We should have four StateInvariants", 4, stateInvariantEditParts.size());
		int i = 1;
		for(final CompactStateInvariantEditPartCN stateInvariantEditPart : stateInvariantEditParts) {
			final CompactStateInvariantNameEditPart nameEditPart = (CompactStateInvariantNameEditPart)EditPartUtils.findFirstChildEditPartWithId(stateInvariantEditPart, CompactStateInvariantNameEditPart.VISUAL_ID);
			assertNotNull("The name edit part must not be null", nameEditPart);
			final StateInvariant stateInvariant = (StateInvariant)((View)stateInvariantEditPart.getModel()).getElement();
			testSetNameWithDirectEditRequest(nameEditPart, stateInvariant, new INameProvider<StateInvariant>() {

				@Override
				public String getName(final StateInvariant stateInvariant) {
					return StateInvariantUtils.getInnerStateInvariantName(stateInvariant);
				}
			});
			setNameWithDirectEditRequest(nameEditPart, "state" + (i % 2 + 1));
			i++;
		}
		checkCompactTimelinePattern("StateInvariant(state2);OccurrenceSpecification(state2_1_To_state1_1);StateInvariant(state1);" + "OccurrenceSpecification(state1_1_To_state2_2);StateInvariant(state2);OccurrenceSpecification(state2_2_To_state1_2);StateInvariant(state1);");
	}

	@Test
	@FailingTest("To be verified. Seems to work for standard user, but not in raw test environment")
	public void testDeleteStateInvariants() {
		createThreeOccurrenceSpecificationsInDefaultCompactLifeline();
		checkInteractionFragmentsWithPattern("-o-o-o-");
		checkSimpleCompactTimelinePattern("-o-o-o-");
		final CompactStateInvariantEditPartCN compactStateInvariantEditPart = findStateInvariantsInDefaultCompactLifeline().get(1);
		executeDestroyCommand(compactStateInvariantEditPart);
		checkInteractionFragmentsWithPattern("-o-o-");
		checkSimpleCompactTimelinePattern("-o-o-");
		undoOnUIThread();
		checkInteractionFragmentsWithPattern("-o-o-o-");
		checkSimpleCompactTimelinePattern("-o-o-o-");
		redoOnUIThread();
		checkInteractionFragmentsWithPattern("-o-o-");
		checkSimpleCompactTimelinePattern("-o-o-");
	}

	@FailingTest("To be verified. Seems to be failing in all environments; not related to the DirectEdit issue")
	@Test
	public void testDeleteStateInvariantsWithOccurrencesOnTop() {
		createThreeOccurrenceSpecificationsInDefaultCompactLifeline();
		checkInteractionFragmentsWithPattern("-o-o-o-");
		checkSimpleCompactTimelinePattern("-o-o-o-");
		final CompactStateInvariantEditPartCN s1 = findStateInvariantsInDefaultCompactLifeline().get(0);
		final CompactStateInvariantEditPartCN s2 = findStateInvariantsInDefaultCompactLifeline().get(1);
		final CompactStateInvariantEditPartCN s3 = findStateInvariantsInDefaultCompactLifeline().get(2);
		final CompactStateInvariantEditPartCN s4 = findStateInvariantsInDefaultCompactLifeline().get(3);
		createOccurrenceSpecificationOverCompactStateInvariant(s1, true);
		createOccurrenceSpecificationOverCompactStateInvariant(s2, false);
		createOccurrenceSpecificationOverCompactStateInvariant(s3, false);
		createOccurrenceSpecificationOverCompactStateInvariant(s4, true);
		flushEventLoop();
		checkInteractionFragmentsWithPattern("-oo-oo-oo-o");
		checkSimpleCompactTimelinePattern("-oo-oo-oo-o");

		executeDestroyCommand(s1);
		checkInteractionFragmentsWithPattern("-oo-oo-o");
		checkSimpleCompactTimelinePattern("-oo-oo-o");
		undoOnUIThread();
		checkInteractionFragmentsWithPattern("-oo-oo-oo-o");
		checkSimpleCompactTimelinePattern("-oo-oo-oo-o");
		redoOnUIThread();
		checkInteractionFragmentsWithPattern("-oo-oo-o");
		checkSimpleCompactTimelinePattern("-oo-oo-o");

		executeDestroyCommand(s4);
		checkInteractionFragmentsWithPattern("-oo-o");
		checkSimpleCompactTimelinePattern("-oo-o");

		executeDestroyCommand(s2);
		checkInteractionFragmentsWithPattern("-o");
		checkSimpleCompactTimelinePattern("-o");
	}

	@FailingTest("To be verified. Seems to work for standard user, but not in raw test environment")
	@Test
	public void testHideStateInvariants() {
		createThreeOccurrenceSpecificationsInDefaultCompactLifeline();
		checkInteractionFragmentsWithPattern("-o-o-o-");
		checkSimpleCompactTimelinePattern("-o-o-o-");
		final CompactStateInvariantEditPartCN compactStateInvariantEditPart = findStateInvariantsInDefaultCompactLifeline().get(1);
		executeHideCommand(compactStateInvariantEditPart);
		checkInteractionFragmentsWithPattern("-o-o-o-");
		checkSimpleCompactTimelinePattern("-o-o-");
		undoOnUIThread();
		checkInteractionFragmentsWithPattern("-o-o-o-");
		checkSimpleCompactTimelinePattern("-o-o-o-");
		redoOnUIThread();
		checkInteractionFragmentsWithPattern("-o-o-o-");
		checkSimpleCompactTimelinePattern("-o-o-");
	}

	@Test
	public void testCannotDeleteLastStateInvariant() {
		checkInteractionFragmentsWithPattern("-");
		checkSimpleCompactTimelinePattern("-");
		final CompactStateInvariantEditPartCN compactStateInvariantEditPart = findStateInvariantsInDefaultCompactLifeline().get(0);
		final Request destroyElementRequest = new EditCommandRequestWrapper(new DestroyElementRequest(false));
		final Command command = compactStateInvariantEditPart.getCommand(destroyElementRequest);
		assertFalse("We shouldn't be able to delete the last state invariant", command.canExecute());
	}

	@Test
	public void testCannotHideLastStateInvariant() {
		checkInteractionFragmentsWithPattern("-");
		checkSimpleCompactTimelinePattern("-");
		final CompactStateInvariantEditPartCN compactStateInvariantEditPart = findStateInvariantsInDefaultCompactLifeline().get(0);
		final GroupRequest deleteViewRequest = new GroupRequest(org.eclipse.gef.RequestConstants.REQ_DELETE);
		deleteViewRequest.setEditParts(compactStateInvariantEditPart);
		final Command command = compactStateInvariantEditPart.getCommand(deleteViewRequest);
		assertFalse("We shouldn't be able to hide the last state invariant", command.canExecute());
	}

	@FailingTest("To be verified. Seems to work for standard user, but not in raw test environment")
	@Test
	public void testResizeCompactStateInvariant() {
		createThreeOccurrenceSpecificationsInDefaultCompactLifeline();
		flushEventLoop();
		checkSimpleCompactTimelinePattern("-o-o-o-");

		final List<CompactStateInvariantEditPartCN> stateInvariantsEditParts = findStateInvariantsInDefaultCompactLifeline();
		assertEquals("Wrong number of StateInvariants", 4, stateInvariantsEditParts.size());
		final CompactStateInvariantEditPartCN s2 = stateInvariantsEditParts.get(1);
		final CompactStateInvariantEditPartCN s3 = stateInvariantsEditParts.get(2);

		createOccurrenceSpecificationOverCompactStateInvariant(s2, false);
		createOccurrenceSpecificationOverCompactStateInvariant(s3, true);
		flushEventLoop();
		checkSimpleCompactTimelinePattern("-o-oo-oo-");

		final List<OccurrenceSpecificationEditPartCN> occurrenceSpecificationEditParts = findOccurrenceSpecificationsInDefaultCompactLifeline();
		assertEquals("Wrong number of OccurrenceSpecifications", 5, occurrenceSpecificationEditParts.size());

		final OccurrenceSpecificationEditPartCN o1 = occurrenceSpecificationEditParts.get(0);
		final OccurrenceSpecificationEditPartCN o2 = occurrenceSpecificationEditParts.get(1);
		final OccurrenceSpecificationEditPartCN o3 = occurrenceSpecificationEditParts.get(2);
		final OccurrenceSpecificationEditPartCN o4 = occurrenceSpecificationEditParts.get(3);
		final OccurrenceSpecificationEditPartCN o5 = occurrenceSpecificationEditParts.get(4);

		final CompactLifelineCompartmentEditPartCN timelineCompartment = getDefaultCompactLifelineTimelineCompartment();

		// test shrink
		testResizeCompactStateInvariant(s2, -9, o1, o2, o3, o4, o5, timelineCompartment);
		// test grow
		testResizeCompactStateInvariant(s2, 42, o1, o2, o3, o4, o5, timelineCompartment);
	}

	private void testResizeCompactStateInvariant(final CompactStateInvariantEditPartCN s2, final int widthDelta, final OccurrenceSpecificationEditPartCN o1, final OccurrenceSpecificationEditPartCN o2, final OccurrenceSpecificationEditPartCN o3, final OccurrenceSpecificationEditPartCN o4, final OccurrenceSpecificationEditPartCN o5, final CompactLifelineCompartmentEditPartCN timelineCompartment) {
		final Rectangle o1Before = getBounds(o1);
		final Rectangle o2Before = getBounds(o2);
		final Rectangle o3Before = getBounds(o3);
		final Rectangle o4Before = getBounds(o4);
		final Rectangle o5Before = getBounds(o5);
		final Rectangle boundsBefore = getBounds(s2);
		resizeEditPart(s2, timelineCompartment, new Dimension(widthDelta, 0), PositionConstants.EAST);
		final Rectangle o1After = getBounds(o1);
		final Rectangle o2After = getBounds(o2);
		final Rectangle o3After = getBounds(o3);
		final Rectangle o4After = getBounds(o4);
		final Rectangle o5After = getBounds(o5);
		final Rectangle boundsAfter = getBounds(s2);
		assertEquals("The Figure should have been resized horizontally", boundsBefore.width + widthDelta, boundsAfter.width);
		assertEquals("The OccurrenceSpecification before it shouldn't have moved", o1Before.x, o1After.x);
		assertEquals("The OccurrenceSpecification on top of it shouldn't have moved", o2Before.x, o2After.x);
		assertEquals("The OccurrenceSpecifications after it should have moved", o3Before.x + widthDelta, o3After.x);
		assertEquals("The OccurrenceSpecifications on the bottom of another state shouldn't have moved", o4Before.x, o4After.x);
		assertEquals("The OccurrenceSpecifications after it should have moved", o5Before.x + widthDelta, o5After.x);
		testUndoRedoChangeBoundsEditPart(s2, boundsBefore);
	}

	protected static void checkBounds(final Rectangle boundsAfter, final int minX, final int maxX) {
		assertTrue("The second OccurrenceSpecification should always be after the first", boundsAfter.x > minX);
		assertTrue("The second OccurrenceSpecification should always be before the third", boundsAfter.x < maxX);
	}
}
