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


public class CrossSelection extends StructuredSelection {

	public CrossSelection() {
		// TODO Auto-generated constructor stub
	}

	public CrossSelection(Object[] elements) {
		super(elements);
		// TODO Auto-generated constructor stub
	}

	public CrossSelection(Object element) {
		super(element);
		// TODO Auto-generated constructor stub
	}

	public CrossSelection(List elements) {
		super(elements);
		// TODO Auto-generated constructor stub
	}

	public CrossSelection(List elements, IElementComparer comparer) {
		super(elements, comparer);
		// TODO Auto-generated constructor stub
	}

}
