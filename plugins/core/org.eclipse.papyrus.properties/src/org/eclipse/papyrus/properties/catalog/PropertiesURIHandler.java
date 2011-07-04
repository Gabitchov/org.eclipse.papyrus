/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.catalog;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.papyrus.properties.Activator;


public class PropertiesURIHandler implements URIHandler {

	public static final String ENVIRONMENT_SEGMENT = "environment"; //$NON-NLS-1$

	public static final String CONTEXT_SEGMENT = "context"; //$NON-NLS-1$

	public static final String PROPERTIES_SCHEME = "ppe"; //$NON-NLS-1$

	public boolean canHandle(URI uri) {
		return uri != null && PROPERTIES_SCHEME.equals(uri.scheme());
	}

	public InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException {
		URI convertedURI = getConvertedURI(uri);
		URIHandler handler = getDelegateHandler(convertedURI);
		return handler.createInputStream(convertedURI, options);
	}

	public OutputStream createOutputStream(URI uri, Map<?, ?> options) throws IOException {
		URI convertedURI = getConvertedURI(uri);
		URIHandler handler = getDelegateHandler(convertedURI);
		return handler.createOutputStream(convertedURI, options);
	}

	public void delete(URI uri, Map<?, ?> options) throws IOException {
		URI convertedURI = getConvertedURI(uri);
		URIHandler handler = getDelegateHandler(convertedURI);
		handler.delete(convertedURI, options);
	}

	public Map<String, ?> contentDescription(URI uri, Map<?, ?> options) throws IOException {
		URI convertedURI = getConvertedURI(uri);
		URIHandler handler = getDelegateHandler(convertedURI);
		return handler.contentDescription(convertedURI, options);
	}

	public boolean exists(URI uri, Map<?, ?> options) {
		URI convertedURI = getConvertedURI(uri);
		URIHandler handler = getDelegateHandler(convertedURI);
		return handler.exists(convertedURI, options);
	}

	public Map<String, ?> getAttributes(URI uri, Map<?, ?> options) {
		URI convertedURI = getConvertedURI(uri);
		URIHandler handler = getDelegateHandler(convertedURI);
		return handler.getAttributes(convertedURI, options);
	}

	public void setAttributes(URI uri, Map<String, ?> attributes, Map<?, ?> options) throws IOException {
		URI convertedURI = getConvertedURI(uri);
		URIHandler handler = getDelegateHandler(convertedURI);
		handler.setAttributes(convertedURI, attributes, options);
	}

	protected URIHandler getDelegateHandler(URI convertedURI) {
		for(URIHandler handler : URIHandler.DEFAULT_HANDLERS) {
			if(handler.canHandle(convertedURI)) {
				return handler;
			}
		}
		return null;
	}

	public URI getConvertedURI(URI sourceURI) {
		if(sourceURI == null) {
			throw new IllegalArgumentException("sourceURI shall not be null"); //$NON-NLS-1$
		}
		String firstSegment = sourceURI.segment(0);
		URI targetURI = URI.createURI(""); //$NON-NLS-1$
		if(firstSegment.equals(ENVIRONMENT_SEGMENT)) {
			for(int i = 1; i < sourceURI.segmentsList().size(); i++) {
				String segment = sourceURI.segmentsList().get(i);
				targetURI = targetURI.appendSegment(segment);
			}
		} else if(firstSegment.equals(CONTEXT_SEGMENT)) {
			for(int i = 1; i < sourceURI.segmentsList().size(); i++) {
				String segment = sourceURI.segmentsList().get(i);
				targetURI = targetURI.appendSegment(segment);
			}
		} else {
			throw new IllegalArgumentException(sourceURI + " is not a valid URI"); //$NON-NLS-1$
		}

		URI pluginURI = targetURI.resolve(URI.createURI("platform:/plugin/")); //$NON-NLS-1$

		if(!exists(pluginURI)) {
			URI workspaceURI = targetURI.resolve(URI.createURI("platform:/resource/")); //$NON-NLS-1$
			if(!exists(workspaceURI)) {
				URI preferenceURI = targetURI.resolve(URI.createFileURI(Activator.getDefault().getPreferencesPath().toString() + "/")); //$NON-NLS-1$
				if(!exists(preferenceURI)) {
					return null;
				}
				return preferenceURI;
			}
			return workspaceURI;
		}

		return pluginURI;
	}

	private boolean exists(URI uri) {
		for(URIHandler handler : DEFAULT_HANDLERS) {
			if(handler.canHandle(uri)) {
				return handler.exists(uri, Collections.EMPTY_MAP);
			}
		}
		return false;
	}

}
