/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.tests.bug.pro20130916;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GateEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.junit.Test;


/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class InteractionStereotypesTest extends BaseStereotypesTest {

	private InteractionEditPart interaction;

	private ConnectionNodeEditPart messageWithGate;

	private ConnectionNodeEditPart messageFound;

	private ConnectionNodeEditPart messageLost;

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7.AbstractNodeTest#setUp()
	 * 
	 * @throws Exception
	 */

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		interaction = (InteractionEditPart)getRootEditPart().getParent();
		assertNotNull(interaction);

		LifelineEditPart lifeline = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(150, 100), null);
		Rectangle lifelineBounds = getAbsoluteBounds(lifeline);
		//1. messageWithGate
		Point endLocation = lifelineBounds.getCenter();
		Point startLocation = new Point(0, endLocation.y);
		messageWithGate = (ConnectionNodeEditPart)createLink(UMLElementTypes.Message_4004, interaction.getViewer(), startLocation, interaction, endLocation, lifeline);
		assertNotNull("messageWithGate", messageWithGate);

		//2. messagefound
		messageFound = (ConnectionNodeEditPart)createLink(UMLElementTypes.Message_4009, lifeline.getViewer(), endLocation.getTranslated(-100, 50), endLocation.getTranslated(0, 50));
		assertNotNull("messageFound", messageFound);

		//3. messageLost
		messageLost = (ConnectionNodeEditPart)createLink(UMLElementTypes.Message_4008, lifeline.getViewer(), endLocation.getTranslated(0, -50), endLocation.getTranslated(100, -50));
		assertNotNull("messageLost", messageLost);
	}

	@Test
	public void testDisplayStereotypeComment() {
		doTestDisplayStereotypeComment(interaction);
	}

	@Test
	public void testDisplayStereotypeInCompartment() {
		checkConnectionHorizontally(messageWithGate, GateEditPart.DEFAULT_SIZE.height / 2);
		checkConnectionHorizontally(messageFound, 1);
		checkConnectionHorizontally(messageLost, 1);
		doTestDisplayStereotypeInCompartment(interaction, interaction);
		checkConnectionHorizontally(messageWithGate, GateEditPart.DEFAULT_SIZE.height / 2);
		checkConnectionHorizontally(messageFound, 1);
		checkConnectionHorizontally(messageLost, 1);
	}

	@Test
	public void testDisplayStereotypeWithBrace() {
		checkConnectionHorizontally(messageWithGate, GateEditPart.DEFAULT_SIZE.height / 2);
		checkConnectionHorizontally(messageFound, 1);
		checkConnectionHorizontally(messageLost, 1);
		doTestDisplayStereotypeWithBrace(interaction, interaction);
		checkConnectionHorizontally(messageWithGate, GateEditPart.DEFAULT_SIZE.height / 2);
		checkConnectionHorizontally(messageFound, 1);
		checkConnectionHorizontally(messageLost, 1);
	}

}
