/*******************************************************************************
 * Copyright (c) 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software) - Bug 370806 - [table] rewrite the "allowed contents" query selection dialog for v0.2
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.efacet.ui.internal.exported.dialog;

import java.util.List;

import org.eclipse.emf.ecore.ETypedElement;

/**
 * Called when a {@link IETypedElementSelectionDialog} is closed, either by OK or Cancel.
 * <p>
 * This interface is intended to be implemented by clients.
 * 
 * @since 0.2.0
 */
public interface IETypedElementSelectionDialogCallback {
	/** The user canceled the dialog */
	void canceled();

	/** The user committed their selection in the dialog */
	void committed(List<ETypedElement> selection);
}
