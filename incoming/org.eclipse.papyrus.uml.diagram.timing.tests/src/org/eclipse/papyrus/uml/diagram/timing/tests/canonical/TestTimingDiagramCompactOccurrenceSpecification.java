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

import java.util.Arrays;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EditPartUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactStateInvariantEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.OccurrenceSpecificationEditPartCN;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.StateInvariant;
import org.junit.Test;

public class TestTimingDiagramCompactOccurrenceSpecification extends AbstractTimingDiagramTestCase {

	@Override
	public void setUp() throws Exception {
		// create the project, model and diagram
		super.setUp();
		createDefaultInteraction();
		createDefaultCompactLifeline();
	}

	@Test
	public void testCreateThreeOccurrenceSpecifications() {
		createThreeOccurrenceSpecificationsInDefaultCompactLifeline();
		final View interactionView = (View) getDefaultInteractionEditPart().getModel();
		final Interaction interaction = (Interaction) interactionView.getElement();
		assertTrue("The interaction should be in a Model", isInModel(interaction));
		// We created 3 OccurrenceSpecifications. The model starts and ends with a StateInvariant, and when creating an
		// OccurrenceSpecification, we split a StateInvariant in two and insert the OccurrenceSpecification.
		// So, it should look like : "-o-o-o-" (with "-" for StateInvariant and "o" for OccurrenceSpecification)
		checkInteractionFragmentsWithPattern("-o-o-o-");
		checkSimpleCompactTimelinePattern("-o-o-o-");
	}

	@Test
	public void testDeleteOccurrenceSpecification() {
		createThreeOccurrenceSpecificationsInDefaultCompactLifeline();
		final List<OccurrenceSpecificationEditPartCN> occurrenceSpecifications = findOccurrenceSpecificationsInDefaultCompactLifeline();
		assertEquals("Wrong number of OccurrenceSpecifications", 3, occurrenceSpecifications.size());
		final OccurrenceSpecificationEditPartCN middleOccurrence = occurrenceSpecifications.get(1);

		final OccurrenceSpecification occurrenceSpecification = (OccurrenceSpecification) ((View) middleOccurrence.getModel()).getElement();
		assertTrue("The OccurrenceSpecification should be in a Model", isInModel(occurrenceSpecification));
		checkInteractionFragmentsWithPattern("-o-o-o-");
		checkSimpleCompactTimelinePattern("-o-o-o-");

		// destroy the middle OccurrenceSpecification
		final Request destroyElementRequest = new EditCommandRequestWrapper(new DestroyElementRequest(false));
		final Command command = middleOccurrence.getCommand(destroyElementRequest);
		checkCommand(command);
		execute(command);
		assertEquals("There should be one less OccurrenceSpecification", 2, findOccurrenceSpecificationsInDefaultCompactLifeline().size());
		assertFalse("The OccurrenceSpecification should not be in the Model after deleting it", isInModel(occurrenceSpecification));
		checkInteractionFragmentsWithPattern("-o-o-");
		checkSimpleCompactTimelinePattern("-o-o-");

		// test undo
		undo();
		assertEquals("The OccurrenceSpecification should be back after the undo", 3, findOccurrenceSpecificationsInDefaultCompactLifeline().size());
		assertTrue("The OccurrenceSpecification should be back in the Model after undoing the deletion", isInModel(occurrenceSpecification));
		checkInteractionFragmentsWithPattern("-o-o-o-");
		checkSimpleCompactTimelinePattern("-o-o-o-");

		// test redo
		redo();
		assertEquals("The OccurrenceSpecification should be removed after the redo", 2, findOccurrenceSpecificationsInDefaultCompactLifeline().size());
		assertFalse("The OccurrenceSpecification should not be in the Model after redoing the deletion", isInModel(occurrenceSpecification));
		checkInteractionFragmentsWithPattern("-o-o-");
		checkSimpleCompactTimelinePattern("-o-o-");
	}

