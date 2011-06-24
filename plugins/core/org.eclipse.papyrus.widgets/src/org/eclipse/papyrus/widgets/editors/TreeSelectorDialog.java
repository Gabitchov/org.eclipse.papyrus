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
package org.eclipse.papyrus.widgets.editors;

import java.util.Collections;
import java.util.List;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.widgets.Activator;
import org.eclipse.papyrus.widgets.providers.IHierarchicContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.dialogs.SelectionDialog;

/**
 * A Dialog for selecting values. The values are displayed as a Tree. If only
 * some of the values of this Tree should be selectable, you should pass a {@link IHierarchicContentProvider} to this dialog.
 * 
 * @author Camille Letavernier
 * 
 */
public class TreeSelectorDialog extends SelectionDialog implements ITreeSelectorDialog {

	private ILabelProvider labelProvider;

	private ITreeContentProvider contentProvider;

	private FilteredTree fTree;

	private Label descriptionLabel;

	private Object input = null;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parentShell
	 *        The parent shell in which this dialog will be opened
	 */
	public TreeSelectorDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Sets the label provider for this dialog
	 * 
	 * @param provider
	 */
	public void setLabelProvider(ILabelProvider provider) {
		labelProvider = provider;
		if(fTree != null) {
			getViewer().setLabelProvider(labelProvider);
		}
	}

	/**
	 * Sets the ContentProvider for this dialog
	 * The ContentProvider may be a {@link IHierarchicContentProvider}
	 * 
	 * @param provider
	 *        The content provider for this dialog. May be a {@link IHierarchicContentProvider}
	 */
	public void setContentProvider(ITreeContentProvider provider) {
		contentProvider = provider;
		if(fTree != null) {
			getViewer().setContentProvider(contentProvider);
			if(getViewer().getInput() == null) {
				doSetInput();
			}
			List<?> initialSelection = getInitialElementSelections();
			if(!initialSelection.isEmpty()) {
				getViewer().setSelection(new StructuredSelection(initialSelection.get(0)), true);
			}
		}
	}

	@Override
	protected Composite getDialogArea() {
		return (Composite)super.getDialogArea();
	}

	@Override
	public void create() {
		super.create();

		descriptionLabel = new Label(getDialogArea(), SWT.WRAP);
		descriptionLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		fTree = new FilteredTree(getDialogArea(), SWT.BORDER, new PatternFilter(), true);
		if(labelProvider != null) {
			getViewer().setLabelProvider(labelProvider);
		}
		if(contentProvider != null) {
			getViewer().setContentProvider(contentProvider);
			if(getViewer().getInput() == null) {
				doSetInput();
			}

			List<?> initialSelection = getInitialElementSelections();
			if(!initialSelection.isEmpty() && initialSelection.get(0) != null) {
				getViewer().setSelection(new StructuredSelection(initialSelection.get(0)), true);
			}
		}

		getViewer().addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();

				Object selectedElement = null;
				if(selection instanceof IStructuredSelection && !selection.isEmpty()) {
					IStructuredSelection sSelection = (IStructuredSelection)selection;
					selectedElement = sSelection.getFirstElement();
				}

				if(contentProvider instanceof IHierarchicContentProvider) {
					boolean isValidValue = ((IHierarchicContentProvider)contentProvider).isValidValue(selectedElement);
					if(isValidValue) {
						setResult(Collections.singletonList(selectedElement));
					} else {
						setResult(Collections.EMPTY_LIST);
					}
					getOkButton().setEnabled(isValidValue);
				}
			}
		});

		getViewer().addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				if(getOkButton().isEnabled()) {
					okPressed();
				}
			}

		});

		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.minimumHeight = 300;
		data.minimumWidth = 300;
		getViewer().getTree().setLayoutData(data);

		getShell().setImage(Activator.getDefault().getImage("/icons/papyrus.png")); //$NON-NLS-1$
		getShell().pack();
	}

	/**
	 * Sets the description for this Dialog. The description is displayed on
	 * top of the dialog
	 * 
	 * @param description
	 *        The description for this dialog
	 */
	public void setDescription(String description) {
		descriptionLabel.setText(description);
	}

	/**
	 * Get the TreeViewer used by this dialog
	 * 
	 * @return
	 *         The TreeViewer associated to this dialog
	 */
	protected TreeViewer getViewer() {
		return fTree.getViewer();
	}

	/**
	 * Sets the input object for this dialog's TreeViewer
	 * 
	 * @param input
	 */
	public void setInput(Object input) {
		this.input = input;
	}

	private void doSetInput() {
		if(input == null) {
			//Default non-null input for IStaticContentProvider (input-independent)
			getViewer().setInput(""); //$NON-NLS-1$
		} else {
			getViewer().setInput(input);
		}
	}

}
