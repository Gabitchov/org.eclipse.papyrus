/** 
 * Copyright (c) Soft-Maint.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 		Thomas Cicognani (Soft-Maint) - Bug 406565 - Ok Dialog
 */

package org.eclipse.emf.facet.util.ui.internal.sync.generated;

import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IOkDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.AbstractExceptionFreeRunnable;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.AbstractVoidExceptionFreeRunnable;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.SynchronizedObject;
import org.eclipse.swt.widgets.Display;

@SuppressWarnings("PMD.ExcessivePublicCount")
public class SynchronizedOkDialog extends SynchronizedObject<IOkDialog>
		implements IOkDialog {

	public SynchronizedOkDialog(final IOkDialog object, final Display display) {
		super(object, display);
	}
	public final void commit() {
		voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedOkDialog.this.getSynchronizedObject().commit();
			}
		});
	}
	
	public final boolean isError() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(SynchronizedOkDialog.this.getSynchronizedObject().isError());
			}
		}).booleanValue();
	}
	
	public final boolean isInformation() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(SynchronizedOkDialog.this.getSynchronizedObject().isInformation());
			}
		}).booleanValue();
	}
	
	public final boolean isWarning() {
		return safeSyncExec(new AbstractExceptionFreeRunnable<Boolean>() {
			@Override
			public Boolean safeRun() {
				return Boolean.valueOf(SynchronizedOkDialog.this.getSynchronizedObject().isWarning());
			}
		}).booleanValue();
	}
	
}
