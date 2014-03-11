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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.papyrus.uml.diagram.common.figure.edge.UMLEdgeFigure;
import org.eclipse.swt.SWT;

/**
 * this is the link that is a template binding it contains a label that can be edited in multiline
 * 
 * @author PT202707
 * 
 */
public class TemplateBindingFigure extends UMLEdgeFigure {

	protected BindingSubstitutionFigure bindingSubstitutionFigure;

	public TemplateBindingFigure() {
		setAntialias(SWT.ON);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.edge.UMLEdgeFigure#createContents()
	 * 
	 */
	protected void createContents() {
		super.createContents();
		PolygonDecoration dec = new PolygonDecoration();
		dec.setScale(15, 5);
		dec.setBackgroundColor(ColorConstants.white);
		dec.setLineWidth(1);
		setTargetDecoration(dec); // arrow at target endpoint
		setForegroundColor(ColorConstants.black);
		this.setLineStyle(Graphics.LINE_CUSTOM); // line drawing style
		bindingSubstitutionFigure = new BindingSubstitutionFigure();
		this.add(bindingSubstitutionFigure);
	}

	@Override
	public void resetStyle() {
		super.resetStyle();
		PolygonDecoration dec = new PolygonDecoration();
		dec.setScale(15, 5);
		dec.setBackgroundColor(ColorConstants.white);
		dec.setLineWidth(1);
		setTargetDecoration(dec); // arrow at target endpoint
	}

	/**
	 * 
	 * @return the label multiline
	 */
	public BindingSubstitutionFigure getBindingSubstitutionFigure() {
		return bindingSubstitutionFigure;
	}
}
