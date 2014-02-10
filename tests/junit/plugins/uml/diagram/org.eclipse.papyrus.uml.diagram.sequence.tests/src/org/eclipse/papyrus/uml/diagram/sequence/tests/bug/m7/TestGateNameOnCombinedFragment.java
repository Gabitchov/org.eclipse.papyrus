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

import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GateEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.figures.MessageFigure;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.GateHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.swt.widgets.Control;
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

	@Test
	public void testUncoveredLifeline2CombinedFragmentGate() {
		testFixedGateName("Gate0", false, true);
	}


	@Test
	public void testCoveredLifeline2CombinedFragmentGate() {
		testFixedGateName("Gate1", true, true);
	}

	@Test
	public void testCombinedFragmentGate2CoveredLifeline() {
		testFixedGateName("Gate2", true, false);
	}

	@Test
	public void testCombinedFragmentGate2UncoveredLifeline() {
		testFixedGateName("Gate3", false, false);
	}

	private GateEditPart createGate(EditPart parent, Point location) {
		CreateRequest request = new CreateRequest(RequestConstants.REQ_CREATE);
		request.setFactory(new CreationFactory() {

			public Object getObjectType() {
				return GateEditPart.GATE_TYPE;
			}

			public Object getNewObject() {
				return GateEditPart.GATE_TYPE;
			}
		});
		request.setLocation(location);
		Command command = parent.getCommand(request);
		assertNotNull("create gate command", command);
		assertTrue("executable of create gate command", command.canExecute());
		getDiagramCommandStack().execute(command);
		waitForComplete();
		GateEditPart gateEditPart = getPrimaryGateEditPart(parent);
		assertNotNull("created gate", gateEditPart);
		return gateEditPart;
	}

	protected GateEditPart getPrimaryGateEditPart(EditPart parent) {
		@SuppressWarnings("rawtypes")
		List children = parent.getChildren();
		for(int i = children.size() - 1; i >= 0; i--) {
			Object child = children.get(i);
			if(child instanceof GateEditPart) {
				GateEditPart gateEp = (GateEditPart)child;
				Gate gate = (Gate)gateEp.resolveSemanticElement();
				if(!(GateHelper.isInnerCFGate(gate))) {
					return gateEp;
				}
			}
		}
		return null;
	}

	protected EditPart createLink(IElementType elementType, EditPartViewer currentViewer, Point startLocation, EditPart sourceEditPart, Point endLocation, EditPart targetEditPart) {
		final EditPart linkEditPart = super.createLink(elementType, currentViewer, startLocation, sourceEditPart, endLocation, targetEditPart);
		if(linkEditPart instanceof AbstractMessageEditPart) {
			currentViewer.setSelection(new StructuredSelection(linkEditPart));
			waitForComplete();
			performFirstDirectEdit((AbstractMessageEditPart)linkEditPart);
		}
		return linkEditPart;
	}

	/**
	 * Emulate a direct edit after creation like use the palette tool.
	 */
	@SuppressWarnings({ "unchecked" })
	private void performFirstDirectEdit(AbstractMessageEditPart messageEditPart) {
		MessageFigure primaryShape = messageEditPart.getPrimaryShape();
		WrappingLabel label = primaryShape.getMessageLabelFigure();
		DirectEditRequest req = new DirectEditRequest();
		Rectangle b = label.getBounds().getCopy();
		label.translateToAbsolute(b);
		req.setLocation(b.getCenter());
		req.getExtendedData().put(SequenceRequestConstant.DIRECT_EDIT_AFTER_CREATION, true);
//		messageEditPart.performRequest(req);

		waitForComplete();

		//Deactive the Popup Editor.
		Control control = messageEditPart.getViewer().getControl();
		control.setFocus();
		Control focusControl = control.getDisplay().getFocusControl();
		
		waitForComplete();
	}

	private void testFixedGateName(String gateName, boolean lifelineCovered, boolean messageFromLifeline2Gate) {
		//1. Create CombinedFragment
		CombinedFragmentEditPart cfEditPart = (CombinedFragmentEditPart)createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), new Point(100, 200), null);
		assertNotNull("CombinedFragment creation", cfEditPart);
		//1.1 Create Gate on CombinedFragment
		Rectangle cfBounds = SequenceUtil.getAbsoluteBounds(cfEditPart);
		GateEditPart gateEditPart = createGate(cfEditPart, new Point(cfBounds.right() - 1, cfBounds.y + cfBounds.height / 2));
		assertNotNull("Gate on CombinedFragment creation", gateEditPart);

		Gate gate = (Gate)((GateEditPart)gateEditPart).resolveSemanticElement();
		changeName(getEditingDomain(), gate, gateName);
		assertEquals("Check gate name when creation", gateName, gate.getLabel());
		//2. Create Lifeline
		//Create a Lifeline which is covered by the CombinedFragment
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
		if(messageFromLifeline2Gate) {
			source = lifelineEp;
			target = gateEditPart;
			targetLocation = SequenceUtil.getAbsoluteBounds(gateEditPart).getRight().getCopy();
			startLocation = SequenceUtil.getAbsoluteBounds(lifelineEp).getCenter().setY(targetLocation.y);
		} else {
			source = gateEditPart;
			startLocation = SequenceUtil.getAbsoluteBounds(gateEditPart).getRight().getCopy();
			target = lifelineEp;
			targetLocation = SequenceUtil.getAbsoluteBounds(lifelineEp).getCenter().setY(startLocation.y);
		}
		AbstractMessageEditPart messageEditPart = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, cfEditPart.getViewer(), startLocation, source, targetLocation, target);
		assertNotNull("Message creation between Lifeline and Gate of CombinedFragment", messageEditPart);

		//5. Check Gate name
		assertEquals("Check gate name after message creation", gateName, gate.getLabel());
	}
}
