package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ConstraintFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.HTMLCornerBentFigure;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractExecutionSpecificationEditPart.ExecutionSpecificationRectangleFigure;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.figures.CombinedFragmentFigure;
import org.eclipse.swt.graphics.Color;


public class HighlightUtil {
	public static final Color COVER_COLOR = ColorConstants.cyan;
	public static final Color TARGET_COLOR = ColorConstants.cyan;
	public static final Color SOURCE_COLOR = ColorConstants.cyan;
	
	static Map<LifelineEditPart, Rectangle> lifelines ;
	static List<LifelineEditPart> highlightLifelines = new ArrayList<LifelineEditPart>();
	static Map<EditPart,FigureState> figureState = new HashMap<EditPart,FigureState>();
	
	public static Map<LifelineEditPart, Rectangle> collectAllLifelines(EditPart part) {
		Map<LifelineEditPart,Rectangle> lifelines = new HashMap<LifelineEditPart,Rectangle>();
		Set<Entry<Object, EditPart>> allEditPartEntries = part.getViewer().getEditPartRegistry().entrySet();
		for(Entry<Object, EditPart> epEntry : allEditPartEntries) {
			EditPart ep = epEntry.getValue();
			if(!(ep instanceof LifelineEditPart))
				continue;
				
			LifelineEditPart lp = (LifelineEditPart)ep;
			IFigure figure = lp.getFigure();
			Rectangle childBounds = figure.getBounds().getCopy();
			figure.translateToAbsolute(childBounds);
			Rectangle centralLineBounds = new Rectangle(
					childBounds.x() +  childBounds.width() / 2,
					childBounds.y(), 1,  childBounds.height());
			
			lifelines.put(lp, centralLineBounds);					
		}
		return lifelines;
	}
	
	public static void showSizeOnDropFeedback(CreateRequest request,EditPart host, IFigure feedback, Rectangle bounds){
		if(lifelines == null){
			lifelines = collectAllLifelines(host);
			highlightLifelines = new ArrayList<LifelineEditPart>();
		}
		
		List<LifelineEditPart> addLifelines = new ArrayList<LifelineEditPart>();
		List<LifelineEditPart> removeLifelines = new ArrayList<LifelineEditPart>();
		
		Iterator<Entry<LifelineEditPart, Rectangle>> it = lifelines.entrySet().iterator();
		while(it.hasNext()){
			Entry<LifelineEditPart, Rectangle> en = it.next();
			
			if(bounds.intersects(en.getValue())){
				if(!highlightLifelines.contains(en.getKey()))
					addLifelines.add(en.getKey());
			}else{
				if(highlightLifelines.contains(en.getKey()))
					removeLifelines.add(en.getKey());
			}
		}
		
		highlightLifelines.removeAll(removeLifelines);
		highlightLifelines.addAll(addLifelines);
		
		// highlight lifeline inside
		for(LifelineEditPart lp : addLifelines){
			RectangleFigure rect = lp.getPrimaryShape().getFigureLifelineNameContainerFigure();
			figureState.put(lp, new FigureState(rect.getBackgroundColor()));
			rect.setBackgroundColor(COVER_COLOR);
			rect.setFill(true);
		}
		
		// restore lifeline outside
		for(LifelineEditPart lp : removeLifelines){
			FigureState s = figureState.get(lp);
			if(s == null)
				continue;
			
			RectangleFigure rect = lp.getPrimaryShape().getFigureLifelineNameContainerFigure();			
			rect.setBackgroundColor(s.bgColor);
			rect.setFill(true);
		}
	}

	public static void eraseSizeOnDropFeedback(Request request, EditPart host) {
		for(LifelineEditPart lp : highlightLifelines){
			FigureState s = figureState.get(lp);
			if(s == null)
				continue;
			
			RectangleFigure rect = lp.getPrimaryShape().getFigureLifelineNameContainerFigure();
			rect.setBackgroundColor(s.bgColor);
			rect.setFill(true);
		}
		
		lifelines = null;
		highlightLifelines = new ArrayList<LifelineEditPart>();		
	}
	
