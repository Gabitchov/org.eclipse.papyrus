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
package org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.BendpointRequest;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragment2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.junit.Test;

/**
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=402970
 *
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class TestMoveAnchorInsideCoRegion_402970 extends AbstractNodeTest {

	@Override
	protected String getProjectName() {
		return ISequenceDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return ISequenceDiagramTestsConstants.FILE_NAME;
	}

	@Test
	public void testMoveMessageDown() {
		LifelineEditPart lifeline1 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(100, 300));
		LifelineEditPart lifeline2 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(300, 100), new Dimension(100, 300));
		CombinedFragment2EditPart coRegion = (CombinedFragment2EditPart)createNode(UMLElementTypes.CombinedFragment_3018, lifeline1, getAbsoluteBounds(lifeline1).getCenter(), new Dimension(50, 100));
		Point startLocation = getAbsoluteBounds(coRegion).getCenter().getTranslated(0, -30);
		Point endLocation = getAbsoluteBounds(lifeline2).getCenter().setY(startLocation.y);
		Message2EditPart messagePart = (Message2EditPart)createLink(UMLElementTypes.Message_4004, lifeline1.getViewer(), startLocation, coRegion, endLocation, lifeline2);
		waitForComplete();
		Point sourceLoc = SequenceUtil.getAbsoluteEdgeExtremity(messagePart, true);
		Point targetLoc = SequenceUtil.getAbsoluteEdgeExtremity(messagePart, false);
		//emulate drag line down with create Bendpoint request.
		BendpointRequest request = new BendpointRequest();
		request.setType(RequestConstants.REQ_CREATE_BENDPOINT);
		request.setSource(messagePart);
		int move = 20;
		Point location = new Point(sourceLoc.x + ((targetLoc.x - sourceLoc.x) / 2), sourceLoc.y + move);
		request.setLocation(location);;
		messagePart.showSourceFeedback(request);
		waitForComplete();//waiting for layout connection by change feedback.
		Command command = messagePart.getCommand(request);
		messagePart.eraseSourceFeedback(request);
		waitForComplete();
		if(command == null || !command.canExecute()) {
			fail("Can not move message down.");
		} else {
			getDiagramCommandStack().execute(command);
			waitForComplete();
			Point newSourceLoc = SequenceUtil.getAbsoluteEdgeExtremity(messagePart, true);
			Point newTargetLoc = SequenceUtil.getAbsoluteEdgeExtremity(messagePart, false);
			assertEquals("message source moved down(" + move + ")", sourceLoc.y + move, newSourceLoc.y);
			assertEquals("message target moved down(" + move + ")", targetLoc.y + move, newTargetLoc.y);
		}
	}
}
