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

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GateEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GateNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionUseEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.sequence.util.GateHelper;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;

/**
 * Graphical Presentation of Gate with In/Out
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=389531
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class TestGraphicalGate_389531 extends AbstractNodeTest {

	@Override
	protected String getProjectName() {
		return ISequenceDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return ISequenceDiagramTestsConstants.FILE_NAME;
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

	protected GateEditPart getGateEditPart(EditPart parent, Gate gate) {
		@SuppressWarnings("rawtypes")
		List children = parent.getChildren();
		for(int i = children.size() - 1; i >= 0; i--) {
			Object child = children.get(i);
			if(child instanceof GateEditPart) {
				GateEditPart gateEp = (GateEditPart)child;
				if(gate == gateEp.resolveSemanticElement()) {
					return gateEp;
				}
			}
		}
		return null;
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

	protected GateEditPart getInnerGateEditPart(GateEditPart outerGateEditPart) {
		Gate outerGate = (Gate)outerGateEditPart.resolveSemanticElement();
		Gate innerCFGate = GateHelper.getInnerCFGate(outerGate);
		if(innerCFGate == null) {
			return null;
		}
		@SuppressWarnings("rawtypes")
		List children = outerGateEditPart.getParent().getChildren();
		for(int i = children.size() - 1; i >= 0; i--) {
			Object child = children.get(i);
			if(child instanceof GateEditPart) {
				GateEditPart gateEp = (GateEditPart)child;
				Gate gate = (Gate)gateEp.resolveSemanticElement();
				if(innerCFGate == gate) {
					return gateEp;
				}
			}
		}
		return null;
	}

	protected String getGateName(GateEditPart gateEditPart) {
		IGraphicalEditPart label = gateEditPart.getChildBySemanticHint(GateNameEditPart.GATE_NAME_TYPE);
		if(label != null) {
			return ((WrappingLabel)label.getFigure()).getText();
		}
		return null;
	}

	protected EditPart createGateParent(IElementType parentType, Point parentLocation, Dimension parentSize) {
		assertNotNull(parentType);
		EditPart parentEditPart = null;
		InteractionEditPart interactionEditPart = (InteractionEditPart)getRootEditPart().getParent();
		if(UMLElementTypes.Interaction_2001 == parentType) {
			parentEditPart = interactionEditPart;
		} else {
			parentEditPart = createNode(parentType, getRootEditPart(), parentLocation, parentSize);
		}
		assertNotNull("create Gate parent", parentEditPart);
		if(UMLElementTypes.InteractionUse_3002 == parentType) {
			//set refersTo value.
			updateValue(getEditingDomain(), ((IGraphicalEditPart)parentEditPart).resolveSemanticElement(), UMLPackage.Literals.INTERACTION_USE__REFERS_TO, interactionEditPart.resolveSemanticElement());
		}
		return parentEditPart;
	}

	/**
	 * Create a Gate on given type parent.
	 * 
	 * @param parentType
	 * @param parentLocation
	 * @param parentSize
	 * @param onLeftSide
	 * @return
	 */
	protected GateEditPart createGateWithParent(IElementType parentType, Point parentLocation, Dimension parentSize, boolean onLeftSide) {
		EditPart parentEditPart = createGateParent(parentType, parentLocation, parentSize);
		Rectangle bounds = getAbsoluteBounds((IGraphicalEditPart)parentEditPart);
		GateEditPart gate = createGate(parentEditPart, onLeftSide ? new Point(bounds.x, bounds.y + bounds.height / 2) : new Point(bounds.right() - 1, bounds.y + bounds.height / 2));
		assertNotNull("create Gate on " + parentType.getDisplayName(), gate);
		return gate;
	}

	protected AbstractExecutionSpecificationEditPart createExecutionSpecificationWithLifeline(Point lifelineLocation, Dimension lifelineSize) {
		LifelineEditPart lifeline = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), lifelineLocation, lifelineSize);
		assertNotNull("create ExecutionSpecification's Lifeline", lifeline);
		AbstractExecutionSpecificationEditPart es = (AbstractExecutionSpecificationEditPart)createNode(UMLElementTypes.ActionExecutionSpecification_3006, lifeline, getAbsoluteBounds(lifeline).getCenter(), null);
		assertNotNull("create ExecutionSpecification", es);
		return es;
	}

	protected EditPart createNode(IElementType type, EditPart parentPart, Point location, Dimension size) {
		EditPart editPart = super.createNode(type, parentPart, location, size);
		assertNotNull("create failed: " + type.getDisplayName(), editPart);
		return editPart;
	}

	@Override
	protected EditPart createLink(IElementType elementType, EditPartViewer currentViewer, Point startLocation, Point endLocation) {
		EditPart link = super.createLink(elementType, currentViewer, startLocation, endLocation);
		assertNotNull("create link", link);
		return link;
	}

	/**
	 * Test create Gate on CombinedFragment by using Palette.
	 */
	@Test
	public void testGateCreateOnCombinedFragment() {
		createGateWithParent(UMLElementTypes.CombinedFragment_3004, new Point(100, 100), new Dimension(200, 200), true);
		createGateWithParent(UMLElementTypes.CombinedFragment_3004, new Point(100, 100), new Dimension(200, 200), false);
	}

	/**
	 * Test create Gate on Interaction by using Palette.
	 */
	@Test
	public void testGateCreateOnInteraction() {
		createGateWithParent(UMLElementTypes.Interaction_2001, new Point(100, 100), new Dimension(200, 200), true);
		createGateWithParent(UMLElementTypes.Interaction_2001, new Point(100, 100), new Dimension(200, 200), false);
	}

	/**
	 * Test create Gate on InteractionUse by using Palette.
	 */
	@Test
	public void testGateCreateOnInteractionUse() {
		GateEditPart gateOnInteractionUse = createGateWithParent(UMLElementTypes.InteractionUse_3002, new Point(100, 100), new Dimension(200, 200), true);
		InteractionEditPart iep = (InteractionEditPart)getRootEditPart().getParent();
		Gate selfGate = (Gate)gateOnInteractionUse.resolveSemanticElement();
		assertNotNull(selfGate);
		//Automatically create a gate on refersTo Interaction.
		Interaction interaction = (Interaction)iep.resolveSemanticElement();
		Gate formalGate = interaction.getFormalGate(selfGate.getName());
		assertNotNull(formalGate);
		GateEditPart gateOnInteraction = getGateEditPart(iep, formalGate);
		assertNotNull("Gate created on Interaction", gateOnInteraction);
	}

	/**
	 * Test Async Message creation from a Lifeline to the existing Gate on CombinedFragment.
	 */
	@Test
	public void testGateCreateWithMessageAsyncOnGate() {
		LifelineEditPart lifeline1 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(100, 400));
		//the lifeline2 should be covered by the CombinedFragment.
		LifelineEditPart lifeline2 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(400, 100), new Dimension(100, 400));
		CombinedFragmentEditPart cf = (CombinedFragmentEditPart)createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), new Point(300, 100), new Dimension(200, 200));
		CombinedFragment combinedFragment = (CombinedFragment)cf.resolveSemanticElement();
		Lifeline covered = (Lifeline)lifeline2.resolveSemanticElement();
		assertTrue("lifeline should be covered by CombinedFragment", combinedFragment.getCovereds().contains(covered));
		Rectangle rect = getAbsoluteBounds(cf);
		GateEditPart outerGateEditPart = createGate(cf, new Point(rect.x, rect.y + rect.height / 2));
		assertNotNull("new Gate should be created", outerGateEditPart);
		//Message from Lifeline1 to Gate(outer gate) of CombinedFragment
		Rectangle r = getAbsoluteBounds(outerGateEditPart);
		Point endLocation = r.getCenter();
		Point startLocation = getAbsoluteBounds(lifeline1).getCenter().setY(endLocation.y);
		Message2EditPart message1EditPart = (Message2EditPart)createLink(UMLElementTypes.Message_4004, lifeline1.getViewer(), startLocation, endLocation);
		assertNotNull("Message from Lifeline1 to Gate(outer gate) of CombinedFragment should be created", message1EditPart);
		//Check names with the outer gate and message1.
		Message message1 = (Message)message1EditPart.resolveSemanticElement();
		String name = "m1";
		changeName(getEditingDomain(), message1, name);
		//		assertEquals("Suggestion name of outer gate", "in_m1", getGateName(outerGateEditPart));
	}

	/**
	 * Test Async Message with inner gate and outer gate on CombinedFragment.
	 * 1. message1: Lifeline1 --> CombinedFragment
	 * 1.1 Lifeline1 is at the left of CombinedFragment, and it not covered by the CombinedFragment.
	 * 1.2 After message creation, there are 2 gates (the inner gate and outer gate) should be created on CombinedFragment automatically.
	 * 1.3 The gates named to "in_<message1.name>".
	 * 2. message2: Inner Gate(1.2) --> Lifeline2
	 * 2.1 Lifeline2 is covered by the CombinedFragment.
	 * 2.2 The name of message2 should be automatically suggested to same as message1 one.
	 * 3. message3: CombinedFragment --> Lifeline3
	 * 3.1 Lifeline3 is at the right of CombinedFragment, and is not covered by the CombinedFragment.
	 * 3.2 The 2 gates should all named to "out_<message3.name>".
	 * 4. message4: Lifeline2 --> Inner Gate(3.2)
	 * 4.1 message4.name == message3.name
	 */
	@Test
	public void testGateCreateWithMessageAsyncOnCombinedFragment() {
		LifelineEditPart lifeline1 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(100, 400));
		// the lifeline2 should be covered by the CombinedFragment.
		LifelineEditPart lifeline2 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(350, 100), new Dimension(100, 400));
		CombinedFragmentEditPart cf = (CombinedFragmentEditPart)createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), new Point(300, 100), new Dimension(200, 200));
		//create CombinedFragment
		CombinedFragment combinedFragment = (CombinedFragment)cf.resolveSemanticElement();
		Lifeline covered = (Lifeline)lifeline2.resolveSemanticElement();
		assertTrue("lifeline should be covered by CombinedFragment", combinedFragment.getCovereds().contains(covered));
		//1. Message from Lifeline1 to  CombinedFragment
		Point startLocation = getAbsoluteBounds(lifeline1).getCenter();
		Rectangle r = getAbsoluteBounds(cf);
		Point endLocation = r.getLocation().setY(startLocation.y);
		Message2EditPart message1EditPart = (Message2EditPart)createLink(UMLElementTypes.Message_4004, lifeline1.getViewer(), startLocation, endLocation);
		assertNotNull("Message from Lifeline1 to Gate(outer gate) of CombinedFragment should be created", message1EditPart);
		//The outer gate should be created automatically.
		GateEditPart message1EndGate = getPrimaryGateEditPart(cf);
		assertNotNull("new Gate should be created", message1EndGate);
		//The inner Gate should be created automatically.
		GateEditPart message1EndGateInner = getInnerGateEditPart(message1EndGate);
		assertNotNull("a inner Gate should be created", message1EndGateInner);
		//2. Message from inner Gate of CombinedFragment to Lifeline2.
		startLocation = getAbsoluteBounds(message1EndGateInner).getCenter();
		endLocation = getAbsoluteBounds(lifeline2).getCenter().setY(startLocation.y);
		Message2EditPart message2EditPart = (Message2EditPart)createLink(UMLElementTypes.Message_4004, lifeline1.getViewer(), startLocation, endLocation);
		assertNotNull("Message from inner Gate of CombinedFragment to Lifeline2 should be created", message2EditPart);
		//Check names with the outer gate, inner gate , message1 and message2.
		Message message1 = (Message)message1EditPart.resolveSemanticElement();
		Message message2 = (Message)message2EditPart.resolveSemanticElement();
		String name = "m1";
		changeName(getEditingDomain(), message1, name);
		//		assertEquals("Suggestion name of message2", name, message2.getName());
		//		assertEquals("Suggestion name of outer gate", "in_m1", getGateName(message1EndGate));
		//		assertEquals("Suggestion name of inner gate", "in_m1", getGateName(message1EndGateInner));
		//3. Message from CombinedFragment to Lifeline3.
		LifelineEditPart lifeline3 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(700, 100), new Dimension(100, 400));
		assertNotNull(lifeline3);
		waitForComplete();
		startLocation = new Point(getAbsoluteBounds(cf).right() - 2, getAbsoluteBounds(cf).getCenter().y);
		endLocation = startLocation.getCopy().setX(getAbsoluteBounds(lifeline3).getCenter().x);
		Message2EditPart message3EditPart = (Message2EditPart)createLink(UMLElementTypes.Message_4004, lifeline1.getViewer(), startLocation, cf, endLocation, lifeline3);
		assertNotNull("Message from CombinedFragment to Lifeline3 should be created", message3EditPart);
		GateEditPart message3StartGate = getPrimaryGateEditPart(cf);
		assertNotNull("New Gate created", message3StartGate);
		Message message3 = (Message)message3EditPart.resolveSemanticElement();
		//		assertEquals("Suggestion name of new gate", "out_" + message3.getName(), getGateName(message3StartGate));
		//4. Message from Lifeline2 to message3StartGateInner
		GateEditPart message3StartGateInner = getInnerGateEditPart(message3StartGate);
		assertNotNull("a inner Gate should be created", message3StartGateInner);
		endLocation = getAbsoluteBounds(message3StartGateInner).getCenter();
		startLocation = new Point(getAbsoluteBounds(lifeline2).getCenter().x, endLocation.y);
		Message2EditPart message4EditPart = (Message2EditPart)createLink(UMLElementTypes.Message_4004, lifeline1.getViewer(), startLocation, endLocation);
		assertNotNull("Message from Lifeline2 to message3StartGateInner", message4EditPart);
		Message message4 = (Message)message4EditPart.resolveSemanticElement();
		assertEquals("Suggestion name of message4", message3.getName(), message4.getName());
	}

	/**
	 * Gates should be created automatically.
	 * 1. message1: Interaction --> Lifeline
	 * 2. message2: Lifeline --> Interaction
	 */
	@Test
	public void testGateCreateWithMessageAsyncOnInteraction() {
		InteractionEditPart interaction = (InteractionEditPart)getRootEditPart().getParent();
		LifelineEditPart lifeline = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), null);
		Rectangle lifelineBounds = getAbsoluteBounds(lifeline);
		//1. message1
		Point endLocation = lifelineBounds.getCenter();
		Point startLocation = new Point(0, endLocation.y);
		Message2EditPart message1ep = (Message2EditPart)createLink(UMLElementTypes.Message_4004, interaction.getViewer(), startLocation, interaction, endLocation, lifeline);
		assertNotNull("message1: Interaction --> Lifeline", message1ep);
		Message message1 = (Message)message1ep.resolveSemanticElement();
		Gate gate1 = (Gate)message1.getSendEvent();
		GateEditPart gate1EditPart = getGateEditPart(interaction, gate1);
		assertNotNull("Gate created", gate1EditPart);
		//		assertEquals("Gate name", "in_" + message1.getName(), getGateName(gate1EditPart));
		//2. message2
		startLocation = endLocation.getTranslated(0, 50);
		endLocation = new Point(0, startLocation.y);
		Message2EditPart message2ep = (Message2EditPart)createLink(UMLElementTypes.Message_4004, interaction.getViewer(), startLocation, lifeline, endLocation, interaction);
		assertNotNull("message2: Lifeline --> Interaction", message2ep);
		Message message2 = (Message)message2ep.resolveSemanticElement();
		Gate gate2 = (Gate)message2.getReceiveEvent();
		GateEditPart gate2EditPart = getGateEditPart(interaction, gate2);
		assertNotNull("Gate created", gate2EditPart);
		//the name of gate on Interaction will not be changed.
		assertEquals("Gate name", gate2.getName(), getGateName(gate2EditPart));
	}

	/**
	 * 1. message1: Lifeline1 --> InteractionUse
	 * 2. message2: InteractionUse --> Lifeline2
	 */
	@Test
	public void testGateCreateWithMessageAsyncOnInteractionUse() {
		LifelineEditPart lifeline1 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(100, 400));
		LifelineEditPart lifeline2 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(600, 100), new Dimension(100, 400));
		InteractionUseEditPart interactionUse = (InteractionUseEditPart)createNode(UMLElementTypes.InteractionUse_3002, getRootEditPart(), new Point(300, 200), new Dimension(200, 100));
		InteractionEditPart iep = (InteractionEditPart)getRootEditPart().getParent();
		//set refersTo value.
		updateValue(getEditingDomain(), interactionUse.resolveSemanticElement(), UMLPackage.Literals.INTERACTION_USE__REFERS_TO, iep.resolveSemanticElement());
		//1. message1
		Point endLocation = getAbsoluteBounds(lifeline1).getCenter();
		Point startLocation = new Point(getAbsoluteBounds(interactionUse).x, endLocation.y);
		Message2EditPart message1ep = (Message2EditPart)createLink(UMLElementTypes.Message_4004, lifeline1.getViewer(), startLocation, lifeline1, endLocation, interactionUse);
		assertNotNull("message1: Lifeline1 --> InteractionUse", message1ep);
		Message message1 = (Message)message1ep.resolveSemanticElement();
		Gate gate1 = (Gate)message1.getReceiveEvent();
		GateEditPart gate1EditPart = getGateEditPart(interactionUse, gate1);
		assertNotNull("Gate created", gate1EditPart);
		assertEquals("Gate name", "in_" + message1.getName(), getGateName(gate1EditPart));
		//2. message2
		endLocation = getAbsoluteBounds(lifeline2).getCenter();
		startLocation = new Point(getAbsoluteBounds(interactionUse).right(), endLocation.y);
		Message2EditPart message2ep = (Message2EditPart)createLink(UMLElementTypes.Message_4004, interactionUse.getViewer(), startLocation, interactionUse, endLocation, lifeline2);
		assertNotNull("message2: InteractionUse --> Lifeline2", message2ep);
		Message message2 = (Message)message2ep.resolveSemanticElement();
		Gate gate2 = (Gate)message2.getSendEvent();
		GateEditPart gate2EditPart = getGateEditPart(interactionUse, gate2);
		assertNotNull("Gate created", gate2EditPart);
		//		assertEquals("Gate name", "out_" + message2.getName(), getGateName(gate2EditPart));
	}

	@Test
	public void testGateCreateWithMessageReplyOnGate() {
		GateEditPart gateEditPart = createGateWithParent(UMLElementTypes.CombinedFragment_3004, new Point(20, 100), new Dimension(100, 200), false);
		AbstractExecutionSpecificationEditPart es = createExecutionSpecificationWithLifeline(new Point(300, 100), null);
		//Message reply
		Point startLocation = getAbsoluteBounds(es).getCenter();
		Point endLocation = getAbsoluteBounds(gateEditPart).getCenter().setY(startLocation.y);
		AbstractMessageEditPart messageReply = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4005, gateEditPart.getViewer(), startLocation, es, endLocation, gateEditPart);
		assertNotNull("Message Reply", messageReply);
	}

	/**
	 * check source when ends == 1;
	 * check target when ends == 2;
	 * check both when ends == others.
	 */
	private void checkGateCreatedWithMessage(EditPart parent, AbstractMessageEditPart messageEditPart, int ends) {
		assertNotNull(parent);
		assertNotNull(messageEditPart);
		EditPart source = messageEditPart.getSource();
		EditPart target = messageEditPart.getTarget();
		if(ends == 1) {
			assertTrue("message start with gate", source instanceof GateEditPart);
			assertTrue("auto added gate", parent == source.getParent());
		} else if(ends == 2) {
			assertTrue("message end with gate", target instanceof GateEditPart);
			assertTrue("auto added gate", parent == target.getParent());
		} else {
			assertTrue("message start with gate", source instanceof GateEditPart);
			assertTrue("auto added gate", parent == source.getParent());
			assertTrue("message end with gate", target instanceof GateEditPart);
			assertTrue("auto added gate", parent == target.getParent());
		}
	}

	@Test
	public void testGateCreateWithMessageReplyOnCombinedFragment() {
		CombinedFragmentEditPart combinedFragment = (CombinedFragmentEditPart)createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), new Point(50, 100), new Dimension(100, 200));
		AbstractExecutionSpecificationEditPart es = createExecutionSpecificationWithLifeline(new Point(400, 50), null);
		//Message reply
		Point startLocation = getAbsoluteBounds(es).getCenter();
		Point endLocation = new Point(getAbsoluteBounds(combinedFragment).right() - 1, startLocation.y);
		AbstractMessageEditPart messageReply = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4005, combinedFragment.getViewer(), startLocation, es, endLocation, combinedFragment);
		assertNotNull("Message Reply", messageReply);
		checkGateCreatedWithMessage(combinedFragment, messageReply, 2);
	}

	@Test
	public void testGateCreateWithMessageReplyOnInteraction() {
		InteractionEditPart iep = (InteractionEditPart)getRootEditPart().getParent();
		AbstractExecutionSpecificationEditPart es = createExecutionSpecificationWithLifeline(new Point(100, 50), null);
		//Message reply
		Point startLocation = getAbsoluteBounds(es).getCenter();
		Point endLocation = new Point(0, startLocation.y);
		AbstractMessageEditPart messageReply = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4005, iep.getViewer(), startLocation, es, endLocation, iep);
		assertNotNull("Message Reply", messageReply);
		checkGateCreatedWithMessage(iep, messageReply, 2);
	}

	@Test
	public void testGateCreateWithMessageReplyOnInteractionUse() {
		AbstractExecutionSpecificationEditPart es = createExecutionSpecificationWithLifeline(new Point(300, 100), new Dimension(100, 400));
		InteractionUseEditPart interactionUse = (InteractionUseEditPart)createNode(UMLElementTypes.InteractionUse_3002, getRootEditPart(), new Point(100, 220), new Dimension(100, 100));
		InteractionEditPart iep = (InteractionEditPart)getRootEditPart().getParent();
		//set refersTo value.
		updateValue(getEditingDomain(), interactionUse.resolveSemanticElement(), UMLPackage.Literals.INTERACTION_USE__REFERS_TO, iep.resolveSemanticElement());
		//Message reply
		Point endLocation = getAbsoluteBounds(es).getCenter();
		Point startLocation = new Point(getAbsoluteBounds(interactionUse).x, endLocation.y);
		AbstractMessageEditPart messageReply = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4005, es.getViewer(), startLocation, es, endLocation, interactionUse);
		assertNotNull("Message Reply", messageReply);
		checkGateCreatedWithMessage(interactionUse, messageReply, 2);
	}

	private void testGateCreateWithMessageFound(IElementType targetType, Point targetLocation, Dimension targetSize) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)createGateParent(targetType, targetLocation, targetSize);
		Point endLocation = null;
		if(UMLElementTypes.Interaction_2001 == targetType) {
			endLocation = getAbsoluteBounds(targetEditPart).getRight().getTranslated(-1, 0);
		} else {
			endLocation = getAbsoluteBounds(targetEditPart).getLeft().getTranslated(1, 0);
		}
		Point startLocation = endLocation.getTranslated(-100, -1);
		AbstractMessageEditPart messageFound = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4009, targetEditPart.getViewer(), startLocation, getRootEditPart().getParent(), endLocation, targetEditPart);
		assertNotNull("Message Found", messageFound);
		checkGateCreatedWithMessage(targetEditPart, messageFound, 2);
	}

	@Test
	public void testGateCreateWithMessageFoundOnGate() {
		GateEditPart gate = createGateWithParent(UMLElementTypes.CombinedFragment_3004, new Point(150, 100), new Dimension(200, 100), true);
		Point endLocation = getAbsoluteBounds(gate).getCenter();
		Point startLocation = endLocation.getTranslated(-80, 0);
		EditPart messageFound = createLink(UMLElementTypes.Message_4009, gate.getViewer(), startLocation, endLocation);
		assertNotNull("Message Found", messageFound);
	}

	@Test
	public void testGateCreateWithMessageFoundOnCombinedFragment() {
		testGateCreateWithMessageFound(UMLElementTypes.CombinedFragment_3004, new Point(300, 100), new Dimension(200, 100));
	}

	@Test
	public void testGateCreateWithMessageFoundOnInteraction() {
		testGateCreateWithMessageFound(UMLElementTypes.Interaction_2001, null, null);
	}

	@Test
	public void testGateCreateWithMessageFoundOnInteractionUse() {
		testGateCreateWithMessageFound(UMLElementTypes.InteractionUse_3002, new Point(300, 100), new Dimension(200, 100));
	}

	@Test
	public void testGateCreateWithMessageLostOnGate() {
		GateEditPart gateEditPart = createGateWithParent(UMLElementTypes.CombinedFragment_3004, new Point(100, 100), new Dimension(200, 100), false);
		Point startLocation = getAbsoluteBounds(gateEditPart).getCenter();
		Point endLocation = startLocation.getTranslated(100, 0);
		EditPart messageLost = createLink(UMLElementTypes.Message_4008, gateEditPart.getViewer(), startLocation, endLocation);
		assertNotNull("Message Lost", messageLost);
	}

	private void testGateCreateWithMessageLost(IElementType targetType, Point targetLocation, Dimension targetSize) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart)createGateParent(targetType, targetLocation, targetSize);
		Point startLocation = null;
		if(UMLElementTypes.Interaction_2001 == targetType) {
			startLocation = getAbsoluteBounds(targetEditPart).getLeft().getTranslated(1, 0);
		} else {
			startLocation = getAbsoluteBounds(targetEditPart).getRight().getTranslated(-1, 0);
		}
		Point endLocation = startLocation.getTranslated(100, 1);
		AbstractMessageEditPart messageFound = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4008, targetEditPart.getViewer(), startLocation, targetEditPart, endLocation, getRootEditPart().getParent());
		assertNotNull("Message Lost", messageFound);
		checkGateCreatedWithMessage(targetEditPart, messageFound, 1);
	}

	@Test
	public void testGateCreateWithMessageLostOnCombinedFragment() {
		testGateCreateWithMessageLost(UMLElementTypes.CombinedFragment_3004, new Point(100, 100), new Dimension(200, 100));
	}

	@Test
	public void testGateCreateWithMessageLostOnInteraction() {
		testGateCreateWithMessageLost(UMLElementTypes.Interaction_2001, null, null);
	}

	@Test
	public void testGateCreateWithMessageLostOnInteractionUse() {
		testGateCreateWithMessageLost(UMLElementTypes.InteractionUse_3002, new Point(100, 100), new Dimension(200, 100));
	}

	@Test
	public void testReconnectMessageAsyncTargetToGate() {
		LifelineEditPart lifeline = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), null);
		CombinedFragmentEditPart combinedFragment = (CombinedFragmentEditPart)createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), new Point(300, 80), new Dimension(100, 200));
		Rectangle rect = getAbsoluteBounds(combinedFragment);
		GateEditPart gate1 = createGate(combinedFragment, rect.getLeft().getTranslated(0, -20));
		//gate2 and gate 1 are located on same CombinedFrament
		GateEditPart gate2 = createGate(combinedFragment, rect.getLeft().getTranslated(0, 20));
		//gate3 is located on different CombinedFragment.
		GateEditPart gate3 = createGateWithParent(UMLElementTypes.CombinedFragment_3004, new Point(300, 300), new Dimension(100, 100), true);
		AbstractMessageEditPart messageAsync = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, lifeline.getViewer(), getAbsoluteCenter(lifeline), getAbsoluteCenter(gate1));
		assertNotNull("Message Async", messageAsync);
		checkGraphicalElements(messageAsync, gate1, false);
		checkSemanticElements(messageAsync, gate1, false);
		reconnectTarget(messageAsync, gate2, getAbsoluteCenter(gate2));
		checkGraphicalElements(messageAsync, gate2, false);
		checkSemanticElements(messageAsync, gate2, false);
		reconnectTarget(messageAsync, gate3, getAbsoluteCenter(gate3));
		checkGraphicalElements(messageAsync, gate3, false);
		checkSemanticElements(messageAsync, gate3, false);
	}

	@Test
	public void testReconnectMessageAsyncSourceToGate() {
		LifelineEditPart lifeline = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(300, 100), null);
		CombinedFragmentEditPart combinedFragment = (CombinedFragmentEditPart)createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), new Point(100, 80), new Dimension(100, 100));
		Rectangle rect = getAbsoluteBounds(combinedFragment);
		GateEditPart gate1 = createGate(combinedFragment, rect.getRight().getTranslated(0, -20));
		GateEditPart gate2 = createGate(combinedFragment, rect.getRight().getTranslated(0, 20));
		GateEditPart gate3 = createGateWithParent(UMLElementTypes.CombinedFragment_3004, new Point(100, 380), new Dimension(100, 100), false);
		AbstractMessageEditPart messageAsync = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, lifeline.getViewer(), getAbsoluteCenter(gate1), getAbsoluteCenter(lifeline));
		assertNotNull("Message Async", messageAsync);
		checkGraphicalElements(messageAsync, gate1, true);
		checkSemanticElements(messageAsync, gate1, true);
		reconnectSource(messageAsync, gate2, getAbsoluteCenter(gate2));
		checkGraphicalElements(messageAsync, gate2, true);
		checkSemanticElements(messageAsync, gate2, true);
		reconnectSource(messageAsync, gate3, getAbsoluteCenter(gate3));
		checkGraphicalElements(messageAsync, gate3, true);
		checkSemanticElements(messageAsync, gate3, true);
	}

	private void checkGraphicalElements(AbstractMessageEditPart messageEditPart, GateEditPart gateEditPart, boolean source) {
		assertNotNull(messageEditPart);
		assertNotNull(gateEditPart);
		if(source) {
			assertEquals("message source editPart", gateEditPart, messageEditPart.getSource());
		} else {
			assertEquals("message target editPart", gateEditPart, messageEditPart.getTarget());
		}
	}

	private void checkSemanticElements(AbstractMessageEditPart messageEditPart, GateEditPart gateEditPart, boolean source) {
		assertNotNull(messageEditPart);
		assertNotNull(gateEditPart);
		Message message = (Message)messageEditPart.resolveSemanticElement();
		assertNotNull(message);
		Gate gate = (Gate)gateEditPart.resolveSemanticElement();
		assertNotNull(gate);
		if(source) {
			assertEquals("message source", gate, message.getSendEvent());
		} else {
			assertEquals("message target", gate, message.getReceiveEvent());
		}
	}

	/**
	 * 1. When moved a message start with gate on the container CombinedFragment, just move the gate to the new location.
	 * 2. Otherwise, create a new gate.
	 */
	@Test
	public void testReconnectMessageAsyncSourceToCombinedFragment() {
		GateEditPart gate1 = createGateWithParent(UMLElementTypes.CombinedFragment_3004, new Point(100, 100), new Dimension(100, 100), false);
		CombinedFragmentEditPart cf1 = (CombinedFragmentEditPart)gate1.getParent();
		CombinedFragmentEditPart cf2 = (CombinedFragmentEditPart)createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), new Point(100, 220), new Dimension(100, 80));
		LifelineEditPart lifeline = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(300, 100), new Dimension(100, 500));
		AbstractMessageEditPart messageAsync = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, lifeline.getViewer(), getAbsoluteCenter(gate1), getAbsoluteCenter(lifeline));
		checkSemanticElements(messageAsync, gate1, true);
		//1. moved on same combinedFragment.
		reconnectSource(messageAsync, cf1, getAbsoluteCenter(gate1).getTranslated(0, 30));
		checkGraphicalElements(messageAsync, gate1, true);
		checkSemanticElements(messageAsync, gate1, true);
		//2. moved to new combinedFragment.
		GateEditPart gate2 = getPrimaryGateEditPart(cf2);
		assertNull("no gate before", gate2);
		reconnectSource(messageAsync, cf2, getAbsoluteBounds(cf2).getRight().getTranslated(-1, 0));
		gate2 = getPrimaryGateEditPart(cf2);
		assertNotNull("gate created", gate2);
		checkGraphicalElements(messageAsync, gate2, true);
		checkSemanticElements(messageAsync, gate2, true);
	}

	@Test
	public void testReconnectMessageAsyncTargetToCombinedFragment() {
		LifelineEditPart lifeline = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(100, 500));
		GateEditPart gate1 = createGateWithParent(UMLElementTypes.CombinedFragment_3004, new Point(300, 100), new Dimension(100, 100), true);
		CombinedFragmentEditPart cf1 = (CombinedFragmentEditPart)gate1.getParent();
		CombinedFragmentEditPart cf2 = (CombinedFragmentEditPart)createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), new Point(300, 220), new Dimension(100, 80));
		AbstractMessageEditPart messageAsync = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, lifeline.getViewer(), getAbsoluteCenter(lifeline), getAbsoluteCenter(gate1));
		checkSemanticElements(messageAsync, gate1, false);
		//1. moved on same combinedFragment.
		reconnectTarget(messageAsync, cf1, getAbsoluteCenter(gate1).getTranslated(0, 30));
		checkGraphicalElements(messageAsync, gate1, false);
		checkSemanticElements(messageAsync, gate1, false);
		//2. moved to new combinedFragment.
		GateEditPart gate2 = getPrimaryGateEditPart(cf2);
		assertNull("no gate before", gate2);
		reconnectTarget(messageAsync, cf2, getAbsoluteBounds(cf2).getLeft().getTranslated(1, 0));
		gate2 = getPrimaryGateEditPart(cf2);
		assertNotNull("gate created", gate2);
		checkGraphicalElements(messageAsync, gate2, false);
		checkSemanticElements(messageAsync, gate2, false);
	}

	@Test
	public void testReconnectMessageAsyncSourceToInteraction() {
		EditPart iep = getRootEditPart().getParent();
		GateEditPart gate = createGate(iep, new Point(0, 100));
		LifelineEditPart lifeline = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), null);
		Point startLocation = getAbsoluteCenter(gate);
		Point endLocation = getAbsoluteCenter(lifeline).setY(startLocation.y + 1);
		AbstractMessageEditPart messageAsync = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, iep.getViewer(), startLocation, gate, endLocation, lifeline);
		checkGraphicalElements(messageAsync, gate, true);
		checkSemanticElements(messageAsync, gate, true);
		reconnectSource(messageAsync, iep, startLocation.getTranslated(0, 50));
		checkGraphicalElements(messageAsync, gate, true);
		checkSemanticElements(messageAsync, gate, true);
	}

	@Test
	public void testReconnectMessageAsyncTargetToInteraction() {
		EditPart iep = getRootEditPart().getParent();
		GateEditPart gate = createGate(iep, new Point(0, 100));
		LifelineEditPart lifeline = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), null);
		Point endLocation = getAbsoluteCenter(gate);
		Point startLocation = getAbsoluteCenter(lifeline).setY(endLocation.y);
		AbstractMessageEditPart messageAsync = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, iep.getViewer(), startLocation, lifeline, endLocation, gate);
		checkGraphicalElements(messageAsync, gate, false);
		checkSemanticElements(messageAsync, gate, false);
		reconnectTarget(messageAsync, iep, startLocation.getTranslated(0, 50));
		checkGraphicalElements(messageAsync, gate, false);
		checkSemanticElements(messageAsync, gate, false);
	}

	@Test
	public void testReconnectMessageAsyncSourceToInteractionUse() {
		InteractionEditPart iep = (InteractionEditPart)getRootEditPart().getParent();
		LifelineEditPart lifeline = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(300, 100), new Dimension(100, 300));
		InteractionUseEditPart iuep1 = (InteractionUseEditPart)createNode(UMLElementTypes.InteractionUse_3002, getRootEditPart(), new Point(100, 150), new Dimension(100, 100));
		updateValue(getEditingDomain(), ((IGraphicalEditPart)iuep1).resolveSemanticElement(), UMLPackage.Literals.INTERACTION_USE__REFERS_TO, iep.resolveSemanticElement());
		InteractionUseEditPart iuep2 = (InteractionUseEditPart)createNode(UMLElementTypes.InteractionUse_3002, getRootEditPart(), new Point(100, 280), new Dimension(100, 100));
		updateValue(getEditingDomain(), ((IGraphicalEditPart)iuep2).resolveSemanticElement(), UMLPackage.Literals.INTERACTION_USE__REFERS_TO, iep.resolveSemanticElement());
		//messageAsync = iuep1 --> lifeline
		GateEditPart gate1 = getPrimaryGateEditPart(iuep1);
		assertNull(gate1);
		Point startLocation = getAbsoluteBounds(iuep1).getRight().getTranslated(-1, 0);
		Point endLocation = getAbsoluteCenter(lifeline).setY(startLocation.y + 1);
		AbstractMessageEditPart messageAsync = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, lifeline.getViewer(), startLocation, iuep1, endLocation, lifeline);
		gate1 = getPrimaryGateEditPart(iuep1);
		assertNotNull("gate1 should be created", gate1);
		checkGraphicalElements(messageAsync, gate1, true);
		checkSemanticElements(messageAsync, gate1, true);
		//reconnect to: iuep2 --> lifeline
		GateEditPart gate2 = getPrimaryGateEditPart(iuep2);
		assertNull(gate2);
		reconnectSource(messageAsync, iuep2, getAbsoluteBounds(iuep2).getRight().getTranslated(-1, 0));
		gate2 = getPrimaryGateEditPart(iuep2);
		assertNotNull("gate2 should be created", gate2);
		checkGraphicalElements(messageAsync, gate2, true);
		checkSemanticElements(messageAsync, gate2, true);
	}

	@Test
	public void testReconnectMessageAsyncTargetToInteractionUse() {
		InteractionEditPart iep = (InteractionEditPart)getRootEditPart().getParent();
		LifelineEditPart lifeline = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(100, 300));
		InteractionUseEditPart iuep1 = (InteractionUseEditPart)createNode(UMLElementTypes.InteractionUse_3002, getRootEditPart(), new Point(300, 150), new Dimension(100, 100));
		updateValue(getEditingDomain(), ((IGraphicalEditPart)iuep1).resolveSemanticElement(), UMLPackage.Literals.INTERACTION_USE__REFERS_TO, iep.resolveSemanticElement());
		InteractionUseEditPart iuep2 = (InteractionUseEditPart)createNode(UMLElementTypes.InteractionUse_3002, getRootEditPart(), new Point(300, 280), new Dimension(100, 100));
		updateValue(getEditingDomain(), ((IGraphicalEditPart)iuep2).resolveSemanticElement(), UMLPackage.Literals.INTERACTION_USE__REFERS_TO, iep.resolveSemanticElement());
		//messageAsync = lifeline --> iuep1
		GateEditPart gate1 = getPrimaryGateEditPart(iuep1);
		assertNull(gate1);
		AbstractMessageEditPart messageAsync = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, lifeline.getViewer(), getAbsoluteCenter(lifeline), lifeline, getAbsoluteBounds(iuep1).getLeft().getTranslated(1, 0), iuep1);
		gate1 = getPrimaryGateEditPart(iuep1);
		assertNotNull("gate1 should be created", gate1);
		checkGraphicalElements(messageAsync, gate1, false);
		checkSemanticElements(messageAsync, gate1, false);
		//reconnect to: lifeline --> iuep2
		GateEditPart gate2 = getPrimaryGateEditPart(iuep2);
		assertNull(gate2);
		reconnectTarget(messageAsync, iuep2, getAbsoluteBounds(iuep2).getLeft().getTranslated(1, 0));
		gate2 = getPrimaryGateEditPart(iuep2);
		assertNotNull("gate2 should be created", gate2);
		checkGraphicalElements(messageAsync, gate2, false);
		checkSemanticElements(messageAsync, gate2, false);
	}

	@Test
	public void testReconnectMessageReplyToCombinedFragment() {
		AbstractExecutionSpecificationEditPart es = createExecutionSpecificationWithLifeline(new Point(100, 100), new Dimension(100, 500));
		CombinedFragmentEditPart cf1 = (CombinedFragmentEditPart)createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), new Point(300, 200), new Dimension(200, 200));
		//messageReply: es --> cf1
		GateEditPart gate1 = getPrimaryGateEditPart(cf1);
		assertNull(gate1);
		AbstractMessageEditPart messageReply = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4005, es.getViewer(), getAbsoluteCenter(es), es, getAbsoluteBounds(cf1).getLeft().getTranslated(1, 0), cf1);
		gate1 = getPrimaryGateEditPart(cf1);
		assertNotNull("gate1 should be created", gate1);
		checkGraphicalElements(messageReply, gate1, false);
		checkSemanticElements(messageReply, gate1, false);
		//reconnect: es --> cf2
		CombinedFragmentEditPart cf2 = (CombinedFragmentEditPart)createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), new Point(300, 420), new Dimension(200, 200));
		GateEditPart gate2 = getPrimaryGateEditPart(cf2);
		assertNull(gate2);
		reconnectTarget(messageReply, cf2, getAbsoluteBounds(cf2).getLeft().getTranslated(1, 0));
		gate2 = getPrimaryGateEditPart(cf2);
		assertNotNull("gate2 should be created", gate2);
		checkGraphicalElements(messageReply, gate2, false);
		checkSemanticElements(messageReply, gate2, false);
	}

	@Test
	public void testReconnectMessageReplyToInteraction() {
		AbstractExecutionSpecificationEditPart es = createExecutionSpecificationWithLifeline(new Point(200, 100), null);
		InteractionEditPart iep = (InteractionEditPart)getRootEditPart().getParent();
		Point startLocation = getAbsoluteCenter(es);
		Point endLocation = getAbsoluteBounds(iep).getLocation().setY(startLocation.y);
		GateEditPart gate = getPrimaryGateEditPart(iep);
		assertNull(gate);
		AbstractMessageEditPart messageReply = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4005, es.getViewer(), startLocation, es, endLocation, iep);
		gate = getPrimaryGateEditPart(iep);
		assertNotNull("gate should be created", gate);
		checkGraphicalElements(messageReply, gate, false);
		checkSemanticElements(messageReply, gate, false);
		//reconnect
		endLocation = endLocation.getTranslated(0, 80);
		reconnectTarget(messageReply, iep, endLocation);
		checkGraphicalElements(messageReply, gate, false);
		checkSemanticElements(messageReply, gate, false);
	}

	@Test
	public void testReconnectMessageReplyToInteractionUse() {
		InteractionEditPart iep = (InteractionEditPart)getRootEditPart().getParent();
		AbstractExecutionSpecificationEditPart es = createExecutionSpecificationWithLifeline(new Point(100, 100), new Dimension(100, 300));
		InteractionUseEditPart iuep1 = (InteractionUseEditPart)createNode(UMLElementTypes.InteractionUse_3002, getRootEditPart(), new Point(300, 150), new Dimension(100, 100));
		updateValue(getEditingDomain(), ((IGraphicalEditPart)iuep1).resolveSemanticElement(), UMLPackage.Literals.INTERACTION_USE__REFERS_TO, iep.resolveSemanticElement());
		InteractionUseEditPart iuep2 = (InteractionUseEditPart)createNode(UMLElementTypes.InteractionUse_3002, getRootEditPart(), new Point(300, 280), new Dimension(100, 100));
		updateValue(getEditingDomain(), ((IGraphicalEditPart)iuep2).resolveSemanticElement(), UMLPackage.Literals.INTERACTION_USE__REFERS_TO, iep.resolveSemanticElement());
		//messageReply: es --> iuep1
		GateEditPart gate1 = getPrimaryGateEditPart(iuep1);
		assertNull(gate1);
		AbstractMessageEditPart messageReply = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4005, es.getViewer(), getAbsoluteCenter(es), es, getAbsoluteBounds(iuep1).getLeft().getTranslated(1, 0), iuep1);
		gate1 = getPrimaryGateEditPart(iuep1);
		assertNotNull("gate1 should be created", gate1);
		checkGraphicalElements(messageReply, gate1, false);
		checkSemanticElements(messageReply, gate1, false);
		//reconnect to: es --> iuep2
		GateEditPart gate2 = getPrimaryGateEditPart(iuep2);
		assertNull(gate2);
		reconnectTarget(messageReply, iuep2, getAbsoluteBounds(iuep2).getLeft().getTranslated(1, 0));
		gate2 = getPrimaryGateEditPart(iuep2);
		assertNotNull("gate2 should be created", gate2);
		checkGraphicalElements(messageReply, gate2, false);
		checkSemanticElements(messageReply, gate2, false);
	}

	@Test
	public void testReconnectMessageFoundToCombinedFragment() {
		//MessageFound not support reconnect.
	}

	@Test
	public void testReconnectMessageFoundToInteraction() {
		//MessageFound not support reconnect.
	}

	@Test
	public void testReconnectMessageFoundToInteractionUse() {
		//MessageFound not support reconnect.
	}

	@Test
	public void testReconnectMessageLostToCombinedFragment() {
		//MessageLost not support reconnect.
	}

	@Test
	public void testReconnectMessageLostToInteraction() {
		//MessageLost not support reconnect.
	}

	@Test
	public void testReconnectMessageLostToInteractionUse() {
		//MessageLost not support reconnect.
	}
}
