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
import static org.junit.Assert.fail;

import java.util.Map.Entry;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EditPartUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.StateDefinitionUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.StateInvariantUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineStateDefinitionCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullStateInvariantEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.StateDefinitionLabelEditPart;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.StateInvariant;
import org.junit.Test;

public class TestTimingDiagramStateDefinition extends AbstractTimingDiagramTestCase {

	@Override
	public void setUp() throws Exception {
		// create the project, model and diagram
		super.setUp();
		createDefaultInteraction();
		createDefaultFullLifeline();
	}

	@Test
	public void testCreateStateDefinition() {
		final EditPart stateDefinition = createStateDefinitionInDefaultFullLifeline();
		final EditPart stateInvariantEditPart = EditPartUtils.findFirstChildEditPartWithId(getDefaultFullLifelineEditPart(),
				FullStateInvariantEditPartCN.VISUAL_ID);
		assertNotNull("A StateInvariant must be created with the first StateDefinition", stateInvariantEditPart);
		final StateInvariant stateInvariant = (StateInvariant) ((View) stateInvariantEditPart.getModel()).getElement();
		assertNotNull("The StateInvariant must not be null", stateInvariant);
		final String stateInvariantId = StateInvariantUtils.getStateInvariantId(stateInvariant);
		assertNotNull("The StateInvariant id must not be null", stateInvariantId);
		final String stateDefinitionViewID = StateDefinitionUtils.getStateDefinitionViewID((View) stateDefinition.getModel());
		assertEquals("The ids of the StateDefinition and the StateInvariant must be equal", stateDefinitionViewID, stateInvariantId);

	}

	@Test
	public void testCreateMultipleStateDefinitions() {
		createStateDefinitionInDefaultFullLifeline();
		expectNStateDefinitions(1);
		createStateDefinitionInDefaultFullLifeline();
		expectNStateDefinitions(2);
		undoOnUIThread();
		expectNStateDefinitions(1);
		redoOnUIThread();
		expectNStateDefinitions(2);
		createStateDefinitionInDefaultFullLifeline();
		expectNStateDefinitions(3);
		undoOnUIThread();
		expectNStateDefinitions(2);
		redoOnUIThread();
		expectNStateDefinitions(3);
	}

	private void expectNStateDefinitions(final int numberOfExpectedStateDefinitions) {
		assertEquals("There must be " + numberOfExpectedStateDefinitions + " StateDefinitionEditPart", numberOfExpectedStateDefinitions, findStateDefinitions()
				.size());
	}

	/**
	 * Creates a new StateDefinition by clicking using the StateDefinition palette tool (this is important to test
	 * because we customized this tool).
	 */
	@Test
	public void testCreateStateDefinitionWithPaletteTool() {
		final FullLifelineStateDefinitionCompartmentEditPartCN stateDefinitionCompartment = getDefaultStateDefinitionCompartment();
		// let GMF do its layout
		flushEventLoop();
		final int nChildrenBefore = stateDefinitionCompartment.getChildren().size();
		final Rectangle bounds = stateDefinitionCompartment.getFigure().getBounds();
		stateDefinitionCompartment.getFigure().getParent().translateToAbsolute(bounds);
		// click center at the top of the compartment
		final Point point = new Point(bounds.x + bounds.width / 2, bounds.y + 1);
		// use the StateDefinition creation tool to create a new StateDefinition
		clickTool("createStateDefinitionCreationTool", point);
		final Text text = findVisibleTextWidgetOnDiagram();
		assertEquals("The state definition compartment should contain one more child", nChildrenBefore + 1, stateDefinitionCompartment.getChildren().size());
		assertNotNull("A Text cell editor should appear after creating a StateDefinition", text);
		final String newName = "state " + System.currentTimeMillis();
		setText(text, newName);
		checkStateDefinition(newName);
	}

	/**
	 * Check that there is a StateDefinition with the given name.
	 * 
	 * @param expectedName
	 *            the name of a StateDefinition that should exist.
	 */
	protected void checkStateDefinition(final String expectedName) {
		final View lifelineView = (View) getDefaultFullLifelineEditPart().getModel();
		final Lifeline lifeline = (Lifeline) lifelineView.getElement();
		final EAnnotation stateDefinitionsEAnnotation = StateDefinitionUtils.getStateDefinitionsEAnnotation(lifeline);
		assertNotNull("The lifeline should have an EAnnotation for the state definitions", stateDefinitionsEAnnotation);

		// find the entry corresponding to the new StateDefinition
		Entry<String, String> newEntry = null;
		final EMap<String, String> details = stateDefinitionsEAnnotation.getDetails();
		for (final Entry<String, String> entry : details) {
			if (expectedName.equals(entry.getValue())) {
				newEntry = entry;
				break;
			}
		}
		assertNotNull("The Lifeline's EAnnotation should contain an entry for the StateDefinition", newEntry);
		@SuppressWarnings("null")
		final String id = newEntry.getKey();
		final View stateDefinitionView = StateDefinitionUtils.getStateDefinitionViewWithId(id, lifelineView);
		final String stateDefinitionName = StateDefinitionUtils.getStateDefinitionName(stateDefinitionView);
		assertEquals("getStateDefinitionName should return the name of the StateDefinition", expectedName, stateDefinitionName);
	}

