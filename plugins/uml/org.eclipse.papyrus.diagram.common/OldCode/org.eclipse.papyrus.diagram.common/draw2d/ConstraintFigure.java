/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Yury Chernikov (Borland) - initial API and implementation
 */
package org.eclipse.papyrus.diagram.common.draw2d;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;

public class ConstraintFigure extends ConstraintFigureBase {

	private WrapLabel myFixedLabel;

	private IFigure myContentPane;

	public ConstraintFigure() {
		super(100, 60, new Insets());
		setLayoutManager(createMainLayout());
		myFixedLabel = addLabel();
		myContentPane = addContentPane();
	}

	public IFigure getContentPane() {
		return myContentPane;
	}

	public void setFixedLabelText(String text) {
		myFixedLabel.setText(text == null ? "" : text); //$NON-NLS-1$
	}

	protected LayoutManager createMainLayout() {
		return new BorderLayout();
	}

	protected WrapLabel addLabel() {
		WrapLabel label = new WrapLabel(""); //$NON-NLS-1$
		label.setBorder(new MarginBorder(0, CLIP_MARGIN_DP + 1, 0, CLIP_MARGIN_DP + 1));
		add(label, BorderLayout.TOP);
		return label;
	}

	protected IFigure addContentPane() {
		RectangleFigure contentPane = new RectangleFigure();
		contentPane.setOutline(false);
		contentPane.setFill(false);
		contentPane.setLayoutManager(new StackLayout());
		add(contentPane, BorderLayout.CENTER);
		return contentPane;
	}

}
