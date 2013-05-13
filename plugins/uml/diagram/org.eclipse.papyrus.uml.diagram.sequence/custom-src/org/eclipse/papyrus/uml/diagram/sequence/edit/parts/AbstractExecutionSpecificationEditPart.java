package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RelativeLocator;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.papyrus.infra.emf.appearance.helper.AppearanceHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IPapyrusNodeFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure;
import org.eclipse.papyrus.uml.diagram.sequence.edit.helpers.AnchorHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.LifelineXYLayoutEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.HighlightUtil;
import org.eclipse.papyrus.uml.diagram.sequence.util.LifelineEditPartUtil;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.UMLPackage;

public abstract class AbstractExecutionSpecificationEditPart extends ShapeNodeEditPart {

	private List executionSpecificationEndParts;

	public AbstractExecutionSpecificationEditPart(View view) {
		super(view);
	}

	@Override
	public List getChildren() {
		if(executionSpecificationEndParts == null) {
			initExecutionSpecificationEndEditPart();
		}
		return super.getChildren();
	}

	protected void initExecutionSpecificationEndEditPart() {
		executionSpecificationEndParts = new ArrayList();

		String id = String.valueOf(ExecutionSpecificationEndEditPart.VISUAL_ID);
		List list = this.getModelChildren();
		for(Object o : list)
			if(o instanceof Shape) {
				Shape s = (Shape)o;
				if(s.getType().equals(id))
					return; // if the model already persist, do not create it again
			}

		EObject element = this.resolveSemanticElement();
		if(!(element instanceof ExecutionSpecification)) {
			return;
		}
		ExecutionSpecification execution = (ExecutionSpecification)element;
		final ExecutionSpecificationEndEditPart startPart = new ExecutionSpecificationEndEditPart(execution.getStart(), this, new RelativeLocator(getFigure(), PositionConstants.NORTH));
		executionSpecificationEndParts.add(startPart);
		final ExecutionSpecificationEndEditPart finishPart = new ExecutionSpecificationEndEditPart(execution.getFinish(), this, new RelativeLocator(getFigure(), PositionConstants.SOUTH));
		executionSpecificationEndParts.add(finishPart);
		Diagram diagram = ((View)this.getModel()).getDiagram();
		startPart.rebuildLinks(diagram);
		finishPart.rebuildLinks(diagram);
		addChild(startPart, -1);
		addChild(finishPart, -1);
	}

	static class FillParentLocator implements Locator {

		public void relocate(IFigure target) {
			target.setBounds(target.getParent().getBounds());
		}
	}

