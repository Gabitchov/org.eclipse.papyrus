package org.eclipse.papyrus.diagram.common.groups.core.utils;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;


public class CoordinnateUtils {

	/**
	 * Get the rectangle with absolute position of a {@link IGraphicalEditPart} which is a node. Else return null
	 * 
	 * @param editPart
	 * @return
	 */
	public static Rectangle getAbsoluteRectangle(EditPart editPart, DiagramEditPart diag) {
		Rectangle rect = null;
		int X, Y, width, height = 0;
		View view = (View)editPart.getModel();
		if(view instanceof Node) {
			Node node = (Node)view;
			LayoutConstraint layoutConstraint = node.getLayoutConstraint();
			if(layoutConstraint instanceof LayoutConstraint) {
				rect = new Rectangle();
				if(layoutConstraint instanceof Location) {
					X = ((Location)layoutConstraint).getX();
					Y = ((Location)layoutConstraint).getY();
				}
				if(layoutConstraint instanceof Size) {
					height = ((Size)layoutConstraint).getHeight();
					width = ((Size)layoutConstraint).getWidth();
				}
			}
		}
		return rect;
	}


}