	@Test
	public void testCreateOccurrenceSpecificationWithDoubleClick() {
		final CompactStateInvariantEditPartCN stateInvariantEditPart = (CompactStateInvariantEditPartCN) EditPartUtils.findFirstChildEditPartWithId(
				getDefaultCompactLifelineEditPart(), CompactStateInvariantEditPartCN.VISUAL_ID);
		assertNotNull("A StateInvariant must always exist", stateInvariantEditPart);
		assertEquals("There must always be only one StateInvariant initially", 1, findStateInvariantsInDefaultCompactLifeline().size());
		final StateInvariant stateInvariant = (StateInvariant) ((View) stateInvariantEditPart.getModel()).getElement();
		assertNotNull("The StateInvariant must not be null", stateInvariant);

		final IFigure figure = stateInvariantEditPart.getFigure();
		final Rectangle bounds = new Rectangle(figure.getBounds());
		figure.getParent().translateToAbsolute(bounds);

		// click at the center of the StateInvariant line
		final int x = bounds.x + bounds.width / 2;
		final int y = bounds.y + bounds.height / 2;

		// send the open request (corresponding to a double-click)
		sendOpenSelectionRequest(stateInvariantEditPart, new Point(x, y));

		checkCreatedStateInvariants();
		checkCreatedOccurrenceSpecification();

		// test undo
		undoOnUIThread();
		assertEquals("There must be one StateInvariant after undo", 1, findStateInvariantsInDefaultCompactLifeline().size());
		assertEquals("There must be no OccurrenceSpecification after undo", 0, findOccurrenceSpecificationsInDefaultCompactLifeline().size());

		// test redo
		redoOnUIThread();
		assertEquals("There must be two StateInvariants after redo", 2, findStateInvariantsInDefaultCompactLifeline().size());
		checkCreatedOccurrenceSpecification();
	}

	@Test
	public void testMoveOccurrenceSpecification() {
		createThreeOccurrenceSpecificationsInDefaultCompactLifeline();
		flushEventLoop();
		final List<OccurrenceSpecificationEditPartCN> occurrenceSpecificationEditParts = findOccurrenceSpecificationsInDefaultCompactLifeline();
		assertEquals("Wrong number of OccurrenceSpecifications", 3, occurrenceSpecificationEditParts.size());

		final OccurrenceSpecificationEditPartCN first = occurrenceSpecificationEditParts.get(0);
		final OccurrenceSpecificationEditPartCN second = occurrenceSpecificationEditParts.get(1);
		final OccurrenceSpecificationEditPartCN third = occurrenceSpecificationEditParts.get(2);

		final CompactLifelineCompartmentEditPartCN timelineCompartment = getDefaultCompactLifelineTimelineCompartment();

		final int minX = getBounds(first).x;
		final int maxX = getBounds(third).x;

		// shift to the left
		Rectangle boundsBefore = getBounds(second);
		moveEditPart(second, timelineCompartment, new Point(-9, 0));
		Rectangle boundsAfter = getBounds(second);
		assertEquals("The Figure should have been moved 9 pixels to the left", boundsBefore.x - 9, boundsAfter.x);
		checkBounds(boundsAfter, minX, maxX);
		testUndoRedoChangeBoundsEditPart(second, boundsBefore);

		// shift to the right
		boundsBefore = getBounds(second);
		moveEditPart(second, timelineCompartment, new Point(13, 0));
		boundsAfter = getBounds(second);
		assertEquals("The Figure should have been moved 13 pixels to the right", boundsBefore.x + 13, boundsAfter.x);
		checkBounds(boundsAfter, minX, maxX);
		testUndoRedoChangeBoundsEditPart(second, boundsBefore);

		// try to move past the previous OccurrenceSpecification (should be forbidden)
		boundsBefore = getBounds(second);
		moveEditPart(second, timelineCompartment, new Point(-(boundsBefore.x - minX + 10), 0));
		boundsAfter = getBounds(second);
		assertTrue("The Figure should be constrained, but still move", boundsAfter.x < boundsBefore.x);
		checkBounds(boundsAfter, minX, maxX);
		testUndoRedoChangeBoundsEditPart(second, boundsBefore);

		// try to move past the following OccurrenceSpecification (should be forbidden)
		boundsBefore = getBounds(second);
		moveEditPart(second, timelineCompartment, new Point(maxX - boundsBefore.x + 10, 0));
		boundsAfter = getBounds(second);
		assertTrue("The Figure should be constrained, but still move", boundsAfter.x > boundsBefore.x);
		checkBounds(boundsAfter, minX, maxX);
		testUndoRedoChangeBoundsEditPart(second, boundsBefore);

		// try to move horizontally and vertically at the same time (should be constrained to an horizontal-only move)
		boundsBefore = getBounds(second);
		moveEditPart(second, timelineCompartment, new Point(-17, 123));
		boundsAfter = getBounds(second);
		assertEquals("The Figure should have been moved 17 pixels to the left", boundsBefore.x - 17, boundsAfter.x);
		assertEquals("The Figure should not move vertically", boundsBefore.y, boundsAfter.y);
		checkBounds(boundsAfter, minX, maxX);
		testUndoRedoChangeBoundsEditPart(second, boundsBefore);
	}

