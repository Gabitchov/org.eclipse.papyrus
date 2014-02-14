/*******************************************************************************
 * Copyright (c) 2009-2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software)
 *     Nicolas Guyomar (Mia-Software) - Bug 339874 - Infra QuerySelectionDialog should have a "querySet" icon
 *     Nicolas Bros (Mia-Software) - Bug 366367 - To be able to change the "CanBePresentedInTheTable" query
 *     Nicolas Bros (Mia-Software) - Bug 370806 - [table] rewrite the "allowed contents" query selection dialog for v0.2
 *     Vincent Lorenzo (CEA-LIST) - Bug 372644 - Create Customizable tooltips for the TreeViewer using a CustomizableLabelProvider
 *     Vincent Lorenzo (CEA-LIST) - Bug 357621 - Improve the label displayed for Customization and Facets
 *     Gregoire Dupe (Mia-Software) - Bug 375087 - [Table] ITableWidget.addColumn(List<ETypedElement>, List<FacetSet>)
 *     Gregoire Dupe (Mia-Software) - Bug 372626 - Aggregates
 *     Nicolas Bros (Mia-Software) - Bug 370806 - [table] rewrite the "allowed contents" query selection dialog for v0.2
 *******************************************************************************/
package org.eclipse.emf.facet.efacet.ui.internal.dialogs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.emf.facet.efacet.ui.internal.Activator;
import org.eclipse.emf.facet.efacet.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.ui.internal.exported.dialog.IETypedElementSelectionDialogInternal;
import org.eclipse.emf.facet.efacet.ui.internal.widget.ETypedElementSelectionControlManager;
import org.eclipse.emf.facet.efacet.ui.internal.widget.IETypedElementSelectionControlManager;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialogCallbackWithPreCommit;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionStatusDialog;

/**
 * A dialog to select an {@link ETypedElement} among a tree of {@link EObject}s that are children of a given set of root
 * {@link EObject}s
 */
public class ETypedElementSelectionDialog<T2, D> extends SelectionStatusDialog
		implements IETypedElementSelectionDialogInternal<D> { // NOPMD

	// note: the dialog should be large enough to see the validator message
	private static final int DEFAULT_WIDTH = 550;
	private static final int DEFAULT_HEIGHT = 550;

	private final boolean allowEmpty;
	private final IDialogCallbackWithPreCommit<List<ETypedElement>, T2, D> callback;
	private final Collection<? extends ETypedElement> availableElements;
	private final int selectionMaxSize;
	private final ICustomizationManager customManager;
	private IETypedElementSelectionControlManager manager;
	private final Collection<? extends EPackage> knownEPackage;

	/**
	 * @param eTypedElements
	 *            the list of ETypedElements that can be selected
	 * @param selectionMaxSize
	 *            the maximum number of typed elements that the user can select
	 * @param allowEmpty
	 *            whether to allow the user to select no ETypedElement (i.e : select <code>null</code>)
	 * @param callback
	 *            called when the dialog closes
	 * @param parentShell
	 *            the parent shell
	 * @param customManager
	 *            the customization manager used by the ICustomizableLabelProvider
	 */
	public ETypedElementSelectionDialog(final Collection<? extends ETypedElement> eTypedElements,
			final int selectionMaxSize, final boolean allowEmpty,
			final IDialogCallbackWithPreCommit<List<ETypedElement>, T2, D> callback,
			final Shell parentShell, final ICustomizationManager customManager,
			final Collection<? extends EPackage> knownEPackage) {
		super(parentShell);
		this.availableElements = eTypedElements;
		this.selectionMaxSize = selectionMaxSize;
		this.allowEmpty = allowEmpty;
		this.callback = callback;
		this.customManager = customManager;
		this.knownEPackage = knownEPackage;
		setHelpAvailable(false);

	}

	@Override
	protected Control createDialogArea(final Composite parent) {
		final Composite composite = (Composite) super.createDialogArea(parent);
		this.manager = new ETypedElementSelectionControlManager(composite,
				this.selectionMaxSize, this.allowEmpty, this.customManager,
				this.knownEPackage);
		this.manager.createContents();
		this.manager.setAvailableETypedElements(this.availableElements);

		// double-click or enter to choose the selected typed element
		this.manager.addOpenListener(new IOpenListener() {
			public void open(final OpenEvent event) {
				ETypedElementSelectionDialog.this.okPressed();
			}
		});

		this.manager.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(final SelectionChangedEvent event) {
				updateValidationStatus();
			}
		});
		return composite;
	}

	protected void updateValidationStatus() {
		updateStatus(this.manager.getValidationStatus());
	}

	@Override
	protected void configureShell(final Shell shell) {
		super.configureShell(shell);
		if (this.selectionMaxSize > 1) {
			shell.setText(Messages.ETypedElementSelectionDialog_dialogTitleMultiSelection);
		} else {
			shell.setText(Messages.ETypedElementSelectionDialog_dialogTitle);
		}
		// TODO: image for ETypedElement
		// shell.setImage(...);
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
			section.put("DIALOG_WIDTH", ETypedElementSelectionDialog.DEFAULT_WIDTH); //$NON-NLS-1$
			section.put("DIALOG_HEIGHT", ETypedElementSelectionDialog.DEFAULT_HEIGHT); //$NON-NLS-1$
		}
		return section;
	}

	public boolean isErrorStatus() {
		final IStatus validationStatus = this.manager.getValidationStatus();
		return validationStatus == null || validationStatus.getSeverity() >= IStatus.ERROR;
	}

	@Override
	protected void okPressed() {
		if (isErrorStatus()) {
			throw new IllegalStateException("The current selection is not valid"); //$NON-NLS-1$
		}
		super.okPressed();
	}

	public D pressOk() {
		okPressed();
		return null;
	}

	public void pressCancel() {
		setReturnCode(Window.CANCEL);
		close();
	}

	@Override
	public boolean close() {
		final boolean result = super.close();
		invokeCallback();
		return result;
	}

	private void invokeCallback() {
		if (this.callback == null) {
			return;
		}
		if (getReturnCode() == Window.OK) {
			this.callback.committed(getSelectedETypedElements(), null);
		}
	}

	public List<ETypedElement> getSelectedETypedElements() {
		List<ETypedElement> currentlySelected = new ArrayList<ETypedElement>();
		if (this.manager.isDisposed()) {
			final Object[] result = getResult();
			if (result == null) {
				throw new UnsupportedOperationException("No selection available because the dialog was canceled"); //$NON-NLS-1$
			}
			for (Object current : result) {
				currentlySelected.add((ETypedElement) current);
			}
		} else {
			currentlySelected = this.manager.computeResult();
		}
		return Collections.unmodifiableList(currentlySelected);
	}

	public ETypedElement getFirstSelectedETypedElement() {
		ETypedElement result = null;
		final List<ETypedElement> typedElements = getSelectedETypedElements();
		if (typedElements != null && !typedElements.isEmpty()) {
			result = typedElements.get(0);
		}
		return result;
	}

	public void setSelectedETypedElements(final List<? extends ETypedElement> newSelection) {
		if (newSelection == null) {
			throw new IllegalArgumentException();
		}
		this.manager.setSelectedETypedElements(newSelection);
		updateValidationStatus();
	}

	public void setSelection(final IStructuredSelection selection) {
		this.manager.setSelection(selection);
		updateValidationStatus();
	}

	@Override
	protected void computeResult() {
		// we build the result
		final List<ETypedElement> currentSelection = this.manager.computeResult();
		setResult(currentSelection);
	}

	public boolean isOkButtonEnabled() {
		return getOkButton().isEnabled();
	}
}
