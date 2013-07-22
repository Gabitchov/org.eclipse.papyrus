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

import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityNameEditPart;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.part.CustomActivityEditPartTN;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EditPartUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.intro.IIntroManager;
import org.eclipse.ui.intro.IIntroPart;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.NamedElement;
import org.junit.Test;


public class TestInteractionOverviewDiagramActivityTN extends AbstractInteractionOverviewDiagramTestCase {

	@Override
	public void setUp() throws Exception {

		removeWelcomeScreen();
		projectCreation();
		createActivity();

		assertTrue(CREATION + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 1);
		GraphicalEditPart containerEditPart = (GraphicalEditPart)getDiagramEditPart().getChildren().get(0);
		rootCompartment = null;
		int index = 0;
		while(rootCompartment == null && index < containerEditPart.getChildren().size()) {
			if((containerEditPart.getChildren().get(index)) instanceof ShapeCompartmentEditPart) {
				rootCompartment = (ShapeCompartmentEditPart)(containerEditPart.getChildren().get(index));
			}
			index++;
		}
	}

	protected void removeWelcomeScreen() {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				IIntroManager introManager = PlatformUI.getWorkbench().getIntroManager();
				IIntroPart intro = introManager.getIntro();
				introManager.closeIntro(intro);
			}
		});
	}

	@Test
	public void testCreateInteraction() {
		createActivity();
	}

	@Test
	public void testDeleteActivity() {
		final CustomActivityEditPartTN activity = createActivity();
		testDelete(activity);
	}

	@Test
	public void testCreateThreeInteractions() {
		final CustomActivityEditPartTN activity1 = createActivity();
		final CustomActivityEditPartTN activity2 = createActivity();
		final CustomActivityEditPartTN activity3 = createActivity();
		// 4 activity as setup create one already
		assertEquals("The diagram should only contain the 3 interactions", 4, getDiagramEditPart().getChildren().size());
		assertTrue("The first interaction should be found in the diagram", getDiagramEditPart().getChildren().contains(activity1));
		assertTrue("The second interaction should be found in the diagram", getDiagramEditPart().getChildren().contains(activity2));
		assertTrue("The third interaction should be found in the diagram", getDiagramEditPart().getChildren().contains(activity3));
	}

	@Test
	public void testEditInteractionName() {
		final CustomActivityEditPartTN activityEditPart = createActivity();
		final ActivityNameEditPart activityNameEditPart = (ActivityNameEditPart)EditPartUtils.findFirstChildEditPartWithId(activityEditPart, ActivityNameEditPart.VISUAL_ID);
		final NamedElement namedElement = (Activity)activityEditPart.getUMLElement();
		testSetNameWithDirectEditRequest(activityNameEditPart, namedElement);
	}
}