	/**
	 * When moving several OccurrenceSpecifications, we don't want the previous positions of the elements to constrain
	 * the future positions of the elements being moved.
	 */
	@Test
	public void testMoveAdjacentOccurrenceSpecifications() {
		// create two OccurrenceSpecifications close to each other
		createOccurrenceSpecificationInLastCompactStateInvariantAtAbsolutePos(1, 100);
		createOccurrenceSpecificationInLastCompactStateInvariantAtAbsolutePos(2, 10);
		flushEventLoop();

		final List<OccurrenceSpecificationEditPartCN> occurrenceSpecificationEditParts = findOccurrenceSpecificationsInDefaultCompactLifeline();
		assertEquals("Wrong number of OccurrenceSpecifications", 2, occurrenceSpecificationEditParts.size());

		final OccurrenceSpecificationEditPartCN first = occurrenceSpecificationEditParts.get(0);
		final OccurrenceSpecificationEditPartCN second = occurrenceSpecificationEditParts.get(1);
		final CompactLifelineCompartmentEditPartCN timelineCompartment = getDefaultCompactLifelineTimelineCompartment();

		// shift both to the left
		final Rectangle firstBefore = getBounds(first);
		final Rectangle secondBefore = getBounds(second);
		moveEditParts(Arrays.asList(first, second), timelineCompartment, new Point(-50, 0));
		final Rectangle firstAfter = getBounds(first);
		final Rectangle secondAfter = getBounds(second);
		assertEquals("The first Figure should have been moved 50 pixels to the left", firstBefore.x - 50, firstAfter.x);
		assertEquals("The second Figure should have been moved 50 pixels to the left", secondBefore.x - 50, secondAfter.x);
	}

	protected static void checkBounds(final Rectangle boundsAfter, final int minX, final int maxX) {
		assertTrue("The second OccurrenceSpecification should always be after the first", boundsAfter.x > minX);
		assertTrue("The second OccurrenceSpecification should always be before the third", boundsAfter.x < maxX);
	}

	@Test
	public void testFullUndoRedo() {
		createThreeOccurrenceSpecificationsInDefaultCompactLifeline();
		// 3 OccurrenceSpecifications + 1 Lifeline + 1 Interaction
		final int nElementsToUndo = 5;
		testDirtyStateForFullUndoRedo(nElementsToUndo);
	}

