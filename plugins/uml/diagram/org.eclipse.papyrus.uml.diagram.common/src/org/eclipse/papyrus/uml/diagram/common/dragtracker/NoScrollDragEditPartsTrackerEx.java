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
package org.eclipse.papyrus.uml.diagram.common.dragtracker;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx;
/**
 * this tracker is used to prevent the move of a figure outdoor of its container
 *
 */
public class NoScrollDragEditPartsTrackerEx extends DragEditPartsTrackerEx{

	/** border size */ 
	private int border = 15; // default size : 10

	public NoScrollDragEditPartsTrackerEx(EditPart sourceEditPart) {
		super(sourceEditPart);
	}
	
	/**
	 * {@inheritDoc} 
	 */
	@Override
	protected void updateTargetRequest() {
		
		super.updateTargetRequest();
		Dimension delta = getDragMoveDelta();
		
		if( getSourceEditPart() instanceof GraphicalEditPart){
			Rectangle childRect=((GraphicalEditPart)getSourceEditPart()).getFigure().getBounds();
			if( getSourceEditPart().getParent() instanceof GraphicalEditPart){
				Rectangle parentRect= 	((GraphicalEditPart) getSourceEditPart().getParent()).getFigure().getBounds();
				IFigure fig=((GraphicalEditPart) getSourceEditPart().getParent()).getFigure();
				
				IFigure contentPane=((GraphicalEditPart) getSourceEditPart().getParent()).getContentPane();
				
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
				
				if( virtualPosition.x+virtualPosition.width+getBorder()>parentRect.width){
					delta.width=parentRect.width-childRect.width-childRect.x-getBorder();
				}
				
				if( virtualPosition.y+virtualPosition.height+2*getBorder()>parentRect.height){
					delta.height=parentRect.height-childRect.height-childRect.y-2*getBorder();
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
	
	/**
	 * Returns the border size
	 * @return the border size
	 */
	protected int getBorder() {
		return this.border;
	}
	
	/**
	 * Sets the border size
	 * @param border the new border size
	 */
	protected void setBorder(int border) {
		this.border = border;
	}

}
