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
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.junit.Test;


/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class LifelineStereotypesTest extends BaseStereotypesTest {

	private LifelineEditPart lifeline;

	private AbstractMessageEditPart link;

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7.AbstractNodeTest#setUp()
	 * 
	 * @throws Exception
	 */

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		lifeline = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(lifeline);

		LifelineEditPart lifeline2 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(400, 100), null);
		link = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, lifeline2.getViewer(), SequenceUtil.getAbsoluteBounds(lifeline).getCenter(), lifeline, SequenceUtil.getAbsoluteBounds(lifeline2).getCenter(), lifeline2);
		assertNotNull("link", link);
	}

	@Test
	public void testDisplayStereotypeComment() {
		doTestDisplayStereotypeComment(lifeline);
	}

	@Test
	public void testDisplayStereotypeInCompartment() {
		checkConnectionHorizontally(link, 1);
		doTestDisplayStereotypeInCompartment(lifeline, lifeline);
		checkConnectionHorizontally(link, 2);
	}

	@Test
	public void testDisplayStereotypeWithBrace() {
		checkConnectionHorizontally(link, 1);
		doTestDisplayStereotypeWithBrace(lifeline, lifeline);
		checkConnectionHorizontally(link, 2);
	}

}
