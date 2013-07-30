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

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.tools.ResizeTracker;

/**
 * this tracker is used to prevent the resize of a figure outdoor of its container
 *
 */
public class NoScrollResizeTracker extends ResizeTracker {

	public NoScrollResizeTracker(GraphicalEditPart owner, int direction) {
		super(owner, direction);
	}
	@Override
	protected void updateSourceRequest() {
		int BORDER=10;
		super.updateSourceRequest();
		ChangeBoundsRequest request = (ChangeBoundsRequest) getSourceRequest();
		Dimension deltaResize= request.getSizeDelta();
		Point delta= request.getMoveDelta();
		
		if( getOwner() instanceof GraphicalEditPart){
			Rectangle childRect=((GraphicalEditPart)getOwner()).getFigure().getBounds();
			if( getOwner().getParent() instanceof GraphicalEditPart){
				Rectangle parentRect= 	((GraphicalEditPart) getOwner().getParent()).getFigure().getBounds();
			
				//calculus the virtual position
				Rectangle virtualPosition= childRect.getCopy();
				virtualPosition.x=virtualPosition.x+delta.x;
				virtualPosition.y=virtualPosition.y+delta.y;
				virtualPosition.width=virtualPosition.width+deltaResize.width;
				virtualPosition.height=virtualPosition.height+deltaResize.height;
				
				
				if( virtualPosition.x<0){
					delta.x=0-childRect.x;
					deltaResize.width=Math.abs(delta.x);
					
				}
				if( virtualPosition.y<0){
					delta.y=0-childRect.y;
					deltaResize.height=Math.abs(delta.y);
					
				}
				if( virtualPosition.getBottomRight().x>parentRect.width-BORDER){
					deltaResize.width=parentRect.width-childRect.getBottomRight().x-BORDER;
				}
				if(virtualPosition.getBottomRight().y>parentRect.height-2*BORDER){
					deltaResize.height=parentRect.height-childRect.getBottomRight().y-2*BORDER;
				}
			
				request.setMoveDelta(delta);
			}
		}
		
	}
}
