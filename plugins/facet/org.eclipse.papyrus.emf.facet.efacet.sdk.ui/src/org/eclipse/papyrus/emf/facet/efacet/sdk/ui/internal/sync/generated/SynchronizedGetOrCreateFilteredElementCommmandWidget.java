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
package org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.sync.generated;

import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.AbstractExceptionFreeRunnable;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.AbstractVoidExceptionFreeRunnable;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.displaysync.SynchronizedObject;
import org.eclipse.swt.widgets.Display;

public class SynchronizedGetOrCreateFilteredElementCommmandWidget<T extends java.lang.Object, W extends java.lang.Object>
		extends
		SynchronizedObject<org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget<T, W>>
		implements
		org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget<T, W> {

	public SynchronizedGetOrCreateFilteredElementCommmandWidget(
			final org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget<T, W> object,
			final Display display) {
		super(object, display);
	}

	public final void addListener(
			final org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.AbstractWidget parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedGetOrCreateFilteredElementCommmandWidget.this
						.getSynchronizedObject().addListener(parm0);
			}
		});
	}

	public final void createWidgetContent() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedGetOrCreateFilteredElementCommmandWidget.this
						.getSynchronizedObject().createWidgetContent();
			}
		});
	}

	public final java.lang.String getError() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<java.lang.String>() {
			@Override
			public java.lang.String safeRun() {
				return SynchronizedGetOrCreateFilteredElementCommmandWidget.this
						.getSynchronizedObject().getError();
			}
		});
	}

	public final void notifyChanged() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedGetOrCreateFilteredElementCommmandWidget.this
						.getSynchronizedObject().notifyChanged();
			}
		});
	}

	public final <A> A adapt(final java.lang.Class<A> parm0) {
		return safeSyncExec(new AbstractExceptionFreeRunnable<A>() {
			@Override
			public A safeRun() {
				return SynchronizedGetOrCreateFilteredElementCommmandWidget.this
						.getSynchronizedObject().adapt(parm0);
			}
		});
	}

	public final java.lang.Object getCommand() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<java.lang.Object>() {
			@Override
			public java.lang.Object safeRun() {
				return SynchronizedGetOrCreateFilteredElementCommmandWidget.this
						.getSynchronizedObject().getCommand();
			}
		});
	}

	public final void onDialogValidation() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedGetOrCreateFilteredElementCommmandWidget.this
						.getSynchronizedObject().onDialogValidation();
			}
		});
	}

	public final T getElementSelected() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<T>() {
			@Override
			public T safeRun() {
				return SynchronizedGetOrCreateFilteredElementCommmandWidget.this
						.getSynchronizedObject().getElementSelected();
			}
		});
	}

	public final org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog<W> pressNewButton() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog<W>>() {
			@Override
			public org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog<W> safeRun() {
				return SynchronizedGetOrCreateFilteredElementCommmandWidget.this
						.getSynchronizedObject().pressNewButton();
			}
		});
	}

	public final void selectElement(final T parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedGetOrCreateFilteredElementCommmandWidget.this
						.getSynchronizedObject().selectElement(parm0);
			}
		});
	}

	public final void selectElementByName(final java.lang.String parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedGetOrCreateFilteredElementCommmandWidget.this
						.getSynchronizedObject().selectElementByName(parm0);
			}
		});
	}

}
