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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.junit.utils.classification.FailingTest;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EditPartUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.InteractionEditPartTN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.InteractionNameEditPart;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.NamedElement;
import org.junit.Test;

public class TestTimingDiagramInteraction extends AbstractTimingDiagramTestCase {

	@Override
	public void setUp() throws Exception {
		// create the project, model and diagram
		super.setUp();
	}

	@Test
	public void testCreateInteraction() {
		createInteraction();
	}

	@Test
	public void testHideInteraction() {
		final InteractionEditPartTN interaction = createInteraction();
		testHide(interaction);
	}

	@Test
	public void testDeleteInteraction() {
		final InteractionEditPartTN interaction = createInteraction();
		testDelete(interaction);
	}

	@Test
	public void testDropInteraction() {
		// create an Interaction and hide its View, so as to be able to drop it after that
		final InteractionEditPartTN interactionEditPart = createInteraction();
		final Interaction interaction = (Interaction)((View)interactionEditPart.getModel()).getElement();
		assertNotNull("The interaction should not be null", interaction);
		hide(interactionEditPart);

		testDrop(getDiagramEditPart(), getDiagramEditPart(), interaction);
	}

	@Test
	public void testCreateThreeInteractions() {
		final InteractionEditPartTN interaction1 = createInteraction();
		final InteractionEditPartTN interaction2 = createInteraction();
		final InteractionEditPartTN interaction3 = createInteraction();
		assertEquals("The diagram should only contain the 3 interactions", 3, getDiagramEditPart().getChildren().size());
		assertTrue("The first interaction should be found in the diagram", getDiagramEditPart().getChildren().contains(interaction1));
		assertTrue("The second interaction should be found in the diagram", getDiagramEditPart().getChildren().contains(interaction2));
		assertTrue("The third interaction should be found in the diagram", getDiagramEditPart().getChildren().contains(interaction3));
	}

	@FailingTest("To be verified - Issue with opening the Text widget for direct edit request. Works in standard user environment")
	@Test
	public void testEditInteractionName() {
		final InteractionEditPartTN interactionEditPart = createInteraction();
		final InteractionNameEditPart interactionNameEditPart = (InteractionNameEditPart)EditPartUtils.findFirstChildEditPartWithId(interactionEditPart, InteractionNameEditPart.VISUAL_ID);
		final NamedElement namedElement = (Interaction)((View)interactionEditPart.getModel()).getElement();
		testSetNameWithDirectEditRequest(interactionNameEditPart, namedElement);
	}

}
