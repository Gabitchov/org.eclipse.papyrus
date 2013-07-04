/*****************************************************************************
 * Copyright (c) 2010 CEA
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

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.junit.Before;
import org.junit.Test;

/**
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=395774
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class TestResizeStateInvariant_395774 extends AbstractNodeTest {

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7.AbstractNodeTest#setUp()
	 * 
	 * @throws Exception
	 */
	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected String getProjectName() {
		return ISequenceDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return ISequenceDiagramTestsConstants.FILE_NAME;
	}
	
	@Test
	public void testResize() {
		LifelineEditPart lifeline = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(lifeline);
		Rectangle r = getAbsoluteBounds(lifeline);
		StateInvariantEditPart stateInvariant = (StateInvariantEditPart)createNode(UMLElementTypes.StateInvariant_3017, lifeline, r.getCenter(), null);
		assertNotNull(stateInvariant);
		int move = 30;
		Rectangle beforeBounds = getAbsoluteBounds(stateInvariant);
		resize(stateInvariant, beforeBounds.getLocation(), PositionConstants.NORTH, new Dimension(0, move));
		resize(stateInvariant, beforeBounds.getLocation(), PositionConstants.SOUTH, new Dimension(0, move));
		resize(stateInvariant, beforeBounds.getLocation(), PositionConstants.WEST, new Dimension(move, 0));
		resize(stateInvariant, beforeBounds.getLocation(), PositionConstants.EAST, new Dimension(move, 0));
	}
}
