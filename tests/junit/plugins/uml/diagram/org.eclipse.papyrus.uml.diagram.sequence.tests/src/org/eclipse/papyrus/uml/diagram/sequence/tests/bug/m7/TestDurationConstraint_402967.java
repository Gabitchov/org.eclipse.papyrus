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

import java.util.Collections;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.common.draw2d.LinesBorder;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintLabelEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ExecutionSpecificationEndEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageEndEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.eclipse.papyrus.uml.tools.utils.ValueSpecificationUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.Interval;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.ValueSpecification;
import org.junit.Test;

public class TestDurationConstraint_402967 extends AbstractNodeTest {

	public static final String REQ_ANNOTATED_LINK_END = "annotated link end";

	public static final String REQ_ANNOTATED_LINK_START = "annotated link start";

	private static final String MOVE = "Move";

	private static final String EDIT = "Edit: ";

	private static final String SEP = "..";

	@Override
	protected String getProjectName() {
		return ISequenceDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return ISequenceDiagramTestsConstants.FILE_NAME;
	}
	
	protected Event createMouseEvent(int x, int y, int button, int stateMask, int count) {
		Event event = new Event();
		event.time = (int)System.currentTimeMillis();
		event.widget = null;
		event.display = Display.getDefault();
		event.x = x;
		event.y = y;
		event.button = button;
		event.stateMask = stateMask;
		event.count = count;
		return event;
	}

	protected Event createEvent() {
		Event event = new Event();
		event.time = (int)System.currentTimeMillis();
		event.widget = null;
		event.display = Display.getDefault();
		return event;
	}

	protected Event createSelectionEvent(int stateMask) {
		Event event = createEvent();
		event.stateMask = stateMask;
		return event;
	}

	private Point selectEditpart(DurationConstraintEditPart dc) {
		// select edit part
		Control control = dc.getViewer().getControl();
		Point p = getAbsoluteBounds(dc).getCenter();
		Event event = createMouseEvent(p.x, p.y, 1, SWT.NONE, 1);
		event.type = SWT.MouseDown;
		event.widget = control;
		control.notifyListeners(SWT.MouseDown, event);

		event.type = SWT.MouseUp;
		control.notifyListeners(SWT.MouseUp, event);
		return p;
	}

	private void clickMenuItem(DurationConstraintEditPart dc, Point p, String itemText) {
		// show menu
		Control control = dc.getViewer().getControl();
		Menu menu = control.getMenu();
		Event event = createEvent();
		event.widget = control;
		event.x = p.x;
		event.y = p.y;
		menu.notifyListeners(SWT.Show, event);
		menu.setVisible(true);
		MenuItem[] items = menu.getItems();
		for(MenuItem it : items)
			if(it.getText().toLowerCase().contains(itemText)) {
				Event e = createEvent();
				e.widget = it;

				it.notifyListeners(SWT.Selection, e);
			}
		menu.notifyListeners(SWT.Hide, event);
		menu.setVisible(false);
		waitForComplete();
	}

	private int getBorderSides(DurationConstraintEditPart dc) {
		LinesBorder lb = (LinesBorder)dc.getPrimaryShape().getBorder();
		return lb.getSides();
	}

	private Point getAnchorPoint(DurationConstraintEditPart dc, CommentAnnotatedElementEditPart linkPart) {
		ConnectionAnchor anchor = dc.getSourceConnectionAnchor(linkPart);
		Point connectPoint = anchor.getLocation(anchor.getReferencePoint());
		return connectPoint;
	}

	@Test
	// test property view of duration link 
	public void testDurationLinkProperty() {
		LifelineEditPart lifeline = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(200, 100), null);
		assertNotNull(lifeline);
		AbstractExecutionSpecificationEditPart es = createExecutionSpecification(lifeline, new Point(231, 150), null);
		assertNotNull(es);

		DurationConstraintEditPart dc = (DurationConstraintEditPart)createNode(UMLElementTypes.DurationConstraint_3021, getRootEditPart(), new Point(400, 200), null);
		assertNotNull(dc);

		//start connection
		Point fromLocation = getAbsoluteBounds(dc).getTop();
		Point toLocation = getAbsoluteBounds(es).getTop();
		CommentAnnotatedElementEditPart linkPart = createDurationLink(dc, fromLocation, toLocation);
		assertTrue(dc.getSourceConnections().size() == 1);

