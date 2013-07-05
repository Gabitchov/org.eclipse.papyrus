package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Cursors;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Handle;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.handles.MoveHandleLocator;
import org.eclipse.gef.handles.RelativeHandleLocator;
import org.eclipse.gef.handles.ResizeHandle;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.tools.ResizeTracker;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableEditPolicyEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.figures.LifelineFigure;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;

public class LifelineSelectionEditPolicy extends ResizableEditPolicyEx {

	public LifelineSelectionEditPolicy() {
		setResizeDirections(PositionConstants.NORTH | PositionConstants.SOUTH | PositionConstants.WEST | PositionConstants.EAST);
	}

	protected List<?> createSelectionHandles() {
		final LifelineEditPart host = (LifelineEditPart)getHost();
		final LifelineFigure primaryShape = host.getPrimaryShape();
		// resizable in at least one direction
		List<Handle> list = new ArrayList<Handle>();
		// createMoveHandle(list);
		Locator locator = new MoveHandleLocator(primaryShape.getFigureLifelineNameContainerFigure());
		MoveHandle moveHandle = new MoveHandle((GraphicalEditPart)getHost(), locator);
		moveHandle.setCursor(Cursors.SIZEALL);
		list.add(moveHandle);
		createResizeHandle(list, PositionConstants.NORTH);
		final IFigure fig = primaryShape.getFigureLifelineNameContainerFigure();
		createResizeHandle(host, list, fig, PositionConstants.WEST);
		createResizeHandle(host, list, fig, PositionConstants.EAST);
		createResizeHandle(list, PositionConstants.SOUTH);
		return list;
	}

	private void createResizeHandle(LifelineEditPart host, List<Handle> list, IFigure fig, int location) {
		Locator locator = new RelativeHandleLocator(fig, location);
		Cursor cursor = Cursors.getDirectionalCursor(location, fig.isMirrored());
		ResizeHandle westResizer = new ResizeHandle((GraphicalEditPart)host, locator, cursor);
		ResizeTracker resizeTracker = new ResizeTracker(host, location);
		westResizer.setDragTracker(resizeTracker);
		list.add(westResizer);
	}

	protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
		IFigure feedback = getDragSourceFeedbackFigure();
		PrecisionRectangle rect = new PrecisionRectangle(getInitialFeedbackBounds().getCopy());
		getHostFigure().translateToAbsolute(rect);
		boolean skipMinSize = false;
		//Only enable horizontal dragging on lifelines(except lifelines that are result of a create message). 
		//https://bugs.eclipse.org/bugs/show_bug.cgi?id=364688
		if(this.getHost() instanceof LifelineEditPart) {
			skipMinSize = true;
			LifelineEditPart lifelineEP = (LifelineEditPart)this.getHost();
			if(!SequenceUtil.isCreateMessageEndLifeline(lifelineEP)) {
				request.getMoveDelta().y = 0;
			}
			//keepNameLabelBounds(lifelineEP, request, rect);
			// restrict child size within parent bounds
			keepInParentBounds(lifelineEP, request, rect);
			changeCombinedFragmentBounds(request, lifelineEP);
		}
		Point left = rect.getLeft();
		Point right = rect.getRight();
		rect.translate(request.getMoveDelta());
		rect.resize(request.getSizeDelta());
		IFigure f = getHostFigure();
		Dimension min = f.getMinimumSize().getCopy();
		Dimension max = f.getMaximumSize().getCopy();
		//		IMapMode mmode = MapModeUtil.getMapMode(f);
		//		min.height = mmode.LPtoDP(min.height);
		//		min.width = mmode.LPtoDP(min.width);
		//		max.height = mmode.LPtoDP(max.height);
		//		max.width = mmode.LPtoDP(max.width);
		getHostFigure().translateToAbsolute(min);
		getHostFigure().translateToAbsolute(max);
		// In manual mode, there is no minimal width, see https://bugs.eclipse.org/bugs/show_bug.cgi?id=383723
		if(min.width > rect.width && !skipMinSize) {
			if(request.getMoveDelta().x > 0 && request.getSizeDelta().width != 0) {
				rect.x = right.x - min.width;
				request.getMoveDelta().x = rect.x - left.x;
			}
			rect.width = min.width;
		} else if(max.width < rect.width)
			rect.width = max.width;
		if(min.height > rect.height)
			rect.height = min.height;
		else if(max.height < rect.height)
			rect.height = max.height;
		feedback.translateToRelative(rect);
		feedback.setBounds(rect);
	}

	private void keepNameLabelBounds(LifelineEditPart lifelineEP, ChangeBoundsRequest request, PrecisionRectangle rect) {
		PrecisionRectangle size = getMovedRectangle(rect, request);
		Dimension preferSize = lifelineEP.getPrimaryShape().getFigureLifelineNameContainerFigure().getPreferredSize(-1, -1).getCopy();
		getHostFigure().translateToAbsolute(preferSize); // handle scale size
		if(size.width < preferSize.width) {
			request.getSizeDelta().width = preferSize.width - rect.width;
			if(request.getMoveDelta().x > 0)
				request.getMoveDelta().x = rect.width - preferSize.width;
		}
	}

	protected Rectangle getCurrentConstraintFor(GraphicalEditPart child) {
		IFigure fig = child.getFigure();
		return (Rectangle)fig.getParent().getLayoutManager().getConstraint(fig);
	}

	private void keepInParentBounds(LifelineEditPart lifelineEP, ChangeBoundsRequest request, PrecisionRectangle rect) {
		if(lifelineEP.getParent() instanceof LifelineEditPart) {
			LifelineEditPart parent = (LifelineEditPart)lifelineEP.getParent();
			Rectangle p = parent.getFigure().getBounds().getCopy();
			parent.getFigure().translateToAbsolute(p);
			PrecisionRectangle c = getMovedRectangle(rect, request);
			Dimension preferSize = getHostFigure().getPreferredSize();
			getHostFigure().translateToAbsolute(preferSize); // handle scale size
			if(request.getType().equals(RequestConstants.REQ_RESIZE)) {
				switch(request.getResizeDirection()) {
				case PositionConstants.WEST:
					if(c.getLeft().x <= p.getLeft().x) { // exceed left edge
						int delta = (p.getLeft().x - c.getLeft().x);
						request.getMoveDelta().x += delta;
						request.getSizeDelta().width -= delta;
					}
					break;
				case PositionConstants.EAST:
					if(c.getRight().x + request.getSizeDelta().width >= p.getRight().x) { // exceed right edge
						int delta = (c.getRight().x - p.getRight().x);
						request.getSizeDelta().width -= delta;
					}
					break;
				}
			} else {
				if(c.getLeft().x <= p.getLeft().x) { // exceed left edge
					int delta = (p.getLeft().x - c.getLeft().x);
					request.getMoveDelta().x += delta;
				} else if(c.getRight().x >= p.getRight().x) { // exceed right edge
					int delta = (c.getRight().x - p.getRight().x);
					request.getMoveDelta().x -= delta;
				}
			}
			// check lifeline intersect with each other
			c = getMovedRectangle(rect, request);
			Rectangle other = getLifelineIntersectBounds(lifelineEP, parent, request, c);
			if(other != null) {
				if(request.getSizeDelta().width == 0) { // move only
					//Fixed bug about moving child lifelines, do NOT allow move out now.
					if(request.getMoveDelta().x > 0) { // move right
						if((p.right() - other.right()) > 0) {
							request.getMoveDelta().x = other.getRight().x - rect.getLeft().x;
						} else {
							request.getMoveDelta().x = 0;//no margin for moving
						}
					} else {
						if((other.x - p.x) > 0) {
							request.getMoveDelta().x = other.getLeft().x - rect.getRight().x;
						} else {
							request.getMoveDelta().x = 0;//no margin for moving
						}
					}
				} else {
					if(request.getMoveDelta().x == 0) { // resize right edge
						request.getSizeDelta().width = other.getLeft().x - rect.getRight().x;
					} else { // resize left edge
						request.getMoveDelta().x = other.getRight().x - rect.getLeft().x;
						request.getSizeDelta().width = -request.getMoveDelta().x;
					}
				}
			}
		}
	}

	private Rectangle getLifelineIntersectBounds(LifelineEditPart lifelineEP, LifelineEditPart parent, ChangeBoundsRequest request, PrecisionRectangle rect) {
		List children = parent.getChildren();
		for(Object o : children)
			if(o instanceof LifelineEditPart && o != lifelineEP) {
				LifelineEditPart p = (LifelineEditPart)o;
				Rectangle bounds = p.getFigure().getBounds().getCopy();
				p.getFigure().translateToAbsolute(bounds);
				if(bounds.intersects(rect)) {
					return bounds;
				}
			}
		return null;
	}

	private PrecisionRectangle getMovedRectangle(PrecisionRectangle rect, ChangeBoundsRequest request) {
		PrecisionRectangle c = rect.getPreciseCopy();
		c.translate(request.getMoveDelta());
		c.resize(request.getSizeDelta());
		return c;
	}

	private void changeCombinedFragmentBounds(ChangeBoundsRequest request, LifelineEditPart lifelineEP) {
		if(request.getMoveDelta().x > 0) // move right
			return;
		View shape = (View)lifelineEP.getModel();
		Lifeline element = (Lifeline)shape.getElement();
		EList<InteractionFragment> covereds = element.getCoveredBys();
		EditPart parent = lifelineEP.getParent();
		List<?> children = parent.getChildren();
		Rectangle bounds = lifelineEP.getFigure().getBounds().getCopy();
		bounds.translate(request.getMoveDelta());
		Point center = bounds.getCenter();
		for(Object obj : children) {
			if(obj instanceof CombinedFragmentEditPart) {
				CombinedFragmentEditPart et = (CombinedFragmentEditPart)obj;
				View sp = (View)et.getModel();
				if(!covereds.contains(sp.getElement())) {
					continue;
				}
				//If the center vertical line is covered by the CombibedFragment, do NOT move the CF again. 
				Rectangle rect = ((GraphicalEditPart)et).getFigure().getBounds();
				if(rect.x < center.x && rect.right() > center.x) {
					continue;
				}
				changeCombinedFragmentBounds(request, et, lifelineEP);
			}
		}
	}

	Point maxMoveDelta;

	@Override
	protected void eraseChangeBoundsFeedback(ChangeBoundsRequest request) {
		super.eraseChangeBoundsFeedback(request);
		maxMoveDelta = null;
	}

	void changeCombinedFragmentBounds(ChangeBoundsRequest request, CombinedFragmentEditPart cep, LifelineEditPart lifelineEP) {
		Rectangle rect = getTransformedRectangle(cep, request);
		if(rect.x <= 0) {
			if(maxMoveDelta != null)
				request.getMoveDelta().x = maxMoveDelta.x;
			else {
				Point p = new Point(Math.abs(rect.x), 0);
				cep.getFigure().translateToAbsolute(p);
				request.getMoveDelta().x = Math.min(0, request.getMoveDelta().x + p.x);
				maxMoveDelta = request.getMoveDelta().getCopy();
			}
		}
	}

	private Rectangle getTransformedRectangle(CombinedFragmentEditPart cep, ChangeBoundsRequest request) {
		Rectangle rect = new PrecisionRectangle(cep.getFigure().getBounds());
		cep.getFigure().translateToAbsolute(rect);
		rect = request.getTransformedRectangle(rect);
		cep.getFigure().translateToRelative(rect);
		return rect;
	}
}
