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
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.wizards.template;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * The Class ModelTemplatesLabelProvider.
 */
public class ModelTemplatesLabelProvider implements ITableLabelProvider {

	/**
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
	 * 
	 * @param element
	 * @param columnIndex
	 */
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	/**
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
	 * 
	 * @param element
	 * @param columnIndex
	 */
	public String getColumnText(Object element, int columnIndex) {
		if(element instanceof ModelTemplateDescription) {
			ModelTemplateDescription modelTemplate = (ModelTemplateDescription)element;
			return modelTemplate.getName() + " (" + modelTemplate.getFileName() + ")";
		}
		return null;
	}

	/**
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 *
	 * @param listener
	 */
	public void addListener(ILabelProviderListener listener) {

	}

	/**
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 *
	 */
	public void dispose() {

	}

	/**
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 *
	 * @param element
	 * @param property
	 */
	public boolean isLabelProperty(Object element, String property) {

		return false;
	}

	/**
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 *
	 * @param listener
	 */
	public void removeListener(ILabelProviderListener listener) {

	}

}
