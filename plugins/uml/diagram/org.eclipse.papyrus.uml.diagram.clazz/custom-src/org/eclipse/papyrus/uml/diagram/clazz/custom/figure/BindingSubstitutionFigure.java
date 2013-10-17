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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.clazz.custom.figure;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IMultilineEditableFigure;
import org.eclipse.swt.graphics.Image;

/**
 * this is a label that can be etited as multiline
 * 
 */
public class BindingSubstitutionFigure extends FlowPage implements ILabelFigure, IMultilineEditableFigure {

	protected TextFlowEx textFlow;

	public BindingSubstitutionFigure() {
		this.setOpaque(false);
		textFlow = new TextFlowEx("");
		this.add(textFlow);
	}

	/**
	 * 
	 * @return the textflow of the constraint that contain the string of the specification
	 */
	public TextFlowEx getTextFlow() {
		return textFlow;
	}

	/**
	 * 
	 * @return the container of the text flow
	 */
	public FlowPage getPageFlow() {
		return this;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure#getText()
	 * 
	 * @return the display string that represents the specification
	 */
	public String getText() {
		return textFlow.getText();
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure#setText(java.lang.String)
	 * 
	 * @param text
	 */
	public void setText(String text) {
		// generates new ones
		textFlow.setText(text);
	}

	public BindingSubstitutionFigure getTemplateBindingFigure() {
		return this;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure#setIcon(org.eclipse.swt.graphics.Image)
	 * 
	 */
	public void setIcon(Image icon) {
		// TODO Auto-generated method stub
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure#getIcon()
	 * 
	 */
	public Image getIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.IMultilineEditableFigure#getEditionLocation()
	 * 
	 */
	public Point getEditionLocation() {
		return this.getLocation();
	}
}
