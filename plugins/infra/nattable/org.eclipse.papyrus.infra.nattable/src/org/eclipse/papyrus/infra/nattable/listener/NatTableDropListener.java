/*****************************************************************************
 * Copyright (c) 2012, 2014 CEA LIST and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 430880
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.listener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.manager.cell.CellManagerFactory;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.utils.LocationValue;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.graphics.Point;

/**
 * 
 * This listener allow to manage the drop inside the table
 * 
 */
public class NatTableDropListener implements DropTargetListener {

	/**
	 * the table manager
	 */
	private final INattableModelManager manager;

	/**
	 * the location value to use to drop the elements
	 */
	private LocationValue dropKindValue;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param manager
	 *        the table manager
	 */
	public NatTableDropListener(final INattableModelManager manager) {
		this.manager = manager;
	}

	/**
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetListener#dragEnter(org.eclipse.swt.dnd.DropTargetEvent)
	 * 
	 * @param event
	 */
	public void dragEnter(final DropTargetEvent event) {
		validateDropEvent(event);
	}

	protected void validateDropEvent(final DropTargetEvent event) {
		event.operations = DND.DROP_COPY | DND.DROP_MOVE;
		
		// Move and Link semantics don't make sense for tables which, like diagrams, are visualizations
		// of objects also visualized in other places (such as the Model Explorer)
		event.detail = DND.DROP_COPY;
	}
	
	/**
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetListener#dragLeave(org.eclipse.swt.dnd.DropTargetEvent)
	 * 
	 * @param event
	 */
	public void dragLeave(final DropTargetEvent event) {
		//nothing to do
	}

	/**
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetListener#dragOperationChanged(org.eclipse.swt.dnd.DropTargetEvent)
	 * 
	 * @param event
	 */
	public void dragOperationChanged(final DropTargetEvent event) {
		validateDropEvent(event);
	}

	/**
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetListener#dragOver(org.eclipse.swt.dnd.DropTargetEvent)
	 * 
	 * @param event
	 */
	public void dragOver(final DropTargetEvent event) {
		validateDropEvent(event);
		this.dropKindValue = null;
		final List<Object> droppedElements = getDroppedObjects(event);
		if (droppedElements.isEmpty()) {
			return; // Nothing to do
		}
		this.dropKindValue = this.manager.getLocationInTheTable(new Point(event.x, event.y));
		int drop = DND.DROP_NONE;
		switch(this.dropKindValue.getKind()) {
		case AFTER_COLUMN_HEADER:
			if(this.manager.canDropColumnsElement(droppedElements)) {
				drop = event.detail;
			}
			break;
		case AFTER_ROW_HEADER:
			if(this.manager.canDropRowElement(droppedElements)) {
				drop = event.detail;
			}
			break;
		case COLUMN_HEADER:
			if(this.manager.canInsertColumns(droppedElements, this.dropKindValue.getColumnIndex())) {
				drop = event.detail;
			}
			break;
		case ROW_HEADER:
			if(this.manager.canInsertRow(droppedElements, this.dropKindValue.getRowIndex())) {
				drop = event.detail;
			}
			break;
		case CELL:
			int rowIndex = this.dropKindValue.getRowIndex();
			int columnIndex = this.dropKindValue.getColumnIndex();
			final Object rowElement = this.manager.getRowElement(rowIndex);
			final Object columnElement = this.manager.getColumnElement(columnIndex);
			if(CellManagerFactory.INSTANCE.isCellEditable(columnElement, rowElement)) {
				final TransactionalEditingDomain domain = getEditingDomain();
				final Command cmd = getDropSetValueCommand(domain, droppedElements);
				if(cmd.canExecute()) {
					drop = event.detail;
				}
			}
			break;
		case UNKNOWN:
			drop = DND.DROP_NONE;
			break;
		default:
			drop = DND.DROP_NONE;
			break;
		}
		event.detail = drop;
	}
	
