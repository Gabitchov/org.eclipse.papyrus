/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.tests.canonical;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.editparts.UMLNodeEditPart;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.part.CustomInteractionUseEditPartCN;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.part.CustomInteractionUseNameEditPart;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EditPartUtils;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.NamedElement;
import org.junit.Test;

public class TestInteractionUse extends AbstractInteractionOverviewDiagramTestCase {

	@Override
	public void setUp() throws Exception {
		// create the project, model and diagram
		super.setUp();
		createActivity();
	}

	@Test
	public void testCreateInteractionUse() {
		createChildNodeInTopNode(UMLElementTypes.CallBehaviorAction_3008);
	}

	@Test
	public void testDeleteInteractionUse() {
		final CustomInteractionUseEditPartCN interactionUse = (CustomInteractionUseEditPartCN)createChildNodeInTopNode(UMLElementTypes.CallBehaviorAction_3008);
		testDelete(interactionUse);
	}

	@Test
	public void testDropLifeline() {
		// create a Lifeline and hide its View, so as to be able to drop it after that
		final UMLNodeEditPart interactionUseEditPart = createChildNodeInTopNode(UMLElementTypes.CallBehaviorAction_3008);
		final CallBehaviorAction callBehaviorAction = (CallBehaviorAction)((View)interactionUseEditPart.getModel()).getElement();
		assertNotNull("The CallBehavior should not be null", callBehaviorAction);
		testHide(interactionUseEditPart);
		testDrop(getDefaultActivityCompartment(), getDefaultActivityCompartment(), callBehaviorAction);
	}


	@Test
	public void testCreateThreeInteractions() {
		final UMLNodeEditPart interactionUse1 = createChildNodeInTopNode(UMLElementTypes.CallBehaviorAction_3008);
		final UMLNodeEditPart interactionUse2 = createChildNodeInTopNode(UMLElementTypes.CallBehaviorAction_3008);
		final UMLNodeEditPart interactionUse3 = createChildNodeInTopNode(UMLElementTypes.CallBehaviorAction_3008);
		assertEquals("The diagram should only contain the 3 interactionUse", 3, getDefaultActivityCompartment().getChildren().size());
		assertTrue("The first interaction should be found in the diagram", getDefaultActivityCompartment().getChildren().contains(interactionUse1));
		assertTrue("The second interaction should be found in the diagram", getDefaultActivityCompartment().getChildren().contains(interactionUse2));
		assertTrue("The third interaction should be found in the diagram", getDefaultActivityCompartment().getChildren().contains(interactionUse3));
	}

	@Test
	public void testEditInteractionName() {
		final UMLNodeEditPart interactionUse = createChildNodeInTopNode(UMLElementTypes.CallBehaviorAction_3008);
		final CustomInteractionUseNameEditPart callBehaviorNameEditPart = (CustomInteractionUseNameEditPart)EditPartUtils.findFirstChildEditPartWithId(interactionUse, CustomInteractionUseNameEditPart.VISUAL_ID);
		final NamedElement namedElement = ((CallBehaviorAction)interactionUse.getUMLElement()).getBehavior();
		testSetNameWithDirectEditRequest(callBehaviorNameEditPart, namedElement);
	}
}
