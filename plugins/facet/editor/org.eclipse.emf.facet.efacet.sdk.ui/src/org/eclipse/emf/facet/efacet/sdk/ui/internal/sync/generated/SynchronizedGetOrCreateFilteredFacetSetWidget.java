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

package org.eclipse.emf.facet.efacet.sdk.ui.internal.sync.generated;

import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.SynchronizedObject;
import org.eclipse.swt.widgets.Display;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.AbstractVoidExceptionFreeRunnable;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.AbstractExceptionFreeRunnable;

@SuppressWarnings("PMD.ExcessivePublicCount")
public class SynchronizedGetOrCreateFilteredFacetSetWidget extends SynchronizedObject<org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.creation.IGetOrCreateFilteredFacetSetWidget> implements org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.creation.IGetOrCreateFilteredFacetSetWidget {

	public SynchronizedGetOrCreateFilteredFacetSetWidget(final org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.creation.IGetOrCreateFilteredFacetSetWidget object, final Display display) {
		super(object, display);
	}
	public final void addListener(final org.eclipse.emf.facet.util.ui.internal.exported.util.widget.AbstractWidget parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedGetOrCreateFilteredFacetSetWidget.this.getSynchronizedObject().addListener(parm0);
			}
		});
	}
	
	public final void createWidgetContent() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedGetOrCreateFilteredFacetSetWidget.this.getSynchronizedObject().createWidgetContent();
			}
		});
	}
	
	public final java.lang.String getError() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<java.lang.String>() {
			@Override
			public java.lang.String safeRun() {
				return SynchronizedGetOrCreateFilteredFacetSetWidget.this.getSynchronizedObject().getError();
			}
		});
	}
	
	public final void notifyChanged() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedGetOrCreateFilteredFacetSetWidget.this.getSynchronizedObject().notifyChanged();
			}
		});
	}
	
	public final <A> A adapt(final java.lang.Class<A> parm0) {
		return safeSyncExec(new AbstractExceptionFreeRunnable<A>() {
			@Override
			public A safeRun() {
				return SynchronizedGetOrCreateFilteredFacetSetWidget.this.getSynchronizedObject().adapt(parm0);
			}
		});
	}
	
	public final java.lang.Object getCommand() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<java.lang.Object>() {
			@Override
			public java.lang.Object safeRun() {
				return SynchronizedGetOrCreateFilteredFacetSetWidget.this.getSynchronizedObject().getCommand();
			}
		});
	}
	
	public final void onDialogValidation() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedGetOrCreateFilteredFacetSetWidget.this.getSynchronizedObject().onDialogValidation();
			}
		});
	}
	
	public final org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet getElementSelected() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet>() {
			@Override
			public org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet safeRun() {
				return SynchronizedGetOrCreateFilteredFacetSetWidget.this.getSynchronizedObject().getElementSelected();
			}
		});
	}
	
	public final org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog<org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IENamedElementWidget<org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet, org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.creation.IGetOrCreateFilteredFacetSetWidget>> pressNewButton() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog<org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IENamedElementWidget<org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet, org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.creation.IGetOrCreateFilteredFacetSetWidget>>>() {
			@Override
			public org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog<org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IENamedElementWidget<org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet, org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.creation.IGetOrCreateFilteredFacetSetWidget>> safeRun() {
				return SynchronizedGetOrCreateFilteredFacetSetWidget.this.getSynchronizedObject().pressNewButton();
			}
		});
	}
	
	public final void selectElement(final org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedGetOrCreateFilteredFacetSetWidget.this.getSynchronizedObject().selectElement(parm0);
			}
		});
	}
	
	public final void selectElementByName(final java.lang.String parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedGetOrCreateFilteredFacetSetWidget.this.getSynchronizedObject().selectElementByName(parm0);
			}
		});
	}
	
}