	protected List<Object> getDroppedObjects(DropTargetEvent event) {
		final LocalTransfer localTransfer = LocalTransfer.getInstance();
		final Object data = localTransfer.nativeToJava(event.currentDataType);
		IStructuredSelection structuredSelection = null;
		if(data instanceof IStructuredSelection) {
			structuredSelection = (IStructuredSelection)data;
		} else if(LocalSelectionTransfer.getTransfer().isSupportedType(event.currentDataType)) {
			// Try the local selection transfer
			ISelection selection = LocalSelectionTransfer.getTransfer().getSelection();
			if(selection instanceof IStructuredSelection) {
				structuredSelection = (IStructuredSelection)selection;
			}
		}
		if(structuredSelection == null) {
			return Collections.emptyList();
		}
		return new ArrayList<Object>(extractSelectedObjects(structuredSelection));
	}
	
	protected Collection<?> extractSelectedObjects(IStructuredSelection structuredSelection) {
		return structuredSelection.toList();
	}

	/**
	 * 
	 * @param droppedElements
	 *        the dropped elements
	 * @return
	 *         the command to set the value in the selected cell
	 */
	private Command getDropSetValueCommand(final TransactionalEditingDomain domain, final List<Object> droppedElements) {
		int rowIndex = this.dropKindValue.getRowIndex();
		int columnIndex = this.dropKindValue.getColumnIndex();
		final Object rowElement = this.manager.getRowElement(rowIndex);
		final Object columnElement = this.manager.getColumnElement(columnIndex);
		if(CellManagerFactory.INSTANCE.isCellEditable(columnElement, rowElement)) {
			Object newValue = null;
			final Object currentValue = CellManagerFactory.INSTANCE.getCrossValue(columnElement, rowElement, this.manager);
			if(currentValue instanceof Collection<?>) {
				//the dropped elements will be added to the current Value in case of multivalued cell
				final Collection<Object> tmpNewValue = new ArrayList<Object>();
				tmpNewValue.addAll((Collection<?>)currentValue);
				tmpNewValue.addAll(droppedElements);
				newValue = tmpNewValue;
			} else if(droppedElements.size() == 1) {
				newValue = droppedElements.get(0);
			} else {
				newValue = droppedElements;
			}
			final Command cmd = CellManagerFactory.INSTANCE.getSetCellValueCommand(domain, columnElement, rowElement, newValue, manager);
			return cmd;
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetListener#drop(org.eclipse.swt.dnd.DropTargetEvent)
	 * 
	 * @param event
	 */
	public void drop(final DropTargetEvent event) {
		//we drop the elements into the table
		final List<Object> droppedElements = getDroppedObjects(event);
		if (!droppedElements.isEmpty()) {
			if(this.dropKindValue != null) {
				switch(this.dropKindValue.getKind()) {
				case AFTER_COLUMN_HEADER:
					this.manager.addColumns(droppedElements);
					break;
				case AFTER_ROW_HEADER:
					this.manager.addRows(droppedElements);
					break;
				case COLUMN_HEADER:
					this.manager.insertColumns(droppedElements, this.dropKindValue.getColumnIndex());
					break;
				case ROW_HEADER:
					this.manager.insertRows(droppedElements, this.dropKindValue.getRowIndex());
					break;
				case CELL:
					final TransactionalEditingDomain domain = getEditingDomain();
					final Command cmd = getDropSetValueCommand(domain, droppedElements);
					if(cmd.canExecute()) {
						domain.getCommandStack().execute(cmd);
					}
					break;
				case UNKNOWN:
					break;
				default:
					break;
				}
			}
		}
		this.dropKindValue = null;
	}


	public void dropAccept(final DropTargetEvent event) {
		//nothing to do
	}

	/**
	 * 
	 * @return
	 *         the Transactional Editing Domain to use to edit the model
	 */
	private TransactionalEditingDomain getEditingDomain() {
		TransactionalEditingDomain domain = null;
		ServicesRegistry registry = null;
		try {
			registry = ServiceUtilsForEObject.getInstance().getServiceRegistry(this.manager.getTable().getContext());
		} catch (ServiceException e) {
			Activator.log.error(e);
		}

		if(registry != null) {
			try {
				domain = registry.getService(TransactionalEditingDomain.class);
			} catch (ServiceException e) {
				Activator.log.error(e);
			}
		}
		return domain;
	}

}
