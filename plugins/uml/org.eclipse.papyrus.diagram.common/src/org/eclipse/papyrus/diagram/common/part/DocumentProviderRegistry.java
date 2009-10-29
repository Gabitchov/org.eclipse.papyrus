/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.part;

import java.util.HashMap;

import org.eclipse.papyrus.diagram.common.util.PathsUtil;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;

/**
 * A registry to store and get <CachedResourceDocumentProvider>s based on <EditingDomain>s and
 * <IEditorInput>s.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * 
 */
public class DocumentProviderRegistry extends HashMap<String, CachedResourcesDocumentProvider> {

	private static DocumentProviderRegistry instance = new DocumentProviderRegistry();

	public static DocumentProviderRegistry getInstance() {
		return instance;
	}

	private DocumentProviderRegistry() {
		return;
	}

	@Override
	public CachedResourcesDocumentProvider get(Object arg0) {
		throw new UnsupportedOperationException(
				"Operation not supported. Use #get(String domainID, IEditorInput input)");
	}

	// @unused
	public CachedResourcesDocumentProvider get(String domainID, IEditorInput input) {
		String key = calculateKey(domainID, input);
		if (containsKey(key)) {
			return super.get(key);
		} else {
			CachedResourcesDocumentProvider documentProvider = new CachedResourcesDocumentProvider(domainID);
			put(key, documentProvider);
			return documentProvider;
		}
	}

	private String calculateKey(String domainID, IEditorInput input) {
		String key = domainID;
		if (input instanceof FileEditorInput || input instanceof CachedResourcesEditorInput) {
			key += PathsUtil.getRelativeWorkspaceFromEditorInput(input);
		}
		return key;
	}

}
