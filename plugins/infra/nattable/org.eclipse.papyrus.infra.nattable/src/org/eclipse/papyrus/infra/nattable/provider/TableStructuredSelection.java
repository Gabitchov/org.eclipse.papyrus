/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.infra.nattable.provider;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.IElementComparer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.nattable.utils.TableSelectionWrapper;

/**
 * The StructuredSelection filled by the tables. It able to embed more precision about the selected elements in the table.
 * 
 * @author vl222926
 * 
 */
public class TableStructuredSelection extends StructuredSelection implements IAdaptable {

	/**
	 * the wrapper for the table selection
	 */
	private final TableSelectionWrapper wrapper;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param wrapper
	 */
	public TableStructuredSelection(TableSelectionWrapper wrapper) {
		super();
		this.wrapper = wrapper;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param elements
	 * @param comparer
	 * @param wrapper
	 */
	public TableStructuredSelection(List<?> elements, IElementComparer comparer, TableSelectionWrapper wrapper) {
		super(elements, comparer);
		this.wrapper = wrapper;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param elements
	 * @param wrapper
	 */
	public TableStructuredSelection(List<?> elements, TableSelectionWrapper wrapper) {
		super(elements);
		this.wrapper = wrapper;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param element
	 * @param wrapper
	 */
	public TableStructuredSelection(Object element, TableSelectionWrapper wrapper) {
		super(element);
		this.wrapper = wrapper;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param elements
	 * @param wrapper
	 */
	public TableStructuredSelection(Object[] elements, TableSelectionWrapper wrapper) {
		super(elements);
		this.wrapper = wrapper;
	}

	/**
	 * 
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 * 
	 * @param adapter
	 * @return
	 */
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if(adapter == TableSelectionWrapper.class) {
			return this.wrapper;
		}
		return null;
	}


}
