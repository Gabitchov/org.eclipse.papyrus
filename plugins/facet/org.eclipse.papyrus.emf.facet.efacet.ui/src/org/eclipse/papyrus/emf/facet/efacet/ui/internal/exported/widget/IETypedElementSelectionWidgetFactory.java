/*******************************************************************************
 * Copyright (c) 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Gregoire Dupe (Mia-Software) - Bug 370442 - rewrite the Facet loading dialog for v0.2
 *     Nicolas Bros (Mia-Software) - Bug 370806 - [table] rewrite the "allowed contents" query selection dialog for v0.2
 *     Vincent Lorenzo (CEA-LIST) -  Bug 372644 - Create Customizable tooltips for the TreeViewer using a CustomizableLabelProvider
 *     Gregoire Dupe (Mia-Software) - Bug 372626 - Aggregates
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.efacet.ui.internal.exported.widget;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.widget.ETypedElementSelectionWidgetFactory;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.swt.widgets.Composite;

/**
 * Factory for {@link IETypedElementSelectionWidget}
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 0.2.0
 */
public interface IETypedElementSelectionWidgetFactory {
	/** This is the default instance of this interface. */
	IETypedElementSelectionWidgetFactory DEFAULT = new ETypedElementSelectionWidgetFactory();

	/**
	 * Open a dialog to let the user select ETypedElements
	 * 
	 * @param selectionMaxSize
	 *            the maximum number of typed elements that the user can select.
	 * @param allowEmpty
	 *            whether to allow the user to select no ETypedElement (i.e :
	 *            select <code>null</code>)
	 * @param parentComposite
	 *            the parent composite
	 * @param customManager
	 *            the customization manager used by the
	 *            ICustomizableLabelProvider
	 * @since 0.2
	 */
	IETypedElementSelectionWidget createETypedElementSelectionWidget(
			int selectionMaxSize,
			boolean allowEmpty,
			Composite parentComposite,
			ICustomizationManager customManager,
			Collection<? extends EObject> knownEPackage);
}