	/**
	 * Overrides to disable the defaultAnchorArea. The edge is now more stuck with the middle of the
	 * figure.
	 * 
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(16, 60) {

			/**
			 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#isDefaultAnchorArea(org.eclipse.draw2d.geometry.PrecisionPoint)
			 */
			@Override
			protected boolean isDefaultAnchorArea(PrecisionPoint p) {
				return false;
			}
		};
		result.setMinimumSize(new Dimension(getMapMode().DPtoLP(16), getMapMode().DPtoLP(20))); // min height 20
		return result;
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new ResizableShapeEditPolicy() {

			@Override
			protected Command getResizeCommand(ChangeBoundsRequest request) {
				// Bugfix: Avoid resize ES with the child size is little than parent one. 
				EditPart host = getHost();
				List<ShapeNodeEditPart> movedChildrenParts = LifelineXYLayoutEditPolicy.getAffixedExecutionSpecificationEditParts((ShapeNodeEditPart)host);
				Rectangle r = getInitialFeedbackBounds().getCopy();
				getHostFigure().translateToAbsolute(r);
				r.translate(0, request.getMoveDelta().y);
				r.resize(0, request.getSizeDelta().height);
				for(ShapeNodeEditPart child : movedChildrenParts) {
					IFigure figure = child.getFigure();
					Rectangle rect = figure.getBounds().getCopy();
					if(figure instanceof HandleBounds) {
						rect = ((HandleBounds)figure).getBounds().getCopy();
					}
					figure.translateToAbsolute(rect);
					if(rect.y < (r.y) || r.bottom() < (rect.y)) {
						return UnexecutableCommand.INSTANCE;
					}
				}
				return super.getResizeCommand(request);
			}

			@Override
			protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
				request.getMoveDelta().x = 0; // reset offset
				IFigure feedback = getDragSourceFeedbackFigure();
				PrecisionRectangle rect = new PrecisionRectangle(getInitialFeedbackBounds().getCopy());
				getHostFigure().translateToAbsolute(rect);
				IFigure f = getHostFigure();
				Dimension min = f.getMinimumSize().getCopy();
				Dimension max = f.getMaximumSize().getCopy();
				IMapMode mmode = MapModeUtil.getMapMode(f);
				min.height = mmode.LPtoDP(min.height);
				min.width = mmode.LPtoDP(min.width);
				max.height = mmode.LPtoDP(max.height);
				max.width = mmode.LPtoDP(max.width);
				Rectangle originalBounds = rect.getCopy();
				rect.translate(request.getMoveDelta());
				rect.resize(request.getSizeDelta());
				if(min.width > rect.width) {
					rect.width = min.width;
				} else if(max.width < rect.width) {
					rect.width = max.width;
				}
				if(min.height > rect.height) {
					rect.height = min.height;
				} else if(max.height < rect.height) {
					rect.height = max.height;
				}
				if(rect.height == min.height && request.getSizeDelta().height < 0 && request.getMoveDelta().y > 0) { //shrink at north
					Point loc = rect.getLocation();
					loc.y = originalBounds.getBottom().y - min.height;
					rect.setLocation(loc);
					request.getSizeDelta().height = min.height - originalBounds.height;
					request.getMoveDelta().y = loc.y - originalBounds.y;
				}
				if(request.getSizeDelta().height == 0) { // moving
					EditPart parentBar = moveExecutionSpecificationFeedback(request, AbstractExecutionSpecificationEditPart.this, rect);
					if(parentBar == null) {
						parentBar = getParent();
					}
					//Highlight the parentBar when perform moving.
					HighlightUtil.unhighlight();
					HighlightUtil.highlight(parentBar);
				}
				feedback.translateToRelative(rect);
				feedback.setBounds(rect);
			}

			@Override
			protected void eraseChangeBoundsFeedback(ChangeBoundsRequest request) {
				super.eraseChangeBoundsFeedback(request);
				HighlightUtil.unhighlight();
			}
		});
	}

	@Override
	protected void setLineWidth(int width) {
		if(getPrimaryShape() instanceof NodeFigure) {
			((NodeFigure)getPrimaryShape()).setLineWidth(width);
		}
	}

	protected final void refreshShadow() {
		getPrimaryShape().setShadow(AppearanceHelper.showShadow((View)getModel()));
	}

	/**
	 * Override to set the transparency to the correct figure
	 */
	@Override
	protected void setTransparency(int transp) {
		getPrimaryShape().setTransparency(transp);
	}

	/**
	 * sets the back ground color of this edit part
	 * 
	 * @param color
	 *        the new value of the back ground color
	 */
	@Override
	protected void setBackgroundColor(Color color) {
		getPrimaryShape().setBackgroundColor(color);
		getPrimaryShape().setIsUsingGradient(false);
		getPrimaryShape().setGradientData(-1, -1, 0);
	}

	/**
	 * Override to set the gradient data to the correct figure
	 */
	@Override
	protected void setGradient(GradientData gradient) {
		IPapyrusNodeFigure fig = getPrimaryShape();
		FillStyle style = (FillStyle)getPrimaryView().getStyle(NotationPackage.Literals.FILL_STYLE);
		if(gradient != null) {
			fig.setIsUsingGradient(true);
			fig.setGradientData(style.getFillColor(), gradient.getGradientColor1(), gradient.getGradientStyle());
		} else {
			fig.setIsUsingGradient(false);
		}
	}

	@Override
	public boolean supportsGradient() {
		return true;
	}

	@Override
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);
		Object feature = event.getFeature();
		if((getModel() != null) && (getModel() == event.getNotifier())) {
			if(NotationPackage.eINSTANCE.getLineStyle_LineWidth().equals(feature)) {
				refreshLineWidth();
			} else if(NotationPackage.eINSTANCE.getLineTypeStyle_LineType().equals(feature)) {
				refreshLineType();
			}
		} else if(NotationPackage.eINSTANCE.getLocation_X().equals(feature) || NotationPackage.eINSTANCE.getLocation_Y().equals(feature) || NotationPackage.eINSTANCE.getSize_Height().equals(feature) || NotationPackage.eINSTANCE.getSize_Width().equals(feature)) {
			getParent().refresh();
		} else if(UMLPackage.eINSTANCE.getExecutionSpecification_Finish().equals(feature) || UMLPackage.eINSTANCE.getExecutionSpecification_Start().equals(feature)) {
			if(executionSpecificationEndParts != null) {
				for(Object child : executionSpecificationEndParts) {
					removeChild((EditPart)child);
				}
				executionSpecificationEndParts = null;
			}
			refreshChildren();
		}
		refreshShadow();
	}

	public class ExecutionSpecificationRectangleFigure extends PapyrusNodeFigure { //RectangleFigure {

		public ExecutionSpecificationRectangleFigure() {
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(16), getMapMode().DPtoLP(60)));
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(16), getMapMode().DPtoLP(20)));
		}

		@Override
		public IFigure findMouseEventTargetAt(int x, int y) {
			// check children first instead of self
			IFigure f = findMouseEventTargetInDescendantsAt(x, y);
			if(f != null) {
				return f;
			}
			if(!containsPoint(x, y)) {
				return null;
			}
			if(isMouseEventTarget()) {
				return this;
			}
			return null;
		}

		@Override
		public IFigure findFigureAt(int x, int y, TreeSearch search) {
			if(search.prune(this)) {
				return null;
			}
			IFigure child = findDescendantAtExcluding(x, y, search);
			if(child != null) {
				return child;
			}
			if(!containsPoint(x, y)) {
				return null;
			}
			if(search.accept(this)) {
				return this;
			}
			return null;
		}
	}

	public abstract ExecutionSpecificationRectangleFigure getPrimaryShape();

	//see bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=385604
	protected ShapeNodeEditPart moveExecutionSpecificationFeedback(ChangeBoundsRequest request, AbstractExecutionSpecificationEditPart movedPart, PrecisionRectangle rect) {
		CustomLifelineEditPart lifelineEP = (CustomLifelineEditPart)movedPart.getParent();
		Rectangle copy = rect.getCopy();
		lifelineEP.getPrimaryShape().translateToRelative(copy);
		List<ShapeNodeEditPart> executionSpecificationList = LifelineEditPartUtil.getChildShapeNodeEditPart(lifelineEP);
		List<ShapeNodeEditPart> movedChildrenParts = LifelineXYLayoutEditPolicy.getAffixedExecutionSpecificationEditParts(AbstractExecutionSpecificationEditPart.this);
		executionSpecificationList.remove(movedPart); // ignore current action and its children
		executionSpecificationList.removeAll(movedChildrenParts);
		ShapeNodeEditPart parentBar = LifelineXYLayoutEditPolicy.getParent(lifelineEP, copy, executionSpecificationList);
		Rectangle dotLineBounds = lifelineEP.getPrimaryShape().getFigureLifelineDotLineFigure().getBounds();
		int dotLineBarLocationX = dotLineBounds.x + dotLineBounds.width / 2 - LifelineXYLayoutEditPolicy.EXECUTION_INIT_WIDTH / 2;
		if(parentBar == null) {
			if(dotLineBarLocationX < copy.x) { // there is no parent bar, move to the center dotline position
				int dx = dotLineBarLocationX - copy.x;
				request.getMoveDelta().x += dx;
				rect.x += dx;
			}
		} else {
			while(!executionSpecificationList.isEmpty()) {
				Rectangle parentBounds = parentBar.getFigure().getBounds();
				int width = parentBounds.width > 0 ? parentBounds.width : LifelineXYLayoutEditPolicy.EXECUTION_INIT_WIDTH;
				int x = parentBounds.x + width / 2 + 1; // affixed to the parent bar
				int dx = x - copy.x;
				rect.x += dx;
				request.getMoveDelta().x += dx;
				copy.x = x;
				// check again to see if the new bar location overlaps with existing bars
				ShapeNodeEditPart part = LifelineXYLayoutEditPolicy.getParent(lifelineEP, copy, executionSpecificationList);
				if(part == parentBar) {
					break;
				} else {
					// if overlaps, go on moving the bar to next x position
					parentBar = part;
				}
			}
		}
		return parentBar;
	}

	/**
	 * Override for add elements on ExecutionSpecification
	 */
	@Override
	public Command getCommand(Request request) {
		if(request instanceof CreateUnspecifiedTypeRequest) {
			return getParent().getCommand(request);
		}
		return super.getCommand(request);
	}

	/**
	 * @generated NOT Override for redirecting creation request to the lifeline
	 */
	@Override
	public void showSourceFeedback(Request request) {
		if(request instanceof CreateUnspecifiedTypeRequest) {
			getParent().showSourceFeedback(request);
		}
		super.showSourceFeedback(request);
	}

	/**
	 * @generated NOT Override for redirecting creation request to the lifeline
	 */
	@Override
	public void eraseSourceFeedback(Request request) {
		if(request instanceof CreateUnspecifiedTypeRequest) {
			getParent().eraseSourceFeedback(request);
		}
		super.eraseSourceFeedback(request);
	}

	@Override
	public void showTargetFeedback(Request request) {
		if(request instanceof CreateUnspecifiedTypeRequest) {
			getParent().showTargetFeedback(request);
		}
		super.showTargetFeedback(request);
	}

	@Override
	public void eraseTargetFeedback(Request request) {
		if(request instanceof CreateUnspecifiedTypeRequest) {
			getParent().eraseTargetFeedback(request);
		}
		super.eraseTargetFeedback(request);
	}

	/**
	 * Add connection on top off the figure during the feedback.
	 */
	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		if(request instanceof CreateUnspecifiedTypeConnectionRequest) {
			CreateUnspecifiedTypeConnectionRequest createRequest = (CreateUnspecifiedTypeConnectionRequest)request;
			List<?> relationshipTypes = createRequest.getElementTypes();
			for(Object obj : relationshipTypes) {
				if(UMLElementTypes.Message_4003.equals(obj)) {
					// Sync Message
					if(!createRequest.getTargetEditPart().equals(createRequest.getSourceEditPart())) {
						return new AnchorHelper.FixedAnchorEx(getFigure(), PositionConstants.TOP);
					}
					// otherwise, this is a recursive call, let destination free
				}
			}
		} else if(request instanceof ReconnectRequest) {
			ReconnectRequest reconnectRequest = (ReconnectRequest)request;
			ConnectionEditPart connectionEditPart = reconnectRequest.getConnectionEditPart();
			if(connectionEditPart instanceof MessageEditPart) {
				// Sync Message
				return new AnchorHelper.FixedAnchorEx(getFigure(), PositionConstants.TOP);
			}
		}
		return super.getTargetConnectionAnchor(request);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
	 * 
	 * @param connEditPart
	 *        The connection edit part.
	 * @return The anchor.
	 */
	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connEditPart) {
		if(connEditPart instanceof MessageEditPart) {
			// Sync Message
			return new AnchorHelper.FixedAnchorEx(getFigure(), PositionConstants.TOP);
		}
		return super.getTargetConnectionAnchor(connEditPart);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.Request)
	 * 
	 * @param request
	 *        The request
	 * @return The anchor
	 */
	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		if(request instanceof CreateUnspecifiedTypeConnectionRequest) {
			CreateUnspecifiedTypeConnectionRequest createRequest = (CreateUnspecifiedTypeConnectionRequest)request;
			List<?> relationshipTypes = createRequest.getElementTypes();
			for(Object obj : relationshipTypes) {
				if(UMLElementTypes.Message_4005.equals(obj)) {
					// Reply Message
					return new AnchorHelper.FixedAnchorEx(getFigure(), PositionConstants.BOTTOM);
				}
			}
		} else if(request instanceof ReconnectRequest) {
			ReconnectRequest reconnectRequest = (ReconnectRequest)request;
			ConnectionEditPart connectionEditPart = reconnectRequest.getConnectionEditPart();
			if(connectionEditPart instanceof Message3EditPart) {
				// Reply Message
				return new AnchorHelper.FixedAnchorEx(getFigure(), PositionConstants.BOTTOM);
			}
		}
		return super.getSourceConnectionAnchor(request);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
	 * 
	 * @param connEditPart
	 *        The connection edit part.
	 * @return The anchor.
	 */
	@Override
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connEditPart) {
		if(connEditPart instanceof Message3EditPart) {
			// Reply Message
			return new AnchorHelper.FixedAnchorEx(getFigure(), PositionConstants.BOTTOM);
		}
		return super.getSourceConnectionAnchor(connEditPart);
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshTransparency();
		refreshShadow();
	}
}
