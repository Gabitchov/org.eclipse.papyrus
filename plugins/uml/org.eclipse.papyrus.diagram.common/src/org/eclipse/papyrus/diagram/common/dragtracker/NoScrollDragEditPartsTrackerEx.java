/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.dragtracker;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx;
/**
 * this tracker is used to prevent the move of a figure outdoor of its container
 *
 */
public class NoScrollDragEditPartsTrackerEx extends DragEditPartsTrackerEx{

	public NoScrollDragEditPartsTrackerEx(EditPart sourceEditPart) {
		super(sourceEditPart);
	}
	
	@Override
	protected void updateTargetRequest() {
		int BORDER=5;
		super.updateTargetRequest();
		Dimension delta = getDragMoveDelta();
		
		if( getSourceEditPart() instanceof GraphicalEditPart){
			Rectangle childRect=((GraphicalEditPart)getSourceEditPart()).getFigure().getBounds();
			if( getSourceEditPart().getParent() instanceof GraphicalEditPart){
				IFigure parentFigure=((GraphicalEditPart) getSourceEditPart().getParent()).getFigure();
				
				Rectangle parentRect= parentFigure.getBounds();
				if( parentFigure instanceof ShapeCompartmentFigure){
					parentRect=((ShapeCompartmentFigure)parentFigure).getContentPane().getBounds();
				}
				EditPart ParentEditPart=((GraphicalEditPart) getSourceEditPart().getParent());
				//calculate the virtual position
				Rectangle virtualPosition= childRect.getCopy();
				virtualPosition.x=virtualPosition.x+delta.width;
				virtualPosition.y=virtualPosition.y+delta.height;
				if( virtualPosition.x<0){
					delta.width=0-childRect.x;
				}
				if( virtualPosition.y<0){
					delta.height=0-childRect.y;
				}
				
				if( virtualPosition.x+virtualPosition.width+BORDER>parentRect.width){
					delta.width=parentRect.width-childRect.width-childRect.x-BORDER;
				}
				
				if( virtualPosition.y+virtualPosition.height+BORDER>parentRect.height){
					delta.height=parentRect.height-childRect.height-childRect.y-BORDER;
				}
				ChangeBoundsRequest request = (ChangeBoundsRequest) getTargetRequest();
				Point moveDelta = new Point(delta.width, delta.height);
				request.setMoveDelta(moveDelta);
				
				
				//Very important the child element to block inside the container
				//if not test first the target editPart.
				// let the default algorithm if the target is not its parent.
				setTargetEditPart(getSourceEditPart().getParent());
			}
		}
	}

}
