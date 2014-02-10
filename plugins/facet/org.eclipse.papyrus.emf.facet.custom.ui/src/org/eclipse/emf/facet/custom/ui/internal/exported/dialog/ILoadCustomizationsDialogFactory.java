/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 */
package org.eclipse.emf.facet.custom.ui.internal.exported.dialog;

import java.util.List;

import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.emf.facet.custom.ui.internal.dialog.LoadCustomizationsDialogFactory;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialogCallbackWithPreCommit;
import org.eclipse.swt.widgets.Shell;

/**
 * Factory for {@link ILoadCustomizationsDialog}.
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 0.2.0
 */
public interface ILoadCustomizationsDialogFactory {
	/** The default implementation */
	ILoadCustomizationsDialogFactory DEFAULT = new LoadCustomizationsDialogFactory();

	/**
	 * @param parent
	 *            the parent shell
	 * @param availableCustoms
	 *            the customizations that the user will be able to select
	 * @param selectedCustoms
	 *            the customizations that will be selected when the dialog opens
	 * @param listener
	 *            called when the dialog closes
	 * @return the dialog
	 * @since 0.2
	 */
	<D> ILoadCustomizationsDialog<D> createLoadCustomizationDialog(final Shell parent,
			final List<Customization> availableCustoms,
			final List<Customization> selectedCustoms,
			IDialogCallbackWithPreCommit<List<Customization>, Boolean, D> callback);

	/**
	 * @param parent
	 *            the parent shell
	 * @param availableCustoms
	 *            the customizations that the user will be able to select
	 * @param selectedCustoms
	 *            the customizations that will be selected when the dialog opens
	 * @param lockedCustoms
	 *            a list of customizations that the user will not be able to unload
	 * @param listener
	 *            called when the dialog closes
	 * @param lockMsg
	 *            a message indicating why certain customizations cannot be unloaded
	 * @return the dialog
	 * @since 0.2
	 */
	<D> ILoadCustomizationsDialog<D> createLoadCustomizationDialog(final Shell parent,
			final List<Customization> availableCustoms,
			final List<Customization> selectedCustoms,
			final List<Customization> lockedCustoms,
			IDialogCallbackWithPreCommit<List<Customization>, Boolean, D> callback,
			String lockMsg);

}
