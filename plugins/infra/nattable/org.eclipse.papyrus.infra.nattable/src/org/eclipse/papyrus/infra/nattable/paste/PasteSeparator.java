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
 * Enumeration for cell delimiters in CSV files
 * 
 */
public enum PasteSeparator {
	/**
	 * tabulation value
	 */
	TABULATION('\t', Messages.PasteSeparator_Tabulation),

	/**
	 * semicolon value
	 */
	SEMICOLON(';', Messages.PasteSeparator_Semicolon),

	/**
	 * Comma value
	 */
	COMMA(',', Messages.PasteSeparator_Comma),
	/**
	 * space value
	 */
	SPACE(' ', Messages.PasteSeparator_Space),

	/**
	 * other value
	 */
	OTHER(Messages.PasteSeparator_Other);

	/**
	 * the separator itself
	 */
	private final char separator;

	/**
	 * the name of the separator
	 */
	private final String name;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param name
	 */
	private PasteSeparator(final String name) {
		this(Character.MIN_VALUE, name);//MIN_VALUE is a value as other one!
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param separator
	 * @param name
	 */
	private PasteSeparator(char separator, String name) {
		this.separator = separator;
		this.name = name;
	}

	/**
	 * 
	 * @return
	 *         the separator to use
	 */
	public char getSeparator() {
		if(this == OTHER) {
			throw new UnsupportedOperationException();
		}
		return separator;
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
