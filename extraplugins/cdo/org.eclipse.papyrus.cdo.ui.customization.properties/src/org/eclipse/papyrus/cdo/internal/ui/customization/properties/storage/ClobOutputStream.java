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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;

import org.eclipse.emf.cdo.common.lob.CDOClob;
import org.eclipse.emf.cdo.eresource.CDOTextResource;


/**
 * An output stream for writing the contents of a {@link CDOClob}.
 */
public class ClobOutputStream extends ByteArrayOutputStream {

	private final String encoding;

	private CDOTextResource resource;

	public ClobOutputStream(CDOTextResource resource) {
		super();

		this.resource = resource;
		this.encoding = (resource.getEncoding() == null) ? "UTF-8" : resource.getEncoding(); //$NON-NLS-1$
	}

	@Override
	public void close() throws IOException {
		super.close();

		if(resource != null) {
			resource.setContents(createClob());
			resource = null;
		}
	}

	protected CDOClob createClob() throws IOException {
		String text = new String(toByteArray(), encoding);
		return new CDOClob(new StringReader(text));
	}
}
