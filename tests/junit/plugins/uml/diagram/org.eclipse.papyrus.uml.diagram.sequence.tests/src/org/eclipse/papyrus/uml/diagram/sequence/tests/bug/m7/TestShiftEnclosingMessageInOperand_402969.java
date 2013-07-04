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

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentCombinedFragmentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.junit.Test;

/**
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=402969
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class TestShiftEnclosingMessageInOperand_402969 extends AbstractNodeTest {

	@Override
	protected String getProjectName() {
		return ISequenceDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return ISequenceDiagramTestsConstants.FILE_NAME;
	}
	
	@Test
	public void testResizeOperand() {
		LifelineEditPart lifeline1 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(200, 100), new Dimension(80, 300));
		LifelineEditPart lifeline2 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(400, 100), new Dimension(80, 300));
		CombinedFragmentEditPart combinedFragment = (CombinedFragmentEditPart)createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), new Point(150, 150), new Dimension(380, 100));
		CombinedFragmentCombinedFragmentCompartmentEditPart compartment = (CombinedFragmentCombinedFragmentCompartmentEditPart)combinedFragment.getChildBySemanticHint("" + CombinedFragmentCombinedFragmentCompartmentEditPart.VISUAL_ID);
		IGraphicalEditPart operand1 = compartment.getChildBySemanticHint(InteractionOperandEditPart.VISUAL_ID + "");
		InteractionOperandEditPart operand2 = (InteractionOperandEditPart)createNode(UMLElementTypes.InteractionOperand_3005, compartment, getAbsoluteBounds(compartment).getCenter(), new Dimension(100, 200));
		Rectangle operandBounds = getAbsoluteBounds(operand2);
		int offset = 10;
		Point startLocation = getAbsoluteBounds(lifeline1).getCenter().setY(operandBounds.y + offset);
		Point endLocation = getAbsoluteBounds(lifeline2).getCenter().setY(operandBounds.y + offset);
		Message2EditPart message = (Message2EditPart)createLink(UMLElementTypes.Message_4004, lifeline1.getViewer(), startLocation, lifeline1, endLocation, lifeline2);
		checkMessageEnclosing(message, operandBounds);
		resize(operand1, operandBounds.getTop(), PositionConstants.SOUTH, new Dimension(0, offset * 2));
		Rectangle newOperandBounds = getAbsoluteBounds(operand2);
		checkMessageEnclosing(message, newOperandBounds);
	}

	/**
	 * @param message
	 * @param operandBounds
	 */
	private void checkMessageEnclosing(ConnectionNodeEditPart message, Rectangle operandBounds) {
		assertNotNull("message", message);
		assertNotNull("operandBounds", operandBounds);
		Point start = SequenceUtil.getAbsoluteEdgeExtremity(message, true);
		assertTrue("Enclosed source", operandBounds.contains(start));
		Point target = SequenceUtil.getAbsoluteEdgeExtremity(message, false);
		assertTrue("Enclosed target", operandBounds.contains(target));
	}
}
