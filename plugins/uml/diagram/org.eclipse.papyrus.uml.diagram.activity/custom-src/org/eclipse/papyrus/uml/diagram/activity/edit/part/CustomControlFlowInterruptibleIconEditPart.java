/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *   Arthur Daussy Bug 366159 - [ActivityDiagram] Activity Diagram should be able to handle correctly Interruptible Edge
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ControlFlowInterruptibleIconEditPart;
import org.eclipse.papyrus.uml.diagram.activity.figures.InterruptibleEdgeExternalIconFigure;
import org.eclipse.swt.graphics.Image;

/**
 * Customization of {@link ControlFlowInterruptibleIconEditPart} in order to make it able to handle specific Label Helper
 * 
 * @author arthur daussy
 * 
 */
public class CustomControlFlowInterruptibleIconEditPart extends ControlFlowInterruptibleIconEditPart {

	public CustomControlFlowInterruptibleIconEditPart(View view) {
		super(view);
	}

	/**
	 * Make it handle with {@link InterruptibleEdgeExternalIconFigure}
	 */
	@Override
	protected String getLabelTextHelper(IFigure figure) {
		if(figure instanceof InterruptibleEdgeExternalIconFigure) {
			return "";
		}
		return super.getLabelTextHelper(figure);
	}

	/**
	 * Make it handle with {@link InterruptibleEdgeExternalIconFigure}
	 */
	@Override
	protected void setLabelTextHelper(IFigure figure, String text) {
		if(figure instanceof InterruptibleEdgeExternalIconFigure) {
			//Label can not be set on this figure
			return;
		}
		super.getLabelTextHelper(figure);
	}

	/**
	 * Make it handle with {@link InterruptibleEdgeExternalIconFigure}
	 */
	@Override
	protected Image getLabelIconHelper(IFigure figure) {
		if(figure instanceof InterruptibleEdgeExternalIconFigure) {
			return ((InterruptibleEdgeExternalIconFigure)figure).getImage();
		}
		return super.getLabelIconHelper(figure);
	}

	/**
	 * Make it handle with {@link InterruptibleEdgeExternalIconFigure}
	 */
	@Override
	protected void setLabelIconHelper(IFigure figure, Image icon) {
		if(figure instanceof InterruptibleEdgeExternalIconFigure) {
			//Icon can not be set on this figure
			return;
		}
		super.setLabelIconHelper(figure, icon);
	}
}
