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
package org.eclipse.papyrus.cdo.internal.ui.util;

import java.util.List;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * This is the CompositeLabelProvider type. Enjoy.
 */
public class CompositeLabelProvider
		implements ILabelProvider {

	private List<ILabelProvider> labelProviders = Lists.newArrayList();

	public CompositeLabelProvider() {
		super();
	}

	public CompositeLabelProvider(ILabelProvider provider,
			ILabelProvider... more) {
		this(Lists.asList(provider, more));
	}

	public CompositeLabelProvider(Iterable<? extends ILabelProvider> providers) {
		this();

		Iterables.addAll(this.labelProviders, providers);
	}

	public void addListener(ILabelProviderListener listener) {
		for (ILabelProvider next : labelProviders) {
			next.addListener(listener);
		}
	}

	public void removeListener(ILabelProviderListener listener) {
		for (ILabelProvider next : labelProviders) {
			next.removeListener(listener);
		}
	}

	public void dispose() {
		for (ILabelProvider next : labelProviders) {
			next.dispose();
		}

		labelProviders.clear();
	}

	public boolean isLabelProperty(Object element, String property) {
		for (ILabelProvider next : labelProviders) {
			if (next.isLabelProperty(element, property)) {
				return true;
			}
		}

		return false;
	}

	public Image getImage(Object element) {
		Image result = null;

		for (ILabelProvider next : labelProviders) {
			result = next.getImage(element);

			if (result != null) {
				break;
			}
		}

		return result;
	}

	public String getText(Object element) {
		String result = null;

		for (ILabelProvider next : labelProviders) {
			result = next.getText(element);

			if (result != null) {
				break;
			}
		}

		return result;
	}

}
