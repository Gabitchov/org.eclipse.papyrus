package org.eclipse.papyrus.uml.diagram.sequence.tests.bug;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentCombinedFragmentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestTopNode;
import org.junit.Test;

/**
 * Adding of operands is allowed, but it is not possible to delete an operand
 * from a combined fragment. Moreover, the resize of operands is also not
 * possible. https://bugs.eclipse.org/bugs/show_bug.cgi?id=364701
 * 
 */
public class TestCombinedFragmentOperand_364701 extends TestTopNode {

	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateSequenceDiagramCommand();
	}

	@Test
	public void testOperandAddDelete() {
		final CombinedFragmentCombinedFragmentCompartmentEditPart cfp = setupCombinedFragment();

		// add operand
		{
			createNode(UMLElementTypes.InteractionOperand_3005, cfp, new Point(
					50, 100), new Dimension(100, 100));
			assertTrue(CREATION + TEST_THE_EXECUTION,
					cfp.getChildren().size() == 2);

			getDiagramCommandStack().undo();
			assertTrue(CREATION + TEST_THE_UNDO, cfp.getChildren().size() == 1);

			getDiagramCommandStack().redo();
			assertTrue(CREATION + TEST_THE_REDO, cfp.getChildren().size() == 2);
		}

		// delete operand
		{
			InteractionOperandEditPart op = (InteractionOperandEditPart) cfp
					.getChildren().get(0);
			deleteEditPart(op);
			assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, cfp.getChildren()
					.size() == 1);

			getEMFCommandStack().undo();
			assertTrue(DESTROY_DELETION + TEST_THE_UNDO, cfp.getChildren()
					.size() == 2);

			getEMFCommandStack().redo();
			assertTrue(DESTROY_DELETION + TEST_THE_REDO, cfp.getChildren()
					.size() == 1);
		}
	}

	private CombinedFragmentCombinedFragmentCompartmentEditPart setupCombinedFragment() {
		createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(),
				new Point(30, 80), new Dimension(100, 100));
		CombinedFragmentEditPart cep = (CombinedFragmentEditPart) getRootEditPart()
				.getChildren().get(0);
		final CombinedFragmentCombinedFragmentCompartmentEditPart cfp = (CombinedFragmentCombinedFragmentCompartmentEditPart) cep
				.getChildren().get(0);
		assertTrue(CREATION + INITIALIZATION_TEST,
				cfp.getChildren().size() == 1);
		return cfp;
	}

	@Test
	public void testOperandResizeHeight() {
		final CombinedFragmentCombinedFragmentCompartmentEditPart cfp = setupCombinedFragment();
		waitForComplete();
		InteractionOperandEditPart op = (InteractionOperandEditPart) cfp
				.getChildren().get(0);

		// resize operand north
		{
			Dimension deltaSize = new Dimension(0, 30);
			Rectangle before = getAbsoluteBounds(op);
			assertTrue("Operand height: ",
					before.height() == getAbsoluteBounds(cfp).height());
			resizeNorth(op, deltaSize);
			Rectangle after = getAbsoluteBounds(op);
			assertTrue("Operand height: ",
					after.height() == getAbsoluteBounds(cfp).height());
			assertTrue("Operand deltaX: ",
					after.width() - before.width() == deltaSize.width());
			assertTrue("Operand deltaY: ",
					after.height() - before.height() == deltaSize.height());
		}

		// resize operand south
		{
			Rectangle before = getAbsoluteBounds(op);
			Dimension deltaSize = new Dimension(0, 20);
			resizeSouth(op, deltaSize);
			Rectangle after = getAbsoluteBounds(op);
			assertTrue("Operand height: ",
					after.height() == getAbsoluteBounds(cfp).height());
			assertTrue("Operand deltaX: ",
					after.width() - before.width() == deltaSize.width());
			assertTrue("Operand deltaY: ",
					after.height() - before.height() == deltaSize.height());
		}

		// resize operand north
		{
			Dimension deltaSize = new Dimension(0, -20);
			Rectangle before = getAbsoluteBounds(op);
			assertTrue("Operand height: ",
					before.height() == getAbsoluteBounds(cfp).height());
			resizeNorth(op, deltaSize);
			Rectangle after = getAbsoluteBounds(op);
			assertTrue("Operand height: ",
					after.height() == getAbsoluteBounds(cfp).height());
			assertTrue("Operand deltaX: ",
					after.width() - before.width() == deltaSize.width());
			assertTrue("Operand deltaY: ",
					after.height() - before.height() == deltaSize.height());
		}

		// resize operand south
		{
			Rectangle before = getAbsoluteBounds(op);
			Dimension deltaSize = new Dimension(0, -20);
			resizeSouth(op, deltaSize);
			Rectangle after = getAbsoluteBounds(op);
			assertTrue("Operand height: ",
					after.height() == getAbsoluteBounds(cfp).height());
			assertTrue("Operand deltaX: ",
					after.width() - before.width() == deltaSize.width());
			assertTrue("Operand deltaY: ",
					after.height() - before.height() == deltaSize.height());
		}
	}

	@Test
	public void testOperandResizeWidth() {
		final CombinedFragmentCombinedFragmentCompartmentEditPart cfp = setupCombinedFragment();
		waitForComplete();
		InteractionOperandEditPart op = (InteractionOperandEditPart) cfp
				.getChildren().get(0);

		// resize operand east
		{
			Dimension deltaSize = new Dimension(100, 0);
			Rectangle before = getAbsoluteBounds(op);
			assertTrue("Operand width: ",
					before.width() == getAbsoluteBounds(cfp).width());
			resizeEast(op, deltaSize);
			Rectangle after = getAbsoluteBounds(op);
			assertTrue("Operand width: ",
					after.width() == getAbsoluteBounds(cfp).width());
			assertTrue("Operand deltaX: ",
					after.width() - before.width() == deltaSize.width());
			assertTrue("Operand deltaY: ",
					after.height() - before.height() == deltaSize.height());
		}

		// resize operand west
		{
			Rectangle before = getAbsoluteBounds(op);
			Dimension deltaSize = new Dimension(20, 0);
			resizeWest(op, deltaSize);
			Rectangle after = getAbsoluteBounds(op);
			assertTrue("Operand width: ",
					after.width() == getAbsoluteBounds(cfp).width());
			assertTrue("Operand deltaX: ",
					after.width() - before.width() == deltaSize.width());
			assertTrue("Operand deltaY: ",
					after.height() - before.height() == deltaSize.height());
		}

		// resize operand east
		{
			Dimension deltaSize = new Dimension(-20, 0);
			Rectangle before = getAbsoluteBounds(op);
			assertTrue("Operand width: ",
					before.width() == getAbsoluteBounds(cfp).width());
			resizeEast(op, deltaSize);
			Rectangle after = getAbsoluteBounds(op);
			assertTrue("Operand width: ",
					after.width() == getAbsoluteBounds(cfp).width());
			assertTrue("Operand deltaX: ",
					after.width() - before.width() == deltaSize.width());
			assertTrue("Operand deltaY: ",
					after.height() - before.height() == deltaSize.height());
		}

		// resize operand west
		{
			Dimension deltaSize = new Dimension(-20, 0);
			Rectangle before = getAbsoluteBounds(op);
			resizeWest(op, deltaSize);
			Rectangle after = getAbsoluteBounds(op);
			assertTrue("Operand width: ",
					after.width() == getAbsoluteBounds(cfp).width());
			assertTrue("Operand deltaX: ",
					after.width() - before.width() == deltaSize.width());
			assertTrue("Operand deltaY: ",
					after.height() - before.height() == deltaSize.height());
		}
	}

	protected void resizeEast(GraphicalEditPart op, Dimension deltaSize) {
		Point p = getRight(op);
		ChangeBoundsRequest req = new ChangeBoundsRequest(
				RequestConstants.REQ_RESIZE);
		req.setLocation(p);
		req.setEditParts(op);
		req.setResizeDirection(PositionConstants.EAST);
		req.setSizeDelta(deltaSize);
		Command c = op.getCommand(req);
		getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(c));
		waitForComplete();
	}

	protected void resizeWest(GraphicalEditPart op, Dimension deltaSize) {
		Point p = getLeft(op);
		ChangeBoundsRequest req = new ChangeBoundsRequest(
				RequestConstants.REQ_RESIZE);
		req.setLocation(p);
		req.setEditParts(op);
		req.setResizeDirection(PositionConstants.WEST);
		req.setSizeDelta(deltaSize);
		req.setMoveDelta(new Point(-deltaSize.width(), -deltaSize.height()));
		Command c = op.getCommand(req);
		getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(c));
		waitForComplete();
	}

	private void resizeSouth(GraphicalEditPart op, Dimension deltaSize) {
		Point p = getBottom(op);
		ChangeBoundsRequest req = new ChangeBoundsRequest(
				RequestConstants.REQ_RESIZE);
		req.setLocation(p);
		req.setEditParts(op);
		req.setResizeDirection(PositionConstants.SOUTH);
		req.setSizeDelta(deltaSize);
		Command c = op.getCommand(req);
		getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(c));
		waitForComplete();
	}

	private void resizeNorth(GraphicalEditPart op, Dimension deltaSize) {
		Point p = getTop(op);
		ChangeBoundsRequest req = new ChangeBoundsRequest(
				RequestConstants.REQ_RESIZE);
		req.setLocation(p);
		req.setEditParts(op);
		req.setResizeDirection(PositionConstants.NORTH);
		req.setSizeDelta(deltaSize);
		req.setMoveDelta(new Point(-deltaSize.width(), -deltaSize.height()));
		Command c = op.getCommand(req);
		getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(c));
		waitForComplete();
	}

	protected void deleteEditPart(EditPart op) {
		Request deleteViewRequest = new EditCommandRequestWrapper(
				new DestroyElementRequest(false));
		Command command = op.getCommand(deleteViewRequest);
		assertNotNull(DESTROY_DELETION + COMMAND_NULL, command);
		assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_IS_CREATED,
				command != UnexecutableCommand.INSTANCE);
		assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED,
				command.canExecute() == true);
		getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(command));
		waitForComplete();
	}

	public void createNode(IElementType type, EditPart parentPart,
			Point location, Dimension size) {
		// CREATION
		CreateViewRequest requestcreation = CreateViewRequestFactory
				.getCreateShapeRequest(type, getRootEditPart()
						.getDiagramPreferencesHint());
		requestcreation.setLocation(location);
		requestcreation.setSize(size);
		Command command = parentPart.getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED,
				command != UnexecutableCommand.INSTANCE);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED,
				command.canExecute() == true);

		getDiagramCommandStack().execute(command);
	}

	protected Point getRight(final GraphicalEditPart op) {
		IFigure f = op.getFigure();
		Rectangle b = f.getBounds().getCopy();
		f.translateToAbsolute(b);
		Point p = b.getRight();
		return p;
	}

	protected Point getLeft(final GraphicalEditPart op) {
		IFigure f = op.getFigure();
		Rectangle b = f.getBounds().getCopy();
		f.translateToAbsolute(b);
		Point p = b.getLeft();
		return p;
	}

	private Point getBottom(GraphicalEditPart op) {
		IFigure f = op.getFigure();
		Rectangle b = f.getBounds().getCopy();
		f.translateToAbsolute(b);
		Point p = b.getBottom();
		return p;
	}

	private Point getTop(GraphicalEditPart op) {
		IFigure f = op.getFigure();
		Rectangle b = f.getBounds().getCopy();
		f.translateToAbsolute(b);
		Point p = b.getTop();
		return p;
	}

}
