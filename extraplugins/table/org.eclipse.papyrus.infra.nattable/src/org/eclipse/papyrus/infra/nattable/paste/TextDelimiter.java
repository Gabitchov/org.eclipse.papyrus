/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		 Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.paste;

import org.eclipse.papyrus.infra.nattable.messages.Messages;

/**
 * 
 * Enumeration for text delimiters
 *
 */
public enum TextDelimiter {

	/**
	 * the single quote
	 */
	SINGLE_QUOTE('\'', Messages.TextDelimiter_Quote),
		
	/**
	 * the double quote
	 */
	DOUBLE_QUOTE('"', Messages.TextDelimiter_DoubleQuote);
	
	/**
	 * the delimiter itself
	 */
	private final char delimiter;

	/**
	 * the name of the delimiter
	 */
	private final String name;

	/**
	 * 
	 * Constructor.
	 *
	 * @param delimiter
	 * @param name
	 */
	private TextDelimiter(char delimiter, String name) {
		this.delimiter = delimiter;
		this.name = name;
	}

	/**
	 * 
	 * @return
	 *         the separator to use
	 */
	public char getDelimiter() {
		return delimiter;
	}

	/**
	 * 
	 * @return
	 *         the name of the separator
	 */
	public String getName() {
		return name;
	}
}
