package org.eclipse.papyrus.uml.diagram.sequence.figures;

import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;

public class MessageAsync extends MessageFigure {

	/**
	 * Constructor.
	 * 
	 */
	public MessageAsync() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param mapMode
	 */
	public MessageAsync(IMapMode mapMode) {
		super(mapMode);
	}

	protected RotatableDecoration createTargetDecoration() {
		PolylineDecoration df = new PolylineDecoration();
		df.setForegroundColor(getForegroundColor());
		PointList pl = new PointList();
		pl.addPoint(getMapMode().DPtoLP(-2), getMapMode().DPtoLP(2));
		pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0));
		pl.addPoint(getMapMode().DPtoLP(-2), getMapMode().DPtoLP(-2));
		df.setTemplate(pl);
		df.setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));
		return df;
	}
}
