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
 * A callback used to return a dialog's result asynchronously.
 * 
 * @param <T>
 *            the type of the result
 */
public interface IDialogCallback<T> {
	/**
	 * The user committed their selection in the dialog.
	 * 
	 * @param result
	 *            the result
	 */
	void committed(T result);
}