	@Test
	public void testCreateOccurrenceSpecificationOnCompactStateInvariant() {
		createThreeOccurrenceSpecificationsInDefaultCompactLifeline();
		flushEventLoop();
		checkSimpleCompactTimelinePattern("-o-o-o-");

		final List<CompactStateInvariantEditPartCN> stateInvariantsEditParts = findStateInvariantsInDefaultCompactLifeline();
		assertEquals("Wrong number of StateInvariants", 4, stateInvariantsEditParts.size());
		final CompactStateInvariantEditPartCN s1 = stateInvariantsEditParts.get(0);
		final CompactStateInvariantEditPartCN s2 = stateInvariantsEditParts.get(1);
		final CompactStateInvariantEditPartCN s3 = stateInvariantsEditParts.get(2);
		final CompactStateInvariantEditPartCN s4 = stateInvariantsEditParts.get(3);

		createOccurrenceSpecificationOverCompactStateInvariant(s1, false);
		createOccurrenceSpecificationOverCompactStateInvariant(s2, true);
		createOccurrenceSpecificationOverCompactStateInvariant(s3, false);
		createOccurrenceSpecificationOverCompactStateInvariant(s4, true);
		flushEventLoop();
		checkSimpleCompactTimelinePattern("-oo-oo-oo-o");

		final List<OccurrenceSpecificationEditPartCN> occurrenceSpecificationEditParts = findOccurrenceSpecificationsInDefaultCompactLifeline();
		assertEquals("Wrong number of OccurrenceSpecifications", 7, occurrenceSpecificationEditParts.size());

		final OccurrenceSpecificationEditPartCN o1 = occurrenceSpecificationEditParts.get(0);
		final OccurrenceSpecificationEditPartCN o2 = occurrenceSpecificationEditParts.get(1);
		final OccurrenceSpecificationEditPartCN o3 = occurrenceSpecificationEditParts.get(2);
		final OccurrenceSpecificationEditPartCN o4 = occurrenceSpecificationEditParts.get(3);
		final OccurrenceSpecificationEditPartCN o5 = occurrenceSpecificationEditParts.get(4);
		final OccurrenceSpecificationEditPartCN o6 = occurrenceSpecificationEditParts.get(5);
		final OccurrenceSpecificationEditPartCN o7 = occurrenceSpecificationEditParts.get(6);

		checkOccurrenceIsMiddleXTopYOfStateInvariant(o1, s1);
		checkOccurrenceIsRightXMiddleYOfStateInvariant(o2, s1);
		checkOccurrenceIsMiddleXBottomYOfStateInvariant(o3, s2);
		checkOccurrenceIsRightXMiddleYOfStateInvariant(o4, s2);
		checkOccurrenceIsMiddleXTopYOfStateInvariant(o5, s3);
		checkOccurrenceIsRightXMiddleYOfStateInvariant(o6, s3);
		checkOccurrenceIsMiddleXBottomYOfStateInvariant(o7, s4);
	}

	private static void checkOccurrenceIsMiddleXTopYOfStateInvariant(final OccurrenceSpecificationEditPartCN occurrenceSpecificationEditPart,
			final CompactStateInvariantEditPartCN stateInvariantEditPart) {
		final Rectangle oBounds = getBounds(occurrenceSpecificationEditPart);
		final Rectangle sBounds = getBounds(stateInvariantEditPart);
		assertTrue("The occurrence should be located vertically near the top of the state invariant", Math.abs(oBounds.y - sBounds.y) <= 5);
		assertTrue("The occurrence should be located horizontally near the middle of the state invariant",
				Math.abs(oBounds.x - (sBounds.x + sBounds.width / 2)) <= 5);
	}

	private static void checkOccurrenceIsMiddleXBottomYOfStateInvariant(final OccurrenceSpecificationEditPartCN occurrenceSpecificationEditPart,
			final CompactStateInvariantEditPartCN stateInvariantEditPart) {
		final Rectangle oBounds = getBounds(occurrenceSpecificationEditPart);
		final Rectangle sBounds = getBounds(stateInvariantEditPart);
		assertTrue("The occurrence should be located vertically near the top of the state invariant", Math.abs(oBounds.y - (sBounds.y + sBounds.height)) <= 5);
		assertTrue("The occurrence should be located horizontally near the middle of the state invariant",
				Math.abs(oBounds.x - (sBounds.x + sBounds.width / 2)) <= 5);
	}