		Control control = openPropertyView(linkPart);
		Button automatic = (Button)getControl((Composite)control, Button.class, "Automatic", SWT.RADIO);
		assertNotNull("Could not found router in Properties: ", automatic);
		assertTrue("Automatic router selected", automatic.getSelection());

		Button manual = (Button)getControl((Composite)control, Button.class, "Manual", SWT.RADIO);
		assertNotNull("Could not found router in Properties: ", manual);
		assertFalse("Manual router selected", manual.getSelection());

		PolylineConnection conn = (PolylineConnection)linkPart.getFigure();
		assertTrue("Automatic Router Connection Points", conn.getPoints().size() == 3);
		selectRadio(manual, true); // switch to manual router
		assertTrue("Manual Router Connection Points", conn.getPoints().size() == 2);
	}

	public void selectRadio(Button button, boolean value) {
		button.setSelection(value);
		Event event = new Event();
		event.button = 1;
		event.widget = button;
		event.type = SWT.Selection;
		button.notifyListeners(SWT.Selection, event);
		waitForComplete();
	}

	public Control openPropertyView(EditPart linkPart) {
		try {
			IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			PropertySheet propertySheet = (PropertySheet)activePage.showView(IPageLayout.ID_PROP_SHEET);
			IEditorPart activeEditor = activePage.getActiveEditor();
			propertySheet.partActivated(activeEditor);
			waitForComplete();
			activeEditor.getEditorSite().getSelectionProvider().setSelection(new StructuredSelection(linkPart));
			waitForComplete();
			IPage currentPage = propertySheet.getCurrentPage();
			assertTrue(currentPage instanceof TabbedPropertySheetPage);
			waitForComplete();
			TabbedPropertySheetPage page = (TabbedPropertySheetPage)currentPage;
			//force select the operand
			page.selectionChanged(activePage.getActiveEditor(), new StructuredSelection(linkPart));
			waitForComplete();
			page.setSelectedTab("appearance");
			waitForComplete();
			ITabDescriptor selectedTab = page.getSelectedTab();
			assertNotNull(selectedTab);
			assertEquals("appearance", selectedTab.getId());
			waitForComplete();

			waitForComplete();
			Control control = page.getControl();
			assertNotNull(control);
			return control;
		} catch (Exception e) {
			fail("Could not open Property Sheet View: " + e.getMessage());
		}
		return null;
	}

	private Control getControl(Composite parent, Class<?> controlType, String name, int style) {
		if(parent == null || parent.isDisposed()) {
			return null;
		}
		for(Control child : parent.getChildren()) {
			if(child.getClass() == controlType) {
				if(child instanceof Group && name.equals(((Group)child).getText())) {
					return child;
				}
				if(child instanceof Button && name.equals(((Button)child).getText()) && ((style & child.getStyle())) != 0) {
					return child;
				}
			} else if(child instanceof Composite) {
				Control control = getControl((Composite)child, controlType, name, style);
				if(control != null) {
					return control;
				}
			}
		}
		return null;
	}

	@Test
	public void testDurationRotate() {
		DurationConstraintEditPart dc = (DurationConstraintEditPart)createNode(UMLElementTypes.DurationConstraint_3021, getRootEditPart(), new Point(400, 200), null);
		assertNotNull(dc);
		assertTrue(CREATION + TEST_THE_EXECUTION, getRootEditPart().getChildren().size() == 1);
		assertTrue(CREATION + TEST_THE_EXECUTION, getBorderSides(dc) == (PositionConstants.TOP | PositionConstants.BOTTOM));

		Rectangle before = getAbsoluteBounds(dc);
		Point p = selectEditpart(dc);
		clickMenuItem(dc, p, "rotate");
		Rectangle after = getAbsoluteBounds(dc);

		assertTrue("TEST_THE_EXECUTION", before.width == after.height);
		assertTrue("TEST_THE_EXECUTION", before.height == after.width);
		assertTrue("TEST_THE_EXECUTION", getBorderSides(dc) == (PositionConstants.LEFT | PositionConstants.RIGHT));

		// undo
		assertTrue(TEST_THE_UNDO, getEMFCommandStack().canUndo());
		getEMFCommandStack().undo();
		Rectangle bounds = getAbsoluteBounds(dc);
		assertTrue(TEST_THE_UNDO, before.equals(bounds));

		// redo
		assertTrue(CREATION + TEST_THE_REDO, getEMFCommandStack().canRedo());
		getEMFCommandStack().redo();
		bounds = getAbsoluteBounds(dc);
		assertTrue(CREATION + TEST_THE_REDO, after.equals(bounds));

		// rotate again, should be same as before
		p = selectEditpart(dc);
		clickMenuItem(dc, p, "rotate");
		after = getAbsoluteBounds(dc);
		assertTrue("TEST_THE_EXECUTION", before.width == after.width);
		assertTrue("TEST_THE_EXECUTION", before.height == after.height);
		assertTrue("TEST_THE_EXECUTION", getBorderSides(dc) == (PositionConstants.TOP | PositionConstants.BOTTOM));
	}

	@Test
	public void testDurationCreation() {
		DurationConstraintEditPart dc = (DurationConstraintEditPart)createNode(UMLElementTypes.DurationConstraint_3021, getRootEditPart(), new Point(400, 200), null);
		assertNotNull(dc);
		assertTrue(CREATION + TEST_THE_EXECUTION, getRootEditPart().getChildren().size() == 1);

		// undo
		assertTrue(CREATION + TEST_THE_UNDO, getEMFCommandStack().canUndo());
		getEMFCommandStack().undo();
		assertTrue(CREATION + TEST_THE_UNDO, getRootEditPart().getChildren().size() == 0);

		// redo
		assertTrue(CREATION + TEST_THE_REDO, getEMFCommandStack().canRedo());
		getEMFCommandStack().redo();
		assertTrue(CREATION + TEST_THE_REDO, getRootEditPart().getChildren().size() == 1);
	}

	@Test
	public void testDurationMoveResize() {
		// test move			
		DurationConstraintEditPart dc = (DurationConstraintEditPart)createNode(UMLElementTypes.DurationConstraint_3021, getRootEditPart(), new Point(400, 200), null);
		assertNotNull(dc);
		moveEditPart(dc, new Point(50, 0));
		moveEditPart(dc, new Point(-20, 0));

		// test resize
		int move = 30;
		DurationConstraintEditPart dc2 = (DurationConstraintEditPart)createNode(UMLElementTypes.DurationConstraint_3021, getRootEditPart(), new Point(200, 100), null);
		assertNotNull(dc2);
		resize(dc2, getAbsoluteBounds(dc2).getLocation(), PositionConstants.NORTH, new Dimension(0, move));
		resize(dc2, getAbsoluteBounds(dc2).getLocation(), PositionConstants.SOUTH, new Dimension(0, move));
		waitForComplete();

		DurationConstraintEditPart dc3 = (DurationConstraintEditPart)createNode(UMLElementTypes.DurationConstraint_3021, getRootEditPart(), new Point(300, 300), null);
		assertNotNull(dc3);
		resize(dc3, getAbsoluteBounds(dc3).getLocation(), PositionConstants.WEST, new Dimension(move, 0));
		resize(dc3, getAbsoluteBounds(dc3).getLocation(), PositionConstants.EAST, new Dimension(move, 0));
	}

	@Test
	// test direct edit of duration expression
	public void testDurationEditExpr() {
		DurationConstraintEditPart dp = (DurationConstraintEditPart)createNode(UMLElementTypes.DurationConstraint_3021, getRootEditPart(), new Point(400, 200), null);
		assertNotNull(dp);

		// edit text
		WrappingLabel label = verifyEditText(dp, "1s", "2s");
		assertTrue(EDIT + TEST_THE_EXECUTION, label.getText().contains("1s..2s"));

		label = verifyEditText(dp, "d", "d+3");
		assertTrue(EDIT + TEST_THE_EXECUTION, label.getText().contains("d..d+3"));

		getEMFCommandStack().undo();
		assertTrue(EDIT + TEST_THE_UNDO, label.getText().contains("1s..2s"));

		label = verifyEditText(dp, "1", "1"); // same value which will only display one
		assertTrue(EDIT + TEST_THE_EXECUTION, label.getText().contains("1") && !label.getText().contains(SEP));
	}

	@Test
	// link to the top and bottom of execution specification on the single lifeline
	public void testLinkingExecutionOnSameLifeline() {
		LifelineEditPart lifeline = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(200, 100), null);
		assertNotNull(lifeline);
		AbstractExecutionSpecificationEditPart es = createExecutionSpecification(lifeline, new Point(231, 150), null);
		assertNotNull(es);

		DurationConstraintEditPart dc = (DurationConstraintEditPart)createNode(UMLElementTypes.DurationConstraint_3021, getRootEditPart(), new Point(400, 200), null);
		assertNotNull(dc);
		//start connection
		{
			Point fromLocation = getAbsoluteBounds(dc).getTop();
			Point toLocation = getAbsoluteBounds(es).getTop();
			CommentAnnotatedElementEditPart linkPart = createDurationLink(dc, fromLocation, toLocation);
			assertTrue(dc.getSourceConnections().size() == 1);
			EditPart target = linkPart.getTarget();
			assertTrue("the target is not a ExecutionSpecificationEndEditPart", target instanceof ExecutionSpecificationEndEditPart);
			OccurrenceSpecification start = (OccurrenceSpecification)((ExecutionSpecificationEndEditPart)target).getNotationView().getElement();
			assertTrue("the target is not start end", start.getName().contains("ActionExecSpecStart"));
			DurationConstraint constraint = (DurationConstraint)dc.getNotationView().getElement();
			assertTrue("constraint elements count", constraint.getConstrainedElements().size() == 1);
			assertTrue("constraint element ", constraint.getConstrainedElements().contains(start));

			// check anchor position
			Point connectPoint = getAnchorPoint(dc, linkPart);
			assertTrue("anchor is not at center", connectPoint.getDistance(getAbsoluteBounds(dc).getTopLeft()) == connectPoint.getDistance(getAbsoluteBounds(dc).getTopRight()));
		}

		{
			Point fromLocation = getAbsoluteBounds(dc).getBottom();
			Point toLocation = getAbsoluteBounds(es).getBottom();
			CommentAnnotatedElementEditPart linkPart = createDurationLink(dc, fromLocation, toLocation);
			assertTrue(dc.getSourceConnections().size() == 2);
			EditPart target = linkPart.getTarget();
			assertTrue("the target is not a ExecutionSpecificationEndEditPart", target instanceof ExecutionSpecificationEndEditPart);
			OccurrenceSpecification end = (OccurrenceSpecification)((ExecutionSpecificationEndEditPart)target).getNotationView().getElement();
			assertTrue("the target is not finish end", end.getName().contains("ActionExecSpecFinish"));

			DurationConstraint constraint = (DurationConstraint)dc.getNotationView().getElement();
			assertTrue("constraint elements count", constraint.getConstrainedElements().size() == 2);
			assertTrue("constraint element ", constraint.getConstrainedElements().contains(end));

			// check anchor position
			Point connectPoint = getAnchorPoint(dc, linkPart);
			assertTrue("anchor is not at center", connectPoint.getDistance(getAbsoluteBounds(dc).getBottomLeft()) == connectPoint.getDistance(getAbsoluteBounds(dc).getBottomRight()));
		}

		// test rotate and check link anchor position
		Point p = selectEditpart(dc);
		clickMenuItem(dc, p, "rotate");
		assertTrue("TEST_THE_EXECUTION", getBorderSides(dc) == (PositionConstants.LEFT | PositionConstants.RIGHT));

		CommentAnnotatedElementEditPart linkPart = (CommentAnnotatedElementEditPart)dc.getSourceConnections().get(0);
		Point connectPoint = getAnchorPoint(dc, linkPart);
		assertTrue("anchor is not at center", Math.abs(connectPoint.getDistance(getAbsoluteBounds(dc).getTopLeft()) - connectPoint.getDistance(getAbsoluteBounds(dc).getBottomLeft())) <= 2);
		CommentAnnotatedElementEditPart linkPart2 = (CommentAnnotatedElementEditPart)dc.getSourceConnections().get(1);
		connectPoint = getAnchorPoint(dc, linkPart2);
		assertTrue("anchor is not at center", Math.abs(connectPoint.getDistance(getAbsoluteBounds(dc).getTopRight()) - connectPoint.getDistance(getAbsoluteBounds(dc).getBottomRight())) <= 2);
	}

	@Test
	// link to different execution specification on two lifeline
	public void testLinkingExecutionOnTwoLifeline() {
		LifelineEditPart lifeline1 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(200, 100), null);
		assertNotNull(lifeline1);
		AbstractExecutionSpecificationEditPart es1 = createExecutionSpecification(lifeline1, new Point(231, 150), null);
		assertNotNull(es1);

		LifelineEditPart lifeline2 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(400, 100), null);
		assertNotNull(lifeline2);
		AbstractExecutionSpecificationEditPart es2 = createExecutionSpecification(lifeline2, new Point(431, 150), null);
		assertNotNull(es2);

		DurationConstraintEditPart dc = (DurationConstraintEditPart)createNode(UMLElementTypes.DurationConstraint_3021, getRootEditPart(), new Point(350, 150), null);
		assertNotNull(dc);

		Point fromLocation = getAbsoluteBounds(dc).getTop();
		Point toLocation = getAbsoluteBounds(es1).getTop();
		//start connection
		CommentAnnotatedElementEditPart linkPart = createDurationLink(dc, fromLocation, toLocation);
		assertTrue(dc.getSourceConnections().size() == 1);
		EditPart target = linkPart.getTarget();
		assertTrue("the target is not a ExecutionSpecificationEndEditPart", target instanceof ExecutionSpecificationEndEditPart);
		OccurrenceSpecification os = (OccurrenceSpecification)((ExecutionSpecificationEndEditPart)target).getNotationView().getElement();
		assertTrue("the target is not start end", os.getName().contains("Start"));

		fromLocation = getAbsoluteBounds(dc).getBottom();
		toLocation = getAbsoluteBounds(es2).getBottom();
		linkPart = createDurationLink(dc, fromLocation, toLocation);
		assertTrue(dc.getSourceConnections().size() == 2);
		target = linkPart.getTarget();
		assertTrue("the target is not a ExecutionSpecificationEndEditPart", target instanceof ExecutionSpecificationEndEditPart);
		os = (OccurrenceSpecification)((ExecutionSpecificationEndEditPart)target).getNotationView().getElement();
		assertTrue("the target is not finish end", os.getName().contains("Finish"));
	}

	// link to different messages on two lifeline
	@Test
	public void testLinkingMessageOnTwoLifeline() {
		LifelineEditPart lifeline1 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(200, 80), null);
		assertNotNull(lifeline1);

		LifelineEditPart lifeline2 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(400, 80), null);
		assertNotNull(lifeline2);

		DurationConstraintEditPart dc = (DurationConstraintEditPart)createNode(UMLElementTypes.DurationConstraint_3021, getRootEditPart(), new Point(300, 150), null);
		assertNotNull(dc);
		waitForComplete();

		int offset = 40;
		Point fromLocation = getAbsoluteBounds(lifeline1).getCenter().translate(0, -offset);
		Point toLocation = getAbsoluteBounds(lifeline2).getCenter().translate(0, -offset);
		createConnection(lifeline1.getViewer(), fromLocation, toLocation);

		fromLocation = getAbsoluteBounds(lifeline1).getCenter().translate(0, offset);
		toLocation = getAbsoluteBounds(lifeline2).getCenter().translate(0, offset);
		createConnection(lifeline1.getViewer(), fromLocation, toLocation);

		{ // link duration top
			fromLocation = getAbsoluteBounds(dc).getTop();
			toLocation = getAbsoluteBounds(lifeline1).getCenter().translate(0, -offset);
			CommentAnnotatedElementEditPart linkPart = createDurationLink(dc, fromLocation, toLocation);
			assertTrue(dc.getSourceConnections().size() == 1); // increase link count

			EditPart target = linkPart.getTarget();
			assertTrue("the target is not a MessageEndEditPart", target instanceof MessageEndEditPart);
			MessageEnd end2 = (MessageEnd)((MessageEndEditPart)target).getNotationView().getElement();
			assertTrue("the target is not send end", end2.getName().contains("Send"));
		}

		{ // link duration bottom
			fromLocation = getAbsoluteBounds(dc).getBottom();
			toLocation = getAbsoluteBounds(lifeline2).getCenter().translate(0, offset);
			CommentAnnotatedElementEditPart linkPart = createDurationLink(dc, fromLocation, toLocation);
			assertTrue(dc.getSourceConnections().size() == 2); // increase link count

			EditPart target = linkPart.getTarget();
			assertTrue("the target is not a MessageEndEditPart", target instanceof MessageEndEditPart);
			MessageEnd end2 = (MessageEnd)((MessageEndEditPart)target).getNotationView().getElement();
			assertTrue("the target is not receive end", end2.getName().contains("Recv"));
		}
	}

	@Test
	// duration link to message and execution 
	public void testLinkingExecutionMessageOnTwoLifeline() {
		LifelineEditPart lifeline1 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(200, 80), null);
		assertNotNull(lifeline1);

		LifelineEditPart lifeline2 = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(400, 80), null);
		assertNotNull(lifeline2);

		DurationConstraintEditPart dc = (DurationConstraintEditPart)createNode(UMLElementTypes.DurationConstraint_3021, getRootEditPart(), new Point(300, 150), null);
		assertNotNull(dc);
		waitForComplete();

		int offset = 40;
		Point fromLocation = getAbsoluteBounds(lifeline1).getCenter().translate(0, -offset);
		Point toLocation = getAbsoluteBounds(lifeline2).getCenter().translate(0, -offset);
		createConnection(lifeline1.getViewer(), fromLocation, toLocation);

		AbstractExecutionSpecificationEditPart es = createExecutionSpecification(lifeline2, new Point(231, 150), null);
		assertNotNull(es);

		{ // link duration top
			fromLocation = getAbsoluteBounds(dc).getTop();
			toLocation = getAbsoluteBounds(lifeline1).getCenter().translate(0, -offset);
			CommentAnnotatedElementEditPart linkPart = createDurationLink(dc, fromLocation, toLocation);
			assertTrue(dc.getSourceConnections().size() == 1); // increase link count

			EditPart target = linkPart.getTarget();
			assertTrue("the target is not a MessageEndEditPart", target instanceof MessageEndEditPart);
			MessageEnd end2 = (MessageEnd)((MessageEndEditPart)target).getNotationView().getElement();
			assertTrue("the target is not send end", end2.getName().contains("Send"));
		}

		fromLocation = getAbsoluteBounds(dc).getBottom();
		toLocation = getAbsoluteBounds(es).getBottom();
		CommentAnnotatedElementEditPart linkPart = createDurationLink(dc, fromLocation, toLocation);
		assertTrue(dc.getSourceConnections().size() == 2);
		EditPart target = linkPart.getTarget();
		assertTrue("the target is not a ExecutionSpecificationEndEditPart", target instanceof ExecutionSpecificationEndEditPart);
		OccurrenceSpecification os = (OccurrenceSpecification)((ExecutionSpecificationEndEditPart)target).getNotationView().getElement();
		assertTrue("the target is not finish end", os.getName().contains("Finish"));
	}

	private void createConnection(EditPartViewer viewer, Point fromLocation, Point toLocation) {
		EditPart sourceEditPart = null;
		EditPart targetEditPart = null;
		CreateConnectionViewRequest request = CreateViewRequestFactory.getCreateConnectionRequest(UMLElementTypes.Message_4004, ((IGraphicalEditPart)getDiagramEditPart()).getDiagramPreferencesHint());
		assertNotNull(request);
		request.setLocation(fromLocation);
		request.setType(RequestConstants.REQ_CONNECTION_START);
		sourceEditPart = viewer.findObjectAtExcluding(fromLocation, Collections.emptySet(), getTargetingConditional(request));
		assertNotNull(sourceEditPart);
		request.setSourceEditPart(sourceEditPart);
		request.setTargetEditPart(sourceEditPart);
		Command command = sourceEditPart.getCommand(request);
		assertNotNull(COMMAND_NULL, command);
		//connect...

		request.setLocation(toLocation);
		request.setType(RequestConstants.REQ_CONNECTION_END);
		targetEditPart = sourceEditPart.getViewer().findObjectAtExcluding(toLocation, Collections.emptySet(), getTargetingConditional(request));
		assertNotNull(targetEditPart);
		request.setTargetEditPart(targetEditPart);
		targetEditPart.getCommand(request); // link by hand will call this method many times
		waitForComplete();
		command = targetEditPart.getCommand(request);
		assertNotNull(COMMAND_NULL, command);

		assertTrue(command.canExecute());
		getDiagramCommandStack().execute(command);
		waitForComplete();
	}

	private CommentAnnotatedElementEditPart createDurationLink(DurationConstraintEditPart dc, Point fromLocation, Point toLocation) {
		EditPart sourceEditPart = dc;
		EditPart targetEditPart = null;
		CreateConnectionViewRequest request = CreateViewRequestFactory.getCreateConnectionRequest(UMLElementTypes.CommentAnnotatedElement_4010, ((IGraphicalEditPart)getDiagramEditPart()).getDiagramPreferencesHint());
		assertNotNull(request);
		request.setLocation(fromLocation);
		request.setType(REQ_ANNOTATED_LINK_START);
		assertNotNull(sourceEditPart);
		request.setSourceEditPart(sourceEditPart);
		request.setTargetEditPart(sourceEditPart);
		Command command = sourceEditPart.getCommand(request);
		assertNotNull(COMMAND_NULL, command);
		//connect...
		request.setLocation(toLocation);
		request.setType(REQ_ANNOTATED_LINK_END);
		targetEditPart = sourceEditPart.getViewer().findObjectAtExcluding(toLocation, Collections.emptySet(), getTargetingConditional(request));
		assertNotNull(targetEditPart);
		request.setTargetEditPart(targetEditPart);
		command = targetEditPart.getCommand(request);

		int connectionCount = dc.getSourceConnections().size();
		assertNotNull(COMMAND_NULL, command);
		assertTrue(command.canExecute());
		getDiagramCommandStack().execute(command);
		waitForComplete();
		assertTrue(connectionCount + 1 == dc.getSourceConnections().size()); // connection increase
		// undo
		getDiagramCommandStack().undo();
		assertTrue(connectionCount == dc.getSourceConnections().size());
		// redo
		getDiagramCommandStack().redo();
		assertTrue(connectionCount + 1 == dc.getSourceConnections().size());

		//check result
		View view = (View)request.getConnectionViewDescriptor().getAdapter(View.class);
		assertNotNull("view not found", view);
		EditPart editPart = (EditPart)targetEditPart.getViewer().getEditPartRegistry().get(view);
		assertNotNull("editpart not found", editPart);
		assertTrue("not a CommentAnnotatedElementEditPart", editPart instanceof CommentAnnotatedElementEditPart);

		return (CommentAnnotatedElementEditPart)editPart;
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

	public WrappingLabel performEditRequest(LabelEditPart lp) {
		WrappingLabel label = (WrappingLabel)lp.getFigure();
		Rectangle b = label.getBounds().getCopy();
		label.translateToAbsolute(b);
		DirectEditRequest req = new DirectEditRequest();
		req.setLocation(b.getCenter());
		lp.performRequest(req);
		return label;
	}

	public Text findEditor(Composite composite, WrappingLabel label) {
		for(Control c : composite.getChildren()) {
			if(c instanceof Text) {
				if(label.getText().equals(((Text)c).getText())) {
					return (Text)c;
				}
			}
		}
		return null;
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

	public Event createKeyEvent(Widget widget, int keyCode, char character) {
		Event event = new Event();
		event.time = (int)System.currentTimeMillis();
		event.widget = widget;
		event.display = Display.getDefault();
		event.keyCode = keyCode;
		event.character = character;
		return event;
	}


	private AbstractExecutionSpecificationEditPart createExecutionSpecification(LifelineEditPart lifeline, Point location, Dimension size) {
		return (AbstractExecutionSpecificationEditPart)createNode(UMLElementTypes.ActionExecutionSpecification_3006, lifeline, location, size);
	}

	protected void moveEditPart(IGraphicalEditPart lifelineEP, Point moveDelta) {
		ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
		req.setResizeDirection(moveDelta.x > 0 ? PositionConstants.EAST : PositionConstants.WEST);
		req.setLocation(getAbsoluteCenter(lifelineEP));
		req.setEditParts(lifelineEP);
		req.setMoveDelta(moveDelta);

		Command command = lifelineEP.getCommand(req);
		assertNotNull(MOVE + COMMAND_NULL, command);
		assertTrue(MOVE + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		Rectangle before = getAbsoluteBounds(lifelineEP);
		getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(command));
		waitForComplete();

		Rectangle after = getAbsoluteBounds(lifelineEP);
		assertTrue(MOVE + TEST_THE_EXECUTION, after.x() - before.x() == moveDelta.x);
		assertTrue(MOVE + TEST_THE_EXECUTION, after.y() - before.y() == moveDelta.y);

		getEMFCommandStack().undo(); // undo move
		waitForComplete();
		assertTrue(MOVE + TEST_THE_UNDO, before.equals(getAbsoluteBounds(lifelineEP)));

		getEMFCommandStack().redo(); // redo move
		waitForComplete();
		assertTrue(MOVE + TEST_THE_REDO, after.equals(getAbsoluteBounds(lifelineEP)));
	}

	protected EditPartViewer.Conditional getTargetingConditional(final Request req) {
		return new EditPartViewer.Conditional() {

			public boolean evaluate(EditPart editpart) {
				return editpart.getTargetEditPart(req) != null;
			}
		};
	}
}
