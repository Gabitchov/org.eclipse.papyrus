/*******************************************************************************
 * Copyright (c) 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Gregoire Dupe (Mia-Software) - Bug 370442 - rewrite the Facet loading dialog for v0.2
 *    Nicolas Bros (Mia-Software) - Bug 370806 - [table] rewrite the "allowed contents" query selection dialog for v0.2
 *******************************************************************************/
package org.eclipse.emf.facet.efacet.ui.internal.exported.widget;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.ETypedElement;

/**
 * A widget to select one or more {@link ETypedElement}s from a list
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 0.2.0
 */
public interface IETypedElementSelectionWidget {

	/**
	 * This method can be called at any time to change the {@link ETypedElement}s which can be selected by the user.
	 * 
	 * @param available
	 *            the {@link ETypedElement}s that can be selected in this widget
	 */
	void setAvailableETypedElements(Collection<? extends ETypedElement> available);

	/** @return the list of selected {@link ETypedElement}s */
	List<ETypedElement> getSelectedETypedElements();

	/** Select the given {@link ETypedElement}s in this widget. */
	void setSelectedETypedElements(Collection<? extends ETypedElement> elementsToSelect);

}
