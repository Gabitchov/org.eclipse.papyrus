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
 *   CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.tests.bug;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;


public class FileUtil {

	/**
	 * @param in
	 *        the input stream to read from.
	 * @return the contents of the inputstream.
	 */
	public static String read(InputStream in) {
		return read(new InputStreamReader(in, Charset.forName("UTF-8")));
	}

	/**
	 * @param url
	 *        the URL to read from.
	 * @return the contents of the url.
	 */
	public static String read(URL url) {
		try {
			return read(url.openStream());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @param in
	 *        the reader to read from.
	 * @return the contents of the reader.
	 */
	public static String read(Reader in) {
		StringBuffer buffer = new StringBuffer();
		try {
			while(in.ready()) {
				buffer.append((char)in.read());
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			close(in);
		}
		return buffer.toString();
	}


	private static void close(Closeable c) {
		if(c != null) {
			try {
				c.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
