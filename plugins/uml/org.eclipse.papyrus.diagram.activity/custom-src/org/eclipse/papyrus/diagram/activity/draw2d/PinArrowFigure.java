/*******************************************************************************
 * Copyright (c) 2007-2009 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Marc Gil Sendra (Prodevelop) - Initial api implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.activity.draw2d;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPin2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPin3EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPin4EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPin5EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPin6EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPin2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPin3EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPin4EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePin2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinEditPart;

/**
 * A figure showing an enclosed Arrow that points to its parent figure according to which side it is located.
 * 
 * @author <a href="mailto:mgil@prodevelop.es">Marc Gil</a>
 */
public class PinArrowFigure extends Shape {

	protected EditPart editPart;

	public PinArrowFigure(EditPart EP) {
		super();
		editPart = EP;
	}

	@Override
	protected void outlineShape(Graphics graphics) {
		Rectangle r = getBounds();

		if (editPart instanceof ValuePinEditPart || editPart instanceof ValuePin2EditPart) {
			if (((BorderedBorderItemEditPart) editPart).getBorderItemLocator().getCurrentSideOfParent() == PositionConstants.WEST)
				drawWEST(graphics, r);
			if (((BorderedBorderItemEditPart) editPart).getBorderItemLocator().getCurrentSideOfParent() == PositionConstants.EAST)
				drawEAST(graphics, r);
			if (((BorderedBorderItemEditPart) editPart).getBorderItemLocator().getCurrentSideOfParent() == PositionConstants.NORTH)
				drawNORTH(graphics, r);
			if (((BorderedBorderItemEditPart) editPart).getBorderItemLocator().getCurrentSideOfParent() == PositionConstants.SOUTH)
				drawSOUTH(graphics, r);

			drawV(graphics, r);
		} else if (editPart instanceof InputPinEditPart || editPart instanceof InputPin2EditPart || editPart instanceof InputPin3EditPart || editPart instanceof InputPin4EditPart
				|| editPart instanceof InputPin5EditPart || editPart instanceof InputPin6EditPart) {
			if (((BorderedBorderItemEditPart) editPart).getBorderItemLocator().getCurrentSideOfParent() == PositionConstants.WEST)
				drawWEST(graphics, r);
			if (((BorderedBorderItemEditPart) editPart).getBorderItemLocator().getCurrentSideOfParent() == PositionConstants.EAST)
				drawEAST(graphics, r);
			if (((BorderedBorderItemEditPart) editPart).getBorderItemLocator().getCurrentSideOfParent() == PositionConstants.NORTH)
				drawNORTH(graphics, r);
			if (((BorderedBorderItemEditPart) editPart).getBorderItemLocator().getCurrentSideOfParent() == PositionConstants.SOUTH)
				drawSOUTH(graphics, r);
		} else if (editPart instanceof OutputPinEditPart || editPart instanceof OutputPin2EditPart || editPart instanceof OutputPin3EditPart || editPart instanceof OutputPin4EditPart) {
			if (((BorderedBorderItemEditPart) editPart).getBorderItemLocator().getCurrentSideOfParent() == PositionConstants.WEST)
				drawEAST(graphics, r);
			if (((BorderedBorderItemEditPart) editPart).getBorderItemLocator().getCurrentSideOfParent() == PositionConstants.EAST)
				drawWEST(graphics, r);
			if (((BorderedBorderItemEditPart) editPart).getBorderItemLocator().getCurrentSideOfParent() == PositionConstants.NORTH)
				drawSOUTH(graphics, r);
			if (((BorderedBorderItemEditPart) editPart).getBorderItemLocator().getCurrentSideOfParent() == PositionConstants.SOUTH)
				drawNORTH(graphics, r);
		}
	}

	private void drawWEST(Graphics graphics, Rectangle r) {
		// center line
		graphics.drawLine(r.getTopLeft().x + 1, r.getTopLeft().y + 7, r.getBottomRight().x - 2, r.getBottomRight().y - 8);
		// top line
		graphics.drawLine(r.getBottomRight().x - 2, r.getBottomRight().y - 8, r.getTopRight().x - 6, r.getTopRight().y + 3);
		// bottom line
		graphics.drawLine(r.getBottomRight().x - 2, r.getBottomRight().y - 8, r.getBottomRight().x - 6, r.getBottomRight().y - 4);
	}

	private void drawEAST(Graphics graphics, Rectangle r) {
		// center line
		graphics.drawLine(r.getBottomRight().x - 2, r.getBottomRight().y - 8, r.getTopLeft().x + 1, r.getTopLeft().y + 7);
		// top line
		graphics.drawLine(r.getTopLeft().x + 1, r.getTopLeft().y + 7, r.getTopLeft().x + 5, r.getTopLeft().y + 3);
		// bottom line
		graphics.drawLine(r.getTopLeft().x + 1, r.getTopLeft().y + 7, r.getBottomLeft().x + 5, r.getBottomLeft().y - 4);
	}

	private void drawNORTH(Graphics graphics, Rectangle r) {
		// center line
		graphics.drawLine(r.getTopLeft().x + 7, r.getTopLeft().y + 1, r.getBottomRight().x - 8, r.getBottomRight().y - 2);
		// left line
		graphics.drawLine(r.getBottomRight().x - 8, r.getBottomRight().y - 2, r.getBottomLeft().x + 3, r.getBottomLeft().y - 6);
		// right line
		graphics.drawLine(r.getBottomRight().x - 8, r.getBottomRight().y - 2, r.getBottomRight().x - 4, r.getBottomRight().y - 6);
	}

	private void drawSOUTH(Graphics graphics, Rectangle r) {
		// center line
		graphics.drawLine(r.getTopLeft().x + 7, r.getTopLeft().y + 1, r.getBottomRight().x - 8, r.getBottomRight().y - 2);
		// left line
		graphics.drawLine(r.getTopLeft().x + 7, r.getTopLeft().y + 1, r.getTopLeft().x + 3, r.getTopLeft().y + 6);
		// right line
		graphics.drawLine(r.getTopLeft().x + 7, r.getTopLeft().y + 1, r.getTopRight().x - 4, r.getTopRight().y + 6);
	}

	private void drawV(Graphics graphics, Rectangle r) {
		// Left V line
		graphics.drawLine(r.getBottomRight().x - 3, r.getBottomRight().y - 2, r.getBottomRight().x - 4, r.getBottomRight().y - 4);

		// Right V lint
		graphics.drawLine(r.getBottomRight().x - 3, r.getBottomRight().y - 2, r.getBottomRight().x - 2, r.getBottomRight().y - 4);
	}

	@Override
	protected void fillShape(Graphics graphics) {
	}
}
