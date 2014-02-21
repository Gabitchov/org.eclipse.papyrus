/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software) - Bug 372865 - FacetSet selection dialog
 *******************************************************************************/
package org.eclipse.emf.facet.efacet.ui.internal.dialogs;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.ui.internal.exported.dialog.IFacetSetSelectionDialog;
import org.eclipse.emf.facet.efacet.ui.internal.exported.dialog.IFacetSetSelectionDialogFactory;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialogCallback;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialogCallbackWithPreCommit;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class FacetSetSelectionDialogFactory implements IFacetSetSelectionDialogFactory {

	private class DummyPrecommitDialog { // NOPMD
		// placeholder type
	}

	public IFacetSetSelectionDialog<?> openFacetSetSelectionDialog(
			final Collection<FacetSet> available, final int selectionMaxSize, final boolean allowEmpty,
			final IDialogCallback<List<FacetSet>> callback, final Shell parentShell) {

		final IDialogCallbackWithPreCommit<List<FacetSet>, Boolean, FacetSetSelectionDialogFactory.DummyPrecommitDialog> wrappedCallback =
				new IDialogCallbackWithPreCommit<List<FacetSet>, Boolean, FacetSetSelectionDialogFactory.DummyPrecommitDialog>() {
					public void committed(final List<FacetSet> result, final Boolean precommitResult) {
						callback.committed(result);
					}

					public DummyPrecommitDialog openPrecommitDialog(final List<FacetSet> result, final IDialogCallback<Boolean> precommitCallback) {
						return null;
					}
				};

		final FacetSetSelectionDialog<FacetSetSelectionDialogFactory.DummyPrecommitDialog> dialog =
				new FacetSetSelectionDialog<FacetSetSelectionDialogFactory.DummyPrecommitDialog>(
						available, selectionMaxSize, allowEmpty, wrappedCallback, parentShell);
		// must be synchronous, otherwise the shell is not created before SynchronizedFacetSetsSelectionDialog, and
		// SynchronizedComposite throws a NPE
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				dialog.open();
			}
		});
		return new SynchronizedFacetSetSelectionDialog<FacetSetSelectionDialogFactory.DummyPrecommitDialog>(dialog);
	}

	public <T> IFacetSetSelectionDialog<T> openFacetSetSelectionDialog(
			final Collection<FacetSet> available, final int selectionMaxSize, final boolean allowEmpty,
			final IDialogCallbackWithPreCommit<List<FacetSet>, Boolean, T> callback, final Shell parentShell) {
		final FacetSetSelectionDialog<T> dialog = new FacetSetSelectionDialog<T>(available,
				selectionMaxSize, allowEmpty, callback, parentShell);
		// must be synchronous, otherwise the shell is not created before SynchronizedFacetSetsSelectionDialog, and
		// SynchronizedComposite throws a NPE
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				dialog.open();
			}
		});
		return new SynchronizedFacetSetSelectionDialog<T>(dialog);
	}
}
