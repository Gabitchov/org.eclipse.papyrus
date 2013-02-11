/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.common.provider;

import java.util.List;

import org.eclipse.jface.viewers.IElementComparer;
import org.eclipse.jface.viewers.StructuredSelection;

/**
 * 
 * This class
 * 
 */
public class AdaptableStructuredSelection extends StructuredSelection implements IAdaptableStructuredSelection {

	public AdaptableStructuredSelection() {
		super();
	}

	public AdaptableStructuredSelection(final Object[] elements) {
		super(elements);

	}

	public AdaptableStructuredSelection(final Object element) {
		super(element);

	}

	public AdaptableStructuredSelection(final List elements) {
		super(elements);

	}

	public AdaptableStructuredSelection(final List elements, final IElementComparer comparer) {
		super(elements, comparer);

	}

	public Object getAdapter(final Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

}
