/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.parsers.util;

import org.eclipse.uml2.uml.TemplateableElement;

/**
 * <code>AssertionFailedException</code> is a runtime exception thrown by some of the methods in <code>Assert</code>.
 * 
 * @see Assert
 */
public class UnboundTemplateRecognitionException extends RuntimeException {

	/**
	 * serial ID
	 * 
	 * @generated
	 */
	private static final long serialVersionUID = -3962411131136049484L;

	private org.eclipse.uml2.uml.TemplateableElement template;

	/**
	 * Constructs a new exception with the given message.
	 * 
	 * @param detail
	 *        the message
	 */
	public UnboundTemplateRecognitionException(String message, TemplateableElement template) {
		super(message);
		this.template = template;
	}

	public TemplateableElement getTemplate() {
		return template;
	}
}
