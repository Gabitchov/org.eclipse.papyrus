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
 *      Grégoire Dupé (Mia-Software) - Bug 406570 - Handlers to Save and SaveAs EMF resources
 */
package org.eclipse.emf.facet.util.ui.internal.exported.dialog;


/**
 * A callback used to return a dialog's result asynchronously.
 * 
 * @since 0.3
 * @noextend This interface is not intended to be extended by clients.
 */
public interface IWithResultDialogCallback<T> {

	/**
	 * The user commit his action.
	 */
	void commited(T result);

	/**
	 * The user cancel his action.
	 */
	void canceled(T result);
}
