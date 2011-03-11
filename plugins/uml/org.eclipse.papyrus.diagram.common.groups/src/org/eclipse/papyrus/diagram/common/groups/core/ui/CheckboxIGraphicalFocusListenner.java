package org.eclipse.papyrus.diagram.common.groups.core.ui;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.graphics.Color;


public class CheckboxIGraphicalFocusListenner implements MouseTrackListener {


	private Color oldColor,newColor;
	private IFigure figure;
	private IGraphicalEditPart parent;
	public CheckboxIGraphicalFocusListenner(IGraphicalEditPart parent) {
		super();
		this.parent = parent;
		figure = ((IGraphicalEditPart)parent.getParent()).getFigure();
		oldColor=figure.getBackgroundColor();
		newColor = new Color(oldColor.getDevice(),oldColor.getRed(),0,0);
	}

	
	public void mouseEnter(MouseEvent arg0) {
//		figure.setBackgroundColor(newColor);
//		figure.setForegroundColor(newColor);
//		figure.repaint();
		
	}
	public void mouseExit(MouseEvent arg0) {
		//figure.setBackgroundColor(oldColor);
		
	}
	public void mouseHover(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
