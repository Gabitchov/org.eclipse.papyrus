/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.swt.graphics.Image;

/**
 * Flow Page that accept a text formatted in html, and displays it under a
 * styled form
 */
public class HTMLCornerBentBodyFigure extends Figure implements ILabelFigure {

	/** text displayed by this figure */
	private String text;

	/** icon displayed by this figure */
	private Image icon;

	/** main flow page for this figure */
	private FlowPage flowPage;

	/**
	 * Creates a new HTMLCornerBentBodyFigure.
	 */
	public HTMLCornerBentBodyFigure() {
		// flowPage = new FlowPage();
		// flowPage.setBackgroundColor(new Color(Display.getCurrent(), new
		// RGB(100, 100, 100)));
		// this.add(flowPage);
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure#setText(java.lang.String)
	 * 
	 * @param text
	 *        the text to display
	 */
	public void setText(String text) {
		this.text = text;

		// TextFlowEx textFlow1 = new TextFlowEx();
		// textFlow1.setText("textFlow1 ");
		// this.add(textFlow1);

	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure#getText()
	 * 
	 * @return the text displayed by this figure
	 */
	public String getText() {
		return text;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure#getIcon()
	 * 
	 * @return
	 */
	public Image getIcon() {
		return icon;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure#setIcon(org.eclipse.swt.graphics.Image)
	 * 
	 * @param icon
	 */
	public void setIcon(Image icon) {
		this.icon = icon;
	}
}
