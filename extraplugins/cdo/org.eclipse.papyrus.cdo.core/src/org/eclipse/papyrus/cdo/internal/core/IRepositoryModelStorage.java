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
package org.eclipse.papyrus.cdo.internal.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * This is the IRepositoryModelStorage type. Enjoy.
 */
public interface IRepositoryModelStorage {

	/**
	 * Obtains an input stream on the repository model storage, if any.
	 * 
	 * @return an input stream, or {@code null} if there is no repository model
	 *         currently stored
	 * 
	 * @throws IOException
	 *             on any failure to get an input stream that is not simply that
	 *             the storage doesn't yet exist
	 */
	InputStream createInputStream()
			throws IOException;

	/**
	 * Obtains an output stream on the repository model storage.
	 * 
	 * @return an output stream (may not be {@code null})
	 * 
	 * @throws IOException
	 *             on any failure to get an output stream
	 */
	OutputStream createOutputStream()
			throws IOException;
}
