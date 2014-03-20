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
package org.eclipse.papyrus.uml.diagram.wizards.kind;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;
import org.eclipse.papyrus.uml.diagram.wizards.Messages;
import org.eclipse.swt.graphics.Image;

/**
 * The LabelProvider for DiagramCategory table.
 * Returns labels and images for the categories as is specified in its descriptor(e.g. read from plugin.xml).
 */
public class DiagramKindLabelProvider implements ILabelProvider {

	/** The Constant UNDEFINED_ELEMENT. */
	private static final String UNDEFINED_ELEMENT = Messages.DiagramKindLabelProvider_undefined_element;

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
	 */
	public Image getImage(Object element) {
		if(element instanceof ViewPrototype) {
			ViewPrototype proto = (ViewPrototype)element;
			return proto.getIcon();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 */
	public String getText(Object element) {
		if(element instanceof ViewPrototype) {
			ViewPrototype proto = (ViewPrototype)element;
			return proto.getLabel();
		}
		return UNDEFINED_ELEMENT;
	}

	/**
	 * Adds the listener.
	 *
	 * @param listener the listener
	 * {@inheritDoc}
	 */
	public void addListener(ILabelProviderListener listener) {
	}

	/**
	 * Dispose.
	 *
	 * {@inheritDoc}
	 */
	public void dispose() {
	}

	/**
	 * Checks if is label property.
	 *
	 * @param element the element
	 * @param property the property
	 * @return true, if is label property
	 * {@inheritDoc}
	 */
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/**
	 * Removes the listener.
	 *
	 * @param listener the listener
	 * {@inheritDoc}
	 */
	public void removeListener(ILabelProviderListener listener) {
	}

}