/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.providers;

import org.eclipse.draw2d.Graphics;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.infra.gmfdiag.common.messages.Messages;
import org.eclipse.swt.graphics.Image;

/**
 * 
 * Label Provider for line style
 * 
 */
public class LineStyleLabelProvider implements ILabelProvider {


	public static final String LINE_STYLE_SOLID_STRING = "Solid";

	public static final String LINE_STYLE_DASH_STRING = "Dash";

	public static final String LINE_STYLE_DOT_STRING = "Dot";

	public static final String LINE_STYLE_DASH_DOT_STRING = "Dash Dot";

	public static final String LINE_STYLE_DASH_DOT_DOT_STRING = "Dash Dot Dot";

	public static final String LINE_STYLE_CUSTOM = "Custom";

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 * 
	 * @param listener
	 */
	public void addListener(ILabelProviderListener listener) {
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 * 
	 */
	public void dispose() {
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 * 
	 * @param element
	 * @param property
	 * @return
	 */
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 * 
	 * @param listener
	 */
	public void removeListener(ILabelProviderListener listener) {
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	public Image getImage(Object element) {
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	public String getText(Object element) {
		if(element instanceof Integer) {
			int lineStyle = (Integer)element;
			switch(lineStyle) {
			case Graphics.LINE_SOLID:
				return LINE_STYLE_SOLID_STRING;
			case Graphics.LINE_DASH:
				return LINE_STYLE_DASH_STRING;
			case Graphics.LINE_DOT:
				return LINE_STYLE_DOT_STRING;
			case Graphics.LINE_DASHDOT:
				return LINE_STYLE_DASH_DOT_STRING;
			case Graphics.LINE_DASHDOTDOT:
				return LINE_STYLE_DASH_DOT_DOT_STRING;
			case Graphics.LINE_CUSTOM:
				return LINE_STYLE_CUSTOM;
			default:
				break;
			}
		}
		return null;
	}

}
