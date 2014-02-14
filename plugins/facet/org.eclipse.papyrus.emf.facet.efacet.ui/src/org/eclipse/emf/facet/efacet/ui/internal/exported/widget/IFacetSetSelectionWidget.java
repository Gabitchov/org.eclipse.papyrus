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
package org.eclipse.emf.facet.efacet.ui.internal.exported.widget;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.swt.widgets.Control;

/**
 * A widget to select one or more {@link FacetSet}s from a tree
 * 
 * @since 0.2.0
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IFacetSetSelectionWidget {

	/**
	 * This method can be called at any time to change the {@link FacetSet}s which can be selected by the user.
	 * 
	 * @param available
	 *            the {@link FacetSet}s that can be selected in this widget
	 */
	void setAvailableFacetSets(Collection<? extends FacetSet> available);

	/** @return the list of selected {@link FacetSet}s */
	List<FacetSet> getSelectedFacetSets();

	/** Select the given {@link FacetSet}s in this widget. */
	void setSelectedFacetSets(Collection<? extends FacetSet> newSelection);

	/**
	 * @return the validation status : the selection is not valid if {@link IStatus#getSeverity()} >=
	 *         {@link IStatus#ERROR}
	 */
	IStatus getValidationStatus();

	/** @return the SWT control */
	Control getControl();
}
