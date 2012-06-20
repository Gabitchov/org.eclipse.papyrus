/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ernest Wozniak (CEA LIST) ernest.wozniak@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - modifications
 *****************************************************************************/
package org.eclipse.papyrus.dsml.validation.model.elements.impl;

/**
 * Exception which is thrown in case specific model element is not stereotype
 * with and expected stereotype.
 * 
 * 
 */
public class WrongStereotypeException extends Exception {

	private static final long serialVersionUID = 1L;

	public WrongStereotypeException() {
		super("Element is not stereotyped with applicable stereotype");
	}

	public WrongStereotypeException(String msg) {
		super(msg);
	}

}
