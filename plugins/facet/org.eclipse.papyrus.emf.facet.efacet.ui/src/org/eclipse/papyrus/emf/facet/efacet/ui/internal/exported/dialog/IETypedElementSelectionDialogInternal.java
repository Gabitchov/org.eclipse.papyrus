/*******************************************************************************
 * Copyright (c) 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software) - Bug 370806 - [table] rewrite the "allowed contents" query selection dialog for v0.2
 *     Gregoire Dupe (Mia-Software) - Bug 375087 - [Table] ITableWidget.addColumn(List<ETypedElement>, List<FacetSet>)
 *******************************************************************************/
package org.eclipse.emf.facet.efacet.ui.internal.exported.dialog;

import java.util.List;

import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.jface.window.Window;

/**
 * Internal interface for a dialog to let the user select ETypedElements.
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 0.2.0
 */
public interface IETypedElementSelectionDialogInternal<D> extends
		IETypedElementSelectionDialog<D> {

	/**
	 * @return whether the "OK" button is currently enabled. It can be disabled if a validator is set, and the current
	 *         selection is not valid.
	 */
	boolean isOkButtonEnabled();

	/**
	 * @return the selected ETypedElements.
	 * @throws UnsupportedOperationException
	 *             if the dialog was cancelled (check {@link IETypedElementSelectionDialogInternal#getReturnCode()
	 *             getReturnCode} before calling this method
	 */
	List<ETypedElement> getSelectedETypedElements();

	/**
	 * @return the first selected ETypedElements or <code>null</code> if none.
	 * @throws UnsupportedOperationException
	 *             if the dialog was cancelled (check {@link IETypedElementSelectionDialogInternal#getReturnCode()
	 *             getReturnCode} before calling this method
	 */
	ETypedElement getFirstSelectedETypedElement();

	/** @return {@link Window#OK} or {@link Window#CANCEL}. */
	int getReturnCode();
}
