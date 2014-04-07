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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7.AbstractNodeTest;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.ActionExecutionSpecification;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.junit.Test;

/**
 * Fixed bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=417374
 *
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class Fixbug_OrderFragmentsAfterResizeExecutions_417374 extends AbstractNodeTest {

	@Test
	public void test() {
		EditPart lifeline = createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(100, 500));

		Interaction interaction = (Interaction)getRootEditPart().resolveSemanticElement();

		ActionExecutionSpecificationEditPart execution1 = (ActionExecutionSpecificationEditPart)createNode(UMLElementTypes.ActionExecutionSpecification_3006, lifeline, new Point(131, 200), new Dimension(16, 150));
		ActionExecutionSpecification actionES = (ActionExecutionSpecification)execution1.resolveSemanticElement();
		waitForComplete();
		//validate after create action
		List<InteractionFragment> actualList = new ArrayList<InteractionFragment>();
		actualList.add(actionES.getStart());
		actualList.add(actionES);
		actualList.add(actionES.getFinish());
		validateOrders(interaction.getFragments(), actualList);

		BehaviorExecutionSpecificationEditPart execution2 = (BehaviorExecutionSpecificationEditPart)createNode(UMLElementTypes.BehaviorExecutionSpecification_3003, lifeline, new Point(148, 230), new Dimension(16, 80));
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

		//resize behavior
		resize(execution2, SequenceUtil.getAbsoluteBounds(execution2).getLocation(), PositionConstants.SOUTH, new Dimension(0, 100));
		//validate
		actualList = new ArrayList<InteractionFragment>();
		actualList.add(actionES.getStart());
		actualList.add(actionES);
		actualList.add(behaviorES.getStart());
		actualList.add(behaviorES);
		actualList.add(actionES.getFinish());
		actualList.add(behaviorES.getFinish());
		validateOrders(interaction.getFragments(), actualList);
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
