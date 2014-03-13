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

import java.io.IOException;
import java.io.Reader;

/**
 * Represents a stream of characters that can be rewound
 * 
 * @author Laurent Wouters
 */
public class RewindableTextStream {

	private static final int BUFFER_SIZE = 1024; // Size of the buffer used to read from the input

	private static final int RING_SIZE = 1024; // Size of the ring storing read characters that can be rewound

	private Reader reader; // Encapsulated text reader

	private char[] buffer; // First stage buffer for batch reading of the stream

	private int bufferStart; // Index where the next character shall be read in the buffer

	private int bufferLength; // Current length of the buffer

	private boolean atEnd; // Marker of the end of input

	private char[] ring; // Ring memory of this reader storing the already read characters

	private int ringStart; // Start index of the ring where to read characters

	private int ringNextEntry; // Index for inserting new characters in the ring

	private long counter;

	/**
	 * Initializes this stream
	 * 
	 * @param reader
	 *        The underlying text reader
	 */
	public RewindableTextStream(Reader reader) {
		this.reader = reader;
		this.buffer = new char[BUFFER_SIZE];
		this.bufferStart = 0;
		this.bufferLength = 0;
		this.ring = new char[RING_SIZE];
		this.ringStart = 0;
		this.ringNextEntry = 0;
		this.counter = 0;
	}

	/**
	 * Determines whether the end of the input has been reached
	 * 
	 * @return <code>true</code> if the end of the input has been reached
	 */
	public boolean isAtEnd() {
		return atEnd;
	}

	/**
	 * Goes back into the stream of the given number of characters
	 * 
	 * @param count
	 *        The number of characters to rewind
	 */
	public void rewind(int count) {
		ringStart -= count;
		counter -= count;
		if(ringStart < 0) {
			ringStart += RING_SIZE;
		}
	}

	/**
	 * Reads the next character in the stream
	 * 
	 * @return The next character
	 */
	public char read() {
		if(atEnd) {
			return 0;
		}
		counter++;
		if(ringStart != ringNextEntry) {
			atEnd = false;
			char value = ring[ringStart++];
			if(ringStart == RING_SIZE) {
				ringStart = 0;
			}
			return value;
		}
		return readBuffer();
	}

	/**
	 * Reads the next character from the input
	 * 
	 * @return The next character in the stream
	 */
	private char readBuffer() {
		if(bufferStart == bufferLength) {
			bufferLength = -1;
			try {
				bufferLength = reader.read(buffer, 0, BUFFER_SIZE);
			} catch (IOException e) {
				//nothing to report
			}
			bufferStart = 0;
			if(bufferLength <= 0) {
				atEnd = true;
				return 0;
			}
		}
		atEnd = false;
		char c = buffer[bufferStart++];
		ring[ringNextEntry++] = c;
		if(ringNextEntry == RING_SIZE) {
			ringNextEntry = 0;
		}
		ringStart = ringNextEntry;
		return c;
	}

	/**
	 * 
	 * @return
	 *         the number of read characters
	 */
	public long getReadCharacters() {
		return this.counter;
	}
}
