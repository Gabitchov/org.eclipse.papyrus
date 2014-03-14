/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.pluginexplorer;

import java.io.File;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SegmentEvent;
import org.eclipse.swt.events.SegmentListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.osgi.framework.Bundle;

/**
 * Represents a dialog for the selection of plugins and their resources by a user
 * @author Laurent Wouters
 */
public class PluginsContentDialog extends Dialog {
	private static final int SIZE_WIDTH = 400;
	private static final int SIZE_HEIGHT = 300;
	
	private PluginsContentSelectionValidator validator;
	private String title;
	private String message;
	private Plugin[] plugins;
	private TreeViewer tree;
	private Text field;
	private Object selection;
	
	/**
	 * Gets the selected element
	 * @return The element selected by the user
	 */
	public Object getSelection() {
		return selection;
	}
	
	/**
	 * Creates a new dialog
	 * @param parentShell The parent shell
	 * @param validator The validator used for validating the user's selection
	 * @param title The dialog's title
	 * @param message The dialog's message
	 */
	public PluginsContentDialog(Shell parentShell, PluginsContentSelectionValidator validator, String title, String message) {
		super(parentShell);
		this.validator = validator;
		this.title = title;
		this.message = message;
		this.plugins = Plugin.getLoadedPlugins();
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
        // create composite
        Composite composite = (Composite) super.createDialogArea(parent);
        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 1;
        composite.setLayout(gridLayout);
        
        Label label = new Label(composite, SWT.WRAP | SWT.SINGLE);
        label.setText(message);
        label.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
        
        field = new Text(composite, SWT.SINGLE | SWT.BORDER);
		field.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
		field.addSegmentListener(new SegmentListener(){
			public void getSegments(SegmentEvent event) {
				if (tree != null)
					tree.setContentProvider(new PluginsContentProvider(plugins, field.getText()));
			}
		});
        
        Composite inner = new Composite(composite, SWT.NONE);
        inner.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL | GridData.FILL_VERTICAL));
        inner.setLayout(new FillLayout());
        
        tree = new TreeViewer(inner, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
        tree.setLabelProvider(new PluginsContentLabelProvider());
        tree.setSorter(getViewerSorter());
        tree.setContentProvider(new PluginsContentProvider(plugins, null));
        tree.setInput(PluginsContentProvider.treeRoot);
        tree.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection s = (IStructuredSelection)event.getSelection();
				selection = s.getFirstElement();
				resetValidity();
			}
    	});
        
        applyDialogFont(composite);
        return composite;
    }
	
	@Override
	protected Control createButtonBar(Composite parent) {
		Control composite = super.createButtonBar(parent);
		resetValidity();
		return composite;
	}
	
	/**
	 * Enquires about the current validity of the selection and disables or enables the dialog's validation correspondingly
	 */
	private void resetValidity() {
		if (selection == null) {
			getButton(IDialogConstants.OK_ID).setEnabled(false);
			return;
		}
		if (validator == null) {
			getButton(IDialogConstants.OK_ID).setEnabled(true);
			return;
		}
		boolean valid = false;
		if (selection instanceof Plugin)
			valid = validator.isValid((Plugin)selection);
		else if (selection instanceof PluginEntry)
			valid = validator.isValid((PluginEntry)selection);
		getButton(IDialogConstants.OK_ID).setEnabled(valid);
	}
	
	@Override
	protected boolean isResizable() { return true; }
	
	@Override
	protected void configureShell(Shell shell) {
        super.configureShell(shell);
        shell.setSize(SIZE_WIDTH, SIZE_HEIGHT);
        Point size = shell.getParent().getShell().getSize();
        shell.setLocation((size.x - SIZE_WIDTH)/2, (size.y - SIZE_HEIGHT)/2);
        shell.setText(title);
    }
	
	/**
	 * Gets the viewer sorter for this dialog
	 * @return A viewer sorter
	 */
	private ViewerSorter getViewerSorter() {
		return new ViewerSorter() {
			@Override
			public int compare(Viewer viewer, Object e1, Object e2) {
				if (e1 instanceof Bundle) {
					Bundle b1 = (Bundle)e1;
					Bundle b2 = (Bundle)e2;
					return b1.getSymbolicName().compareTo(b2.getSymbolicName());
				} else if (e1 instanceof File) {
					File f1 = (File)e1;
					File f2 = (File)e2;
					return (f1.getName().compareTo(f2.getName()));
				}
				return super.compare(viewer, e1, e2);
			}
		};
	}
}
