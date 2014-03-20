/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.Shape;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeTypes;
import org.eclipse.papyrus.uml.diagram.common.figure.edge.UMLEdgeFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

public abstract class AbstractMessageFigure extends UMLEdgeFigure {

	protected static final Font LABEL_FONT = new Font(Display.getCurrent(), "SANS", 9, SWT.NORMAL); //$NON-NLS-1$

	private WrappingLabel messageLabel;

	@Override
	public void paint(final Graphics graphics) {
		graphics.setAntialias(SWT.ON);
		super.paint(graphics);
	}

	public AbstractMessageFigure() {
		// setForegroundColor(ColorConstants.black);
		setForegroundColor(getForegroundColor());
		setSourceDecoration(createSourceDecoration());
		setTargetDecoration(createTargetDecoration());
	}

	// meant to be overridden
	@SuppressWarnings("static-method")
	protected RotatableDecoration createSourceDecoration() {
		return null;
	}

	// meant to be overridden
	@SuppressWarnings("static-method")
	protected RotatableDecoration createTargetDecoration() {
		return null;
	}

	@Override
	protected void createContents() {
		super.createContents();
		this.messageLabel = new WrappingLabel();
		this.messageLabel.setText(""); //$NON-NLS-1$
		this.messageLabel.setFont(LABEL_FONT);
		add(this.messageLabel);
	}

	public WrappingLabel getMessageLabel() {
		return this.messageLabel;
	}

	@Override
	public void setLineWidth(final int w) {
		super.setLineWidth(w);
		if(getSourceDecoration() instanceof Shape) {
			((Shape)getSourceDecoration()).setLineWidth(w);
		}
		if(getTargetDecoration() instanceof Shape) {
			((Shape)getTargetDecoration()).setLineWidth(w);
		}
	}

	@Override
	public void setForegroundColor(final Color c) {
		super.setForegroundColor(c);
		if(getSourceDecoration() instanceof Shape) {
			((Shape)getSourceDecoration()).setForegroundColor(c);
			((Shape)getSourceDecoration()).setBackgroundColor(c);
		}
		if(getTargetDecoration() instanceof Shape) {
			((Shape)getTargetDecoration()).setForegroundColor(c);
			((Shape)getTargetDecoration()).setBackgroundColor(c);
		}
	}

	@Override
	public void resetStyle() {
		super.resetStyle();
		setSourceDecoration(createSourceDecoration());
		setTargetDecoration(createTargetDecoration());
	}

	protected static IMapMode getMapMode() {
		return MapModeTypes.IDENTITY_MM;
	}
}
