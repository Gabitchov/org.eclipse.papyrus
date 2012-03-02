package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Cursors;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Handle;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.handles.MoveHandleLocator;
import org.eclipse.gef.handles.RelativeHandleLocator;
import org.eclipse.gef.handles.ResizeHandle;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.tools.ResizeTracker;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableEditPolicyEx;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart.LifelineFigure;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
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
	
	protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
		IFigure feedback = getDragSourceFeedbackFigure();

		PrecisionRectangle rect = new PrecisionRectangle(
				getInitialFeedbackBounds().getCopy());
		getHostFigure().translateToAbsolute(rect);
		
		//Only enable horizontal dragging on lifelines(except lifelines that are result of a create message). 
		//https://bugs.eclipse.org/bugs/show_bug.cgi?id=364688
		if (this.getHost() instanceof LifelineEditPart) {
			LifelineEditPart lifelineEP = (LifelineEditPart) this.getHost();
			if (!SequenceUtil.isCreateMessageEndLifeline(lifelineEP)) {
				request.getMoveDelta().y = 0;
			}
		}
		
		rect.translate(request.getMoveDelta());
		rect.resize(request.getSizeDelta());

		IFigure f = getHostFigure();
		Dimension min = f.getMinimumSize().getCopy();
		Dimension max = f.getMaximumSize().getCopy();
		IMapMode mmode = MapModeUtil.getMapMode(f);
		min.height = mmode.LPtoDP(min.height);
		min.width = mmode.LPtoDP(min.width);
		max.height = mmode.LPtoDP(max.height);
		max.width = mmode.LPtoDP(max.width);

		if (min.width > rect.width)
			rect.width = min.width;
		else if (max.width < rect.width)
			rect.width = max.width;

		if (min.height > rect.height)
			rect.height = min.height;
		else if (max.height < rect.height)
			rect.height = max.height;

		feedback.translateToRelative(rect);
		feedback.setBounds(rect);
	}

}
