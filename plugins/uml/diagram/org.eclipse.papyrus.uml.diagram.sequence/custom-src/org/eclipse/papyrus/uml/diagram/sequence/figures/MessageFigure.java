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
package org.eclipse.papyrus.uml.diagram.sequence.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.Shape;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.papyrus.uml.diagram.common.figure.edge.UMLEdgeFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public abstract class MessageFigure extends UMLEdgeFigure {

	private static final Font LABEL_FIGURE_FONT = new Font(Display.getCurrent(), "SANS", 9, SWT.NORMAL);

	private WrappingLabel messageLabelFigure;

	private boolean selection;

	private Cursor customCursor;

	private IMapMode mapMode;

	/**
	 * Constructor.
	 * 
	 */
	public MessageFigure() {
		this(null);
	}

	public MessageFigure(IMapMode mapMode) {
		this.mapMode = mapMode;
		createContents();
		setTargetDecoration(createTargetDecoration());
	}

	public void setLineWidth(int w) {
		super.setLineWidth(w);
		if(getSourceDecoration() instanceof Shape) {
			((Shape)getSourceDecoration()).setLineWidth(w);
		}
		if(getTargetDecoration() instanceof Shape) {
			((Shape)getTargetDecoration()).setLineWidth(w);
		}
	}

	@Override
	public void setForegroundColor(Color c) {
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

	protected abstract RotatableDecoration createTargetDecoration();

	protected void createContents() {
		super.createContents();
		messageLabelFigure = new WrappingLabel();
		messageLabelFigure.setText("");
		messageLabelFigure.setForegroundColor(ColorConstants.black);
		messageLabelFigure.setFont(LABEL_FIGURE_FONT);
		this.add(messageLabelFigure);
	}

	/**
	 * @return the messageLabelFigure
	 */
	public WrappingLabel getMessageLabelFigure() {
		return messageLabelFigure;
	}

	public IMapMode getMapMode() {
		if(mapMode != null) {
			return mapMode;
		}
		return MapModeUtil.getMapMode();
	}

	/**
	 * @return the selection
	 */
	public boolean isSelection() {
		return selection;
	}

	/**
	 * @param selection
	 *        the selection to set
	 */
	public void setSelection(boolean selection) {
		this.selection = selection;
		repaint();
	}

	/**
	 * @return the customCursor
	 */
	public Cursor getCustomCursor() {
		return customCursor;
	}

	/**
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx#getCursor()
	 * 
	 * @return
	 */
	@Override
	public Cursor getCursor() {
		if(customCursor != null) {
			return customCursor;
		}
		return super.getCursor();
	}

	/**
	 * @param customCursor
	 *        the customCursor to set
	 */
	public void setCustomCursor(Cursor customCursor) {
		this.customCursor = customCursor;
	}

	/**
	 * @param mapMode
	 *        the mapMode to set
	 */
	public void setMapMode(IMapMode mapMode) {
		this.mapMode = mapMode;
	}
}
