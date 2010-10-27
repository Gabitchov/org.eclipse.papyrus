/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib saadia.dhouib@cea.fr  
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.communication.custom.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.communication.custom.figures.CustomWrappingLabel;
import org.eclipse.papyrus.diagram.communication.edit.parts.AppliedStereotypeMessageEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.MessageEditPart;
import org.eclipse.papyrus.diagram.communication.edit.parts.MessageNameEditPart;


// TODO: Auto-generated Javadoc
/**
 * The Class CustomMessageEditPart.
 */
public class CustomMessageEditPart extends MessageEditPart {

	/**
	 * Instantiates a new custom message edit part.
	 * 
	 * @param view
	 *        the view
	 */
	public CustomMessageEditPart(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

	/*
	 * public void addChild() {
	 * List<EditPart> listchildren = this.getChildren();
	 * if(!listchildren.isEmpty()) {
	 * int size = listchildren.size();
	 * EditPart childEditPart = listchildren.get(0);
	 * this.addChild(childEditPart, size);
	 * listchildren = this.getChildren();
	 * size = listchildren.size();
	 * System.out.printf("Size of ListChildren %d\n", size);
	 * 
	 * }
	 * }
	 */

	@Override
	protected boolean removeFixedChild(EditPart childEditPart) {
		// TODO Auto-generated method stub
		if(childEditPart instanceof MessageNameEditPart) {
			if(childEditPart instanceof MessageNameEditPart) {
				IFigure childFigureBefore = ((GraphicalEditPart)childEditPart).getFigure();
				getPrimaryShape().remove(((MessageNameEditPart)childEditPart).getFigure());
				IFigure childFigure = ((GraphicalEditPart)childEditPart).getFigure();

				if(childFigure.getParent() == null) {
					childFigure.setParent(this.getPrimaryShape());
				}
				if(childFigure.getBounds() == new Rectangle(0, 0, 0, 0)) {
					System.out.println("The bound have changed!!!! ");
					childFigure.setBounds(childFigureBefore.getBounds());
				}

			}
			return true;
		}
		if(childEditPart instanceof AppliedStereotypeMessageEditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @see org.eclipse.papyrus.diagram.communication.edit.parts.MessageEditPart#addFixedChild(org.eclipse.gef.EditPart)
	 * 
	 * @param childEditPart
	 * @return
	 */

	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof MessageNameEditPart) {

			CustomWrappingLabel fFigureMessageCreateLabelFigure = new CustomWrappingLabel();
			fFigureMessageCreateLabelFigure.setText("Message"); //$NON-NLS-1$
			//fFigureMessageCreateLabelFigure.setTextWrap(true);
			fFigureMessageCreateLabelFigure.setTextJustification(PositionConstants.CENTER);
			fFigureMessageCreateLabelFigure.setAlignment(PositionConstants.CENTER);
			fFigureMessageCreateLabelFigure.setIconAlignment(PositionConstants.CENTER);


			IFigure childFigureBefore = ((GraphicalEditPart)childEditPart).getFigure();
			IFigure fig = getFigure();
			if((childFigureBefore == null)) {//First time the label is added to the figure of the message connector

				fig.add(fFigureMessageCreateLabelFigure);
				//getFigure().add(fFigureMessageCreateLabelFigure);
				//setFigure(getFigure());

				((MessageNameEditPart)childEditPart).setLabel(fFigureMessageCreateLabelFigure);
			} else {//The figure has been already removed and now we re-add it to the Message Connector Figure (getFigure())
				fig.add(childFigureBefore);
			}
			return true;
		}
		if(childEditPart instanceof AppliedStereotypeMessageEditPart) {
			((AppliedStereotypeMessageEditPart)childEditPart).setLabel(getPrimaryShape().getAppliedStereotypeLabel());
			return true;
		}
		return false;
	}
}
