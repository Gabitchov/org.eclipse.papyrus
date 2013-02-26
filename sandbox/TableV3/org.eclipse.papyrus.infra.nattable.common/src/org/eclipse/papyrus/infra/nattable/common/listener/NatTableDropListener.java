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
package org.eclipse.papyrus.infra.nattable.common.listener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.common.utils.LocationValue;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.graphics.Point;


public class NatTableDropListener implements DropTargetListener {


	private final INattableModelManager manager;

	private LocationValue dropKindValue;

	public NatTableDropListener(final INattableModelManager manager) {
		this.manager = manager;
	}

	public void dragEnter(final DropTargetEvent event) {

	}

	public void dragLeave(final DropTargetEvent event) {

	}

	public void dragOperationChanged(final DropTargetEvent event) {

	}

	public void dragOver(final DropTargetEvent event) {
		this.dropKindValue = null;
		final LocalTransfer localTransfer = LocalTransfer.getInstance();
		final Object data = localTransfer.nativeToJava(event.currentDataType);
		IStructuredSelection structuredSelection = null;
		if(data instanceof IStructuredSelection) {
			structuredSelection = (IStructuredSelection)data;
		}
		final Collection<Object> objectsToAdd = new ArrayList<Object>(structuredSelection.toList());
		this.dropKindValue = this.manager.getLocationInTheTable(new Point(event.x, event.y));
		System.out.println(dropKindValue);
		int drop = DND.DROP_NONE;
		switch(this.dropKindValue.getKind()) {
		case AFTER_COLUMN_HEADER:
			if(this.manager.canDropColumnsElement(objectsToAdd)) {
				drop = DND.DROP_DEFAULT;
			}
			break;
		case AFTER_ROW_HEADER:
			if(this.manager.canDropRowElement(objectsToAdd)) {
				drop = DND.DROP_DEFAULT;
			}
			break;
		case COLUMN_HEADER:
			if(this.manager.canInsertColumns(objectsToAdd, this.dropKindValue.getColumnIndex())) {
				drop = DND.DROP_DEFAULT;
			}
			break;
		case ROW_HEADER:
			if(this.manager.canInsertRow(objectsToAdd, this.dropKindValue.getRowIndex())) {
				drop = DND.DROP_DEFAULT;
			}
			break;
		case CELL:
			//FIXME
			drop = DND.DROP_NONE;
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

	public void drop(final DropTargetEvent event) {
		//we drop the elements into the table
		LocalTransfer localTransfer = LocalTransfer.getInstance();
		Object data = localTransfer.nativeToJava(event.currentDataType);
		if(data instanceof StructuredSelection) {
			final IStructuredSelection selection = (IStructuredSelection)data;
			final List<Object> droppedElements = selection.toList();
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
				//FIXME
				break;
			case UNKNOWN:
				break;
			default:
				break;
			}
		}
		this.dropKindValue = null;
	}


	public void dropAccept(final DropTargetEvent event) {

	}

}
