/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.figure.node.HTMLCornerBentFigure;
import org.eclipse.papyrus.uml.diagram.sequence.util.ElementIconUtil;
import org.eclipse.swt.graphics.Image;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomCommentBodyEditPart extends CommentBodyEditPart {

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomCommentBodyEditPart(View view) {
		super(view);
	}

	@Override
	protected void setLabelIconHelper(IFigure figure, Image icon) {
		if(figure instanceof HTMLCornerBentFigure) {
			((HTMLCornerBentFigure)figure).setAppliedStereotypeIcon(icon);
		} else {
			super.setLabelIconHelper(figure, icon);
		}
	}

	@Override
	protected Image getLabelIcon() {
		return ElementIconUtil.getLabelIcon(this);
	}
}
