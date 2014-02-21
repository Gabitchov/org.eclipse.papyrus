/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 372865 - FacetSet selection dialog
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.efacet.ui.internal.exported.dialog;

import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.jface.viewers.TreeViewer;

/**
 * Internal interface for a dialog to let the user select {@link FacetSet}s.
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * 
 * @param <T>
 *            the type of a pre-commit dialog (can be <code>null</code> if there is no pre-commit dialog)
 */
public interface IFacetSetSelectionDialogInternal<T> extends IFacetSetSelectionDialog<T> {

	/**
	 * @return whether the "OK" button is currently enabled. It can be disabled if a validator is set, and the current
	 *         selection is not valid.
	 */
	boolean isOkButtonEnabled();

	/** @return the tree viewer */
	TreeViewer getTreeViewer();
}
