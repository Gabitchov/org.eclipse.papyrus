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
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.junit.Before;
import org.junit.Test;


/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class TimeConstraintStereotypesTest extends BaseStereotypesTest {

	private TimeObservationEditPart timeObservation;

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7.AbstractNodeTest#setUp()
	 *
	 * @throws Exception
	 */
	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();
		EditPart lifeline = createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), null);
		AbstractExecutionSpecificationEditPart es = (AbstractExecutionSpecificationEditPart)createNode(UMLElementTypes.ActionExecutionSpecification_3006, lifeline, new Point(131, 100), null);
		Point location = SequenceUtil.getAbsoluteBounds(es).getTop().getCopy();
		timeObservation = (TimeObservationEditPart)createNode(UMLElementTypes.TimeObservation_3020, getRootEditPart(), location, null);
		assertNotNull(timeObservation);
	}

	@Test
	public void testDisplayStereotypeComment() {
		//It seems the TimeObservationEditPart can not be selected from diagram, we use the Label EditPart instead.
		IGraphicalEditPart label = timeObservation.getChildBySemanticHint("" + TimeObservationLabelEditPart.VISUAL_ID);
		doTestDisplayStereotypeComment(label);
	}

	@Test
	public void testDisplayStereotypeInCompartment() {
		//It seems the TimeObservationEditPart can not be selected from diagram, we use the Label EditPart instead.
		IGraphicalEditPart label = timeObservation.getChildBySemanticHint("" + TimeObservationLabelEditPart.VISUAL_ID);
		doTestDisplayStereotypeInCompartment(label, timeObservation.getChildBySemanticHint("" + TimeObservationAppliedStereotypeEditPart.VISUAL_ID));
	}

	@Test
	public void testDisplayStereotypeWithBrace() {
		//It seems the TimeObservationEditPart can not be selected from diagram, we use the Label EditPart instead.
		IGraphicalEditPart label = timeObservation.getChildBySemanticHint("" + TimeObservationLabelEditPart.VISUAL_ID);
		doTestDisplayStereotypeWithBrace(label, timeObservation.getChildBySemanticHint("" + TimeObservationAppliedStereotypeEditPart.VISUAL_ID));
	}

}
