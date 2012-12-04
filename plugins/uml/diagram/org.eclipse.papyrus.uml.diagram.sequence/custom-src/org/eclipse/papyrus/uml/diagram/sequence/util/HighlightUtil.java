package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.swt.graphics.Color;


public class HighlightUtil {

	private static class FigureState {

		private Color bgColor;

		private Color fgColor;

		private int lineWidth;

		public FigureState(Color bgColor, Color fgColor, int lineWidth) {
			this.bgColor = bgColor;
			this.fgColor = fgColor;
			this.lineWidth = lineWidth;
		}
	}

	public static final Color COVER_COLOR = ColorConstants.cyan;

	public static final Color TARGET_COLOR = ColorConstants.cyan;

	public static final Color SOURCE_COLOR = ColorConstants.cyan;

	static Map<LifelineEditPart, Rectangle> lifelines;

	static List<LifelineEditPart> highlightLifelines = new ArrayList<LifelineEditPart>();
	
	static Map<EditPart, FigureState> feedbackStates = new HashMap<EditPart, HighlightUtil.FigureState>();

	public static Map<LifelineEditPart, Rectangle> collectAllLifelines(EditPart part) {
		Map<LifelineEditPart, Rectangle> lifelines = new HashMap<LifelineEditPart, Rectangle>();
		Set<Entry<Object, EditPart>> allEditPartEntries = part.getViewer().getEditPartRegistry().entrySet();
		for(Entry<Object, EditPart> epEntry : allEditPartEntries) {
			EditPart ep = epEntry.getValue();
			if(!(ep instanceof LifelineEditPart))
				continue;

			LifelineEditPart lp = (LifelineEditPart)ep;
			IFigure figure = lp.getFigure();
			Rectangle childBounds = figure.getBounds().getCopy();
			figure.translateToAbsolute(childBounds);
			Rectangle centralLineBounds = new Rectangle(childBounds.x() + childBounds.width() / 2, childBounds.y(), 1, childBounds.height());

			lifelines.put(lp, centralLineBounds);
		}
		return lifelines;
	}

	public static void eraseSizeOnDropFeedback(Request request, EditPart host) {
		for(LifelineEditPart lp : highlightLifelines) {
			FigureState s = feedbackStates.get(lp);
			if(s == null)
				continue;

			RectangleFigure rect = lp.getPrimaryShape().getFigureLifelineNameContainerFigure();
			rect.setBackgroundColor(s.bgColor);
			rect.setFill(true);
		}

		lifelines = null;
		highlightLifelines = new ArrayList<LifelineEditPart>();
	}

	public static void showSizeOnDropFeedback(CreateRequest request, EditPart host, IFigure feedback, Rectangle bounds) {
		if(lifelines == null) {
			lifelines = collectAllLifelines(host);
			highlightLifelines = new ArrayList<LifelineEditPart>();
		}

		List<LifelineEditPart> addLifelines = new ArrayList<LifelineEditPart>();
		List<LifelineEditPart> removeLifelines = new ArrayList<LifelineEditPart>();

		Iterator<Entry<LifelineEditPart, Rectangle>> it = lifelines.entrySet().iterator();
		while(it.hasNext()) {
			Entry<LifelineEditPart, Rectangle> en = it.next();

			if(bounds.intersects(en.getValue())) {
				if(!highlightLifelines.contains(en.getKey()))
					addLifelines.add(en.getKey());
			} else {
				if(highlightLifelines.contains(en.getKey()))
					removeLifelines.add(en.getKey());
			}
		}

		highlightLifelines.removeAll(removeLifelines);
		highlightLifelines.addAll(addLifelines);

		// highlight lifeline inside
		for(LifelineEditPart lp : addLifelines) {
			RectangleFigure rect = lp.getPrimaryShape().getFigureLifelineNameContainerFigure();
			feedbackStates.put(lp, new FigureState(rect.getBackgroundColor(), rect.getForegroundColor(), rect.getLineWidth()));
			rect.setBackgroundColor(COVER_COLOR);
			rect.setFill(true);
		}

		// restore lifeline outside
		for(LifelineEditPart lp : removeLifelines) {
			FigureState s = feedbackStates.get(lp);
			if(s == null)
				continue;

			RectangleFigure rect = lp.getPrimaryShape().getFigureLifelineNameContainerFigure();
			rect.setBackgroundColor(s.bgColor);
			rect.setFill(true);
		}
	}

	private Map<Object, FigureState> figureState = new HashMap<Object, FigureState>();

	/**
	 * Maybe this value can be managed by preferences.
	 */
	private Color getHighlightBackground() {
		return null;
	}

