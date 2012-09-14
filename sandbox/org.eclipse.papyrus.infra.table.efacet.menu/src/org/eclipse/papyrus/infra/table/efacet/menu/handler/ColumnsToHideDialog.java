/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *   Gregoire Dupe (Mia-Software) - Bug 341238 - We need to be able to specify which column have to be hidden/visible using the customization mechanism
 *   Vincent Lorenzo (CEA-LIST) - Bug 341238 - We need to be able to specify which column have to be hidden/visible using the customization mechanism
 *   Nicolas Bros (Mia-Software) - Bug 344247 - illegal API use in org.eclipse.emf.facet.widgets.nattable.internal.dialogs.ColumnsToHideDialog
 *   Gregoire Dupe (Mia-Software) - Bug 366804 - [Restructuring] Table widget upgrade
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.efacet.menu.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Column;

//import org.eclipse.emf.facet.widgets.table.ui.internal.comparator.ColumnComparator;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionDialog;

public class ColumnsToHideDialog extends SelectionDialog {

	//	private final Object inputElement;
	private final ILabelProvider labelProvider;

	private final SortedColumnContentProvider contentProvider;

	private CheckboxTreeViewer listViewer;

	//
	//	private static final int DIALOG_WIDTH = 300;
	//	private static final int DIALOG_HEIGHT = 300;
	//
	//	/** indicates if the local customization files should be set at the top */
	//	private boolean setAtTheTop;
	//
	//	/** the initial selection */
	//	private List<Column> initialSelection;
	//
	//	private final boolean askToPutOnTheTopTheLocalCustomization;Z
	//
	//	private boolean mustAskTheUserNextTime;
	//
	//	private PutOnTheTopQuestionDialog putOnTheTopQuestionDialog;

	private final Collection<EObject> input;

	private final Collection<ETypedElement> initialSelection;

	public ColumnsToHideDialog(final Shell parentShell, final Collection<EObject> classifiers, final Collection<ETypedElement> initialSelection, final ILabelProvider labelProvider) {
		super(parentShell);
		setTitle("Select the columns to show");
		this.input = classifiers;
		this.labelProvider = labelProvider;
		this.contentProvider = new SortedColumnContentProvider();
		this.initialSelection = initialSelection;
	}

	//	/**
	//	 * Visually checks the previously-specified elements in this dialog's list
	//	 * viewer.
	//	 */
	//	private void checkInitialSelections() {
	//		Iterator<?> itemsToCheck = getInitialElementSelections().iterator();
	//
	//		while(itemsToCheck.hasNext()) {
	//			this.listViewer.setChecked(itemsToCheck.next(), true);
	//		}
	//	}

	@Override
	protected void configureShell(final Shell shell) {
		super.configureShell(shell);
		//		shell.setImage(ImageProvider.getInstance().getSelectColumnsToHide());
	}

	@Override
	protected Control createDialogArea(final Composite parent) {
		// page group
		Composite composite = (Composite)super.createDialogArea(parent);

		initializeDialogUnits(composite);

		createMessageArea(composite);

		this.listViewer = new CheckboxTreeViewer(composite, 0);
		GridData data = new GridData(GridData.FILL_BOTH);
		data.heightHint = 300;
		//		data.widthHint = ColumnsToHideDialog.DIALOG_WIDTH;
		this.listViewer.getTree().setLayoutData(data);

		this.listViewer.setLabelProvider(this.labelProvider);
		this.listViewer.setContentProvider(this.contentProvider);

		//		addSelectionButtons(composite);

		this.listViewer.setInput(input);
		this.listViewer.setCheckedElements((this.initialSelection.toArray()));
		this.listViewer.expandAll();
		// initialize page
		//		if(!getInitialElementSelections().isEmpty()) {
		//			//			checkInitialSelections();
		//		}

		// this checkbox allows sorting the columns by name
		//		final Button cbSort = new Button(composite, SWT.CHECK);
		//		cbSort.setText("Sort Columns By Name"); //$NON-NLS-1$ // TODO should be externalized
		//		cbSort.pack();
		//		cbSort.addSelectionListener(new SelectionAdapter() {
		//
		//			@Override
		//			public void widgetSelected(final SelectionEvent e) {
		//				ColumnsToHideDialog.this.contentProvider.setIsSorted(cbSort.getSelection());
		//				getViewer().refresh();
		//			}
		//		});
		Dialog.applyDialogFont(composite);
		return composite;

	}

	/**
	 * Returns the viewer used to show the list.
	 * 
	 * @return the viewer, or <code>null</code> if not yet created
	 */
	protected CheckboxTreeViewer getViewer() {
		return this.listViewer;
	}

