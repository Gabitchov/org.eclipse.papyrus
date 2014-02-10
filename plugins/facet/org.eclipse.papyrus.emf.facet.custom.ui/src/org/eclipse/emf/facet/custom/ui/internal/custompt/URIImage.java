/**
 *  Copyright (c) 2013 Soft-Maint.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 * 		David Couvrand (Soft-Maint) - Bug 402725 - Need a query to get an image from an URI
 *  	Nicolas Rault (Soft-Maint) - Bug 402725 - Need a query to get an image from an URI
 */
package org.eclipse.emf.facet.custom.ui.internal.custompt;

import java.io.InputStream;

import org.eclipse.emf.facet.custom.metamodel.custompt.IImage;

public class URIImage implements IImage {
	
	private static final long serialVersionUID = 6801140731857137834L;
	private String uri;
	
	public URIImage(final String uri) {
		this.uri = uri;
	}

	public InputStream getInputStream() {
		return null;
	}

	public String getUri() {
		return this.uri;
	}

	public void setUri(final String uri) {
		this.uri = uri;
	}

}