	/**
	 * Maybe this value can be managed by preferences.
	 */
	private int getHighlightBorderWidth() {
		return 2;
	}

	private List<IFigure> getHighlightFigures(EditPart host) {
		List<IFigure> figures = new ArrayList<IFigure>();
		if(host instanceof LifelineEditPart) {
			LifelineEditPart part = (LifelineEditPart)host;
			figures.add(part.getPrimaryShape().getFigureLifelineNameContainerFigure());
			figures.add(part.getPrimaryShape().getFigureLifelineDotLineFigure());
		} else if(host instanceof AbstractExecutionSpecificationEditPart) {
			figures.add(((AbstractExecutionSpecificationEditPart)host).getPrimaryShape());
		} else if(host instanceof CombinedFragmentEditPart) {
			figures.add(((CombinedFragmentEditPart)host).getPrimaryShape());
		} else if(host instanceof InteractionOperandEditPart) {
			InteractionOperandEditPart op = (InteractionOperandEditPart)host;
			CombinedFragmentEditPart cep = (CombinedFragmentEditPart)op.getParent().getParent();
			figures.add(cep.getPrimaryShape());
		} else if(host instanceof CommentEditPart) {
			figures.add(((CommentEditPart)host).getPrimaryShape());
		} else if(host instanceof ConstraintEditPart) {
			figures.add(((ConstraintEditPart)host).getPrimaryShape());
		} else if(host instanceof IPapyrusEditPart) {
			figures.add(((IPapyrusEditPart)host).getPrimaryShape());
		}
		return figures;
	}

	/**
	 * Maybe this value can be managed by preferences.
	 */
	private Color getHighlightForeground() {
		return null;
	}

	public void highlight(EditPart host) {
		List<IFigure> highlightFigures = getHighlightFigures(host);
		if(highlightFigures.isEmpty()) {
			return;
		}

		Color background = getHighlightBackground();
		Color foreground = getHighlightForeground();
		int lineWidth = getHighlightBorderWidth();
		for(IFigure figure : highlightFigures) {
			saveIfNotExist(figure, figure);
			updateFigure(figure, background, foreground, lineWidth);
		}
	}

	protected void saveIfNotExist(Object host, IFigure fig) {
		if(!figureState.containsKey(host)) {
			int lineWidth = 1;
			Border border = fig.getBorder();
			if(border instanceof LineBorder) {
				lineWidth = ((LineBorder)border).getWidth();
			} else if(fig instanceof Shape) {
				lineWidth = ((Shape)fig).getLineWidth();
			}
			figureState.put(host, new FigureState(fig.getBackgroundColor(), fig.getForegroundColor(), lineWidth));
		}
	}

	public void unhighlight() {
		if(figureState == null || figureState.isEmpty()) {
			return;
		}
		Set<Entry<Object, FigureState>> entrySet = figureState.entrySet();
		for(Entry<Object, FigureState> entry : entrySet) {
			Object key = entry.getKey();
			FigureState value = entry.getValue();
			if(key instanceof IFigure) {
				IFigure fig = (IFigure)key;
				updateFigure(fig, value.bgColor, value.fgColor, value.lineWidth);
			} else if(key instanceof EditPart) {
				List<IFigure> figures = getHighlightFigures((EditPart)key);
				for(IFigure fig : figures) {
					updateFigure(fig, value.bgColor, value.fgColor, value.lineWidth);
				}
			}
		}
		figureState.clear();
	}

	public void unhighlight(EditPart host) {
		List<IFigure> highlightFigures = getHighlightFigures(host);
		if(highlightFigures.isEmpty()) {
			return;
		}
		for(IFigure figure : highlightFigures) {
			FigureState s = figureState.remove(figure);
			if(s == null) {
				continue;
			}
			updateFigure(figure, s.bgColor, s.fgColor, s.lineWidth);
		}
	}

	private void updateFigure(IFigure fig, Color bgColor, Color fgColor, int lineWidth) {
		if(fig == null) {
			return;
		}
		if(lineWidth > 0) {
			Border border = fig.getBorder();
			if(border != null && border instanceof LineBorder) {
				((LineBorder)border).setWidth(lineWidth);
			} else if(fig instanceof Shape) {
				((Shape)fig).setLineWidth(lineWidth);
			} else if(fig instanceof Polyline) {
				((Polyline)fig).setLineWidth(lineWidth);
			}
		}
		if(bgColor != null) {
			fig.setBackgroundColor(bgColor);
		}
		if(fgColor != null) {
			fig.setForegroundColor(fgColor);
		}
		fig.repaint();
	}
}
