/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.editors;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;

/**
 * A basic menu which proposes a list of choices.
 * 
 * Implementation is based on a JFace TableViewer
 * 
 * Typical usage: JDT-like Ctrl + Click (Navigation)
 * 
 * @author Camille Letavernier
 * 
 */
public class SelectionMenu {

	private ILabelProvider labelProvider;

	private IStructuredContentProvider contentProvider;

	private Shell parentShell;

	private Point location;

	private Object input;

	private Shell shell;

	private final ISelectionChangedListener selectionChangedListener;

	private final List<ISelectionChangedListener> selectionChangedListeners;

	public SelectionMenu(Shell parentShell) {
		this(parentShell, parentShell.getDisplay().getCursorLocation());
	}

	public SelectionMenu(Shell parentShell, Point location) {
		//Move the shell so that it doesn't open under the mouse
		//The hovered element can still be selected
		location.x += 1;
		location.y += 1;

		this.parentShell = parentShell;
		this.location = location;
		labelProvider = new LabelProvider();
		selectionChangedListeners = new LinkedList<ISelectionChangedListener>();
		selectionChangedListener = new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				for(ISelectionChangedListener listener : selectionChangedListeners) {
					listener.selectionChanged(event);
				}
			}
		};
	}

	public void open() {
		shell = new Shell(parentShell, SWT.NONE);
		shell.setBackground(shell.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);

		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 5;
		gridLayout.marginHeight = 5;
		shell.setLayout(gridLayout);

		shell.setLayout(new GridLayout(1, false));

		final TableViewer tableViewer = new TableViewer(shell, SWT.NO_SCROLL);

		tableViewer.getTable().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		tableViewer.setContentProvider(contentProvider);
		tableViewer.setLabelProvider(labelProvider);

		ColumnViewerToolTipSupport.enableFor(tableViewer);
		tableViewer.setInput(input);
		tableViewer.addSelectionChangedListener(selectionChangedListener);

		shell.setLocation(location);
		shell.pack();
		shell.open();
	}

	public void dispose() {
		if(shell != null) {
			shell.dispose();
		}
	}

	public void setContentProvider(IStructuredContentProvider provider) {
		this.contentProvider = provider;
	}

	public void setInput(Object input) {
		this.input = input;
	}

	public void setLabelProvider(ILabelProvider labelProvider) {
		this.labelProvider = labelProvider;
	}

	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		this.selectionChangedListeners.add(listener);
	}
}
