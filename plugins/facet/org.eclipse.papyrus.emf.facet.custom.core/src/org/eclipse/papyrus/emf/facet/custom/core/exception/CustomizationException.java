/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 *      Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 */
package org.eclipse.papyrus.emf.facet.custom.core.exception;

/**
 * This exception is thrown when the computation of a customization property value failed.
 * @author Gregoire Dupe
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public final class CustomizationException extends Exception {

	private static final long serialVersionUID = -4070159863668577038L;

	public CustomizationException() {
		super();
	}

	public CustomizationException(final String message) {
		super(message);
	}

	public CustomizationException(final Throwable cause) {
		super(cause);
	}

	public CustomizationException(final String message, final Throwable cause) {
		super(message, cause);
	}

}
