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

import static org.junit.Assert.assertNotNull;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7.AbstractNodeTest;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.junit.Test;

/**
 * Fixed bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=417373
 *
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class Fixbug_EditorCrashesWhenMovingGeneralOrdering_417373 extends AbstractNodeTest {

	@Test
	public void test() {
		EditPart lifeline1 = createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 400), new Dimension(100, 400));
		EditPart lifeline2 = createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(350, 400), new Dimension(100, 400));
		Point startLocation = SequenceUtil.getAbsoluteBounds((IGraphicalEditPart)lifeline1).getCenter().getCopy();
		Point endLocation = SequenceUtil.getAbsoluteBounds((IGraphicalEditPart)lifeline2).getCenter().getCopy();
		AbstractMessageEditPart message1 = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, lifeline1.getViewer(), startLocation, lifeline1, endLocation, lifeline2);
		AbstractMessageEditPart message2 = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, lifeline1.getViewer(), endLocation.getTranslated(0, 79), lifeline2, startLocation.getTranslated(0, 80), lifeline1);
		//create General Ordering
		startLocation = SequenceUtil.getAbsoluteEdgeExtremity(message1, false);
		endLocation = SequenceUtil.getAbsoluteEdgeExtremity(message2, false);
		EditPart generalOrdering = createLink(UMLElementTypes.GeneralOrdering_4012, lifeline1.getViewer(), startLocation, lifeline2, endLocation, lifeline1);
		assertNotNull("generalOrdering", generalOrdering);

		//Move down the end of message2 10 times.
		Point pt = endLocation.getCopy();
		for(int i = 1; i <= 10; i++) {
			Point p = pt.getTranslated(0, i * 10);
			reconnectTarget(message2, message2.getTarget(), p);
			getDiagramCommandStack().undo();
			waitForComplete();
		}

	}
}
