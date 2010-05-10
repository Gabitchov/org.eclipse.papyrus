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
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

/**
 * 
 * This is used to create the message figure which is a PolylineConnection that has
 * a CustomWrappingLabel
 */
public class MessageFigure extends PolylineConnectionEx {

	private CustomWrappingLabel fFigureMessageCreateLabelFigure;



	static final Font FFIGUREMESSAGECREATELABELFIGURE_FONT = new Font(Display.getCurrent(), "SANS", 9, SWT.NORMAL); //$NON-NLS-1$

	static final String PATH = "/icons/arrow.gif"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public MessageFigure() {
		this.setLineWidth(1);
		this.setLineStyle(Graphics.LINE_SOLID);
		this.setForegroundColor(ColorConstants.black);

		createContents();

	}



	private void createContents() {

		fFigureMessageCreateLabelFigure = new CustomWrappingLabel();
		fFigureMessageCreateLabelFigure.setText("blabla"); //$NON-NLS-1$


		fFigureMessageCreateLabelFigure.setFont(FFIGUREMESSAGECREATELABELFIGURE_FONT);
		fFigureMessageCreateLabelFigure.setOpaque(false);
		this.add(fFigureMessageCreateLabelFigure);


	}

	/**
	 * 
	 * @return fFigureMessageCreateLabelFigure
	 */
	public CustomWrappingLabel getFigureMessageCreateLabelFigure() {
		return fFigureMessageCreateLabelFigure;
	}



}
