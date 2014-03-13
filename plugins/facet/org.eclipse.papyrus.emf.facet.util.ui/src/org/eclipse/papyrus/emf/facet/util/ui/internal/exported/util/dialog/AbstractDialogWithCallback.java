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
package org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.dialog;

import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialogWithoutResultCallback;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IWithResultDialogCallback;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.ICommandWidget;

/**
 * Abstract dialog with an {@link IDialogWithoutResultCallback} in parameter.
 * 
 * @since 0.3
 */
public abstract class AbstractDialogWithCallback<T extends Object, W extends ICommandWidget>
		extends AbstractDialog<IWithResultDialogCallback<T>, W> {

	/**
	 * Constructor.
	 * 
	 * @param editingDomain
	 *            the current editing domain
	 * @param properties
	 *            the properties that the widget needs
	 */
	protected AbstractDialogWithCallback(
			final IWithResultDialogCallback<T> callback) {
		super(callback);
	}

	@Override
	protected void okPressed() {
		if (isDialogValid() && (getCallback() != null)) {
			getCallback().commited(getResult());
		}
		super.okPressed();
	}

	protected abstract T getResult();

	@Override
	protected void cancelPressed() {
		if (getCallback() != null) {
			getCallback().canceled(getResult());
		}
		super.cancelPressed();
	}

}
