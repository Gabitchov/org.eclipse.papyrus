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
package org.eclipse.papyrus.emf.facet.efacet.ui.internal.widget;

import org.eclipse.papyrus.emf.facet.efacet.ui.internal.exported.widget.IFacetSetSelectionWidget;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.exported.widget.IFacetSetSelectionWidgetFactory;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class FacetSetSelectionWidgetFactory implements IFacetSetSelectionWidgetFactory {

	public IFacetSetSelectionWidget createFacetSetSelectionWidget(final int selectionMaxSize, final boolean allowEmpty,
			final Composite parentComposite, final Runnable onChange) {
		final FacetSetSelectionControl[] control = new FacetSetSelectionControl[1];
		// must be synchronous, otherwise the shell is not created before SynchronizedFacetSetSelectionWidget, and
		// SynchronizedComposite throws a NPE
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				control[0] = new FacetSetSelectionControl(parentComposite, selectionMaxSize, allowEmpty, onChange);
				control[0].createContents();
			}
		});
		return new SynchronizedFacetSetSelectionWidget(control[0]);
	}
}
