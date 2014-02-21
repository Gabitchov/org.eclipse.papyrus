/** 
 * Copyright (c) 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 */

package org.eclipse.emf.facet.efacet.sdk.ui.internal.sync.generated;

import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.SynchronizedObject;
import org.eclipse.swt.widgets.Display;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.AbstractVoidExceptionFreeRunnable;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.AbstractExceptionFreeRunnable;

@SuppressWarnings("PMD.ExcessivePublicCount")
public class SynchronizedENamedElementWidget <C extends org.eclipse.emf.ecore.EObject, CW extends java.lang.Object> extends SynchronizedObject<org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IENamedElementWidget <C, CW>> implements org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IENamedElementWidget <C, CW> {

	public SynchronizedENamedElementWidget(final org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IENamedElementWidget <C, CW> object, final Display display) {
		super(object, display);
	}
	public final void addListener(final org.eclipse.emf.facet.util.ui.internal.exported.util.widget.AbstractWidget parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedENamedElementWidget.this.getSynchronizedObject().addListener(parm0);
			}
		});
	}
	
	public final void createWidgetContent() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedENamedElementWidget.this.getSynchronizedObject().createWidgetContent();
			}
		});
	}
	
	public final java.lang.String getError() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<java.lang.String>() {
			@Override
			public java.lang.String safeRun() {
				return SynchronizedENamedElementWidget.this.getSynchronizedObject().getError();
			}
		});
	}
	
	public final void notifyChanged() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedENamedElementWidget.this.getSynchronizedObject().notifyChanged();
			}
		});
	}
	
	public final <A> A adapt(final java.lang.Class<A> parm0) {
		return safeSyncExec(new AbstractExceptionFreeRunnable<A>() {
			@Override
			public A safeRun() {
				return SynchronizedENamedElementWidget.this.getSynchronizedObject().adapt(parm0);
			}
		});
	}
	
	public final java.lang.Object getCommand() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<java.lang.Object>() {
			@Override
			public java.lang.Object safeRun() {
				return SynchronizedENamedElementWidget.this.getSynchronizedObject().getCommand();
			}
		});
	}
	
	public final void onDialogValidation() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedENamedElementWidget.this.getSynchronizedObject().onDialogValidation();
			}
		});
	}
	
	public final C getContainer() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<C>() {
			@Override
			public C safeRun() {
				return SynchronizedENamedElementWidget.this.getSynchronizedObject().getContainer();
			}
		});
	}
	
	public final java.lang.String getElementName() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<java.lang.String>() {
			@Override
			public java.lang.String safeRun() {
				return SynchronizedENamedElementWidget.this.getSynchronizedObject().getElementName();
			}
		});
	}
	
	public final org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog<CW> pressParentButton() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog<CW>>() {
			@Override
			public org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog<CW> safeRun() {
				return SynchronizedENamedElementWidget.this.getSynchronizedObject().pressParentButton();
			}
		});
	}
	
	public final void setName(final java.lang.String parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedENamedElementWidget.this.getSynchronizedObject().setName(parm0);
			}
		});
	}
	
}
