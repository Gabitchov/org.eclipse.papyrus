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
package org.eclipse.papyrus.uml.diagram.wizards.template;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.papyrus.uml.diagram.wizards.Messages;
import org.eclipse.swt.graphics.Image;

/**
 * The Class ModelTemplatesLabelProvider.
 */
public class ModelTemplatesLabelProvider implements ITableLabelProvider {

	/**
	 * Gets the column image.
	 *
	 * @param element the element
	 * @param columnIndex the column index
	 * @return the column image
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
	 */
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	/**
	 * Gets the column text.
	 *
	 * @param element the element
	 * @param columnIndex the column index
	 * @return the column text
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
	 */
	public String getColumnText(Object element, int columnIndex) {
		if(element instanceof ModelTemplateDescription) {
			ModelTemplateDescription modelTemplate = (ModelTemplateDescription)element;
			return Messages.bind(org.eclipse.papyrus.uml.diagram.wizards.Messages.ModelTemplatesLabelProvider_model_template_description_text, modelTemplate.getName(), modelTemplate.getFileName());
		}
		return null;
	}

	/**
	 * Adds the listener.
	 *
	 * @param listener the listener
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void addListener(ILabelProviderListener listener) {

	}

	/**
	 * Dispose.
	 *
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	public void dispose() {

	}

	/**
	 * Checks if is label property.
	 *
	 * @param element the element
	 * @param property the property
	 * @return true, if is label property
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 */
	public boolean isLabelProperty(Object element, String property) {

		return false;
	}

	/**
	 * Removes the listener.
	 *
	 * @param listener the listener
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void removeListener(ILabelProviderListener listener) {

	}

}
