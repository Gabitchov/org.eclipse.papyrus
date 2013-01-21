package org.eclipse.papyrus.infra.nattable.common.listener;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;


public class NatTableDropListener implements DropTargetListener {

	private final NatTable natTable;

	private final Table pTable;

	private final INattableModelManager manager;

	public NatTableDropListener(final NatTable fNatTable, final INattableModelManager manager, final Table rawModel) {
		this.natTable = fNatTable;
		this.pTable = rawModel;
		this.manager = manager;
	}

	public void dragEnter(final DropTargetEvent event) {

	}

	public void dragLeave(final DropTargetEvent event) {

	}

	public void dragOperationChanged(final DropTargetEvent event) {

	}

	public void dragOver(final DropTargetEvent event) {
		LocalTransfer localTransfer = LocalTransfer.getInstance();
		Object data = localTransfer.nativeToJava(event.currentDataType);


		//we should verify if all the dropped element are already in the table or not
		final List<Object> ownedElement = new ArrayList<Object>();
		for(final IAxis current : this.pTable.getHorizontalContentProvider().getAxis()) {
			ownedElement.add(current.getElement());
		}
		if(data instanceof StructuredSelection) {
			final IStructuredSelection selection = (IStructuredSelection)data;
			final List<Object> droppedElements = new ArrayList<Object>(selection.toList());
			int nbDroppedElement = droppedElements.size();
			droppedElements.removeAll(ownedElement);
			if(droppedElements.size() == nbDroppedElement) {
				event.detail = DND.DROP_DEFAULT;
			} else {
				//we refuse the drop
				event.detail = DND.DROP_NONE;
			}
		}
	}

	public void drop(final DropTargetEvent event) {
		//we drop the elements into the table
		LocalTransfer localTransfer = LocalTransfer.getInstance();
		Object data = localTransfer.nativeToJava(event.currentDataType);
		if(data instanceof StructuredSelection) {
			final IStructuredSelection selection = (IStructuredSelection)data;
			final List<Object> droppedElements = selection.toList();
			manager.addRows(droppedElements);
			return;
		}
	}


	public void dropAccept(final DropTargetEvent event) {

	}

}
