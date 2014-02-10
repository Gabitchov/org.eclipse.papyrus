/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.emf.facet.efacet.sdk.ui.internal.dialog;

import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.sdk.ui.dialog.IFacetDialogFactory;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IDerivedTypedElementWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IENamedElementWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IEStructuralFeatureWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IETypedElementWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IFacetWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.creation.IGetOrCreateFilteredFacetSetWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.AbstractExceptionFreeRunnable;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.SynchronizedObject;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget;
import org.eclipse.swt.widgets.Display;

/**
 * Synchronized class for {@link FacetDialogFactoryImpl}.
 */
public class SynchronizedFacetDialogFactory extends
		SynchronizedObject<IFacetDialogFactory> implements IFacetDialogFactory {

	public SynchronizedFacetDialogFactory(final IFacetDialogFactory object,
			final Display display) {
		super(object, display);
	}

	public IDialog<IENamedElementWidget<FacetSet, IGetOrCreateFilteredFacetSetWidget>> openCreateFacetSetInFacetSetDialog() {
		return this
				.safeSyncExec(new AbstractExceptionFreeRunnable<IDialog<IENamedElementWidget<FacetSet, IGetOrCreateFilteredFacetSetWidget>>>() {
					@Override
					public IDialog<IENamedElementWidget<FacetSet, IGetOrCreateFilteredFacetSetWidget>> safeRun() {
						return SynchronizedFacetDialogFactory.this
								.getSynchronizedObject()
								.openCreateFacetSetInFacetSetDialog();
					}
				});
	}

	public IDialog<IFacetWidget> openCreateFacetInFacetSetDialog() {
		return this
				.safeSyncExec(new AbstractExceptionFreeRunnable<IDialog<IFacetWidget>>() {
					@Override
					public IDialog<IFacetWidget> safeRun() {
						return SynchronizedFacetDialogFactory.this
								.getSynchronizedObject()
								.openCreateFacetInFacetSetDialog();
					}
				});
	}

	public IDialog<IEStructuralFeatureWidget> openAddAttributeInFacetDialog() {
		return this
				.safeSyncExec(new AbstractExceptionFreeRunnable<IDialog<IEStructuralFeatureWidget>>() {
					@Override
					public IDialog<IEStructuralFeatureWidget> safeRun() {
						return SynchronizedFacetDialogFactory.this
								.getSynchronizedObject()
								.openAddAttributeInFacetDialog();
					}
				});
	}

	public IDialog<IEStructuralFeatureWidget> openAddReferenceInFacetDialog() {
		return this
				.safeSyncExec(new AbstractExceptionFreeRunnable<IDialog<IEStructuralFeatureWidget>>() {
					@Override
					public IDialog<IEStructuralFeatureWidget> safeRun() {
						return SynchronizedFacetDialogFactory.this
								.getSynchronizedObject()
								.openAddReferenceInFacetDialog();
					}
				});
	}

	public IDialog<IDerivedTypedElementWidget> openAddOperationInFacetDialog() {
		return this
				.safeSyncExec(new AbstractExceptionFreeRunnable<IDialog<IDerivedTypedElementWidget>>() {
					@Override
					public IDialog<IDerivedTypedElementWidget> safeRun() {
						return SynchronizedFacetDialogFactory.this
								.getSynchronizedObject()
								.openAddOperationInFacetDialog();
					}
				});
	}

	public IDialog<IETypedElementWidget<FacetOperation, IGetOrCreateFilteredElementCommmandWidget<FacetOperation, IDerivedTypedElementWidget>>> openAddParameterInOperationDialog() {
		return this
				.safeSyncExec(new AbstractExceptionFreeRunnable<IDialog<IETypedElementWidget<FacetOperation, IGetOrCreateFilteredElementCommmandWidget<FacetOperation, IDerivedTypedElementWidget>>>>() {
					@Override
					public IDialog<IETypedElementWidget<FacetOperation, IGetOrCreateFilteredElementCommmandWidget<FacetOperation, IDerivedTypedElementWidget>>> safeRun() {
						return SynchronizedFacetDialogFactory.this
								.getSynchronizedObject()
								.openAddParameterInOperationDialog();
					}
				});
	}

	public IDialog<IENamedElementWidget<FacetSet, IGetOrCreateFilteredFacetSetWidget>> openEditFacetSetDialog() {
		return this
				.safeSyncExec(new AbstractExceptionFreeRunnable<IDialog<IENamedElementWidget<FacetSet, IGetOrCreateFilteredFacetSetWidget>>>() {
					@Override
					public IDialog<IENamedElementWidget<FacetSet, IGetOrCreateFilteredFacetSetWidget>> safeRun() {
						return SynchronizedFacetDialogFactory.this
								.getSynchronizedObject()
								.openEditFacetSetDialog();
					}
				});
	}

	public IDialog<IFacetWidget> openEditFacetDialog() {
		return this
				.safeSyncExec(new AbstractExceptionFreeRunnable<IDialog<IFacetWidget>>() {
					@Override
					public IDialog<IFacetWidget> safeRun() {
						return SynchronizedFacetDialogFactory.this
								.getSynchronizedObject().openEditFacetDialog();
					}
				});
	}

	public IDialog<IEStructuralFeatureWidget> openEditFacetAttributeDialog() {
		return this
				.safeSyncExec(new AbstractExceptionFreeRunnable<IDialog<IEStructuralFeatureWidget>>() {
					@Override
					public IDialog<IEStructuralFeatureWidget> safeRun() {
						return SynchronizedFacetDialogFactory.this
								.getSynchronizedObject()
								.openEditFacetAttributeDialog();
					}
				});
	}

	public IDialog<IEStructuralFeatureWidget> openEditFacetReferenceDialog() {
		return this
				.safeSyncExec(new AbstractExceptionFreeRunnable<IDialog<IEStructuralFeatureWidget>>() {
					@Override
					public IDialog<IEStructuralFeatureWidget> safeRun() {
						return SynchronizedFacetDialogFactory.this
								.getSynchronizedObject()
								.openEditFacetReferenceDialog();
					}
				});
	}

	public IDialog<IDerivedTypedElementWidget> openEditFacetOperationDialog() {
		return this
				.safeSyncExec(new AbstractExceptionFreeRunnable<IDialog<IDerivedTypedElementWidget>>() {
					@Override
					public IDialog<IDerivedTypedElementWidget> safeRun() {
						return SynchronizedFacetDialogFactory.this
								.getSynchronizedObject()
								.openEditFacetOperationDialog();
					}
				});
	}

	public IDialog<IETypedElementWidget<FacetOperation, IGetOrCreateFilteredElementCommmandWidget<FacetOperation, IDerivedTypedElementWidget>>> openEditFacetOperationParameterDialog() {
		return this
				.safeSyncExec(new AbstractExceptionFreeRunnable<IDialog<IETypedElementWidget<FacetOperation, IGetOrCreateFilteredElementCommmandWidget<FacetOperation, IDerivedTypedElementWidget>>>>() {
					@Override
					public IDialog<IETypedElementWidget<FacetOperation, IGetOrCreateFilteredElementCommmandWidget<FacetOperation, IDerivedTypedElementWidget>>> safeRun() {
						return SynchronizedFacetDialogFactory.this
								.getSynchronizedObject()
								.openEditFacetOperationParameterDialog();
					}
				});
	}

}
