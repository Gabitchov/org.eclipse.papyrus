/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.widgets.providers;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

/**
 * A mutable wrapper for {@link ILabelProvider}s
 * May be used when you need to instantiate a component with a labelProvider,
 * and you don't have one yet.
 * If there is no wrapped label provider, the default toString method will be called
 * on non-null objects.
 * 
 * @author Camille Letavernier
 * 
 */
public class WrappedLabelProvider implements ILabelProvider {

	/**
	 * The wrapped LabelProvider
	 */
	private ILabelProvider labelProvider;

	/**
	 * Constructs a new empty Label provider wrapper.
	 */
	public WrappedLabelProvider() {

	}

	/**
	 * 
	 * Constructs a new Label provider, wrapping the specified label provider.
	 * 
	 * @param provider
	 *        The wrapped label provider
	 */
	public WrappedLabelProvider(ILabelProvider provider) {
		this.labelProvider = provider;
	}

	/**
	 * Changes the wrapped label provider
	 * 
	 * @param provider
	 *        The new wrapped label provider
	 */
	public void setLabelProvider(ILabelProvider provider) {
		this.labelProvider = provider;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addListener(ILabelProviderListener listener) {
		//Nothing
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		//Nothing
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isLabelProperty(Object element, String property) {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeListener(ILabelProviderListener listener) {
		//Nothing
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage(Object element) {
		if(labelProvider != null)
			return labelProvider.getImage(element);
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText(Object element) {
		if(labelProvider != null)
			return labelProvider.getText(element);
		if(element == null)
			return "null"; //$NON-NLS-1$
		return element.toString();
	}

}
