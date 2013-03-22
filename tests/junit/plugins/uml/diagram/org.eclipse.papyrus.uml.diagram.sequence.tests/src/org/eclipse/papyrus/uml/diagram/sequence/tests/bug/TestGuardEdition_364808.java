/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.tests.bug;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentCombinedFragmentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestTopNode;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.InteractionConstraint;
import org.eclipse.uml2.uml.InteractionOperatorKind;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;


/**
 * An advanced textual editor for combined fragments guards would allow to capture
 * complex guards.
 * 
 */
public class TestGuardEdition_364808 extends TestTopNode {

	private static final String CHANGE_OPERATOR_KIND = "Change Operator Kind: ";

	private static final String EDIT = "Edit: ";

	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateSequenceDiagramCommand();
	}

	@Test
	public void testEditText() {
		InteractionOperandEditPart op = setupOperand();
		WrappingLabel label = performEditRequest(op);

		Composite composite = (Composite)op.getViewer().getControl();
		Text editor = findEditor(composite, label);
		assertNotNull(editor);
		assertTrue(EDIT + INITIALIZATION_TEST, label.getText().contains(editor.getText()));

		// edit text
		String cond = "a < b";
		editor.setText(cond);
		input(editor, SWT.CR);
		waitForComplete();

		// verify
		CombinedFragment cf = (CombinedFragment)((CombinedFragmentEditPart)getRootEditPart().getChildren().get(0)).resolveSemanticElement();
		InteractionConstraint guard = cf.getOperands().get(0).getGuard();
		assertTrue(EDIT + TEST_THE_EXECUTION, cond.equals(((LiteralString)guard.getSpecification()).getValue()));
		assertTrue(EDIT + TEST_THE_EXECUTION, label.getText().contains(cond));
	}

	@Test
	public void testEditLoop() {
		InteractionOperandEditPart op = setupOperand();
		CombinedFragmentEditPart cep = (CombinedFragmentEditPart)getRootEditPart().getChildren().get(0);
		changeOperatorKind(cep, (CombinedFragment)cep.resolveSemanticElement(), InteractionOperatorKind.LOOP_LITERAL);

		WrappingLabel label = performEditRequest(op);

		Composite composite = (Composite)op.getViewer().getControl();
		Text editor = findEditor(composite, label);
		assertNotNull(editor);

		// edit text
		String cond = "[1,10] a < b";
		editor.setText(cond);
		input(editor, SWT.CR);
		waitForComplete();

		// verify
		CombinedFragment cf = (CombinedFragment)((CombinedFragmentEditPart)getRootEditPart().getChildren().get(0)).resolveSemanticElement();
		InteractionConstraint guard = cf.getOperands().get(0).getGuard();
		assertTrue(EDIT + TEST_THE_EXECUTION, "a < b".equals(((LiteralString)guard.getSpecification()).getValue()));
		assertTrue(EDIT + TEST_THE_EXECUTION, ((LiteralInteger)guard.getMaxint()).getValue() == 10);
		assertTrue(EDIT + TEST_THE_EXECUTION, ((LiteralInteger)guard.getMinint()).getValue() == 1);
		assertTrue(EDIT + TEST_THE_EXECUTION, label.getText().contains("1,10"));
		assertTrue(EDIT + TEST_THE_EXECUTION, label.getText().contains("a < b"));
	}

	protected InteractionOperandEditPart setupOperand() {
		createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), new Point(10, 80), new Dimension(100, 100));
		CombinedFragmentEditPart cep = (CombinedFragmentEditPart)getRootEditPart().getChildren().get(0);
		final CombinedFragmentCombinedFragmentCompartmentEditPart cfp = (CombinedFragmentCombinedFragmentCompartmentEditPart)cep.getChildren().get(0);
		InteractionOperandEditPart op = (InteractionOperandEditPart)cfp.getChildren().get(0);
		waitForComplete();
		return op;
	}

	protected WrappingLabel performEditRequest(InteractionOperandEditPart op) {
		WrappingLabel label = op.getPrimaryShape().getInteractionConstraintLabel();
		Rectangle b = label.getBounds().getCopy();
		label.translateToAbsolute(b);
		DirectEditRequest req = new DirectEditRequest();
		req.setLocation(b.getCenter());
		op.performRequest(req);
		return label;
	}

	private Text findEditor(Composite composite, WrappingLabel label) {
		for(Control c : composite.getChildren()) {
			if(c instanceof Text) {
				if(label.getText().equals(((Text)c).getText()))
					return (Text)c;
			}
		}
		return null;
	}

	protected void changeOperatorKind(CombinedFragmentEditPart p, CombinedFragment cf, InteractionOperatorKind kind) {
		EAttribute feature = UMLPackage.eINSTANCE.getCombinedFragment_InteractionOperator();
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(cf);
		SetRequest request = new SetRequest(p.getEditingDomain(), cf, feature, kind);
		ICommand createGMFCommand = provider.getEditCommand(request);
		org.eclipse.emf.common.command.AbstractCommand emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);
		assertTrue(CHANGE_OPERATOR_KIND + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, emfCommand.canExecute() == true);
		getEMFCommandStack().execute(emfCommand);
		waitForComplete();
		assertTrue(CHANGE_OPERATOR_KIND + TEST_THE_EXECUTION, cf.getInteractionOperator() == kind);
	}

	public void input(Widget widget, char... character) {
		if(widget.isDisposed())
			return;

		for(char c : character) {
			Event e = createKeyEvent(widget, 0, c);
			e.type = SWT.KeyDown;
			widget.notifyListeners(SWT.KeyDown, e);

			e = createKeyEvent(widget, 0, c);
			e.type = SWT.KeyUp;
			widget.notifyListeners(SWT.KeyUp, e);
		}
		waitForComplete();
	}

	private Event createKeyEvent(Widget widget, int keyCode, char character) {
		Event event = new Event();
		event.time = (int)System.currentTimeMillis();
		event.widget = widget;
		event.display = Display.getDefault();
		event.keyCode = keyCode;
		event.character = character;
		return event;
	}

	public void createNode(IElementType type, EditPart parentPart, Point location, Dimension size) {
		//CREATION
		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, getRootEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(location);
		requestcreation.setSize(size);
		Command command = parentPart.getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

		getDiagramCommandStack().execute(command);
	}
}
