/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Sergey Gribovsky (Borland) - initial API and implementation
 */
package org.eclipse.papyrus.diagram.statemachine.part;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.StateMachine;


public class SelectConnectionPointsDialog extends Dialog {
	public SelectConnectionPointsDialog(Shell parentShell, StateMachine input, PseudostateKind kind) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		myInput = input;
		myKind = kind;
	}

	public List<Pseudostate> getSelectedConnectionPoints() {
		return mySelectionConnectionPoints;
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {		
		getShell().setText(CustomMessages.SelectConnectionPointsDialog_Title);
		createSelector(parent);				
		return parent;
	}

	@Override
	protected Control createButtonBar(Composite parent) {
		Control buttonBar = super.createButtonBar(parent);
		setOkButtonEnabled(false);
		return buttonBar;
	}

	private void setOkButtonEnabled(boolean enabled) {
		getButton(IDialogConstants.OK_ID).setEnabled(enabled);
	}

	private void createSelector(Composite parent) {
		TreeViewer viewer = new TreeViewer(parent, SWT.MULTI | SWT.V_SCROLL | SWT.BORDER);
		GridData layoutData = new GridData(GridData.FILL_BOTH);
		layoutData.heightHint = 300;
		layoutData.widthHint = 300;
		viewer.getTree().setLayoutData(layoutData);
		ConnectionPointsListContentProvider contentProvider = new ConnectionPointsListContentProvider(myInput);
		viewer.setContentProvider(contentProvider);
		viewer.setLabelProvider(new ConnectionPointsListLabelProvider());
		viewer.setInput(myInput);
		viewer.addFilter(new ConnectionPointsFilter());
		viewer.addSelectionChangedListener(new OkButtonEnabler());
	}
	
	private StateMachine myInput;
	private PseudostateKind myKind;
	private List<Pseudostate> mySelectionConnectionPoints;

	private static class ConnectionPointsListContentProvider implements ITreeContentProvider {
	    public ConnectionPointsListContentProvider(StateMachine content) {
	    	myContent = content;
	    }
	    
	    public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof StateMachine) {
				EList connectionPoints = myContent.getConnectionPoints(); 
				return connectionPoints.toArray(new Pseudostate[connectionPoints.size()]);
			}
			return null;
		}
	    
		public Object getParent(Object element) {
			if (element instanceof Pseudostate) {
				return myContent;
			}
			return null;
		}
		
		public boolean hasChildren(Object element) {
			if (element instanceof StateMachine) {
				return true;
			}
			return false;
		}
		
		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}
		
		public void dispose() {
		}
		
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
		
		private StateMachine myContent;
	}
	
	private static class ConnectionPointsListLabelProvider implements ILabelProvider {
		public String getText(Object element) {
			if (element instanceof Pseudostate) {
				Pseudostate pseudoState = (Pseudostate) element;
				StringBuffer text = new StringBuffer(10);
				if (pseudoState.getKind() == PseudostateKind.ENTRY_POINT_LITERAL) {
					text.append(CustomMessages.SelectConnectionPointsDialog_LabelProvider_EntryPointPrefix);
				} else if (pseudoState.getKind() == PseudostateKind.EXIT_POINT_LITERAL) {
					text.append(CustomMessages.SelectConnectionPointsDialog_LabelProvider_ExitPointPrefix);
				}
				text.append(' ');
				text.append(pseudoState.getName());
				return text.toString();
			}
			
			return myAdapterFactoryLabelProvider.getText(element);
		}
		
		public Image getImage(Object element) {
			return myAdapterFactoryLabelProvider.getImage(element);
		}

		public void addListener(ILabelProviderListener listener) {
			myAdapterFactoryLabelProvider.addListener(listener);
		}

		public void dispose() {
			myAdapterFactoryLabelProvider.dispose();
		}

		public boolean isLabelProperty(Object element, String property) {
			return myAdapterFactoryLabelProvider.isLabelProperty(element, property);
		}

		public void removeListener(ILabelProviderListener listener) {
			myAdapterFactoryLabelProvider.removeListener(listener);
		}
		
		private AdapterFactoryLabelProvider myAdapterFactoryLabelProvider = new AdapterFactoryLabelProvider(UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());
	}
	
	private class ConnectionPointsFilter extends ViewerFilter {
		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			if (element instanceof Pseudostate) {
				Pseudostate pseudostate = (Pseudostate) element;
				if (pseudostate.getKind() != SelectConnectionPointsDialog.this.myKind) {
					return false;
				}
			}
			return true;
		}
	}

	private class OkButtonEnabler implements ISelectionChangedListener {
		public void selectionChanged(SelectionChangedEvent event) {
			if (!(event.getSelection() instanceof IStructuredSelection)) {
				setOkButtonEnabled(false);
				return;
			}
			IStructuredSelection selection = (IStructuredSelection) event.getSelection();
			mySelectionConnectionPoints = selection.toList();
			if (selection.isEmpty()) {
				setOkButtonEnabled(false);
				return;
			}
			for (Iterator iterator = selection.iterator(); iterator.hasNext();) {
				Object selectedElement = iterator.next();
				if (!(selectedElement instanceof Pseudostate)) {
					setOkButtonEnabled(false);
					return;
				}
			}
			setOkButtonEnabled(true);
		}
	}
}
