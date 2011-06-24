/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.ui.hyperlinkshell;

import java.util.ArrayList;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;


/**
 * The Class HyperlinkContentProvider
 * the input has to be a collection.
 */
public class HyperLinkContentProvider implements IStructuredContentProvider {

	/**
	 * {@inheritedDoc}.
	 */
	public void dispose() {
	}

	/**
	 * {@inheritedDoc}.
	 * 
	 * @param viewer
	 *        the viewer
	 * @param oldInput
	 *        the old input
	 * @param newInput
	 *        the new input
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	/**
	 * {@inheritedDoc}.
	 * 
	 * @param inputElement
	 *        the input element
	 * 
	 * @return the elements
	 */
	public Object[] getElements(Object inputElement) {
		if(inputElement instanceof ArrayList<?>) {
			return ((ArrayList<?>)inputElement).toArray();
		}
		return null;
	}

}
