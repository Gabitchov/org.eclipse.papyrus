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
package org.eclipse.papyrus.views.properties.catalog;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.papyrus.views.properties.Activator;

/**
 * A URI Handler for URIs with the ppe:/ scheme
 * 
 * @author Camille Letavernier
 */
public class PropertiesURIHandler implements URIHandler {

	/**
	 * The segment for environment models
	 */
	public static final String ENVIRONMENT_SEGMENT = "environment"; //$NON-NLS-1$

	/**
	 * The segment for context models
	 */
	public static final String CONTEXT_SEGMENT = "context"; //$NON-NLS-1$

	/**
	 * The handled URI scheme (ppe)
	 */
	public static final String PROPERTIES_SCHEME = "ppe"; //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 */
	public boolean canHandle(URI uri) {
		return uri != null && PROPERTIES_SCHEME.equals(uri.scheme());
	}

	/**
	 * {@inheritDoc}
	 */
	public InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException {
		URI convertedURI = getConvertedURI(uri);
		URIHandler handler = getDelegateHandler(convertedURI);
		return handler.createInputStream(convertedURI, options);
	}

	/**
	 * {@inheritDoc}
	 */
	public OutputStream createOutputStream(URI uri, Map<?, ?> options) throws IOException {
		URI convertedURI = getConvertedURI(uri);
		URIHandler handler = getDelegateHandler(convertedURI);
		return handler.createOutputStream(convertedURI, options);
	}

	/**
	 * {@inheritDoc}
	 */
	public void delete(URI uri, Map<?, ?> options) throws IOException {
		URI convertedURI = getConvertedURI(uri);
		URIHandler handler = getDelegateHandler(convertedURI);
		handler.delete(convertedURI, options);
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<String, ?> contentDescription(URI uri, Map<?, ?> options) throws IOException {
		URI convertedURI = getConvertedURI(uri);
		URIHandler handler = getDelegateHandler(convertedURI);
		return handler.contentDescription(convertedURI, options);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean exists(URI uri, Map<?, ?> options) {
		URI convertedURI = getConvertedURI(uri);
		URIHandler handler = getDelegateHandler(convertedURI);
		return handler.exists(convertedURI, options);
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<String, ?> getAttributes(URI uri, Map<?, ?> options) {
		URI convertedURI = getConvertedURI(uri);
		URIHandler handler = getDelegateHandler(convertedURI);
		return handler.getAttributes(convertedURI, options);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setAttributes(URI uri, Map<String, ?> attributes, Map<?, ?> options) throws IOException {
		URI convertedURI = getConvertedURI(uri);
		URIHandler handler = getDelegateHandler(convertedURI);
		handler.setAttributes(convertedURI, attributes, options);
	}

	/**
	 * Returns the URIHandler that can handle the given URI
	 * 
	 * @param convertedURI
	 *        The URI obtained after converting the ppe:/ URI to a standard URI
	 * @return
	 *         The URIHandler corresponding to the converted URI
	 */
	protected URIHandler getDelegateHandler(URI convertedURI) {
		if(convertedURI == null) {
			return null;
		}

		for(URIHandler handler : URIHandler.DEFAULT_HANDLERS) {
			if(handler.canHandle(convertedURI)) {
				return handler;
			}
		}
		return null;
	}

	/**
	 * Converts the ppe:/ URI to a standard URI
	 * 
	 * @param sourceURI
	 *        The ppe:/ URI to convert
	 * @return
	 *         The standard URI
	 */
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