	//
	//	/** Add the selection and deselection buttons to the dialog. */
	//	private void addSelectionButtons(final Composite composite) {
	//		Composite buttonComposite = new Composite(composite, SWT.NONE);
	//		GridLayout layout = new GridLayout();
	//		layout.numColumns = 0;
	//		layout.marginWidth = 0;
	//		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
	//		buttonComposite.setLayout(layout);
	//		buttonComposite.setLayoutData(new GridData(SWT.END, SWT.TOP, true, false));
	//
	//		Button selectButton = createButton(buttonComposite, IDialogConstants.SELECT_ALL_ID, "&Select All", false); //$NON-NLS-1$ // TODO should be externalized
	//
	//		SelectionListener listener = new SelectionAdapter() {
	//
	//			@Override
	//			public void widgetSelected(final SelectionEvent e) {
	//				selectAll();
	//			}
	//		};
	//		selectButton.addSelectionListener(listener);
	//
	//		Button deselectButton = createButton(buttonComposite, IDialogConstants.DESELECT_ALL_ID, "&Deselect All", false); //$NON-NLS-1$ // TODO should be externalized
	//
	//		listener = new SelectionAdapter() {
	//
	//			@Override
	//			public void widgetSelected(final SelectionEvent e) {
	//				deselectAll();
	//			}
	//		};
	//		deselectButton.addSelectionListener(listener);
	//	}

	/**
	 * 
	 * @see org.eclipse.jface.window.Window#open()
	 * 
	 * @return
	 */
	@Override
	public int open() {
		//		if(this.askToPutOnTheTopTheLocalCustomization) {
		//			this.putOnTheTopQuestionDialog = openPutOnTheTopQuestionDialog();
		//		}
		//		this.initialSelection = getVisibleColumns(this.setAtTheTop);
		//		setInitialElementSelections(this.initialSelection);
		return super.open();
	}

	//	/**
	//	 * 
	//	 * @return <ul>
	//	 *         <li>IDialogConstants.NO_ID</li>
	//	 *         <li>IDialogConstants.YES_ID</li>
	//	 *         <li><code>-1<code> in other cases</li>
	//	 *         </ul>
	//	 */
	//	private PutOnTheTopQuestionDialog openPutOnTheTopQuestionDialog() {
	//		String message = TableWidgetPreferencePage.DISPLAYED_MESSAGE_1 + " " + TableWidgetPreferencePage.DISPLAYED_MESSAGE_2 + "\n\n" + TableWidgetPreferencePage.DISPLAYED_QUESTION; //$NON-NLS-1$//$NON-NLS-2$
	//		String toggleMessage = TableWidgetPreferencePage.DONT_DISPLAY_NEXT_TIME;
	//		final PutOnTheTopQuestionDialog dialog = new PutOnTheTopQuestionDialog(getShell(), Messages.NatTableWidget_selectColumnToShowHide, ImageProvider.getInstance().getSelectColumnsToHide(), message, MessageDialog.WARNING, new String[]{ IDialogConstants.YES_LABEL, IDialogConstants.NO_LABEL }, 0, toggleMessage, false) {
	//
	//			@Override
	//			public boolean close() {
	//				ColumnsToHideDialog.this.setAtTheTop = isPutOnTheTop();
	//				ColumnsToHideDialog.this.mustAskTheUserNextTime = this.isAskTheUserNextTime();
	//				return super.close();
	//			}
	//		};
	//		Display.getDefault().asyncExec(new Runnable() {
	//
	//			public void run() {
	//				dialog.open();
	//			}
	//		});
	//		return dialog;
	//	}

	//	public boolean isPutOnTheTop() {
	//		return this.setAtTheTop;
	//	}

	//	/**
	//	 * 
	//	 * @see org.eclipse.emf.facet.widgets.nattable.internal.IColumnsToHideDialog#getInitialSelection()
	//	 * 
	//	 * @return the initial selection
	//	 */
	//	public List<Column> getInitialSelection() {
	//		return this.initialSelection;
	//	}
	//
	//	public IPutOnTheTopQuestionDialog isPutOnTheTopQuestionDialog() {
	//		return this.putOnTheTopQuestionDialog;
	//	}

	public void pressOk() {
		okPressed();
	}

	//	public abstract List<Column> getVisibleColumns(boolean putOnTheTop);

	public List<Column> getSelectedColumns() {
		List<Column> resultList = new ArrayList<Column>();
		for(Object result : getResult()) {
			if(result instanceof Column) {
				Column column = (Column)result;
				resultList.add(column);
			}
		}
		return resultList;
	}

	//	public boolean isMustAskTheUserNextTime() {
	//		return this.mustAskTheUserNextTime;
	//	}

	public void selectAll() {
		getViewer().setAllChecked(true);
	}

	public void deselectAll() {
		getViewer().setAllChecked(false);
	}

	/**
	 * The <code>ListSelectionDialog</code> implementation of this <code>Dialog</code> method builds a list of the selected elements for
	 * later retrieval by the client and closes this dialog.
	 */
	@Override
	protected void okPressed() {
		setResult(Arrays.asList(this.listViewer.getCheckedElements()));
		//		// Get the input children.
		//		Object[] children = this.contentProvider.getElements(this.inputElement);
		//
		//		// Build a list of selected children.
		//		if(children != null) {
		//			ArrayList<Object> list = new ArrayList<Object>();
		//			for(int i = 0; i < children.length; ++i) {
		//				Object element = children[i];
		//				if(this.listViewer.getChecked(element)) {
		//					list.add(element);
		//				}
		//			}
		//			setResult(list);
		//		}

		super.okPressed();
	}

	//	public IPutOnTheTopQuestionDialog getPutOnTheTopQuestionDialog() {
	//		return this.putOnTheTopQuestionDialog;
	//	}
}
