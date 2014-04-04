/*****************************************************************************
 * Copyright (c) 2010 CEA
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.appearance.helper.AppearanceHelper;
import org.eclipse.papyrus.infra.emf.appearance.helper.VisualInformationPapyrusConstants;
import org.eclipse.papyrus.uml.diagram.common.figure.node.CornerBentFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentCombinedFragmentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentBodyEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Constraint2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomInteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionUseEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionUseNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.StateInvariantNameEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.eclipse.swt.graphics.Image;
import org.junit.Before;
import org.junit.Test;

/**
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=396799
 *
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class TestElementIcon_396799 extends AbstractNodeTest {

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7.AbstractNodeTest#setUp()
	 *
	 * @throws Exception
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected String getProjectName() {
		return ISequenceDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return ISequenceDiagramTestsConstants.FILE_NAME;
	}

	protected void replaceEannotation(EAnnotation annotation, EModelElement object) {
		while(object.getEAnnotation(annotation.getSource()) != null) {
			object.getEAnnotations().remove(object.getEAnnotation(annotation.getSource()));
		}
		object.getEAnnotations().add(annotation);
	}

	protected void replaceEntry(EAnnotation annotation, String key, String value) {
		while(annotation.getDetails().get(key) != null) {
			annotation.getDetails().removeKey(key);
		}
		annotation.getDetails().put(key, value);
	}

	protected EAnnotation createEAnnotation() {
		EAnnotation eannotation = EcoreFactory.eINSTANCE.createEAnnotation();
		eannotation.setSource(VisualInformationPapyrusConstants.DISPLAY_NAMELABELICON);
		return eannotation;
	}

	private void changeElementIcon(final View model) {
		final boolean showElementIcon = AppearanceHelper.showElementIcon(model);
		AbstractTransactionalCommand command = new AbstractTransactionalCommand(getEditingDomain(), "Display Element Icon", Collections.singletonList(file)) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				EAnnotation shadowFigureEAnnotation = createEAnnotation();
				replaceEannotation(shadowFigureEAnnotation, model);
				replaceEntry(shadowFigureEAnnotation, VisualInformationPapyrusConstants.DISPLAY_NAMELABELICON_VALUE, "" + !showElementIcon);
				return CommandResult.newOKCommandResult();
			}
		};
		assertTrue(command.canExecute());
		getDiagramCommandStack().execute(new ICommandProxy(command));
		waitForComplete();
		assertEquals(showElementIcon, !AppearanceHelper.showElementIcon(model));
	}

	private Image getLabelIconHelper(IFigure figure) {
		if(figure instanceof CornerBentFigure) {
			try {
				Field f = CornerBentFigure.class.getDeclaredField("iconLabel");
				f.setAccessible(true);
				Label label = (Label)f.get(figure);
				if(label != null) {
					return label.getIcon();
				}
			} catch (Exception e) {
			}
		} else if(figure instanceof WrappingLabel) {
			return ((WrappingLabel)figure).getIcon();
		} else if(figure instanceof ILabelFigure) {
			return ((ILabelFigure)figure).getIcon();
		} else if(figure instanceof Label) {
			return ((Label)figure).getIcon();
		}
		return null;
	}

	@Test
	public void testLifeline() {
		LifelineEditPart lifeline = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(lifeline);
		View view = lifeline.getNotationView();
		LifelineNameEditPart nameEditPart = (LifelineNameEditPart)lifeline.getChildBySemanticHint("" + LifelineNameEditPart.VISUAL_ID);
		assertNotNull(nameEditPart);
		//do check
		testElementIcon(nameEditPart.getFigure(), view, true);
	}

	private void testElementIcon(IFigure labelFigure, View model, boolean enabled) {
		assertNotNull(labelFigure);
		assertNotNull(model);
		Image actual = getLabelIconHelper(labelFigure);
		Image expected = UMLElementTypes.getImage(ViewUtil.resolveSemanticElement(model).eClass());
		if(enabled) {
			if(AppearanceHelper.showElementIcon(model)) {
				assertEquals(expected, actual);
			} else {
				assertTrue(actual == null);
			}
		} else {
			assertTrue(expected != actual);
		}
		//Change element icon
		changeElementIcon(model);
		waitForComplete();
		actual = getLabelIconHelper(labelFigure);
		if(enabled) {
			if(AppearanceHelper.showElementIcon(model)) {
				assertEquals(expected, actual);
			} else {
				assertTrue(actual == null);
			}
		} else {
			assertTrue(expected != actual);
		}
	}

	@Test
	public void testCombinedFragment() {
		CombinedFragmentEditPart cf = (CombinedFragmentEditPart)createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), new Point(100, 100), new Dimension(200, 200));
		assertNotNull(cf);
		testElementIcon(cf.getPrimaryShape().getHeaderLabel(), cf.getNotationView(), true);
	}

	@Test
	public void testInteraction() {
		InteractionEditPart iep = (InteractionEditPart)getRootEditPart().getParent();
		assertNotNull(iep);
		InteractionNameEditPart object = (InteractionNameEditPart)iep.getChildBySemanticHint("" + InteractionNameEditPart.VISUAL_ID);
		testElementIcon(object.getFigure(), iep.getNotationView(), true);
	}

	@Test
	public void testInteractionOperand() {
		CombinedFragmentEditPart cf = (CombinedFragmentEditPart)createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), new Point(100, 100), new Dimension(200, 200));
		assertNotNull(cf);
		CombinedFragmentCombinedFragmentCompartmentEditPart compartment = (CombinedFragmentCombinedFragmentCompartmentEditPart)cf.getChildBySemanticHint("" + CombinedFragmentCombinedFragmentCompartmentEditPart.VISUAL_ID);
		assertNotNull(compartment);
		InteractionOperandEditPart operand = (InteractionOperandEditPart)compartment.getChildBySemanticHint("" + InteractionOperandEditPart.VISUAL_ID);
		assertNotNull(operand);
		WrappingLabel label = operand instanceof CustomInteractionOperandEditPart ? ((CustomInteractionOperandEditPart)operand).getInteractionConstraintLabel() : operand.getPrimaryShape().getInteractionConstraintLabel();
		testElementIcon(label, operand.getNotationView(), true);
	}

	@Test
	public void testInteractionUse() {
		InteractionUseEditPart interactionUse = (InteractionUseEditPart)createNode(UMLElementTypes.InteractionUse_3002, getRootEditPart(), new Point(100, 100), new Dimension(200, 200));
		assertNotNull(interactionUse);
		InteractionUseNameEditPart editPart = (InteractionUseNameEditPart)interactionUse.getChildBySemanticHint("" + InteractionUseNameEditPart.VISUAL_ID);
		assertNotNull(editPart);
		testElementIcon(editPart.getFigure(), interactionUse.getNotationView(), true);
	}

	@Test
	public void testStateInvariant() {
		LifelineEditPart lifeline = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(lifeline);
		StateInvariantEditPart stateInvariant = (StateInvariantEditPart)createNode(UMLElementTypes.StateInvariant_3017, lifeline, getAbsoluteCenter(lifeline), null);
		assertNotNull(stateInvariant);
		StateInvariantNameEditPart editPart = (StateInvariantNameEditPart)stateInvariant.getChildBySemanticHint("" + StateInvariantNameEditPart.VISUAL_ID);
		assertNotNull(editPart);
		testElementIcon(editPart.getFigure(), stateInvariant.getNotationView(), true);
	}

	@Test
	public void testComment() {
		CommentEditPart comment = (CommentEditPart)createNode(UMLElementTypes.Comment_3009, getRootEditPart(), new Point(100, 100), new Dimension(100, 100));
		assertNotNull(comment);
		CommentBodyEditPart editPart = (CommentBodyEditPart)comment.getChildBySemanticHint("" + CommentBodyEditPart.VISUAL_ID);
		assertNotNull(editPart);
		testElementIcon(editPart.getFigure(), comment.getNotationView(), true);
	}

	@Test
	public void testConstraint() {
		ConstraintEditPart constraint = (ConstraintEditPart)createNode(UMLElementTypes.Constraint_3008, getRootEditPart(), new Point(100, 100), new Dimension(100, 100));
		assertNotNull(constraint);
		Constraint2EditPart editPart = (Constraint2EditPart)constraint.getChildBySemanticHint("" + Constraint2EditPart.VISUAL_ID);
		assertNotNull(editPart);
		testElementIcon(editPart.getFigure(), constraint.getNotationView(), true);
	}

	@Test
	public void testDurationConstraint() {
	}

	@Test
	public void testDestructionEvent() {
	}

	@Test
	public void testTimeConstraint() {
	}

	@Test
	public void testCoRegion() {
	}

	@Test
	public void testDurationObservation() {
	}

	@Test
	public void testTimeObservation() {
	}

	@Test
	public void testExecutionSpecifications() {
	}

	@Test
	public void testMessages() {
	}
}
