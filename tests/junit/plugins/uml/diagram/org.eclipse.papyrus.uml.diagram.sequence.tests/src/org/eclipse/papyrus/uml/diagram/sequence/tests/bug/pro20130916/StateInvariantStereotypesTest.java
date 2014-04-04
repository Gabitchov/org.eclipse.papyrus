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
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.junit.Before;
import org.junit.Test;


/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class StateInvariantStereotypesTest extends BaseStereotypesTest {

	private StateInvariantEditPart stateInvariant;

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7.AbstractNodeTest#setUp()
	 *
	 * @throws Exception
	 */
	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();
		LifelineEditPart lifeline = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), null);
		stateInvariant = (StateInvariantEditPart)createNode(UMLElementTypes.StateInvariant_3017, lifeline, new Point(131, 150), null);
		assertNotNull(stateInvariant);
	}

	@Test
	public void testDisplayStereotypeComment() {
		doTestDisplayStereotypeComment(stateInvariant);
	}

	@Test
	public void testDisplayStereotypeInCompartment() {
		doTestDisplayStereotypeInCompartment(stateInvariant, stateInvariant);
	}

	@Test
	public void testDisplayStereotypeWithBrace() {
		doTestDisplayStereotypeWithBrace(stateInvariant, stateInvariant);
	}

}
