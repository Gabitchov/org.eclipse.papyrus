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

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.commands.SetPropertyCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentCombinedFragmentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.figures.LifelineFigure;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.Message;
import org.junit.Test;


/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class Fixbug_LifelineManagement_417365 extends BaseStereotypesTest {

	private LifelineEditPart lifeline1;

	private LifelineEditPart lifeline2;

	private LifelineEditPart lifeline3;

	private LifelineEditPart lifeline4;

	private AbstractMessageEditPart message1;

	private AbstractMessageEditPart message2;

	private AbstractMessageEditPart message3;

	private AbstractMessageEditPart message4;

	private AbstractMessageEditPart message5;

	private AbstractMessageEditPart message6;

	private AbstractMessageEditPart message7;

	private AbstractMessageEditPart message8;

	private AbstractMessageEditPart message9;

	private AbstractMessageEditPart message10;

	private AbstractMessageEditPart message11;

	private AbstractMessageEditPart message12;

	private AbstractMessageEditPart message13;

	private static final int[] FONT_HEIGHTS = { 9, 10, 12, 14, 17, 21, 28, 36, 48, 72 };

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7.AbstractNodeTest#setUp()
	 * 
	 * @throws Exception
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		prepareDiagram();
	}

	/**
	 * Create Test Diagram.
	 */
	protected void prepareDiagram() {
		//Create Lifelines
		lifeline1 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(100, 800));
		lifeline2 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(300, 100), new Dimension(100, 800));
		lifeline3 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(500, 100), null);

		int y = 120;
		//Create message from Interaction to Lifeline1.
		InteractionEditPart interaction = (InteractionEditPart)getRootEditPart().getParent();
		Rectangle interactionBounds = SequenceUtil.getAbsoluteBounds(interaction);
		Rectangle lifeline1Bounds = SequenceUtil.getAbsoluteBounds(lifeline1);
		Point pt = lifeline1Bounds.getCenter();
		message1 = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, lifeline1.getViewer(), new Point(0, y - 1), interaction, new Point(pt.x, y), lifeline1);

		//Create ExecutionSpecification on lifeline1 and Lifeline2
		y += 20;
		AbstractExecutionSpecificationEditPart execution1 = (AbstractExecutionSpecificationEditPart)createNode(UMLElementTypes.ActionExecutionSpecification_3006, lifeline1, new Point(pt.x, y), null);
		AbstractExecutionSpecificationEditPart execution2 = (AbstractExecutionSpecificationEditPart)createNode(UMLElementTypes.ActionExecutionSpecification_3006, lifeline2, SequenceUtil.getAbsoluteBounds(lifeline2).getCenter().setY(y), null);

		//Create Message between execution1 and execution2.
		message2 = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4003, lifeline1.getViewer(), SequenceUtil.getAbsoluteBounds(execution1).getTop(), execution1, SequenceUtil.getAbsoluteBounds(execution2).getTop(), execution2);
		message3 = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, lifeline1.getViewer(), SequenceUtil.getAbsoluteBounds(execution2).getBottom(), execution2, SequenceUtil.getAbsoluteBounds(execution1).getBottom(), execution1);

		//Create Message from execution2 to Lifeline3
		y = SequenceUtil.getAbsoluteBounds(execution2).getCenter().y;
		message4 = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, lifeline1.getViewer(), SequenceUtil.getAbsoluteBounds(execution2).getCenter(), execution2, SequenceUtil.getAbsoluteBounds(lifeline3).getCenter().translate(0, 1), lifeline3);

		lifeline4 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(650, 100), new Dimension(70, 100));
		//Create Message Create from lifeline3 to lifeline4
		y += 20;
		message5 = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4006, lifeline1.getViewer(), SequenceUtil.getAbsoluteBounds(lifeline3).getCenter().setY(y), lifeline3, SequenceUtil.getAbsoluteBounds(lifeline4).getTop(), lifeline4);

		//Create message  from interaction to lifeline4
		y += 40;
		message6 = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, lifeline1.getViewer(), interactionBounds.getRight().setY(y).translate(0, -1), interaction, SequenceUtil.getAbsoluteBounds(lifeline4).getCenter().setY(y), lifeline4);

		//Create message found and message lost
		y += 20;
		message7 = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4009, lifeline1.getViewer(), SequenceUtil.getAbsoluteBounds(lifeline3).getCenter().setY(y).getTranslated(-80, 0), interaction, SequenceUtil.getAbsoluteBounds(lifeline3).getCenter().setY(y), lifeline3);
		y += 20;
		message8 = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4008, lifeline1.getViewer(), SequenceUtil.getAbsoluteBounds(lifeline3).getCenter().setY(y), lifeline3, SequenceUtil.getAbsoluteBounds(lifeline3).getCenter().setY(y).getTranslated(80, 1), interaction);

		//Create CombinedFragment
		CombinedFragmentEditPart combinedFragment = (CombinedFragmentEditPart)createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), new Point(50, 300), new Dimension(500, 200));
		CombinedFragmentCombinedFragmentCompartmentEditPart compartment = (CombinedFragmentCombinedFragmentCompartmentEditPart)combinedFragment.getChildBySemanticHint(CombinedFragmentCombinedFragmentCompartmentEditPart.VISUAL_ID + "");
		InteractionOperandEditPart firstOperand = (InteractionOperandEditPart)compartment.getPrimaryChildEditPart();
		InteractionOperandEditPart secondOperand = (InteractionOperandEditPart)createNode(UMLElementTypes.InteractionOperand_3005, compartment, SequenceUtil.getAbsoluteBounds(combinedFragment).getCenter(), null);

		//create message in firstOperand
		y = SequenceUtil.getAbsoluteBounds(firstOperand).getCenter().y;
		AbstractExecutionSpecificationEditPart execution3 = (AbstractExecutionSpecificationEditPart)createNode(UMLElementTypes.ActionExecutionSpecification_3006, lifeline1, new Point(pt.x, y), null);
		AbstractExecutionSpecificationEditPart execution4 = (AbstractExecutionSpecificationEditPart)createNode(UMLElementTypes.ActionExecutionSpecification_3006, lifeline2, SequenceUtil.getAbsoluteBounds(lifeline2).getCenter().setY(y), null);
		//Create Message between execution1 and execution2.
		message9 = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4003, lifeline1.getViewer(), SequenceUtil.getAbsoluteBounds(execution3).getTop(), execution3, SequenceUtil.getAbsoluteBounds(execution4).getTop(), execution4);
		message10 = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, lifeline1.getViewer(), SequenceUtil.getAbsoluteBounds(execution4).getBottom(), execution4, SequenceUtil.getAbsoluteBounds(execution3).getBottom(), execution3);

		//create message in secondOperand
		y = SequenceUtil.getAbsoluteBounds(secondOperand).getCenter().y;
		message11 = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, lifeline1.getViewer(), SequenceUtil.getAbsoluteBounds(lifeline1).getCenter().setY(y), lifeline1, SequenceUtil.getAbsoluteBounds(lifeline2).getCenter().setY(y + 1), lifeline2);

		//Create message between Interaction and CombinedFragment
		y = SequenceUtil.getAbsoluteBounds(combinedFragment).getLeft().y;
		message12 = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, lifeline1.getViewer(), new Point(0, y - 1), interaction, SequenceUtil.getAbsoluteBounds(combinedFragment).getLeft(), combinedFragment);

		y = SequenceUtil.getAbsoluteBounds(combinedFragment).getRight().y;
		message13 = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, lifeline1.getViewer(), new Point(interactionBounds.right(), y - 1), interaction, SequenceUtil.getAbsoluteBounds(combinedFragment).getRight(), combinedFragment);

		waitForComplete();
		validateMessageHorizontally();
	}

	/**
	 * Validate all messages has same position horizontally.
	 */
	private void validateMessageHorizontally() {
		validateMessageHorizontally(message1);
		validateMessageHorizontally(message2);
		validateMessageHorizontally(message3);
		validateMessageHorizontally(message4);
		validateMessageHorizontally(message5);
		validateMessageHorizontally(message6);
		validateMessageHorizontally(message7);
		validateMessageHorizontally(message8);
		validateMessageHorizontally(message9);
		validateMessageHorizontally(message10);
		validateMessageHorizontally(message11);
		validateMessageHorizontally(message12);
		validateMessageHorizontally(message13);
	}

	private void validateMessageHorizontally(AbstractMessageEditPart message) {
		assertNotNull("message", message);
		//		waitForComplete();
		//		message.refresh();
		//		waitForComplete();
		Connection conn = message.getConnectionFigure();
		PointList points = conn.getPoints();
		int start = points.getFirstPoint().y;
		int end = points.getLastPoint().y;
		EObject obj = message.resolveSemanticElement();
		String name = "";
		if(obj instanceof Message) {
			name = ((Message)obj).getName();
		}
		assertEquals("message horizontal position<" + name + ">", end, start);
	}

	private void validateAll() {
		validateLifelineHeadBottom();
		validateMessageHorizontally();
	}

	/**
	 * Validate lifelife head's bottom.
	 */
	private void validateLifelineHeadBottom() {
		int b1 = getLifelineHeadBottom(lifeline1);
		int b2 = getLifelineHeadBottom(lifeline2);
		int b3 = getLifelineHeadBottom(lifeline3);
		assertTrue("Lifeline head bottom", Math.abs(b1 - b2) <= 1);
		assertTrue("Lifeline head bottom", Math.abs(b1 - b3) <= 1);
	}

	private int getLifelineHeadBottom(LifelineEditPart lifeline) {
		LifelineFigure figure = lifeline.getPrimaryShape();
		RectangleFigure figureLifelineNameContainerFigure = figure.getFigureLifelineNameContainerFigure();
		return figureLifelineNameContainerFigure.getBounds().bottom();
	}

	@Test
	public void testFontChanged() {
		//Increase height of font for lifeline1
		for(int i = 1; i < FONT_HEIGHTS.length; i++) {
			int height = FONT_HEIGHTS[i];
			testChangeFontHeight(lifeline1, height);
		}
		//Decrease height of font for lifeline1
		for(int i = FONT_HEIGHTS.length - 2; i >= 0; i--) {
			int height = FONT_HEIGHTS[i];
			testChangeFontHeight(lifeline1, height);
		}
		//Increase height of font for lifeline2
		for(int i = 1; i < FONT_HEIGHTS.length; i++) {
			int height = FONT_HEIGHTS[i];
			testChangeFontHeight(lifeline2, height);
		}
		//Decrease height of font for lifeline2
		for(int i = FONT_HEIGHTS.length - 2; i >= 0; i--) {
			int height = FONT_HEIGHTS[i];
			testChangeFontHeight(lifeline2, height);
		}
		//Increase height of font for lifeline3
		for(int i = 1; i < FONT_HEIGHTS.length; i++) {
			int height = FONT_HEIGHTS[i];
			testChangeFontHeight(lifeline3, height);
		}
		//Decrease height of font for lifeline3
		for(int i = FONT_HEIGHTS.length - 2; i >= 0; i--) {
			int height = FONT_HEIGHTS[i];
			testChangeFontHeight(lifeline3, height);
		}
		//Increase height of font for lifeline4
		for(int i = 1; i < FONT_HEIGHTS.length; i++) {
			int height = FONT_HEIGHTS[i];
			testChangeFontHeight(lifeline4, height);
		}
		//Decrease height of font for lifeline4
		for(int i = FONT_HEIGHTS.length - 2; i >= 0; i--) {
			int height = FONT_HEIGHTS[i];
			testChangeFontHeight(lifeline4, height);
		}
	}

	/**
	 * @param lifeline
	 * @param height
	 */
	private void testChangeFontHeight(LifelineEditPart lifeline, int height) {
		assertNotNull("lifeline", lifeline);
		SetPropertyCommand command = new SetPropertyCommand(getEditingDomain(), lifeline, "notation.FontStyle.fontHeight", "Font Size", height);
		executeOnUIThread(new ICommandProxy(command));
		waitForComplete();
		validateAll();
	}

	@Test
	public void testStereotypeChanged() {
		//Applied stereotype on lifeline1
		doTestDisplayStereotypeInCompartment(lifeline1, lifeline1);
		waitForComplete();
		validateAll();

		//Applied stereotype on lifeline2
		doTestDisplayStereotypeInCompartment(lifeline2, lifeline2);
		waitForComplete();
		validateAll();

		//Applied stereotype on lifeline3
		doTestDisplayStereotypeInCompartment(lifeline3, lifeline3);
		waitForComplete();
		validateAll();

		//Applied stereotype on lifeline4
		doTestDisplayStereotypeInCompartment(lifeline4, lifeline4);
		waitForComplete();
		validateAll();
	}

	@Test
	public void testResizeLifelineAfterStereotypeApplied() {
		//Applied stereotype on lifeline1
		doTestDisplayStereotypeInCompartment(lifeline4, lifeline4);
		//resize down/up from bottom 
		resize(lifeline4, SequenceUtil.getAbsoluteBounds(lifeline4).getLocation(), PositionConstants.SOUTH, new Dimension(0, 30));
		resize(lifeline4, SequenceUtil.getAbsoluteBounds(lifeline4).getLocation(), PositionConstants.NORTH, new Dimension(0, 30));

		//resize west
		resize(lifeline4, SequenceUtil.getAbsoluteBounds(lifeline4).getLocation(), PositionConstants.WEST, new Dimension(30, 0));
		//resize east
		resize(lifeline4, SequenceUtil.getAbsoluteBounds(lifeline4).getLocation(), PositionConstants.EAST, new Dimension(30, 0));
	}
}