	/** Check that no StateDefinition exists with the given name. */
	protected void checkNoStateDefinition(final String unexpectedName) {
		final View lifelineView = (View) getDefaultFullLifelineEditPart().getModel();
		final Lifeline lifeline = (Lifeline) lifelineView.getElement();
		final EAnnotation stateDefinitionsEAnnotation = StateDefinitionUtils.getStateDefinitionsEAnnotation(lifeline);
		if (stateDefinitionsEAnnotation == null) {
			return;
		}
		// find the entry corresponding to the new StateDefinition
		final EMap<String, String> details = stateDefinitionsEAnnotation.getDetails();
		for (final Entry<String, String> entry : details) {
			if (unexpectedName.equals(entry.getValue())) {
				fail("A StateDefinition with the given name exists");
			}
		}
	}

	@Test
	public void testDeleteStateDefinition() {
		final EditPart stateDefinition1 = createStateDefinitionInDefaultFullLifeline();
		final EditPart stateDefinition2 = createStateDefinitionInDefaultFullLifeline();
		final EditPart stateDefinition3 = createStateDefinitionInDefaultFullLifeline();

		final GroupRequest deleteRequest1 = new GroupRequest(RequestConstants.REQ_DELETE);
		deleteRequest1.setEditParts(stateDefinition1);
		final Command command1 = stateDefinition1.getCommand(deleteRequest1);
		assertTrue("The first StateDefinition should not be deletable since a StateInvariant uses it", command1 instanceof UnexecutableCommand);

		testDeleteStateDefinition(stateDefinition2, "second state definition for testDeleteStateDefinition");
		testDeleteStateDefinition(stateDefinition3, "third state definition for testDeleteStateDefinition");
	}

	protected void testDeleteStateDefinition(final EditPart stateDefinition, final String name) {
		// set a name before deleting so that we can then check whether it was really deleted/re-created
		setNameWithDirectEditRequest(getStateDefinitionLabelEditPart(stateDefinition), name);
		checkStateDefinition(name);

		final FullLifelineStateDefinitionCompartmentEditPartCN stateDefinitionCompartment = getDefaultStateDefinitionCompartment();
		final int sizeBefore = stateDefinitionCompartment.getChildren().size();

		// this is actually a "hide" instead of a "delete", since StateDefinition has no UML semantic element
		final GroupRequest deleteRequest = new GroupRequest(RequestConstants.REQ_DELETE);
		deleteRequest.setEditParts(stateDefinition);
		final Command command = stateDefinition.getCommand(deleteRequest);
		checkCommand(command);
		executeOnUIThread(command);
		assertEquals("The StateDefinition compartment should now contain one less child", sizeBefore - 1, stateDefinitionCompartment.getChildren().size());
		checkNoStateDefinition(name);
		undoOnUIThread();
		assertEquals("The child should be back after the undo", sizeBefore, stateDefinitionCompartment.getChildren().size());
		checkStateDefinition(name);
		redoOnUIThread();
		assertEquals("The child should be removed after the redo", sizeBefore - 1, stateDefinitionCompartment.getChildren().size());
		checkNoStateDefinition(name);
	}

	@Test
	public void testEditStateDefinitionName() {
		final EditPart stateDefinition = createStateDefinitionInDefaultFullLifeline();
		final StateDefinitionLabelEditPart stateDefinitionLabelEditPart = getStateDefinitionLabelEditPart(stateDefinition);
		// set first name
		final String name1 = "test name 1 " + System.currentTimeMillis();
		setNameWithDirectEditRequest(stateDefinitionLabelEditPart, name1);
		checkStateDefinition(name1);
		// set second name
		final String name2 = "test name 2 " + System.currentTimeMillis();
		setNameWithDirectEditRequest(stateDefinitionLabelEditPart, name2);
		checkStateDefinition(name2);
		checkNoStateDefinition(name1);
		// test undo
		undo();
		checkStateDefinition(name1);
		checkNoStateDefinition(name2);
		// test redo
		redo();
		checkStateDefinition(name2);
		checkNoStateDefinition(name1);

		// TODO: check fragment names are updated when changing the state definition name
	}

	private static StateDefinitionLabelEditPart getStateDefinitionLabelEditPart(final EditPart stateDefinitionEditPart) {
		final StateDefinitionLabelEditPart stateDefinitionLabelEditPart = (StateDefinitionLabelEditPart) EditPartUtils.findFirstChildEditPartWithId(
				stateDefinitionEditPart, StateDefinitionLabelEditPart.VISUAL_ID);
		return stateDefinitionLabelEditPart;
	}
}
