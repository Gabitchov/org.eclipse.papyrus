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
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message3EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message4EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message5EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message6EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message7EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.junit.Test;


/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class MessageStereotypesTest extends BaseStereotypesTest {

	protected void doTest(AbstractMessageEditPart message) {
		doTestDisplayStereotypeComment(message);
	}

	@Test
	public void testSynchronousMessage() {
		LifelineEditPart lifeline1 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(lifeline1);
		ActionExecutionSpecificationEditPart source = (ActionExecutionSpecificationEditPart)createNode(UMLElementTypes.ActionExecutionSpecification_3006, lifeline1, getAbsoluteCenter(lifeline1), null);
		assertNotNull(source);
		LifelineEditPart lifeline2 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(300, 100), null);
		assertNotNull(lifeline2);
		ActionExecutionSpecificationEditPart target = (ActionExecutionSpecificationEditPart)createNode(UMLElementTypes.ActionExecutionSpecification_3006, lifeline2, getAbsoluteCenter(lifeline2), null);
		assertNotNull(target);
		MessageEditPart message = (MessageEditPart)createLink(UMLElementTypes.Message_4003, lifeline1.getViewer(), getAbsoluteCenter(source), getAbsoluteCenter(target));
		assertNotNull(message);
		doTest(message);
	}

	@Test
	public void testAsynchronousMessage() {
		LifelineEditPart source = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(source);
		LifelineEditPart target = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(300, 100), null);
		assertNotNull(target);
		Message2EditPart message = (Message2EditPart)createLink(UMLElementTypes.Message_4004, source.getViewer(), getAbsoluteCenter(source), getAbsoluteCenter(target));
		assertNotNull(message);
		doTest(message);
	}

	@Test
	public void testCreateMessage() {
		LifelineEditPart source = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(source);
		LifelineEditPart target = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(300, 100), null);
		assertNotNull(target);
		Message4EditPart message = (Message4EditPart)createLink(UMLElementTypes.Message_4006, source.getViewer(), getAbsoluteCenter(source), getAbsoluteCenter(target));
		assertNotNull(message);
		doTest(message);
	}

	@Test
	public void testReplyMessage() {
		LifelineEditPart lifeline1 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(300, 100), null);
		assertNotNull(lifeline1);
		ActionExecutionSpecificationEditPart source = (ActionExecutionSpecificationEditPart)createNode(UMLElementTypes.ActionExecutionSpecification_3006, lifeline1, getAbsoluteCenter(lifeline1).getTranslated(0, -100), null);
		assertNotNull(source);
		LifelineEditPart lifeline2 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(lifeline2);
		ActionExecutionSpecificationEditPart target = (ActionExecutionSpecificationEditPart)createNode(UMLElementTypes.ActionExecutionSpecification_3006, lifeline2, getAbsoluteCenter(lifeline2).getTranslated(0, 100), null);
		assertNotNull(target);
		Message3EditPart message = (Message3EditPart)createLink(UMLElementTypes.Message_4005, source.getViewer(), getAbsoluteCenter(source), getAbsoluteCenter(target));
		assertNotNull(message);
		doTest(message);
	}

	@Test
	public void testFoundMessage() {
		LifelineEditPart target = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(300, 100), null);
		assertNotNull(target);
		Point targetLocation = getAbsoluteCenter(target);
		Point sourceLocation = targetLocation.getTranslated(-100, 0);
		Message7EditPart message = (Message7EditPart)createLink(UMLElementTypes.Message_4009, target.getViewer(), sourceLocation, targetLocation);
		assertNotNull(message);
		doTest(message);
	}

	@Test
	public void testLostMessage() {
		LifelineEditPart source = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(300, 100), null);
		assertNotNull(source);
		Point sourceLocation = getAbsoluteCenter(source);
		Point targetLocation = sourceLocation.getTranslated(100, 0);
		Message6EditPart message = (Message6EditPart)createLink(UMLElementTypes.Message_4008, source.getViewer(), sourceLocation, targetLocation);
		assertNotNull(message);
		doTest(message);
	}

	@Test
	public void testDeleteMessage() {
		LifelineEditPart source = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(source);
		LifelineEditPart target = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(300, 100), null);
		assertNotNull(target);
		Message5EditPart message = (Message5EditPart)createLink(UMLElementTypes.Message_4007, source.getViewer(), getAbsoluteCenter(source), getAbsoluteCenter(target));
		assertNotNull(message);
		doTest(message);
	}
}
