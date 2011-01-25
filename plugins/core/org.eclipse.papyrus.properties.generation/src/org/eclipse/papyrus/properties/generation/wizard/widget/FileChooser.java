/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.generation.wizard.widget;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public class FileChooser extends Composite implements SelectionListener, Listener {

	private Text text;

	private Button browse;

	private IFile currentFile;

	private List<ViewerFilter> filters;

	private Set<Listener> listeners = new HashSet<Listener>();

	private boolean newFile;

	public FileChooser(Composite parent, boolean newFile) {
		super(parent, SWT.NONE);
		setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = 0;
		setLayout(layout);

		text = new Text(this, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		text.addListener(SWT.FocusOut, this);
		browse = new Button(this, SWT.PUSH);
		browse.setText("Browse workspace...");
		browse.addSelectionListener(this);
		filters = new LinkedList<ViewerFilter>();
		this.newFile = newFile;
	}

	public void setText(String text) {
		browse.setText(text);
	}

	public String getText() {
		return browse.getText();
	}

	public String getFilePath() {
		String path = text.getText();
		if(path.trim().equals("")) { //$NON-NLS-1$
			return null;
		}
		return path.trim();
	}

	public void setFilterExtensions(String[] extensions) {
		filters.clear();
		ExtensionFilter filter = new ExtensionFilter(extensions);
		filters.add(filter);
	}

	public void handleEvent(Event event) {
		notifyChange();
	}

	public void addListener(Listener listener) {
		listeners.add(listener);
	}

	public void widgetSelected(SelectionEvent e) {
		IFile[] result = new IFile[0];

		if(newFile) {
			IFile file = WorkspaceResourceDialog.openNewFile(getShell(), null, null, null, filters);
			if(file != null)
				result = new IFile[]{ file };
		} else {
			result = WorkspaceResourceDialog.openFileSelection(getShell(), null, null, false, new Object[]{ currentFile }, filters);
		}

		if(result.length >= 1) {
			currentFile = result[0];
			text.setText(currentFile.getFullPath().toString());
			notifyChange();
		}
	}

	private void notifyChange() {
		for(Listener listener : listeners) {
			listener.handleEvent(null);
		}
	}

	public void widgetDefaultSelected(SelectionEvent e) {
		//Nothing
	}

}
