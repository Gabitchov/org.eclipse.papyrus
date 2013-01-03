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

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.custom.LifelineVerticalLabelCellEditorLocator;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EditPartUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineNameEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.UMLEditPartFactory;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.NamedElement;
import org.junit.Test;

public class TestTimingDiagramCompactLifeline extends AbstractTimingDiagramTestCase {

	@Override
	public void setUp() throws Exception {
		// create the project, model and diagram
		super.setUp();
		createDefaultInteraction();
	}

	@Test
	public void testCreateLifeline() {
		createCompactLifelineInDefaultInteraction();
	}

	@Test
	public void testHideLifeline() {
		final CompactLifelineEditPartCN lifelineEditPart = createCompactLifelineInDefaultInteraction();
		testHide(lifelineEditPart);
	}

	@Test
	public void testDeleteLifeline() {
		final CompactLifelineEditPartCN lifelineEditPart = createCompactLifelineInDefaultInteraction();
		testDelete(lifelineEditPart);
	}

	@Test
	public void testDropLifeline() {
		// create a compact Lifeline and hide its View, so as to be able to drop it after that
		final CompactLifelineEditPartCN lifelineEditPart = createCompactLifelineInDefaultInteraction();
		final Lifeline lifeline = (Lifeline) ((View) lifelineEditPart.getModel()).getElement();
		assertNotNull("The lifeline should not be null", lifeline);
		testHide(lifelineEditPart);
		testDrop(getDefaultInteractionCompartment(), getDefaultInteractionCompartment(), lifeline);
	}

	@Test
	public void testCellEditorLocator() {
		final CompactLifelineEditPartCN lifelineEditPart = createCompactLifelineInDefaultInteraction();
		final CompactLifelineNameEditPart compactLifelineNameEditPart = (CompactLifelineNameEditPart) EditPartUtils.findFirstChildEditPartWithId(
				lifelineEditPart, CompactLifelineNameEditPart.VISUAL_ID);
		assertNotNull("The CompactLifelineNameEditPart was not found", compactLifelineNameEditPart);
		final CellEditorLocator textCellEditorLocator = UMLEditPartFactory.getTextCellEditorLocator(compactLifelineNameEditPart);
		assertTrue("The cell editor locator must be the one specific to the vertical label",
				textCellEditorLocator instanceof LifelineVerticalLabelCellEditorLocator);
	}

	@Test
	public void testEditLifelineName() {
		final CompactLifelineEditPartCN lifelineEditPart = createCompactLifelineInDefaultInteraction();
		final CompactLifelineNameEditPart compactLifelineNameEditPart = (CompactLifelineNameEditPart) EditPartUtils.findFirstChildEditPartWithId(
				lifelineEditPart, CompactLifelineNameEditPart.VISUAL_ID);
		final NamedElement namedElement = (Lifeline) ((View) lifelineEditPart.getModel()).getElement();
		testSetNameWithDirectEditRequest(compactLifelineNameEditPart, namedElement);
	}

	@Test
	public void create3LifelinesTest() {
		final EditPart interactionCompartment = getDefaultInteractionCompartment();
		assertNotNull("The interaction compartment was not found", interactionCompartment);
		createView(UMLElementTypes.Lifeline_20, interactionCompartment);
		createView(UMLElementTypes.Lifeline_20, interactionCompartment);
		createView(UMLElementTypes.Lifeline_20, interactionCompartment);
		assertEquals("The interaction compartment should only contain the 3 lifelines", 3, interactionCompartment.getChildren().size());
		final List<? extends EditPart> editParts = EditPartUtils.findChildEditPartsWithId(interactionCompartment, CompactLifelineEditPartCN.VISUAL_ID);
		assertEquals("The interaction compartment should contain 3 lifelines", 3, editParts.size());
	}

}
