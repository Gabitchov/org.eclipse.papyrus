/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.customization.properties.storage;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

import org.eclipse.emf.cdo.common.lob.CDOClob;


/**
 * An input stream for reading {@link CDOClob}s.
 */
public class ClobInputStream extends InputStream {

	private static final int BUFFER_SIZE_IN_CHARS = 2048;

	private static final int MASK = 0xFF;

	private static final int EOF = -1;

	private final Charset charset;

	private Reader reader;

	private CharBuffer chars = CharBuffer.allocate(BUFFER_SIZE_IN_CHARS);

	private ByteBuffer buffer;

	public ClobInputStream(CDOClob clob, String encoding) throws IOException {
		this.reader = clob.getContents();
		this.charset = Charset.forName((encoding == null) ? "UTF-8" : encoding); //$NON-NLS-1$
	}

	@Override
	public void close() throws IOException {
		if(reader != null) {
			reader.close();
			reader = null;
			buffer = null;
			chars = null;
		}
	}

	@Override
	public int read() throws IOException {
		checkClosed();
		checkBuffer();

		if(buffer != null) {
			return buffer.get() & MASK;
		}

		return EOF;
	}

	private void checkBuffer() throws IOException {
		if((buffer == null) || !buffer.hasRemaining()) {
			buffer = null;
			createBuffer();
		}
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		checkClosed();

		if(len == 0) {
			return 0;
		}

		checkBuffer();

		if(buffer == null) {
			return EOF;
		}

		int count = 0;
		do {
			checkBuffer();

			if(buffer == null) {
				// no more to read
				break;
			}

			int toRead = Math.min(buffer.remaining(), len - count);
			buffer.get(b, off + count, toRead);
			count = count + toRead;
		} while(count < len);

		return count;
	}

	@Override
	public int available() throws IOException {
		checkClosed();
		checkBuffer();

		if(buffer != null) {
			return buffer.remaining();
		}

		return 0;
	}

	protected final void checkClosed() throws IOException {
		if(reader == null) {
			throw new IOException("CLOB reader is closed"); //$NON-NLS-1$
		}
	}

	private void createBuffer() throws IOException {
		checkClosed();

		chars.rewind();
		int count = reader.read(chars);
		if(count > 0) {
			chars.flip();
			buffer = charset.encode(chars);
		}
	}
}
