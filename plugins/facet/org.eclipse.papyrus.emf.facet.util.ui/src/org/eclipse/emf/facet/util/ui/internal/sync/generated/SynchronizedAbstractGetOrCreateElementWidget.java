/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.emf.facet.util.ui.internal.sync.generated;

import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.SynchronizedObject;
import org.eclipse.swt.widgets.Display;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.AbstractVoidExceptionFreeRunnable;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.AbstractExceptionFreeRunnable;

public class SynchronizedAbstractGetOrCreateElementWidget
		extends
		SynchronizedObject<org.eclipse.emf.facet.util.ui.internal.exported.widget.getorcreate.IAbstractGetOrCreateElementWidget>
		implements
		org.eclipse.emf.facet.util.ui.internal.exported.widget.getorcreate.IAbstractGetOrCreateElementWidget {

	public SynchronizedAbstractGetOrCreateElementWidget(
			final org.eclipse.emf.facet.util.ui.internal.exported.widget.getorcreate.IAbstractGetOrCreateElementWidget object,
			final Display display) {
		super(object, display);
	}

	public final void addListener(
			final org.eclipse.emf.facet.util.ui.internal.exported.util.widget.AbstractWidget parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedAbstractGetOrCreateElementWidget.this
						.getSynchronizedObject().addListener(parm0);
			}
		});
	}

	public final void createWidgetContent() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedAbstractGetOrCreateElementWidget.this
						.getSynchronizedObject().createWidgetContent();
			}
		});
	}

	public final java.lang.String getError() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<java.lang.String>() {
			@Override
			public java.lang.String safeRun() {
				return SynchronizedAbstractGetOrCreateElementWidget.this
						.getSynchronizedObject().getError();
			}
		});
	}

	public final void notifyChanged() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedAbstractGetOrCreateElementWidget.this
						.getSynchronizedObject().notifyChanged();
			}
		});
	}

	public final java.lang.String getText() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<java.lang.String>() {
			@Override
			public java.lang.String safeRun() {
				return SynchronizedAbstractGetOrCreateElementWidget.this
						.getSynchronizedObject().getText();
			}
		});
	}

	public final void setText(final java.lang.String parm0) {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedAbstractGetOrCreateElementWidget.this
						.getSynchronizedObject().setText(parm0);
			}
		});
	}

}
