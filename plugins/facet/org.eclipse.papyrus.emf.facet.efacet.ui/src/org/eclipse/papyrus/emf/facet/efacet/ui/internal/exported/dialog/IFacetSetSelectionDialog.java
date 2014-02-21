/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software) - Bug 372865 - FacetSet selection dialog
 *******************************************************************************/
package org.eclipse.emf.facet.efacet.ui.internal.exported.dialog;

import java.util.List;

import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;

/**
 * A dialog to let the user select facet sets to load.
 * 
 * @param <T>
 *            the type of a pre-commit dialog
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 0.2.0
 */
public interface IFacetSetSelectionDialog<T> {

	/** Set the selection to the given list of {@link FacetSet}s */
	void setSelectedFacetSets(List<? extends FacetSet> newSelection);

	/**
	 * Emulate a press on the OK button
	 * 
	 * @return a pre-commit dialog, or <code>null</code> if no pre-commit dialog was opened
	 */
	T pressOk();

	/** Emulate a press on the Cancel button */
	void pressCancel();

	/** Check all {@link FacetSet}s */
	void selectAll();

	/** Uncheck all {@link FacetSet}s */
	void deselectAll();
}
