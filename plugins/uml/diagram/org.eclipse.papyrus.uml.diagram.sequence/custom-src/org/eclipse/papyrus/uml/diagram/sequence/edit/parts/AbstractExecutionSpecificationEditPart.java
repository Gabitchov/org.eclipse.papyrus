package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RelativeLocator;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.ExecutionSpecification;

public abstract class AbstractExecutionSpecificationEditPart extends
		ShapeNodeEditPart {
	private List executionSpecificationEndParts;

	public AbstractExecutionSpecificationEditPart(View view) {
		super(view);
	}

	@Override
	public List getChildren() {
		if (executionSpecificationEndParts == null) {
			initExecutionSpecificationEndEditPart();
		}
		return super.getChildren();
	}

	protected void initExecutionSpecificationEndEditPart() {
		executionSpecificationEndParts = new ArrayList();

		EObject element = this.resolveSemanticElement();
		if (!(element instanceof ExecutionSpecification))
			return;
		ExecutionSpecification execution = (ExecutionSpecification) element;
		final ExecutionSpecificationEndEditPart startPart = new ExecutionSpecificationEndEditPart(
				execution.getStart(), this, new RelativeLocator(getFigure(),
						PositionConstants.NORTH));
		executionSpecificationEndParts.add(startPart);

		final ExecutionSpecificationEndEditPart finishPart = new ExecutionSpecificationEndEditPart(
				execution.getFinish(), this, new RelativeLocator(getFigure(),
						PositionConstants.SOUTH));
		executionSpecificationEndParts.add(finishPart);

		Diagram diagram = ((View) this.getModel()).getDiagram();
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
	 * @generated NOT
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
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new ResizableShapeEditPolicy(){
			@Override
			protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
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
		        
		        if (min.width>rect.width)
		            rect.width = min.width;
		        else if (max.width < rect.width)
		            rect.width = max.width;
		        if (min.height>rect.height)
		            rect.height = min.height;
		        else if (max.height < rect.height)
		            rect.height = max.height;
		        
		        if(rect.height == min.height && request.getSizeDelta().height < 0 && request.getMoveDelta().y > 0 ){ //shrink at north
		        	Point loc = rect.getLocation();
		        	loc.y = originalBounds.getBottom().y - min.height;
		        	rect.setLocation(loc);
		        	
		        	request.getSizeDelta().height = min.height - originalBounds.height;
		        	request.getMoveDelta().y = loc.y - originalBounds.y;
		        }
		        feedback.translateToRelative(rect);
		        feedback.setBounds(rect);
			}
		});
	}	
}
