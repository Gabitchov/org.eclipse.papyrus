/*******************************************************************************
 * Copyright (c) 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 379683 - customizable Tree content provider
 *    Nicolas Bros (Mia-Software) - Bug 380407 - Missing since tag on CustomizedContentProviderUtils
 *******************************************************************************/
package org.eclipse.emf.facet.custom.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EAttributeTreeElement;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EReferenceTreeElement;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

/**
 * A companion utility class for {@link ICustomizedTreeContentProvider}
 * 
 * @since 0.2
 */
public final class CustomizedContentProviderUtils {
	private CustomizedContentProviderUtils() {
		// utility class
	}

	/**
	 * Replace proxy objects by their underlying model elements in the given selection
	 * 
	 * @return the unwrapped version of the selection
	 */
	public static ISelection resolveSelection(final ISelection selection) {
		Assert.isNotNull(selection);
		ISelection result;
		if (selection instanceof IStructuredSelection) {
			final IStructuredSelection strSelection = (IStructuredSelection) selection;
			final List<Object> resolvedElements = new ArrayList<Object>();
			final Iterator<?> iterator = strSelection.iterator();
			while (iterator.hasNext()) {
				final Object element = iterator.next();
				resolvedElements.add(resolve(element));
			}
			result = new StructuredSelection(resolvedElements);
		} else {
			throw new IllegalArgumentException("Unhandled selection type: " + selection.getClass().getName()); //$NON-NLS-1$
		}
		return result;
	}

	/**
	 * Resolve the given UI element into the underlying model element.
	 * 
	 * @param element
	 *            a UI element, that may be a proxy for a model element
	 * @return the corresponding model element, or the given element if it is not a proxy
	 */
	public static Object resolve(final Object element) {
		Object resolved = element;
		if (element instanceof EObjectTreeElement) {
			resolved = ((EObjectTreeElement) element).getEObject();
		} else if (element instanceof EAttributeTreeElement) {
			resolved = ((EAttributeTreeElement) element).getEAttribute();
		} else if (element instanceof EReferenceTreeElement) {
			resolved = ((EReferenceTreeElement) element).getEReference();
		}
		return resolved;
	}
}
