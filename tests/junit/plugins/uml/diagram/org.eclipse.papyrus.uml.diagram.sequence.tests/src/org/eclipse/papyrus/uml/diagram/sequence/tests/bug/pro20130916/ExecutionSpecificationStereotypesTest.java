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
import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.junit.Test;


/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class ExecutionSpecificationStereotypesTest extends BaseStereotypesTest {

	private LifelineEditPart lifeline;

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7.AbstractNodeTest#setUp()
	 * 
	 * @throws Exception
	 */

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		lifeline = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 300), null);
		assertNotNull(lifeline);
	}

	@Test
	public void testDisplayStereotypeComment_ActionExecutionSpecification() {
		EditPart es = createNode(UMLElementTypes.ActionExecutionSpecification_3006, lifeline, new Point(131, 150), null);
		assertNotNull("actionExecutionSpecification", es);
		doTestDisplayStereotypeComment(es);
	}

	@Test
	public void testDisplayStereotypeComment_BehaviorExecutionSpecification() {
		EditPart es = createNode(UMLElementTypes.BehaviorExecutionSpecification_3003, lifeline, new Point(131, 220), null);
		assertNotNull("behaviorExecutionSpecification", es);
		doTestDisplayStereotypeComment(es);
	}

	@Test
	public void testDisplayStereotypeComment_DestructionExecutionSpecification() {
		EditPart es = createNode(UMLElementTypes.DestructionOccurrenceSpecification_3022, lifeline, new Point(131, 250), null);
		assertNotNull("destructionExecutionSpecification", es);
		doTestDisplayStereotypeComment(es);
	}

}
