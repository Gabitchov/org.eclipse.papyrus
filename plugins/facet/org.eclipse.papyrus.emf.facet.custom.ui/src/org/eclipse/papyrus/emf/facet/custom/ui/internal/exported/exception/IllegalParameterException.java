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
 */
package org.eclipse.papyrus.emf.facet.custom.ui.internal.exported.exception;

import java.util.List;

public class IllegalParameterException extends Exception {

	private static final long serialVersionUID = 2470355059500176931L;
	private final List<? extends Object> illegalParameters;

	public IllegalParameterException(
			final List<? extends Object> illegalParameters) {
		super();
		this.illegalParameters = illegalParameters;
	}

	public IllegalParameterException(final String message,
			final List<? extends Object> illegalParameters) {
		super(message);
		this.illegalParameters = illegalParameters;
	}

	public IllegalParameterException(final Throwable cause,
			final List<? extends Object> illegalParameters) {
		super(cause);
		this.illegalParameters = illegalParameters;
	}

	public IllegalParameterException(final String message,
			final Throwable cause,
			final List<? extends Object> illegalParameters) {
		super(message, cause);
		this.illegalParameters = illegalParameters;
	}

	/**
	 * @return the illegalParameters
	 */
	public List<? extends Object> getIllegalParameters() {
		return this.illegalParameters;
	}

}
