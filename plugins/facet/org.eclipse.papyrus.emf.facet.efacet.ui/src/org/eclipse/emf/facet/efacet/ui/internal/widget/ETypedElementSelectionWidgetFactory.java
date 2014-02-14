/*******************************************************************************
 * Copyright (c) 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software) - Bug 370806 - [table] rewrite the "allowed contents" query selection dialog for v0.2
 *     Vincent Lorenzo (CEA-LIST) -  Bug 372644 - Create Customizable tooltips for the TreeViewer using a CustomizableLabelProvider
 *     Gregoire Dupe (Mia-Software) - Bug 372626 - Aggregates
 *******************************************************************************/
package org.eclipse.emf.facet.efacet.ui.internal.widget;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.emf.facet.efacet.ui.internal.exported.widget.IETypedElementSelectionWidget;
import org.eclipse.emf.facet.efacet.ui.internal.exported.widget.IETypedElementSelectionWidgetFactory;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class ETypedElementSelectionWidgetFactory implements IETypedElementSelectionWidgetFactory {

	public IETypedElementSelectionWidget createETypedElementSelectionWidget(
			final int selectionMaxSize, final boolean allowEmpty,
			final Composite parentComposite,
			final ICustomizationManager customManager,
			final Collection<? extends EObject> knownEPackage) {
		final ETypedElementSelectionControlManager[] control = new ETypedElementSelectionControlManager[1];
		// must be synchronous, otherwise the shell is not created before SynchronizedETypedElementSelectionWidget, and SynchronizedComposite throws a NPE
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				control[0] = new ETypedElementSelectionControlManager(parentComposite,
						selectionMaxSize, allowEmpty,
						customManager, knownEPackage);
				control[0].createContents();
			}
		});
		return new SynchronizedETypedElementSelectionWidget(control[0]);
	}
}
