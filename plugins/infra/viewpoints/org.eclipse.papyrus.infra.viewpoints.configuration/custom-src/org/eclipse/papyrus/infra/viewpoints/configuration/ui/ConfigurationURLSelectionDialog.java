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
package org.eclipse.papyrus.infra.viewpoints.configuration.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * Dialog for the selection of a configuration model through URIs
 * @author Laurent Wouters
 */
public class ConfigurationURLSelectionDialog extends Dialog {

	private static final int SIZE_WIDTH = 400;
	private static final int SIZE_HEIGHT = 300;
	private static final String MSG_TITLE = "Select the URI of the configuration model";
	
	private static final Object TREE_ROOT = new Object();
	
	private Resource selection;
	
	/**
	 * Represents a provider of URIs
	 * @author Laurent Wouters
	 */
	private static class ModelContentProvider implements IStructuredContentProvider {
		public void dispose() { }
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) { }
		public Object[] getElements(Object inputElement) {
			List<Resource> data = new ArrayList<Resource>();
			
			return data.toArray();
		}
	}
	
	public ConfigurationURLSelectionDialog(Shell parentShell, int style) {
		super(parentShell);
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
        // create composite
        Composite composite = (Composite) super.createDialogArea(parent);
        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 1;
        composite.setLayout(gridLayout);
        
        Composite inner = new Composite(composite, SWT.NONE);
        inner.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL | GridData.FILL_VERTICAL));
        inner.setLayout(new FillLayout());
        
        ListViewer list = new ListViewer(inner, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
        list.setLabelProvider(getLabelProvider());
        list.setContentProvider(new ModelContentProvider());
        list.setInput(TREE_ROOT);
        list.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection s = (IStructuredSelection)event.getSelection();
				Object first = s.getFirstElement();
				if (first == null)
					onSelection(null);
				else if (first instanceof Resource)
					onSelection((Resource)first);
				else
					onSelection(null);
			}
    	});
    	
        applyDialogFont(composite);
        return composite;
    }
	
	@Override
	protected Control createButtonBar(Composite parent) {
		Control composite = super.createButtonBar(parent);
		if (selection == null)
			getButton(IDialogConstants.OK_ID).setEnabled(false);
		else
			getButton(IDialogConstants.OK_ID).setEnabled(true);
		return composite;
	}
	
	private void onSelection(Resource element) {
		selection = element;
		if (selection == null) {
			getButton(IDialogConstants.OK_ID).setEnabled(false);
		} else {
			getButton(IDialogConstants.OK_ID).setEnabled(true);
		}
	}
	
	@Override
	protected void configureShell(Shell shell) {
        super.configureShell(shell);
        shell.setSize(SIZE_WIDTH, SIZE_HEIGHT);
        Point size = shell.getParent().getShell().getSize();
        shell.setLocation((size.x - SIZE_WIDTH)/2, (size.y - SIZE_HEIGHT)/2);
        shell.setText(MSG_TITLE);
    }
	
	private ILabelProvider getLabelProvider() {
		return new ILabelProvider() {
			public void addListener(ILabelProviderListener listener) { }
			public void dispose() { }
			public boolean isLabelProperty(Object element, String property) {
				// TODO Auto-generated method stub
				return false;
			}
			public void removeListener(ILabelProviderListener listener) { }
			public Image getImage(Object element) { return null; }
			public String getText(Object element) {
				Resource res = (Resource)element;
				return res.getURI().toString();
			}
		};
	}
}
