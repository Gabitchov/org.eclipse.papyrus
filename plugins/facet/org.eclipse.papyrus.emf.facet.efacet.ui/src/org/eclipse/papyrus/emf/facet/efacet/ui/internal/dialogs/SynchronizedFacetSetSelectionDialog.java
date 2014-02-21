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
package org.eclipse.papyrus.emf.facet.efacet.ui.internal.dialogs;

import java.util.List;

import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.exported.dialog.IFacetSetSelectionDialog;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.exported.dialog.IFacetSetSelectionDialogInternal;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.AbstractExceptionFreeRunnable;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.AbstractVoidExceptionFreeRunnable;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.SynchronizedComposite;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Shell;

/** A synchronization facade for {@link IFacetSetSelectionDialog}. */
public class SynchronizedFacetSetSelectionDialog<T> extends SynchronizedComposite<Shell> implements IFacetSetSelectionDialogInternal<T> {

	private final IFacetSetSelectionDialogInternal<T> dialog;

	public IFacetSetSelectionDialogInternal<T> getDialog() {
		return this.dialog;
	}

	public SynchronizedFacetSetSelectionDialog(final FacetSetSelectionDialog<T> delegate) {
		super(delegate.getShell());
		this.dialog = delegate;
	}

	public void setSelectedFacetSets(final List<? extends FacetSet> newSelection) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				getDialog().setSelectedFacetSets(newSelection);

			}
		});
	}

	public T pressOk() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<T>() {
			@Override
			public T safeRun() {
				return getDialog().pressOk();
			}
		});
	}

	public void pressCancel() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				getDialog().pressCancel();
			}
		});
	}

	public void selectAll() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				getDialog().selectAll();
			}
		});
	}

	public void deselectAll() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				getDialog().deselectAll();
			}
		});
	}

	public boolean isOkButtonEnabled() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(getDialog().isOkButtonEnabled());
			}
		}).booleanValue();
	}

	public TreeViewer getTreeViewer() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<TreeViewer>() {
			@Override
			public TreeViewer safeRun() {
				return getDialog().getTreeViewer();
			}
		});
	}

}
