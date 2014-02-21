/*******************************************************************************
 * Copyright (c) 2012 CEA-LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Vincent Lorenzo (CEA-LIST) -  Bug 372644 - Create Customizable tooltips for the TreeViewer using a CustomizableLabelProvider
 *     Gregoire Dupe (Mia-Software) -  Bug 372644 - Create Customizable tooltips for the TreeViewer using a CustomizableLabelProvider
 *******************************************************************************/
package org.eclipse.emf.facet.efacet.ui.internal.widget;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.jface.viewers.IStructuredSelection;

public interface IETypedElementSelectionControlManager extends
		IETypedElementSelectionWidgetInternal {

	/**
	 * @return the validation status
	 */
	IStatus getValidationStatus();

	/**
	 * Set the available elements
	 * 
	 * @param eTypedElements
	 *            available eTypedElements
	 */
	void setAvailableETypedElements(
			Collection<? extends ETypedElement> eTypedElements);

	/**
	 * 
	 * @param selection
	 *            the selection
	 */
	void setSelection(final IStructuredSelection selection);

	/**
	 * 
	 * @return the selection
	 */
	List<ETypedElement> computeResult();

}
