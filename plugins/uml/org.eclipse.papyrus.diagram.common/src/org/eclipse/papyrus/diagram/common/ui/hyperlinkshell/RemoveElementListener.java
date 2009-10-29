package org.eclipse.papyrus.diagram.common.ui.hyperlinkshell;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;

public class RemoveElementListener implements MouseListener {

	private TableViewer tableviewer;

	private ArrayList elementList;

	public RemoveElementListener(TableViewer atableViewer, ArrayList aList) {
		super();
		this.tableviewer = atableViewer;
		this.elementList = aList;
	}

	public void mouseUp(MouseEvent e) {
		if (tableviewer.getTable().getSelection().length != 0) {
			Iterator iterator = ((IStructuredSelection) tableviewer.getSelection()).iterator();
			while (iterator.hasNext()) {
				Object object = iterator.next();
				elementList.remove(object);
				tableviewer.setInput(elementList);
			}
		}
	}

	public void mouseDown(MouseEvent e) {
	}

	public void mouseDoubleClick(MouseEvent e) {
	}
}
