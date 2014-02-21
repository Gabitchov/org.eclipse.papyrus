/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.dialog;

import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IWithResultDialogCallback;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.dialog.AbstractDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.ICommandWidget;

public abstract class AbstractGetCustomizationDialog<T extends Object, W extends ICommandWidget>
		extends AbstractDialog<IWithResultDialogCallback<T>, W> {

	/**
	 * Constructor.
	 * 
	 * @param properties
	 *            properties that parent widget had.
	 */
	public AbstractGetCustomizationDialog(
			final IWithResultDialogCallback<T> callback) {
		super(callback);
	}

}
