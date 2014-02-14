/*******************************************************************************
 * Copyright (c) 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software) - Bug 370442 - rewrite the Facet loading dialog for v0.2
 *     Nicolas Bros (Mia-Software) - Bug 370806 - [table] rewrite the "allowed contents" query selection dialog for v0.2
 *     Gregoire Dupe (Mia-Software) - Bug 375087 - [Table] ITableWidget.addColumn(List<ETypedElement>, List<FacetSet>)
 *******************************************************************************/
package org.eclipse.emf.facet.efacet.ui.internal.dialogs;

import java.util.List;

import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.facet.efacet.ui.internal.exported.dialog.IETypedElementSelectionDialog;
import org.eclipse.emf.facet.efacet.ui.internal.exported.dialog.IETypedElementSelectionDialogInternal;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.AbstractExceptionFreeRunnable;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.AbstractVoidExceptionFreeRunnable;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.SynchronizedComposite;
import org.eclipse.swt.widgets.Shell;

/** A synchronization facade for {@link IETypedElementSelectionDialog}. */
public class SynchronizedETypedElementSelectionDialog<T2, D> extends
		SynchronizedComposite<Shell> implements
		IETypedElementSelectionDialogInternal<D> {

	private final IETypedElementSelectionDialogInternal<D> dialog;

	public IETypedElementSelectionDialogInternal<D> getDialog() {
		return this.dialog;
	}

	public SynchronizedETypedElementSelectionDialog(
			final ETypedElementSelectionDialog<T2, D> delegate) {
		super(delegate.getShell());
		this.dialog = delegate;
	}

	public D pressOk() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<D>() {
			@Override
			public D safeRun() {
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

	public List<ETypedElement> getSelectedETypedElements() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<List<ETypedElement>>() {
			@Override
			public List<ETypedElement> safeRun() {
				return getDialog().getSelectedETypedElements();
			}
		});
	}

	public ETypedElement getFirstSelectedETypedElement() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<ETypedElement>() {
			@Override
			public ETypedElement safeRun() {
				return getDialog().getFirstSelectedETypedElement();
			}
		});
	}

	public void setSelectedETypedElements(final List<? extends ETypedElement> newSelection) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				getDialog().setSelectedETypedElements(newSelection);

			}
		});
	}

	public int getReturnCode() {
		return getDialog().getReturnCode();
	}

	public boolean isOkButtonEnabled() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(getDialog().isOkButtonEnabled());
			}
		}).booleanValue();
	}
}
