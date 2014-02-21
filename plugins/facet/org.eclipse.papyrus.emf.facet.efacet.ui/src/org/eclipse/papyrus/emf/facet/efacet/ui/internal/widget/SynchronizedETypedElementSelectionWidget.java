/*******************************************************************************
 * Copyright (c) 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software) - Bug 370806 - [table] rewrite the "allowed contents" query selection dialog for v0.2
 *     Vincent Lorenzo (CEA-LIST) -  Bug 372644 - Create Customizable tooltips for the TreeViewer using a CustomizableLabelProvider
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.efacet.ui.internal.widget;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.AbstractExceptionFreeRunnable;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.AbstractVoidExceptionFreeRunnable;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.SynchronizedObject;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.FilteredTree;

public class SynchronizedETypedElementSelectionWidget extends SynchronizedObject<ETypedElementSelectionControlManager> implements
		IETypedElementSelectionWidgetInternal {

	private final ETypedElementSelectionControlManager control;

	protected IETypedElementSelectionWidgetInternal getControl() {
		return this.control;
	}

	public SynchronizedETypedElementSelectionWidget(final ETypedElementSelectionControlManager control) {
		super(control, control.getFilteredTree().getDisplay());
		this.control = control;
	}

	public void setAvailableETypedElements(final Collection<? extends ETypedElement> available) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				getControl().setAvailableETypedElements(available);
			}
		});
	}

	public List<ETypedElement> getSelectedETypedElements() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<List<ETypedElement>>() {
			@Override
			public List<ETypedElement> safeRun() {
				return getControl().getSelectedETypedElements();
			}
		});
	}

	public void setSelectedETypedElements(final Collection<? extends ETypedElement> elementsToSelect) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				getControl().setSelectedETypedElements(elementsToSelect);
			}
		});
	}

	public void addOpenListener(final IOpenListener openListener) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				getControl().addOpenListener(openListener);
			}
		});
	}

	public void addSelectionChangedListener(final ISelectionChangedListener listener) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				getControl().addSelectionChangedListener(listener);
			}
		});
	}

	public IStatus getValidationStatus() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<IStatus>() {
			@Override
			public IStatus safeRun() {
				return getControl().getValidationStatus();
			}
		});
	}

	public boolean isDisposed() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(getControl().isDisposed());
			}
		}).booleanValue();
	}

	public FilteredTree getFilteredTree() {
		// should not be used!
		throw new UnsupportedOperationException();
	}

	public void createContents() {
		// //nothing to do
		throw new UnsupportedOperationException();
	}

	public void setSelection(final IStructuredSelection selection) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				getControl().setSelection(selection);
			}
		});
	}

}
