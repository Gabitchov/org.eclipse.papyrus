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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestTopNode;
import org.eclipse.papyrus.uml.tools.utils.ValueSpecificationUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.uml2.uml.ActionExecutionSpecification;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.Interval;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.ValueSpecification;
import org.junit.Test;

/**
 * An embedded textuel editor shall allow editing duration constraints. This editor shall be accessible on the diagram.
 * When the two values of the interval are equal, the value shall be displayed only once.
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=384596
 * 
 */
public class TestDurationConstraints_384596 extends TestTopNode {

	private static final String SEP = "..";

	/** The occurrence specification(s) which are the nearest from a creation request */
	public static final String NEAREST_OCCURRENCE_SPECIFICATION = "Nearest occurrence specification"; //$NON-NLS-1$

	/** The occurrence specification(s) which are the nearest from a creation request (2nd end of creation) */
	public static final String NEAREST_OCCURRENCE_SPECIFICATION_2 = "Nearest occurrence specification (end)"; //$NON-NLS-1$

	private static final String EDIT = "Edit: ";

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateSequenceDiagramCommand();
	}

	@Test
	public void testDurationEdition() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(62, 200), null);
		final LifelineEditPart lifeline1 = (LifelineEditPart)getRootEditPart().getChildren().get(0);
		waitForComplete();

		createNode(UMLElementTypes.ActionExecutionSpecification_3006, lifeline1, new Point(131, 200), new Dimension(20, 40), null);
		waitForComplete();

		ActionExecutionSpecificationEditPart esp = (ActionExecutionSpecificationEditPart)lifeline1.getChildren().get(1);
		createDuraitonConstraint(lifeline1, esp);

		DurationConstraintEditPart dp = (DurationConstraintEditPart)lifeline1.getChildren().get(2);

		// edit text
		WrappingLabel label = verifyEditText(dp, "1s", "2s");
		assertTrue(EDIT + TEST_THE_EXECUTION, label.getText().contains("1s..2s"));

		label = verifyEditText(dp, "d", "d+3");
		assertTrue(EDIT + TEST_THE_EXECUTION, label.getText().contains("d..d+3"));

		getEMFCommandStack().undo();
		assertTrue(EDIT + TEST_THE_UNDO, label.getText().contains("1s..2s"));

		label = verifyEditText(dp, "1", "1");
		assertTrue(EDIT + TEST_THE_EXECUTION, label.getText().contains("1") && !label.getText().contains(SEP));

	}

	protected WrappingLabel verifyEditText(DurationConstraintEditPart dp, String min, String max) {
		DurationConstraintLabelEditPart lp = (DurationConstraintLabelEditPart)dp.getChildren().get(0);
		WrappingLabel label = performEditRequest(lp);

		Composite composite = (Composite)lp.getViewer().getControl();
		Text editor = findEditor(composite, label);

		editor.setText(min + SEP + max);
		input(editor, SWT.CR);

		DurationConstraint constraint = (DurationConstraint)dp.resolveSemanticElement();
		ValueSpecification spec = constraint.getSpecification();
		assertTrue(EDIT + TEST_THE_EXECUTION, min.equals(ValueSpecificationUtil.getSpecificationValue(((Interval)spec).getMin())));
		assertTrue(EDIT + TEST_THE_EXECUTION, max.equals(ValueSpecificationUtil.getSpecificationValue(((Interval)spec).getMax())));

		waitForComplete();
		return label;
	}

	protected void createDuraitonConstraint(final LifelineEditPart lifeline1, ActionExecutionSpecificationEditPart esp) {
		ActionExecutionSpecification aes = (ActionExecutionSpecification)esp.resolveSemanticElement();

		Map<String, Object> extendedData = new HashMap<String, Object>();
		List<OccurrenceSpecification> events = new ArrayList<OccurrenceSpecification>(2);
		events.add(aes.getStart());
		extendedData.put(NEAREST_OCCURRENCE_SPECIFICATION, events);

		events = new ArrayList<OccurrenceSpecification>(2);
		events.add(aes.getFinish());
		extendedData.put(NEAREST_OCCURRENCE_SPECIFICATION_2, events);

		createNode(UMLElementTypes.DurationConstraint_3021, lifeline1, getAbsoluteBounds(esp).getBottom(), new Dimension(20, 40), extendedData);
		waitForComplete();
	}

	public void input(Widget widget, char... character) {
		if(widget.isDisposed()) {
			return;
		}

		for(char c : character) {
			Event e = createKeyEvent(widget, 0, c);
			e.type = SWT.KeyDown;
			widget.notifyListeners(SWT.KeyDown, e);

			e = createKeyEvent(widget, 0, c);
			e.type = SWT.KeyUp;
			widget.notifyListeners(SWT.KeyUp, e);
		}
		waitForComplete();

		Event e = new Event();
		e.type = SWT.DefaultSelection;
		widget.notifyListeners(SWT.DefaultSelection, e);
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

	private Text findEditor(Composite composite, WrappingLabel label) {
		for(Control c : composite.getChildren()) {
			if(c instanceof Text) {
				if(label.getText().equals(((Text)c).getText())) {
					return (Text)c;
				}
			}
		}
		return null;
	}

	protected WrappingLabel performEditRequest(DurationConstraintLabelEditPart lp) {
		WrappingLabel label = (WrappingLabel)lp.getFigure();
		Rectangle b = label.getBounds().getCopy();
		label.translateToAbsolute(b);
		DirectEditRequest req = new DirectEditRequest();
		req.setLocation(b.getCenter());
		lp.performRequest(req);
		return label;
	}

	public void createNode(IElementType type, EditPart parentPart, Point location, Dimension size, Map<String, Object> extendedData) {
		//CREATION
		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, getRootEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(location);
		requestcreation.setSize(size);
		if(extendedData != null) {
			requestcreation.getExtendedData().putAll(extendedData);
		}
		Command command = parentPart.getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

		getDiagramCommandStack().execute(command);
	}

}
