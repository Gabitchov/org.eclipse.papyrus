package org.eclipse.papyrus.diagram.common.ui.hyperlinkshell;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;

public class UpElementListener implements MouseListener {

	private TableViewer tableviewer;

	private ArrayList elementList;

	public UpElementListener(TableViewer atableViewer, ArrayList aList) {
		super();
		this.tableviewer = atableViewer;
		this.elementList = aList;
	}

	public void mouseUp(MouseEvent e) {
		if(tableviewer.getTable().getSelection().length != 0) {
			Object elt = ((IStructuredSelection)tableviewer.getSelection()).getFirstElement();
			if(elementList.indexOf(elt) == 0) {
				return;
			}
			Iterator iterator = ((IStructuredSelection)tableviewer.getSelection()).iterator();
			while(iterator.hasNext()) {
				Object currentHyperLinkDoc = iterator.next();
				int index = elementList.indexOf(currentHyperLinkDoc);
				elementList.remove(currentHyperLinkDoc);
				elementList.add(index - 1, currentHyperLinkDoc);
				tableviewer.setInput(elementList);
			}
		}
	}

	public void mouseDown(MouseEvent e) {
	}

	public void mouseDoubleClick(MouseEvent e) {
	}
}
