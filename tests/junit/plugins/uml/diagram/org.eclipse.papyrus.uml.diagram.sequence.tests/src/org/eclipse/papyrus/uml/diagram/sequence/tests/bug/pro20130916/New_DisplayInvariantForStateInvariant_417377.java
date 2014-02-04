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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomStateInvariantLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.sequence.providers.ElementInitializers;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7.AbstractNodeTest;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Duration;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.DurationInterval;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.StateInvariant;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.TimeExpression;
import org.eclipse.uml2.uml.TimeInterval;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;


/**
 * Display invariant for a StateInvariant: https://bugs.eclipse.org/bugs/show_bug.cgi?id=417377
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class New_DisplayInvariantForStateInvariant_417377 extends AbstractNodeTest {

	private StateInvariantEditPart stateInvarintEditPart;

	private StateInvariant stateInvariant;

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7.AbstractNodeTest#setUp()
	 * 
	 * @throws Exception
	 */

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		EditPart lifeline = createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), null);
		assertNotNull("lifeline", lifeline);
		stateInvarintEditPart = (StateInvariantEditPart)createNode(UMLElementTypes.StateInvariant_3017, lifeline, new Point(131, 150), null);
		assertNotNull("stateInvariant", stateInvarintEditPart);
		stateInvariant = (StateInvariant)stateInvarintEditPart.resolveSemanticElement();
		assertNotNull("uml element", stateInvariant);
	}

	@Test
	public void testDisplayInvariant_TimeConstraint() {
		final Interaction interaction = (Interaction)getRootSemanticModel();
		//create and add time constraint.
		getCommandStack().execute(new RecordingCommand(getEditingDomain()) {

			@Override
			protected void doExecute() {
				TimeConstraint timeConstraint = (TimeConstraint)interaction.createOwnedRule("timeRule", UMLPackage.eINSTANCE.getTimeConstraint());
				TimeInterval timeInterval = UMLFactory.eINSTANCE.createTimeInterval();
				timeConstraint.setSpecification(timeInterval);
				org.eclipse.uml2.uml.Package package_ = timeInterval.getNearestPackage();
				TimeExpression minTimeExp = UMLFactory.eINSTANCE.createTimeExpression();
				TimeExpression maxTimeExp = UMLFactory.eINSTANCE.createTimeExpression();
				package_.getPackagedElements().add(minTimeExp);
				package_.getPackagedElements().add(maxTimeExp);
				ElementInitializers.init_NamedElement(minTimeExp, "", timeInterval.eClass().getName(), "Min");
				ElementInitializers.init_NamedElement(maxTimeExp, "", timeInterval.eClass().getName(), "Max");
				timeInterval.setMin(minTimeExp);
				timeInterval.setMax(maxTimeExp);
				LiteralInteger minExprValue = UMLFactory.eINSTANCE.createLiteralInteger();
				minExprValue.setValue(20);
				minTimeExp.setExpr(minExprValue);
				LiteralInteger maxTimeValue = UMLFactory.eINSTANCE.createLiteralInteger();
				maxTimeValue.setValue(50);
				maxTimeExp.setExpr(maxTimeValue);

				stateInvariant.setInvariant(timeConstraint);
			}
		});
		waitForComplete();
		doCheckInvariantLabel("{20..50}");
	}

	@Test
	public void testDisplayInvariant_DurationConstraint() {
		final Interaction interaction = (Interaction)getRootSemanticModel();
		//create and add duration constraint.
		getCommandStack().execute(new RecordingCommand(getEditingDomain()) {

			@Override
			protected void doExecute() {
				DurationConstraint durationConstraint = (DurationConstraint)interaction.createOwnedRule("durationRule", UMLPackage.eINSTANCE.getDurationConstraint());
				DurationInterval durationInterval = UMLFactory.eINSTANCE.createDurationInterval();
				durationConstraint.setSpecification(durationInterval);
				org.eclipse.uml2.uml.Package package_ = durationConstraint.getNearestPackage();
				Duration minDuration = UMLFactory.eINSTANCE.createDuration();
				Duration maxDuration = UMLFactory.eINSTANCE.createDuration();
				package_.getPackagedElements().add(minDuration);
				package_.getPackagedElements().add(maxDuration);
				ElementInitializers.init_NamedElement(minDuration, "", durationInterval.eClass().getName(), "Min");
				ElementInitializers.init_NamedElement(maxDuration, "", durationInterval.eClass().getName(), "Max");
				durationInterval.setMin(minDuration);
				durationInterval.setMax(maxDuration);
				LiteralInteger minDurationValue = UMLFactory.eINSTANCE.createLiteralInteger();
				minDurationValue.setValue(20);
				minDuration.setExpr(minDurationValue);
				LiteralInteger maxDurationValue = UMLFactory.eINSTANCE.createLiteralInteger();
				maxDurationValue.setValue(50);
				maxDuration.setExpr(maxDurationValue);

				stateInvariant.setInvariant(durationConstraint);
			}
		});
		waitForComplete();
		doCheckInvariantLabel("{20..50}");
	}

	@Test
	public void testDisplayInvariant_Constraint() {
		final Interaction interaction = (Interaction)getRootSemanticModel();
		//create and add constraint.
		getCommandStack().execute(new RecordingCommand(getEditingDomain()) {

			@Override
			protected void doExecute() {
				Constraint constraint = (Constraint)interaction.createOwnedRule("constraintRule", UMLPackage.eINSTANCE.getConstraint());
				LiteralString value = UMLFactory.eINSTANCE.createLiteralString();
				value.setValue("testConstraint");
				constraint.setSpecification(value);
				stateInvariant.setInvariant(constraint);
			}
		});
		waitForComplete();
		doCheckInvariantLabel("{testConstraint}");
	}

	/**
	 * @param string
	 */
	private void doCheckInvariantLabel(String expectedLabelValue) {
		IGraphicalEditPart child = stateInvarintEditPart.getChildBySemanticHint(UMLVisualIDRegistry.getType(StateInvariantLabelEditPart.VISUAL_ID));
		assertTrue("invariant edit part", child instanceof CustomStateInvariantLabelEditPart);
		IFigure figure = ((CustomStateInvariantLabelEditPart)child).getFigure();
		String actualLabelValue = null;
		if(figure instanceof WrappingLabel) {
			actualLabelValue = ((WrappingLabel)figure).getText();
		} else if(figure instanceof Label) {
			actualLabelValue = ((Label)figure).getText();
		} else if(figure instanceof ILabelFigure) {
			actualLabelValue = ((ILabelFigure)figure).getText();
		}
		assertEquals("displayed invariant value", expectedLabelValue, actualLabelValue);
	}
}
