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
 * Represents a parser of CSV document
 * This parser implements the following grammar:
 * Document -> Row (LineEnding Row)* EOF
 * Row -> ( Cell (Separator Cell)* )?
 * 
 * An empty document is matched as having a single row with no cell.
 * A line ending just before the EOF also represents an empty row.
 * 
 * @author Laurent Wouters
 */
public class CSVParser {
	private CSVLexer lexer; // the input lexer
	private RowIterator output; // the ouput iterators

	/**
	 * Initializes this parser
	 * 
	 * @param input
	 *            The input to parse
	 * @param valueSeparator
	 *            The character that separates values in rows
	 * @param textMarker
	 *            The character that marks the beginning and end of raw text
	 */
	public CSVParser(Reader input, char valueSeparator, char textMarker) {
		this.lexer = new CSVLexer(input, valueSeparator, textMarker);
		this.output = new Document();
	}

	/**
	 * Parses the input and gets an iterator over the rows
	 * 
	 * @return An iterator over the document's rows
	 */
	public RowIterator parse() {
		return output;
	}

	/**
	 * 
	 * @return
	 *         the number of read characters
	 */
	public long getReadCharacters() {
		return this.lexer.getReadCharacters();
	}

	/**
	 * Represents a row in a CSV document as an iterator over the value of its cells
	 * This class uses a small state machine to matches the tokens against the following regular expression:
	 * Row -> (Cell (Separator Cell)* )? End
	 * Cell is a cell's value token in the lexer
	 * Separator is a separator token in the lexer
	 * End can be either the Error, EOF, or Line ending tokens
	 * 
	 * @author Laurent Wouters
	 */
	private class Row extends CellIterator {
		private static final int STATE_INIT = 0;
		private static final int STATE_CELL = 1;
		private static final int STATE_SEPARATOR = 2;
		private static final int STATE_END = 3;

		private String next; // value of the next cell in this row
		private int state; // current state in the state machine

		/**
		 * Initializes this row
		 */
		public Row() {
			state = 0;
			findNext();
		}

		/**
		 * Executes the transitions on the initial state
		 */
		public void onStateInit() {
			next = lexer.next();
			int type = lexer.getTokenType();
			if (type == CSVLexer.TOKEN_VALUE) {
				state = STATE_CELL;
			} else if (type == CSVLexer.TOKEN_SEPARATOR) {
				next = ""; //$NON-NLS-1$
				state = STATE_SEPARATOR;
			} else {
				next = null;
				state = STATE_END;
			}
		}

		/**
		 * Executes the transitions on the OnCell state
		 */
		private void onStateCell() {
			next = lexer.next();
			int type = lexer.getTokenType();
			if (type == CSVLexer.TOKEN_SEPARATOR) {
				onStateSeparator();
			} else {
				next = null;
				state = STATE_END;
			}
		}

		/**
		 * Executes the transitions on the OnSeparator state
		 */
		private void onStateSeparator() {
			next = lexer.next();
			int type = lexer.getTokenType();
			if (type == CSVLexer.TOKEN_VALUE) {
				state = STATE_CELL;
			} else if (type == CSVLexer.TOKEN_SEPARATOR) {
				next = ""; //$NON-NLS-1$
				state = STATE_SEPARATOR;
			} else {
				next = ""; //$NON-NLS-1$
				state = STATE_END;
			}
		}

		/**
		 * Executes the transitions on the final state
		 */
		private void onStateEnd() {
			next = null;
		}

		/**
		 * Executes the state machine
		 */
		private void findNext() {
			switch (state) {
			case STATE_INIT:
				onStateInit();
				break;
			case STATE_CELL:
				onStateCell();
				break;
			case STATE_SEPARATOR:
				onStateSeparator();
				break;
			default:
				onStateEnd();
				break;
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			return (next != null);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#next()
		 */
		@Override
		public String next() {
			String value = next;
			findNext();
			return value;
		}
	}

	/**
	 * Represents a CSV document as an iterator over its rows
	 * 
	 * @author Laurent Wouters
	 * 
	 */
	private class Document extends RowIterator {
		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() {
			return (lexer.getTokenType() != CSVLexer.TOKEN_EOF);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#next()
		 */
		@Override
		public CellIterator next() {
			return new Row();
		}
	}


}
