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
 *     Gregoire Dupe (Mia-Software) - Bug 375087 - [Table] ITableWidget.addColumn(List<ETypedElement>, List<FacetSet>)
 *     Gregoire Dupe (Mia-Software) - Bug 372626 - Aggregates
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.efacet.ui.internal.exported.dialog;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.dialogs.ETypedElementSelectionDialogFactory;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialogCallbackWithPreCommit;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.swt.widgets.Shell;

/**
 * A factory to create {@link IETypedElementSelectionDialog}s
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 0.2.0
 */
public interface IETypedElementSelectionDialogFactory {

	/** This is the default instance of this interface. */
	IETypedElementSelectionDialogFactory DEFAULT = new ETypedElementSelectionDialogFactory();

	/**
	 * Open a dialog to let the user select ETypedElements to load.
	 * 
	 * @param eTypedElements
	 *            the list of ETypedElements that can be selected using this dialog
	 * @param selectionMaxSize
	 *            the maximum number of typed elements that the user can select
	 * @param allowEmpty
	 *            whether to allow the user to select no ETypedElement (i.e : select <code>null</code>)
	 * @param callback
	 *            called when the dialog closes
	 * @param parentShell
	 *            the parent shell
	 * @param customManager
	 *            the customization manager used by the
	 *            ICustomizableLabelProvider. Can be null.
	 */
	<T2, D> IETypedElementSelectionDialog<D> openETypedElementSelectionDialog(
			Collection<? extends ETypedElement> eTypedElements,
			int selectionMaxSize, boolean allowEmpty,
			IDialogCallbackWithPreCommit<List<ETypedElement>, T2, D> callback,
			Shell parentShell,
			ICustomizationManager customManager,
			Collection<? extends EPackage> knownFacetSets);
}
