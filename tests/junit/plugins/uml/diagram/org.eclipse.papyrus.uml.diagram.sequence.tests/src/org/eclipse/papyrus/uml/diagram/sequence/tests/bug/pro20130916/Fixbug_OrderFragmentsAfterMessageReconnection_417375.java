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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7.AbstractNodeTest;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.ActionExecutionSpecification;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.junit.Test;


/**
 * Fixed bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=417375
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class Fixbug_OrderFragmentsAfterMessageReconnection_417375 extends AbstractNodeTest {

	@Test
	public void test() {
		EditPart lifeline1 = createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(100, 500));
		EditPart lifeline2 = createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(300, 100), new Dimension(100, 500));

		final Interaction interaction = (Interaction)getRootEditPart().resolveSemanticElement();

		ActionExecutionSpecificationEditPart execution1 = (ActionExecutionSpecificationEditPart)createNode(UMLElementTypes.ActionExecutionSpecification_3006, lifeline1, new Point(131, 200), new Dimension(16, 150));
		ActionExecutionSpecification actionES = (ActionExecutionSpecification)execution1.resolveSemanticElement();
		waitForComplete();
		//validate after create action
		List<InteractionFragment> actualList = new ArrayList<InteractionFragment>();
		actualList.add(actionES.getStart());
		actualList.add(actionES);
		actualList.add(actionES.getFinish());
		validateOrders(interaction.getFragments(), actualList);

		BehaviorExecutionSpecificationEditPart execution2 = (BehaviorExecutionSpecificationEditPart)createNode(UMLElementTypes.BehaviorExecutionSpecification_3003, lifeline1, new Point(148, 230), new Dimension(16, 80));
		BehaviorExecutionSpecification behaviorES = (BehaviorExecutionSpecification)execution2.resolveSemanticElement();
		waitForComplete();
		//validate after create behavior
		actualList = new ArrayList<InteractionFragment>();
		actualList.add(actionES.getStart());
		actualList.add(actionES);
		actualList.add(behaviorES.getStart());
		actualList.add(behaviorES);
		actualList.add(behaviorES.getFinish());
		actualList.add(actionES.getFinish());
		validateOrders(interaction.getFragments(), actualList);

		Point endLocation = SequenceUtil.getAbsoluteBounds(execution2).getCenter().getCopy().getTranslated(0, 20);
		Point startLocation = SequenceUtil.getAbsoluteBounds((IGraphicalEditPart)lifeline2).getCenter().setY(endLocation.y - 1);
		AbstractMessageEditPart messageEditPart = (AbstractMessageEditPart)createLink(UMLElementTypes.Message_4004, lifeline1.getViewer(), startLocation, lifeline2, endLocation, execution2);
		Message message = (Message)messageEditPart.resolveSemanticElement();
		waitForComplete();
		//validate after create message
		actualList = new ArrayList<InteractionFragment>();
		actualList.add(actionES.getStart());
		actualList.add(actionES);
		actualList.add(behaviorES.getStart());
		actualList.add(behaviorES);
		actualList.add((InteractionFragment)message.getSendEvent());
		actualList.add((InteractionFragment)message.getReceiveEvent());
		actualList.add(behaviorES.getFinish());
		actualList.add(actionES.getFinish());
		validateOrders(interaction.getFragments(), actualList);

		//reconnect message target to the end of the behavior execution.
		OccurrenceSpecification finish = behaviorES.getFinish();
		IGraphicalEditPart finishEditPart = null;
		List children = execution2.getChildren();
		for(Object object : children) {
			if(object instanceof IGraphicalEditPart) {
				EObject element = ((IGraphicalEditPart)object).resolveSemanticElement();
				if(finish == element) {
					finishEditPart = (IGraphicalEditPart)object;
					break;
				}
			}
		}
		assertNotNull("finishEditPart", finishEditPart);
		reconnectTarget(messageEditPart, finishEditPart, SequenceUtil.getAbsoluteBounds(finishEditPart).getCenter());
		//validate
		actualList = new ArrayList<InteractionFragment>();
		actualList.add(actionES.getStart());
		actualList.add(actionES);
		actualList.add(behaviorES.getStart());
		actualList.add(behaviorES);
		actualList.add((InteractionFragment)message.getSendEvent());
		actualList.add((InteractionFragment)message.getReceiveEvent());
		actualList.add(actionES.getFinish());
		validateOrders(interaction.getFragments(), actualList);

		//reconnect back
		reconnectTarget(messageEditPart, execution2, SequenceUtil.getAbsoluteBounds(execution2).getCenter().setY(SequenceUtil.getAbsoluteEdgeExtremity(messageEditPart, true).y - 1));
		//validate
		actualList = new ArrayList<InteractionFragment>();
		actualList.add(actionES.getStart());
		actualList.add(actionES);
		actualList.add(behaviorES.getStart());
		actualList.add(behaviorES);
		actualList.add((InteractionFragment)message.getSendEvent());
		actualList.add((InteractionFragment)message.getReceiveEvent());
		actualList.add(behaviorES.getFinish());
		actualList.add(actionES.getFinish());
		final List<InteractionFragment> fragments = new ArrayList<InteractionFragment>(actualList);
		Display.getDefault().asyncExec(new Runnable() {

			public void run() {
				validateOrders(interaction.getFragments(), fragments);
			}
		});
	}

	protected void validateOrders(List<InteractionFragment> expectedList, List<InteractionFragment> actualList) {
		assertNotNull("actualList", actualList);
		assertNotNull("expectedList", expectedList);
		for(int index = 0; index < actualList.size(); index++) {
			InteractionFragment fragment = actualList.get(index);
			int expectedIndex = expectedList.indexOf(fragment);
			assertEquals("Index of " + fragment.getName(), expectedIndex, index);
		}
	}
}
