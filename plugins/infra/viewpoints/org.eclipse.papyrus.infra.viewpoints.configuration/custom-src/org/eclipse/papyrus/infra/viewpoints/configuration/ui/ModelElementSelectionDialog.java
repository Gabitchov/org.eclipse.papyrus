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
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * Represents a dialog for the selection of a model element
 * @author Laurent Wouters
 */
public class ModelElementSelectionDialog extends Dialog {
	private static final int SIZE_WIDTH = 400;
	private static final int SIZE_HEIGHT = 300;
	
	private static final String MSG_TITLE = "Model element selection";
	private static final String MSG_EMPTYSELECTION = "Select an element";
	
	private ServicesRegistry registry;
	private EObject root;
	private EObject selection;
	private IModelElementValidator validator;
	private Label notification;
	private String message;
	
	private static class AtomSelection implements IStructuredSelection {
		private Object element;
		public AtomSelection(Object element) {
			this.element = element;
		}
		public boolean isEmpty() {
			return (element == null);
		}
		public Object getFirstElement() {
			return element;
		}
		public Iterator iterator() {
			return new Iterator() {
				private boolean done = false;
				public boolean hasNext() {
					return (!done);
				}
				public Object next() {
					if (done)
						throw new NoSuchElementException();
					done = true;
					return element;
				}
				public void remove() { }
			};
		}
		public int size() {
			return ((element != null) ? 1 : 0);
		}
		public Object[] toArray() {
			if (element == null)
				return new Object[0];
			return new Object[] { element };
		}
		public List toList() {
			List<Object> list = new ArrayList<Object>(1);
			if (element != null)
				list.add(element);
			return list;
		}
	}
	
	
	public EObject getSelection() {
		return selection;
	}
	
	public ModelElementSelectionDialog(Shell parentShell, ServicesRegistry registry, String message, EObject root, EObject current, IModelElementValidator validator) {
		super(parentShell);
		this.registry = registry;
		this.root = root;
		this.selection = current;
		this.validator = validator;
		this.message = message;
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
        
        Composite inner = new Composite(composite, SWT.NONE);
        inner.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL | GridData.FILL_VERTICAL));
        inner.setLayout(new FillLayout());
        
        TreeViewer tree = new TreeViewer(inner, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
        tree.setLabelProvider(getLabelProvider());
        tree.setContentProvider(new ECoreModelContentProvider(root));
        tree.setInput(ECoreModelContentProvider.ROOT);
        if (selection != null) {
        	tree.reveal(selection);
        	tree.setSelection(new AtomSelection(selection));
        }
        tree.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection s = (IStructuredSelection)event.getSelection();
				Object first = s.getFirstElement();
				if (first == null)
					onSelection(null);
				else if (first instanceof EObject)
					onSelection((EObject)first);
				else
					onSelection(null);
			}
    	});
        
    	notification = new Label(composite, SWT.WRAP | SWT.SINGLE);
    	notification.setForeground(new Color(composite.getDisplay(), 255, 0, 0));
    	notification.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
    	if (selection == null)
    		notification.setText(MSG_EMPTYSELECTION);
    	else {
    		String msg = validator.isSelectable(selection);
    		if (msg == null)
    			notification.setText("");
    		else
    			notification.setText(msg);
    	}
    	
        applyDialogFont(composite);
        return composite;
    }
	
	@Override
	protected Control createButtonBar(Composite parent) {
		Control composite = super.createButtonBar(parent);
		if (selection == null)
    		getButton(IDialogConstants.OK_ID).setEnabled(false);
		else {
    		String msg = validator.isSelectable(selection);
    		if (msg == null)
    			getButton(IDialogConstants.OK_ID).setEnabled(true);
    		else
    			getButton(IDialogConstants.OK_ID).setEnabled(false);
    	}
		return composite;
	}
	
	
	private void onSelection(EObject element) {
		selection = element;
		if (selection == null) {
    		notification.setText(MSG_EMPTYSELECTION);
    		getButton(IDialogConstants.OK_ID).setEnabled(false);
		} else {
    		String msg = validator.isSelectable(selection);
    		if (msg == null) {
    			notification.setText("");
    			getButton(IDialogConstants.OK_ID).setEnabled(true);
    		} else {
    			notification.setText(msg);
    			getButton(IDialogConstants.OK_ID).setEnabled(false);
    		}
    	}
	}
	
	@Override
	protected void configureShell(Shell shell) {
        super.configureShell(shell);
        shell.setSize(SIZE_WIDTH, SIZE_HEIGHT);
        shell.setText(MSG_TITLE);
		if (shell.getParent() != null) {
			Composite parent = shell.getParent();
			Shell parentShell = parent.getShell();
			if (parentShell != null) {
				Point size = parentShell.getSize();
				shell.setLocation((size.x - SIZE_WIDTH) / 2, (size.y - SIZE_HEIGHT) / 2);
			}
		}
    }
	
	private ILabelProvider getLabelProvider() {
		try {
			LabelProviderService service = registry.getService(LabelProviderService.class);
			if (service != null)
				return service.getLabelProvider();
		}
		catch (ServiceException e) { }
		return null;
	}
}
