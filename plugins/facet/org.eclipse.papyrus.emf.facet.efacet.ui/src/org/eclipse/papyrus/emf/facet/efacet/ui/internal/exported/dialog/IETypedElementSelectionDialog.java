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
package org.eclipse.papyrus.emf.facet.efacet.ui.internal.exported.dialog;

import java.util.List;

import org.eclipse.emf.ecore.ETypedElement;

/**
 * A dialog to let the user select ETypedElements.
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 0.2.0
 */
public interface IETypedElementSelectionDialog<D> {

	/** Set the selection to the given list of ETypedElements */
	void setSelectedETypedElements(List<? extends ETypedElement> newSelection);

	/** Emulate a press on the OK button */
	D pressOk();

	/** Emulate a press on the Cancel button */
	void pressCancel();
}
