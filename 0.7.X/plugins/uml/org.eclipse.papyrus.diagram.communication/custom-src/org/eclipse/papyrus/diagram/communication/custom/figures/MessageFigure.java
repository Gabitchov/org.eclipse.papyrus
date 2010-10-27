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
package org.eclipse.papyrus.diagram.communication.custom.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.papyrus.diagram.common.figure.node.IPapyrusUMLElementFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

/**
 * 
 * This is used to create the message figure which is a PolylineConnection that
 * has a CustomWrappingLabel
 */
public class MessageFigure extends PolylineConnectionEx implements IPapyrusUMLElementFigure {




	private CustomWrappingLabel fFigureMessageCreateLabelFigure;

	private CustomWrappingLabel appliedStereotypeLabelFigure;

	static final Font FFIGUREMESSAGECREATELABELFIGURE_FONT = new Font(Display.getCurrent(), "Arial", 8, SWT.NORMAL); //$NON-NLS-1$


	/**
	 * 
	 * Constructor.
	 * 
	 */
	public MessageFigure() {
		this.setLineWidth(1);
		this.setLineStyle(Graphics.LINE_SOLID);
		this.setForegroundColor(ColorConstants.white);
		this.setBackgroundColor(ColorConstants.white);

		createContents();

	}

	private void createContents() {

		appliedStereotypeLabelFigure = new CustomWrappingLabel();
		appliedStereotypeLabelFigure.setText(""); //$NON-NLS-1$


		appliedStereotypeLabelFigure.setTextWrap(true);
		appliedStereotypeLabelFigure.setTextJustification(PositionConstants.CENTER);



		this.add(appliedStereotypeLabelFigure);
	}

	/**
	 * 
	 * @return fFigureMessageCreateLabelFigure
	 */

	public CustomWrappingLabel getFigureMessageCreateLabelFigure() {
		return fFigureMessageCreateLabelFigure;
	}

	/**
	 * Sets the stereotypes for this figure.
	 * <p>
	 * This implementation checks if the specified string is null or not.
	 * <ul>
	 * <li>if the string is <code>null</code>, it removes the label representing the stereotypes.</li>
	 * <li>if this is not <code>null</code>, it creates the stereotype label if needed and displays the specified string.</li>
	 * </ul>
	 * </p>
	 * 
	 * @param stereotypes
	 *        the string representing the stereotypes to be displayed
	 * @param image
	 *        the image representing the stereotypes to be displayed
	 * @see org.eclipse.papyrus.diagram.common.figure.node.IPapyrusUMLElementFigure#setStereotypeDisplay(java.lang.String,
	 *      org.eclipse.swt.graphics.Image)
	 */
	public void setStereotypeDisplay(String stereotypes, Image image) {
		// Set stereotype text on figure
		if(!"".equals(stereotypes)) { //$NON-NLS-1$
			appliedStereotypeLabelFigure.setText(stereotypes);
		} else {
			appliedStereotypeLabelFigure.setText(""); //$NON-NLS-1$
		}

		appliedStereotypeLabelFigure.setIcon(image);

	}

	/**
	 * get the applied stereotype label
	 * 
	 * @return applied stereotype label
	 */
	public CustomWrappingLabel getAppliedStereotypeLabel() {
		return appliedStereotypeLabelFigure;
	}


}
