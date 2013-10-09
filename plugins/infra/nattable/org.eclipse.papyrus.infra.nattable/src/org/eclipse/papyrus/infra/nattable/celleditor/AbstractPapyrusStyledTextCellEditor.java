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
package org.eclipse.papyrus.infra.nattable.celleditor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.nattable.celleditor.AbstractStyledTextCellEditor;
import org.eclipse.papyrus.infra.nattable.manager.table.ITableAxisElementProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;

/**
 * Abstract Class for StyledText cell editor.
 * This class is used for XText Cell Editor
 * 
 * @author vl222926
 * 
 */
public abstract class AbstractPapyrusStyledTextCellEditor extends AbstractStyledTextCellEditor {

	/**
	 * the table
	 */
	protected final Table table;

	/**
	 * the axis element on which this cell editor is declared
	 */
	protected final Object axisElement;

	/**
	 * the table element provider
	 */
	protected final ITableAxisElementProvider elementProvider;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param table
	 * @param axisElement
	 * @param elementProvider
	 * @param commitOnUpDown
	 * @param moveSelectionOnEnter
	 */
	public AbstractPapyrusStyledTextCellEditor(final Table table, final Object axisElement, final ITableAxisElementProvider elementProvider, boolean commitOnUpDown, boolean moveSelectionOnEnter) {
		super(commitOnUpDown, moveSelectionOnEnter);
		this.table = table;
		this.axisElement = axisElement;
		this.elementProvider = elementProvider;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param table
	 * @param axisElement
	 * @param elementProvider
	 */
	public AbstractPapyrusStyledTextCellEditor(final Table table, final Object axisElement, final ITableAxisElementProvider elementProvider) {
		this(table, axisElement, elementProvider, false);
	}


	/**
	 * 
	 * Constructor.
	 * 
	 * @param table
	 * @param axisElement
	 * @param elementProvider
	 * @param commitOnUpDown
	 */
	public AbstractPapyrusStyledTextCellEditor(final Table table, final Object axisElement, final ITableAxisElementProvider elementProvider, boolean commitOnUpDown) {
		this(table, axisElement, elementProvider, commitOnUpDown, false);
	}

	/**
	 * 
	 * @return the edited object
	 */
	protected abstract EObject getEditedEObject();
}
