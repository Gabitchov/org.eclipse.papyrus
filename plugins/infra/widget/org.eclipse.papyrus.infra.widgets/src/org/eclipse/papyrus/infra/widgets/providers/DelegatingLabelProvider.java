/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.providers;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

/**
 * A label provider that delegates to some other label provider with the
 * possibility of overriding certain labels.
 */
public class DelegatingLabelProvider
		implements ILabelProvider {

	private final ILabelProvider delegate;

	public DelegatingLabelProvider(ILabelProvider delegate) {
		super();

		this.delegate = delegate;
	}

	public Image getImage(Object element) {
		Image result = customGetImage(element);
		if (result == null) {
			result = delegatedGetImage(element);
		}
		return result;
	}

	/**
	 * Overridden in subclasses to provide custom images for certain
	 * {@code element}s.
	 * 
	 * @param element
	 *            an element
	 * @return the custom image, or {@code null} to delegate
	 */
	protected Image customGetImage(Object element) {
		return null;
	}

	protected Image delegatedGetImage(Object element) {
		return delegate.getImage(element);
	}

	public String getText(Object element) {
		String result = customGetText(element);
		if (result == null) {
			result = delegatedGetText(element);
		}
		return result;
	}

	/**
	 * Overridden in subclasses to provide custom text for certain
	 * {@code element}s.
	 * 
	 * @param element
	 *            an element
	 * @return the custom text, or {@code null} to delegate
	 */
	protected String customGetText(Object element) {
		return null;
	}

	protected String delegatedGetText(Object element) {
		return delegate.getText(element);
	}

	public boolean isLabelProperty(Object element, String property) {
		return delegate.isLabelProperty(element, property);
	}

	public void addListener(ILabelProviderListener listener) {
		delegate.addListener(listener);
	}

	public void removeListener(ILabelProviderListener listener) {
		delegate.removeListener(listener);
	}

	/**
	 * Disposes my delegate.
	 */
	public void dispose() {
		delegate.dispose();
	}

}
