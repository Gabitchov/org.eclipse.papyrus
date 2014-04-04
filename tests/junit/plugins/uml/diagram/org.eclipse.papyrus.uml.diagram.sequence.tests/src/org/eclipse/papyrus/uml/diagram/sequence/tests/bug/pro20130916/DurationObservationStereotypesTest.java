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
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationObservationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationObservationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class DurationObservationStereotypesTest extends BaseStereotypesTest {

	private DurationObservationEditPart durationObservation;

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7.AbstractNodeTest#setUp()
	 *
	 * @throws Exception
	 */
	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();
		durationObservation = (DurationObservationEditPart)createNode(UMLElementTypes.DurationObservation_3024, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(durationObservation);
	}

	@Test
	public void testDisplayStereotypeComment() {
		doTestDisplayStereotypeComment(durationObservation);
	}

	@Test
	public void testDisplayStereotypeInCompartment() {
		doTestDisplayStereotypeInCompartment(durationObservation, durationObservation.getChildBySemanticHint("" + DurationObservationAppliedStereotypeEditPart.VISUAL_ID));
	}

	@Test
	public void testDisplayStereotypeWithBrace() {
		doTestDisplayStereotypeWithBrace(durationObservation, durationObservation.getChildBySemanticHint("" + DurationObservationAppliedStereotypeEditPart.VISUAL_ID));
	}
}
