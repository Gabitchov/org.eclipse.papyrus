/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.ui.hyperlinkshell;

import java.util.ArrayList;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving downElement events. The class that is interested in
 * processing a downElement event implements this interface, and the object created with that class
 * is registered with a component using the component's <code>addDownElementListener<code> method. When
 * the downElement event occurs, that object's appropriate
 * method is invoked.
 * 
 * @see DownElementEvent
 */
public class DownElementListener implements MouseListener {

	/** The tableviewer. */
	private TableViewer tableviewer;

	/** The element list. */
	private ArrayList elementList;

	/**
	 * Instantiates a new down element listener.
	 * 
	 * @param atableViewer
	 *        the a table viewer
	 * @param aList
	 *        the a list
	 */
	public DownElementListener(TableViewer atableViewer, ArrayList aList) {
		super();
		this.tableviewer = atableViewer;
		this.elementList = aList;
	}

	/**
	 * {@inheritDoc}
	 */
	public void mouseUp(MouseEvent e) {
		if(tableviewer.getTable().getSelection().length != 0) {
			Object[] block = ((IStructuredSelection)tableviewer.getSelection()).toArray();
			if((elementList.indexOf(block[block.length - 1])) == elementList.size() - 1) {
				return;
			}
			for(int i = block.length - 1; i >= 0; i--) {
				Object currentobject = (Object)block[i];
				int index = elementList.indexOf(currentobject);
				elementList.remove(currentobject);
				elementList.add(index + 1, currentobject);
				tableviewer.setInput(elementList);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void mouseDown(MouseEvent e) {
	}

	/**
	 * {@inheritDoc}
	 */
	public void mouseDoubleClick(MouseEvent e) {
	}
}
