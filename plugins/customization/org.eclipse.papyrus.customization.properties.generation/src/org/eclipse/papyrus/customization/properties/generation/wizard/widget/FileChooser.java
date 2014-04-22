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
package org.eclipse.papyrus.customization.properties.generation.wizard.widget;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.jface.databinding.swt.IWidgetValueProperty;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.customization.properties.generation.messages.Messages;
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

/**
 * A Widget for selecting or creating a file in the workspace
 * 
 * @author Camille Letavernier
 */
public class FileChooser extends Composite implements SelectionListener, Listener {

	private Text text;

	private Button browse;

	private IFile currentFile;

	private List<ViewerFilter> filters;

	private Set<Listener> listeners = new HashSet<Listener>();

	private boolean newFile;

	/**
	 * Constructs a new FileChooser in the given Composite
	 * 
	 * @param parent
	 *        The composite in which the FileChooser is created
	 * @param newFile
	 *        True if the fileChooser allows the user to create a new file,
	 *        false if he should select an existing one
	 */
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
		browse.setText(Messages.FileChooser_browseWorkspace);
		browse.addSelectionListener(this);
		filters = new LinkedList<ViewerFilter>();
		this.newFile = newFile;
	}

	/**
	 * @return the selected file path
	 */
	public String getFilePath() {
		if(text.isDisposed()) {
			return null;
		}
		String path = text.getText();
		if(path.trim().equals("")) { //$NON-NLS-1$
			return null;
		}
		return path.trim();
	}

	/**
	 * Sets the file extensions that this FileChooser accepts
	 * Files that don't match one of these extensions will be hidden
	 * 
	 * @param extensions
	 */
	public void setFilterExtensions(String[] extensions) {
		filters.clear();
		ExtensionFilter filter = new ExtensionFilter(extensions);
		filters.add(filter);
	}

	public void handleEvent(Event event) {
		notifyChange();
	}

	/**
	 * Add a listener to this widget. The listener will be notified when the user
	 * choose a new file
	 * 
	 * @param listener
	 */
	public void addListener(Listener listener) {
		listeners.add(listener);
	}

	public void widgetSelected(SelectionEvent e) {
		IFile[] result = new IFile[0];

		if(newFile) {
			IFile file = WorkspaceResourceDialog.openNewFile(getShell(), null, null, null, filters);
			if(file != null) {
				result = new IFile[]{ file };
			}
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
	
	public IObservableValue getObservableValue(){
		 IWidgetValueProperty prop = WidgetProperties.text(SWT.Modify);
		 return prop.observeDelayed(600, text);
	}

	public void setText(String s){
		text.setText(s);
		
	}
}
