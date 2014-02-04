/**
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.nattable.parsers;

import java.io.Reader;

/**
 * Represents a lexer for a CSV document
 * 
 * Lexing rules are:
 * LineEnding -> '\n' | '\r' | '\r\n'
 * Separator -> what is given in parameter
 * TextMarker -> what is given in parameter
 * Whitespace -> (Unicode IsWhitespace character class) - (Separator | TextMarker | '\n' | '\r')
 * Cell -> (. - Whitespace)*
 * Cell -> TextMarker ( (.-TextMarker) | (TextMarker TextMarker)* ) TextMarker
 * 
 * In these rules . represents any character and - represents the language difference operator.
 * The last rule means that inside a quoted cell value the content can be anything except the quote character, in which case it must be doubled.
 * 
 * @author Laurent Wouters
 */
public class CSVLexer {
	/**
	 * Represents an error in this lexer
	 */
	public static final int TOKEN_ERROR = -1;
	/**
	 * Token type of cells' value in a CSV
	 */
	public static final int TOKEN_VALUE = 0;
	/**
	 * Token type of cells' separator
	 */
	public static final int TOKEN_SEPARATOR = 1;
	/**
	 * Token type of new line markers
	 */
	public static final int TOKEN_NEW_ROW = 2;
	/**
	 * Token type for the end of input marker
	 */
	public static final int TOKEN_EOF = 3;

	/**
	 * Size of the buffer used to build the tokens
	 */
	private static final int BUFFER_SIZE = 1024;

	private RewindableTextStream input; // the input stream
	private char separator; // The cell separator character
	private char textMarker; // The raw text beginning and end character
	private char[] builder; // The buffer used to build the tokens
	private int lastTokenType; // The type of the last matched token
	private String lastTokenValue; // The value of the last matched token

	/**
	 * Initializes this lexer
	 * 
	 * @param input
	 *            The input text reader
	 * @param valueSeparator
	 *            The character that separates values in rows
	 * @param textMarker
	 *            The character that marks the beginning and end of raw text
	 */
	public CSVLexer(Reader input, char valueSeparator, char textMarker) {
		this.input = new RewindableTextStream(input);
		this.separator = valueSeparator;
		this.textMarker = textMarker;
		this.builder = new char[BUFFER_SIZE];
		this.lastTokenType = TOKEN_ERROR;
		this.lastTokenValue = null;
	}

	/**
	 * Gets the type of the last matched token
	 * 
	 * @return The type of the last matched token
	 */
	public int getTokenType() {
		return lastTokenType;
	}

	/**
	 * Gets the value of the last matched token
	 * 
	 * @return The value of the last matched token
	 */
	public String getTokenValue() {
		return lastTokenValue;
	}

	/**
	 * Gets the next token in the input
	 * 
	 * @return The next token
	 */
	public String next() {
		// ignore all whitespaces
		char c = input.read();
		if (input.isAtEnd())
			return getTokenEOF();
		while (isWhitespace(c)) {
			c = input.read();
			if (input.isAtEnd())
				return getTokenEOF();
		}

		// Here c is not whitespace and we are not at the end
		if (c == separator)
			return getTokenSeparator();
		if (c == textMarker)
			return onTextMarkerChar();
		if (c == '\r' || c == '\n')
			return onLineEndingChar(c);

		// Here we are on normal data
		int length = 1;
		builder[0] = c;
		while (true) {
			c = input.read();
			if (input.isAtEnd())
				break;
			if (c == separator || c == '\r' || c == '\n') {
				input.rewind(1);
				break;
			}
			builder[length] = c;
			length++;
		}

		// we matched the data
		// Now, trim the trailing white spaces
		while (length > 0 && isWhitespace(builder[length - 1])) {
			length--;
		}

		return getTokenValue(length);
	}

	/**
	 * Determines whether the given character is a white space that can be skipped
	 * 
	 * @param c
	 *            The character
	 * @return <code>true</code> if the character can be skipped
	 */
	private boolean isWhitespace(char c) {
		if (c == separator || c == textMarker || c == '\n' || c == '\r')
			return false;
		return Character.isWhitespace(c);
	}

	/**
	 * Lexes the line ending token beginning with the given character
	 * 
	 * @param c
	 *            The beginning character
	 * @return The matched token
	 */
	private String onLineEndingChar(char c) {
		if (c == '\n')
			return getTokenNewRow();
		// This was a '\r' character
		// Check for windows line ending style
		char n = input.read();
		if (input.isAtEnd())
			return getTokenNewRow();
		if (n != '\n')
			input.rewind(1);
		return getTokenNewRow();
	}

	/**
	 * Lexes the raw text between marks
	 * 
	 * @return The matched token
	 */
	private String onTextMarkerChar() {
		int length = 0;
		while (true) {
			char c = input.read();
			if (input.isAtEnd())
				return getTokenError();
			if (c != textMarker) {
				builder[length] = c;
				length++;
			} else {
				// get the following char
				c = input.read();
				if (c == textMarker) {
					// This is a double marker
					builder[length] = c;
					length++;
				} else {
					// This was the end of the quoted text
					if (!input.isAtEnd())
						input.rewind(1);
					return getTokenValue(length);
				}
			}
		}
	}

	/**
	 * Gets an error token
	 * 
	 * @return An error token
	 */
	private String getTokenError() {
		lastTokenType = TOKEN_ERROR;
		lastTokenValue = null;
		return null;
	}

	/**
	 * Gets an end of input marker token
	 * 
	 * @return An end of input marker token
	 */
	private String getTokenEOF() {
		lastTokenType = TOKEN_EOF;
		lastTokenValue = null;
		return null;
	}

	/**
	 * Gets a cell separator token
	 * 
	 * @return A cell separator token
	 */
	private String getTokenSeparator() {
		lastTokenType = TOKEN_SEPARATOR;
		lastTokenValue = null;
		return null;
	}

	/**
	 * Gets a new row token
	 * 
	 * @return A new row token
	 */
	private String getTokenNewRow() {
		lastTokenType = TOKEN_NEW_ROW;
		lastTokenValue = null;
		return null;
	}

	/**
	 * Gets a token representing a cell's value
	 * 
	 * @param length
	 *            Length of the value
	 * @return A token
	 */
	private String getTokenValue(int length) {
		lastTokenType = TOKEN_VALUE;
		lastTokenValue = new String(builder, 0, length);
		return lastTokenValue;
	}

	/**
	 * 
	 * @return
	 *         the number of read characters
	 */
	public long getReadCharacters() {
		return this.input.getReadCharacters();
	}
}
