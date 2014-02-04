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

import org.eclipse.gef.rulers.RulerProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.UnitsConstants;
import org.eclipse.swt.graphics.Image;

/**
 * 
 * Label provider for Units
 * 
 */
public class UnitsLabelProvider implements ILabelProvider {

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 * 
	 * @param listener
	 */
	public void addListener(ILabelProviderListener listener) {
		//not used
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 * 
	 */
	public void dispose() {
		//not used
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
		//not used
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	public Image getImage(Object element) {
		//not used
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
			final int unit = (Integer)element;
			switch(unit) {
			case RulerProvider.UNIT_INCHES:
				return UnitsConstants.INCHES;
			case RulerProvider.UNIT_CENTIMETERS:
				return UnitsConstants.CENTIMETERS;
			case RulerProvider.UNIT_PIXELS:
				return UnitsConstants.PIXELS;
			default:
				break;
			}
		}
		return "";
	}

}
