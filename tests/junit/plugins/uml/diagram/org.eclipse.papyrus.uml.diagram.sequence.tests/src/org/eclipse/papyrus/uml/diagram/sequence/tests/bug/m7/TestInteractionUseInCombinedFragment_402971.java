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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentCombinedFragmentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionUseEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.junit.Test;

/**
 * Fixed bug: A new created InteractionUse in CombinedFragment is always located at left and top
 *
 * See: https://bugs.eclipse.org/bugs/show_bug.cgi?id=402971
 *
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class TestInteractionUseInCombinedFragment_402971 extends AbstractNodeTest {

	@Override
	protected String getProjectName() {
		return ISequenceDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return ISequenceDiagramTestsConstants.FILE_NAME;
	}

	@Test
	public void test() {
		CombinedFragmentEditPart cf = (CombinedFragmentEditPart)createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), new Point(100, 100), new Dimension(500, 200));
		assertNotNull(cf);
		CombinedFragmentCombinedFragmentCompartmentEditPart compartment = (CombinedFragmentCombinedFragmentCompartmentEditPart)cf.getChildBySemanticHint("" + CombinedFragmentCombinedFragmentCompartmentEditPart.VISUAL_ID);
		assertNotNull(compartment);
		InteractionOperandEditPart operand = (InteractionOperandEditPart)compartment.getChildBySemanticHint("" + InteractionOperandEditPart.VISUAL_ID);
		assertNotNull(operand);
		//Create InteractionUses.
		int width = 20;
		int height = 20;
		Rectangle r = getAbsoluteBounds(operand);
		for(int x = r.x + width; x < r.right();) {
			int y = r.y + height + 10;
			Point location = new Point(x, y);
			InteractionUseEditPart interactionUse = (InteractionUseEditPart)createNode(UMLElementTypes.InteractionUse_3002, operand, location, null);
			assertNotNull(interactionUse);
			Rectangle bounds = getAbsoluteBounds(interactionUse);
			assertTrue("InteractionUse should be at " + location.toString() + ", but " + bounds.getLocation().toString(), location.equals(bounds.getLocation()));
			width = bounds.width + 20;
			height = bounds.height + 20;
			x = x + width;
		}
	}
}
