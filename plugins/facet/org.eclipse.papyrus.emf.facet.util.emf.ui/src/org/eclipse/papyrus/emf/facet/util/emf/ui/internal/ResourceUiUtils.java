/**
 * Copyright (c) 2013 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Gregoire Dupe (Mia-Software) - Bug 406570 - Handlers to Save and SaveAs EMF resources
 */
package org.eclipse.emf.facet.util.emf.ui.internal;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.facet.util.core.Logger;
import org.eclipse.emf.facet.util.emf.ui.internal.dialogs.SaveAsDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialogCallback;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IOkDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IOkDialogFactory;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IWithResultDialogCallback;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;

public final class ResourceUiUtils {

	private ResourceUiUtils() {
		// Must no be used
	}

	public static IOkDialog save(final Resource resource, final Shell shell) {
		IOkDialog dialog = null;
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (MalformedURLException e) {
			ResourceUiUtils.openSaveAsDialog(resource, shell);
		} catch (IOException e) {
			final IDialogCallback<Void> callBack = new IDialogCallback<Void>() {
				public void committed(final Void result2) {
					// Nothing to do.
				}
			};
			dialog = savingFailed(e, shell, callBack);
		}
		return dialog;
	}

	private static IOkDialog savingFailed(final IOException exception,
			final Shell shell, final IDialogCallback<Void> callBack) {
		Logger.logError(exception, Activator.getDefault());
		final String errorMessage = NLS.bind(
				Messages.ResourceUiUtils_TheResourceSavingFailed,
				exception.getMessage());
		return IOkDialogFactory.DEFAULT.openErrorDialog(shell,
				Messages.ResourceUiUtils_SavingFailed, errorMessage, callBack);
	}

	public static SaveAsDialog openSaveAsDialog(final Resource resource,
			final Shell shell) {
		final IWithResultDialogCallback<String> callBack = new IWithResultDialogCallback<String>() {

			public void commited(final String result) {
				ResourceUiUtils.saveAs(resource, result, shell);
			}

			public void canceled(final String result) {
				// Nothing to do
			}
		};
		final SaveAsDialog dialog = new SaveAsDialog(shell, resource.getURI()
				.toString(), callBack);
		dialog.open();
		return dialog;
	}

	protected static IOkDialog saveAs(final Resource resource,
			final String result, final Shell shell) {
		IOkDialog dialog = null;
		try {
			resource.setURI(URI.createURI(result));
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			final IDialogCallback<Void> callBack = new IDialogCallback<Void>() {
				public void committed(final Void result2) {
					ResourceUiUtils.openSaveAsDialog(resource, shell);
				}
			};
			dialog = savingFailed(e, shell, callBack);
		}
		return dialog;
	}

}
