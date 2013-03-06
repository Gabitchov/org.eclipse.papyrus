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
import org.eclipse.ui.IPersistableElement;

/**
 * This is the PapyrusCDOEditorInput type. Enjoy.
 */
public class PapyrusCDOEditorInput
		extends URIEditorInput {

	public PapyrusCDOEditorInput(URI uri) {
		super(uri);
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
}
