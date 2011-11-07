/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.documentation.view;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.views.documentation.IDocumentationChangedListener;
import org.eclipse.ui.IWorkbenchPart;


public class DocumentionPartHandlerRegistry {
	
	private static class DocumentionPartHandlerRegistryHolder {

		public static final DocumentionPartHandlerRegistry instance = new DocumentionPartHandlerRegistry();
	}

	public static DocumentionPartHandlerRegistry getInstance() {
		return DocumentionPartHandlerRegistryHolder.instance;
	}

	private static final String DOCUMENTATIONPARTHANDLER_EXTENSION_ID = "org.eclipse.papyrus.views.documentation.view.documentationPartHandler"; //$NON-NLS-1$

	private static final String DOCUMENTATIONPARTHANDLER_ID = "documentationPartHandler"; //$NON-NLS-1$
	
	
	private Set<IDocumentationPartHandler> documentationPartHandlers = new HashSet<IDocumentationPartHandler>();

	private Set<IDocumentationChangedListener> documentationChangedListeners = new HashSet<IDocumentationChangedListener>();
	
	private DocumentionPartHandlerRegistry() {
		initializeMap();
	}

	public IDocumentationPartHandler getDocumentationPartHandler(IWorkbenchPart part) {
		for (IDocumentationPartHandler documentationPartHandler : documentationPartHandlers) {
			if (documentationPartHandler.canHandlePart(part)) {
				return documentationPartHandler;
			}
		}
		return null;
	}
	
	private void initializeMap() {
		// Reading data from plugins
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(DOCUMENTATIONPARTHANDLER_EXTENSION_ID);
		for(int i = 0; i < configElements.length; i++) {
			initializeOne(configElements[i]);
		}
	}

	private void initializeOne(IConfigurationElement iConfigurationElement) {
		try {
			IDocumentationPartHandler documentationPartHandler = (IDocumentationPartHandler)iConfigurationElement.createExecutableExtension(DOCUMENTATIONPARTHANDLER_ID);
			documentationPartHandlers.add(documentationPartHandler);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void registerDocumentationChangedListener(IDocumentationChangedListener listener) {
		documentationChangedListeners.add(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	public void unregisterDocumentationChangedListener(IDocumentationChangedListener listener) {
		documentationChangedListeners.remove(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	public Set<IDocumentationChangedListener> getRegisteredDocumentationChangedListeners() {
		return documentationChangedListeners;
	}
}
