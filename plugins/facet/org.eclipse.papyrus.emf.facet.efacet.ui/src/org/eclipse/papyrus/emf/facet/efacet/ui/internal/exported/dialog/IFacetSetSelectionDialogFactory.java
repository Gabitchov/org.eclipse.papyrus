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
package org.eclipse.papyrus.emf.facet.efacet.ui.internal.exported.dialog;

import java.util.Collection;
import java.util.List;

import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.dialogs.FacetSetSelectionDialogFactory;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialogCallback;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialogCallbackWithPreCommit;
import org.eclipse.swt.widgets.Shell;

/**
 * A factory to create {@link IFacetSetSelectionDialog}s
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 0.2.0
 */
public interface IFacetSetSelectionDialogFactory {

	/** This is the default instance of this interface. */
	IFacetSetSelectionDialogFactory DEFAULT = new FacetSetSelectionDialogFactory();

	/**
	 * Open a dialog to let the user select facet sets.
	 * 
	 * @param available
	 *            the {@link FacetSet}s the user will be able to select in the dialog
	 * @param selectionMaxSize
	 *            the maximum number of {@link FacetSet}s that the user can select
	 * @param allowEmpty
	 *            whether to allow the user to select no FacetSet (i.e : select <code>null</code>)
	 * @param callback
	 *            called when the dialog closes
	 * @param parentShell
	 *            the parent shell
	 * @return an instance of the dialog being opened
	 */
	IFacetSetSelectionDialog<?> openFacetSetSelectionDialog(Collection<FacetSet> available,
			int selectionMaxSize, boolean allowEmpty, IDialogCallback<List<FacetSet>> callback,
			Shell parentShell);
	
	/**
	 * Open a dialog to let the user select facet sets. The callback will be called before the dialog closes, to let you
	 * open a "pre-commit" dialog, to ask the user for confirmation for example.
	 * 
	 * @param available
	 *            the {@link FacetSet}s the user will be able to select in the dialog
	 * @param selectionMaxSize
	 *            the maximum number of {@link FacetSet}s that the user can select
	 * @param allowEmpty
	 *            whether to allow the user to select no FacetSet (i.e : select <code>null</code>)
	 * @param callback
	 *            called before the dialog is committed, and again when the dialog is committed
	 * @param parentShell
	 *            the parent shell
	 * @return an instance of the dialog being opened
	 */
	<T> IFacetSetSelectionDialog<T> openFacetSetSelectionDialog(Collection<FacetSet> available,
			int selectionMaxSize, boolean allowEmpty, IDialogCallbackWithPreCommit<List<FacetSet>, Boolean, T> callback,
			Shell parentShell);
}
