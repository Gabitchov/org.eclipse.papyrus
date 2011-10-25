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
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

/**
 * the label provider that inherits of modisco label provider
 * 
 */
public class MoDiscoLabelProviderWTooltips extends ColumnLabelProvider {
	
	private MoDiscoLabelProvider moDiscoLP;
	
	public MoDiscoLabelProviderWTooltips() {
		moDiscoLP = new MoDiscoLabelProvider ();
	}

	@Override
	public String getToolTipText(Object element) {
		return moDiscoLP.getMarkerMessage(element);
	}

	@Override
	public Point getToolTipShift(Object object) {
		return new Point(5, 5);
	}

	@Override
	public int getToolTipDisplayDelayTime(Object object) {
		return 1000;
	}

	@Override
	public int getToolTipTimeDisplayed(Object object) {
		return 10000;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IFontProvider#getFont(java.lang.Object)
	 */
	public Font getFont(Object element) {
		return moDiscoLP.getFont(element);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IColorProvider#getBackground(java.lang.Object)
	 */
	public Color getBackground(Object element) {
		return moDiscoLP.getBackground(element);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IColorProvider#getForeground(java.lang.Object)
	 */
	public Color getForeground(Object element) {
		return moDiscoLP.getForeground(element);
	}

	
	/**
	 * return the image of an element in the model browser
	 * evaluates error markers.
	 */
	@Override
	public Image getImage(Object element) {
		return moDiscoLP.getImage(element);
	}

	/**
	 * @see org.eclipse.gmt.modisco.infra.browser.uicore.CustomizableModelLabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		return moDiscoLP.getText(element);
	}	
}