	public static void showConnectionFeedback(EditPart host, Color color) {
		if(host instanceof LifelineEditPart){
			LifelineEditPart part = (LifelineEditPart)host;
			RectangleFigure fig = part.getPrimaryShape().getFigureLifelineNameContainerFigure();
			saveIfNotExist(host, fig);
			fig.setBackgroundColor(color);
			fig.setFill(true);
		}else if(host instanceof AbstractExecutionSpecificationEditPart){
			ExecutionSpecificationRectangleFigure fig = ((AbstractExecutionSpecificationEditPart)host).getPrimaryShape();
			saveIfNotExist(host, fig);
			fig.setBackgroundColor(color);
		}else if(host instanceof CombinedFragmentEditPart){
			CombinedFragmentFigure fig = ((CombinedFragmentEditPart)host).getPrimaryShape();
			saveIfNotExist(host, fig);
			fig.setBackgroundColor(color);
		}else if(host instanceof InteractionOperandEditPart){
			InteractionOperandEditPart op = (InteractionOperandEditPart) host;
			CombinedFragmentEditPart cep = (CombinedFragmentEditPart) op.getParent().getParent();
			CombinedFragmentFigure fig = cep.getPrimaryShape();
			saveIfNotExist(host, fig);
			fig.setBackgroundColor(color);
		}else if(host instanceof CommentEditPart){
			HTMLCornerBentFigure fig = ((CommentEditPart)host).getPrimaryShape();
			saveIfNotExist(host, fig);
			fig.setBackgroundColor(color);
		}else if(host instanceof ConstraintEditPart){
			ConstraintFigure fig = ( (ConstraintEditPart) host).getPrimaryShape();
			saveIfNotExist(host, fig);
			fig.setBackgroundColor(color);
		}
	}

	protected static void saveIfNotExist(EditPart host, IFigure fig) {
		if(!figureState.containsKey(host))
			figureState.put(host, new FigureState(fig.getBackgroundColor()));
	}
	
	public static void eraseConnectionFeedback(EditPart host) {
		FigureState s = figureState.get(host);
		if(s == null)
			return;
		
		if(host instanceof LifelineEditPart){
			LifelineEditPart part = (LifelineEditPart)host;
			RectangleFigure fig = part.getPrimaryShape().getFigureLifelineNameContainerFigure();
			fig.setBackgroundColor(s.bgColor);
			fig.setFill(true);
		}else if(host instanceof AbstractExecutionSpecificationEditPart){
			ExecutionSpecificationRectangleFigure fig = ((AbstractExecutionSpecificationEditPart)host).getPrimaryShape();
			fig.setBackgroundColor(s.bgColor);
		}else if(host instanceof CombinedFragmentEditPart){
			CombinedFragmentEditPart cep = (CombinedFragmentEditPart)host;
			cep.getPrimaryShape().setBackgroundColor(s.bgColor);
		}else if(host instanceof InteractionOperandEditPart){
			InteractionOperandEditPart op = (InteractionOperandEditPart) host;
			CombinedFragmentEditPart cep = (CombinedFragmentEditPart) op.getParent().getParent();
			cep.getPrimaryShape().setBackgroundColor(s.bgColor);
		}else if(host instanceof CommentEditPart){
			HTMLCornerBentFigure fig = ((CommentEditPart)host).getPrimaryShape();
			fig.setBackgroundColor(s.bgColor);
		}else if(host instanceof ConstraintEditPart){
			ConstraintFigure fig = ( (ConstraintEditPart) host).getPrimaryShape();
			fig.setBackgroundColor(s.bgColor);
		}
		
		figureState.remove(host);
	}
	
	static class FigureState{		
		Color bgColor;
		
		public FigureState(Color bgColor) {
			this.bgColor = bgColor;
		}
	}
}
