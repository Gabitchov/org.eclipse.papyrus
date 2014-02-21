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
 */
package org.eclipse.emf.facet.util.emf.ui.internal.exported.util.wizard.page.exception;

/**
 * @since 0.3
 */
public class SelectedEClassifierRuntimeException extends RuntimeException {

	
	private static final long serialVersionUID = -1021467669726982508L;

	public SelectedEClassifierRuntimeException() {
		super(
				"List not totally loaded. Check if the list's job is done before doing the selection."); //$NON-NLS-1$
	}

	public SelectedEClassifierRuntimeException(final String message) {
		super(message);
	}

	public SelectedEClassifierRuntimeException(final String message,
			final Throwable cause) {
		super(message, cause);
	}

	public SelectedEClassifierRuntimeException(final Throwable cause) {
		super(cause);
	}
}
