/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software) - Bug 372865 - FacetSet selection dialog
 *     Gregoire Dupe (Mia-Software) - Bug 372626 - Aggregates
 *******************************************************************************/
package org.eclipse.emf.facet.efacet.ui.internal.dialogs;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.ui.internal.Activator;
import org.eclipse.emf.facet.efacet.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.ui.internal.exported.dialog.IFacetSetSelectionDialogInternal;
import org.eclipse.emf.facet.efacet.ui.internal.widget.FacetSetSelectionControl;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialogCallback;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialogCallbackWithPreCommit;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionStatusDialog;

/**
 * A dialog to select {@link FacetSet}s
 * 
 * @param <T>
 *            the type of a pre-commit dialog
 */
public class FacetSetSelectionDialog<T> extends SelectionStatusDialog implements IFacetSetSelectionDialogInternal<T> {

	// note: the dialog should be large enough to see the validator message
	private static final int DEFAULT_WIDTH = 800;
	private static final int DEFAULT_HEIGHT = 600;

	private final Collection<FacetSet> available;
	private final int selectionMaxSize;
	private final boolean allowEmpty;
	private final IDialogCallbackWithPreCommit<List<FacetSet>, Boolean, T> callback;
	private FacetSetSelectionControl selectionControl;

	public FacetSetSelectionDialog(final Collection<FacetSet> available,
			final int selectionMaxSize, final boolean allowEmpty,
			final IDialogCallbackWithPreCommit<List<FacetSet>, Boolean, T> callback, final Shell parentShell) {
		super(parentShell);
		Assert.isLegal(callback != null, "available cannot be null"); //$NON-NLS-1$
		Assert.isLegal(callback != null, "callback cannot be null"); //$NON-NLS-1$
		Assert.isLegal(selectionMaxSize > 0, "selectionMaxSize must be > 0"); //$NON-NLS-1$
		this.available = available;
		this.selectionMaxSize = selectionMaxSize;
		this.allowEmpty = allowEmpty;
		this.callback = callback;
		setHelpAvailable(false);
	}

	@Override
	protected Control createDialogArea(final Composite parent) {
		final Composite composite = (Composite) super.createDialogArea(parent);
		final Runnable onChange = new Runnable() {
			public void run() {
				updateValidationStatus();
			}
		};
		this.selectionControl = createFacetSetSelectionControl(composite, onChange);
		this.selectionControl.createContents();
		this.selectionControl.setAvailableFacetSets(this.available);
		updateValidationStatus();
		return composite;
	}

	protected FacetSetSelectionControl createFacetSetSelectionControl(final Composite parentComposite, final Runnable onChange) {
		return new FacetSetSelectionControl(parentComposite, this.selectionMaxSize, this.allowEmpty, onChange);
	}

	@Override
	protected void createButtonsForButtonBar(final Composite parent) {
		createButton(parent, IDialogConstants.SELECT_ALL_ID, Messages.FacetSetSelectionDialog_selectAll, false);
		createButton(parent, IDialogConstants.DESELECT_ALL_ID, Messages.FacetSetSelectionDialog_deselectAll, false);
		super.createButtonsForButtonBar(parent);
	}

	@Override
	protected void buttonPressed(final int buttonId) {
		super.buttonPressed(buttonId);
		if (IDialogConstants.SELECT_ALL_ID == buttonId) {
			selectAll();
		} else if (IDialogConstants.DESELECT_ALL_ID == buttonId) {
			deselectAll();
		}
	}

	protected void updateValidationStatus() {
		updateStatus(this.selectionControl.getValidationStatus());
	}

	@Override
	protected void configureShell(final Shell shell) {
		super.configureShell(shell);
		if (this.selectionMaxSize > 1) {
			shell.setText(Messages.FacetSetSelectionDialog_titleSelectFacetSets);
		} else {
			shell.setText(Messages.FacetSetSelectionDialog_titleSelectFacetSet);
		}
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected IDialogSettings getDialogBoundsSettings() {
		final String sectionName = this.getClass().getName() + ".settings"; //$NON-NLS-1$
		final IDialogSettings settings = Activator.getDefault().getDialogSettings();
		IDialogSettings section = settings.getSection(sectionName);
		if (section == null) {
			section = settings.addNewSection(sectionName);
			// cf Dialog#DIALOG_WIDTH
			section.put("DIALOG_WIDTH", FacetSetSelectionDialog.DEFAULT_WIDTH); //$NON-NLS-1$
			section.put("DIALOG_HEIGHT", FacetSetSelectionDialog.DEFAULT_HEIGHT); //$NON-NLS-1$
		}
		return section;
	}

	public boolean isErrorStatus() {
		final IStatus validationStatus = this.selectionControl.getValidationStatus();
		return validationStatus == null || validationStatus.getSeverity() >= IStatus.ERROR;
	}

	public T pressOk() {
		final IDialogCallback<Boolean> precommitCallBack = new IDialogCallback<Boolean>() {
			public void committed(final Boolean precommitResult) {
				commit(precommitResult);
			}
		};
		final T dialog = this.callback.openPrecommitDialog(
				getSelectedFacetSets(),
				precommitCallBack);
		if (dialog == null) {
			commit(Boolean.TRUE);
		}
		return dialog;
	}

	public void pressCancel() {
		setReturnCode(Window.CANCEL);
		close();
	}

	@Override
	protected void okPressed() {
		pressOk();
	}

	@Override
	protected void cancelPressed() {
		pressCancel();
	}

	protected void commit(final Boolean precommitResult) {
		// since the callback is called from client code, we need to ensure we are running on the UI thread
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				commitOnUIThread(precommitResult);
			}
		});
	}

	protected void commitOnUIThread(final Boolean precommitResult) {
		final List<FacetSet> selectedFacetSets = getSelectedFacetSets();
		setReturnCode(Window.OK);
		close();
		this.callback.committed(selectedFacetSets, precommitResult);
	}

	@Override
	public int open() {
		// so that this dialog can be manipulated programmatically
		setBlockOnOpen(false);
		return super.open();
	}

	public List<FacetSet> getSelectedFacetSets() {
		if (this.selectionControl.isDisposed()) {
			throw new UnsupportedOperationException("No selection available because the dialog is closed"); //$NON-NLS-1$
		}
		return this.selectionControl.getSelectedFacetSets();
	}

	public void setSelectedFacetSets(final List<? extends FacetSet> newSelection) {
		this.selectionControl.setSelectedFacetSets(newSelection);
		updateValidationStatus();
	}

	public void selectAll() {
		this.selectionControl.selectAll();
		updateValidationStatus();
	}

	public void deselectAll() {
		this.selectionControl.deselectAll();
		updateValidationStatus();
	}

	public boolean isOkButtonEnabled() {
		return getOkButton().isEnabled();
	}

	@Override
	protected void computeResult() {
		// nothing : the dialog is not used in a standard way : use the callback
	}
	
	public TreeViewer getTreeViewer() {
		return this.selectionControl.getTreeViewer();
	}
}