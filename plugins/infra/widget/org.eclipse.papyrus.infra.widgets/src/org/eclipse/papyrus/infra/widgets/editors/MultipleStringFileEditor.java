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

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.papyrus.infra.widgets.providers.WorkspaceContentProvider;
import org.eclipse.papyrus.infra.widgets.selectors.NullSelector;
import org.eclipse.papyrus.infra.widgets.selectors.ReferenceSelector;
import org.eclipse.papyrus.infra.widgets.util.FileUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;

/**
 * A Widget for editing multi-valued Strings with File paths
 * The file paths may be absolute (FileSystem paths) or relative to the workspace (Workspace paths)
 * 
 * @author Camille Letavernier
 */
public class MultipleStringFileEditor extends MultipleValueEditor {

	protected boolean allowBrowseWorkspace = true;

	protected boolean allowBrowseFileSystem = true;

	protected Button browseFileSystem;

	protected Button browseWorkspace;

	protected final List<String> filterNames;

	protected final List<String> filterExtensions;

	public static final String browseWorkspaceIcon = "icons/browse-workspace_12x12.png"; //$NON-NLS-1$

	public static final String browseFileSystemIcon = "icons/browse-filesystem_12x12.png"; //$NON-NLS-1$

	public MultipleStringFileEditor(Composite parent, int style) {
		super(parent, style, NullSelector.instance);
		setDirectCreation(true);

		filterNames = new LinkedList<String>();
		filterExtensions = new LinkedList<String>();
	}

	@Override
	protected void createListControls() {
		super.createListControls();
		add.dispose();
		edit.dispose();

		browseFileSystem = createButton(Activator.getDefault().getImageFromPlugin(browseFileSystemIcon), "Browse file system");
		browseWorkspace = createButton(Activator.getDefault().getImageFromPlugin(browseWorkspaceIcon), "Browse workspace");

		browseWorkspace.moveAbove(remove);
		browseFileSystem.moveAbove(remove);
	}

	@Override
	public void setDirectCreation(boolean directCreation) {
		super.setDirectCreation(true); //Always true
	}

	@Override
	protected void updateControls() {
		remove.setEnabled(!readOnly);
		up.setEnabled(ordered && !readOnly);
		down.setEnabled(ordered && !readOnly);

		browseWorkspace.setEnabled(allowBrowseWorkspace && !readOnly);
		browseFileSystem.setEnabled(allowBrowseFileSystem && !readOnly);
	}

	public void allowBrowseWorkspace(boolean allowBrowseWorkspace) {
		this.allowBrowseWorkspace = allowBrowseWorkspace;
	}

	public void allowBrowseFileSystem(boolean allowBrowseFileSystem) {
		this.allowBrowseFileSystem = allowBrowseFileSystem;
	}

	/**
	 * Handle events occuring on controls
	 * 
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 * 
	 * @param e
	 */
	@Override
	public void widgetSelected(SelectionEvent e) {
		super.widgetSelected(e);
		if(e.widget == browseFileSystem) {
			browseFileSystem();
		} else if(e.widget == browseWorkspace) {
			browseWorkspace();
		}
	}

	protected void browseFileSystem() {
		//		File file = FileUtil.getFile(text.getText());

		FileDialog dialog = new FileDialog(getShell(), SWT.MULTI | SWT.OPEN);
		dialog.setFilterExtensions(filterExtensions.toArray(new String[filterExtensions.size()]));
		dialog.setFilterNames(filterNames.toArray(new String[filterNames.size()]));
		if(dialog.open() != null) {
			List<String> filePathList = new ArrayList<String>(modelProperty.size() + dialog.getFileNames().length);
			filePathList.addAll(modelProperty);

			for(String fileName : dialog.getFileNames()) {
				filePathList.add(dialog.getFilterPath() + File.separator + fileName);
			}

			modelProperty.clear();
			modelProperty.addAll(filePathList);
			commit();
		}
	}

	protected void browseWorkspace() {
		LabelProviderService labelProviderService = new LabelProviderServiceImpl();
		try {
			labelProviderService.startService();
		} catch (ServiceException ex) {
			Activator.log.error(ex);
		}

		ILabelProvider labelProvider = labelProviderService.getLabelProvider();

		ReferenceSelector selector = new ReferenceSelector();
		selector.setLabelProvider(labelProvider);
		selector.setContentProvider(new WorkspaceContentProvider());


		MultipleValueSelectorDialog dialog = new MultipleValueSelectorDialog(getShell(), selector);
		if(labelText != null) {
			dialog.setTitle(labelText);
		}

		dialog.setLabelProvider(labelProvider);

		dialog.setOrdered(true);
		dialog.setUnique(true);
		selector.setUnique(true);

		int code = dialog.open();
		if(code == Window.OK) {
			Object[] result = dialog.getResult();
			if(result.length > 0) {
				List<String> filePathResult = new ArrayList<String>(result.length + modelProperty.size());
				filePathResult.addAll(modelProperty);
				for(Object file : result) {
					if(file instanceof IFile) {
						filePathResult.add(FileUtil.getPath((IFile)file, false));
					}
				}
				modelProperty.clear();
				modelProperty.addAll(filePathResult);
				commit();
			}
		}
	}

	public void setFilters(String[] filterExtensions, String[] filterNames) {
		if(filterExtensions.length != filterNames.length) {
			//This is a simple warning. Only valid filters will be retained.
			Activator.log.warn("FilterExtensions and FilterNames do not match");
		}

		setFilterNames(getFilterLabels(filterNames, filterExtensions));
		setFilterExtensions(filterExtensions);
	}

	protected String[] getFilterLabels(String[] filterNames, String[] filterExtensions) {
		int size = Math.min(filterNames.length, filterExtensions.length);
		String[] filters = new String[size];
		for(int i = 0; i < size; i++) {
			filters[i] = filterNames[i] + " (" + filterExtensions[i] + ")";
		}
		return filters;
	}

	public void setFilterExtensions(String[] filterExtensions) {
		this.filterExtensions.clear();
		this.filterExtensions.addAll(Arrays.asList(filterExtensions));
	}

	public void setFilterNames(String[] filterNames) {
		this.filterNames.clear();
		this.filterNames.addAll(Arrays.asList(filterNames));
	}

}
