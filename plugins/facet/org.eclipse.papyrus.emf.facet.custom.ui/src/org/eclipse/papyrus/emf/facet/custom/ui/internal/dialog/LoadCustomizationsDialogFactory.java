/**
 *  Copyright (c) 2012 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 */
package org.eclipse.papyrus.emf.facet.custom.ui.internal.dialog;

import java.util.Collections;
import java.util.List;

import org.eclipse.papyrus.emf.facet.custom.ui.internal.exported.dialog.ILoadCustomizationsDialog;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.exported.dialog.ILoadCustomizationsDialogFactory;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialogCallbackWithPreCommit;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.swt.widgets.Shell;

public class LoadCustomizationsDialogFactory implements ILoadCustomizationsDialogFactory {

	public <D> ILoadCustomizationsDialog<D> createLoadCustomizationDialog(
			final Shell parent,
			final List<Customization> availableCustoms,
			final List<Customization> selectedCustoms,
			final IDialogCallbackWithPreCommit<List<Customization>, Boolean, D> callback) {
		return new SynchronizedLoadCustomizationsDialog(parent,
				availableCustoms, selectedCustoms,
				Collections.<Customization> emptyList(), callback, ""); //$NON-NLS-1$
	}

	public <D> ILoadCustomizationsDialog<D> createLoadCustomizationDialog(
			final Shell parent,
			final List<Customization> availableCustoms,
			final List<Customization> selectedCustoms,
			final List<Customization> lockedCustoms,
			final IDialogCallbackWithPreCommit<List<Customization>, Boolean, D> callback,
			final String lockMsg) {
		return new SynchronizedLoadCustomizationsDialog(parent,
				availableCustoms, selectedCustoms, lockedCustoms, callback,
				lockMsg);
	}
}
