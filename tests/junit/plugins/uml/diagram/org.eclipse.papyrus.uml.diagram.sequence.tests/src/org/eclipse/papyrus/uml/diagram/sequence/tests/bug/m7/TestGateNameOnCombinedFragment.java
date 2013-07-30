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

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GateEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.junit.Test;


/**
 * Test the name of a Gate which created automatically on CombinedFragment when adding a Message.
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class TestGateNameOnCombinedFragment extends AbstractNodeTest {

	@Test
	public void testUncoveredLifeline2CombinedFragment() {
		testGateName("in_", false, true);
	}


	@Test
	public void testCoveredLifeline2CombinedFragment() {
		testGateName("out_", true, true);
	}

	@Test
	public void testCombinedFragment2CoveredLifeline() {
		testGateName("in_", true, false);
	}

	@Test
	public void testCombinedFragment2UncoveredLifeline() {
		testGateName("out_", false, false);
	}

	private void testGateName(String gateNamePrefix, boolean lifelineCovered, boolean messageFromLifeline2CombinedFragment) {
		//1. Create CombinedFragment
		CombinedFragmentEditPart cfEditPart = (CombinedFragmentEditPart)createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), new Point(100, 200), null);
		assertNotNull("CombinedFragment creation", cfEditPart);

		//2. Create Lifeline
		//Create a Lifeline which is covered by the CombinedFragment
		Rectangle cfBounds = SequenceUtil.getAbsoluteBounds(cfEditPart);
		Point lifelineLocation = new Point(0, 100);
		if(lifelineCovered) {
			lifelineLocation.x = cfBounds.getCenter().x;
		} else {
			lifelineLocation.x = cfBounds.getRight().x + 100;
		}
		LifelineEditPart lifelineEp = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), lifelineLocation, null);
		assertNotNull("Lifeline Creation", lifelineEp);

		//3. Check covered.
		CombinedFragment combinedFragment = (CombinedFragment)cfEditPart.resolveSemanticElement();
		Lifeline lifeline = (Lifeline)lifelineEp.resolveSemanticElement();
		if(lifelineCovered) {
			assertTrue("lifeline is covered by combinedFragment", lifeline.getCoveredBys().contains(combinedFragment));
		} else {
			assertTrue("lifeline is not covered by combinedFragment", !lifeline.getCoveredBys().contains(combinedFragment));
		}

		//4. Create Message between Lifeline and CombinedFragment.
		EditPart source = null, target = null;
		Point startLocation = null, targetLocation = null;
		if(messageFromLifeline2CombinedFragment) {
			source = lifelineEp;
			target = cfEditPart;
			targetLocation = SequenceUtil.getAbsoluteBounds(cfEditPart).getRight().getCopy();
			startLocation = SequenceUtil.getAbsoluteBounds(lifelineEp).getCenter().setY(targetLocation.y);
		} else {
			source = cfEditPart;
			startLocation = SequenceUtil.getAbsoluteBounds(cfEditPart).getRight().getCopy();
			target = lifelineEp;
			targetLocation = SequenceUtil.getAbsoluteBounds(lifelineEp).getCenter().setY(startLocation.y);
		}
		AbstractMessageEditPart messageEditPart = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, cfEditPart.getViewer(), startLocation, source, targetLocation, target);
		assertNotNull("Message creation between Lifeline and CombinedFragment", messageEditPart);

		//5. Check Gate name
		IGraphicalEditPart gateEditPart = cfEditPart.getChildBySemanticHint(GateEditPart.GATE_TYPE);
		assertNotNull("Gate created", gateEditPart);
		assertTrue("Gate created successfully", gateEditPart instanceof GateEditPart);
		Gate gate = (Gate)((GateEditPart)gateEditPart).resolveSemanticElement();
		Message message = (Message)messageEditPart.resolveSemanticElement();
		assertEquals("Gate name", gateNamePrefix + message.getLabel(), gate.getLabel());
	}
}
