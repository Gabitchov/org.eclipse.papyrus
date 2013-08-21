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
package org.eclipse.papyrus.cdo.internal.ui.editors;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.core.editor.IPapyrusPageInput;
import org.eclipse.ui.IPersistableElement;

/**
 * This is the PapyrusCDOEditorInput type. Enjoy.
 */
public class PapyrusCDOEditorInput extends URIEditorInput {

	public PapyrusCDOEditorInput(URI uri) {
		this(uri, uri.trimFileExtension().lastSegment());
	}

	public PapyrusCDOEditorInput(URI uri, String name) {
		super(uri, name);
	}

	/**
	 * Editors on CDO resources cannot be re-opened without re-connecting the
	 * repository, so return {@code null}.
	 */
	@Override
	public IPersistableElement getPersistable() {
		return null;
	}
	
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		Object result;

		if(adapter == URI.class) {
			result = getURI();
		} else {
			result = super.getAdapter(adapter);
		}

		return result;
	}

	/**
	 * A specialization of the CDO editor input that supports specifying editor pages to open in addition.
	 */
	public static class PageInput extends PapyrusCDOEditorInput implements IPapyrusPageInput {

		private static final URI[] NO_URIS = {};

		private final URI[] pageURIs;

		private final boolean closeOtherPages;

		public PageInput(URI uri) {
			this(uri, NO_URIS, false);
		}

		public PageInput(URI uri, URI[] pageURIs, boolean closeOtherPages) {
			super(uri);

			this.pageURIs = pageURIs;
			this.closeOtherPages = closeOtherPages;
		}


		public URI[] getPages() {
			return pageURIs;
		}

		public boolean closeOtherPages() {
			return closeOtherPages;
		}

	}
}
