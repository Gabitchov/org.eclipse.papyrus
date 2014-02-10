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
package org.eclipse.emf.facet.util.ui.internal.exported.util.dialog;

import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.AbstractExceptionFreeRunnable;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.AbstractVoidExceptionFreeRunnable;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.SynchronizedObject;
import org.eclipse.swt.widgets.Display;

/**
 * Synchronized class for safe run.
 * 
 * @see AbstractDialog
 * @since 0.3
 * 
 */
public class SynchronizedAbstractDialog<W extends Object> extends
		SynchronizedObject<IDialog<W>> implements IDialog<W> {

	/**
	 * Constructor.
	 * 
	 * @param object
	 *            the to synchronized.
	 * @param display
	 *            the display.
	 */
	public SynchronizedAbstractDialog(final IDialog<W> object,
			final Display display) {
		super(object, display);
	}

	public void commit() {
		this.voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedAbstractDialog.this.getSynchronizedObject()
						.commit();
			}
		});
	}

	public void cancel() {
		this.voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedAbstractDialog.this.getSynchronizedObject()
						.cancel();
			}
		});
	}

	public int open() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<Integer>() {
			@Override
			public Integer safeRun() {
				return Integer.valueOf(SynchronizedAbstractDialog.this
						.getSynchronizedObject().open());
			}
		}).intValue();
	}

	public boolean isDialogValid() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(SynchronizedAbstractDialog.this
						.getSynchronizedObject().isDialogValid());
			}
		}).booleanValue();
	}

	public W getWidget() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<W>() {
			@Override
			public W safeRun() {
				return SynchronizedAbstractDialog.this.getSynchronizedObject()
						.getWidget();
			}
		});
	}

}
