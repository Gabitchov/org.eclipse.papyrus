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
package org.eclipse.emf.facet.efacet.ui.internal.widget;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.ui.internal.exported.widget.IFacetSetSelectionWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.AbstractExceptionFreeRunnable;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.AbstractVoidExceptionFreeRunnable;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.SynchronizedObject;
import org.eclipse.swt.widgets.Control;

public class SynchronizedFacetSetSelectionWidget extends SynchronizedObject<FacetSetSelectionControl> implements IFacetSetSelectionWidget {

	private final FacetSetSelectionControl control;

	protected FacetSetSelectionControl getDelegate() {
		return this.control;
	}

	public SynchronizedFacetSetSelectionWidget(final FacetSetSelectionControl control) {
		super(control, control.getTreeViewer().getTree().getDisplay());
		this.control = control;
	}

	public void setAvailableFacetSets(final Collection<? extends FacetSet> available) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				getDelegate().setAvailableFacetSets(available);
			}
		});
	}

	public List<FacetSet> getSelectedFacetSets() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<List<FacetSet>>() {
			@Override
			public List<FacetSet> safeRun() {
				return getDelegate().getSelectedFacetSets();
			}
		});
	}

	public void setSelectedFacetSets(final Collection<? extends FacetSet> facetSetsToSelect) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				getDelegate().setSelectedFacetSets(facetSetsToSelect);
			}
		});
	}

	public IStatus getValidationStatus() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<IStatus>() {
			@Override
			public IStatus safeRun() {
				return getDelegate().getValidationStatus();
			}
		});
	}

	public boolean isDisposed() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(getDelegate().isDisposed());
			}
		}).booleanValue();
	}

	public Control getControl() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<Control>() {
			@Override
			public Control safeRun() {
				return getDelegate().getControl();
			}
		});
	}
}
