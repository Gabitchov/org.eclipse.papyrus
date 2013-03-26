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
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.cdo.eresource.CDOTextResource;
import org.eclipse.emf.cdo.util.CDOURIUtil;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.cdo.view.CDOViewSet;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.URIHandlerImpl;


/**
 * A URI handler that loads XMI content from {@link CDOTextResource}s.
 */
public class CDOTextURIHandler extends URIHandlerImpl {

	public static final String SCHEME = "papyrus.cdo.text"; //$NON-NLS-1$

	private final ResourceSet resourceSet;

	protected CDOTextURIHandler(ResourceSet resourceSet) {
		super();

		this.resourceSet = resourceSet;
	}

	public static CDOTextURIHandler install(ResourceSet resourceSet) {
		CDOTextURIHandler result = new CDOTextURIHandler(resourceSet);

		// add to the front of the list because the last currently on the list is a catch-all
		resourceSet.getURIConverter().getURIHandlers().add(0, result);

		return result;
	}

	public static void uninstall(ResourceSet resourceSet) {
		for(Iterator<URIHandler> iter = resourceSet.getURIConverter().getURIHandlers().iterator(); iter.hasNext();) {
			if(iter.next() instanceof CDOTextURIHandler) {
				iter.remove();
			}
		}
	}

	public void uninstall() {
		resourceSet.getURIConverter().getURIHandlers().remove(this);
	}

	public static URI createURI(URI uri) {
		return URI.createHierarchicalURI(SCHEME, uri.authority(), uri.device(), uri.segments(), uri.query(), uri.fragment());
	}

	@Override
	public boolean canHandle(URI uri) {
		return SCHEME.equals(uri.scheme());
	}

	public static URI translate(URI uri) {
		return URI.createHierarchicalURI(CDOURIUtil.PROTOCOL_NAME, uri.authority(), uri.device(), uri.segments(), uri.query(), uri.fragment());
	}

	protected URIHandler getDelegateHandler(URI translatedURI) {
		return resourceSet.getURIConverter().getURIHandler(translatedURI);
	}

	public static CDOView getView(ResourceSet resourceSet, URI uri) {
		CDOView result = null;

		CDOViewSet viewSet = CDOUtil.getViewSet(resourceSet);
		if(viewSet != null) {
			if(SCHEME.equals(uri.scheme())) {
				uri = translate(uri);
			}

			result = viewSet.resolveView(CDOURIUtil.extractRepositoryUUID(uri));
		}

		return result;
	}

	protected CDOView getView(URI uri) {
		return getView(resourceSet, uri);
	}

	@Override
	public InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException {
		URI translated = translate(uri);
		CDOView view = getView(translated);
		if(view == null) {
			// try to delegate, but it probably won't work
			return getDelegateHandler(translated).createInputStream(translated, options);
		} else {
			try {
				CDOTextResource text = view.getTextResource(URI.decode(CDOURIUtil.extractResourcePath(translated)));
				return new ClobInputStream(text.getContents(), text.getEncoding());
			} catch (IOException e) {
				throw e;
			} catch (Exception e) {
				throw new IOException(e);
			}
		}
	}

	@Override
	public OutputStream createOutputStream(URI uri, Map<?, ?> options) throws IOException {
		URI translated = translate(uri);
		CDOView view = getView(translated);
		if(view == null) {
			// try to delegate, but it probably won't work
			return getDelegateHandler(translated).createOutputStream(translated, options);
		} else {
			ClobOutputStream clobOutput = null;

			try {
				CDOTextResource text = view.getTextResource(CDOURIUtil.extractResourcePath(translated));
				clobOutput = new ClobOutputStream(text);
			} catch (Exception e) {
				throw new IOException(e);
			}

			// returning here resolves resource-leak compiler warning
			return clobOutput;
		}
	}

	@Override
	public void delete(URI uri, Map<?, ?> options) throws IOException {
		URI translated = translate(uri);
		getDelegateHandler(translated).delete(translated, options);
	}

	@Override
	public boolean exists(URI uri, Map<?, ?> options) {
		URI translated = translate(uri);
		return getDelegateHandler(translated).exists(translated, options);
	}

	@Override
	public Map<String, ?> getAttributes(URI uri, Map<?, ?> options) {
		URI translated = translate(uri);
		return getDelegateHandler(translated).getAttributes(translated, options);
	}

	@Override
	public void setAttributes(URI uri, Map<String, ?> attributes, Map<?, ?> options) throws IOException {
		URI translated = translate(uri);
		getDelegateHandler(translated).setAttributes(translated, attributes, options);
	}

}
