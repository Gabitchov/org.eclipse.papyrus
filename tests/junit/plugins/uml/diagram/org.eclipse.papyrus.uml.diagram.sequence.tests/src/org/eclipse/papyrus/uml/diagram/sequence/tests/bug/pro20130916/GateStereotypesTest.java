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

import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GateEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.util.GateHelper;
import org.eclipse.uml2.uml.Gate;
import org.junit.Test;


/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class GateStereotypesTest extends BaseStereotypesTest {

	private GateEditPart gate;

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7.AbstractNodeTest#setUp()
	 * 
	 * @throws Exception
	 */

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		gate = createGate(getRootEditPart().getParent(), new Point(0, 100));
		assertNotNull(gate);
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

	@Test
	public void testDisplayStereotypeComment() {
		doTestDisplayStereotypeComment(gate);
	}

	@Test
	public void testDisplayStereotypeInCompartment() {
		doTestDisplayStereotypeInCompartment(gate, gate.getLabelEditPart());
	}

	@Test
	public void testDisplayStereotypeWithBrace() {
		doTestDisplayStereotypeWithBrace(gate, gate.getLabelEditPart());
	}

}
