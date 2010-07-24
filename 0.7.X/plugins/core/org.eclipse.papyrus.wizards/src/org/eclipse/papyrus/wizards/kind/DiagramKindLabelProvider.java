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
package org.eclipse.papyrus.wizards.kind;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.core.extension.commands.CreationCommandDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * The Class DiagramCategoryLabelProvider.
 */
public class DiagramKindLabelProvider implements ILabelProvider {

	private static final String UNDEFINED_ELEMENT = "<undefined>";

	public Image getImage(Object element) {
		// TODO use ImageRegistry to store images
		if(element != null && element instanceof CreationCommandDescriptor) {
			ImageDescriptor image = ((CreationCommandDescriptor)element).getIcon();
			// image is an optional attribute
			if(image != null) {
				return new Image(null, image.getImageData());
			}
		}
		return null;
	}

	public String getText(Object element) {
		if(element != null && element instanceof CreationCommandDescriptor) {
			return ((CreationCommandDescriptor)element).getLabel();
		}
		return UNDEFINED_ELEMENT;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addListener(ILabelProviderListener listener) {
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeListener(ILabelProviderListener listener) {
	}

}