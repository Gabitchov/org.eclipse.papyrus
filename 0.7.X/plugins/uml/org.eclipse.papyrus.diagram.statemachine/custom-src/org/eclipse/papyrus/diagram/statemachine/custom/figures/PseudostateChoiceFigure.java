package org.eclipse.papyrus.diagram.statemachine.custom.figures;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.papyrus.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.diagram.common.figure.node.PapyrusNodeFigure;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

public class PseudostateChoiceFigure extends PapyrusNodeFigure implements IPapyrusNodeUMLElementFigure{
	/**
	 * 
	  * {@inheritDoc}
	 */
		protected Border getDefaultBorder(Color borderColor) {
			return null;
		}

	/**
	 * 
	 * {@inheritDoc}
	 */
		@Override
		public Dimension getPreferredSize(int wHint, int hHint) {
			// TODO Auto-generated method stub
			return new Dimension(20,20);
		}
		
		/**
		 * {@inheritDoc}
		 */
		public Label getStereotypesLabel() {
			return new Label();
		}
		/**
		 * {@inheritDoc}
		 */
		public void paintFigure(Graphics graphics) {
			graphics.pushState();
			Rectangle r = getBounds().getCopy().crop(new Insets(0,0,1,1));
			
			int lineWidth = graphics.getLineWidth();
			r.x = r.x + lineWidth / 2;
			r.y = r.y + lineWidth / 2;
			r.width = r.width - lineWidth - 1;
			r.height = r.height - lineWidth - 1;
	
			PointList pl = new PointList();
			pl.addPoint(r.getTop());
			pl.addPoint(r.getRight());
			pl.addPoint(r.getBottom());
			pl.addPoint(r.getLeft());
			
			if(isUsingGradient()) {
				graphics.setBackgroundColor(FigureUtilities.integerToColor(getGradientColor2()));
				//graphics.setForegroundColor(FigureUtilities.integerToColor(getGradientColor2()));
			}
			else{
			graphics.setBackgroundColor(getBackgroundColor());
			//graphics.setForegroundColor(getBackgroundColor);
			}
			graphics.fillPolygon(pl);
			graphics.setLineWidth(1);
			graphics.setBackgroundColor(getForegroundColor());
			graphics.drawPolygon(pl);
			graphics.popState();
			

		}
		/**
		 * {@inheritDoc}
		 */
		public void setStereotypeDisplay(String stereotypes, Image image) {
			// TODO Auto-generated method stub
			
		}
		/**
		 * {@inheritDoc}
		 */
		public void setStereotypePropertiesInBrace(String stereotypeProperties) {
			// TODO Auto-generated method stub
			
		}
		/**
		 * {@inheritDoc}
		 */
		public void setStereotypePropertiesInCompartment(String stereotypeProperties) {
			// TODO Auto-generated method stub
			
		}

}
