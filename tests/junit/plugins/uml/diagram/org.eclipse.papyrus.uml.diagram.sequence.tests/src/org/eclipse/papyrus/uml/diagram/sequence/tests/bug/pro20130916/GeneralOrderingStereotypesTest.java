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

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GeneralOrderingEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class GeneralOrderingStereotypesTest extends BaseStereotypesTest {

	private GeneralOrderingEditPart generalOrdering;

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7.AbstractNodeTest#setUp()
	 *
	 * @throws Exception
	 */
	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();
		LifelineEditPart source = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(source);
		LifelineEditPart target = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(300, 100), null);
		assertNotNull(target);
		Point sourcePoint = getAbsoluteCenter(source);
		Point targetPoint = getAbsoluteCenter(target);
		Message2EditPart message1 = (Message2EditPart)createLink(UMLElementTypes.Message_4004, source.getViewer(), sourcePoint, targetPoint);
		assertNotNull(message1);
		Message2EditPart message2 = (Message2EditPart)createLink(UMLElementTypes.Message_4004, source.getViewer(), sourcePoint.getTranslated(0, 50), targetPoint.getTranslated(0, 50));
		assertNotNull(message2);
		sourcePoint = SequenceUtil.getAbsoluteEdgeExtremity(message1, true);
		targetPoint = SequenceUtil.getAbsoluteEdgeExtremity(message2, false);
		generalOrdering = (GeneralOrderingEditPart)createLink(UMLElementTypes.GeneralOrdering_4012, source.getViewer(), sourcePoint, targetPoint);
		assertNotNull(generalOrdering);
	}

	@Test
	public void testDisplayStereotypeComment() {
		doTestDisplayStereotypeComment(generalOrdering);
	}

}
