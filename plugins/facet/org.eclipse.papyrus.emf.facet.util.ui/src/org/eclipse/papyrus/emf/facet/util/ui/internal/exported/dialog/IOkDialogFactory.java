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
package org.eclipse.emf.facet.util.ui.internal.exported.dialog;

import org.eclipse.emf.facet.util.ui.internal.dialog.OkDialogFactory;
import org.eclipse.swt.widgets.Shell;

/**
 * 
 * @author tcicognani
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 0.4
 */
public interface IOkDialogFactory {
	IOkDialogFactory DEFAULT = new OkDialogFactory();

	IOkDialog openDialog(Shell parentShell, int kind, String title,
			String message, IDialogCallback<Void> iDialogCallback);

	IOkDialog openDialog(Shell parentShell, int kind, String title,
			String message);

	IOkDialog openInformationDialog(Shell parentShell, String title,
			String message, IDialogCallback<Void> iDialogCallback);

	IOkDialog openInformationDialog(Shell parentShell, String title,
			String message);

	IOkDialog openWarningDialog(Shell parentShell, String title,
			String message, IDialogCallback<Void> iDialogCallback);

	IOkDialog openWarningDialog(Shell parentShell, String title, String message);

	IOkDialog openErrorDialog(Shell parentShell, String title, String message,
			IDialogCallback<Void> iDialogCallback);

	IOkDialog openErrorDialog(Shell parentShell, String title, String message);

	IOkDialog openErrorDialog(Shell parentShell, Exception exception,
			String message);
}
