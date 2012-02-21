package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Cursors;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Handle;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.handles.MoveHandleLocator;
import org.eclipse.gef.handles.RelativeHandleLocator;
import org.eclipse.gef.handles.ResizeHandle;
import org.eclipse.gef.tools.ResizeTracker;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableEditPolicyEx;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart.LifelineFigure;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;

public class LifelineSelectionEditPolicy extends ResizableEditPolicyEx {

	public LifelineSelectionEditPolicy() {
		setResizeDirections(PositionConstants.NORTH | PositionConstants.SOUTH | PositionConstants.WEST | PositionConstants.EAST);
	}

	protected List<?> createSelectionHandles() {
		final LifelineEditPart host = (LifelineEditPart) getHost();
		final LifelineFigure primaryShape = host.getPrimaryShape();
		// resizable in at least one direction
		List<Handle> list = new ArrayList<Handle>();
		// createMoveHandle(list);
		Locator locator = new MoveHandleLocator(
				primaryShape.getFigureLifelineNameContainerFigure());
		MoveHandle moveHandle = new MoveHandle((GraphicalEditPart) getHost(),
				locator);
		moveHandle.setCursor(Cursors.SIZEALL);
		list.add(moveHandle);

		createResizeHandle(list, PositionConstants.NORTH);
		final RectangleFigure fig = primaryShape
				.getFigureLifelineNameContainerFigure();

		createResizeHandle(host, list, fig,PositionConstants.WEST);
		createResizeHandle(host, list, fig,PositionConstants.EAST);

		createResizeHandle(list, PositionConstants.SOUTH);
		return list;
	}

	private void createResizeHandle(LifelineEditPart host, List<Handle> list,
			RectangleFigure fig, int location) {
		Locator locator = new RelativeHandleLocator(fig, location);
		Cursor cursor = Cursors
				.getDirectionalCursor(location, fig.isMirrored());
		ResizeHandle westResizer = new ResizeHandle((GraphicalEditPart) host,
				locator, cursor);
		ResizeTracker resizeTracker = new ResizeTracker(host, location);
		westResizer.setDragTracker(resizeTracker);
		list.add(westResizer);
	}

}
