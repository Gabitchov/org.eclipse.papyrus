/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime.propertyeditor;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.papyrus.commands.CheckedOperationHistory;
import org.eclipse.papyrus.views.properties.runtime.Activator;


/**
 * Property editor for Primitive typed-properties
 */
public class MultiplePrimitiveTypedPropertyEditor extends AbstractTablePropertyEditor {

	/** id of this editor */
	public static final String ID = "org.eclipse.papyrus.views.properties.runtime.multiplePrimitiveTypedPropertyEditor";

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected EditingSupport createEditingSupport() {
		return new StringEditingSupport(viewer);
	}

	/**
	 * Editing support for the viewer
	 */
	protected class StringEditingSupport extends EditingSupport {

		/**
		 * Creates a new StringEditingSupport.
		 * 
		 * @param viewer
		 *        the viewer in which this suport is added
		 */
		public StringEditingSupport(ColumnViewer viewer) {
			super(viewer);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected CellEditor getCellEditor(Object element) {
			return new TextCellEditor(table);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected boolean canEdit(Object element) {
			return true;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected Object getValue(Object element) {
			return element;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected void setValue(Object element, Object value) {
			// retrieve the index of the element in the list of values
			int index = viewer.getTable().getSelectionIndex();
			// retrieves the operation to set the value
			IUndoableOperation operation = getController().getEditValueOperation(index, table, value);
			if(operation != null && operation.canExecute()) {
				try {
					CheckedOperationHistory.getInstance().execute(operation, new NullProgressMonitor(), null);
				} catch (ExecutionException e) {
					Activator.log.error(e);
				}
			}
		}

	}

}
