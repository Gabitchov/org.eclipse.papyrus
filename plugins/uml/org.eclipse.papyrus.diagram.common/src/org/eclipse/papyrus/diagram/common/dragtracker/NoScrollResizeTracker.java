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
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.tools.ResizeTracker;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;

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
		int BORDER=5;
		super.updateSourceRequest();
		ChangeBoundsRequest request = (ChangeBoundsRequest) getSourceRequest();
		Dimension deltaResize= request.getSizeDelta();
		Point delta= request.getMoveDelta();

		if( getOwner() instanceof GraphicalEditPart){
			Rectangle childRect=((GraphicalEditPart)getOwner()).getFigure().getBounds();
			if( getOwner().getParent() instanceof GraphicalEditPart){
				IFigure parentFigure=((GraphicalEditPart) getOwner().getParent()).getFigure();
				Point originLimit=childRect.getBottomRight();
				Rectangle parentRect= 	parentFigure.getBounds();
				if( parentFigure instanceof ShapeCompartmentFigure){
					parentRect=((ShapeCompartmentFigure)parentFigure).getContentPane().getBounds();
				}
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
				if(virtualPosition.getBottomRight().y>parentRect.height-BORDER){
					deltaResize.height=parentRect.height-childRect.getBottomRight().y-BORDER;
				}

				if( virtualPosition.x>originLimit.x-((GraphicalEditPart)getOwner()).getFigure().getMinimumSize(0, 0).width){
					delta.x=((GraphicalEditPart)getOwner()).getFigure().getBounds().width-((GraphicalEditPart)getOwner()).getFigure().getMinimumSize(0, 0).width;
					deltaResize.width= ((GraphicalEditPart)getOwner()).getFigure().getMinimumSize(0, 0).width-((GraphicalEditPart)getOwner()).getFigure().getBounds().width;

				}
				if( virtualPosition.y>originLimit.y-((GraphicalEditPart)getOwner()).getFigure().getMinimumSize(0, 0).height){
					delta.y=((GraphicalEditPart)getOwner()).getFigure().getBounds().height-((GraphicalEditPart)getOwner()).getFigure().getMinimumSize(0, 0).height;
					deltaResize.height= ((GraphicalEditPart)getOwner()).getFigure().getMinimumSize(0, 0).height-((GraphicalEditPart)getOwner()).getFigure().getBounds().height;

				
				}
				request.setMoveDelta(delta);
			}
		}

	}
}
