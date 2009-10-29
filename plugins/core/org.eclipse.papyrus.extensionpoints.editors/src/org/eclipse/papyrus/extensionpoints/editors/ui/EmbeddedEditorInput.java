/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.extensionpoints.editors.ui;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

// @unused
public class EmbeddedEditorInput extends URIEditorInput {

	/** current edited EObject */
	private final EObject editedObject;

	/**
	 * Creates a new EmbeddedEditorInput.
	 * 
	 * @param uri
	 *            the uri of the file edited by the parent editor of the embedded editor
	 * @param editedObject
	 *            the current edited object
	 */
	public EmbeddedEditorInput(URI uri, EObject editedObject) {
		super(uri);
		this.editedObject = editedObject;
	}

	/**
	 * Returns the current edited object
	 * 
	 * @return the current edited object
	 */
	public EObject getEditedObject() {
		return editedObject;
	}
}
