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
package org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog;

import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.dialog.AbstractDialog;

/**
 * @see AbstractDialog
 * @since 0.3
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IDialog<W extends Object> {

	/**
	 * Press the "Ok" button.
	 */
	void commit();

	/**
	 * Press the "Cancel" button.
	 */
	void cancel();

	/**
	 * Open the dialog. This method is used for to open the dialog into the
	 * thread UI. So, this method has no to be called into the constructor.
	 * 
	 * @return the result of the dialog (OK or CANCEL).
	 */
	int open();

	/**
	 * Return if the dialog is valid or not.
	 * 
	 * @return true if all the necessaries properties are set.
	 */
	boolean isDialogValid();

	W getWidget();
}