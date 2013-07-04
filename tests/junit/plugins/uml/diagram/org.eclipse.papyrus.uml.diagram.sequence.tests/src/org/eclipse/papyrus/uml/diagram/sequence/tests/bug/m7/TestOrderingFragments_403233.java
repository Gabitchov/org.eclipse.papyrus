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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.junit.Test;

/**
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=403233
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class TestOrderingFragments_403233 extends AbstractNodeTest {

	@Override
	protected String getProjectName() {
		return ISequenceDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return ISequenceDiagramTestsConstants.FILE_NAME;
	}
	
	@Test
	public void testOrderingAfterCreateExecutions() {
		LifelineEditPart lifeline = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(200, 100), null);
		AbstractExecutionSpecificationEditPart executionPart1 = (AbstractExecutionSpecificationEditPart)createNode(UMLElementTypes.ActionExecutionSpecification_3006, lifeline, getAbsoluteBounds(lifeline).getCenter(), null);
		AbstractExecutionSpecificationEditPart executionPart2 = (AbstractExecutionSpecificationEditPart)createNode(UMLElementTypes.ActionExecutionSpecification_3006, lifeline, getAbsoluteBounds(executionPart1).getCenter().getTranslated(0, -100), null);
		ExecutionSpecification execution1 = (ExecutionSpecification)executionPart1.resolveSemanticElement();
		ExecutionSpecification execution2 = (ExecutionSpecification)executionPart2.resolveSemanticElement();
		validOrderWithPosition(execution1, getAbsoluteBounds(executionPart1).y, execution2, getAbsoluteBounds(executionPart2).y);
	}

	private void validOrderWithPosition(InteractionFragment fragment1, int position1, InteractionFragment fragment2, int position2) {
		if(position1 == position2) {
			return;
		}
		assertNotNull("fragment1", fragment1);
		assertNotNull("fragment2", fragment2);
		EObject container = fragment1.eContainer();
		assertEquals("has same container", fragment1.eContainer(), fragment2.eContainer());
		EList<InteractionFragment> fragments = null;
		if(container instanceof Interaction) {
			fragments = ((Interaction)container).getFragments();
		} else if(container instanceof InteractionOperand) {
			fragments = ((InteractionOperand)container).getFragments();
		}
		int index1 = fragments.indexOf(fragment1);
		int index2 = fragments.indexOf(fragment2);
		if(position1 < position2) {
			assertTrue("", index1 < index2);
		} else if(position1 > position2) {
			assertTrue("", index1 > index2);
		}
	}
}
