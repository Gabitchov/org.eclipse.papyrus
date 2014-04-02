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
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *  Based on edit policy view from patrick.tessier@cea.fr
 *  
 */
package org.eclipse.papyrus.gmf.figureview.view;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.Shape;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;


/**
 * This is the label provider to display figures
 * 
 */
public class FigureLabelProvider implements ITableLabelProvider, ITableColorProvider {

	protected Color papyrusColor = new Color(Display.getDefault(), 0, 127, 14);

	protected Color customizableDropEditPolicyColor = new Color(Display.getDefault(), 0, 38, 255);

	public void removeListener(ILabelProviderListener listener) {
	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void dispose() {
	}

	public void addListener(ILabelProviderListener listener) {
	}

	public String getColumnText(Object element, int columnIndex) {
		if(element instanceof IFigure) {
			IFigure figure = (IFigure)element;
			switch(columnIndex) {
			case 0:
				String name = figure.getClass().getName();
				int index = name.lastIndexOf("."); //$NON-NLS-1$
				if(index == -1) {
					return name;
				}
				else {
					return name.substring(index + 1);
				}
			case 1:
				return figure.getBounds().toString();
			case 2:
				if(figure.getLayoutManager() != null) {
					return figure.getLayoutManager().getClass().getSimpleName();
				}
				else {
					return "none"; //$NON-NLS-1$
				}
			case 3:
				if(figure.getBorder() != null) {
					String borderInfo = figure.getBorder().getClass().getSimpleName();
					if (figure.getBorder() instanceof LineBorder) {
						borderInfo += String.format(" (%d)", ((LineBorder) figure.getBorder()).getWidth()); //$NON-NLS-1$
					}
					return borderInfo;
				}
				else {
					return "no border"; //$NON-NLS-1$
				}
			case 4:
				if (figure instanceof Shape) {
					return String.format("%d", ((Shape) figure).getLineWidth()); //$NON-NLS-1$
				}
				else if (figure instanceof NodeFigure) {
					return String.format("%d", ((NodeFigure) figure).getLineWidth()); //$NON-NLS-1$
				}
				else {
					return "not avail"; //$NON-NLS-1$
				}
			}
		}
		return "cannot display element: " + element; //$NON-NLS-1$
	}

	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	public Color getForeground(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	public Color getBackground(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
};
