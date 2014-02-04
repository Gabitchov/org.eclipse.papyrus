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
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.junit.Test;


/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class DurationConstraintStereotypesTest extends BaseStereotypesTest {

	private DurationConstraintEditPart durationConstraint;

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7.AbstractNodeTest#setUp()
	 * 
	 * @throws Exception
	 */

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		durationConstraint = (DurationConstraintEditPart)createNode(UMLElementTypes.DurationConstraint_3021, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(durationConstraint);
	}

	@Test
	public void testDisplayStereotypeComment() {
		doTestDisplayStereotypeComment(durationConstraint);
	}

	@Test
	public void testDisplayStereotypeInCompartment() {
		doTestDisplayStereotypeInCompartment(durationConstraint, durationConstraint.getChildBySemanticHint("" + DurationConstraintAppliedStereotypeEditPart.VISUAL_ID));
	}

	@Test
	public void testDisplayStereotypeWithBrace() {
		doTestDisplayStereotypeWithBrace(durationConstraint, durationConstraint.getChildBySemanticHint("" + DurationConstraintAppliedStereotypeEditPart.VISUAL_ID));
	}

}
