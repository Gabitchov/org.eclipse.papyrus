/*******************************************************************************
 * Copyright (c) 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software) - Bug 370442 - rewrite the Facet loading dialog for v0.2
 *     Nicolas Bros (Mia-Software) - Bug 370806 - [table] rewrite the "allowed contents" query selection dialog for v0.2
 *     Vincent Lorenzo (CEA-LIST) -  Bug 372644 - Create Customizable tooltips for the TreeViewer using a CustomizableLabelProvider
 *     Gregoire Dupe (Mia-Software) - Bug 375087 - [Table] ITableWidget.addColumn(List<ETypedElement>, List<FacetSet>)
 *     Gregoire Dupe (Mia-Software) - Bug 372626 - Aggregates
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.efacet.ui.internal.dialogs;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.exported.dialog.IETypedElementSelectionDialog;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.exported.dialog.IETypedElementSelectionDialogFactory;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialogCallbackWithPreCommit;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ETypedElementSelectionDialogFactory implements IETypedElementSelectionDialogFactory {

	public <T2, D> IETypedElementSelectionDialog<D> openETypedElementSelectionDialog(
			final Collection<? extends ETypedElement> eTypedElements,
			final int selectionMaxSize,
			final boolean allowEmpty,
			final IDialogCallbackWithPreCommit<List<ETypedElement>, T2, D> callback,
			final Shell parentShell, final ICustomizationManager customManager,
			final Collection<? extends EPackage> knownFacetSets) {
		final ETypedElementSelectionDialog<T2, D> dialog = new ETypedElementSelectionDialog<T2, D>(
				eTypedElements, selectionMaxSize, allowEmpty, callback,
				parentShell, customManager, knownFacetSets);
		// must be synchronous, otherwise the shell is not created before SynchronizedETypedElementSelectionDialog, and SynchronizedComposite throws a NPE
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				dialog.setBlockOnOpen(false);
				dialog.open();
			}
		});
		return new SynchronizedETypedElementSelectionDialog<T2, D>(dialog);
	}
}
