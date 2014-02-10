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
package org.eclipse.emf.facet.util.ui.internal.dialog;

import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialogCallback;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IOkDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IOkDialogFactory;
import org.eclipse.emf.facet.util.ui.internal.sync.generated.SynchronizedOkDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class OkDialogFactory implements IOkDialogFactory {

	private final IDialogCallback<Void> noDialogCallback = new IDialogCallback<Void>() {
		public void committed(final Void paramT) {
			// Nothing to do
		}
	};

	public IOkDialog openDialog(final Shell parentShell, final int kind,
			final String title, final String message,
			final IDialogCallback<Void> iDialogCallback) {
		final OkDialog okDialog = new OkDialog(parentShell, kind, title,
				message, iDialogCallback);

		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				okDialog.open();
			}
		});

		return new SynchronizedOkDialog(okDialog, Display.getDefault());
	}

	public IOkDialog openDialog(final Shell parentShell, final int kind,
			final String title, final String message) {
		return openDialog(parentShell, kind, title, message,
				this.noDialogCallback);
	}

	public IOkDialog openInformationDialog(final Shell parentShell,
			final String title, final String message,
			final IDialogCallback<Void> iDialogCallback) {
		return openDialog(parentShell, SWT.ICON_INFORMATION, title, message,
				iDialogCallback);
	}

	public IOkDialog openInformationDialog(final Shell parentShell,
			final String title, final String message) {
		return openInformationDialog(parentShell, title, message,
				this.noDialogCallback);
	}

	public IOkDialog openWarningDialog(final Shell parentShell,
			final String title, final String message,
			final IDialogCallback<Void> iDialogCallback) {
		return openDialog(parentShell, SWT.ICON_WARNING, title, message,
				iDialogCallback);
	}

	public IOkDialog openWarningDialog(final Shell parentShell,
			final String title, final String message) {
		return openWarningDialog(parentShell, title, message,
				this.noDialogCallback);
	}

	public IOkDialog openErrorDialog(final Shell parentShell,
			final String title, final String message,
			final IDialogCallback<Void> iDialogCallback) {
		return openDialog(parentShell, SWT.ICON_ERROR, title, message,
				iDialogCallback);
	}

	public IOkDialog openErrorDialog(final Shell parentShell,
			final String title, final String message) {
		return openErrorDialog(parentShell, title, message,
				this.noDialogCallback);
	}

	public IOkDialog openErrorDialog(final Shell parentShell,
			final Exception exception, final String message) {
		final StringBuffer strBuffer = new StringBuffer();
		strBuffer.append(message);
		strBuffer.append("\n\n"); //$NON-NLS-1$
		strBuffer.append(exception.getMessage());
		strBuffer.append("\n\n"); //$NON-NLS-1$
		for (StackTraceElement stkElt : exception.getStackTrace()) {
			strBuffer.append(stkElt.toString());
			strBuffer.append('\n');
		}
		return openErrorDialog(parentShell, exception.getClass().getName(),
				strBuffer.toString(), this.noDialogCallback);
	}

}