	private static void checkOccurrenceIsRightXMiddleYOfStateInvariant(final OccurrenceSpecificationEditPartCN occurrenceSpecificationEditPart,
			final CompactStateInvariantEditPartCN stateInvariantEditPart) {
		final Rectangle oBounds = getBounds(occurrenceSpecificationEditPart);
		final Rectangle sBounds = getBounds(stateInvariantEditPart);
		assertTrue("The occurrence should be located vertically near the middle of the state invariant",
				Math.abs(oBounds.y - (sBounds.y + sBounds.height / 2)) <= 5);
		assertTrue("The occurrence should be located horizontally near the right of the state invariant",
				Math.abs(oBounds.x - (sBounds.x + sBounds.width)) <= 5);
	}

	protected void checkCreatedStateInvariants() {
		// check the StateInvariants
		final List<CompactStateInvariantEditPartCN> stateInvariantEditParts = findStateInvariantsInDefaultCompactLifeline();
		assertEquals("There must be two StateInvariants after creating an OccurrenceSpecification", 2, stateInvariantEditParts.size());
		checkStateInvariant(stateInvariantEditParts.get(0));
		checkStateInvariant(stateInvariantEditParts.get(1));
	}

	private void checkCreatedOccurrenceSpecification() {
		final List<OccurrenceSpecificationEditPartCN> occurrenceSpecificationEditParts = findOccurrenceSpecificationsInDefaultCompactLifeline();
		assertEquals("There must be one OccurrenceSpecification", 1, occurrenceSpecificationEditParts.size());
		final OccurrenceSpecificationEditPartCN occurrenceSpecificationEditPart = occurrenceSpecificationEditParts.get(0);
		final View occurrenceSpecificationView = (View) occurrenceSpecificationEditPart.getModel();
		final OccurrenceSpecification occurrenceSpecification = (OccurrenceSpecification) occurrenceSpecificationView.getElement();
		assertNotNull("The OccurrenceSpecification must not be null", occurrenceSpecification);
		assertTrue("The OccurrenceSpecification must be in the model", isInModel(occurrenceSpecification));
		assertEquals("The OccurrenceSpecification must cover one Lifeline", 1, occurrenceSpecification.getCovereds().size());
		final Lifeline lifeline = (Lifeline) ((View) getDefaultCompactLifelineEditPart().getModel()).getElement();
		assertEquals("The OccurrenceSpecification must cover the Lifeline", lifeline, occurrenceSpecification.getCovereds().get(0));
		final Interaction interaction = (Interaction) ((View) getDefaultInteractionEditPart().getModel()).getElement();
		assertTrue("The OccurrenceSpecification must be in the Interaction", interaction.getFragments().contains(occurrenceSpecification));
	}

	private void checkStateInvariant(final CompactStateInvariantEditPartCN stateInvariantEditPartCN) {
		final View stateInvariantView = (View) stateInvariantEditPartCN.getModel();
		final StateInvariant stateInvariant = (StateInvariant) stateInvariantView.getElement();
		assertNotNull("The StateInvariant must not be null", stateInvariant);
		assertTrue("The StateInvariant must be in the model", isInModel(stateInvariant));
		assertEquals("The StateInvariant must cover one Lifeline", 1, stateInvariant.getCovereds().size());
		final Lifeline lifeline = (Lifeline) ((View) getDefaultCompactLifelineEditPart().getModel()).getElement();
		assertEquals("The StateInvariant must cover the Lifeline", lifeline, stateInvariant.getCovereds().get(0));
		final Interaction interaction = (Interaction) ((View) getDefaultInteractionEditPart().getModel()).getElement();
		assertTrue("The StateInvariant must be in the Interaction", interaction.getFragments().contains(stateInvariant));
	}
}
