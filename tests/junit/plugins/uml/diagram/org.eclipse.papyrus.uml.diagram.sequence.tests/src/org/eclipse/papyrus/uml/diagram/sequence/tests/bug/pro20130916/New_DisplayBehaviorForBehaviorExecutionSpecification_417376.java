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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.BehaviorExecutionSpecificationBehaviorEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7.AbstractNodeTest;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Before;
import org.junit.Test;


/**
 * Display behavior as a label: https://bugs.eclipse.org/bugs/show_bug.cgi?id=417376
 *
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class New_DisplayBehaviorForBehaviorExecutionSpecification_417376 extends AbstractNodeTest {

	private BehaviorExecutionSpecificationEditPart behaviorExecutionSpecificationEditPart;

	private BehaviorExecutionSpecification behaviorExecutionSpecification;

	protected Behavior createBehavior(final String name, final EClass type) {
		final Model behaviorContainer = getBehaviorContainer();
		getCommandStack().execute(new RecordingCommand(getEditingDomain()) {

			@Override
			protected void doExecute() {
				behaviorContainer.createPackagedElement(name, type);
			}
		});
		waitForComplete();
		PackageableElement behavior = behaviorContainer.getPackagedElement(name);
		assertNotNull("create behavior", behavior);
		assertEquals("created behavior type", type, behavior.eClass());
		return (Behavior)behavior;
	}

	/**
	 * Check if there's a Label with given behaviorName.
	 */
	private void doCheckBehaviorLabel(String behaviorName) {
		IGraphicalEditPart child = behaviorExecutionSpecificationEditPart.getChildBySemanticHint(BehaviorExecutionSpecificationBehaviorEditPart.BEHAVIOR_TYPE);
		if(behaviorName == null) {
			assertNull("Behavior should NOT be displayed.", child);
		} else {
			assertNotNull("Behavior should be displayed.", child);
			assertTrue("Behavior should be a BehaviorExecutionSpecificationBehaviorEditPart", child instanceof BehaviorExecutionSpecificationBehaviorEditPart);
			BehaviorExecutionSpecificationBehaviorEditPart behaviorEditPart = (BehaviorExecutionSpecificationBehaviorEditPart)child;
			IFigure figure = behaviorEditPart.getFigure();
			String labelText = null;
			if(figure instanceof WrappingLabel) {
				labelText = ((WrappingLabel)figure).getText();
			} else if(figure instanceof Label) {
				labelText = ((Label)figure).getText();
			} else if(figure instanceof ILabelFigure) {
				labelText = ((ILabelFigure)figure).getText();
			}
			assertEquals("Displayed behavior", behaviorName, labelText);
		}
	}

	protected Model getBehaviorContainer() {
		EObject eContainer = behaviorExecutionSpecification.eContainer();
		while(eContainer != null && !(eContainer instanceof Model)) {
			eContainer = eContainer.eContainer();
		}
		return (Model)eContainer;
	}

	protected void setBehavior(final Behavior newBehavior) {
		getCommandStack().execute(new RecordingCommand(getEditingDomain()) {

			@Override
			protected void doExecute() {
				behaviorExecutionSpecification.setBehavior(newBehavior);
			}
		});
		waitForComplete();
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7.AbstractNodeTest#setUp()
	 *
	 * @throws Exception
	 */
	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();
		EditPart lifeline = createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), null);
		assertNotNull("lifeline", lifeline);
		behaviorExecutionSpecificationEditPart = (BehaviorExecutionSpecificationEditPart)createNode(UMLElementTypes.BehaviorExecutionSpecification_3003, lifeline, new Point(131, 150), null);
		assertNotNull("execution", behaviorExecutionSpecificationEditPart);
		EObject element = behaviorExecutionSpecificationEditPart.resolveSemanticElement();
		assertNotNull("element", element);
		assertTrue("behavior execution", element instanceof BehaviorExecutionSpecification);
		behaviorExecutionSpecification = (BehaviorExecutionSpecification)element;
	}

	/**
	 * Test behavior, the name of the behavior should be displayed.
	 */
	@Test
	public void testDisplayBehavior() {
		String behaviorName = "testDisplayBehavior_Activity";
		setBehavior(createBehavior(behaviorName, UMLPackage.eINSTANCE.getActivity()));

		doCheckBehaviorLabel(behaviorName);
	}

	/**
	 * Test OpaqueBehavior, the languages and bodies should be displayed, too
	 */
	@Test
	public void testDisplayOpaqueBehavior() {
		final OpaqueBehavior opaqueBehavior = (OpaqueBehavior)createBehavior("testDisplayBehavior_Opaque", UMLPackage.eINSTANCE.getOpaqueBehavior());
		getCommandStack().execute(new RecordingCommand(getEditingDomain()) {

			@Override
			protected void doExecute() {
				opaqueBehavior.getLanguages().add("JAVA");
				opaqueBehavior.getBodies().add("System.out.print()");
				opaqueBehavior.getLanguages().add("OCL");
				opaqueBehavior.getBodies().add("self.radius > 0");
			}
		});
		setBehavior(opaqueBehavior);
		doCheckBehaviorLabel("{{JAVA}System.out.print(), {OCL}self.radius > 0}");
	}
}
