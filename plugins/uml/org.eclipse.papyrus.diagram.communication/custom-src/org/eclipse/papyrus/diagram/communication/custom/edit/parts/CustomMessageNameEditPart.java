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
 *  Saadia DHOUIB (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.communication.custom.edit.parts;

import java.awt.Label;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.figure.node.ILabelFigure;
import org.eclipse.papyrus.diagram.communication.custom.figures.CustomWrappingLabel;
import org.eclipse.papyrus.diagram.communication.edit.parts.MessageNameEditPart;
import org.eclipse.papyrus.diagram.communication.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.graphics.Image;

/**
 * 
 * CustomMessageNameEditPart: a custom wrapping label of the MssageEditPart
 * 
 */
public class CustomMessageNameEditPart extends MessageNameEditPart {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomMessageNameEditPart(View view) {
		super(view);
	}

	static final String PATH = "/icons/arrow.gif"; //$NON-NLS-1$

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.communication.edit.parts.MessageNameEditPart#getLabelIcon()
	 * 
	 * @return the specific icon of the label (an arrow)
	 */
	@Override
	public Image getLabelIcon() {
		return org.eclipse.papyrus.diagram.common.Activator.getPluginIconImage(UMLDiagramEditorPlugin.ID, PATH);

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.communication.edit.parts.MessageNameEditPart#setLabelTextHelper(org.eclipse.draw2d.IFigure, java.lang.String)
	 * 
	 * @param figure
	 * @param text
	 */
	@Override
	public void setLabelTextHelper(IFigure figure, String text) {
		if(figure instanceof CustomWrappingLabel) {
			((CustomWrappingLabel)figure).setText(text);
			// added to precise the position of the text relative to
			// the icon
			((WrappingLabel)figure).setTextPlacement(PositionConstants.NORTH);
		} else if(figure instanceof ILabelFigure) {
			((ILabelFigure)figure).setText(text);
		}

		else {
			((Label)figure).setText(text);
		}
	}

}
