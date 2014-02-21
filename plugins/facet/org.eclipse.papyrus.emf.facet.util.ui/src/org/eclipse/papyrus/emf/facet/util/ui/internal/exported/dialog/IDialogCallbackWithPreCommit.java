/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Gregoire Dupe (Mia-Software) - Initial API
 *    Nicolas Bros (Mia-Software) - Bug 372865 - FacetSet selection dialog
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog;

/**
 * A callback used to return a dialog's result asynchronously. This interface makes it possible to open a second
 * "pre-commit" dialog when the user commits their selection in the first dialog. This second dialog is given the
 * opportunity to open before the first dialog closes. This can be useful to ask the user for confirmation for example.
 * <p>
 * The second dialog should either:
 * <ul>
 * <li>call {@link IDialogCallback#committed(Object) committed} on the callback passed to
 * {@link IDialogCallbackWithPreCommit#openPrecommitDialog(Object, IDialogCallback) openPrecommitDialog} with the
 * definitive result
 * <li>do nothing if the pre-commit dialog was canceled
 * </ul>
 * 
 * @param <T1>
 *            the type of the result for the first dialog
 * @param <T2>
 *            the type of the result for the pre-commit dialog
 * @param <D>
 *            the type of the pre-commit dialog
 */
public interface IDialogCallbackWithPreCommit<T1, T2, D> {
	/**
	 * The user confirmed their choice in the pre-commit dialog.
	 * 
	 * @param result
	 *            the result of the first dialog
	 * @param precommitResult
	 *            the result of the pre-commit dialog
	 */
	void committed(T1 result, T2 precommitResult);

	/**
	 * The user committed their selection in the first dialog. This method is called to let you open a second
	 * "pre-commit" dialog, that can prompt the user for confirmation.
	 * 
	 * @param result
	 *            the result from the first dialog
	 * @param precommitCallback
	 *            you must call {@link IDialogCallback#committed(Object) committed} on this callback if the user
	 *            confirms their choice in the second (pre-commit) dialog, and pass the result of the pre-commit dialog.
	 *            Or do nothing if the user chose to cancel. If you return <code>null</code> from this method, you
	 *            mustn't call {@link IDialogCallback#committed(Object)} or the commit will be done twice
	 * @return the pre-commit dialog (for unit tests), or <code>null</code> if no pre-commit callback is needed
	 */
	D openPrecommitDialog(T1 result, IDialogCallback<T2> precommitCallback);
}
