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
package org.eclipse.papyrus.views.properties.util;

import static org.eclipse.emf.ecore.resource.ContentHandler.CHARSET_PROPERTY;
import static org.eclipse.emf.ecore.resource.ContentHandler.CONTENT_TYPE_PROPERTY;
import static org.eclipse.emf.ecore.resource.ContentHandler.OPTION_REQUESTED_PROPERTIES;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.papyrus.views.properties.Activator;


/**
 * An URL stream handler to use to encapsulate an EMF {@link URI} in a Java {@link URL}.
 */
public class EMFURLStreamHandler extends URLStreamHandler {

	private final URIConverter uriConverter;

	public EMFURLStreamHandler(URIConverter uriConverter) {
		super();

		this.uriConverter = uriConverter;
	}

	@Override
	protected URLConnection openConnection(URL u) throws IOException {
		return new EMFURLConnection(u, uriConverter);
	}

	//
	// Nested types
	//

	private static class EMFURLConnection extends URLConnection {

		private final URIConverter uriConverter;

		private final URI uri;

		private Map<String, ?> contentDescription;

		private boolean connected;

		private InputStream input;

		protected EMFURLConnection(URL url, URIConverter uriConverter) {
			super(url);

			this.uriConverter = uriConverter;

			this.uri = URI.createURI(url.toExternalForm(), true);
		}

		@Override
		public void connect() throws IOException {
			if(!connected) {
				try {
					input = uriConverter.getURIHandler(uri).createInputStream(uri, createInputStreamOptions());
					connected = true;
				} catch (Exception e) {
					throw new IOException("Failed to connect.", e);
				}
			}
		}

		@Override
		public String getContentEncoding() {
			return (String)getContentDescription().get(CHARSET_PROPERTY);
		}

		@Override
		public String getContentType() {
			return (String)getContentDescription().get(CONTENT_TYPE_PROPERTY);
		}

		@Override
		public int getContentLength() {
			return -1;
		}

		@Override
		public boolean getDoInput() {
			return true;
		}

		@Override
		public boolean getDoOutput() {
			return false;
		}

		@Override
		public InputStream getInputStream() throws IOException {
			if(!connected) {
				connect();
			}

			return input;
		}

		private Map<String, ?> getContentDescription() {
			if(contentDescription == null) {
				try {
					contentDescription = uriConverter.getURIHandler(uri).contentDescription(uri, getContentDescriptionOptions());
				} catch (IOException e) {
					Activator.log.error(e);
					contentDescription = Collections.emptyMap();
				}
			}

			return contentDescription;
		}

		private Map<Object, Object> createInputStreamOptions() {
			Map<Object, Object> result = new java.util.HashMap<Object, Object>();
			result.put(URIConverter.OPTION_RESPONSE, new java.util.HashMap<Object, Object>());
			return result;
		}

		private Map<?, ?> getContentDescriptionOptions() {
			Set<String> requestedProperties = new java.util.HashSet<String>();
			requestedProperties.add(CONTENT_TYPE_PROPERTY);
			requestedProperties.add(CHARSET_PROPERTY);

			return Collections.singletonMap(OPTION_REQUESTED_PROPERTIES, requestedProperties);
		}
	}
}
