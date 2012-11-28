/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.common.exceptions;


public class ErrorInPastePreparationException extends Exception {


	/**
	 * the serial version UID
	 */
	private static final long serialVersionUID = -2707065012620342372L;


	public ErrorInPastePreparationException(final String message) {
		super(message);
	}


	public ErrorInPastePreparationException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
